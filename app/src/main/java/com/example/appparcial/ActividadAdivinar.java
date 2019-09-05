package com.example.appparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ActividadAdivinar extends AppCompatActivity
{
    TextView txtViewAdivinar,txtViewIntentos;
    EditText editTxtNumero;
    Button btnAdivina;
    LinearLayout lytConScroll;
    TextView txtViewNuevo;
    boolean win;
    String auxiliar;
    int contadorIntentos,numeroRandom,numeroMaximo,numeroIntento;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_adivinar);

        txtViewAdivinar = findViewById(R.id.txtViewAdivinar);
        txtViewIntentos = findViewById(R.id.txtViewIntentos);
        editTxtNumero = findViewById(R.id.editTxtNumero);
        btnAdivina = findViewById(R.id.btnAdivina);
        lytConScroll = (LinearLayout) findViewById(R.id.lytConScroll);

        Intent i = getIntent();

        numeroMaximo = i.getIntExtra("numeroMaximo",100);

        numeroRandom = (int)(Math.random()*((numeroMaximo) + 1));


        txtViewAdivinar.setText("Adivina un numero entre 0 y " +numeroMaximo);

        win=false;
        btnAdivina.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(!win)
                {
                    if(!editTxtNumero.getText().toString().matches(""))
                    {
                        numeroIntento = Integer.parseInt(editTxtNumero.getText().toString());

                        if((numeroIntento > 0 && numeroIntento < numeroMaximo))
                        {
                            editTxtNumero.setText("");
                            contadorIntentos++;
                            txtViewIntentos.setText("Intentos : "+contadorIntentos);

                            if(numeroIntento > numeroRandom)
                            {
                                auxiliar = "El numero "+numeroIntento+" es: Mayor";
                                txtViewNuevo = new TextView(ActividadAdivinar.this);
                                txtViewNuevo.setText(auxiliar);
                                txtViewNuevo.setTextColor(Color.BLACK);
                                lytConScroll.addView(txtViewNuevo);
                            }
                            if(numeroIntento < numeroRandom)
                            {
                                txtViewNuevo =new TextView(ActividadAdivinar.this);
                                txtViewNuevo.setText("El numero "+numeroIntento+" es: Menor");
                                txtViewNuevo.setTextColor(Color.BLACK);
                                lytConScroll.addView(txtViewNuevo);
                            }
                            if(numeroIntento == numeroRandom)
                            {
                                txtViewNuevo = new TextView(ActividadAdivinar.this);
                                txtViewNuevo.setText("El numero "+ numeroIntento + " es Correcto!");
                                txtViewNuevo.setTextColor(Color.BLACK);
                                lytConScroll.addView(txtViewNuevo);
                                win = true;
                            }
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"El numero se salio de los bordes",Toast.LENGTH_LONG).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"No se ingreso un numero",Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"GANASTE!!",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
