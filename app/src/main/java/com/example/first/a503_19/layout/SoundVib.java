package com.example.first.a503_19.layout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SoundVib extends AppCompatActivity {

    Button btnvibrate, btnsystemsound, btnusersound, btntoast, btnbasicalert, btnasync;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_vib);


        //버튼찾아오기
        btnvibrate = (Button)findViewById(R.id.btnvibrate);
        btnsystemsound = (Button)findViewById(R.id.btnsystemsound);
        btnusersound = (Button)findViewById(R.id.btnusersound);
        btnbasicalert = (Button)findViewById(R.id.btnbasicalert);
        btntoast = (Button)findViewById(R.id.btntoast);
        btnasync = (Button)findViewById(R.id.btnasync);


        btnvibrate.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                Vibrator vib = (Vibrator)getSystemService(VIBRATOR_SERVICE);
                vib.vibrate(3000);
            }
        });

        btnsystemsound.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                Uri systemsound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                Ringtone ringtone = RingtoneManager.getRingtone(getApplicationContext(),systemsound);
                ringtone.play();
            }
        });

        btnusersound.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                MediaPlayer player = MediaPlayer.create(SoundVib.this, R.raw.dididididididi);
                player.start();
            }
        });

        btntoast.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(SoundVib.this,"안녕하세요 토스트입니다.",Toast.LENGTH_LONG).show();
            }
        });

        btnbasicalert.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                //메소드체이닝을 이용한 생성과 출력
                new AlertDialog.Builder(SoundVib.this)
                        .setMessage("기본 대화상자")
                        .setTitle("대화상자")
                        .setIcon(R.drawable.icon)
                        .setPositiveButton("긍정", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(SoundVib.this, "긍정을 눌럿습니다.", Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("부정",null)
                        .setNeutralButton("중립",null)
                        .show();
            }
        });


        //Button btnasync = (Button)fingViewById(R.id.btnasync);
        btnasync.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(SoundVib.this)
                        .setMessage("액티비티 종료")
                        .setTitle("대화상자")
                        .setIcon(R.drawable.icon)
                        .show();

                //토스트출력
                Toast.makeText(SoundVib.this,"토스트 출력",Toast.LENGTH_LONG)
                        .show();

                //엑티비티 종료
                finish();
            }
        });


    }
}
