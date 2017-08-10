package cn.com.tianyudg.layoutinjava.helper.basic;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
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

public class ViewHelper {

    private static final String TAG = "ViewHelper";
    public static final Drawable NO_BG_DRAWABLE = null;
    public static final List<Integer> NO_RL_RULE1 = null;
    public static final Map<Integer,Integer> NO_RL_RULE2 = null;
    public static final int NO_BG_COLOR = -999;
    public static final int NO_BG_RES = -998;
    public static final int NO_LAYOUT_GRAVITY = -997;

    public static final int NO_WEIGHT = -996;
    public static final int DEFAULT_VISIABLE = View.VISIBLE;
    public static final int DEFAULT_WIDTH = ViewGroup.LayoutParams.MATCH_PARENT;
    public static final int DEFAULT_HEIGHT = ViewGroup.LayoutParams.WRAP_CONTENT;
    public static final int[] DEFAULT_PADDING = {0, 0, 0, 0};
    public static final int[] DEFAULT_MARGINS = DEFAULT_PADDING;


    public static ViewGroup.MarginLayoutParams getMarginLayoutParams(ViewParent parent, View view) {
        return getMarginLayoutParams(parent, view
                , DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_MARGINS
                , NO_LAYOUT_GRAVITY, NO_WEIGHT
                , NO_RL_RULE1 , NO_RL_RULE2);
    }


    public static ViewGroup.MarginLayoutParams getMarginLayoutParams(ViewParent parent, View view
            , int width, int height, int[] margins) {
        return getMarginLayoutParams(parent, view
                , width, height, margins
                , NO_LAYOUT_GRAVITY, NO_WEIGHT
                , NO_RL_RULE1 , NO_RL_RULE2);
    }


    public static ViewGroup.MarginLayoutParams getMarginLayoutParams(ViewParent parent, View view
            , int width, int height, int[] margins
            , int layoutGravity) {
        return getMarginLayoutParams(parent, view
                , width, height, margins
                , layoutGravity, NO_WEIGHT
                , NO_RL_RULE1 , NO_RL_RULE2);
    }


    /**
     * @param parent        父类
     * @param width         宽度
     * @param height        高度
     * @param margins       外边距
     * @param layoutGravity 布局重心
     * @return
     */
    public static ViewGroup.MarginLayoutParams getMarginLayoutParams(ViewParent parent, View view
            , int width, int height
            , int[] margins
            , int layoutGravity, int llWeight
            , List<Integer> rlRule1
            , Map<Integer, Integer> rlRule2) {

        if (margins == null || margins.length < 4) {
            throw new WrongParameterException("You should give a nonull int[]@margins whose length is 4 at least");

        }


        if (parent instanceof LinearLayout) {
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) view.getLayoutParams();
            lp.width = width;
            lp.height = height;
            lp.setMargins(margins[0], margins[1], margins[2], margins[3]);
            lp.gravity = layoutGravity;
            lp.weight = llWeight;
            return lp;

        } else if (parent instanceof RelativeLayout) {
            RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) view.getLayoutParams();
            lp.width = width;
            lp.height = height;
            lp.setMargins(margins[0], margins[1], margins[2], margins[3]);



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


            return lp;
        } else if (parent instanceof FrameLayout) {
            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) view.getLayoutParams();
            lp.width = width;
            lp.height = height;
            lp.setMargins(margins[0], margins[1], margins[2], margins[3]);
            lp.gravity = layoutGravity;
            return lp;
        } else if (parent instanceof ViewGroup) {
            ViewGroup.MarginLayoutParams mlp = new ViewGroup.MarginLayoutParams(width, height);
            mlp.setMargins(margins[0], margins[1], margins[2], margins[3]);
            return mlp;
        } else {
            throw new IllegalStateException("Not support ViewParent@parent type");
        }
    }
}
