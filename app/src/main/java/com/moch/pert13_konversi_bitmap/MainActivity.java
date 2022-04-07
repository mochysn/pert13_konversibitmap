package com.moch.pert13_konversi_bitmap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebStorage;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button button;
    ImageView imageView;
    Drawable drawable;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        button = (Button) findViewById(R.id.button);
        drawable = ContextCompat.getDrawable(this, R.drawable.image);
        bitmap = ((BitmapDrawable) drawable).getBitmap();


    }

    public void convert (View view){
        Bitmap newBitmap = convertImage(bitmap);
        imageView.setImageBitmap(newBitmap);
    }

    public static Bitmap convertImage (Bitmap original){
        Bitmap finalImage = Bitmap.createBitmap(original.getWidth(),
                original.getHeight(), original.getConfig());

        int A, R, G, B;
        int colorPixel;
        int width = original.getWidth();
        int height = original.getHeight();

        for (int x = 0; x < height; x++){
            for (int y = 0; y < width; y++) {
                colorPixel = original.getPixel(x, y);
                A = Color.alpha(colorPixel);
                R = Color.red(colorPixel);
                G = Color.green(colorPixel);
                B = Color.blue(colorPixel);

                R = (R + G + B) / 3;
                G = R;
                B = R;

                finalImage.setPixel(x, y, Color.argb(A, R, G, B));

            }
        }

        return  finalImage;
    }
}