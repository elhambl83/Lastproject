package com.example.lastproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText code , username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        code = findViewById(R.id.editText);
        username = findViewById(R.id.editText2);
    }
    @Override
    protected  void onResume()
    {
        super.onResume();
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String s1 = sh.getString("username", "");
        int a = sh.getInt("code", 0);
        username.setText(s1);
        code.setText(String.valueOf(a));
    }


    @Override
    protected  void onPause(){
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("username", username.getText().toString());
        edit.putInt("code", Integer.parseInt(code.getText().toString()));
        edit.apply();
    }
}
