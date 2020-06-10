package appjam.hackathon.project.isaac.momentstory.view;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
        import androidx.databinding.DataBindingUtil;
        import androidx.lifecycle.ViewModel;
        import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.Manifest;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

import appjam.hackathon.project.isaac.momentstory.R;
        import appjam.hackathon.project.isaac.momentstory.databinding.ActivityPostBinding;
import appjam.hackathon.project.isaac.momentstory.network.Data;
import appjam.hackathon.project.isaac.momentstory.network.NetRetrofit;
import appjam.hackathon.project.isaac.momentstory.network.Response;
import appjam.hackathon.project.isaac.momentstory.network.response.PostRequest;
import appjam.hackathon.project.isaac.momentstory.viewmodel.PostViewModel;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

public class PostActivity extends AppCompatActivity {

    ActivityPostBinding binding;
    PostViewModel postViewmodel;

    // startActivityForResult Answer
    private static final int PICK_FROM_ALBUM = 1;
    private File tempFile;

    // View
    ArrayList<MultipartBody.Part> imageList = new ArrayList<>();
    RequestBody fileNameBody;

    // Upload Album
    private String fileExt;
    private String fileType;
    private String uploadName;

    // Request
    PostRequest postRequest = new PostRequest();

    // SimpleDateFormat
    Date today = new Date();
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd");

    // RecyclerView
    LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_post);
        postViewmodel = ViewModelProviders.of(this).get(PostViewModel.class);

        binding.setLifecycleOwner(this);
        binding.setViewModel(postViewmodel);

        binding.textView6.setText(sdf1.format(today));
        binding.recyclerView.setLayoutManager(layoutManager);
    }

    // 권한 체크 매서드
    public void tedPermission(View view){
        PermissionListener permissionListener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                goToAlbum();
            }
            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
            }
        };

        TedPermission.with(this)
                .setPermissionListener(permissionListener)
                .setRationaleMessage(R.string.rationale)
                .setDeniedMessage(R.string.denied)
                .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA)
                .check();
    }

    // 갤러리 접근 호출
    public void goToAlbum(){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
        startActivityForResult(intent, PICK_FROM_ALBUM);
    }

    // 갤러리 접근 실행
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_FROM_ALBUM){

                Uri photoUri;
                int column_index;
                Cursor cursor = null;

                try {
                    // 갤러리에서 선택된 이미지의 Uri 값을 저장한다.
                    photoUri = data.getData();
                } catch (NullPointerException e) {
                    photoUri = null;
                }

                Log.e("TAG", "PICK_FROM_ALBUM photoUri : " + photoUri);

                try {
                    String[] proj = {MediaStore.Images.Media.DATA};

                    // assert 예약어는 boolean 예약어와 같다.
                    assert photoUri != null;
                    cursor = PostActivity.this.getContentResolver().query(photoUri, proj, null, null, null);

                    // assert 예약어는 boolean 예약어와 같다.
                    assert cursor != null;
                    column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

                    cursor.moveToFirst();
                    tempFile = new File(cursor.getString(column_index));
                } catch (NullPointerException e) {

                } finally {
                    if(cursor != null){
                        cursor.close();
                    }
                }
                try {
                    setImage();
                } catch (NullPointerException e) {

                }
        }
    }

    // 이미지 설정
    public void setImage(){
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap originalBm = BitmapFactory.decodeFile(tempFile.getAbsolutePath(), options);

        uploadProfile(changeToBytes(), tempFile.getName());
    }

    // 이미지파일을 비트로 바꿉니다
    private byte[] changeToBytes() {

        int size = (int) tempFile.length();
        byte[] bytes = new byte[size];
        try {
            BufferedInputStream buf = new BufferedInputStream(new FileInputStream(tempFile));
            buf.read(bytes, 0, bytes.length);
            buf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    // Profile Upload
    public void uploadProfile(byte[] imageBytes, String originalName){

        String[] filenameArray = originalName.split("\\.");
        String extension = filenameArray[filenameArray.length -1];

        fileType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
        fileExt = "." + extension;

        uploadName = Integer.toString(new Random().nextInt(999999999));

        RequestBody requestFile = RequestBody.create(MediaType.parse(Objects.requireNonNull(fileType)), imageBytes);

        MultipartBody.Part body = MultipartBody.Part.createFormData("img", uploadName + fileExt, requestFile);
        fileNameBody = RequestBody.create(MediaType.parse("text/plain"), uploadName);

        imageList.add(body);
    }

    public void upload(View view){

        postRequest.setTitle(binding.editText.getText().toString());
        postRequest.setDescription(binding.editText4.getText().toString());
        postRequest.setGoalTime(binding.editText2.getText().toString() + ":" + binding.editText3.getText().toString() + ":" + "00");

        String token = "bearer eyJhbGciOiJIUzI1NiJ9.YWRtaW4.1OR5ifDCi1UIivGQLh_sEcybZqeGnMAcznaAXBGPEy0";

        Log.e("test", postRequest.getTitle());

        RequestBody sendTitle = RequestBody.create(MediaType.parse("text/plain"),postRequest.getTitle());
        RequestBody sendDescription = RequestBody.create(MediaType.parse("text/plain"),postRequest.getDescription());
        RequestBody sendGoalTime = RequestBody.create(MediaType.parse("text/plain"),postRequest.getGoalTime());

        Call<Response<Data>> res  = NetRetrofit.getInstance().getPost().boardPost(token,imageList,fileNameBody,sendTitle,sendDescription,sendGoalTime);
        res.enqueue(new Callback<Response<Data>>() {
            @Override
            public void onResponse(Call<Response<Data>> call, retrofit2.Response<Response<Data>> response) {
                if(response.code() == 200){
                    Log.e("200", "서버 통신 성공하였습니다.");
                }
            }
            @Override
            public void onFailure(Call<Response<Data>> call, Throwable t) {
                Log.e("onFailure", "서버 통신을 실패하였습니다.");
            }
        });
    }
}
