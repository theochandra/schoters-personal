package com.example.schoterspersonal.component;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;

import java.util.HashMap;

@SuppressWarnings("ALL")
public class Typefaces {

    public static final String PATH_FONT_HELVETICA = "fonts/Helvetica-Bold.ttf";

    public static final String PATH_FONT_OPEN_SANS = "fonts/OpenSans-Regular.ttf";

    private static final String TAG = "Typefaces";

    private static final HashMap<String, Typeface> cache = new HashMap<>();

    private Typefaces() {
    }

    public static Typeface get(Context c, String assetPath) {
        synchronized (cache) {
            if (!cache.containsKey(assetPath)) {
                try {
                    Typeface t = Typeface.createFromAsset(c.getAssets(),
                        assetPath);
                    cache.put(assetPath, t);
                } catch (Exception e) {
                    Log.e(TAG, "Could not get typeface '" + assetPath
                        + "' because " + e.getMessage());
                    return null;
                }
            }
            return cache.get(assetPath);
        }
    }

}
