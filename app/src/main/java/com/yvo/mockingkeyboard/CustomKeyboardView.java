package com.yvo.mockingkeyboard;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;
import android.view.KeyEvent;

import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.preference.PreferenceManager;

import java.util.List;

public class CustomKeyboardView extends KeyboardView {

    private SharedPreferences settings;
    private Drawable drawable;
    Paint mPaint = new Paint();
    Canvas canvas;

    public CustomKeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        drawable = AppCompatResources.getDrawable(context, R.drawable.key);
    }

    @Override
    public void onDraw(Canvas canvas) {

        settings = PreferenceManager.getDefaultSharedPreferences(getContext());
        this.canvas = canvas;

        ColorStateList rbobTie = getResources().getColorStateList(R.color.bobTie);
        ColorStateList rbobTiePress = getResources().getColorStateList(R.color.bobTie);
        ColorStateList rbobShirt = getResources().getColorStateList(R.color.bobTie);
        ColorStateList rbobShirtPress = getResources().getColorStateList(R.color.bobTie);
        ColorStateList rbobPants = getResources().getColorStateList(R.color.bobTie);
        ColorStateList rbobPantsPress = getResources().getColorStateList(R.color.bobTie);
        ColorStateList rbobBody = getResources().getColorStateList(R.color.bobTie);
        ColorStateList rbobBodyPress = getResources().getColorStateList(R.color.bobTie);
        ColorStateList rbobShoes = getResources().getColorStateList(R.color.bobTie);
        ColorStateList rbobShoesPress = getResources().getColorStateList(R.color.bobTie);
        int fontColor = Color.BLACK;
        
        switch (settings.getString("keyboardStyle", "contrasted"))
        {
            case "contrasted":
                //Tie colored Key
                rbobTie = getResources().getColorStateList(R.color.bobTie);
                rbobTiePress = getResources().getColorStateList(R.color.bobTiePress);
                //Shirt colored Keys
                rbobShirt = getResources().getColorStateList(R.color.bobShirt);
                rbobShirtPress = getResources().getColorStateList(R.color.bobShirtPress);
                //Pant colored Keys
                rbobPants = getResources().getColorStateList(R.color.bobPants);
                rbobPantsPress = getResources().getColorStateList(R.color.bobPantsPress);
                //Body colored Keys
                rbobBody = getResources().getColorStateList(R.color.bobBody);
                rbobBodyPress = getResources().getColorStateList(R.color.bobBodyPress);
                //Shoes colored Keys
                rbobShoes = getResources().getColorStateList(R.color.bobShirt);
                rbobShoesPress = getResources().getColorStateList(R.color.bobShirtPress);
                break;
            case "light":
                //Tie colored Key
                rbobTie = getResources().getColorStateList(R.color.lightBobTie);
                rbobTiePress = getResources().getColorStateList(R.color.lightBobTiePress);
                //Shirt colored Keys
                rbobShirt = getResources().getColorStateList(R.color.lightBobShirt);
                rbobShirtPress = getResources().getColorStateList(R.color.lightBobShirtPress);
                //Pant colored Keys
                rbobPants = getResources().getColorStateList(R.color.lightBobPants);
                rbobPantsPress = getResources().getColorStateList(R.color.lightBobPantsPress);
                //Body colored Keys
                rbobBody = getResources().getColorStateList(R.color.lightBobBody);
                rbobBodyPress = getResources().getColorStateList(R.color.lightBobBodyPress);
                //Shoes colored Keys
                rbobShoes = getResources().getColorStateList(R.color.lightBobShirt);
                rbobShoesPress = getResources().getColorStateList(R.color.lightBobShirtPress);
                break;
            case "dark":
                //Tie colored Key
                rbobTie = getResources().getColorStateList(R.color.darkBobTie);
                rbobTiePress = getResources().getColorStateList(R.color.darkBobTiePress);
                //Shirt colored Keys
                rbobShirt = getResources().getColorStateList(R.color.darkBobShirt);
                rbobShirtPress = getResources().getColorStateList(R.color.darkBobShirtPress);
                //Pant colored Keys
                rbobPants = getResources().getColorStateList(R.color.darkBobPants);
                rbobPantsPress = getResources().getColorStateList(R.color.darkBobPantsPress);
                //Body colored Keys
                rbobBody = getResources().getColorStateList(R.color.darkBobBody);
                rbobBodyPress = getResources().getColorStateList(R.color.darkBobBodyPress);
                //Shoes colored Keys
                rbobShoes = getResources().getColorStateList(R.color.darkBobShirt);
                rbobShoesPress = getResources().getColorStateList(R.color.darkBobShirtPress);

                fontColor = Color.LTGRAY;
                break;
        }

        //Tie colored Key
        ColorStateList cTie = rbobTie;
        ColorStateList cTiePress = rbobTiePress;
        //Shirt colored Keys
        ColorStateList cShirt = rbobShirt;
        ColorStateList cShirtPress = rbobShirtPress;
        //Pant colored Keys
        ColorStateList cPant = rbobPants;
        ColorStateList cPantPress = rbobPantsPress;
        //Body colored Keys
        ColorStateList cBody = rbobBody;
        ColorStateList cBodyPress = rbobBodyPress;
        //Shoes colored Keys
        ColorStateList cShoes = rbobShoes;
        ColorStateList cShoesPress = rbobShoesPress;

        List<Keyboard.Key> keys = getKeyboard().getKeys();

        //Coloring Keys
        for (Keyboard.Key key : keys) {

            mPaint.setTextAlign(Paint.Align.CENTER);
            mPaint.setTextSize(70);
            mPaint.setColor(fontColor);

            //TODO Put coloring thingy in methods
            switch (key.codes[0])
            {
                case 116: case 121:
                    //Tie Colored key
                    Drawable keyTie = DrawableCompat.wrap(drawable);
                    NinePatchDrawable npTie = (NinePatchDrawable) keyTie;
                        if (key.pressed) {
                            DrawableCompat.setTintList(keyTie, cTiePress);
                            npTie.setBounds(key.x, key.y - key.height - key.gap, key.x + key.width, key.y);
                            npTie.draw(canvas);
                        }
                        else
                            DrawableCompat.setTintList(keyTie, cTie);
                    npTie.setBounds(key.x, key.y, key.x + key.width, key.y + key.height);
                    npTie.draw(canvas);
                    break;
                case 113: case 119: case 101: case 114: case 117: case 105: case 111: case 112:
                    //shirt Colored keys
                    Drawable keyShirt = DrawableCompat.wrap(drawable);
                    NinePatchDrawable npShirt = (NinePatchDrawable) keyShirt;
                        if (key.pressed) {
                            DrawableCompat.setTintList(keyShirt, cShirtPress);
                            npShirt.setBounds(key.x, key.y - key.height - key.gap, key.x + key.width, key.y);
                            npShirt.draw(canvas);
                        }
                        else
                            DrawableCompat.setTintList(keyShirt, cShirt);
                    npShirt.setBounds(key.x, key.y, key.x + key.width, key.y + key.height);
                    npShirt.draw(canvas);
                    break;
                case 97: case 115: case 100: case 102: case 103: case 104: case 106: case 107: case 108:
                    //Pant Colored keys
                    Drawable keyPant = DrawableCompat.wrap(drawable);
                    NinePatchDrawable npPant = (NinePatchDrawable) keyPant;
                        if (key.pressed) {
                            DrawableCompat.setTintList(keyPant, cPantPress);
                            npPant.setBounds(key.x, key.y - key.height - key.gap, key.x + key.width, key.y);
                            npPant.draw(canvas);
                        }
                        else
                            DrawableCompat.setTintList(keyPant, cPant);
                    npPant.setBounds(key.x, key.y, key.x + key.width, key.y + key.height);
                    npPant.draw(canvas);
                    break;
                case 35: case 44: case 39: case 32: case 63: case 46: case -4:
                    //Pant Colored keys
                    Drawable keyShoes = DrawableCompat.wrap(drawable);
                    NinePatchDrawable npShoes = (NinePatchDrawable) keyShoes;
                        if (key.pressed) {
                            DrawableCompat.setTintList(keyShoes, cShoesPress);
                            npShoes.setBounds(key.x,key.y - key.height - key.gap, key.x + key.width, key.y);
                            npShoes.draw(canvas);
                            DrawableCompat.setTintList(keyShoes, cShoesPress);
                        }
                        else {
                            DrawableCompat.setTintList(keyShoes, cShoes);
                        }
                    npShoes.setBounds(key.x, key.y, key.x + key.width, key.y + key.height);
                    npShoes.draw(canvas);
                    break;
                default:
                    //Body Colored keys
                    Drawable keyBody = DrawableCompat.wrap(drawable);
                    NinePatchDrawable npBody = (NinePatchDrawable) keyBody;
                    if (key.pressed) {
                        DrawableCompat.setTintList(keyBody, cBodyPress);
                        npBody.setBounds(key.x, key.y - key.height - key.gap, key.x + key.width, key.y);
                        npBody.draw(canvas);
                    }
                    else
                        DrawableCompat.setTintList(keyBody, cBody);
                    npBody.setBounds(key.x, key.y, key.x + key.width, key.y + key.height);
                    npBody.draw(canvas);
                    break;
            }

            //Placing icons
            if (key.icon != null) {
                key.icon.setBounds(0, 0, key.icon.getIntrinsicWidth(), key.icon.getIntrinsicHeight());
                canvas.save();
                canvas.translate(key.x + key.width/2 - key.icon.getIntrinsicWidth()/2, key.y + (key.height / 2) - key.icon.getIntrinsicHeight()/2);
                key.icon.draw(canvas);
                canvas.restore();
            }

            //Placing text (labels)
            // Switch the character to uppercase if shift is pressed
            String label = key.label == null? null : adjustCase(key.label).toString();

            if(label != null) {
                if (key.pressed) {
                    canvas.drawText(label,
                            key.x + (key.width / 2),
                            key.y + (key.height / 5) * 2 + mPaint.getTextSize() / 2 - key.height, mPaint);
                }
                canvas.drawText(label,
                        key.x + (key.width / 2),
                        key.y + (key.height / 5) * 2 + mPaint.getTextSize() / 2, mPaint);
            }
        }
        //super.onDraw(canvas);
    }

    protected CharSequence adjustCase(CharSequence label) {
        if (getKeyboard().isShifted() && label != null && label.length() < 3
                && Character.isLowerCase(label.charAt(0))) {
            label = label.toString().toUpperCase();
        }
        return label;
    }
}
