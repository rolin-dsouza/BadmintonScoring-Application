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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class register extends AppCompatActivity {
    EditText musername,mpassword,mphonenumber,memail;
    Button mregister;
    TextView login,au;
    FirebaseAuth fAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        musername=findViewById(R.id.empname);
        memail=findViewById(R.id.empmail);
        mpassword=findViewById(R.id.password);
        mphonenumber=findViewById(R.id.number);
        mregister=findViewById(R.id.button2);
        fAuth=FirebaseAuth.getInstance();
        login=findViewById(R.id.textView4);
        au=findViewById(R.id.textView3);

        mregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=memail.getText().toString();
                String password=mpassword.getText().toString();
                String phone=mphonenumber.getText().toString();
                String username=musername.getText().toString();
                String err="";


                if(TextUtils.isEmpty(email)){
                    memail.setError("email is required");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mpassword.setError("password is empty");
                    return;
                }
                if(TextUtils.isEmpty(phone)){
                    mphonenumber.setError("phone number is empty");
                    return;
                }
                if(TextUtils.isEmpty(username)){
                    musername.setError("username is empty");
                    return;
                }
                if(password.length()<6){
                    mpassword.setError("password should be more than 6 character");
                    return;
                }
               if(phone.length()<10){
                  mphonenumber.setError("phone No. should be 10 character");
                   return;
               }
                if(phone.length()>10){
                    mphonenumber.setError("phone No. should be 10 character");
                    return;
                }

           //     if(!isValidPass(password))
                   // mpassword.setError("password should be more than 6 character");

             if(!isValidPhone(phone))
                 mphonenumber.setError("Please enter valid phone number(10 digits");

               // if(!isValidEmail(email))
                 //   memail.setError("Please enter valid Email(domain name .com|.edu|.in|.org");
               // memail.setError("email is required");

//          if(phone.length()<6){
//                    mpassword.setError("password should be more than 6 character");
//                    return;
//                }


                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if( task.isSuccessful())
                        {

                            String name=musername.getText().toString();
                            String email=memail.getText().toString();
                            String password=mpassword.getText().toString();
                            String number=mphonenumber.getText().toString();
                            firebaseDatabase=FirebaseDatabase.getInstance();
                            myRef=firebaseDatabase.getReference("users");
                            myRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("username").setValue(name);
                            myRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Email").setValue(email);
                            myRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Password").setValue(password);

                            myRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("number").setValue(number);
                            firebaseDatabase=FirebaseDatabase.getInstance();

                            myRef= firebaseDatabase.getReference("Leave Record");
                            myRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("leave count").setValue(0);


                            Toast.makeText(register.this,"User created",Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(register.this,MainActivity.class);
                            startActivity(i);
                        }
                        else
                        {



                            Toast.makeText(register.this,"Failed",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent d=new Intent(register.this,MainActivity.class);
                startActivity(d);
            }
        });

    }
    public static boolean isValidPass(String str) {
        String regex = "^[a-zA-z0-9]{6,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        if(matcher.matches())
            return true;
        return false;
    }

    public static boolean isValidPhone(String str) {
        String regex = "^\\d{10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        if(matcher.matches())
            return true;
        return false;
    }

    public static boolean isValidEmail(String str) {
        String regex = "[a-zA-Z0-9._-]+@[a-z]+\\.(com|edu|in|org)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        if(matcher.matches())
            return true;
        return false;
    }
}
//   /* @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater=getMenuInflater();
//        inflater.inflate(R.menu.menu1,menu);
//        return true;
//    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        switch (item.getItemId())
//        {
//            case R.id.exit:
//                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
//
//                alertBuilder.setMessage("Do you want to close this application")
//                        .setCancelable(false)
//                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                dialogInterface.cancel();
//                                moveTaskToBack(true);
//                                android.os.Process.killProcess(android.os.Process.myPid());
//                                System.exit(1);
//                                Toast.makeText(register.this, "Clicked on Yes", Toast.LENGTH_SHORT).show();
//                            }
//                        })
//                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                dialogInterface.cancel();
//                                Toast.makeText(register.this, "Clicked on No", Toast.LENGTH_SHORT).show();
//                            }
//                        });
//                AlertDialog alert = alertBuilder.create();
//                alert.setTitle("Alert ");
//                alert.show();
//
//                return true;
//            case R.id.aboutus:
//                Toast.makeText(getApplicationContext(),"about us",Toast.LENGTH_LONG).show();
//                return true;
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//
//}*/