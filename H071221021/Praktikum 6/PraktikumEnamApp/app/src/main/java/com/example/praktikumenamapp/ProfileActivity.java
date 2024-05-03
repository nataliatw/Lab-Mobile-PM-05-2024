package com.example.praktikumenamapp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {
    ImageView iv_foto;
    Button refreshBtn;
    TextView tv_name, tv_email, tv_titleError;
    ProgressBar pb;
    CardView cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        iv_foto = findViewById(R.id.iv_foto);
        tv_name = findViewById(R.id.tv_name);
        tv_email = findViewById(R.id.tv_email);
        cv = findViewById(R.id.cv);
        pb = findViewById(R.id.pb);
        refreshBtn = findViewById(R.id.refreshBtn);
        tv_titleError = findViewById(R.id.tv_titleError);

        calling();

        refreshBtn.setOnClickListener(v -> {
            pb.setVisibility(View.VISIBLE);
            tv_titleError.setVisibility(View.GONE);
            refreshBtn.setVisibility(View.GONE);
            calling();
        });
    }

    public void calling(){
        String id = getIntent().getStringExtra("id");

        tv_titleError.setVisibility(View.GONE);
        refreshBtn.setVisibility(View.GONE);
        cv.setVisibility(View.GONE);

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                Call<ProfileResponse> client = ApiConfig.getApiService().getUser(id);
                client.enqueue(new Callback<ProfileResponse>() {
                    @Override
                    public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                        if (response.isSuccessful()) {
                            if (response.body() != null) {
                                UserResponse userResponse = response.body().getData();

                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        tv_name.setText(userResponse.getFirstName() + userResponse.getLastName());
                                        tv_email.setText(userResponse.getEmail());
                                        Picasso.get().load(userResponse.getAvatarUrl()).into(iv_foto);

                                        pb.setVisibility(View.GONE);
                                        cv.setVisibility(View.VISIBLE);
                                    }
                                });
                            }
                        } else {
                            if (response.body() != null){
                                Log.e("MainActivity", "onFailure1: " + response.message());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ProfileResponse> call, Throwable t) {
                        pb.setVisibility(View.GONE);
                        tv_titleError.setVisibility(View.VISIBLE);
                        refreshBtn.setVisibility(View.VISIBLE);

                    }
                });
            }
        });
    }
}