package cn.com.tianyudg.layoutinjava.helper.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.EditText;

import cn.com.tianyudg.layoutinjava.exception.WrongParameterException;
import cn.com.tianyudg.layoutinjava.helper.basic.ViewHelper;

/**
 * Author : WaterFlower.
 * Created on 2017/8/10.
 * Desc :
 */

public class EditTextHelper {


    public static EditText getEditText(Context context
            , int width, int height
            , String hint, float tvSize, int tvColor, int hintColor, int inputType, boolean allCaps
            , int tvGravity, int layoutGravity
            , int[] margins, int[] paddings
            , int visibale
            , int bgColor, int bgRes, Drawable bgDrawable) {

        if (paddings == null || paddings.length < 4) {
            throw new WrongParameterException("You should give a nonull int[]@paddings whose length is 4 at least");

        }

        EditText et = new EditText(context);
        et.setLayoutParams(ViewHelper.getMarginLayoutParams(et.getParent(), et, width, height, margins, layoutGravity));
        et.setPadding(paddings[0], paddings[1], paddings[2], paddings[3]);
        et.setGravity(tvGravity);

        et.setAllCaps(allCaps);
        et.setTextSize(tvSize);
        et.setTextColor(tvColor);

        et.setHint(hint);
        et.setHintTextColor(hintColor);
        et.setInputType(inputType);


        if (bgColor != ViewHelper.NO_BG_COLOR) {
            et.setBackgroundColor(bgColor);
        }
        if (bgDrawable != ViewHelper.NO_BG_DRAWABLE) {
            et.setBackground(bgDrawable);
        }
        if (bgRes != ViewHelper.NO_BG_RES) {
            et.setBackgroundResource(bgRes);
        }

        et.setVisibility(visibale);
        return et;
    }
}
