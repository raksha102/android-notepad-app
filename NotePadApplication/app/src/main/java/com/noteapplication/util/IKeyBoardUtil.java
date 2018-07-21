package com.noteapplication.util;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;

public interface IKeyBoardUtil {

    void hideSoftKeyboard(Context activity, View view);

    void showSoftKeyboard(Context activity, View view);

    void showSoftKeyboard(Context activity);

    boolean hideSoftKeyboard(FragmentActivity activity);
}
