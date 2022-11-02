package com.example.poonascoringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class doubles extends AppCompatActivity {
    Button b1;
    EditText dplyname1,dplyname2;
    EditText dplyname3,dplyname4;
    String plyname1,plyname2,plyname3,plyname4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_doubles);
        b1 = (Button) findViewById(R.id.btnstart);
        dplyname1=(EditText)findViewById(R.id.deditply1);
        dplyname2=(EditText)findViewById(R.id.deditply2);
        dplyname3=(EditText)findViewById(R.id.deditply3);
        dplyname4=(EditText)findViewById(R.id.deditply4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String err = "";
                plyname1 = dplyname1.getText().toString();
                plyname2 = dplyname2.getText().toString();
                plyname3 = dplyname3.getText().toString();
                plyname4= dplyname4.getText().toString();


                //Toast.makeText(RegistrationPage.this, "Added to Database", Toast.LENGTH_SHORT).show();
                if (isInputEmpty(plyname1))
                    err += "Please enter player name";
                if (isInputEmpty(plyname2))
                    err += "Please enter player name";
                if (isInputEmpty(plyname3))
                    err += "Please enter player name";
                if (isInputEmpty(plyname4))
                    err += "Please enter player name";




                if (err.isEmpty()) {
                    SharedPreferences preferences1 = getSharedPreferences("dplyrinfo",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences1.edit();

                    editor.putString("dplyname1_shared", dplyname1.getText().toString());
                    editor.putString("dplyname2_shared", dplyname2.getText().toString());
                    editor.putString("dplyname3_shared", dplyname3.getText().toString());
                    editor.putString("dplyname4_shared", dplyname4.getText().toString());
                    editor.apply();
                    Intent i = new Intent(doubles.this, doublesmatch.class);
                    startActivity(i);


                }
                else
                {
                    Toast.makeText(doubles.this, "Enter all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.homepage:
                Intent i = new Intent(doubles.this, type.class);
                startActivity(i);

                return true;
            case R.id.history:
                Toast.makeText(getApplicationContext(),"History",Toast.LENGTH_LONG).show();
                return true;
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
                                Toast.makeText(doubles.this, "Clicked on Yes", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                Toast.makeText(doubles.this, "Clicked on No", Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alert = alertBuilder.create();
                alert.setTitle("Alert ");
                alert.show();

                return true;

            case R.id.aboutus:
                Toast.makeText(getApplicationContext(),"about us",Toast.LENGTH_LONG).show();
                Intent ii = new Intent(doubles.this, about.class);
                startActivity(ii);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
public static boolean isInputEmpty(String str) {
        if(str.isEmpty())
        return true;
        return false;
        }
}