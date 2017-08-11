package cn.com.tianyudg.layoutinjava.helper.viewgroup;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;

import cn.com.tianyudg.layoutinjava.exception.WrongParameterException;
import cn.com.tianyudg.layoutinjava.helper.basic.VHelper;

/**
 * Author : WaterFlower.
 * Created on 2017/8/10.
 * Desc :
 */

public class RlHelper {


    public static RelativeLayout getRl(Context context, int id) {


        return getRl(context
                , id
                , Gravity.NO_GRAVITY
                , VHelper.DEFAULT_PADDING
                , VHelper.NO_BG_COLOR);
    }


    public static RelativeLayout getRl(Context context
            , int id
            , int gravity
            , int[] paddings
            , int bgColor) {


        return getRl(context
                , id
                , gravity
                , paddings
                , View.VISIBLE
                , bgColor, VHelper.NO_BG_RES, VHelper.NO_BG_DRAWABLE);
    }

    public static RelativeLayout getRl(Context context
            , int id
            , int gravity
            , int[] paddings
            , int visibale
            , int bgColor, int bgRes, Drawable bgDrawable) {

        if (paddings == null || paddings.length < 4) {
            throw new WrongParameterException("You should give a nonull int[]@paddings whose length is 4 at least");

        }

        RelativeLayout rl = new RelativeLayout(context);
        rl.setId(id);
        rl.setPadding(paddings[0], paddings[1], paddings[2], paddings[3]);
        rl.setGravity(gravity);

        if (bgColor != VHelper.NO_BG_COLOR) {
            rl.setBackgroundColor(bgColor);
        }
        if (bgDrawable != VHelper.NO_BG_DRAWABLE) {
            rl.setBackground(bgDrawable);
        }
        if (bgRes != VHelper.NO_BG_RES) {
            rl.setBackgroundResource(bgRes);
        }
        rl.setVisibility(visibale);
        return rl;
    }
}
