package com.example.exa_3er_salvador_as;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FormularioActivity extends AppCompatActivity {

    private EditText etNumeroAS;
    private EditText etNombreAS;
    private EditText etPuestoAS;
    private EditText etDiasAS;
    private EditText etSueldoInicialAS;
    private TextView tvSueldoFinalAS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        etNumeroAS = findViewById(R.id.etNumeroAS);
        etNombreAS = findViewById(R.id.etNombreAS);
        etPuestoAS = findViewById(R.id.etPuestoAS);
        etDiasAS = findViewById(R.id.etDiasAS);
        etSueldoInicialAS = findViewById(R.id.etSueldoInicialAS);
        tvSueldoFinalAS = findViewById(R.id.tvSueldoFinalAS);
    }

    public void calcularSueldo(View view) {
        int diasAS = Integer.parseInt(etDiasAS.getText().toString());
        int sueldoInicialAS = Integer.parseInt(etSueldoInicialAS.getText().toString());
        double bonoAS = sueldoInicialAS * 0.15;
        double sueldoFinalAS = diasAS > 15 ? sueldoInicialAS + bonoAS : sueldoInicialAS;
        tvSueldoFinalAS.setText("" + sueldoFinalAS);
    }

    public void guardarEmpleado(View view) {
        calcularSueldo(view);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String numero = etNumeroAS.getText().toString();
        String nombre = etNombreAS.getText().toString();
        String puesto = etPuestoAS.getText().toString();
        String dias = etDiasAS.getText().toString();
        String sueldoFinal = tvSueldoFinalAS.getText().toString();

        ContentValues registro = new ContentValues();
        registro.put("id", numero);
        registro.put("nombre", nombre);
        registro.put("puesto", puesto);
        registro.put("dias", dias);
        registro.put("sueldoFinal", sueldoFinal);

        bd.insert("empleado", null, registro);
        bd.close();

        etNumeroAS.setText(null);
        etNombreAS.setText(null);
        etPuestoAS.setText(null);
        etDiasAS.setText(null);
        etSueldoInicialAS.setText(null);
        tvSueldoFinalAS.setText("0");

        Toast.makeText(this, "Exito al guardar el empleado con sueldo final: " + sueldoFinal, Toast.LENGTH_LONG).show();
    }
}