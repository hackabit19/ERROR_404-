package com.example.hp.syndicate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Activities extends AppCompatActivity {
    TextView t4;
    Button b5,b6,b7,b8,b9;
    ImageView i1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);
        t4=(TextView)findViewById(R.id.textView4);
        b5=(Button)findViewById(R.id.button5);
        b6=(Button)findViewById(R.id.button6);
        b8=(Button)findViewById(R.id.button8);
        b9=(Button)findViewById(R.id.button9);
        ImageView i1=(ImageView)findViewById(R.id.imageView);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Activities.this,Login.class);
                startActivity(i);
                finish();
            }
        });
    }
}
