package com.example.hp.syndicate;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity
{
    Button b3,b4;
    EditText e3,e4,e5,e6,e7,e8;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        e3=(EditText)findViewById(R.id.editText3);
        e4=(EditText)findViewById(R.id.editText4);
        e5=(EditText)findViewById(R.id.editText5);
        e6=(EditText)findViewById(R.id.editText6);
        e7=(EditText)findViewById(R.id.editText7);
        e8=(EditText)findViewById(R.id.editText8);
        b3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i=new Intent(SignUp.this,Login.class);
                startActivity(i);
                finish();
            }
        });
        b4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String s1 = e3.getText().toString();
                String s2 = e4.getText().toString();
                String s3 = e5.getText().toString();
                String s4 = e6.getText().toString();
                String s5 = e7.getText().toString();
                String s6 = e8.getText().toString();
                if(s1.equals("") || s2.equals("") || s3.equals("") || s4.equals("") || s5.equals("") || s6.equals(""))
                {
                    Toast.makeText(SignUp.this, "Fill All", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    SQLiteDatabase syndicate = openOrCreateDatabase("data",MODE_PRIVATE,null);
                    syndicate.execSQL("create table if not exists base(name varchar, email varchar, username varchar, password varchar, city varchar, phone varchar)");
                    String s7="select * from base where email='"+s2+"' and username='"+s3+"'";
                    Cursor cursor = syndicate.rawQuery(s7,null);
                    if(cursor.getCount()>0)
                    {
                        Toast.makeText(SignUp.this, "Already Exists", Toast.LENGTH_SHORT).show();
                        Intent j = new Intent(SignUp.this, Login.class);
                        startActivity(j);
                        finish();
                    }
                    else
                    {
                        syndicate.execSQL("insert into base values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"')");
                        Toast.makeText(SignUp.this, "Added and Updated to the Database..", Toast.LENGTH_SHORT).show();
                        Intent k = new Intent(SignUp.this, Login.class);
                        startActivity(k);
                        finish();
                    }
                }
            }
        });

    }
}
