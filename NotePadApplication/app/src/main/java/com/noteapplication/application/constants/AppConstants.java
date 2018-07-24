package com.noteapplication.application.constants;


import android.support.annotation.IntDef;
import android.support.annotation.StringDef;

public class AppConstants {

    @IntDef({LANDING_SCREEN, ADD_SCREEN})
    public @interface SCREEN_TYPE {
    }

    public static final int LANDING_SCREEN = 101;
    public static final int ADD_SCREEN = 102;

    @StringDef({POLICY_DATABASE})
    public @interface DATA_POLICY {
    }

    public static final String POLICY_DATABASE = "policy_database";
    public static final String POLICY_NETWORK = "policy_network";
}
