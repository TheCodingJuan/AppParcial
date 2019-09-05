package com.example.appparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Button btnJugar;
    EditText editTxtNumero;
    String editNumero;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnJugar =  findViewById(R.id.btnJugar);
        editTxtNumero = findViewById(R.id.editTxtNumero);

        btnJugar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                editNumero = editTxtNumero.getText().toString();

                if(!editNumero.matches(""))
                {
                    if(((Integer.parseInt(editNumero) >=0) && (Integer.parseInt(editNumero) <= 100)))
                    {
                        Intent i = new Intent(getApplicationContext(), ActividadAdivinar.class);
                        i.putExtra("numeroMaximo",Integer.parseInt(editNumero));
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"VALOR INVALIDO 0-100",Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"No se ha ingresado ningun valor",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
