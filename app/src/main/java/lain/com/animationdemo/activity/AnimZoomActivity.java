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
 * 缩放动画界面
 */
public class AnimZoomActivity extends AppCompatActivity {

    @Bind(R.id.btn_smallImage)
    Button mBtnSmallImage;
    @Bind(R.id.btn_bigImage)
    Button mBtnBigImage;
    @Bind(R.id.img_zoomCar)
    ImageView mImgZoomCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_zoom);
        ButterKnife.bind(this);
    }

    private void initAnimation(View view,String type,Float f) {
        if(f>1f){
            ObjectAnimator
                    .ofFloat(view, type,1f,f,1f)//把图片放大三倍，再变回
                    //(1.执行动画的控件，2.类型，3.初始点，4.放大缩小倍数，5.终点)
                    .setDuration(3000)//
                    .start();
        }else{
            ObjectAnimator
                    .ofFloat(view, type,1f,f)//把图片放大三倍，再变回,最后个参数如果不要，就直接显示放大或缩小后的图片
                    //(1.执行动画的控件，2.类型，3.初始点，4.放大缩小倍数，5.终点)
                    .setDuration(3000)//
                    .start();
        }
    }

    @OnClick({R.id.btn_smallImage, R.id.btn_bigImage})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_smallImage:
                initAnimation(mImgZoomCar,"scaleY",0.01f);
                break;
            case R.id.btn_bigImage:
                initAnimation(mImgZoomCar,"scaleY",3f);
                break;
        }
    }
}
