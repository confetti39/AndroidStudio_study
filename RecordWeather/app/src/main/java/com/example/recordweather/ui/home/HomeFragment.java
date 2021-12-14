package com.example.recordweather.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.recordweather.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    TextView tv_home_0h, tv_home_6h, tv_home_12h, tv_home_18h;
    TextView tv_home_0h_weather, tv_home_6h_weather, tv_home_12h_weather, tv_home_18h_weather;
    TextView tv_home_0h_temper, tv_home_6h_temper, tv_home_12h_temper, tv_home_18h_temper;
    TextView tv_home_0h_sensible, tv_home_6h_sensible, tv_home_12h_sensible, tv_home_18h_sensible;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        tv_home_0h = root.findViewById(R.id.tv_home_0h);
        tv_home_6h = root.findViewById(R.id.tv_home_0h);
        tv_home_12h = root.findViewById(R.id.tv_home_12h);
        tv_home_18h = root.findViewById(R.id.tv_home_18h);

        tv_home_0h_weather = root.findViewById(R.id.tv_home_0h_weather);
        tv_home_6h_weather = root.findViewById(R.id.tv_home_6h_weather);
        tv_home_12h_weather = root.findViewById(R.id.tv_home_12h_weather);
        tv_home_18h_weather = root.findViewById(R.id.tv_home_18h_weather);

        tv_home_0h_temper = root.findViewById(R.id.tv_home_0h_temper);
        tv_home_6h_temper = root.findViewById(R.id.tv_home_6h_temper);
        tv_home_12h_temper = root.findViewById(R.id.tv_home_12h_temper);
        tv_home_18h_temper = root.findViewById(R.id.tv_home_18h_temper);

        tv_home_0h_sensible = root.findViewById(R.id.tv_home_0h_sensible);
        tv_home_6h_sensible = root.findViewById(R.id.tv_home_6h_sensible);
        tv_home_12h_sensible = root.findViewById(R.id.tv_home_12h_sensible);
        tv_home_18h_sensible = root.findViewById(R.id.tv_home_18h_sensible);

//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}