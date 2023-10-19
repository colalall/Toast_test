package com.example.toast_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn1,btn2,btn3,btn4;
    private Context mcontext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=findViewById(R.id.btn_success);
        btn2=findViewById(R.id.btn_info);
        btn3=findViewById(R.id.btn_error);
        btn4=findViewById(R.id.btn_warn);

        mcontext=this;

        //按钮的点击事件 正确提示，普通提示，错误提示，警告提示
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.showSuccessToast(mcontext,"这是一个正确气泡通知");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.showInfoToast(mcontext,"这是一个普通气泡通知");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.showErrorToast(mcontext,"这是一个错误气泡通知");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.showWarningToast(mcontext,"这是一个警告气泡通知");
            }
        });
    }
    }

