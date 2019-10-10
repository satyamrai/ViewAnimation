package com.example.viewanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btnst;
    ImageView iv,iv1;
    Animation animation;
    Drawable frameAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnst = findViewById(R.id.startanim);
        iv = findViewById(R.id.img);
        iv1 = findViewById(R.id.img1);
        iv.setBackgroundResource(R.drawable.myanim);
        frameAnimation = iv.getBackground();
        animation = AnimationUtils.loadAnimation(this,R.anim.myanimation);
        btnst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnim(view);
            }
        });
    }

    public void startAnim(View v){
        if(frameAnimation instanceof Animatable){
            ((Animatable) frameAnimation).start();
        }
    }
    public  void stopAnim(View v){
        if(((Animatable) frameAnimation).isRunning()){
            ((Animatable) frameAnimation).stop();
        }
    }

    public void doStuff(View view) {
       // iv1.startAnimation(animation);
//        RotateAnimation ra =  new RotateAnimation(0,360,10,Animation.RELATIVE_TO_PARENT);
//        ra.setRepeatCount(4);
//        ra.setDuration(4000);
//        iv1.startAnimation(ra);
        TranslateAnimation ta = new TranslateAnimation(0,100,10,150);
        ta.setDuration(4000);
        ta.setRepeatCount(4);
        iv1.startAnimation(ta);
    }

}
