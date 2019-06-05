package com.as.demo_ok25;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button butSheet;
    private Button butDialog;
    private Button butMain2;
    private Button butMain3;
    private BottomSheetBehavior mBottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


        mBottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.bottomlayout));
        mBottomSheetBehavior.setPeekHeight(0);//这个值就是屏幕上留下的高度

    }

    private void initView() {
        butSheet = (Button) findViewById(R.id.butSheet);
        butSheet.setOnClickListener(this);
        butDialog = (Button) findViewById(R.id.butDialog);
        butDialog.setOnClickListener(this);
        butMain2 = (Button) findViewById(R.id.butMain2);
        butMain2.setOnClickListener(this);
        butMain3 = (Button) findViewById(R.id.butMain3);
        butMain3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.butSheet:
                if (mBottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                    mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                } else if (mBottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
                    mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
                break;
            case R.id.butDialog:
                final BottomSheetDialog mBottomSheetDialog = new BottomSheetDialog(this);
                View view = LayoutInflater.from(this).inflate(R.layout.bottom_sheet_dialog, null, false);
                mBottomSheetDialog.setContentView(view);

                View designview = mBottomSheetDialog.getDelegate().findViewById(android.support.design.R.id.design_bottom_sheet);
                final BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(designview);

                //设置默认弹出高度
                bottomSheetBehavior.setPeekHeight(500);
                bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                    @Override
                    public void onStateChanged(@NonNull View bottomSheet, int newState) {
                        if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                            mBottomSheetDialog.dismiss();
                            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                        }
                    }

                    @Override
                    public void onSlide(@NonNull View bottomSheet, float slideOffset) {

                    }
                });
                mBottomSheetDialog.show();
                break;
            case R.id.butMain2:
                Intent intent = new Intent(this, Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.butMain3:
                Intent intent3 = new Intent(this, Main3Activity.class);
                startActivity(intent3);
                break;
        }
    }
}
