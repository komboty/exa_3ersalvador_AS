package com.example.exa_3er_salvador_as;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etPassAS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPassAS = findViewById(R.id.etPassAS);
    }

    public void login(View view) {
        // Si la contraseña no es uacm123
        if (!etPassAS.getText().toString().equals("uacm123")) {
            Toast.makeText(MainActivity.this, "La contraseña es uacm123", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(view.getContext(), MenuActivity.class);
        startActivity(intent);
    }
}