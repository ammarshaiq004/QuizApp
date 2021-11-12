package com.ammar.assignment.quizapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.app.Activity.DEFAULT_KEYS_DISABLE;

@SuppressLint({"InflateParams"})
public class ToastClass {
    @ColorInt
    private static int TOAST_DEFAULT_TEXT_COLOR = Color.parseColor("#FFFFFF");
    @ColorInt
    private static int TOAST_ERROR_COLOR = Color.parseColor("#D50000");
    @ColorInt
    private static int TOAST_INFO_COLOR = Color.parseColor("#3F51B5");
    private static final Typeface TOAST_LOADED_TOAST_TYPEFACE = Typeface.create("sans-serif-condensed", Typeface.NORMAL);
    @ColorInt
    private static int TOAST_NORMAL_COLOR = Color.parseColor("#353A3E");
    @ColorInt
    private static int TOAST_SUCCESS_COLOR = Color.parseColor("#388E3C");
    @ColorInt
    private static int TOAST_WARNING_COLOR = Color.parseColor("#FFA900");
    private static Typeface toast_currentTypeface = TOAST_LOADED_TOAST_TYPEFACE;
    private static int toast_textSize = 14;
    private static boolean toast_tint_Icon = true;



    private ToastClass() {
    }

    @CheckResult
    public static Toast normal(@NonNull Context context, @NonNull CharSequence message) {
        return normal(context, message, 0, null, false);
    }

    @CheckResult
    public static Toast normal(@NonNull Context context, @NonNull CharSequence message, Drawable icon) {
        return normal(context, message, 0, icon, true);
    }

    @CheckResult
    public static Toast normal(@NonNull Context context, @NonNull CharSequence message, int duration) {
        return normal(context, message, duration, null, false);
    }

    @CheckResult
    public static Toast normal(@NonNull Context context, @NonNull CharSequence message, int duration, Drawable icon) {
        return normal(context, message, duration, icon, true);
    }

    @CheckResult
    public static Toast normal(@NonNull Context context, @NonNull CharSequence message, int duration, Drawable icon, boolean withIcon) {
        return custom(context, message, icon, TOAST_NORMAL_COLOR, duration, withIcon, true);
    }

    @CheckResult
    public static Toast warning(@NonNull Context context, @NonNull CharSequence message) {
        return warning(context, message, DEFAULT_KEYS_DISABLE, true);
    }

    @CheckResult
    public static Toast warning(@NonNull Context context, @NonNull CharSequence message, int duration) {
        return warning(context, message, duration, true);
    }

    @CheckResult
    public static Toast warning(@NonNull Context context, @NonNull CharSequence message, int duration, boolean withIcon) {
        return custom(context, message, Utility.getDrawable(context, R.drawable.icon_error_toast), TOAST_WARNING_COLOR, duration, withIcon, true);
    }

    @CheckResult
    public static Toast info(@NonNull Context context, @NonNull CharSequence message) {
        return info(context, message, DEFAULT_KEYS_DISABLE, true);
    }

    @CheckResult
    public static Toast info(@NonNull Context context, @NonNull CharSequence message, int duration) {
        return info(context, message, duration, true);
    }

    @CheckResult
    public static Toast info(@NonNull Context context, @NonNull CharSequence message, int duration, boolean withIcon) {
        return custom(context, message, Utility.getDrawable(context, R.drawable.icon_information_toast), TOAST_INFO_COLOR, duration, withIcon, true);
    }

    @CheckResult
    public static Toast success(@NonNull Context context, @NonNull CharSequence message) {
        return success(context, message, DEFAULT_KEYS_DISABLE, true);
    }

    @CheckResult
    public static Toast success(@NonNull Context context, @NonNull CharSequence message, int duration) {
        return success(context, message, duration, true);
    }

    @CheckResult
    public static Toast success(@NonNull Context context, @NonNull CharSequence message, int duration, boolean withIcon) {
        return custom(context, message, Utility.getDrawable(context, R.drawable.icon_done_toast), TOAST_SUCCESS_COLOR, duration, withIcon, true);
    }

    @CheckResult
    public static Toast error(@NonNull Context context, @NonNull CharSequence message) {
        return error(context, message, DEFAULT_KEYS_DISABLE, true);
    }

    @CheckResult
    public static Toast error(@NonNull Context context, @NonNull CharSequence message, int duration) {
        return error(context, message, duration, true);
    }

    @CheckResult
    public static Toast error(@NonNull Context context, @NonNull CharSequence message, int duration, boolean withIcon) {
        return custom(context, message, Utility.getDrawable(context, R.drawable.icon_close_toasts), TOAST_ERROR_COLOR, duration, withIcon, true);
    }

    @CheckResult
    public static Toast custom(@NonNull Context context, @NonNull CharSequence message, Drawable icon, int duration, boolean withIcon) {
        return custom(context, message, icon, -1, duration, withIcon, false);
    }

    @CheckResult
    public static Toast custom(@NonNull Context context, @NonNull CharSequence message, @DrawableRes int iconRes, @ColorInt int tintColor, int duration, boolean withIcon, boolean shouldTint) {
        return custom(context, message, Utility.getDrawable(context, iconRes), tintColor, duration, withIcon, shouldTint);
    }

    @SuppressLint({"ShowToast"})
    @CheckResult
    public static Toast custom(@NonNull Context context, @NonNull CharSequence message, Drawable icon, @ColorInt int tintColor, int duration, boolean withIcon, boolean shouldTint) {
        Drawable drawableFrame;
        Toast currentToast = Toast.makeText(context, "", duration);
        View toastLayout = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.layout_make_toast_display, null);
        ImageView toastIcon = (ImageView) toastLayout.findViewById(R.id._make_toast_icon);
        TextView toastTextView = (TextView) toastLayout.findViewById(R.id._make_toast_text);
        if (shouldTint) {
            drawableFrame = Utility.tint9PatchDrawableFrame(context, tintColor);
        } else {
            drawableFrame = Utility.getDrawable(context, R.drawable.toast_frame);
        }
        Utility.setBackground(toastLayout, drawableFrame);
        if (!withIcon) {
            toastIcon.setVisibility(View.GONE);
        } else if (icon == null) {
            throw new IllegalArgumentException("Avoid passing 'icon' as null if 'withIcon' is set to true");
        } else {
            if (toast_tint_Icon) {
                icon = Utility.tintIcon(icon, TOAST_DEFAULT_TEXT_COLOR);
            }
            Utility.setBackground(toastIcon, icon);
        }
        toastTextView.setText(message);
        toastTextView.setTextColor(TOAST_DEFAULT_TEXT_COLOR);
        toastTextView.setTypeface(toast_currentTypeface);
        toastTextView.setTextSize(2, (float) toast_textSize);
        currentToast.setView(toastLayout);
        return currentToast;
    }
}
