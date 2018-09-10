package com.sistemasvox.marcelo.imc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends Activity {
    private EditText pesoEditText, alturaEditText;
    private ImageView imagem;
    private TextView imcTextView;
    private NumberFormat formatoNumero = NumberFormat.getNumberInstance();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pesoEditText = (EditText) findViewById(R.id.pesoEditText);
        alturaEditText = (EditText) findViewById(R.id.alturaEditText2);
        imagem = (ImageView) findViewById(R.id.imageView);
        imcTextView = (TextView) findViewById(R.id.imcTextView);
    }

    public void calcular(View view) {
        double peso = Double.parseDouble(pesoEditText.getText().toString());
        double altura = Double.parseDouble(alturaEditText.getText().toString());
        double imc = peso / (altura * altura);
        imcTextView.setText(formatoNumero.format(imc));
        if (imc < 18.5) imagem.setImageResource(R.drawable.imc1);
        else if (imc >= 18.5 && imc < 25) imagem.setImageResource(R.drawable.imc2);
        else if (imc >= 25 && imc < 30) imagem.setImageResource(R.drawable.imc3);
        else if (imc >= 30) imagem.setImageResource(R.drawable.imc4);
    }
}