package com.ammar.assignment.quizapp;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build.VERSION;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import android.view.View;

public class Utility {
    public static String rollNumber;
    public static String name;
    private Utility() {
    }

    static Drawable tintIcon(@NonNull Drawable drawable, @ColorInt int tintColor) {
        drawable.setColorFilter(tintColor, Mode.SRC_IN);
        return drawable;
    }

    static Drawable tint9PatchDrawableFrame(@NonNull Context context, @ColorInt int tintColor) {
        return tintIcon((NinePatchDrawable) getDrawable(context, R.drawable.toast_frame), tintColor);
    }

    static void setBackground(@NonNull View view, Drawable drawable) {
        if (VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    static Drawable getDrawable(@NonNull Context context, @DrawableRes int id) {
        if (VERSION.SDK_INT >= 21) {
            return context.getDrawable(id);
        }
        return context.getResources().getDrawable(id);
    }
}
