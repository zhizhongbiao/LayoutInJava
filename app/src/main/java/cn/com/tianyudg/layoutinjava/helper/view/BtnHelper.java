package cn.com.tianyudg.layoutinjava.helper.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import cn.com.tianyudg.layoutinjava.exception.WrongParameterException;
import cn.com.tianyudg.layoutinjava.helper.basic.VHelper;

/**
 * Author : WaterFlower.
 * Created on 2017/8/10.
 * Desc :
 */

public class BtnHelper {


    public static Button getBtn(Context context
            , String text, float tvSize, int tvColor

            , int bgColor) {

        return getBtn(context
                , text, tvSize, tvColor, false
                , Gravity.CENTER
                , VHelper.DEFAULT_PADDING
                , View.VISIBLE
                , bgColor, VHelper.NO_BG_RES, VHelper.NO_BG_DRAWABLE);
    }

    public static Button getBtn(Context context
            , String text, float tvSize, int tvColor
            , int[] paddings
            , int bgColor) {

        return getBtn(context
                , text, tvSize, tvColor, false
                , Gravity.CENTER
                , paddings
                , View.VISIBLE
                , bgColor, VHelper.NO_BG_RES, VHelper.NO_BG_DRAWABLE);
    }


    public static Button getBtn(Context context
            , String text, float tvSize, int tvColor, boolean allCaps
            , int gravity
            , int[] paddings
            , int visibale
            , int bgColor, int bgRes, Drawable bgDrawable) {

        if (paddings == null || paddings.length < 4) {
            throw new WrongParameterException("You should give a nonull int[]@paddings whose length is 4 at least");

        }

        Button btn = new Button(context);
        btn.setPadding(paddings[0], paddings[1], paddings[2], paddings[3]);
        btn.setGravity(gravity);

        btn.setAllCaps(allCaps);
        btn.setTextSize(tvSize);
        btn.setTextColor(tvColor);
        btn.setText(text);

        if (bgColor != VHelper.NO_BG_COLOR) {
            btn.setBackgroundColor(bgColor);
        }
        if (bgDrawable != VHelper.NO_BG_DRAWABLE) {
            btn.setBackground(bgDrawable);
        }
        if (bgRes != VHelper.NO_BG_RES) {
            btn.setBackgroundResource(bgRes);
        }

        btn.setVisibility(visibale);
        return btn;
    }
}
