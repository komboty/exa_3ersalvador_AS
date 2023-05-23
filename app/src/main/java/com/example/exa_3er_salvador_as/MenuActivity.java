package com.example.exa_3er_salvador_as;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void irVideoActivity(View view) {
        Intent intent = new Intent(view.getContext(), VideoActivity.class);
        startActivity(intent);
    }

    public void irFormularioActivity(View view) {
        Intent intent = new Intent(view.getContext(), FormularioActivity.class);
        startActivity(intent);
    }

    public void irEmpleadosActivity(View view) {
        Intent intent = new Intent(view.getContext(), EmpleadosActivity.class);
        startActivity(intent);
    }
}