package com.example.mobilegame.Util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DebugOverlayView extends View {

    private Paint paint;
    private RectF points;

    public DebugOverlayView(Context context) {
        this(context, null);
    }

    public DebugOverlayView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        this.paint = new Paint();
        this.paint.setColor(Color.RED);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(5);
    }

    public void setRect(RectF rect) {
        this.points = rect;
        invalidate();
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        if (points != null) {
            canvas.drawRect(points, paint);
        }
    }
}
