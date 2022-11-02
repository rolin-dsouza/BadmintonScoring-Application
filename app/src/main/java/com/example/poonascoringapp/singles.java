package com.example.poonascoringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class singles extends AppCompatActivity {
    Button b1;
    EditText splyname1,splyname2;
    String plyname1,plyname2;
    RadioGroup radgrp;
    String side="";
    RadioButton sradleft,sradright;
    ImageView i1,i2;
    int lcnt=0,rcnt=0;
    String  lcnts,rcnts;
    TextView singles1,sserve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_singles);
        b1 = (Button) findViewById(R.id.btnstart);
        splyname1 = (EditText) findViewById(R.id.seditply1);
        splyname2 = (EditText) findViewById(R.id.seditply2);
        i1=(ImageView) findViewById(R.id.simgviewply1);
        i2=(ImageView) findViewById(R.id.simgviewply2);
        sradleft=findViewById(R.id.sradleft) ;
        sradright=findViewById(R.id.sradright) ;
        radgrp=(RadioGroup)findViewById(R.id.sradgrp);
        singles1=(TextView) findViewById(R.id.singles1);
        sserve=(TextView) findViewById(R.id.sserve);
        SharedPreferences preferences = getSharedPreferences("plyrinfo", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String err = "";
                plyname1 = splyname1.getText().toString();
                plyname2 = splyname2.getText().toString();


                //Toast.makeText(RegistrationPage.this, "Added to Database", Toast.LENGTH_SHORT).show();
                if (isInputEmpty(plyname1))
                    err += "Please enter player name";
                if (isInputEmpty(plyname2))
                    err += "Please enter player name";


                if (err.isEmpty()) {


                    editor.putString("splyname1_shared", splyname1.getText().toString());
                    editor.putString("splyname2_shared", splyname2.getText().toString());
                    editor.apply();
                    Intent i = new Intent(singles.this, singlesmatch.class);
                    startActivity(i);


                } else {
                    Toast.makeText(singles.this, "Enter all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //singles1.setText(lcnts+"l");
        //sserve.setText(rcnts+"r");

       radgrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {


                switch (i) {
                    case R.id.sradleft:
                        side = "left";
                        lcnt++;
                        lcnts = String.valueOf(lcnt);
                      // singles1.setText(lcnts+"l");
                        editor.putString("sleft_shared",  lcnts.toString());
                        editor.apply();
                        rcnt=0;
                        rcnts = String.valueOf(rcnt);
                        editor.putString("sright_shared",  rcnts.toString());
                        editor.apply();
                        sradleft.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                               i1.setVisibility(View.VISIBLE);
                                i1.setImageResource(R.drawable.blueimg1);
                              i2.setVisibility(View.INVISIBLE);
                            }
                        });

                     //   editor.putString("sleft_shared", side.toString());
                       Toast.makeText(singles.this, "Left is selected", Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.sradright:
                        side = "right";
                        rcnt++;

                        rcnts = String.valueOf(rcnt);
                       // sserve.setText(rcnts+"r");
                        editor.putString("sright_shared",  rcnts.toString());
                        editor.apply();
                        lcnt=0;
                        lcnts = String.valueOf(lcnt);
                        editor.putString("sleft_shared",  lcnts.toString());
                        editor.apply();
                        //i2.setImageResource(R.drawable.blueimg1);
                        sradright.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                i2.setVisibility(View.VISIBLE);
                                i2.setImageResource(R.drawable.blueimg1);
                               i1.setVisibility(View.INVISIBLE);
                            }
                        });

                      //  editor.putString("sright_shared", side.toString());
                        Toast.makeText(singles.this, "Right is selected", Toast.LENGTH_SHORT).show();

                        break;
                    /*default: editor.putString("sleft_shared", side.toString());
                        i1.setVisibility(View.VISIBLE);
                        i1.setImageResource(R.drawable.blueimg1);
                        i2.setVisibility(View.INVISIBLE);*/

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
                    Intent i = new Intent(singles.this, type.class);
                    startActivity(i);

                    Toast.makeText(getApplicationContext(),"home",Toast.LENGTH_LONG).show();
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
                                    Toast.makeText(singles.this, "Clicked on Yes", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                    Toast.makeText(singles.this, "Clicked on No", Toast.LENGTH_SHORT).show();
                                }
                            });
                    AlertDialog alert = alertBuilder.create();
                    alert.setTitle("Alert ");
                    alert.show();

                    return true;
                case R.id.aboutus:
                    Toast.makeText(getApplicationContext(),"about us",Toast.LENGTH_LONG).show();
                    Intent ii = new Intent(singles.this, about.class);
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

