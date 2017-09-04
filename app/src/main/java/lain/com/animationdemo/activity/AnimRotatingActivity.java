package lain.com.animationdemo.activity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lain.com.animationdemo.R;

/**
 * 旋转动画界面
 */
public class AnimRotatingActivity extends AppCompatActivity {

    @Bind(R.id.btn_xRotating)
    Button mBtnXRotating;
    @Bind(R.id.btn_yRotating)
    Button mBtnYRotating;
    @Bind(R.id.btn_centerRotating)
    Button mBtnCenterRotating;
    @Bind(R.id.img_rotatingCar)
    ImageView mImgRotatingCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_rotating);
        ButterKnife.bind(this);
    }

    private void initAnimation(View view,String type) {
        ObjectAnimator
                .ofFloat(view, type, 0.0F, 360.0F)//(1.执行动画的控件，2.动画类型，3.from 4.to 从多少度到多少度)
                .setDuration(500)//
                .start();
    }

    @OnClick({R.id.btn_xRotating, R.id.btn_yRotating, R.id.btn_centerRotating})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_xRotating:
                initAnimation(mImgRotatingCar,"rotationX");
                break;
            case R.id.btn_yRotating:
                initAnimation(mImgRotatingCar,"rotationY");
                break;
            case R.id.btn_centerRotating:
                initAnimation(mImgRotatingCar,"rotation");
                break;
        }
    }
}
