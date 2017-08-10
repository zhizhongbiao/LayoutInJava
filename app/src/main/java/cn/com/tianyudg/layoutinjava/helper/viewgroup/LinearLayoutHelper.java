package cn.com.tianyudg.layoutinjava.helper.viewgroup;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;

import cn.com.tianyudg.layoutinjava.helper.basic.ViewHelper;

/**
 * Author : WaterFlower.
 * Created on 2017/8/10.
 * Desc :
 */

public class LinearLayoutHelper {

    public static final Drawable NO_DIVIDER = null;
    public static final int NO_WEIGHT_SUM = -10000;



    public static LinearLayout getLinearLayout(Context context
            , int llGravity, int orientation) {

        return getLinearLayout(context
                , llGravity, orientation
                , ViewHelper.DEFAULT_MARGINS, ViewHelper.DEFAULT_PADDING
                , NO_WEIGHT_SUM);
    }


    public static LinearLayout getLinearLayout(Context context
            , int llGravity, int orientation
            , int[] margins, int[] paddings
            , float weightSum) {

        return getLinearLayout(context
                , ViewHelper.DEFAULT_WIDTH,ViewHelper.DEFAULT_HEIGHT
                , llGravity, orientation
                , margins, paddings
                , null, 0, -1
                , View.VISIBLE
                , weightSum);
    }


    /**
     * @param context        上下文
     * @param llWidth        宽度
     * @param llHeight       高度
     * @param llGravity      重心
     * @param orientation    方向
     * @param margins        外边距
     * @param paddings       内边距
     * @param dividerDrawabl 分界线
     * @param dividerPadding 分界线大小
     * @param showDivider    边界线显示的位置
     * @param visibale       可见性
     * @param weightSum      比重总数
     */
    public static LinearLayout getLinearLayout(Context context
            , int llWidth, int llHeight
            , int llGravity, int orientation
            , int[] margins, int[] paddings
            , Drawable dividerDrawabl, int dividerPadding, int showDivider
            , int visibale
            , float weightSum) {

        if (paddings == null || paddings.length < 4) {
            throw new RuntimeException("You should give a nonull int[]@paddings whose length is 4 at least");

        }

        LinearLayout ll = new LinearLayout(context);
//        ViewGroup.MarginLayoutParams mlp = new ViewGroup.MarginLayoutParams(llWidth, llHeight);
//        mlp.setMargins(margins[0], margins[1], margins[2], margins[3]);
//        ll.setLayoutParams(mlp);

//        ll.setLayoutParams(ViewHelper.getMarginLayoutParams(ll.getParent(),llWidth, llHeight,margins));
        ll.setPadding(paddings[0], paddings[1], paddings[2], paddings[3]);
        ll.setOrientation(orientation);
        ll.setGravity(llGravity);
        if (dividerDrawabl != NO_DIVIDER) {
            ll.setDividerDrawable(dividerDrawabl);
            ll.setDividerPadding(dividerPadding);
            ll.setShowDividers(showDivider);
        }

        ll.setVisibility(visibale);
        if (weightSum > 0) {
            ll.setWeightSum(weightSum);
        }

        return ll;
    }
}
