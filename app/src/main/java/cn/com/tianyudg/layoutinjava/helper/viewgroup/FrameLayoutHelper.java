package cn.com.tianyudg.layoutinjava.helper.viewgroup;

import android.content.Context;
import android.widget.FrameLayout;

/**
 * Author : WaterFlower.
 * Created on 2017/8/10.
 * Desc :
 */

public class FrameLayoutHelper {


    public static FrameLayout getFrameLayout(Context context
            , int width, int height
            , int llGravity
            , int[] margins, int[] paddings
            , int visibale) {

        if (paddings == null || paddings.length < 4) {
            throw new RuntimeException("You should give a nonull int[]@paddings whose length is 4 at least");

        }

        FrameLayout fl = new FrameLayout(context);
//        ViewGroup.MarginLayoutParams mlp = new FrameLayout.MarginLayoutParams(width, height);
//        mlp.setMargins(margins[0], margins[1], margins[2], margins[3]);
//        fl.setLayoutParams(mlp);
//        fl.setLayoutParams(ViewHelper.getMarginLayoutParams(fl.getParent(),width, height, margins));
        fl.setPadding(paddings[0], paddings[1], paddings[2], paddings[3]);
        fl.setVisibility(visibale);


        return fl;
    }

}
