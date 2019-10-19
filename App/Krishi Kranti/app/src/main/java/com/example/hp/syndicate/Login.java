package com.example.hp.syndicate;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity
{
    Button b1,b2;
    EditText e1,e2;
    TextView t1,t2,t3,t4;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        t1=(TextView)findViewById(R.id.textView);
        t2=(TextView)findViewById(R.id.textView2);
        t3=(TextView)findViewById(R.id.textView3);
        t4=(TextView)findViewById(R.id.textView4);
        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(Login.this, SignUp.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                if(s1.equals("") || s2.equals(""))
                {
                    Toast.makeText(Login.this, "Fill All", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    SQLiteDatabase syndicate = openOrCreateDatabase("data",MODE_PRIVATE,null);
                    syndicate.execSQL("create table if not exists base(name varchar, email varchar, username varchar, password varchar, city varchar, phone varchar)");
                    String s3="select * from base where username='"+s1+"' and password='"+s2+"'";
                    Cursor cursor = syndicate.rawQuery(s3,null);
                    if(cursor.getCount()>0)
                    {
                        Toast.makeText(Login.this, "Welcome", Toast.LENGTH_SHORT).show();
                        Intent j = new Intent(Login.this, Activities.class);
                        startActivity(j);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(Login.this, "Sorry, this Entry does not Exist in our Database..", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}
