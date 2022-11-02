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
import android.widget.TextView;
import android.widget.Toast;

public class doublesmatch extends AppCompatActivity {
    TextView dplyrname1;
    TextView dplyrname2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_doublesmatch);
        dplyrname1=(TextView)findViewById(R.id.dteam1name);
        dplyrname2=(TextView)findViewById(R.id.dteam2name);
        SharedPreferences preferences1 = getSharedPreferences("dplyrinfo", MODE_PRIVATE);

        String dplyname1_sharedp = preferences1.getString("dplyname1_shared", "");
        String dplyname2_sharedp=  preferences1.getString("dplyname2_shared", "");
        String dplyname3_sharedp= preferences1.getString("dplyname3_shared", "");
        String dplyname4_sharedp= preferences1.getString("dplyname4_shared", "");
        dplyrname1.setText(dplyname1_sharedp+"/"+dplyname2_sharedp);
        dplyrname2.setText(dplyname3_sharedp+"/"+dplyname4_sharedp);

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
                    Intent i = new Intent(doublesmatch.this, d_round1score.class);
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
                                    Toast.makeText(doublesmatch.this, "Clicked on Yes", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                    Toast.makeText(doublesmatch.this, "Clicked on No", Toast.LENGTH_SHORT).show();
                                }
                            });
                    AlertDialog alert = alertBuilder.create();
                    alert.setTitle("Alert ");
                    alert.show();

                    return true;

                case R.id.aboutus:
                    Toast.makeText(getApplicationContext(),"about us",Toast.LENGTH_LONG).show();
                    Intent ii = new Intent(doublesmatch.this, about.class);
                    startActivity(ii);
                    return true;

                default:
                    return super.onOptionsItemSelected(item);
            }
        }
    }
