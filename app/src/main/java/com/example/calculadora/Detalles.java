package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Detalles extends AppCompatActivity {

    TextView dpar, promedio, alta, baja, reprobadas, textView222;
    ArrayList<Integer> calpri ;
    ArrayList<Integer> calseg ;
    ArrayList<Integer> calter;
    ArrayList<String> materias = new ArrayList<String>();
    Button volver;
    int par;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        dpar = findViewById(R.id.dparcial);
        promedio = findViewById(R.id.promedio);
        alta = findViewById(R.id.alta);
        baja = findViewById(R.id.baja);
        reprobadas = findViewById(R.id.reprobadas);
        volver = findViewById(R.id.volver);
        textView222 = findViewById(R.id.textView222);

        String m = "miau"+ System.getProperty("line.separator") + "miau";
        System.out.println(m);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                volver();
            }
        });

        par = getIntent().getIntExtra("parcial", 1);
        if(par == 1){
            dpar.setText("Primer Parcial");
        }else if(par == 2){
            dpar.setText("Segundo Parcial");
        }else if(par == 3){
            dpar.setText("Tercer Parcial");
        }else if(par == 4){
            textView222.setText("Extraordinarios");
            dpar.setText("Semestre");
        }

        try {
            calpri = getIntent().getIntegerArrayListExtra("primer");
            System.out.println(calpri.size());
        }catch(Exception e){
            System.out.println(e.getMessage());
            primerp();
            System.out.println(calpri.size());
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

        materias.add("Probabilidad y Estadística");
        materias.add("Física IV");
        materias.add("Química IV");
        materias.add("Inglés VI");
        materias.add("Orientación Juvenil y Profesional IV");
        materias.add("Métodos Ágiles de Programación");
        materias.add("Soporte de Software");
        materias.add("Ingeniería de Software Básica");
        materias.add("Laboratorio de Proyectos de Tecnologías de la Información IV");
        materias.add("Proyecto Integrador");

        enviar();


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

    private void enviar(){
        if(par == 1){
            double prom = 0;
            for(Integer i: calpri){
                prom += i;
            }
            promedio.setText(String.valueOf(prom/10));

            int bajaa, altaa, ba= 0, al= 0;
            altaa= bajaa = calpri.get(0);
            ArrayList<Integer> repro = new ArrayList<Integer>();

            for (int i = 0; i < calpri.size(); i++) {
                if(calpri.get(i) > altaa) {
                    al = i;
                    altaa = calpri.get(i);
                }
                if(calpri.get(i) < bajaa) {
                    ba = i;
                    bajaa = calpri.get(i);
                }
                if(calpri.get(i) < 6){
                    repro.add(i);
                }
            }

            alta.setText(materias.get(al) + ": "+ altaa);
            baja.setText(materias.get(ba) + ": "+ bajaa);

            String marepro = "";

            for(Integer i: repro){
                marepro += "- "+materias.get(i) + ", ";
            }

            if(repro.size() ==0){
                marepro = "Ninguna";
            }

            reprobadas.setText(marepro);
        }else if(par == 2){
            double prom = 0;
            for(Integer i: calseg){
                prom += i;
            }
            promedio.setText(String.valueOf(prom/10));

            int bajaa, altaa, ba= 0, al= 0;
            altaa= bajaa = calseg.get(0);
            ArrayList<Integer> repro = new ArrayList<Integer>();

            for (int i = 0; i < calseg.size(); i++) {
                if(calseg.get(i) > altaa) {
                    al = i;
                    altaa = calseg.get(i);
                }
                if(calseg.get(i) < bajaa) {
                    ba = i;
                    bajaa = calseg.get(i);
                }
                if(calseg.get(i) < 6){
                    repro.add(i);
                }
            }

            alta.setText(materias.get(al) + ": "+ altaa);
            baja.setText(materias.get(ba) + ": "+ bajaa);

            String marepro = "";

            for(Integer i: repro){
                marepro += "- "+materias.get(i) + ", ";
            }

            if(repro.size() ==0){
                marepro = "Ninguna";
            }

            reprobadas.setText(marepro);
        }else if(par == 3){
            double prom = 0;
            for(Integer i: calter){
                prom += i;
            }
            promedio.setText(String.valueOf(prom/10));

            int bajaa, altaa, ba= 0, al= 0;
            altaa= bajaa = calter.get(0);
            ArrayList<Integer> repro = new ArrayList<Integer>();

            for (int i = 0; i < calter.size(); i++) {
                if(calter.get(i) > altaa) {
                    al = i;
                    altaa = calter.get(i);
                }
                if(calter.get(i) < bajaa) {
                    ba = i;
                    bajaa = calter.get(i);
                }
                if(calter.get(i) < 6){
                    repro.add(i);
                }
            }

            alta.setText(materias.get(al) + ": "+ altaa);
            baja.setText(materias.get(ba) + ": "+ bajaa);

            String marepro = "";

            for(Integer i: repro){
                marepro += "- "+materias.get(i) + ", ";
            }

            if(repro.size() ==0){
                marepro = "Ninguna";
            }

            reprobadas.setText(marepro);
        }else if(par == 4) {
            ArrayList<Integer> semestre = new ArrayList<Integer>();
            double prom = 0;
            for (int i = 0; i < 10; i++) {
                int mat = 0;
                mat += calpri.get(i);
                mat += calseg.get(i);
                mat += calter.get(i);
                mat /= 3;
                prom += mat;
                semestre.add(mat);
            }
            promedio.setText(String.valueOf(prom / 10));

            int bajaa, altaa, ba = 0, al = 0;
            altaa = bajaa = semestre.get(0);
            ArrayList<Integer> repro = new ArrayList<Integer>();

            for (int i = 0; i < semestre.size(); i++) {
                if (semestre.get(i) > altaa) {
                    altaa = semestre.get(i);
                    al = i;
                }
                if (semestre.get(i) < bajaa) {
                    bajaa= semestre.get(i);
                    ba = i;
                }
                if (semestre.get(i) < 6) {
                    repro.add(i);
                }
            }

            alta.setText(materias.get(al) + ": " + altaa);
            baja.setText(materias.get(ba) + ": " + bajaa);

            String marepro = "";

            for (Integer i : repro) {
                marepro += "- " + materias.get(i) + ", ";
            }

            if (repro.size() == 0) {
                marepro = "Ninguna";
            }

            reprobadas.setText(marepro);
        }
    }


    private void volver(){
        Intent i = new Intent(this, MainActivity.class);
        i.putIntegerArrayListExtra("primer", calpri);
        i.putIntegerArrayListExtra("segundo",  calseg);
        i.putIntegerArrayListExtra("tercer",  calter);
        startActivity(i);
    }
}