package lain.com.animationdemo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lain.com.animationdemo.R;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.btn_translation)
    Button mBtnTranslation;
    @Bind(R.id.btn_rotating)
    Button mBtnRotating;
    @Bind(R.id.btn_zoom)
    Button mBtnZoom;
    @Bind(R.id.btn_transparency)
    Button mBtnTransparency;
    @Bind(R.id.btn_many)
    Button mBtnMany;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {

    }

    @OnClick({R.id.btn_translation, R.id.btn_rotating, R.id.btn_zoom, R.id.btn_transparency, R.id.btn_many})
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btn_translation://平移动画
                intent.setClass(this,AnimTranslationActivity.class);
                break;
            case R.id.btn_rotating://旋转动画
                intent.setClass(this,AnimRotatingActivity.class);
                break;
            case R.id.btn_zoom://缩放动画
                intent.setClass(this,AnimZoomActivity.class);
                break;
            case R.id.btn_transparency://透明度动画
                intent.setClass(this,AnimTransparencyActivity.class);
                break;
            case R.id.btn_many://组合动画
                intent.setClass(this,CombinationActivity.class);
                break;
        }
        startActivity(intent);
    }
}
