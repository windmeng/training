package lain.com.animationdemo.activity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lain.com.animationdemo.R;

/**
 * 组合动画
 */
public class CombinationActivity extends AppCompatActivity {

    @Bind(R.id.btn_combination1)
    Button mBtnCombination1;
    @Bind(R.id.btn_combination2)
    Button mBtnCombination2;
    @Bind(R.id.btn_combination3)
    Button mBtnCombination3;
    @Bind(R.id.img_combination)
    ImageView mImgCombination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combination);
        ButterKnife.bind(this);
    }
    private void initAnimation1(View view) {
        ObjectAnimator moveIn = ObjectAnimator.ofFloat(view, "translationX", -500f, 0f);//平移动画
        ObjectAnimator rotate = ObjectAnimator.ofFloat(view, "rotation", 0f, 360f);//旋转动画
        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f, 1f);//渐变
        AnimatorSet animatorSet = new AnimatorSet();// 千万不要写成AnimationSet，两个不同的类
        animatorSet.play(rotate).after(moveIn).with(fadeInOut);
        animatorSet.setDuration(5000);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() {//AnimatorListenerAdapter中已经封装好了动画执行的监听，需要哪个就复写就好了
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Toast.makeText(CombinationActivity.this,"结束了！",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initAnimation2(View view) {
        ObjectAnimator moveIn = ObjectAnimator.ofFloat(view, "translationY", -500f, 0f);//平移动画
        ObjectAnimator rotate = ObjectAnimator.ofFloat(view, "rotation", 0f, 360f);//旋转动画
        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(view, "alpha", 0f,1f);//渐变
        AnimatorSet animatorSet = new AnimatorSet();// 千万不要写成AnimationSet，两个不同的类
        animatorSet.play(rotate).after(moveIn).with(fadeInOut);
        animatorSet.setDuration(5000);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() {//AnimatorListenerAdapter中已经封装好了动画执行的监听，需要哪个就复写就好了
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Toast.makeText(CombinationActivity.this,"结束了！",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initAnimation3(View view) {
        ObjectAnimator moveIn = ObjectAnimator.ofFloat(view, "translationY", -500f, 0f);//平移动画
        ObjectAnimator rotate = ObjectAnimator.ofFloat(view, "rotationX", 0f, 360f);//旋转动画
        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f, 1f);//渐变
        AnimatorSet animatorSet = new AnimatorSet();// 千万不要写成AnimationSet，两个不同的类
        animatorSet.play(rotate).after(moveIn).with(fadeInOut);
        animatorSet.setDuration(5000);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() {//AnimatorListenerAdapter中已经封装好了动画执行的监听，需要哪个就复写就好了
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Toast.makeText(CombinationActivity.this,"结束了！",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initXmlAnimation(){
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(
                CombinationActivity.this,R.animator.combination);
        set.setTarget(mImgCombination);
        set.start();
    }
    @OnClick({R.id.btn_combination1, R.id.btn_combination2, R.id.btn_combination3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_combination1:
                initAnimation1(mImgCombination);
                break;
            case R.id.btn_combination2:
                initAnimation2(mImgCombination);
                break;
            case R.id.btn_combination3:
                initXmlAnimation();
//                initAnimation3(mImgCombination);
                break;
        }
    }
}
