package com.example.praktikumenamapp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    TextView tv_titleError;
    ProgressBar pb;
    Button refreshBtn;
    Button loadMoreBtn;
    AdapterUsers adapterUsers;
    int currentPage = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);
        tv_titleError = findViewById(R.id.tv_titleError);
        pb = findViewById(R.id.pb);
        refreshBtn = findViewById(R.id.refreshBtn);
        loadMoreBtn = findViewById(R.id.loadMoreBtn);

        adapterUsers = new AdapterUsers(new ArrayList<>());
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapterUsers);

        calling();

        loadMoreBtn.setOnClickListener(v -> {
            currentPage++;
            loadMore();
        });
    }

    public void calling() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        tv_titleError.setVisibility(View.GONE);
        refreshBtn.setVisibility(View.GONE);
        pb.setVisibility(View.VISIBLE);
        loadMoreBtn.setVisibility(View.GONE);

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                Call<DataResponse> client = ApiConfig.getApiService().getData(String.valueOf(currentPage));
                client.enqueue(new Callback<DataResponse>() {
                    @Override
                    public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                        if (response.isSuccessful()) {
                            if (response.body() != null) {
                                ArrayList<UserResponse> userResponses = response.body().getData();
                                adapterUsers.addData(userResponses);
                                pb.setVisibility(View.GONE);
                                loadMoreBtn.setVisibility(View.VISIBLE);
                            }
                        } else {
                            if (response.body() != null) {
                                Log.e("MainActivity", "onFailure: " + response.message());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<DataResponse> call, Throwable t) {
                        pb.setVisibility(View.GONE);
                        tv_titleError.setVisibility(View.VISIBLE);
                        refreshBtn.setVisibility(View.VISIBLE);
                        rv.setVisibility(View.GONE);

                        refreshBtn.setOnClickListener(v -> {
                            pb.setVisibility(View.VISIBLE);
                            tv_titleError.setVisibility(View.GONE);
                            refreshBtn.setVisibility(View.GONE);
                            rv.setVisibility(View.VISIBLE);
                            calling();
                        });
                    }
                });
            }
        });
    }

    private void loadMore() {

        calling();
    }
}