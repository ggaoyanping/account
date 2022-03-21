package com.example.accountbook;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private TextView register;//立即注册
    private TextView forget_password;//忘记密码
    private EditText login_number;//登陆账号
    private EditText login_password;//登陆密码
    private Button login_button;//登陆按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        click();

    }
    //初始化控件
    public void init(){
        login_number=findViewById(R.id.login_number);
        login_password=findViewById(R.id.login_password);
        login_button=findViewById(R.id.login_button);
        register=findViewById(R.id.login_reg);
        forget_password=findViewById(R.id.forget);
    }
    //点击跳转
    public void click(){
        //立即注册跳转
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到注册界面
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        //忘记密码跳转
        forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到忘记密码界面
                Intent intent=new Intent(LoginActivity.this,ForgetPasswordActivity.class);
                startActivity(intent);
            }
        });
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //跳转到主界面
                Intent intent=new Intent(LoginActivity.this,NavigationActivity.class);
                startActivity(intent);
            }
        });
    }
}
