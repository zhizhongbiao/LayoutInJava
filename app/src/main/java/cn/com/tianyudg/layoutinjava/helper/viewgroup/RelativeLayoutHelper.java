package cn.com.tianyudg.layoutinjava.helper.viewgroup;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.RelativeLayout;

import cn.com.tianyudg.layoutinjava.exception.WrongParameterException;
import cn.com.tianyudg.layoutinjava.helper.basic.ViewHelper;

/**
 * Author : WaterFlower.
 * Created on 2017/8/10.
 * Desc :
 */

public class RelativeLayoutHelper {


    public static RelativeLayout getRelativeLayout(Context context
            , int llWidth, int llHeight
            , int rlGravity, int layoutGravity
            , int[] margins, int[] paddings
            , int visibale
            , int bgColor, int bgRes, Drawable bgDrawable) {

        if (paddings == null || paddings.length < 4) {
            throw new WrongParameterException("You should give a nonull int[]@paddings whose length is 4 at least");

        }

        RelativeLayout rl = new RelativeLayout(context);
        rl.setLayoutParams(ViewHelper.getMarginLayoutParams(rl.getParent(), rl, llWidth, llHeight, margins, layoutGravity));
        rl.setPadding(paddings[0], paddings[1], paddings[2], paddings[3]);
        rl.setGravity(rlGravity);

        if (bgColor != ViewHelper.NO_BG_COLOR) {
            rl.setBackgroundColor(bgColor);
        }
        if (bgDrawable != ViewHelper.NO_BG_DRAWABLE) {
            rl.setBackground(bgDrawable);
        }
        if (bgRes != ViewHelper.NO_BG_RES) {
            rl.setBackgroundResource(bgRes);
        }
        rl.setVisibility(visibale);
        return rl;
    }
}
