package com.example.narim.nova;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);


        Button Cancel = findViewById(R.id.Button_EditProfile_Cancel);
        Button Save = findViewById(R.id.Button_EditProfile_Save);

        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditProfile.this,ProfilePage.class);
                startActivity(intent);
                finish();
            }
        });

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditProfile.this,ProfilePage.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
