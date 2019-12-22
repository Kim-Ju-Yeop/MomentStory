package appjam.hackathon.project.isaac.momentstory.network.service;

import java.util.ArrayList;

import appjam.hackathon.project.isaac.momentstory.network.Data;
import appjam.hackathon.project.isaac.momentstory.network.Response;
import appjam.hackathon.project.isaac.momentstory.network.response.PostRequest;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface PostService {


    @Multipart
    @POST("/board")
    Call<Response<Data>> boardPost(@Header("Authorization")String token,
                                   @Part ArrayList<MultipartBody.Part> img,
                                   @Part("img") RequestBody name,
                                   @Part("title") RequestBody title,
                                   @Part("description") RequestBody description,
                                   @Part("goalTime") RequestBody goalTime);
}
