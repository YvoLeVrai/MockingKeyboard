package com.yvo.mockingkeyboard;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;

import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;

import java.util.List;

public class CustomKeyboardView extends KeyboardView {

    private Drawable drawable;
    Paint mPaint = new Paint();

    public CustomKeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        drawable = AppCompatResources.getDrawable(context, R.drawable.key);
    }

    @Override
    public void onDraw(Canvas canvas) {
        //super.onDraw(canvas);

        //Tie colored Key
        ColorStateList cTie = getResources().getColorStateList(R.color.bobTie);
        //Shirt colored Keys
        ColorStateList cShirt = getResources().getColorStateList(R.color.bobShirt);
        //Pant colored Keys
        ColorStateList cPant = getResources().getColorStateList(R.color.bobPants);
        //Body colored Keys
        ColorStateList cBody = getResources().getColorStateList(R.color.bobBody);
        //Shoes colored Keys
        ColorStateList cShoes = getResources().getColorStateList(R.color.bobShirt);

        List<Keyboard.Key> keys = getKeyboard().getKeys();

        for (Keyboard.Key key : keys) {

            mPaint.setTextAlign(Paint.Align.CENTER);
            mPaint.setTextSize(70);
            mPaint.setColor(Color.BLACK);

            switch (key.codes[0])
            {
                case 116: case 121:
                    //Tie Colored key
                    Drawable keyTie = DrawableCompat.wrap(drawable);
                    DrawableCompat.setTintList(keyTie, cTie);
                    NinePatchDrawable npTie = (NinePatchDrawable) keyTie;
                    npTie.setBounds(key.x, key.y+15, key.x + key.width, key.y + key.height);
                    npTie.draw(canvas);
                    break;
                case 113: case 119: case 101: case 114: case 117: case 105: case 111: case 112:
                    //shirt Colored keys
                    Drawable keyShirt = DrawableCompat.wrap(drawable);
                    DrawableCompat.setTintList(keyShirt, cShirt);
                    NinePatchDrawable npShirt = (NinePatchDrawable) keyShirt;
                    npShirt.setBounds(key.x, key.y+15, key.x + key.width, key.y + key.height);
                    npShirt.draw(canvas);
                    break;
                case 97: case 115: case 100: case 102: case 103: case 104: case 106: case 107: case 108:
                    //Pant Colored keys
                    Drawable keyPant = DrawableCompat.wrap(drawable);
                    DrawableCompat.setTintList(keyPant, cPant);
                    NinePatchDrawable npPant = (NinePatchDrawable) keyPant;
                    npPant.setBounds(key.x, key.y+15, key.x + key.width, key.y + key.height);
                    npPant.draw(canvas);
                    break;
                case 35: case 44: case 39: case 32: case 63: case 46: case -4:
                    //Pant Colored keys
                    Drawable keyShoes = DrawableCompat.wrap(drawable);
                    DrawableCompat.setTintList(keyShoes, cShoes);
                    NinePatchDrawable npShoes = (NinePatchDrawable) keyShoes;
                    npShoes.setBounds(key.x, key.y+15, key.x + key.width, key.y + key.height);
                    npShoes.draw(canvas);
                    //mPaint.setColor(Color.WHITE);
                    break;
                default:
                    //Body Colored keys
                    Drawable keyBody = DrawableCompat.wrap(drawable);
                    DrawableCompat.setTintList(keyBody, cBody);
                    NinePatchDrawable npBody = (NinePatchDrawable) keyBody;
                    npBody.setBounds(key.x, key.y+15, key.x + key.width, key.y + key.height);
                    npBody.draw(canvas);
                    break;
            }

            if (key.icon != null) {
                key.icon.setBounds(key.x, key.y+15, key.x + key.width, key.y + key.height);
                key.icon.draw(canvas);
            }

            if(key.label != null)
                canvas.drawText(key.label.toString(), key.x + (key.width / 2),
                        key.y + (key.height / 2) + mPaint.getTextSize()/3, mPaint);
        }
    }
}
