package com.example.poonascoringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class d_round1score extends AppCompatActivity {
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dround1score);
        b1=(Button) findViewById(R.id.dcontinuernd2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(d_round1score.this,doublesmatch.class);
                startActivity(i1);
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
                Intent i = new Intent(d_round1score.this, doublesmatch.class);
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
                                Toast.makeText(d_round1score.this, "Clicked on Yes", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                Toast.makeText(d_round1score.this, "Clicked on No", Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alert = alertBuilder.create();
                alert.setTitle("Alert ");
                alert.show();

                return true;



            case R.id.aboutus:
                Toast.makeText(getApplicationContext(),"about us",Toast.LENGTH_LONG).show();
                Intent ii = new Intent(d_round1score.this, about.class);
                startActivity(ii);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}