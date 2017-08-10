package cn.com.tianyudg.layoutinjava.helper.viewgroup;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;

import cn.com.tianyudg.layoutinjava.helper.basic.ViewHelper;

/**
 * Author : WaterFlower.
 * Created on 2017/8/10.
 * Desc :
 */

public class FrameLayoutHelper {


    public static FrameLayout getFrameLayout(Context context
            , int width, int height
            , int layoutGravity
            , int[] margins, int[] paddings
            , int visibale
            , int bgColor, int bgRes, Drawable bgDrawable) {

        if (paddings == null || paddings.length < 4) {
            throw new RuntimeException("You should give a nonull int[]@paddings whose length is 4 at least");

        }

        FrameLayout fl = new FrameLayout(context);
        fl.setLayoutParams(ViewHelper.getMarginLayoutParams(fl.getParent(),fl,width, height, margins,layoutGravity));
        fl.setPadding(paddings[0], paddings[1], paddings[2], paddings[3]);

        if (bgColor != ViewHelper.NO_BG_COLOR) {
            fl.setBackgroundColor(bgColor);
        }
        if (bgDrawable != ViewHelper.NO_BG_DRAWABLE) {
            fl.setBackground(bgDrawable);
        }
        if (bgRes != ViewHelper.NO_BG_RES) {
            fl.setBackgroundResource(bgRes);
        }

        fl.setVisibility(visibale);


        return fl;
    }

}
