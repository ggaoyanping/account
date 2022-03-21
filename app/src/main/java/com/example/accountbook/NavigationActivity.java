package com.example.accountbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class NavigationActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup radiogroup;
    private RadioButton rb_flow;

    //Fragment Object
    private Fragment fg_flow,fg_bill,fg_form,fg_center;
    private FragmentManager fManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        fManager = getSupportFragmentManager();
        radiogroup= (RadioGroup) findViewById(R.id.radiogroup);
        //RadioGroup的点击事件监听
        radiogroup.setOnCheckedChangeListener(this);

        //获取首页单选按钮，并设置为选中状态
        rb_flow= (RadioButton) findViewById(R.id.rb_flow);
        rb_flow.setChecked(true);

    }

    //Radio 点击事件设置
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction fTransaction = fManager.beginTransaction();
        hideAllFragment(fTransaction);

        switch (checkedId){
            case R.id.rb_flow:
                if (fg_flow == null){
                    //第一次需要加载Fragment
                    fg_flow = new FlowFragment();
                    fTransaction.add(R.id.content,fg_flow);
                } else{
                    fTransaction.show(fg_flow);
                }
                break;
            case R.id.rb_bill:
                if (fg_bill == null){
                    fg_bill = new BillFragment();
                    fTransaction.add(R.id.content,fg_bill);
                }else{
                    fTransaction.show(fg_bill);
                }
                break;
            case R.id.rb_form:
                if (fg_form == null){
                    fg_form = new FormFragment();
                    fTransaction.add(R.id.content,fg_form);
                }else{
                    fTransaction.show(fg_form);
                }
                break;
            case R.id.rb_center:
                if (fg_center == null){
                    fg_center = new CenterFragment();
                    fTransaction.add(R.id.content,fg_center);
                }else{
                    fTransaction.show(fg_center);
                }
                break;
        }
        fTransaction.commit();
    }

    //隐藏所有的Fragment
    private void hideAllFragment(FragmentTransaction fTransaction) {
        if(fg_flow != null)fTransaction.hide(fg_flow);
        if(fg_bill != null)fTransaction.hide(fg_bill);
        if(fg_form != null)fTransaction.hide(fg_form);
        if(fg_center != null)fTransaction.hide(fg_center);
    }
}
