package appjam.hackathon.project.isaac.momentstory.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import appjam.hackathon.project.isaac.momentstory.R;
import appjam.hackathon.project.isaac.momentstory.databinding.ActivityMainBinding;
import appjam.hackathon.project.isaac.momentstory.view.fragment.fragment1;
import appjam.hackathon.project.isaac.momentstory.view.fragment.fragment2;
import appjam.hackathon.project.isaac.momentstory.view.fragment.fragment3;
import appjam.hackathon.project.isaac.momentstory.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel;
    ActivityMainBinding binding;

    private FragmentManager fragmentManager = getSupportFragmentManager();

    // 3개의 메뉴에 들어갈 Fragment
    private fragment1 menu1Fragment = new fragment1();
    private fragment2 menu2Fragment = new fragment2();
    private fragment3 menu3Fragment = new fragment3();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(mainViewModel);

        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.layout, menu1Fragment);
        fragmentTransaction.commit();

        binding.bottomNavigationViewMainMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                switch (item.getItemId()) {
                    case R.id.action_one:
                        fragmentTransaction.replace(R.id.layout, menu1Fragment);
                        fragmentTransaction.commit();
                        return true;
                    case R.id.action_two:
                        fragmentTransaction.replace(R.id.layout, menu2Fragment);
                        fragmentTransaction.commit();
                        return true;
                    case R.id.action_three:
                        fragmentTransaction.replace(R.id.layout, menu3Fragment);
                        fragmentTransaction.commit();
                        return true;
                }
                return false;
            }
        });
    }

    public void click(View view){
        Intent intent = new Intent(this, PostActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        ActivityCompat.finishAffinity(this);
    }
}
