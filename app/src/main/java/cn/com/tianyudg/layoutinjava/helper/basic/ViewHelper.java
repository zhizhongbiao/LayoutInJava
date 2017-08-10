package cn.com.tianyudg.layoutinjava.helper.basic;

import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Author : WaterFlower.
 * Created on 2017/8/10.
 * Desc :
 */

public class ViewHelper {

    public static final int DEFAULT_WIDTH = ViewGroup.LayoutParams.MATCH_PARENT;
    public static final int DEFAULT_HEIGHT = ViewGroup.LayoutParams.WRAP_CONTENT;
    public static final int[] DEFAULT_PADDING = {0, 0, 0, 0};
    public static final int[] DEFAULT_MARGINS = {0, 0, 0, 0};


    /**
     * @param parent        父类
     * @param width         宽度
     * @param height        高度
     * @param margins       外边距
     * @param layoutGravity 布局重心
     * @return
     */
    public static ViewGroup.MarginLayoutParams getMarginLayoutParams(ViewParent parent
            , int width, int height
            , int[] margins
            , int layoutGravity, int llWeight) {

        if (margins == null || margins.length < 4) {
            throw new RuntimeException("You should give a nonull int[]@margins whose length is 4 at least");

        }


        if (parent instanceof LinearLayout) {
            LinearLayout ll = (LinearLayout) parent;
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) ll.getLayoutParams();
            lp.width = width;
            lp.height = height;
            lp.setMargins(margins[0], margins[1], margins[2], margins[3]);
            lp.gravity = layoutGravity;
            lp.weight = llWeight;
            return lp;

        } else if (parent instanceof RelativeLayout) {
            RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams)
                    ((RelativeLayout) parent).getLayoutParams();
            lp.width = width;
            lp.height = height;
            lp.setMargins(margins[0], margins[1], margins[2], margins[3]);
            //TODO 还有些属性没设置

            return lp;
        } else if (parent instanceof FrameLayout) {

            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams)
                    ((FrameLayout) parent).getLayoutParams();
            lp.width = width;
            lp.height = height;
            lp.setMargins(margins[0], margins[1], margins[2], margins[3]);
            lp.gravity = layoutGravity;
            
            return lp;
        } else if (parent instanceof ViewGroup) {
            ViewGroup.MarginLayoutParams mlp = new ViewGroup.MarginLayoutParams(width, height);
            mlp.setMargins(margins[0], margins[1], margins[2], margins[3]);
        } else {
            throw new IllegalStateException("Not support ViewParent@parent type");
        }

        return null;
    }
}
