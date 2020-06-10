package appjam.hackathon.project.isaac.momentstory.view.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import appjam.hackathon.project.isaac.momentstory.R;
import appjam.hackathon.project.isaac.momentstory.view.Date;
import appjam.hackathon.project.isaac.momentstory.view.DateAdapter;
import appjam.hackathon.project.isaac.momentstory.view.PostActivity;


public class fragment2 extends Fragment {

    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_fragment2, container, false);

        recyclerView = rootView.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);

        DateAdapter adapter = new DateAdapter();

        adapter.addItems(new Date("SUN", "01"));
        adapter.addItems(new Date("MON", "02"));
        adapter.addItems(new Date("TUE", "03"));
        adapter.addItems(new Date("WED", "04"));
        adapter.addItems(new Date("THU", "05"));
        adapter.addItems(new Date("FRI", "06"));
        adapter.addItems(new Date("SAT", "07"));
        adapter.addItems(new Date("SUN", "08"));
        adapter.addItems(new Date("MON", "09"));
        adapter.addItems(new Date("TUE", "10"));
        adapter.addItems(new Date("WED", "11"));
        adapter.addItems(new Date("THU", "12"));
        adapter.addItems(new Date("FRI", "13"));
        adapter.addItems(new Date("SAT", "14"));
        adapter.addItems(new Date("SUN", "15"));
        adapter.addItems(new Date("MON", "16"));
        adapter.addItems(new Date("TUE", "17"));
        adapter.addItems(new Date("WED", "18"));
        adapter.addItems(new Date("THU", "19"));
        adapter.addItems(new Date("FRI", "20"));
        adapter.addItems(new Date("SAT", "21"));
        adapter.addItems(new Date("SUN", "22"));
        adapter.addItems(new Date("MON", "23"));
        adapter.addItems(new Date("TUE", "24"));
        adapter.addItems(new Date("WED", "25"));
        adapter.addItems(new Date("THU", "26"));
        adapter.addItems(new Date("FRI", "27"));
        adapter.addItems(new Date("SAT", "28"));
        adapter.addItems(new Date("SUN", "29"));
        adapter.addItems(new Date("MON", "30"));
        adapter.addItems(new Date("TUE", "31"));

        recyclerView.setAdapter(adapter);

        ImageView imageView = rootView.findViewById(R.id.imageView4);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PostActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }

}
