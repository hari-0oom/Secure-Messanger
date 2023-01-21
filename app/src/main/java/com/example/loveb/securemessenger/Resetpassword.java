package com.example.loveb.securemessenger;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class Resetpassword extends AppCompatActivity {


    EditText old,newpwd,cnfpwd;
    Button save;
    String oldpassword,newpassword,cnfpassword;
    String pwd= AES.pwdtext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpassword);

        old= findViewById(R.id.old);


        newpwd= findViewById(R.id.newp);


        cnfpwd= findViewById(R.id.cnfpwd);


        save= findViewById(R.id.save);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        save.setOnClickListener(view -> {
            oldpassword=old.getText().toString();
            newpassword=newpwd.getText().toString();
            cnfpassword=cnfpwd.getText().toString();
            if(pwd.equals(oldpassword))
            {

                if(newpassword.equals(cnfpassword))
                {
                   AES.pwdtext=newpassword;
                    System.out.println("updated successfully");
                    Toast.makeText(Resetpassword.this,"Updated Successfully!!",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else
                {
                    Toast.makeText(Resetpassword.this," password does not match",Toast.LENGTH_SHORT).show();
                    System.out.println("new password match ni karre");
                }
            }
            else
            {
                System.out.println(pwd);
                Toast.makeText(Resetpassword.this," password does not match",Toast.LENGTH_SHORT).show();
                System.out.println("purane password match ni karre");
                System.out.println(oldpassword);
            }
        });


    }
}
