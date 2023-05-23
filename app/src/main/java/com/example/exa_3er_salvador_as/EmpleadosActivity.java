package com.example.exa_3er_salvador_as;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class EmpleadosActivity extends AppCompatActivity {
    private ListView lvEmpleadosAS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empleados);

        lvEmpleadosAS = (ListView) findViewById(R.id.lvEmpleadosAS);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * from empleado", null);

        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No existen Empleados", Toast.LENGTH_LONG).show();
            return;
        }

        String textEmpleado = "";
        List<String> empleados = new ArrayList<>();
        cursor.moveToFirst();
        do {
            textEmpleado = "Numero: " + cursor.getString(0) + "\nNombre: " + cursor.getString(1) + "\nSueldo Final: $" + cursor.getString(4) + "\n";
            empleados.add(textEmpleado);
        } while (cursor.moveToNext());
        bd.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, empleados);
        lvEmpleadosAS.setAdapter(adapter);
    }
}