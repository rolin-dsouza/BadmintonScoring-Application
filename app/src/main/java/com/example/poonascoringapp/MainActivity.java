package com.example.poonascoringapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    TextView t1,t2;
    EditText memail,mpassword;
    Button mlogin;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        memail=findViewById(R.id.txt1);
        mpassword=findViewById(R.id.txt2);
        mlogin=findViewById(R.id.button1);
        t1=findViewById(R.id.txt3);
        t2=findViewById(R.id.txtregister);
        fAuth=FirebaseAuth.getInstance();



        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s= new Intent(MainActivity.this,register.class);
                startActivity(s);
            }
        });

        mlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=memail.getText().toString();
                String password=mpassword.getText().toString();
                if(TextUtils.isEmpty(email)){
                    memail.setError("email is required");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mpassword.setError("password is empty");
                    return;
                }

               // String email=memail.getText().toString();
               // String password=mpassword.getText().toString();
                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent i=new Intent(MainActivity.this,type.class);
                            startActivity(i);
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                        }
                    }

                });


            }
        });
    }


   /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu1,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.exit:

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);

                alertBuilder.setMessage("Do you want to close this application")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                moveTaskToBack(true);
                                android.os.Process.killProcess(android.os.Process.myPid());
                                System.exit(1);
                                Toast.makeText(MainActivity.this, "Clicked on Yes", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                Toast.makeText(MainActivity.this, "Clicked on No", Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alert = alertBuilder.create();
                alert.setTitle("Alert ");
                alert.show();

                return true;
            case R.id.aboutus:
                Toast.makeText(getApplicationContext(),"about us",Toast.LENGTH_LONG).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }*/
}

