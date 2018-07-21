package com.noteapplication.application.constants;


import android.support.annotation.IntDef;

public class AppConstants {

    @IntDef({LANDING_SCREEN, ADD_SCREEN})
    public @interface SCREEN_TYPE {
    }

    public static final int LANDING_SCREEN = 101;
    public static final int ADD_SCREEN = 102;
}
