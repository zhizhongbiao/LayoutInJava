package cn.com.tianyudg.layoutinjava.helper.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

import cn.com.tianyudg.layoutinjava.exception.WrongParameterException;
import cn.com.tianyudg.layoutinjava.helper.basic.ViewHelper;

/**
 * Author : WaterFlower.
 * Created on 2017/8/10.
 * Desc :
 */

public class TextViewHelper {


    public static TextView getTextView(Context context
            , int width, int height
            , String text, float tvSize, int tvColor, boolean allCaps
            , int tvGravity, int layoutGravity
            , int[] margins, int[] paddings
            , int visibale
            , int bgColor, int bgRes, Drawable bgDrawable) {

        if (paddings == null || paddings.length < 4) {
            throw new WrongParameterException("You should give a nonull int[]@paddings whose length is 4 at least");

        }

        TextView tv = new TextView(context);
        tv.setLayoutParams(ViewHelper.getMarginLayoutParams(tv.getParent(), tv, width, height, margins, layoutGravity));
        tv.setPadding(paddings[0], paddings[1], paddings[2], paddings[3]);
        tv.setGravity(tvGravity);

        tv.setAllCaps(allCaps);
        tv.setTextSize(tvSize);
        tv.setTextColor(tvColor);
        tv.setText(text);


        if (bgColor != ViewHelper.NO_BG_COLOR) {
            tv.setBackgroundColor(bgColor);
        }
        if (bgDrawable != ViewHelper.NO_BG_DRAWABLE) {
            tv.setBackground(bgDrawable);
        }
        if (bgRes != ViewHelper.NO_BG_RES) {
            tv.setBackgroundResource(bgRes);
        }

        tv.setVisibility(visibale);
        return tv;
    }
}
