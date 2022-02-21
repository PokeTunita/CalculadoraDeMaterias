package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Materias extends AppCompatActivity {
    EditText mat1, mat2, mat3, mat4, mat5, mat6, mat7, mat8, mat9, mat10;
    TextView  parcial;
    Button detalles;
    public ArrayList<Integer> calpri = new ArrayList<Integer>()  ;
    public ArrayList<Integer> calseg  = new ArrayList<Integer>();
    public ArrayList<Integer> calter = new ArrayList<Integer>();
    int par = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materias);
        mat1 = findViewById(R.id.mat1);
        mat2 = findViewById(R.id.mat2);
        mat3 = findViewById(R.id.mat3);
        mat4 = findViewById(R.id.mat4);
        mat5 = findViewById(R.id.mat5);
        mat6 = findViewById(R.id.mat6);
        mat7 = findViewById(R.id.mat7);
        mat8 = findViewById(R.id.mat8);
        mat9 = findViewById(R.id.mat9);
        mat10 = findViewById(R.id.mat10);
        parcial = findViewById(R.id.parcial);
        detalles = findViewById(R.id.detalles);

        detalles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seguir();
            }
        });

        par = getIntent().getIntExtra("parcial", 1);
        if(par == 1){
            parcial.setText("Primer Parcial");
        }else if(par == 2){
            parcial.setText("Segundo Parcial");
        }else{
            parcial.setText("Tercer Parcial");
        }
        if(getIntent().getIntegerArrayListExtra("primer") != null){
            calpri = getIntent().getIntegerArrayListExtra("primer");
        }else{
            primerp();
        }

        if(getIntent().getIntegerArrayListExtra("segundo") != null){
            calseg = getIntent().getIntegerArrayListExtra("segundo");
        }else{
            segundop();
        }

        if(getIntent().getIntegerArrayListExtra("tercero") != null){
            calter = getIntent().getIntegerArrayListExtra("tercero");
        }else{
            tercerp();
        }


        enviar();
    }

    private void seguir(){
        int cal1, cal2, cal3, cal4, cal5, cal6, cal7, cal8, cal9, cal10;
        cal1 = Integer.valueOf(String.valueOf(mat1.getText()));
        cal2 = Integer.valueOf(String.valueOf(mat2.getText()));
        cal3 = Integer.valueOf(String.valueOf(mat3.getText()));
        cal4 = Integer.valueOf(String.valueOf(mat4.getText()));
        cal5 = Integer.valueOf(String.valueOf(mat5.getText()));
        cal6 = Integer.valueOf(String.valueOf(mat6.getText()));
        cal7 = Integer.valueOf(String.valueOf(mat7.getText()));
        cal8 = Integer.valueOf(String.valueOf(mat8.getText()));
        cal9 = Integer.valueOf(String.valueOf(mat9.getText()));
        cal10 = Integer.valueOf(String.valueOf(mat10.getText()));
        boolean seguirr = true;

        if(cal1 < 0 || cal1 > 10){
            seguirr = false;
        }else if(cal2 < 0 || cal2 > 10){
            seguirr = false;
        }else if(cal3 < 0 || cal3 > 10){
            seguirr = false;
        }else if(cal4 < 0 || cal4 > 10){
            seguirr = false;
        }else if(cal5 < 0 || cal5 > 10){
            seguirr = false;
        }else if(cal6 < 0 || cal6 > 10){
            seguirr = false;
        }else if(cal7 < 0 || cal7 > 10){
            seguirr = false;
        }else if(cal8 < 0 || cal8 > 10){
            seguirr = false;
        }else if(cal9 < 0 || cal9 > 10){
            seguirr = false;
        }else if(cal10 < 0 || cal10 > 10){
            seguirr = false;
        }
        if(seguirr){
            detalles(cal1, cal2, cal3, cal4, cal5, cal6, cal7, cal8, cal9, cal10);
        }else{
            Toast.makeText(this, "Algunas Calificaciones son invalidas",Toast.LENGTH_SHORT).show();
        }


    }


    private void primerp(){
        calpri = new ArrayList<Integer>();
        for(int i=0; i<10; i++){
            calpri.add(0);
        }
    }

    private void segundop(){
        calseg = new ArrayList<Integer>();
        for(int i=0; i<10; i++){
            calseg.add(0);
        }
    }

    private void tercerp(){
        calter = new ArrayList<Integer>();
        for(int i=0; i<10; i++){
            calter.add(0);
        }
    }

    private void enviar (){
        if(par == 1){
            mat1.setText(String.valueOf(calpri.get(0)));
            mat2.setText(String.valueOf(calpri.get(1)));
            mat3.setText(String.valueOf(calpri.get(2)));
            mat4.setText(String.valueOf(calpri.get(3)));
            mat5.setText(String.valueOf(calpri.get(4)));
            mat6.setText(String.valueOf(calpri.get(5)));
            mat7.setText(String.valueOf(calpri.get(6)));
            mat8.setText(String.valueOf(calpri.get(7)));
            mat9.setText(String.valueOf(calpri.get(8)));
            mat10.setText(String.valueOf(calpri.get(9)));
        }
        if(par == 2){
            mat1.setText(String.valueOf(calseg.get(0)));
            mat2.setText(String.valueOf(calseg.get(1)));
            mat3.setText(String.valueOf(calseg.get(2)));
            mat4.setText(String.valueOf(calseg.get(3)));
            mat5.setText(String.valueOf(calseg.get(4)));
            mat6.setText(String.valueOf(calseg.get(5)));
            mat7.setText(String.valueOf(calseg.get(6)));
            mat8.setText(String.valueOf(calseg.get(7)));
            mat9.setText(String.valueOf(calseg.get(8)));
            mat10.setText(String.valueOf(calseg.get(9)));
        }
        if(par == 3){
            mat1.setText(String.valueOf(calter.get(0)));
            mat2.setText(String.valueOf(calter.get(1)));
            mat3.setText(String.valueOf(calter.get(2)));
            mat4.setText(String.valueOf(calter.get(3)));
            mat5.setText(String.valueOf(calter.get(4)));
            mat6.setText(String.valueOf(calter.get(5)));
            mat7.setText(String.valueOf(calter.get(6)));
            mat8.setText(String.valueOf(calter.get(7)));
            mat9.setText(String.valueOf(calter.get(8)));
            mat10.setText(String.valueOf(calter.get(9)));
        }
    }

    private void detalles(int m1, int m2,int m3,int m4,int m5,int m6,int m7,int m8,int m9,int m10){
        if(par == 1){
            calpri.clear();
            calpri.add(m1);
            calpri.add(m2);
            calpri.add(m3);
            calpri.add(m4);
            calpri.add(m5);
            calpri.add(m6);
            calpri.add(m7);
            calpri.add(m8);
            calpri.add(m9);
            calpri.add(m10);

        } else if(par == 2){
            calseg.clear();
            calseg.add(m1);
            calseg.add(m2);
            calseg.add(m3);
            calseg.add(m4);
            calseg.add(m5);
            calseg.add(m6);
            calseg.add(m7);
            calseg.add(m8);
            calseg.add(m9);
            calseg.add(m10);
        }else if(par == 3){
            calter.clear();
            calter.add(m1);
            calter.add(m2);
            calter.add(m3);
            calter.add(m4);
            calter.add(m5);
            calter.add(m6);
            calter.add(m7);
            calter.add(m8);
            calter.add(m9);
            calter.add(m10);
        }

        Intent i = new Intent(this, Detalles.class);
        i.putExtra("parcial", par);
        i.putIntegerArrayListExtra("primer", calpri);
        i.putIntegerArrayListExtra("segundo",  calseg);
        i.putIntegerArrayListExtra("tercer",  calter);
        startActivity(i);

    }

}