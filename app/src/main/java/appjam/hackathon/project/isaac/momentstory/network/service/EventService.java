package appjam.hackathon.project.isaac.momentstory.network.service;

import appjam.hackathon.project.isaac.momentstory.network.Data;
import appjam.hackathon.project.isaac.momentstory.network.Response;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface EventService {

    @GET("/board")
    Call<Response<Data>> getEvent(@Header("Authorization")String token);
}
