package com.example.quiz;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.quiz.databinding.ActivitySignupBinding;
import com.example.quiz.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.Serializable;

public class SignupActivity extends AppCompatActivity {

    ActivitySignupBinding activitySignupBinding;
    FirebaseAuth auth;
    FirebaseFirestore saveData;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySignupBinding = ActivitySignupBinding.inflate(getLayoutInflater());
       // setContentView(R.layout.activity_signup);
        activitySignupBinding.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        setContentView(activitySignupBinding.getRoot());
        auth = FirebaseAuth.getInstance();
        saveData = FirebaseFirestore.getInstance();
        progressDialog = new ProgressDialog(this);
        activitySignupBinding.btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email, pass, name, number;
                email = activitySignupBinding.emailBox.getText().toString();
                pass = activitySignupBinding.password.getText().toString();
                name = activitySignupBinding.nameBox.getText().toString();
                number = activitySignupBinding.phoneNumbr.getText().toString();

                final User user = new User(name, pass, number, email);
                progressDialog.setMessage("Creating user... ");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setIndeterminate(true);
                progressDialog.show();
                auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            //System.out.println("fjal");

                            System.out.println(task.getResult());
                            String uId = task.getResult().getUser().getUid();
                            // do
                            saveData.collection("user").document(uId).set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        progressDialog.dismiss();
                                        Toast.makeText(SignupActivity.this, "Signup Sucessfull", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(new Intent(SignupActivity.this, LoginActivity.class));
                                        //intent.putExtra("user", (Serializable) user);
                                        startActivity(intent);
                                        finish();
                                    }else{
                                        Toast.makeText(SignupActivity.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                        }else{
                            progressDialog.dismiss();
                            Toast.makeText(SignupActivity.this, "Signup Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}