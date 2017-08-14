package cn.com.tianyudg.layoutinjava.helper.basic;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.com.tianyudg.layoutinjava.helper.view.EtHelper;
import cn.com.tianyudg.layoutinjava.helper.view.IvHelper;
import cn.com.tianyudg.layoutinjava.helper.view.TvHelper;
import cn.com.tianyudg.layoutinjava.helper.viewgroup.FlHelper;
import cn.com.tianyudg.layoutinjava.helper.viewgroup.LlHelper;

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


    public static LinearLayout editView(Context context, ViewGroup vg, int etId, String tvText, String etHint) {

        LinearLayout ll = LlHelper.getLl(context, VHelper.getViewId(), LinearLayout.HORIZONTAL);
        vg.addView(ll);

        TextView tv = TvHelper.getTv(context, VHelper.getViewId(), tvText, 26, Color.parseColor("#333333"));
        ll.addView(tv, VHelper.getMlp(ll, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT
                ,new int[]{40,40,40,40} ));

        View view = new View(context);
        view.setBackgroundColor(Color.parseColor("#ebebeb"));
        ll.addView(view,VHelper.getMlp(ll,1,LinearLayout.LayoutParams.MATCH_PARENT,new int[]{0,30,0,30}));

        EditText et = EtHelper.getEt(context, etId, etHint, 26, Color.parseColor("#999999"), Color.parseColor("#999999"));
        ll.addView(et,VHelper.getMlp(ll,0,LinearLayout.LayoutParams.WRAP_CONTENT,new int[]{40,40,40,40},1f));


        return ll;
    }


}
