package cn.com.tianyudg.layoutinjava.helper.viewgroup;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import cn.com.tianyudg.layoutinjava.exception.WrongParameterException;
import cn.com.tianyudg.layoutinjava.helper.basic.VHelper;

/**
 * Author : WaterFlower.
 * Created on 2017/8/10.
 * Desc :
 */

public class LlHelper {

    public static final Drawable NO_DIVIDER = null;
    public static final int NO_WEIGHT_SUM = -10000;


    public static LinearLayout getLl(Context context
            , int id
            , int orientation) {

        return getLl(context
                , id
                , Gravity.NO_GRAVITY, orientation
                , VHelper.DEFAULT_PADDING
                , NO_WEIGHT_SUM);
    }


    public static LinearLayout getLl(Context context
            , int id
            , int gravity, int orientation) {

        return getLl(context
                , id
                , gravity, orientation
                , VHelper.DEFAULT_PADDING
                , NO_WEIGHT_SUM);
    }

    public static LinearLayout getLl(Context context
            , int id
            , int gravity, int orientation, int bgColor) {

        return getLl(context
                , id
                , gravity, orientation
                , VHelper.DEFAULT_PADDING
                , null, 0, -1
                , View.VISIBLE
                , NO_WEIGHT_SUM
                , bgColor, VHelper.NO_BG_RES, VHelper.NO_BG_DRAWABLE);
    }


    public static LinearLayout getLl(Context context
            , int id
            , int gravity, int orientation
            , int[] paddings
            , float weightSum) {

        return getLl(context
                , id
                , gravity, orientation
                , paddings
                , null, 0, -1
                , View.VISIBLE
                , weightSum
                , VHelper.NO_BG_COLOR, VHelper.NO_BG_RES, VHelper.NO_BG_DRAWABLE);
    }


    /**
     * @param context         上下文
     * @param gravity         重心
     * @param orientation     方向
     * @param paddings        内边距  [左,上,右,下]
     * @param dividerDrawable 分界线
     * @param dividerPadding  分界线大小
     * @param showDivider     边界线显示的位置
     * @param visibale        可见性
     * @param weightSum       比重总数
     * @param bgColor         背景颜色
     * @param bgRes           背景资源
     * @param bgDrawable      背景Drawable
     * @return
     */
    public static LinearLayout getLl(Context context
            , int id
            , int gravity, int orientation
            , int[] paddings
            , Drawable dividerDrawable, int dividerPadding, int showDivider
            , int visibale
            , float weightSum
            , int bgColor, int bgRes, Drawable bgDrawable) {

        if (paddings == null || paddings.length < 4) {
            throw new WrongParameterException("You should give a nonull int[]@paddings whose length is 4 at least");

        }

        LinearLayout ll = new LinearLayout(context);
        ll.setId(id);
        ll.setPadding(paddings[0], paddings[1], paddings[2], paddings[3]);
        ll.setOrientation(orientation);
        ll.setGravity(gravity);
        if (dividerDrawable != NO_DIVIDER) {
            ll.setDividerDrawable(dividerDrawable);
            ll.setDividerPadding(dividerPadding);
            ll.setShowDividers(showDivider);
        }

        if (bgColor != VHelper.NO_BG_COLOR) {
            ll.setBackgroundColor(bgColor);
        }
        if (bgDrawable != VHelper.NO_BG_DRAWABLE) {
            ll.setBackground(bgDrawable);
        }
        if (bgRes != VHelper.NO_BG_RES) {
            ll.setBackgroundResource(bgRes);
        }

        if (weightSum > 0) {
            ll.setWeightSum(weightSum);
        }

        ll.setVisibility(visibale);
        return ll;
    }
}
