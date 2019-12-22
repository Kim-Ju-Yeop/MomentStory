package appjam.hackathon.project.isaac.momentstory.network.service;

import java.util.ArrayList;

import appjam.hackathon.project.isaac.momentstory.network.Data;
import appjam.hackathon.project.isaac.momentstory.network.Response;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface MainService {

    @POST("/user/profile")
    Call<Response<Data>> getProfile(@Header("Authorization") String token);

    @GET("/user")
    Call<Response<Data>> getUser(@Header("Authorization") String token);
}
