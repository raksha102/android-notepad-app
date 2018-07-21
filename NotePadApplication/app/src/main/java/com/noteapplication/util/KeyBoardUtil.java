package com.noteapplication.util;


import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import javax.inject.Inject;

public class KeyBoardUtil implements IKeyBoardUtil {

    public boolean isKeyboardVisible = false;

    @Inject
    public KeyBoardUtil() {
    }

    public void hideSoftKeyboard(Context activity, View view) {
        if (null != view) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            isKeyboardVisible = false;
        }
    }

    public void showSoftKeyboard(Context activity, View view) {
        if (null != view) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInputFromInputMethod(view.getWindowToken(), InputMethodManager.SHOW_FORCED);
            isKeyboardVisible = true;
        }
    }

    public void showSoftKeyboard(Context activity) {
        if (!isKeyboardVisible) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
            isKeyboardVisible = true;
        }
    }

    public boolean hideSoftKeyboard(FragmentActivity activity) {
        if (activity != null) {
            if (activity.getCurrentFocus() != null) {
                InputMethodManager inputMethodManager = (InputMethodManager)
                        activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                isKeyboardVisible = false;
                return inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
            }
        }
        return false;
    }
}
