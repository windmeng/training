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
 * 平移动画界面
 */
public class AnimTranslationActivity extends AppCompatActivity {


    @Bind(R.id.btn_xTranslation)
    Button mBtnXTranslation;
    @Bind(R.id.btn_yTranslation)
    Button mBtnYTranslation;
    @Bind(R.id.img_translationCar)
    ImageView mImgTranslationCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_translation);
        ButterKnife.bind(this);
    }

    private void initAnimation(View view,String type) {
        float curTranslationX = view.getTranslationX();
        float curTranslationY = view.getTranslationY();
        if(type.equals("translationX")){
            ObjectAnimator
                    .ofFloat(view, type,curTranslationX, -500f,curTranslationX)//把图片左移出屏幕，再回到原点
                    //(1.执行动画的控件，2.类型，3.初始点，4.移动距离，5.终点)
                    .setDuration(3000)//
                    .start();
        }else if(type.equals("translationY")){
            ObjectAnimator
                    .ofFloat(view, type,curTranslationY, -500f,curTranslationY)//把图片上移出屏幕，再回到原点
                    .setDuration(3000)//
                    .start();
        }
    }

    @OnClick({R.id.btn_xTranslation, R.id.btn_yTranslation})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_xTranslation:
                initAnimation(mImgTranslationCar,"translationX");
                break;
            case R.id.btn_yTranslation:
                initAnimation(mImgTranslationCar,"translationY");
                break;
        }
    }
}
