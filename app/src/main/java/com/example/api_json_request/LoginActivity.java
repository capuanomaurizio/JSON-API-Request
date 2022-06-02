package com.example.api_json_request;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    private Button btnEntra, btnSearch;
    private TextView lblLogin, lblEsito;
    private EditText edtUsername, edtPassword;
    private final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$";
    private final String USERNAME_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnEntra = (Button)findViewById(R.id.btnEntra);
        btnSearch = (Button)findViewById(R.id.btnSearch);
        btnSearch.setVisibility(View.GONE);
        lblLogin = (TextView)findViewById(R.id.lblLogin);
        lblEsito = (TextView)findViewById(R.id.lblEsito);
        lblEsito.setVisibility(View.GONE);
        edtUsername = (EditText)findViewById(R.id.edtUsername);
        edtPassword = (EditText)findViewById(R.id.edtPassword);

        btnEntra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
                Matcher matcher = pattern.matcher(password);
                if(matcher.matches()){
                    pattern = Pattern.compile(USERNAME_PATTERN);
                    matcher = pattern.matcher(username);
                    if(matcher.matches()){
                        btnSearch.setVisibility(View.VISIBLE);
                        lblEsito.setVisibility(View.GONE);
                    }
                    else{
                        lblEsito.setText("Lo username non rispetta il formato richiesto");
                        lblEsito.setVisibility(View.VISIBLE);
                    }
                }
                else{
                    pattern = Pattern.compile(USERNAME_PATTERN);
                    matcher = pattern.matcher(username);
                    if(matcher.matches()){
                        lblEsito.setText("La password non rispetta il formato richiesto");
                        lblEsito.setVisibility(View.VISIBLE);
                    }
                    else{
                        lblEsito.setText("Username e password non rispettano il formato richiesto");
                        lblEsito.setVisibility(View.VISIBLE);
                    }
                }
                btnSearch.setVisibility(View.VISIBLE);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MapActivity.class);
                startActivity(i);
            }
        });
    }
}