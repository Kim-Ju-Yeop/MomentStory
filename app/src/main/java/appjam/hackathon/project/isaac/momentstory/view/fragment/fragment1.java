package appjam.hackathon.project.isaac.momentstory.view.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import appjam.hackathon.project.isaac.momentstory.R;
import appjam.hackathon.project.isaac.momentstory.network.Data;
import appjam.hackathon.project.isaac.momentstory.network.NetRetrofit;
import appjam.hackathon.project.isaac.momentstory.network.Response;
import retrofit2.Call;
import retrofit2.Callback;

public class fragment1 extends Fragment {


    public fragment1() {
        // Required empty public constructor
    }

    public String withTime_H;
    public String withTime_M;
    public String goalTime_H;
    public String goalTime_M;

    TextView wh;
    TextView wm;
    TextView gh;
    TextView gm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.fragment_fragment1, container, false);


        wh = v.findViewById(R.id.with_h);
        wm = v.findViewById(R.id.with_mh);
        gh = v.findViewById(R.id.goal_h);
        gm = v.findViewById(R.id.goal_m);

        getWithTime_H();
        return inflater.inflate(R.layout.fragment_fragment1, container, false);
    }

    public void getWithTime_H() {

        String token = "bearer eyJhbGciOiJIUzI1NiJ9.YWRtaW4.1OR5ifDCi1UIivGQLh_sEcybZqeGnMAcznaAXBGPEy0";

        Call<Response<Data>> res = NetRetrofit.getInstance().getMain().getUser(token);
        res.enqueue(new Callback<Response<Data>>() {
            @Override
            public void onResponse(Call<Response<Data>> call, retrofit2.Response<Response<Data>> response) {

                if (response.code() == 200) {
                    wh.setText(response.body().getData().getTogether_time().substring(0, 2));
                    wm.setText(response.body().getData().getTogether_time().substring(3, 5));
                    gh.setText(response.body().getData().getGoal_time().substring(0, 2));
                    gm.setText(response.body().getData().getGoal_time().substring(3, 5));
                }
            }

            @Override
            public void onFailure(Call<Response<Data>> call, Throwable t) {
                Log.e("PartMain", "ERROR");
            }
        });
    }

}
