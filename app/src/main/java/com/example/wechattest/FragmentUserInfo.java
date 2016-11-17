package com.example.wechattest;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by saber on 2016/11/16.
 */

public class FragmentUserInfo extends Fragment{

    private TextView tv;

    private TextView userAccount;

    private  RoundImageView photo;

    private TableRow resetPassword;

    private  TableRow server;

    private TableRow version;

    private Button quit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_info, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tv = (TextView) getView().findViewById(R.id.title_text);
        tv.setText("个人中心");


    }

}
