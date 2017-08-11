package cn.com.tianyudg.layoutinjava.helper.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;

import cn.com.tianyudg.layoutinjava.exception.WrongParameterException;
import cn.com.tianyudg.layoutinjava.helper.basic.VHelper;

/**
 * Author : WaterFlower.
 * Created on 2017/8/10.
 * Desc :
 */

public class EtHelper {

    public static EditText getEt(Context context
            , String hint, float tvSize, int tvColor, int hintColor) {

        return getEt(context
                , hint, tvSize, tvColor, hintColor, -995
                , Gravity.CENTER
                , VHelper.DEFAULT_PADDING
                , VHelper.TRANSPARENT_BG);
    }


    public static EditText getEt(Context context
            , String hint, float tvSize, int tvColor, int hintColor, int inputType
            , int gravity
            , int[] paddings) {

        return getEt(context
                , hint, tvSize, tvColor, hintColor, inputType
                , gravity
                , paddings
                , VHelper.TRANSPARENT_BG);
    }


    public static EditText getEt(Context context
            , String hint, float tvSize, int tvColor, int hintColor, int inputType
            , int gravity
            , int[] paddings
            , int bgColor) {

        return getEt(context
                , hint, tvSize, tvColor, hintColor, inputType, false
                , gravity
                , paddings
                , View.VISIBLE
                , bgColor, VHelper.NO_BG_RES, VHelper.NO_BG_DRAWABLE);
    }


    public static EditText getEt(Context context
            , String hint, float tvSize, int tvColor, int hintColor, int inputType, boolean allCaps
            , int gravity
            , int[] paddings
            , int visibale
            , int bgColor, int bgRes, Drawable bgDrawable) {

        if (paddings == null || paddings.length < 4) {
            throw new WrongParameterException("You should give a nonull int[]@paddings whose length is 4 at least");

        }

        EditText et = new EditText(context);
        et.setPadding(paddings[0], paddings[1], paddings[2], paddings[3]);
        et.setGravity(gravity);

        et.setAllCaps(allCaps);
        et.setTextSize(tvSize);
        et.setTextColor(tvColor);

        et.setHint(hint);
        et.setHintTextColor(hintColor);
        et.setInputType(inputType);


        if (bgColor != VHelper.NO_BG_COLOR) {
            et.setBackgroundColor(bgColor);
        }
        if (bgDrawable != VHelper.NO_BG_DRAWABLE) {
            et.setBackground(bgDrawable);
        }
        if (bgRes != VHelper.NO_BG_RES) {
            et.setBackgroundResource(bgRes);
        }

        et.setVisibility(visibale);
        return et;
    }
}
