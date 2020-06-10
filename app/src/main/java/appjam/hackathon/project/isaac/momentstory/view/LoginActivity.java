package appjam.hackathon.project.isaac.momentstory.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import appjam.hackathon.project.isaac.momentstory.R;

public class LoginActivity extends AppCompatActivity {

    EditText text_id;
    EditText text_pw;
    ConstraintLayout layout;
    CardView cardView;
    TextView textView;

    SharedPreferences loginData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        text_id = findViewById(R.id.id_text);
        text_pw = findViewById(R.id.password_text);
        layout = findViewById(R.id.login_container);
        cardView = findViewById(R.id.cardView1);
        textView = findViewById(R.id.textView11);

        loginData = getSharedPreferences("Login", MODE_PRIVATE);
    }

    public void checkFirstRun() {
        boolean isFirstRun = loginData.getBoolean("isFirstRun", true);
        if (isFirstRun) {
            layout.setVisibility(View.GONE);

            cardView.setVisibility(View.VISIBLE);
            textView.setVisibility(View.VISIBLE);
        } else {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }
    }

    public void login(View view) {
        String a = text_id.getText().toString();
        String b = text_pw.getText().toString();
        if (a.equals(b)) {
            checkFirstRun();
        } else {
            Toast.makeText(this, "일치하는 회원정보가 없습니다.", Toast.LENGTH_SHORT).show();
        }
    }

    public void settingTime(View view) {
        loginData.edit().putBoolean("isFirstRun", false).apply();
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        ActivityCompat.finishAffinity(this);
    }
}
