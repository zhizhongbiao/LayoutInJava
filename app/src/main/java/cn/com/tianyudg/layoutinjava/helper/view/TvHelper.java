package cn.com.tianyudg.layoutinjava.helper.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import cn.com.tianyudg.layoutinjava.exception.WrongParameterException;
import cn.com.tianyudg.layoutinjava.helper.basic.VHelper;

/**
 * Author : WaterFlower.
 * Created on 2017/8/10.
 * Desc :
 */

public class TvHelper {


    public static TextView getTv(Context context
            , int id
            , String text, float tvSize, int tvColor) {


        return getTv(context
                , id
                , text, tvSize, tvColor, false
                , Gravity.NO_GRAVITY
                , VHelper.DEFAULT_PADDING
                , View.VISIBLE
                , VHelper.NO_BG_COLOR, VHelper.NO_BG_RES, VHelper.NO_BG_DRAWABLE);
    }


    public static TextView getTv(Context context
            , int id
            , String text, float tvSize, int tvColor
            , int[] paddings) {


        return getTv(context
                , id
                , text, tvSize, tvColor, false
                , Gravity.NO_GRAVITY
                , paddings
                , View.VISIBLE
                , VHelper.NO_BG_COLOR, VHelper.NO_BG_RES, VHelper.NO_BG_DRAWABLE);
    }


    public static TextView getTv(Context context
            , int id
            , String text, float tvSize, int tvColor
            , int gravity
            , int[] paddings) {


        return getTv(context
                , id
                , text, tvSize, tvColor, false
                , gravity
                , paddings
                , View.VISIBLE
                , VHelper.NO_BG_COLOR, VHelper.NO_BG_RES, VHelper.NO_BG_DRAWABLE);
    }


    public static TextView getTv(Context context
            , int id
            , String text, float tvSize, int tvColor, boolean allCaps
            , int gravity
            , int[] paddings
            , int visibale
            , int bgColor, int bgRes, Drawable bgDrawable) {

        if (paddings == null || paddings.length < 4) {
            throw new WrongParameterException("You should give a nonull int[]@paddings whose length is 4 at least");

        }

        TextView tv = new TextView(context);
        tv.setId(id);
        tv.setPadding(paddings[0], paddings[1], paddings[2], paddings[3]);
        tv.setGravity(gravity);

        tv.setAllCaps(allCaps);
        tv.setTextSize(tvSize);
        tv.setTextColor(tvColor);
        tv.setText(text);


        if (bgColor != VHelper.NO_BG_COLOR) {
            tv.setBackgroundColor(bgColor);
        }
        if (bgDrawable != VHelper.NO_BG_DRAWABLE) {
            tv.setBackground(bgDrawable);
        }
        if (bgRes != VHelper.NO_BG_RES) {
            tv.setBackgroundResource(bgRes);
        }

        tv.setVisibility(visibale);
        return tv;
    }
}
