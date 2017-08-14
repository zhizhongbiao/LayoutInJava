package cn.com.tianyudg.layoutinjava.helper.basic;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cn.com.tianyudg.layoutinjava.exception.WrongParameterException;

/**
 * Author : WaterFlower.
 * Created on 2017/8/10.
 * Desc :
 */

public class VHelper {

    private static final String TAG = "VHelper";
    public static final Drawable NO_BG_DRAWABLE = null;
    public static final List<Integer> NO_RL_RULE1 = null;
    public static final Map<Integer, Integer> NO_RL_RULE2 = null;
    public static final int NO_BG_COLOR = -999;
    public static final
    @DrawableRes
    int NO_BG_RES = -998;
    public static final int NO_LAYOUT_GRAVITY = -997;
    public static final int NO_WEIGHT = -996;
    public static final int TRANSPARENT_BG = Color.TRANSPARENT;


    public static final int DEFAULT_VISIABLE = View.VISIBLE;
    public static final int DEFAULT_WIDTH = ViewGroup.LayoutParams.MATCH_PARENT;
    public static final int DEFAULT_HEIGHT = ViewGroup.LayoutParams.WRAP_CONTENT;
    public static final int[] DEFAULT_PADDING = {0, 0, 0, 0};
    public static final int[] DEFAULT_MARGINS = DEFAULT_PADDING;
    private static int mViewId = Integer.MAX_VALUE - 888;


    public static ViewGroup.MarginLayoutParams getMlp(ViewGroup vg) {
        return getMlp(
                vg
                , DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_MARGINS
                , NO_LAYOUT_GRAVITY, NO_WEIGHT
                , NO_RL_RULE1, NO_RL_RULE2);
    }


    public static ViewGroup.MarginLayoutParams getMlp(ViewGroup vg
            , int width, int height, int[] margins) {
        return getMlp(
                vg
                , width, height, margins
                , NO_LAYOUT_GRAVITY, NO_WEIGHT
                , NO_RL_RULE1, NO_RL_RULE2);
    }


    public static ViewGroup.MarginLayoutParams getMlp(ViewGroup vg
            , int width, int height, int[] margins,float weight) {

        return getMlp(
                vg
                , width, height, margins
                ,NO_LAYOUT_GRAVITY, weight
                , NO_RL_RULE1, NO_RL_RULE2);

    }


    public static ViewGroup.MarginLayoutParams getMlp(ViewGroup vg
            , int width, int height, int[] margins
            , int layoutGravity) {
        return getMlp(
                vg
                , width, height, margins
                , layoutGravity, NO_WEIGHT
                , NO_RL_RULE1, NO_RL_RULE2);
    }


    public static ViewGroup.MarginLayoutParams getMlp(ViewGroup vg
            , int width, int height
            , int[] margins
            , int layoutGravity, float llWeight
            , List<Integer> rlRule1
            , Map<Integer, Integer> rlRule2) {

        if (vg == null) {
            throw new WrongParameterException("ViewGroup@vg can not be null");
        }

        if (margins == null || margins.length < 4) {
            throw new WrongParameterException("You should give a nonull int[]@margins whose length is 4 at least");
        }


        if (vg instanceof LinearLayout) {
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(width, height);
            if (layoutGravity!=NO_LAYOUT_GRAVITY)
            {
                lp.gravity = layoutGravity;
            }
            lp.weight = llWeight;
            lp.setMargins(margins[0], margins[1], margins[2], margins[3]);
            return lp;

        } else if (vg instanceof RelativeLayout) {
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(width, height);
            if (rlRule1 != NO_RL_RULE1) {
                for (Integer verb : rlRule1) {
                    lp.addRule(verb);
                }
            }

            if (rlRule2 != NO_RL_RULE2) {
                Iterator<Integer> iterator = rlRule2.keySet().iterator();
                while (iterator.hasNext()) {
                    Integer verb = iterator.next();
                    Integer relativeId = rlRule2.get(verb);
                    lp.addRule(verb, relativeId);
                    Log.e(TAG, "verb/relativeId=" + verb + "/" + relativeId);
                }
            }
            lp.setMargins(margins[0], margins[1], margins[2], margins[3]);
            return lp;
        } else if (vg instanceof FrameLayout) {
            FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(width, height);
            lp.gravity = layoutGravity;
            lp.setMargins(margins[0], margins[1], margins[2], margins[3]);
            return lp;
        } else {
            ViewGroup.MarginLayoutParams mlp = new ViewGroup.MarginLayoutParams(width, height);
            mlp.setMargins(margins[0], margins[1], margins[2], margins[3]);
            return mlp;
        }
    }


    /**
     * 将px值转换为dip或dp值，保证尺寸大小不变
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2dip(Context context, float pxValue){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
    /**
     * 将dip或dp值转换为px值，保证尺寸不变
     * @param context
     * @param dipValue
     * @return
     */
    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
    /**
     * 将px值转换为sp值，保证文字大小不变
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     * @param context
     * @param spValue
     * @return
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public static int getViewId() {
        return --mViewId;
    }


}
