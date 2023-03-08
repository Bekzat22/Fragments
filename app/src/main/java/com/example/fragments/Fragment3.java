package com.example.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class Fragment3 extends Fragment {


    AppCompatButton btn;
    EditText name,password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        name=view.findViewById(R.id.name);
        name.setText("admin");
        password=view.findViewById(R.id.password);
        password.setText("admin");
        btn=view.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hhh=name.getText().toString();
                String ggg=password.getText().toString();
                if (hhh.equals("admin")&&ggg.equals("admin")){
                    FragmentManager fm = getActivity().getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.container2, new Fragment1());
                    fm.popBackStack(R.id.fragment1, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    ft.commit();
                }else if (!hhh.equals("admin") || !ggg.equals("admin")) {
                    name.setError("incorrect");
                    password.setError("incorrect");
                }
            }
        });
    }
}