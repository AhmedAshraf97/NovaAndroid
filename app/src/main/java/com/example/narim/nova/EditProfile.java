package com.example.narim.nova;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * The type Edit profile.
 */
public class EditProfile extends AppCompatActivity {
    /**
     * The Name.
     */
    EditText Name, /**
     * The Username.
     */
    Username, /**
     * The Bio.
     */
    Bio, /**
     * The Location.
     */
    Location;
    /**
     * The Save.
     */
    Button Save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        TextView Cancel = findViewById(R.id.Textview_EditProfile_Cancel);
        Save = findViewById(R.id.Button_EditProfile_Save);
        Name=findViewById(R.id.EditText_EditProfile_Name);
        Username=findViewById(R.id.EditText_EditProfile_UserName);
        Bio=findViewById(R.id.EditText_EditProfile_Bio);
        Location=findViewById(R.id.EditText_EditProfile_Loc);
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

        Name.addTextChangedListener(EditProfile);
        Username.addTextChangedListener(EditProfile);
        Bio.addTextChangedListener(EditProfile);
        Location.addTextChangedListener(EditProfile);
    }

    private TextWatcher EditProfile=new TextWatcher() {
        /**
         * @param charSequence
         * @param i
         * @param i1
         * @param i2
         */
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        /**
         * @param charSequence
         * @param i
         * @param i1
         * @param i2
         *Make the button apear when writing any text and make it disappear when the text is removed
         */
        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if (!(Name.getText().toString().isEmpty())||!(Username.getText().toString().isEmpty())||!(Bio.getText().toString().isEmpty())||!(Location.getText().toString().isEmpty()))
        {Save.setVisibility(View.VISIBLE);}
            if ((Name.getText().toString().isEmpty())&&(Username.getText().toString().isEmpty())&&(Bio.getText().toString().isEmpty())&&(Location.getText().toString().isEmpty()))
            {Save.setVisibility(View.INVISIBLE);}
        }

        /**
         * @param editable
         */
        @Override
        public void afterTextChanged(Editable editable) {



        }
    };

}
