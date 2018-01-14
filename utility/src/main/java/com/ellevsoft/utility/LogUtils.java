package com.ellevsoft.utility;

import android.util.Log;

public class LogUtils {

    private final static String LOGTAG = "LogUtils";

    // Shows logs on debug version only (Does not appear on the release version)
    private final static boolean DEBUG = BuildConfig.DEBUG;

    public static void v(String message, Object... args) {
        if (DEBUG) {
            Log.v(LOGTAG, args == null || args.length == 0
                    ? message : String.format(message, args));
        }
    }

    public static void v(String tag, String message, Object... args) {
        if (DEBUG) {
            Log.v(LOGTAG + "/" + tag, args == null || args.length == 0 ? message
                    : String.format(message, args));
        }
    }

    public static void d(String message, Object... args) {
        if (DEBUG) {
            Log.d(LOGTAG, args == null || args.length == 0 ? message
                    : String.format(message, args));
        }
    }

    public static void d(String tag, String message, Object... args) {
        if (DEBUG) {
            Log.d(LOGTAG + "/" + tag, args == null || args.length == 0 ? message
                    : String.format(message, args));
        }
    }

    public static void i(String message, Object... args) {
        if (DEBUG) {
            Log.i(LOGTAG, args == null || args.length == 0 ? message
                    : String.format(message, args));
        }
    }

    public static void i(String tag, String message, Object... args) {
        if (DEBUG) {
            Log.i(LOGTAG + "/" + tag, args == null || args.length == 0 ? message
                    : String.format(message, args));
        }
    }

    public static void w(String message, Object... args) {
        if (DEBUG) {
            Log.w(LOGTAG, args == null || args.length == 0 ? message
                    : String.format(message, args));
        }
    }

    public static void w(String tag, String message, Object... args) {
        if (DEBUG) {
            Log.w(LOGTAG + "/" + tag, args == null || args.length == 0 ? message
                    : String.format(message, args));
        }
    }

    public static void e(String message, Object... args) {
        if (DEBUG) {
            Log.e(LOGTAG, args == null || args.length == 0 ? message
                    : String.format(message, args));
        }
    }

    public static void e(String tag, String message, Object... args) {
        if (DEBUG) {
            Log.e(LOGTAG + "/" + tag, args == null || args.length == 0 ? message
                    : String.format(message, args));
        }
    }

    public static void e(String message, Exception e) {
        if (DEBUG) {
            Log.e(LOGTAG, message, e);
        }
    }

    public static void e(String tag, String message, Exception e) {
        if (DEBUG) {
            Log.e(LOGTAG + "/" + tag, message, e);
        }
    }

    public static void wtf(String message, Object... args) {
        if (DEBUG) {
            Log.wtf(LOGTAG, args == null || args.length == 0 ? message
                    : String.format(message, args));
        }
    }

    public static void wtf(String tag, String message, Object... args) {
        if (DEBUG) {
            Log.wtf(LOGTAG + "/" + tag, args == null || args.length == 0 ? message
                    : String.format(message, args));
        }
    }

}
