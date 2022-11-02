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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class singlesmatch extends AppCompatActivity {
    TextView splyrname1,plyname1,plyname2,plyname3,plyname4,pylr1score,plyr2score;
    TextView splyrname2,plyname11,rndno,singles,singlesm;
    ImageView i1,i2,i3,i4;
    Button ptsleft,ptsright,sundo;
    String cnt1s,cnt2s;
    String flag1="u",lflag,rflag,rndnumber,rno;
    int plyr1count=0,plyr2count=0 ,slcnt,srcnt;
    static int rnd=1;
    static int cnt1=0;
    static int cnt2=0;
    String  score1,score2,plyr2sscore,plyr1sscore;
            int p1score,p2score;
            int count;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singlesmatch);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        splyrname1=(TextView)findViewById(R.id.splyr1name);
        plyname1=(TextView)findViewById(R.id.plyname1);
        plyname3=(TextView)findViewById(R.id.plyname2);
        plyname2=(TextView)findViewById(R.id.plyname11);
        plyname4=(TextView)findViewById(R.id.plyname22);
        splyrname2=(TextView)findViewById(R.id.splyr2name);
        plyname11=(TextView)findViewById(R.id.plyname11);
        pylr1score=(TextView)findViewById(R.id. plyr1score);
        plyr2score=(TextView)findViewById(R.id.plyr2score);
        singles=(TextView)findViewById(R.id.singles);
        singlesm=(TextView)findViewById(R.id.singlesm);
        rndno=(TextView)findViewById(R.id.roundno1);
        i1=(ImageView)findViewById(R.id.simgviewc1);
        i2=(ImageView)findViewById(R.id.simgviewc2);
        i3=(ImageView)findViewById(R.id.simgviewc3);
        i4=(ImageView)findViewById(R.id.simgviewc4);
        ptsleft=(Button)findViewById(R.id.sptsleft) ;
        ptsright=(Button)findViewById(R.id.sptsright) ;
        sundo=(Button)findViewById(R.id.sundo) ;
        SharedPreferences preferences = getSharedPreferences("plyrinfo", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        rndnumber=String.valueOf(rnd);
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);


        String splyname1_sharedp = preferences.getString("splyname1_shared", "");
        String splyname2_sharedp= preferences.getString("splyname2_shared", "");
        String sleft_sharedp= preferences.getString("sleft_shared", "");
        String sright_sharedp= preferences.getString("sright_shared", "");

        String rndno_sharedp= preferences.getString("rndno_shared", "");
        rno=rndno_sharedp.toString();
       // singles.setText(sleft_sharedp);
        //singlesm.setText(sright_sharedp);

        slcnt= Integer.parseInt(sleft_sharedp);
        srcnt= Integer.parseInt(sright_sharedp);
        if(slcnt>srcnt){
            Toast.makeText(singlesmatch.this, "left ", Toast.LENGTH_SHORT).show();
            i1.setImageResource(R.drawable.blueimg1);
            plyname1.setText(splyname1_sharedp);
            plyname3.setText(splyname2_sharedp);
            flag1="u";
        }
        else
        {
            Toast.makeText(singlesmatch.this, "Right ", Toast.LENGTH_SHORT).show();
            i3.setImageResource(R.drawable.blueimg1);
            plyname1.setText(splyname1_sharedp);
            plyname3.setText(splyname2_sharedp);
            flag1="d";

        }

        /*if(sleft_sharedp.equals("1"))
        {
            Toast.makeText(singlesmatch.this, "left ", Toast.LENGTH_SHORT).show();
            i1.setImageResource(R.drawable.blueimg1);
            plyname1.setText(splyname1_sharedp);
            plyname3.setText(splyname2_sharedp);
            flag1="u";
        }
        if(sright_sharedp.equals("1"))
        {
            Toast.makeText(singlesmatch.this, "Right ", Toast.LENGTH_SHORT).show();
            i3.setImageResource(R.drawable.blueimg1);
            plyname1.setText(splyname1_sharedp);
            plyname3.setText(splyname2_sharedp);
            flag1="u";
        }*/



      /*  if(sright_sharedp.equals("right"))
        {
            Toast.makeText(singlesmatch.this, "Right ", Toast.LENGTH_SHORT).show();
            i3.setImageResource(R.drawable.blueimg1);
            plyname1.setText(splyname1_sharedp);
            plyname3.setText(splyname2_sharedp);
            flag1="u";
        }
        if(sleft_sharedp.equals("left"))
        {
            Toast.makeText(singlesmatch.this, "left ", Toast.LENGTH_SHORT).show();
            i1.setImageResource(R.drawable.blueimg1);
            plyname1.setText(splyname1_sharedp);
            plyname3.setText(splyname2_sharedp);
            flag1="u";
        }*/
        //rndno.setText(rno);

     /*    if(rno.equals("2"))
        {
            //Toast.makeText(getApplicationContext(), "won",Toast.LENGTH_LONG).show();

            rndno.setText("2");

        }*/
        if(rndnumber.equals("3"))
        {
            rndno.setText("3");
            editor.putString("rndno_shared", rndnumber.toString());
            editor.apply();
            rndno.setText(rndnumber);
            rnd++;
            rndnumber=String.valueOf(rnd);

            sundo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {



                    //editor.putString("plyr1score_shared", plyr1sscore.toString());
                    // editor.apply();


                    if (lflag == "y") {
                        String plyr1score_sharedp= preferences.getString("3plyr1score_shared", "");

                        p1score=Integer.parseInt(plyr1score_sharedp);
                        if(p1score<=0) {
                            Toast.makeText(getApplicationContext(),"No Points",Toast.LENGTH_SHORT).show();


                        }
                        else {
                            --p1score;
                            score1 = String.valueOf(p1score);
                            pylr1score.setText(score1);
                            editor.putString("3plyr1score_shared", score1.toString());
                            editor.apply();
                            //  p1score = Integer.valueOf(ptsleft.getText().toString());
                            //   p1score--;
                            //plyr1sscore= String.valueOf(p1score);
                            // pylr1score.setText(plyr1sscore);
                            if (flag1 == "u") {
                                plyname2.setText("");
                                i2.setVisibility(View.INVISIBLE);
                                i1.setImageResource(R.drawable.blueimg1);
                                i1.setVisibility(View.VISIBLE);
                                plyname1.setText(splyname1_sharedp);

                                plyname4.setText("");
                                plyname3.setText(splyname2_sharedp);
                                i3.setVisibility(View.INVISIBLE);
                                i4.setVisibility(View.INVISIBLE);
                                flag1 = "d";
                            } else {
                                plyname1.setText("");
                                i1.setVisibility(View.INVISIBLE);
                                i2.setImageResource(R.drawable.blueimg1);
                                i2.setVisibility(View.VISIBLE);
                                plyname2.setText(splyname1_sharedp);

                                plyname3.setText("");
                                plyname4.setText(splyname2_sharedp);
                                i3.setVisibility(View.INVISIBLE);
                                i4.setVisibility(View.INVISIBLE);

                                flag1 = "u";


                            }
                        }
                    }
                    else if(rflag=="y") {
                        String plyr2score_sharedp = preferences.getString("3plyr2score_shared", "");

                        p2score = Integer.parseInt(plyr2score_sharedp);
                        if(p2score<=0) {
                            Toast.makeText(getApplicationContext(),"No Points",Toast.LENGTH_SHORT).show();


                        }
                        else {
                            --p2score;
                            score2 = String.valueOf(p2score);
                            plyr2score.setText(score2);
                            editor.putString("3plyr2score_shared", score2.toString());
                            editor.apply();


                            if (flag1 == "u") {

                                plyname4.setText("");
                                i4.setVisibility(View.INVISIBLE);
                                i3.setImageResource(R.drawable.blueimg1);
                                i3.setVisibility(View.VISIBLE);
                                plyname3.setText(splyname2_sharedp);

                                plyname2.setText("");
                                plyname1.setText(splyname1_sharedp);
                                i1.setVisibility(View.INVISIBLE);
                                i2.setVisibility(View.INVISIBLE);
                                flag1 = "d";

                            } else {
                                plyname3.setText("");
                                i3.setVisibility(View.INVISIBLE);
                                i4.setImageResource(R.drawable.blueimg1);
                                i4.setVisibility(View.VISIBLE);
                                plyname4.setText(splyname2_sharedp);

                                plyname1.setText("");
                                plyname2.setText(splyname1_sharedp);
                                i1.setVisibility(View.INVISIBLE);
                                i2.setVisibility(View.INVISIBLE);

                                flag1 = "u";


                            }

                        }
                    }
                }
            });
            ptsleft.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // while (plyr1count <= 5) {
                    //plyr1count += plyr1count;
                    //  for(plyr1count=0;plyr1count<=5;plyr1count++)
                    // {
                    lflag = "y";
                    rflag = "n";
                    if(plyr1count==20)
                    {
                        cnt1++;
                        cnt1s = String.valueOf(cnt1);
                        editor.putString("ply1cnt_shared", cnt1s.toString());
                        editor.putString("3swinner_shared", splyname1_sharedp.toString());


                        editor.apply();
                        plyr1count++;
                       score1 = String.valueOf(plyr1count);
                        pylr1score.setText(score1);
                      //  score1 = String.valueOf(cnt1);
                      //  pylr1score.setText(score1);

                        editor.putString("3plyr1score_shared", score1.toString());
                        editor.apply();
                        Toast.makeText(getApplicationContext(),splyname1_sharedp+"won" ,Toast.LENGTH_LONG).show();

                        Intent i = new Intent(singlesmatch.this, finalscore.class);
                        startActivity(i);
                    }
                    if (plyr1count <20) {
                        ++plyr1count;

                        score1 = String.valueOf(plyr1count);
                        if(score1.equals("11"))
                        {
                            alertBuilder.setMessage("Do you want to continue")
                                    .setCancelable(false)
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            dialogInterface.cancel();
                                            if (flag1 == "u") {


                                                if (splyname1_sharedp != null) {
                                                    plyname2.setText("");
                                                    i2.setVisibility(View.INVISIBLE);
                                                    i1.setImageResource(R.drawable.blueimg1);
                                                    i1.setVisibility(View.VISIBLE);
                                                    plyname1.setText(splyname1_sharedp);

                                                    plyname4.setText("");
                                                    plyname3.setText(splyname2_sharedp);
                                                    i3.setVisibility(View.INVISIBLE);
                                                    i4.setVisibility(View.INVISIBLE);
                                                    flag1 = "d";


                                                }
                                            } else {

                                                if (splyname1_sharedp != null) {
                                                    plyname1.setText("");
                                                    i1.setVisibility(View.INVISIBLE);
                                                    i2.setImageResource(R.drawable.blueimg1);
                                                    i2.setVisibility(View.VISIBLE);
                                                    plyname2.setText(splyname1_sharedp);

                                                    plyname3.setText("");
                                                    plyname4.setText(splyname2_sharedp);
                                                    i3.setVisibility(View.INVISIBLE);
                                                    i4.setVisibility(View.INVISIBLE);

                                                    flag1 = "u";


                                                }

                                            }

//                                            moveTaskToBack(true);
//                                            android.os.Process.killProcess(android.os.Process.myPid());
//                                            System.exit(1);
//                                            Toast.makeText(singlesmatch.this, "Clicked on Yes", Toast.LENGTH_SHORT).show();
                                        }
                                    })
                                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            dialogInterface.cancel();
                                            Intent i1=new Intent(singlesmatch.this,type.class);
                                            startActivity(i1);
                                            android.os.Process.killProcess(android.os.Process.myPid());
                                            System.exit(1);
                                          //  Toast.makeText(singlesmatch.this, "Clicked on No", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                            AlertDialog alert = alertBuilder.create();
                            alert.setTitle("Interval ");
                            alert.show();

                        }
                        pylr1score.setText(score1);
                        editor.putString("3plyr1score_shared", score1.toString());
                        editor.apply();


                        if (flag1 == "u") {


                            if (splyname1_sharedp != null) {
                                plyname2.setText("");
                                i2.setVisibility(View.INVISIBLE);
                                i1.setImageResource(R.drawable.blueimg1);
                                i1.setVisibility(View.VISIBLE);
                                plyname1.setText(splyname1_sharedp);

                                plyname4.setText("");
                                plyname3.setText(splyname2_sharedp);
                                i3.setVisibility(View.INVISIBLE);
                                i4.setVisibility(View.INVISIBLE);
                                flag1 = "d";


                            }
                        } else {

                            if (splyname1_sharedp != null) {
                                plyname1.setText("");
                                i1.setVisibility(View.INVISIBLE);
                                i2.setImageResource(R.drawable.blueimg1);
                                i2.setVisibility(View.VISIBLE);
                                plyname2.setText(splyname1_sharedp);

                                plyname3.setText("");
                                plyname4.setText(splyname2_sharedp);
                                i3.setVisibility(View.INVISIBLE);
                                i4.setVisibility(View.INVISIBLE);

                                flag1 = "u";


                            }

                        }


                    }
                }
            });

            ptsright.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    rflag="y";
                    lflag="n";
                    if(plyr2count==20)
                    {
                        cnt2++;
                        cnt2s = String.valueOf(cnt2);
                        editor.putString("ply2cnt_shared", cnt2s.toString());
                        editor.putString("3swinner_shared", splyname2_sharedp.toString());
                        editor.apply();
                        plyr2count++;
                        score2 = String.valueOf(plyr2count);
                       plyr2score.setText(score2);

                      // score2 = String.valueOf(cnt2);
                         // plyr2score.setText(score2);

                        editor.putString("3plyr2score_shared", score2.toString());
                        editor.apply();
                        Toast.makeText(getApplicationContext(),splyname2_sharedp +"won",Toast.LENGTH_LONG).show();

                      Intent i = new Intent(singlesmatch.this, finalscore.class);
                     startActivity(i);
                    }
                    if (plyr2count < 20) {
                        plyr2count++;


                        score2 = String.valueOf(plyr2count);
                        if(score2.equals("11"))
                        {
                        alertBuilder.setMessage("Do you want to continue")
                                .setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.cancel();
                                        if (flag1 == "u") {


                                            if (splyname2_sharedp != null) {
                                                plyname4.setText("");
                                                i4.setVisibility(View.INVISIBLE);
                                                i3.setImageResource(R.drawable.blueimg1);
                                                i3.setVisibility(View.VISIBLE);
                                                plyname3.setText(splyname2_sharedp);

                                                plyname2.setText("");
                                                plyname1.setText(splyname1_sharedp);
                                                i1.setVisibility(View.INVISIBLE);
                                                i2.setVisibility(View.INVISIBLE);
                                                flag1 = "d";


                                            }
                                        } else {
                                            if (splyname1_sharedp != null) {
                                                plyname3.setText("");
                                                i3.setVisibility(View.INVISIBLE);
                                                i4.setImageResource(R.drawable.blueimg1);
                                                i4.setVisibility(View.VISIBLE);
                                                plyname4.setText(splyname2_sharedp);

                                                plyname1.setText("");
                                                plyname2.setText(splyname1_sharedp);
                                                i1.setVisibility(View.INVISIBLE);
                                                i2.setVisibility(View.INVISIBLE);

                                                flag1 = "u";


                                            }

                                        }
//                                        moveTaskToBack(true);
//                                        android.os.Process.killProcess(android.os.Process.myPid());
//                                        System.exit(1);
//                                        Toast.makeText(singlesmatch.this, "Clicked on Yes", Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.cancel();
                                        Intent i1=new Intent(singlesmatch.this,type.class);
                                        startActivity(i1);
                                        android.os.Process.killProcess(android.os.Process.myPid());
                                        System.exit(1);
                                       // Toast.makeText(singlesmatch.this, "Clicked on No", Toast.LENGTH_SHORT).show();
                                    }
                                });
                        AlertDialog alert = alertBuilder.create();
                        alert.setTitle("Interval");
                        alert.show();
                    }
                        plyr2score.setText(score2);
                        editor.putString("3plyr2score_shared", score2.toString());
                        editor.apply();


                        if (flag1 == "u") {


                            if (splyname2_sharedp != null) {
                                plyname4.setText("");
                                i4.setVisibility(View.INVISIBLE);
                                i3.setImageResource(R.drawable.blueimg1);
                                i3.setVisibility(View.VISIBLE);
                                plyname3.setText(splyname2_sharedp);

                                plyname2.setText("");
                                plyname1.setText(splyname1_sharedp);
                                i1.setVisibility(View.INVISIBLE);
                                i2.setVisibility(View.INVISIBLE);
                                flag1 = "d";


                            }
                        } else {
                            if (splyname1_sharedp != null) {
                                plyname3.setText("");
                                i3.setVisibility(View.INVISIBLE);
                                i4.setImageResource(R.drawable.blueimg1);
                                i4.setVisibility(View.VISIBLE);
                                plyname4.setText(splyname2_sharedp);

                                plyname1.setText("");
                                plyname2.setText(splyname1_sharedp);
                                i1.setVisibility(View.INVISIBLE);
                                i2.setVisibility(View.INVISIBLE);

                                flag1 = "u";


                            }

                        }
                    }



                }
            });



        }
        if(rndnumber.equals("2"))
        {
            rndno.setText("2");
            editor.putString("rndno_shared", rndnumber.toString());
            editor.apply();
            rndno.setText(rndnumber);
            rnd++;
            rndnumber=String.valueOf(rnd);

            sundo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {



                    //editor.putString("plyr1score_shared", plyr1sscore.toString());
                    // editor.apply();


                    if (lflag == "y") {
                        String plyr1score_sharedp = preferences.getString("2plyr1score_shared", "");

                        p1score = Integer.parseInt(plyr1score_sharedp);
                        if(p1score<=0) {
                            Toast.makeText(getApplicationContext(),"No Points",Toast.LENGTH_SHORT).show();


                        }
                        else {
                            --p1score;
                            score1 = String.valueOf(p1score);
                            pylr1score.setText(score1);
                            editor.putString("2plyr1score_shared", score1.toString());
                            editor.apply();
                            //  p1score = Integer.valueOf(ptsleft.getText().toString());
                            //   p1score--;
                            //plyr1sscore= String.valueOf(p1score);
                            // pylr1score.setText(plyr1sscore);
                            if (flag1 == "u") {
                                plyname2.setText("");
                                i4.setVisibility(View.INVISIBLE);
                                i3.setImageResource(R.drawable.blueimg1);
                                i3.setVisibility(View.VISIBLE);
                                plyname3.setText(splyname1_sharedp);

                                plyname2.setText("");
                                plyname1.setText(splyname2_sharedp);
                                i1.setVisibility(View.INVISIBLE);
                                i2.setVisibility(View.INVISIBLE);
                                flag1 = "d";
                            } else {
                                plyname1.setText("");
                                i3.setVisibility(View.INVISIBLE);
                                i4.setImageResource(R.drawable.blueimg1);
                                i4.setVisibility(View.VISIBLE);
                                plyname4.setText(splyname1_sharedp);

                                plyname1.setText("");
                                plyname2.setText(splyname2_sharedp);
                                i1.setVisibility(View.INVISIBLE);
                                i2.setVisibility(View.INVISIBLE);

                                flag1 = "u";


                            }
                        }
                    }
                    else if(rflag=="y") {
                        String plyr2score_sharedp = preferences.getString("2plyr2score_shared", "");

                        p2score = Integer.parseInt(plyr2score_sharedp);
                        if(p2score<=0) {
                            Toast.makeText(getApplicationContext(),"No Points",Toast.LENGTH_SHORT).show();


                        }
                        else {
                            --p2score;
                            score2 = String.valueOf(p2score);
                            plyr2score.setText(score2);
                            editor.putString("2plyr2score_shared", score2.toString());
                            editor.apply();


                            if (flag1 == "u") {
                                plyname2.setText("");
                                i2.setVisibility(View.INVISIBLE);
                                i1.setImageResource(R.drawable.blueimg1);
                                i1.setVisibility(View.VISIBLE);
                                plyname1.setText(splyname2_sharedp);

                                plyname2.setText("");
                                plyname1.setText(splyname1_sharedp);
                                i1.setVisibility(View.INVISIBLE);
                                i2.setVisibility(View.INVISIBLE);
                                flag1 = "d";

                            } else {
                                plyname3.setText("");
                                i3.setVisibility(View.INVISIBLE);
                                i4.setImageResource(R.drawable.blueimg1);
                                i4.setVisibility(View.VISIBLE);
                                plyname4.setText(splyname2_sharedp);

                                plyname1.setText("");
                                plyname2.setText(splyname1_sharedp);
                                i1.setVisibility(View.INVISIBLE);
                                i2.setVisibility(View.INVISIBLE);

                                flag1 = "u";


                            }

                        }
                    }
                }
            });
            ptsleft.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // while (plyr1count <= 5) {
                    //plyr1count += plyr1count;
                    //  for(plyr1count=0;plyr1count<=5;plyr1count++)
                    // {
                    lflag = "y";
                    rflag = "n";
                    if(plyr1count==20) {
                        cnt1++;
                        cnt1s = String.valueOf(cnt1);
                        editor.putString("ply1cnt_shared", cnt1s.toString());
                        editor.putString("2swinner_shared", splyname1_sharedp.toString());


                        editor.apply();
                        plyr1count++;
                        score1 = String.valueOf(plyr1count);


                        pylr1score.setText(score1);

                        editor.putString("2plyr1score_shared", score1.toString());
                        editor.apply();
                        Toast.makeText(getApplicationContext(),splyname1_sharedp+"won" ,Toast.LENGTH_LONG).show();

                        Intent i = new Intent(singlesmatch.this, round2score.class);
                        startActivity(i);
                    }
                    if (plyr1count <20) {
                        ++plyr1count;

                        score1 = String.valueOf(plyr1count);
                        if(score1.equals("11"))
                        {
                        alertBuilder.setMessage("Do you want to continue")
                                .setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.cancel();
                                        if (flag1 == "u") {


                                            if (splyname1_sharedp != null) {
                                                plyname2.setText("");
                                                i2.setVisibility(View.INVISIBLE);
                                                i1.setImageResource(R.drawable.blueimg1);
                                                i1.setVisibility(View.VISIBLE);
                                                plyname1.setText(splyname1_sharedp);

                                                plyname4.setText("");
                                                plyname3.setText(splyname2_sharedp);
                                                i3.setVisibility(View.INVISIBLE);
                                                i4.setVisibility(View.INVISIBLE);
                                                flag1 = "d";


                                            }
                                        } else {

                                            if (splyname1_sharedp != null) {
                                                plyname1.setText("");
                                                i1.setVisibility(View.INVISIBLE);
                                                i2.setImageResource(R.drawable.blueimg1);
                                                i2.setVisibility(View.VISIBLE);
                                                plyname2.setText(splyname1_sharedp);

                                                plyname3.setText("");
                                                plyname4.setText(splyname2_sharedp);
                                                i3.setVisibility(View.INVISIBLE);
                                                i4.setVisibility(View.INVISIBLE);

                                                flag1 = "u";


                                            }

                                        }

//                                        moveTaskToBack(true);
//                                        android.os.Process.killProcess(android.os.Process.myPid());
//                                        System.exit(1);
//                                        Toast.makeText(singlesmatch.this, "Clicked on Yes", Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.cancel();
                                        Intent i1=new Intent(singlesmatch.this,type.class);
                                        startActivity(i1);
                                        android.os.Process.killProcess(android.os.Process.myPid());
                                        System.exit(1);
                                       // Toast.makeText(singlesmatch.this, "Clicked on No", Toast.LENGTH_SHORT).show();
                                    }
                                });
                        AlertDialog alert = alertBuilder.create();
                        alert.setTitle("Interval ");
                        alert.show();
                    }
                        pylr1score.setText(score1);
                        editor.putString("2plyr1score_shared", score1.toString());
                        editor.apply();


                        if (flag1 == "u") {


                            if (splyname1_sharedp != null) {
                                plyname2.setText("");
                                i2.setVisibility(View.INVISIBLE);
                                i1.setImageResource(R.drawable.blueimg1);
                                i1.setVisibility(View.VISIBLE);
                                plyname1.setText(splyname1_sharedp);

                                plyname4.setText("");
                                plyname3.setText(splyname2_sharedp);
                                i3.setVisibility(View.INVISIBLE);
                                i4.setVisibility(View.INVISIBLE);
                                flag1 = "d";


                            }
                        } else {

                            if (splyname1_sharedp != null) {
                                plyname1.setText("");
                                i1.setVisibility(View.INVISIBLE);
                                i2.setImageResource(R.drawable.blueimg1);
                                i2.setVisibility(View.VISIBLE);
                                plyname2.setText(splyname1_sharedp);

                                plyname3.setText("");
                                plyname4.setText(splyname2_sharedp);
                                i3.setVisibility(View.INVISIBLE);
                                i4.setVisibility(View.INVISIBLE);

                                flag1 = "u";


                            }

                        }


                    }
                }
            });

            ptsright.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    rflag="y";
                    lflag="n";
                    if(plyr2count==20)
                    {
                        cnt2++;
                        cnt2s = String.valueOf(cnt2);
                        editor.putString("ply2cnt_shared", cnt2s.toString());
                        editor.putString("2swinner_shared", splyname2_sharedp.toString());
                        editor.apply();
                        plyr2count++;
                        score2 = String.valueOf(plyr2count);
                        plyr2score.setText(score2);

                        editor.putString("2plyr2score_shared", score2.toString());
                        editor.apply();
                        Toast.makeText(getApplicationContext(),splyname2_sharedp +"won",Toast.LENGTH_LONG).show();

                        Intent i = new Intent(singlesmatch.this, round2score.class);
                        startActivity(i);
                    }
                    if (plyr2count < 20) {
                        plyr2count++;


                        score2 = String.valueOf(plyr2count);
                        if(score2.equals("11")) {
                            alertBuilder.setMessage("Do you want to  continue")
                                    .setCancelable(false)
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            dialogInterface.cancel();
                                            if (flag1 == "u") {


                                                if (splyname2_sharedp != null) {
                                                    plyname4.setText("");
                                                    i4.setVisibility(View.INVISIBLE);
                                                    i3.setImageResource(R.drawable.blueimg1);
                                                    i3.setVisibility(View.VISIBLE);
                                                    plyname3.setText(splyname2_sharedp);

                                                    plyname2.setText("");
                                                    plyname1.setText(splyname1_sharedp);
                                                    i1.setVisibility(View.INVISIBLE);
                                                    i2.setVisibility(View.INVISIBLE);
                                                    flag1 = "d";


                                                }
                                            } else {
                                                if (splyname1_sharedp != null) {
                                                    plyname3.setText("");
                                                    i3.setVisibility(View.INVISIBLE);
                                                    i4.setImageResource(R.drawable.blueimg1);
                                                    i4.setVisibility(View.VISIBLE);
                                                    plyname4.setText(splyname2_sharedp);

                                                    plyname1.setText("");
                                                    plyname2.setText(splyname1_sharedp);
                                                    i1.setVisibility(View.INVISIBLE);
                                                    i2.setVisibility(View.INVISIBLE);

                                                    flag1 = "u";


                                                }

                                            }
//                                            moveTaskToBack(true);
//                                            android.os.Process.killProcess(android.os.Process.myPid());
//                                            System.exit(1);
//                                            Toast.makeText(singlesmatch.this, "Clicked on Yes", Toast.LENGTH_SHORT).show();
                                        }
                                    })
                                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            dialogInterface.cancel();
                                            Intent i1=new Intent(singlesmatch.this,type.class);
                                            startActivity(i1);
                                            android.os.Process.killProcess(android.os.Process.myPid());
                                            System.exit(1);
                                            //Toast.makeText(singlesmatch.this, "Clicked on No", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                            AlertDialog alert = alertBuilder.create();
                            alert.setTitle("Interval ");
                            alert.show();
                        }

                        plyr2score.setText(score2);
                        editor.putString("2plyr2score_shared", score2.toString());
                        editor.apply();


                        if (flag1 == "u") {


                            if (splyname2_sharedp != null) {
                                plyname4.setText("");
                                i4.setVisibility(View.INVISIBLE);
                                i3.setImageResource(R.drawable.blueimg1);
                                i3.setVisibility(View.VISIBLE);
                                plyname3.setText(splyname2_sharedp);

                                plyname2.setText("");
                                plyname1.setText(splyname1_sharedp);
                                i1.setVisibility(View.INVISIBLE);
                                i2.setVisibility(View.INVISIBLE);
                                flag1 = "d";


                            }
                        } else {
                            if (splyname1_sharedp != null) {
                                plyname3.setText("");
                                i3.setVisibility(View.INVISIBLE);
                                i4.setImageResource(R.drawable.blueimg1);
                                i4.setVisibility(View.VISIBLE);
                                plyname4.setText(splyname2_sharedp);

                                plyname1.setText("");
                                plyname2.setText(splyname1_sharedp);
                                i1.setVisibility(View.INVISIBLE);
                                i2.setVisibility(View.INVISIBLE);

                                flag1 = "u";


                            }

                        }
                    }



                }
            });



        }
         if(rndnumber.equals("1"))
              {
            editor.putString("rndno_shared", rndnumber.toString());
            editor.apply();
            rndno.setText(rndnumber);
            rnd++;
            rndnumber=String.valueOf(rnd);

                  sundo.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View view) {



                          //editor.putString("plyr1score_shared", plyr1sscore.toString());
                          // editor.apply();


                          if (lflag == "y") {
                              String plyr1score_sharedp= preferences.getString("plyr1score_shared", "");

                              p1score=Integer.parseInt(plyr1score_sharedp);

                              if(p1score<=0) {
                                  Toast.makeText(getApplicationContext(),"No Points",Toast.LENGTH_SHORT).show();


                              }
                              else {

                                  --p1score;
                                  score1 = String.valueOf(p1score);
                                  pylr1score.setText(score1);
                                  editor.putString("plyr1score_shared", score1.toString());
                                  editor.apply();
                                  //  p1score = Integer.valueOf(ptsleft.getText().toString());
                                  //   p1score--;
                                  //plyr1sscore= String.valueOf(p1score);
                                  // pylr1score.setText(plyr1sscore);
                                  if (flag1 == "u") {
                                      plyname2.setText("");
                                      i2.setVisibility(View.INVISIBLE);
                                      i1.setImageResource(R.drawable.blueimg1);
                                      i1.setVisibility(View.VISIBLE);
                                      plyname1.setText(splyname1_sharedp);

                                      plyname4.setText("");
                                      plyname3.setText(splyname2_sharedp);
                                      i3.setVisibility(View.INVISIBLE);
                                      i4.setVisibility(View.INVISIBLE);
                                      flag1 = "d";
                                  } else {
                                      plyname1.setText("");
                                      i1.setVisibility(View.INVISIBLE);
                                      i2.setImageResource(R.drawable.blueimg1);
                                      i2.setVisibility(View.VISIBLE);
                                      plyname2.setText(splyname1_sharedp);

                                      plyname3.setText("");
                                      plyname4.setText(splyname2_sharedp);
                                      i3.setVisibility(View.INVISIBLE);
                                      i4.setVisibility(View.INVISIBLE);

                                      flag1 = "u";


                                  }
                              }

                          }
                          else if(rflag=="y") {
                              String plyr2score_sharedp = preferences.getString("plyr2score_shared", "");

                              p2score = Integer.parseInt(plyr2score_sharedp);

                                  if(p2score<=0) {
                                      Toast.makeText(getApplicationContext(),"No Points",Toast.LENGTH_SHORT).show();


                                  }
                                  else
                                  {

                                  --p2score;
                                  score2 = String.valueOf(p2score);
                                  plyr2score.setText(score2);
                                  editor.putString("plyr2score_shared", score2.toString());
                                  editor.apply();


                                  if (flag1 == "u") {

                                      plyname4.setText("");
                                      i4.setVisibility(View.INVISIBLE);
                                      i3.setImageResource(R.drawable.blueimg1);
                                      i3.setVisibility(View.VISIBLE);
                                      plyname3.setText(splyname2_sharedp);

                                      plyname2.setText("");
                                      plyname1.setText(splyname1_sharedp);
                                      i1.setVisibility(View.INVISIBLE);
                                      i2.setVisibility(View.INVISIBLE);
                                      flag1 = "d";

                                  } else {
                                      plyname3.setText("");
                                      i3.setVisibility(View.INVISIBLE);
                                      i4.setImageResource(R.drawable.blueimg1);
                                      i4.setVisibility(View.VISIBLE);
                                      plyname4.setText(splyname2_sharedp);

                                      plyname1.setText("");
                                      plyname2.setText(splyname1_sharedp);
                                      i1.setVisibility(View.INVISIBLE);
                                      i2.setVisibility(View.INVISIBLE);

                                      flag1 = "u";


                                  }

                              }
                          }
                      }
                  });
                  ptsleft.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View view) {
                          //extraaaaaa
                         // String plyr1score_sharedp= preferences.getString("plyr1score_shared", "");

                        //  plyr1count=Integer.parseInt(plyr1score_sharedp);
                         // score1 = String.valueOf(plyr1count);
                        //  pylr1score.setText(score1);

                          // while (plyr1count <= 5) {
                          //plyr1count += plyr1count;
                          //  for(plyr1count=0;plyr1count<=5;plyr1count++)
                          // {
                          lflag = "y";
                          rflag = "n";
                          if(plyr1count==20)
                          {
                              cnt1++;
                              cnt1s = String.valueOf(cnt1);
                              editor.putString("ply1cnt_shared", cnt1s.toString());

                              editor.putString("swinner_shared", splyname1_sharedp.toString());


                              editor.apply();
                              plyr1count++;
                              score1 = String.valueOf(plyr1count);
                              pylr1score.setText(score1);

                              editor.putString("plyr1score_shared", score1.toString());
                              editor.apply();
                              Toast.makeText(getApplicationContext(),splyname1_sharedp+"won" ,Toast.LENGTH_LONG).show();

                              Intent i = new Intent(singlesmatch.this, round1score.class);
                              startActivity(i);
                          }
                          if (plyr1count <20) {


                              ++plyr1count;
                              score1 = String.valueOf(plyr1count);
                              if(score1.equals("11"))
                              {
                                  //Toast.makeText(getApplicationContext(),"yyyyywon" ,Toast.LENGTH_LONG).show();


                                  alertBuilder.setMessage("Do you want to continue")
                                          .setCancelable(false)
                                          .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                              @Override
                                              public void onClick(DialogInterface dialogInterface, int i) {
                                                  dialogInterface.cancel();
                                                  pylr1score.setText(score1);
                                                  editor.putString("plyr1score_shared", score1.toString());
                                                  editor.apply();


                                                  if (flag1 == "u") {


                                                      if (splyname1_sharedp != null) {
                                                          plyname2.setText("");
                                                          i2.setVisibility(View.INVISIBLE);
                                                          i1.setImageResource(R.drawable.blueimg1);
                                                          i1.setVisibility(View.VISIBLE);
                                                          plyname1.setText(splyname1_sharedp);

                                                          plyname4.setText("");
                                                          plyname3.setText(splyname2_sharedp);
                                                          i3.setVisibility(View.INVISIBLE);
                                                          i4.setVisibility(View.INVISIBLE);
                                                          flag1 = "d";


                                                      }
                                                  } else {

                                                      if (splyname1_sharedp != null) {
                                                          plyname1.setText("");
                                                          i1.setVisibility(View.INVISIBLE);
                                                          i2.setImageResource(R.drawable.blueimg1);
                                                          i2.setVisibility(View.VISIBLE);
                                                          plyname2.setText(splyname1_sharedp);

                                                          plyname3.setText("");
                                                          plyname4.setText(splyname2_sharedp);
                                                          i3.setVisibility(View.INVISIBLE);
                                                          i4.setVisibility(View.INVISIBLE);

                                                          flag1 = "u";


                                                      }

                                                  }


                                                  Toast.makeText(singlesmatch.this, "Clicked on Yes", Toast.LENGTH_SHORT).show();
                                              }
                                          })
                                          .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                              @Override
                                              public void onClick(DialogInterface dialogInterface, int i) {
                                                  dialogInterface.cancel();
                                                  Intent i1=new Intent(singlesmatch.this,type.class);
                                                  startActivity(i1);
                                                  android.os.Process.killProcess(android.os.Process.myPid());
                                                  System.exit(1);
                                                //  Toast.makeText(singlesmatch.this, "Clicked on No", Toast.LENGTH_SHORT).show();
                                              }
                                          });
                                  AlertDialog alert = alertBuilder.create();
                                  alert.setTitle("Interval");
                                  alert.show();


                              }
                              pylr1score.setText(score1);
                              editor.putString("plyr1score_shared", score1.toString());
                              editor.apply();


                              if (flag1 == "u") {


                                  if (splyname1_sharedp != null) {
                                      plyname2.setText("");
                                      i2.setVisibility(View.INVISIBLE);
                                      i1.setImageResource(R.drawable.blueimg1);
                                      i1.setVisibility(View.VISIBLE);
                                      plyname1.setText(splyname1_sharedp);

                                      plyname4.setText("");
                                      plyname3.setText(splyname2_sharedp);
                                      i3.setVisibility(View.INVISIBLE);
                                      i4.setVisibility(View.INVISIBLE);
                                      flag1 = "d";


                                  }
                              } else {

                                  if (splyname1_sharedp != null) {
                                      plyname1.setText("");
                                      i1.setVisibility(View.INVISIBLE);
                                      i2.setImageResource(R.drawable.blueimg1);
                                      i2.setVisibility(View.VISIBLE);
                                      plyname2.setText(splyname1_sharedp);

                                      plyname3.setText("");
                                      plyname4.setText(splyname2_sharedp);
                                      i3.setVisibility(View.INVISIBLE);
                                      i4.setVisibility(View.INVISIBLE);

                                      flag1 = "u";


                                  }

                              }


                          }
                      }
                  });

                  ptsright.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View view) {
                          rflag="y";
                          lflag="n";
                          if(plyr2count==20)
                          {
                              cnt2++;
                              cnt2s = String.valueOf(cnt2);
                              editor.putString("ply2cnt_shared", cnt2s.toString());
                              editor.putString("swinner_shared", splyname2_sharedp.toString());
                              editor.apply();
                              plyr2count++;
                              score2 = String.valueOf(plyr2count);
                              plyr2score.setText(score2);

                              editor.putString("plyr2score_shared", score2.toString());
                              editor.apply();
                              Toast.makeText(getApplicationContext(),splyname2_sharedp +"won",Toast.LENGTH_LONG).show();

                              Intent i = new Intent(singlesmatch.this, round1score.class);
                              startActivity(i);
                          }
                          if (plyr2count < 20) {
                              plyr2count++;


                              score2 = String.valueOf(plyr2count);
                              if(score2.equals("11")) {
                                  alertBuilder.setMessage("Do you want to continue?")
                                          .setCancelable(false)
                                          .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                              @Override
                                              public void onClick(DialogInterface dialogInterface, int i) {
                                                  dialogInterface.cancel();
                                                  if (flag1 == "u") {


                                                      if (splyname2_sharedp != null) {
                                                          plyname4.setText("");
                                                          i4.setVisibility(View.INVISIBLE);
                                                          i3.setImageResource(R.drawable.blueimg1);
                                                          i3.setVisibility(View.VISIBLE);
                                                          plyname3.setText(splyname2_sharedp);

                                                          plyname2.setText("");
                                                          plyname1.setText(splyname1_sharedp);
                                                          i1.setVisibility(View.INVISIBLE);
                                                          i2.setVisibility(View.INVISIBLE);
                                                          flag1 = "d";


                                                      }
                                                  } else {
                                                      if (splyname1_sharedp != null) {
                                                          plyname3.setText("");
                                                          i3.setVisibility(View.INVISIBLE);
                                                          i4.setImageResource(R.drawable.blueimg1);
                                                          i4.setVisibility(View.VISIBLE);
                                                          plyname4.setText(splyname2_sharedp);

                                                          plyname1.setText("");
                                                          plyname2.setText(splyname1_sharedp);
                                                          i1.setVisibility(View.INVISIBLE);
                                                          i2.setVisibility(View.INVISIBLE);

                                                          flag1 = "u";


                                                      }

                                                  }
                                              }

                                              //moveTaskToBack(true);
//                                                  android.os.Process.killProcess(android.os.Process.myPid());
//                                                  System.exit(1);
//                                                  Toast.makeText(singlesmatch.this, "Clicked on Yes", Toast.LENGTH_SHORT).show();
                                          })
                                          .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                              @Override
                                              public void onClick(DialogInterface dialogInterface, int i) {
                                                  dialogInterface.cancel();
                                                  Intent i1=new Intent(singlesmatch.this,type.class);
                                                  startActivity(i1);
                                                  android.os.Process.killProcess(android.os.Process.myPid());
                                                  System.exit(1);
                                                  //Toast.makeText(singlesmatch.this, "Clicked on No", Toast.LENGTH_SHORT).show();
                                              }
                                          });
                                  AlertDialog alert = alertBuilder.create();
                                  alert.setTitle("Interval");
                                  alert.show();
                              }

                              plyr2score.setText(score2);
                              editor.putString("plyr2score_shared", score2.toString());
                              editor.apply();


                              if (flag1 == "u") {


                                  if (splyname2_sharedp != null) {
                                      plyname4.setText("");
                                      i4.setVisibility(View.INVISIBLE);
                                      i3.setImageResource(R.drawable.blueimg1);
                                      i3.setVisibility(View.VISIBLE);
                                      plyname3.setText(splyname2_sharedp);

                                      plyname2.setText("");
                                      plyname1.setText(splyname1_sharedp);
                                      i1.setVisibility(View.INVISIBLE);
                                      i2.setVisibility(View.INVISIBLE);
                                      flag1 = "d";


                                  }
                              } else {
                                  if (splyname1_sharedp != null) {
                                      plyname3.setText("");
                                      i3.setVisibility(View.INVISIBLE);
                                      i4.setImageResource(R.drawable.blueimg1);
                                      i4.setVisibility(View.VISIBLE);
                                      plyname4.setText(splyname2_sharedp);

                                      plyname1.setText("");
                                      plyname2.setText(splyname1_sharedp);
                                      i1.setVisibility(View.INVISIBLE);
                                      i2.setVisibility(View.INVISIBLE);

                                      flag1 = "u";


                                  }

                              }
                          }



                      }
                  });




              }



        splyrname1.setText(splyname1_sharedp);
        splyrname2.setText(splyname2_sharedp);




        cnt1s = String.valueOf(cnt1);
        cnt2s = String.valueOf(cnt2);






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
                Intent i = new Intent(singlesmatch.this, type.class);
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
                                Toast.makeText(singlesmatch.this, "Clicked on Yes", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                Toast.makeText(singlesmatch.this, "Clicked on No", Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alert = alertBuilder.create();
                alert.setTitle("Alert ");
                alert.show();

                return true;

            case R.id.aboutus:
                Toast.makeText(getApplicationContext(),"about us",Toast.LENGTH_LONG).show();
                Intent ii = new Intent(singlesmatch.this, about.class);
                startActivity(ii);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}