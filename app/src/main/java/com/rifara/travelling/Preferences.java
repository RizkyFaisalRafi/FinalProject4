package com.rifara.travelling;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {

    private final SharedPreferences sharedPreferences;

    private final SharedPreferences.Editor editor;

    public Preferences(Context context) {
        sharedPreferences = context.getSharedPreferences("samplePref", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public SharedPreferences.Editor getEditor() {
        return editor;
    }
}
