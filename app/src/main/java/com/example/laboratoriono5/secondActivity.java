package com.example.laboratoriono5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity {

    //mensaje mediante clave-valor definida public para poder usarla tambien en la Primera Activity
    public static final String EXTRA_REPLY = "com.example.laboratoriono5.extra.REPLAY";

    //variable para la edicion
    private EditText mReplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //obtenemos el intent disponible
        Intent intent = getIntent();

        //se obtiene el mensaje de la otra activity
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //referencia de nuestro textView
        TextView textView = findViewById(R.id.text_message);

        //lo ponemos en él
        textView.setText(message);

        //obtenemos la referencia que fue escrito en nuestra segunda activity EditText y lo guardamos en mReplay
        mReplay = findViewById(R.id.editText_second);
    }

    public void returnReply(View view) {
        //obtenemos lo de mReply
        String reply = mReplay.getText().toString();

        //Creamos un objeto intent
        Intent replyIntent = new Intent();

        /*ahora tomamos el valor del id que es el valor clave, el segundo parámetro es el texto
        real obtenido del reply*/
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        //cerramos la actividad
        finish();
    }
}