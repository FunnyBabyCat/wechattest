package com.example.wechattest;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TableRow;
import android.widget.TextView;

public class IndexActivity extends FragmentActivity implements View.OnClickListener {

    private WebView webView = null;
    private Fragment[] mFragments;
    private RadioGroup bottomRg;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private RadioButton rbOne, rbTwo, rbThree, rbFour;
    private TextView userAccount;

    private TableRow resetPassword;
    private  TableRow server;
    private TableRow version;
    private Button quit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_index);

        Intent intent = getIntent();
        userAccount = (TextView) findViewById(R.id.user_account);
        userAccount.setText(intent.getStringExtra("userAccount"));

        ActivityCollector.addActivity(this);
        quit = (Button) findViewById(R.id.quit);

        resetPassword = (TableRow) findViewById(R.id.reset_password);
        server = (TableRow) findViewById(R.id.server) ;
        version = (TableRow) findViewById(R.id.version);

        resetPassword.setOnClickListener(this);
        server.setOnClickListener(this);
        version.setOnClickListener(this);
        quit.setOnClickListener(this);

        mFragments = new Fragment[4];

        fragmentManager = getSupportFragmentManager();

        mFragments[0] = fragmentManager.findFragmentById(R.id.fragment_kpi);
        mFragments[1] = fragmentManager.findFragmentById(R.id.fragment_select);
        mFragments[2] = fragmentManager.findFragmentById(R.id.fragment_qna);
        mFragments[3] = fragmentManager.findFragmentById(R.id.fragment_user_info);

        fragmentTransaction = fragmentManager.beginTransaction()
                .hide(mFragments[0]).hide(mFragments[1]).hide(mFragments[2]).hide(mFragments[3]);
        fragmentTransaction.show(mFragments[0]).commit();
        setFragmentIndicator();

    }

    private void setFragmentIndicator(){

        bottomRg = (RadioGroup) findViewById(R.id.bottomRg);

        rbOne = (RadioButton) findViewById(R.id.rbOne);
        rbTwo = (RadioButton) findViewById(R.id.rbTwo);
        rbThree = (RadioButton) findViewById(R.id.rbThree);
        rbFour = (RadioButton) findViewById(R.id.rbFour);


        bottomRg.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                fragmentTransaction = fragmentManager.beginTransaction()
                        .hide(mFragments[0]).hide(mFragments[1])
                        .hide(mFragments[2]).hide(mFragments[3]);
                switch (checkedId) {

                    case R.id.rbOne:
                        fragmentTransaction.show(mFragments[0]).commit();
                        webView = (WebView) findViewById(R.id.web_view_kpi);
                        break;

                    case R.id.rbTwo:
                        fragmentTransaction.show(mFragments[1]).commit();
                        webView = (WebView) findViewById(R.id.web_view_select);
                        break;

                    case R.id.rbThree:
                        fragmentTransaction.show(mFragments[2]).commit();
                        webView = (WebView) findViewById(R.id.web_view_qna);
                        break;

                    case R.id.rbFour:
                        fragmentTransaction.show(mFragments[3]).commit();
                        webView = null;
                        break;

                    default:
                        break;

                }
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if( webView == null ){
            return super.onKeyDown(keyCode, event);
        }
        if(keyCode==KeyEvent.KEYCODE_BACK){
            if(webView.canGoBack()){
                webView.goBack();//返回上一页面
                return true;
            }
            else{
                System.exit(0);//退出程序
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    public void KpiListMenu(View v){

        PopupMenu popupMenu = new PopupMenu(this , v);

        MenuInflater menuInflater = popupMenu.getMenuInflater();

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                switch (menuItem.getItemId()){

                    case R.id.jingyingkaohefenxi:
                        webView.loadUrl("http://3zrbg.free.natapp.cc/bairuiwechatbi/main/menu/module/module.do?module=bairuichart/menu/perfomance/PerformanceAppraisal.html");
                        return true;

                    case R.id.shourufenxi:
                        webView.loadUrl("http://3zrbg.free.natapp.cc/bairuiwechatbi/main/menu/module/module.do?module=bairuichart/menu/revenue/InCome.html");
                        return true;

                    case R.id.feiyongfenxi:
                        webView.loadUrl("http://3zrbg.free.natapp.cc/bairuiwechatbi/main/menu/module/module.do?module=bairuichart/menu/cost/cost.html");
                        return true;

                    case R.id.lirunfenxi:
                        webView.loadUrl("http://3zrbg.free.natapp.cc/bairuiwechatbi/main/menu/module/module.do?module=bairuichart/menu/cost/cost.html");
                        return true;

                    case R.id.guimofenxi:
                        webView.loadUrl("http://3zrbg.free.natapp.cc/bairuiwechatbi/main/menu/module/module.do?module=bairuichart/menu/business/businessanalysis_scale.html");
                        return true;

                    case R.id.zhengtiyunyingqingkuang:
                        webView.loadUrl("http://3zrbg.free.natapp.cc/bairuiwechatbi/main/menu/module/module.do?module=bairuichart/menu/overallOperation/overallOperation.html");
                        return true;

                    default:
                        return false;

                }
            }
        });

        menuInflater.inflate(R.menu.kpi_list, popupMenu.getMenu());

        popupMenu.show();

    }


    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.reset_password:
                Intent intent1 = new Intent(IndexActivity.this, ResetUser.class);
                intent1.putExtra("resetAccount", userAccount.getText().toString());
                startActivity(intent1);
                break;
            case R.id.server:
                Intent intent2 = new Intent(Intent.ACTION_DIAL);
                intent2.setData(Uri.parse("tel:10086"));
                startActivity(intent2);
                break;
            case R.id.version:
                AlertDialog.Builder dialog = new AlertDialog.Builder(IndexActivity.this);
                dialog.setTitle("版本");
                dialog.setMessage("当前版本为1.0.0, 为最新版本.");
                dialog.setCancelable(false);
                dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.show();
                break;
            case R.id.quit:
                ActivityCollector.finishAll();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

}
