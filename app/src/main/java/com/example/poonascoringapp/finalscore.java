package com.example.poonascoringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
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

public class finalscore extends AppCompatActivity {
    Button b1;

    TextView plyname1,plyname2,sscore1,sscore2,rndwon1,fply1score1,fply1score2,fply1score3,round3;
    TextView fply2score1,fply2score2,fply2score3,winnername;
    int rndnumber;
    String rndnos1,rnos;
    int rno,cnt1,cnt2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalscore);

       SharedPreferences preferences = getSharedPreferences("plyrinfo", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        b1=(Button) findViewById(R.id.buttonexit);
        plyname1=(TextView)findViewById(R.id.fplyname1);
        plyname2=(TextView)findViewById(R.id.fplyname2);
        fply1score1=(TextView)findViewById(R.id.fply1score1);
        fply1score2=(TextView)findViewById(R.id.fply1score2);
        fply1score3=(TextView)findViewById(R.id.fply1score3) ;
        fply2score1=(TextView)findViewById(R.id.fply2score1);
        fply2score2=(TextView)findViewById(R.id.fply2score2);
        fply2score3=(TextView)findViewById(R.id.fply2score3) ;
        winnername=(TextView)findViewById(R.id.winnername) ;
        round3=(TextView)findViewById(R.id.round3) ;

        String splyname1_sharedp = preferences.getString("splyname1_shared", "");
        String splyname2_sharedp= preferences.getString("splyname2_shared", "");
        String swinner1_sharedp= preferences.getString("swinner_shared", "");
        String swinner3_sharedp= preferences.getString("3swinner_shared", "");
        String swinner2_sharedp= preferences.getString("2swinner_shared", "");

        String plyr1score_sharedp= preferences.getString("plyr1score_shared", "");
        String plyr2score_sharedp= preferences.getString("plyr2score_shared", "");
        String _2plyr1score_sharedp= preferences.getString("2plyr1score_shared", "");
        String _2plyr2score_sharedp= preferences.getString("2plyr2score_shared", "");
        String _3plyr1score_sharedp= preferences.getString("3plyr1score_shared", "");
        String _3plyr2score_sharedp= preferences.getString("3plyr2score_shared", "");
        String ply1cnt_shared= preferences.getString("ply1cnt_shared", "");
        String ply2cnt_shared= preferences.getString("ply2cnt_shared", "");




      String rndno_sharedp= preferences.getString("rndno_shared", "");
        rno=Integer.parseInt(rndno_sharedp);
        cnt1=Integer.parseInt( ply1cnt_shared);
        cnt2=Integer.parseInt(ply2cnt_shared);

    // round3.setText(rndno_sharedp);

       // rno++;
        // rno=2;
       rnos = String.valueOf(rno);
        //winnername.setText(rnos);
       // editor.putString("rndno_shared", rnos.toString());
        //editor.apply();*/
        if(swinner1_sharedp.equals(swinner2_sharedp))
        {
            plyname1.setText(splyname1_sharedp);
            plyname2.setText(splyname2_sharedp);

            fply1score1.setText(plyr1score_sharedp);
            fply2score1.setText(plyr2score_sharedp);
            fply1score2.setText(_2plyr1score_sharedp);
            fply2score2.setText(_2plyr2score_sharedp);
             round3.setText("");

          //  winnername.setText(splyname1_sharedp);



        }
        else {


            //int rndno1= new Integer(rndno_sharedp);
            //rndno1++;
            // rndnos1 = String.valueOf(rndno1);

            // editor.putString("rndno1_shared", rndnos1.toString());


            //  editor.apply();

            plyname1.setText(splyname1_sharedp);
            plyname2.setText(splyname2_sharedp);

            fply1score1.setText(plyr1score_sharedp);
            fply2score1.setText(plyr2score_sharedp);
            fply1score2.setText(_2plyr1score_sharedp);
            fply2score2.setText(_2plyr2score_sharedp);
            fply1score3.setText(_3plyr1score_sharedp);
            fply2score3.setText(_3plyr2score_sharedp);
        }
        //
        if(plyr1score_sharedp.equals(_2plyr1score_sharedp))
        {
            winnername.setText(splyname1_sharedp);
        }
        if(plyr2score_sharedp.equals(_2plyr2score_sharedp))
        {
            winnername.setText(splyname2_sharedp);
        }
        //
        if(cnt1>cnt2){
          winnername.setText(splyname1_sharedp);
        }
        else
        {
            winnername.setText(splyname2_sharedp);
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // rno=1;
                //rndnos1 = String.valueOf(rno);
              //  editor.putString("rndno_shared", rndnos1.toString());

               // editor.apply();

               Intent i1=new Intent(finalscore.this,MainActivity.class);
               startActivity(i1);
              //  Activity.finish();
                //activity_finalscore.this.finish();
              //  finish();
               // this.finishAffinity();
               // getActivity().finish();
               // System.exit(0);

               // System.exit(0);
               // moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);


            }



        //  rndwon1.setText(swinner_sharedp);
       // rndwon1.setText(rnos);


       // b1=(Button) findViewById(R.id.finalround);
       // b1.setOnClickListener(new View.OnClickListener() {
       //     @Override
         //   public void onClick(View view) {
              /*  if(swinner1_sharedp.equals(swinner2_sharedp))
                {

                    Intent i1=new Intent(finalscore.this,finalscore.class);
                    startActivity(i1);
                }
                else
                {
                    Intent i1=new Intent(finalscore.this,singlesmatch.class);
                    startActivity(i1);
                }*/

         //   }
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
                Intent i = new Intent(finalscore.this, type.class);
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
                                Toast.makeText(finalscore.this, "Clicked on Yes", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                Toast.makeText(finalscore.this, "Clicked on No", Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alert = alertBuilder.create();
                alert.setTitle("Alert");
                alert.show();

                return true;



            case R.id.aboutus:
                Toast.makeText(getApplicationContext(),"about us",Toast.LENGTH_LONG).show();
                Intent ii = new Intent(finalscore.this, about.class);
                startActivity(ii);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}