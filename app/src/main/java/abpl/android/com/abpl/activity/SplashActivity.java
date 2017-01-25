package abpl.android.com.abpl.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import abpl.android.com.abpl.R;
import abpl.android.com.abpl.RefrenceWrapper;
import abpl.android.com.abpl.splashview.ParticleView;

public class SplashActivity extends AppCompatActivity {
ParticleView mParticleView;
    RefrenceWrapper mRefrenceWrapper;
    SplashActivity mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mContext=SplashActivity.this;
        mRefrenceWrapper=RefrenceWrapper.getRefrenceWrapper(mContext);
        mParticleView=(ParticleView)findViewById(R.id.app_name);

        mParticleView.startAnim();

        mParticleView.setOnParticleAnimListener(new ParticleView.ParticleAnimListener() {
            @Override
            public void onAnimationEnd() {
                Intent intent = new Intent(mContext, LoginActivity.class);
              startActivity(intent);
                finish();
            }
        });

    }
}
