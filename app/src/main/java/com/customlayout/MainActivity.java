package com.customlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    int count = 0;
    long oldTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long currentTime = System.currentTimeMillis();
                if (currentTime - oldTime > 700) {
                    oldTime = System.currentTimeMillis();
                    count = 0;
                } else if (currentTime - oldTime < 700) {
                    oldTime = System.currentTimeMillis();
                    count++;
                }

                if (count == 4) {
                    Toast.makeText(MainActivity.this, "您已经处于开发者模式", Toast.LENGTH_SHORT).show();
                    count = 0;
                }


            }
        });

    }
}
