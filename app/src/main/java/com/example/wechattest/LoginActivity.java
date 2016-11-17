package com.example.wechattest;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.method.PasswordTransformationMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.wechattest.R.id.account;

/**
 * Created by saber on 2016/11/17.
 */

public class LoginActivity extends Activity {

    private EditText accountEdit;
    private EditText passwordEdit;
    private Button login;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        accountEdit = (EditText) findViewById(account);
        passwordEdit = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        passwordEdit.setTransformationMethod(PasswordTransformationMethod
                .getInstance());
        String acc = pref.getString("account", "");
        String pas = pref.getString("password", "");
        accountEdit.setText(acc);
        accountEdit.setSelection(acc.length());
        passwordEdit.setText(pas);
        passwordEdit.setSelection(pas.length());

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                if(true) {//提交表单，检查密码是否正确
                    editor = pref.edit();
                    editor.putString("account", account);
                    editor.putString("password", password);
                    editor.commit();
                    Intent intent = new Intent(LoginActivity.this, IndexActivity.class);
                    intent.putExtra("userAccount", account.toString());
                    startActivity(intent);
                    finish();
                }else {
                    Toast toast = Toast.makeText(LoginActivity.this, "账户或密码不正确", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
        });

    }

}
