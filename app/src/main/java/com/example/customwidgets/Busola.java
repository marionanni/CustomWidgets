package com.example.customwidgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Busola extends RelativeLayout {

    View rootView;
    TextView valueTextView;
    View directionImage;
    private float currentDegree = 0f;
    RotateAnimation ra = null;


    public Busola(Context context) {
        super(context);
        init(context);
    }

    public Busola(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public Busola(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    public int getValue() {

        return Integer.valueOf(valueTextView.getText().toString());
    }

    public void setValue(float value) {

        valueTextView.setText(String.valueOf(value));
        ra = new RotateAnimation(currentDegree, -value, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        ra.setDuration(210);
        ra.setFillAfter(true);
        directionImage.startAnimation(ra);
        currentDegree = -value;
    }

    private void init(Context context) {
        rootView = inflate(context, R.layout.busola, this);
        valueTextView = (TextView) rootView.findViewById(R.id.valueTextView);

        directionImage = rootView.findViewById(R.id.direction);
    }

}
