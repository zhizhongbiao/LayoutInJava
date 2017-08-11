package cn.com.tianyudg.layoutinjava.helper.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import cn.com.tianyudg.layoutinjava.exception.WrongParameterException;
import cn.com.tianyudg.layoutinjava.helper.basic.VHelper;

/**
 * Author : WaterFlower.
 * Created on 2017/8/10.
 * Desc :
 */

public class IvHelper {
    public static final int NO_IMG_RES = -995;
    public static final Drawable NO_IMG_DRAWABL = null;
    public static final Bitmap NO_IMG_BITMAP = null;
    public static final ImageView.ScaleType NO_IMG_SCALE_TYPE = null;


    public static ImageView getIv(Context context
            , Bitmap bm) {


        return getIv(context, NO_IMG_RES, bm, NO_IMG_DRAWABL, NO_IMG_SCALE_TYPE
                , VHelper.DEFAULT_PADDING
                , View.VISIBLE
                , VHelper.NO_BG_COLOR, VHelper.NO_BG_RES, VHelper.NO_BG_DRAWABLE);
    }


    public static ImageView getIv(Context context
            , int imgRes) {

        return getIv(context, imgRes
                , VHelper.DEFAULT_PADDING);
    }


    public static ImageView getIv(Context context
            , int imgRes, int[] paddings) {


        return getIv(context, imgRes, NO_IMG_BITMAP, NO_IMG_DRAWABL, NO_IMG_SCALE_TYPE
                , paddings
                , View.VISIBLE
                , VHelper.NO_BG_COLOR, VHelper.NO_BG_RES, VHelper.NO_BG_DRAWABLE);
    }


    public static ImageView getIv(Context context
            , int imgRes, Bitmap bm, Drawable imgDrawable, ImageView.ScaleType scaleType
            , int[] paddings
            , int visibale
            , int bgColor, int bgRes, Drawable bgDrawable) {

        if (paddings == null || paddings.length < 4) {
            throw new WrongParameterException("You should give a nonull int[]@paddings whose length is 4 at least");

        }

        ImageView iv = new ImageView(context);

        iv.setPadding(paddings[0], paddings[1], paddings[2], paddings[3]);

        if (scaleType != NO_IMG_SCALE_TYPE) {
            iv.setScaleType(scaleType);
        }

        if (imgRes != NO_IMG_RES) {
            iv.setImageResource(imgRes);
        }

        if (bm != NO_IMG_BITMAP) {
            iv.setImageBitmap(bm);
        }
        if (imgDrawable != NO_IMG_DRAWABL) {
            iv.setImageDrawable(imgDrawable);
        }


        if (bgColor != VHelper.NO_BG_COLOR) {
            iv.setBackgroundColor(bgColor);
        }
        if (bgDrawable != VHelper.NO_BG_DRAWABLE) {
            iv.setBackground(bgDrawable);
        }
        if (bgRes != VHelper.NO_BG_RES) {
            iv.setBackgroundResource(bgRes);
        }

        iv.setVisibility(visibale);
        return iv;
    }
}
