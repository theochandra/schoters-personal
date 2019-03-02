package com.example.schoterspersonal.component.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.example.schoterspersonal.component.Typefaces;

import androidx.appcompat.widget.AppCompatTextView;

@SuppressWarnings("ALL")
public class HelveticaTextView extends AppCompatTextView {

    public HelveticaTextView(Context context) {
        super(context);
        setFont(context);
    }

    private void setFont(Context context) {
        Typeface face = Typefaces.get(context, Typefaces.PATH_FONT_HELVETICA);
        setTypeface(face);
    }

    public HelveticaTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont(context);
    }

    public HelveticaTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont(context);
    }

}
