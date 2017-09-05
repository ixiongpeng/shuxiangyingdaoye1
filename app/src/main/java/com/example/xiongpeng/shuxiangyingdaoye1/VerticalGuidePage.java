package com.example.xiongpeng.shuxiangyingdaoye1;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

/**
 * Created by xiongpeng on 2017/9/5.
 */

public class VerticalGuidePage extends ScrollView {

    String TAG = VerticalGuidePage.class.getSimpleName();
    private int mScreenHeight;
    public VerticalGuidePage(Context context) {
        super(context);
    }

    public VerticalGuidePage(Context context, AttributeSet attrs) {
        super(context, attrs);
        mScreenHeight = context.getResources().getDisplayMetrics().heightPixels;
    }

    public VerticalGuidePage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        LinearLayout parent = (LinearLayout) getChildAt(0);
        View view0 = parent.getChildAt(0);
        view0.getLayoutParams().height = mScreenHeight;
        View view1 = parent.getChildAt(1);
        view1.getLayoutParams().height = mScreenHeight;
        View view2 = parent.getChildAt(2);
        view2.getLayoutParams().height = mScreenHeight;
        View view3 = parent.getChildAt(3);
        view3.getLayoutParams().height = mScreenHeight;
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_UP:
                int height = getScrollY() % mScreenHeight;
                if(height <= (mScreenHeight/3)){
                    smoothScrollBy(0, -height);
                }else{
                    smoothScrollBy(0, mScreenHeight - height);
                }
                return true;
        }
        return super.onTouchEvent(ev);
    }
}

//http://blog.csdn.net/Leavessilent/article/details/52443441
