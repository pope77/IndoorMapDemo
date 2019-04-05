package com.example.indoormapdemo;

import android.graphics.PointF;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.piasy.biv.view.BigImageView;

/**
 * @author popeg
 */
public class MainActivity extends AppCompatActivity {

    private BigImageView bigImageView;
    private ArrowView arrowView;
    private String mapURL = "http://bmob-cdn-22675.b0.upaiyun.com/2019/04/05/a800880d40b621288011af2b386a6827.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bigImageView = findViewById(R.id.bigImageView_test);
//        arrowView = findViewById(R.id.arrowView);

        bigImageView.showImage(Uri.parse(mapURL));

//        ArrowView arrowViewTest = new ArrowView(this);
//        arrowView.addPoint(new PointF(66,77));
//        arrowView.invalidate();

    }
}
