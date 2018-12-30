package com.fajaregafirmansyah.volumebalok;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.bumptech.glide.Glide;
import com.fajaregafirmansyah.volumebalok.databinding.ActivitySplashScreenBinding;

public class SplashScreenActivity extends AppCompatActivity {
    private ActivitySplashScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash_screen);
        //fungsi untuk membuat layar menjadi fullscreen tidak terlihat appbarnya
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //menambahkan gambar ke dalam variabel iconTengah
        Glide.with(this).load(R.mipmap.ic_volumebalok_circle).into(binding.iconTengah);

        //diatur waktu berjalannya di halaman splashscreen
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //perpindahan halaman
                startActivity(new Intent(getApplicationContext(), HitungVolumeActivity.class));
                finish();
            }
        }, 2000L); //1000L = 1 detik
    }
}
