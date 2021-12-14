package com.example.recordweather.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.recordweather.R;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    ImageButton ib_add_check;
    TextView tv_add_time, tv_add_weather, tv_add_temper, tv_add_sensible;
    EditText et_add_outer, et_add_top, et_add_bottom, et_add_memo;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        ib_add_check = (ImageButton)root.findViewById(R.id.ib_add_check);
        tv_add_time = (TextView)root.findViewById(R.id.tv_add_time);
        tv_add_weather = (TextView)root.findViewById(R.id.tv_add_weather);
        tv_add_temper = (TextView)root.findViewById(R.id.tv_add_temper);
        tv_add_sensible = (TextView)root.findViewById(R.id.tv_add_sensible);
        et_add_outer = (EditText)root.findViewById(R.id.et_add_outer);
        et_add_top = (EditText)root.findViewById(R.id.et_add_top);
        et_add_bottom = (EditText)root.findViewById(R.id.et_add_bottom);
        et_add_memo = (EditText)root.findViewById(R.id.et_add_memo);

//        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}