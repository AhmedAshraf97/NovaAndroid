package com.example.narim.nova;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Scene;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.signin.internal.SignInResponse;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class SignUp extends AppCompatActivity {

    TextView InvalidName;
    TextView InvalidScreenName;
    TextView InvalidEmail;
    TextView NotTheSamePassword;
    TextView text1;
    EditText Name,ScreenName,Email,Password,RePassword;

    /**
     * @param Email
     * @return True if email is valid
     * False if email is invalid
     */
    public boolean CheckEmail(String Email) {

        String ePattern = "^[a-zA-Z]+[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]*@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(Email);
        return m.matches();
    }

    /**
     * @param ScreenName
     * @return True if screen name is not empty and it is within range
     * False if screen name is empty or not valid
     */
    public boolean CheckScreenName(String ScreenName) {
        if (ScreenName.isEmpty()) {
            return false;
        }
        if (ScreenName.length() >= 15)
            return false;

        if (ScreenName.contains(" "))
            return false;

        char[] CheckScreenName = ScreenName.toCharArray();
        if (!Character.isLetter(CheckScreenName[0])) {
            return false;
        }
        return true;

    }

    /**
     * @param Name
     * @return True if screen name is not empty and it is within range
     * False if screen name is empty or not valid
     */
    public boolean CheckName(String Name){
        if(Name.length() >= 15 )
            return false;

        int SpaceCount = 0;
        char[] CheckName = Name.toCharArray();
        for( int i = 0;i<CheckName.length;i++) {
            if (Character.isWhitespace(CheckName[i]))
                SpaceCount++;
        }
        if(SpaceCount == Name.length())
            return false;

        return true;
    }

    /**
     * @param p1
     * @param p2
     * @return True if two passwords match and are withing range
     * False if two passwords don't match or are invalid
     */
    public boolean CheckPassword(String p1, String p2) {

        if (p1.length() != p2.length()) {
            return false;
        } else {

            char[] p1char = p1.toCharArray();
            char[] p2char = p2.toCharArray();
            for (int i = 0; i < p1.length(); i++) {
                if (p1char[i] != p2char[i]) {
                    return false;
                }
            }
            return true;
        }
    }


    /**
     * @return True if all data is filled and valid
     * False if any data is missing or invalid
     */
    public boolean check() {


        String Warning = null;
        boolean Check = true;
        InvalidName.setVisibility(View.INVISIBLE);
        InvalidScreenName.setVisibility(View.INVISIBLE);
        InvalidEmail.setVisibility(View.INVISIBLE);
        NotTheSamePassword.setVisibility(View.INVISIBLE);

        if (Name.getText().toString().isEmpty() || ScreenName.getText().toString().isEmpty() || Email.getText().toString().isEmpty() || Password.getText().toString().isEmpty()) {
            Warning = "Please enter your missing data ";
        } else if (Name.getText().toString().isEmpty()) {
            Warning = "Please enter your Name";
        } else if (ScreenName.getText().toString().isEmpty()) {
            Warning = "Please enter your screen Name";
        } else if (Email.getText().toString().isEmpty()) {
            Warning = "Please enter your Email";
        } else if (Password.getText().toString().isEmpty()) {
            Warning = "Please enter your Password";
        } else if ((Password.length() < 8 || Password.length() > 25 || RePassword.length() < 8 || RePassword.length() > 25))
            Warning = "Please enter valid Password";



        if(Warning!=null) {
            Toast.makeText(this, Warning, Toast.LENGTH_LONG).show();
            Check = false;
        }
        if(Name.getText().length()>15 || !CheckName(Name.getText().toString())){
            InvalidName.setVisibility(View.VISIBLE);
            Check = false;
        }
        if(ScreenName.getText().length()>15 || !CheckScreenName(ScreenName.getText().toString())){
            InvalidScreenName.setVisibility(View.VISIBLE);
            Check = false;
        }
        if(!CheckEmail(Email.getText().toString())&& Email.length()!=0){
            InvalidEmail.setVisibility(View.VISIBLE);
            Check = false;
        }
        if(!CheckPassword(Password.getText().toString(),RePassword.getText().toString())){
            NotTheSamePassword.setVisibility(View.VISIBLE);
            Check = false;

        }

        if(Check){
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        text1= findViewById(R.id.Text1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Name =(EditText) findViewById(R.id.EditText_SignUp_Name);
        ScreenName =(EditText) findViewById(R.id.EditText_SignUp_ScreenName);
        Email =(EditText) findViewById(R.id.EditText_SignUp_Email);
        Password =(EditText) findViewById(R.id.EditText_SignUp_Password);
        RePassword = (EditText) findViewById(R.id.EditText_SignUp_ReEnterPassword);
        InvalidName =(TextView) findViewById(R.id.TextView_SignUp_InvalidName);
        InvalidScreenName=(TextView) findViewById(R.id.TextView_SignUp_InvalidScreenName);
        InvalidEmail=(TextView) findViewById(R.id.TextView_SignUp_InvalidEmail);
        NotTheSamePassword=(TextView) findViewById(R.id.TextView_SignUp_InvalidPassword);

        InvalidName.setVisibility(View.INVISIBLE);
        InvalidScreenName.setVisibility(View.INVISIBLE);
        InvalidEmail.setVisibility(View.INVISIBLE);
        NotTheSamePassword.setVisibility(View.INVISIBLE);
        Button SignIn = findViewById(R.id.Button_SignUp_SignInButton);
        Button Confirm= findViewById(R.id.Button_SignUp_ConfirmButton);
        Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              boolean check = check();
              if (check==true)
              {
                    getData();
                  Intent intent = new Intent(SignUp.this,HomePage.class);
                  startActivity(intent);
                  finish();
              }

            }
        });
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this,SignIn.class);
                startActivity(intent);
                finish();
            }

        });

    }

    /**
     * Connects to the url , sends reuests and gets response
     */
    // https://3567aa04-ab9f-4d91-a98c-cdb32235902e.mock.pstmn.io/account/signup1
    private void getData(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://3.18.190.89:8080/account/signup.json",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            Log.e("success","Yes");
                            Gson gson = new Gson();
                            SignUpResponse wrapper = gson.fromJson(response, SignUpResponse.class);
                            Log.e("someOtherrrrr", response);
                            Toast.makeText(SignUp.this, response, Toast.LENGTH_LONG).show();
                            //if(wrapper.getMessage()=="OK") {
                              //  Intent i = new Intent(SignUp.this, HomePage.class);
                               // startActivity(i);
                           // }
                           // else
                            if (wrapper.getStatus()==200) {
                                SignUpResult signUpResult=wrapper.getResult();
                                Toast.makeText(SignUp.this,"Sucessful",Toast.LENGTH_LONG).show();
                                Log.e("id",signUpResult.get_id());
                                Log.e("email",signUpResult.getEmail());
                                Log.e("screenname",signUpResult.getScreenname());
                                Log.e("name",signUpResult.getName());
                            } else {
                                if(wrapper.getMessage()=="email already registered.")
                                {
                                    Toast.makeText(SignUp.this,"This email was already taken",Toast.LENGTH_LONG).show();
                                }
                                else if(wrapper.getMessage()=="screen name already registered.")
                                {
                                    Toast.makeText(SignUp.this,"ScreenName was already taken", Toast.LENGTH_LONG).show();
                                }
                                else if(wrapper.getMessage()=="\"screen_name\" length must be less than or equal to 15 characters long")
                                {
                                    Toast.makeText(SignUp.this, "Screen name length must be less than or equal to 15", Toast.LENGTH_LONG).show();
                                }
                                else if(wrapper.getMessage()=="\"email\" must be a valid email")
                                {
                                    Toast.makeText(SignUp.this,"Email not valid",Toast.LENGTH_LONG).show();
                                }
                                else if(wrapper.getMessage()=="\"screen_name\" length must be at least 3 characters long")
                                {
                                    Toast.makeText(SignUp.this, "Screen name length must be at least 3 characters", Toast.LENGTH_LONG).show();
                                }
                            }
                        } catch (Exception e) {
                            //commonCallBackInterface.onSuccess("ServicePl_VolleyError", "VolleyError");
                            e.printStackTrace();
                            Log.e("someOther", response);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // commonCallBackInterface.onSuccess("ServicePl_VolleyError", "VolleyError");
                    }
                }) {


            @Override
            public byte[] getBody() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<String, String>();
                params.put("name",Name.getText().toString());
                params.put("email",Email.getText().toString() );
                params.put("screenname",ScreenName.getText().toString());
                params.put("password",Password.getText().toString());
                return new JSONObject(params).toString().getBytes();
            }
            @Override
            public String getBodyContentType() {
                return "application/json";
            }
            //---------------------------
        };

        stringRequest.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 20 * 1000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 20 * 1000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {
                error.printStackTrace();
                //commonCallBackInterface.onSuccess("ServicePl_VolleyError", "VolleyError");
            }
        });

        VolleySingelton volleySingleton = VolleySingelton.getInstance(this);
        volleySingleton.getRequestQueue().add(stringRequest);

    }
}