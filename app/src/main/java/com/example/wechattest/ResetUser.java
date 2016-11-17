package com.example.wechattest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by wanwan on 2016/11/16.
 */

public class ResetUser extends Activity {

    private EditText resetAccount;
    private EditText oldPassword;
    private EditText newPassword1;
    private EditText newPassword2;
    private Button commit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_password);
        ActivityCollector.addActivity(this);
        resetAccount = (EditText) findViewById(R.id.reset_account);
        oldPassword = (EditText) findViewById(R.id.old_password);
        newPassword1 = (EditText) findViewById(R.id.new_password1);
        newPassword2 = (EditText) findViewById(R.id.new_password2);
        commit = (Button) findViewById(R.id.commit);

        Intent intent = getIntent();
        String account = intent.getStringExtra("resetAccount");
        resetAccount.setText(account);
        resetAccount.setSelection(account.length());

        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCollector.finishAll();
                Intent intent = new Intent(ResetUser.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
