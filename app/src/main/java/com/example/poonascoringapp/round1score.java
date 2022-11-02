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
import android.widget.TextView;
import android.widget.Toast;

public class round1score extends AppCompatActivity {
    Button b1;
    TextView plyname1,plyname2,sscore1,sscore2,rndwon1,round1txtview;
    int rndnumber;
   String rndnos1,rnos;
   int rno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round1score);
        SharedPreferences preferences = getSharedPreferences("plyrinfo", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        b1=(Button) findViewById(R.id.continuernd2);
        plyname1=(TextView)findViewById(R.id.plyname1);
        plyname2=(TextView)findViewById(R.id.plyname2);
        sscore1=(TextView)findViewById(R.id.sscore1);
        sscore2=(TextView)findViewById(R.id.sscore2);
        rndwon1=(TextView)findViewById(R.id.rnd1won) ;
        round1txtview=(TextView)findViewById(R.id.round1txtview);



        String splyname1_sharedp = preferences.getString("splyname1_shared", "");
        String splyname2_sharedp= preferences.getString("splyname2_shared", "");

        String swinner_sharedp= preferences.getString("swinner_shared", "");
        String plyr1score_sharedp= preferences.getString("plyr1score_shared", "");
        String plyr2score_sharedp= preferences.getString("plyr2score_shared", "");

        String rndno_sharedp= preferences.getString("rndno_shared", "");
        rno=Integer.parseInt(rndno_sharedp);
      rno++;
       // rno=2;
       rnos = String.valueOf(rno);
       editor.putString("rndno_sharedp", rnos.toString());
        editor.apply();




        //int rndno1= new Integer(rndno_sharedp);
        //rndno1++;
       // rndnos1 = String.valueOf(rndno1);

       // editor.putString("rndno1_shared", rndnos1.toString());


      //  editor.apply();

        plyname1.setText(splyname1_sharedp);
        plyname2.setText(splyname2_sharedp);
        sscore1.setText(plyr1score_sharedp);
        sscore2.setText(plyr2score_sharedp);
     rndwon1.setText(swinner_sharedp);
        //rndwon1.setText(rnos);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(round1score.this,singlesmatch.class);
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
                Intent i = new Intent(round1score.this, type.class);
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
                                Toast.makeText(round1score.this, "Clicked on Yes", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                Toast.makeText(round1score.this, "Clicked on No", Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alert = alertBuilder.create();
                alert.setTitle("Alert ");
                alert.show();

                return true;



            case R.id.aboutus:
                Toast.makeText(getApplicationContext(),"about us",Toast.LENGTH_LONG).show();
                Intent ii = new Intent(round1score.this, about.class);
                startActivity(ii);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}