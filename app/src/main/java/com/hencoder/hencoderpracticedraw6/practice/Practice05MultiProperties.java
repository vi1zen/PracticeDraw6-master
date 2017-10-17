package com.hencoder.hencoderpracticedraw6.practice;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.ImageView;

import com.hencoder.hencoderpracticedraw6.R;

public class Practice05MultiProperties extends ConstraintLayout {
    Button animateBt;
    ImageView imageView;
    boolean flag = true;

    public Practice05MultiProperties(Context context) {
        super(context);
    }

    public Practice05MultiProperties(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice05MultiProperties(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setScaleX(0);
        imageView.setScaleY(0);
        imageView.setAlpha(0f);
        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 在这里处理点击事件，同时对多个属性做动画
                if(flag){
                    AnimatorSet animatorSet = new AnimatorSet();
                    ObjectAnimator animator1 = ObjectAnimator.ofFloat(imageView, "scaleX", 1f);
                    ObjectAnimator animator2 = ObjectAnimator.ofFloat(imageView, "scaleY", 1f);
                    ObjectAnimator animator3 = ObjectAnimator.ofFloat(imageView, "alpha", 1f);
                    ObjectAnimator animator4 = ObjectAnimator.ofFloat(imageView, "translationX", 600f);
                    ObjectAnimator animator5 = ObjectAnimator.ofFloat(imageView, "rotation", 360f);
                    animatorSet.playTogether(animator1,animator2,animator3,animator4,animator5);
                    animatorSet.setDuration(500);
                    animatorSet.start();
                    flag = false;
                }else {
                    AnimatorSet animatorSet = new AnimatorSet();
                    ObjectAnimator animator1 = ObjectAnimator.ofFloat(imageView, "scaleX", 0f);
                    ObjectAnimator animator2 = ObjectAnimator.ofFloat(imageView, "scaleY", 0f);
                    ObjectAnimator animator3 = ObjectAnimator.ofFloat(imageView, "alpha", 0f);
                    ObjectAnimator animator4 = ObjectAnimator.ofFloat(imageView, "translationX", 0f);
                    ObjectAnimator animator5 = ObjectAnimator.ofFloat(imageView, "rotation", 0f);
                    animatorSet.playTogether(animator1,animator2,animator3,animator4,animator5);
                    animatorSet.setDuration(500);
                    animatorSet.start();
                    flag = true;
                }

            }
        });
    }
}
