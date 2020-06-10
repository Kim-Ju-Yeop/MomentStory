package appjam.hackathon.project.isaac.momentstory.network;


import appjam.hackathon.project.isaac.momentstory.network.service.MainService;
import appjam.hackathon.project.isaac.momentstory.network.service.PostService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetRetrofit {
    private static NetRetrofit ourInstance = new NetRetrofit();
    public static NetRetrofit getInstance() {
        return ourInstance;
    }

    private NetRetrofit() {

    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.211.115:3000/")
            .addConverterFactory(GsonConverterFactory.create()) // 파싱등록
            .build();

//    LoginService login = retrofit.create(LoginService.class);
//    public LoginService getLogin() {
//        return login;
//    }

    PostService post = retrofit.create(PostService.class);

    public PostService getPost() {
        return post;
    }

    MainService main = retrofit.create(MainService.class);

    public MainService getMain() {
        return main;
    }
}

