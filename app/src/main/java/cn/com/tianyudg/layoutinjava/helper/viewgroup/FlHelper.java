package cn.com.tianyudg.layoutinjava.helper.viewgroup;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.view.View;
import android.widget.FrameLayout;

import cn.com.tianyudg.layoutinjava.helper.basic.VHelper;

/**
 * Author : WaterFlower.
 * Created on 2017/8/10.
 * Desc :
 */

public class FlHelper {


    public static FrameLayout getFl(Context context , int id) {

        return getFl(context
                ,id
                , VHelper.DEFAULT_PADDING
                , VHelper.NO_BG_COLOR);
    }

    public static FrameLayout getFl(Context context
            , int id
            , int bgColor) {

        return getFl(context
                ,id
                , VHelper.DEFAULT_PADDING
                , bgColor);
    }


    public static FrameLayout getFl(Context context
            , int id
            , int[] paddings
            , int bgColor) {

        return getFl(context
                ,id
                , paddings
                , View.VISIBLE
                , bgColor, VHelper.NO_BG_RES, VHelper.NO_BG_DRAWABLE);
    }

    public static FrameLayout getFl(Context context
            , int id
            , int[] paddings
            , int visibale
            , int bgColor, @DrawableRes int bgRes, Drawable bgDrawable) {

        if (paddings == null || paddings.length < 4) {
            throw new RuntimeException("You should give a nonull int[]@paddings whose length is 4 at least");

        }

        FrameLayout fl = new FrameLayout(context);
        fl.setId(id);
        fl.setPadding(paddings[0], paddings[1], paddings[2], paddings[3]);

        if (bgColor != VHelper.NO_BG_COLOR) {
            fl.setBackgroundColor(bgColor);
        }
        if (bgDrawable != VHelper.NO_BG_DRAWABLE) {
            fl.setBackground(bgDrawable);
        }
        if (bgRes != VHelper.NO_BG_RES) {
            fl.setBackgroundResource(bgRes);
        }

        fl.setVisibility(visibale);


        return fl;
    }

}
