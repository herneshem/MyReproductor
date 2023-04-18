package com.example.myreproductor;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    //Aqui se crea las variables

    Button play, btn_repetir;
    MediaPlayer mp; //cambia portada
    ImageView vi;
    int repetir = 2, posicion = 0;

    MediaPlayer vector[] = new MediaPlayer[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Aqui se crea la relaci'on entre lo logico y el dise;o

        play = (Button) findViewById(R.id.btn_play);
        btn_repetir = (Button) findViewById(R.id.btn_repetir);
        vi = (ImageView) findViewById(R.id.imageView);

        vector[0] = MediaPlayer.create(this, R.raw.lindasobedi);
        vector[1] = MediaPlayer.create(this, R.raw.vendedordeagua);
        vector[2] = MediaPlayer.create(this, R.raw.saborcaney);
    }
    //Aqui se crea los m'etodos

    public void PlayPausa(View view) {
        if (vector[posicion].isPlaying()) {
            vector[posicion].pause();
            play.setBackgroundResource(R.drawable.reproducir);
            Toast.makeText(this, "Pausa", Toast.LENGTH_SHORT).show();
        } else {
            vector[posicion].start();
            play.setBackgroundResource(R.drawable.pausa);
            Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show();
        }

    }
    public void Stop(View view){
        if(vector[posicion] !=null){
            vector[posicion].stop();
            vector[0] = MediaPlayer.create(this, R.raw.lindasobedi);
            vector[1] = MediaPlayer.create(this, R.raw.vendedordeagua);
            vector[2] = MediaPlayer.create(this, R.raw.saborcaney);
            posicion = 0;
            play.setBackgroundResource(R.drawable.reproducir);
            vi.setImageResource(R.drawable.yoda);
            Toast.makeText(this,"Detener", Toast.LENGTH_SHORT).show();
        }
    }

    public void Repetir(View view){
        if(repetir == 1){
            btn_repetir.setBackgroundResource(R.drawable.no_repetir);
            Toast.makeText(this,"No Repetir", Toast.LENGTH_SHORT).show();
            vector[posicion].setLooping(false);
            repetir = 2;
        }else{
            btn_repetir.setBackgroundResource(R.drawable.repetir);
            Toast.makeText(this, "Repetir", Toast.LENGTH_SHORT).show();
            vector[posicion].setLooping(true);
            repetir = 1;

        }
    }

    public void Siguiente(View view){
        if(posicion < vector.length -1){
            if(vector[posicion].isPlaying()){
                vector[posicion].stop();
                posicion ++;
                vector[posicion].start();
                if(posicion == 0){
                    vi.setImageResource(R.drawable.yoda);
                }else if(posicion == 1){
                    vi.setImageResource(R.drawable.yodaagua);
                }
                else if(posicion == 2){
                    vi.setImageResource(R.drawable.yodabaile);
                }
            }else{
                posicion ++;

                if(posicion == 0){
                    vi.setImageResource(R.drawable.yoda);
                }else if(posicion == 1){
                    vi.setImageResource(R.drawable.yodaagua);
                }
                else if(posicion == 2){
                    vi.setImageResource(R.drawable.yodabaile);
                }
            }

        }else{
            Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_SHORT).show();
        }
    }

    public void Retroceder(View view){
        if(posicion >= 1){
            if(vector[posicion].isPlaying()){
                vector[posicion].stop();
                vector[0] = MediaPlayer.create(this, R.raw.lindasobedi);
                vector[1] = MediaPlayer.create(this, R.raw.vendedordeagua);
                vector[2] = MediaPlayer.create(this, R.raw.saborcaney);
                posicion --;
                vector[posicion].start();

                if(posicion == 0){
                    vi.setImageResource(R.drawable.yoda);
                }else if(posicion == 1){
                    vi.setImageResource(R.drawable.yodaagua);
                }
                else if(posicion == 2){
                    vi.setImageResource(R.drawable.yodabaile);
                }
            }else{
                posicion --;

                if(posicion == 0){
                    vi.setImageResource(R.drawable.yoda);
                }else if(posicion == 1){
                    vi.setImageResource(R.drawable.yodaagua);
                }
                else if(posicion == 2){
                    vi.setImageResource(R.drawable.yodabaile);
                }
            }

        }else{
            Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_SHORT).show();
        }
    }
}