package cn.com.tianyudg.layoutinjava.helper.basic;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import cn.com.tianyudg.layoutinjava.helper.view.IvHelper;
import cn.com.tianyudg.layoutinjava.helper.viewgroup.FlHelper;

/**
 * Author : WaterFlower.
 * Created on 2017/8/11.
 * Desc :
 */

public class UiUtil {


    public static FrameLayout logoView(Context context, ViewGroup vg, int ivW, int ivH, int bgColor, int ivRes, int[] ivMargin) {
        FrameLayout fl = FlHelper.getFl(context, bgColor);
        vg.addView(fl, VHelper.getMlp(
                vg
                , fl
                , FrameLayout.LayoutParams.MATCH_PARENT
                , FrameLayout.LayoutParams.WRAP_CONTENT
                , new int[]{20, 20, 20, 20}
        ));

        ImageView iv = IvHelper.getIv(context, ivRes);
        fl.addView(iv, VHelper.getMlp(fl,iv, ivW, ivH, ivMargin));


        return fl;
    }
}
