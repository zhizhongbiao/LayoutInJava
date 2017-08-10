package cn.com.tianyudg.layoutinjava.helper.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.Button;

import cn.com.tianyudg.layoutinjava.exception.WrongParameterException;
import cn.com.tianyudg.layoutinjava.helper.basic.ViewHelper;

/**
 * Author : WaterFlower.
 * Created on 2017/8/10.
 * Desc :
 */

public class ButtonHelper {


    public static Button getButton(Context context
            , int width, int height
            , String text, float tvSize, int tvColor, boolean allCaps
            , int tvGravity, int layoutGravity
            , int[] margins, int[] paddings
            , int visibale
            , int bgColor, int bgRes, Drawable bgDrawable) {

        if (paddings == null || paddings.length < 4) {
            throw new WrongParameterException("You should give a nonull int[]@paddings whose length is 4 at least");

        }

        Button btn = new Button(context);
        btn.setLayoutParams(ViewHelper.getMarginLayoutParams(btn.getParent(), btn, width, height, margins, layoutGravity));
        btn.setPadding(paddings[0], paddings[1], paddings[2], paddings[3]);
        btn.setGravity(tvGravity);

        btn.setAllCaps(allCaps);
        btn.setTextSize(tvSize);
        btn.setTextColor(tvColor);
        btn.setText(text);

        if (bgColor != ViewHelper.NO_BG_COLOR) {
            btn.setBackgroundColor(bgColor);
        }
        if (bgDrawable != ViewHelper.NO_BG_DRAWABLE) {
            btn.setBackground(bgDrawable);
        }
        if (bgRes != ViewHelper.NO_BG_RES) {
            btn.setBackgroundResource(bgRes);
        }

        btn.setVisibility(visibale);
        return btn;
    }
}
