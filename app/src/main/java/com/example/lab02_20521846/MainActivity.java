package com.example.lab02_20521846;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvEmp;
    ArrayList<Employee> listEmp = new ArrayList<>();
    AdapterEmployee adtEmp;
    Button calc;
    EditText fullname;
    EditText salary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvent();
    }

    private void addEvent() {
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listEmp.add(new Employee(fullname.getText().toString(), Double.parseDouble(salary.getText().toString())));
                adtEmp.notifyDataSetChanged();
            }
        });
    }

    private void addControls() {
        fullname = findViewById(R.id.a_m_fullname);
        salary = findViewById(R.id.a_m_salary);
        calc = findViewById(R.id.buttonCalc);
        lvEmp = (ListView) findViewById(R.id.lvEmp);

        adtEmp = new AdapterEmployee(MainActivity.this,
                R.layout.view_employee, listEmp);
        lvEmp.setAdapter(adtEmp);
    }
}