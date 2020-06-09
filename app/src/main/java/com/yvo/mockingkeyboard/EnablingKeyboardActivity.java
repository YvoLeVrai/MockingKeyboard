package com.yvo.mockingkeyboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;

import java.util.List;

public class EnablingKeyboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isKeyboardEnabled())
        {
            setContentView(R.layout.activity_ennabled_keyboard);
        }
        else
        {
            setContentView(R.layout.activity_enabling_keyboard);
        }
    }

    public void button_enable_Click(View view)
    {
        //Entrer dans les options de l'app
        Intent intent = new Intent(Settings.ACTION_INPUT_METHOD_SETTINGS);
        startActivity(intent);
    }

    public void button_switch_click(View view)
    {
        //Button to switch android keyboard
        InputMethodManager imeManager = (InputMethodManager) getApplicationContext().getSystemService(INPUT_METHOD_SERVICE);
        if (imeManager != null) {
            imeManager.showInputMethodPicker();
        }
    }

    private boolean isKeyboardEnabled()
    {
        boolean enabled = false;

        InputMethodManager imeManager = (InputMethodManager)getApplicationContext().getSystemService(INPUT_METHOD_SERVICE);
        List<InputMethodInfo> InputMethods = imeManager.getEnabledInputMethodList();

        Log.i("Keyboard List", InputMethods.toString());

        for (InputMethodInfo inputMethodInfo : InputMethods)
        {
            Log.i("InputMethodInfo", inputMethodInfo.getPackageName());
            if (inputMethodInfo.getPackageName().equals("com.yvo.mockingkeyboard"))
            {
                enabled = true;
            }
        }
        Log.i("enabled", String.valueOf(enabled));
        return enabled;
    }
}