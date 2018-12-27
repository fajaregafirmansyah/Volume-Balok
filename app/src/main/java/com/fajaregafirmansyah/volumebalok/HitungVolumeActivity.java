package com.fajaregafirmansyah.volumebalok;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;

import com.fajaregafirmansyah.volumebalok.databinding.ActivityHitungVolumeBinding;

public class HitungVolumeActivity extends AppCompatActivity implements TextWatcher {
    private ActivityHitungVolumeBinding binding;
    String panjang, lebar, tinggi;

    private static final String STATE_RESULT = "state_result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_hitung_volume);

        binding.edtPanjang.addTextChangedListener(this);
        binding.edtLebar.addTextChangedListener(this);
        binding.edtTinggi.addTextChangedListener(this);

        cekValidasiForm();

        binding.btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double nilaipanjang = Double.parseDouble(panjang);
                double nilailebar = Double.parseDouble(lebar);
                double nilaitinggi = Double.parseDouble(tinggi);

                double volume = nilaipanjang * nilailebar * nilaitinggi;

                binding.tvHasil.setText(String.valueOf(volume));
            }
        });

        if(savedInstanceState != null){
            String result = savedInstanceState.getString(STATE_RESULT);
            binding.tvHasil.setText(result);
        }
    }

    @SuppressLint("ResourceAsColor")
    private void cekValidasiForm() {
        panjang = binding.edtPanjang.getText().toString();
        lebar = binding.edtLebar.getText().toString();
        tinggi = binding.edtTinggi.getText().toString();

        if (!TextUtils.isEmpty(panjang) && !TextUtils.isEmpty(lebar) && !TextUtils.isEmpty(tinggi)) {
            binding.btnHitung.setEnabled(true);
            binding.btnHitung.setTextColor(getResources().getColor(R.color.colorPrimary));
            binding.btnHitung.setBackgroundResource(R.drawable.btn_round_effect);
        } else {
            binding.btnHitung.setEnabled(false);
            binding.btnHitung.setTextColor(getResources().getColor(R.color.colorAccentDisable));
            binding.btnHitung.setBackgroundResource(R.drawable.disable_btn_round_effect);
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        cekValidasiForm();
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    Double toDouble(String str) {
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, binding.tvHasil.getText().toString());
    }
}
