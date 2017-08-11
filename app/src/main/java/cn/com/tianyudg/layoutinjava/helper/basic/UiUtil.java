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


    public static FrameLayout logoView(Context context, ViewGroup vg
            , int flId, int flW, int flH, int[] flMargin
            , int ivId, int ivW, int ivH, int bgColor, int ivRes, int[] ivMargin) {

        FrameLayout fl = FlHelper.getFl(context, flId, bgColor);
        vg.addView(fl, VHelper.getMlp(vg, flW, flH, flMargin));

        ImageView iv = IvHelper.getIv(context, ivId, ivRes);
        fl.addView(iv, VHelper.getMlp(fl, ivW, ivH, ivMargin));

        return fl;
    }


//    public static LinearLayout loginView(Context context, ViewGroup vg
//            , int llId, int llW, int llH, int[] llMargin
//            , int ivId, int ivW, int ivH, int bgColor, int ivRes, int[] ivMargin) {
//
//        LinearLayout ll = FlHelper.getFl(context, flId, bgColor);
//        vg.addView(ll, VHelper.getMlp(vg, flW, flH, flMargin));
//
//        ImageView iv = IvHelper.getIv(context, ivId, ivRes);
//        ll.addView(iv, VHelper.getMlp(ll, ivW, ivH, ivMargin));
//
//        return ll;
//    }
}
