package com.ycwang.moduleapp.test;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.ycwang.moduleapp.R;

/**
 * @author ycwang.
 * @date 2018-9-10.
 */
public class BitmapActivty extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bitmap);

        ImageView d = findViewById(R.id.img);

        d.setImageBitmap(createTextBitmap("  ",300,46));
    }

    private  Bitmap createTextBitmap(String text, int width, int height) {
        height = (int) (getResources().getDisplayMetrics().density*height);
        width = (int) (getResources().getDisplayMetrics().density*width);
        Bitmap textBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(textBitmap);
        Paint textPaint = new Paint();
        textPaint.setColor(Color.RED);
        canvas.drawRect(0, 0, width, height, textPaint);

        // 重新设置画笔属性，绘制文字
        textPaint.setAntiAlias(true);
        textPaint.setColor(Color.BLACK);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextSize(32);
        textPaint.setFakeBoldText(true);

        text = "1120 9955 8777 5544 965";
        // 左右缩进各60
        int textWidth = (width - 120) / (text.length());
        char[] textArr = text.toCharArray();

        int y = height / 2;
        for (int i = 0; i < textArr.length; i++) {
            int x = textWidth * i + textWidth / 2 + 60;
            canvas.drawText(String.valueOf(textArr[i]), x, y, textPaint);
        }
        canvas.save();
        canvas.restore();
        return textBitmap;
    }
}
