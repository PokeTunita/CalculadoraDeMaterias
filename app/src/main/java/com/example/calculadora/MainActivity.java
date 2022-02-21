package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button primer, segundo, tercer, semestre;
    public static ArrayList<Integer> calpri;
    public static ArrayList<Integer> calseg;
    public static ArrayList<Integer> calter;
    Boolean pri = false, seg = false, ter = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        primer = findViewById(R.id.primer);
        segundo = findViewById(R.id.segundo);
        tercer = findViewById(R.id.tercer);
        semestre = findViewById(R.id.semestre);


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

        primer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calipri();
            }
        });

        segundo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Segupri();
            }
        });

        tercer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tercerpri();
            }
        });

        semestre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Semestre();
            }
        });


    }

    public void Calipri(){
        Intent i = new Intent(this, Materias.class);
        i.putExtra("parcial", 1);
        i.putIntegerArrayListExtra("primer", calpri);
        i.putIntegerArrayListExtra("segundo",  calseg);
        i.putIntegerArrayListExtra("tercer",  calter);
        startActivity(i);
    }

    public void Segupri(){
        Intent i = new Intent(this, Materias.class);
        i.putExtra("parcial", 2);
        i.putIntegerArrayListExtra("primer", calpri);
        i.putIntegerArrayListExtra("segundo",  calseg);
        i.putIntegerArrayListExtra("tercer",  calter);
        startActivity(i);
    }

    public void Tercerpri(){
        Intent i = new Intent(this, Materias.class);
        i.putExtra("parcial", 3);
        i.putIntegerArrayListExtra("primer", calpri);
        i.putIntegerArrayListExtra("segundo",  calseg);
        i.putIntegerArrayListExtra("tercer",  calter);
        startActivity(i);
    }

    public void Semestre(){
        Intent i = new Intent(this, Detalles.class);
        i.putExtra("parcial", 4);
        i.putIntegerArrayListExtra("primer", calpri);
        i.putIntegerArrayListExtra("segundo",  calseg);
        i.putIntegerArrayListExtra("tercer",  calter);
        startActivity(i);
    }

    private void primerp(){
        calpri= new ArrayList<Integer>();
            for(int i=0; i<10; i++){
                calpri.add(0);
            }
    }

    private void segundop(){
        calseg= new ArrayList<Integer>();
        for(int i=0; i<10; i++){
            calseg.add(0);
        }
    }

    private void tercerp(){
        calter= new ArrayList<Integer>();
        for(int i=0; i<10; i++){
            calter.add(0);
        }
    }
}