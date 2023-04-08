package com.example.lab02_20521846;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.DecimalFormat;
import java.util.List;

public class AdapterEmployee extends ArrayAdapter<Employee> {
    Activity context;
    int resource;
    List<Employee> objects;
    public AdapterEmployee(@NonNull Activity context, int resource, List<Employee> objects) {
        super(context, resource, objects);

        this.objects = objects;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View row, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        row = layoutInflater.inflate(this.resource, null);

        TextView fullname = row.findViewById(R.id.v_e_fullname);
        TextView salary = row.findViewById(R.id.v_e_salary);

        Employee emp = this.objects.get(position);
        fullname.setText(emp.getFullName());
        salary.setText(" - Net Salary:    " + String.valueOf(DecimalFormat.getInstance().format(emp.calcSalary())));

        return row;
    }
}
