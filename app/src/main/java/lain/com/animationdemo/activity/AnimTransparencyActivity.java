package lain.com.animationdemo.activity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lain.com.animationdemo.R;

/**
 * 透明度动画界面
 */
public class AnimTransparencyActivity extends AppCompatActivity {
    @Bind(R.id.img_car)
    ImageView mImgCar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_anim_img);
        ButterKnife.bind(this);
    }
    private void initAnimation(View view) {
        ObjectAnimator
                .ofFloat(view, "alpha",1f,0f,1f)//(1.执行动画的控件，2.动画类型，3.from 4.to 从多少度到多少度)
                .setDuration(3000)//
                .start();
    }

    @OnClick(R.id.img_car)
    public void onClick() {
        initAnimation(mImgCar);
    }
}
