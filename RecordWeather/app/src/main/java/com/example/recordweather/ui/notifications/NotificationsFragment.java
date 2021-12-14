package com.example.recordweather.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.recordweather.R;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    TextView tv_temper_err, tv_temper_errPicker;
    Button btn_temper_minus, btn_temper_plus;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        tv_temper_err = (TextView)root.findViewById(R.id.tv_temper_err);
        tv_temper_errPicker = (TextView)root.findViewById(R.id.tv_temper_errPicker);
        btn_temper_minus = (Button)root.findViewById(R.id.btn_temper_minus);
        btn_temper_plus = (Button)root.findViewById(R.id.btn_temper_plus);

//        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}