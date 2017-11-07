package com.example.diak.thinkanumber;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btn_plus, btn_minus, btn_send;
    private TextView number;
    private ImageView imgV_1, imgV_2, imgV_3, imgV_4, imgV_5;
    private int szam = 0;
    private int kitalalando_szam = 0;
    private int eletek = 5;

    private AlertDialog.Builder alert_vege;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        alert_vege = new AlertDialog.Builder(MainActivity.this);

        Random rnd = new Random();
        kitalalando_szam = rnd.nextInt(20) + 1;

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (szam < 20) {
                    szam++;
                }
                number.setText("" + szam);
            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (szam > 0) {
                    szam--;
                }
                number.setText("" + szam);
            }
        });

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (szam == kitalalando_szam) {
                    Toast.makeText(MainActivity.this, "Nyertél!", Toast.LENGTH_SHORT).show();
                    jatek_vege_nyert();

                } else if (szam > kitalalando_szam) {
                    Toast.makeText(MainActivity.this, "Lejjebb!", Toast.LENGTH_SHORT).show();
                    elet();
                } else if (szam < kitalalando_szam) {
                    Toast.makeText(MainActivity.this, "Feljebb!", Toast.LENGTH_SHORT).show();
                    elet();
                }
            }
        });
    }

    public void init() {
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_minus = (Button) findViewById(R.id.btn_negative);
        btn_send = (Button) findViewById(R.id.btn_submit);

        number = (TextView) findViewById(R.id.textView_szam);
        imgV_1 = (ImageView) findViewById(R.id.imageView_elet1);
        imgV_2 = (ImageView) findViewById(R.id.imageView_elet2);
        imgV_3 = (ImageView) findViewById(R.id.imageView_elet3);
        imgV_4 = (ImageView) findViewById(R.id.imageView_elet4);
        imgV_5 = (ImageView) findViewById(R.id.imageView_elet5);
    }

    public void elet() {
        eletek--;
        switch (eletek) {
            case 0:
                imgV_1.setImageResource(R.drawable.heart1);
                jatek_vege_vesztett();
                break;
            case 1:
                imgV_2.setImageResource(R.drawable.heart1);
                break;
            case 2:
                imgV_3.setImageResource(R.drawable.heart1);
                break;
            case 3:
                imgV_4.setImageResource(R.drawable.heart1);
                break;
            case 4:
                imgV_5.setImageResource(R.drawable.heart1);
                break;
        }
    }

    public void new_game() {
        Random rnd = new Random();
        kitalalando_szam = rnd.nextInt(20) + 1;
        szam = 0;
        number.setText("" + szam);
        eletek = 5;
        imgV_1.setImageResource(R.drawable.heart2);
        imgV_2.setImageResource(R.drawable.heart2);
        imgV_3.setImageResource(R.drawable.heart2);
        imgV_4.setImageResource(R.drawable.heart2);
        imgV_5.setImageResource(R.drawable.heart2);
    }

    public void jatek_vege_vesztett() {
        alert_vege.setTitle("Vesztettél!")
                .setMessage("Szeretnél újra játszani?")
                .setPositiveButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        new_game();
                    }
                })
                .setCancelable(false)
                .create();
        alert_vege.show();
    }
    public void jatek_vege_nyert() {
        alert_vege.setTitle("Gratulálok, Győztél!")
                .setMessage("Új játék?")
                .setPositiveButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        new_game();
                    }
                })
                .setCancelable(false)
                .create();
        alert_vege.show();
    }

}
