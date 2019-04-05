package com.example.indoormapdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

/**
 * @author popeg
 */
public class ArrowView extends SubsamplingScaleImageView {

    private final Paint paint = new Paint();
    private Bitmap arrow;

    private PointF sPin;

    public ArrowView(Context context) {
        super(context);
        initialise();
    }

    public void addPoint(PointF sPin){
        this.sPin = sPin;
    }

    private void initialise(){
        float density = getResources().getDisplayMetrics().density;
        arrow = intPint(R.mipmap.arrow,density);
    }

    private Bitmap intPint(int drawable, float density) {
        Bitmap pin = BitmapFactory.decodeResource(this.getResources(), drawable);
        float w = (density/420f) * pin.getWidth();
        float h = (density/420f) * pin.getHeight();
        return Bitmap.createScaledBitmap(pin, (int)w, (int)h, true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (isReady()){
            paint.setAntiAlias(true);
            Bitmap pin = arrow;
            PointF sPin = this.sPin;
            PointF vPin = new PointF();
            sourceToViewCoord(sPin,vPin);
            float vX = vPin.x - (pin.getWidth()/2);
            float vY = vPin.y - pin.getHeight();
            canvas.drawBitmap(pin,vX,vY,paint);
        }

    }
}
