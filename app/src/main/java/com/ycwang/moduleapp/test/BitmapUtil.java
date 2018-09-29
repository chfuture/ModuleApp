package com.ycwang.moduleapp.test;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * @author ycwang.
 * @date 2018-9-29.
 */
public class BitmapUtil {


    /**
     * decode bitmap
     *
     * @param resources  Resource
     * @param resourceId resource id
     * @param reqWidth   目标宽
     * @param reqHeight  目标高
     * @return 返回的bitmap
     */
    public static Bitmap decodeSampleBitmapFromResource(
            Resources resources, int resourceId, int reqWidth, int reqHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, resourceId, options);
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, resourceId, options);
    }

    /**
     * calculate insamplesize
     *
     * @param options   设置
     * @param reqWidth  目标宽
     * @param reqHeight 目标高
     * @return 返回的insamplesize
     */
    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        int height = options.outHeight;
        int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            int halfHeight = height / 2;
            int halfWidth = width / 2;
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }
}
