package com.ellevsoft.utility;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UtilCommon {

	public static void saveToSharedPreferences(Context context, String key, String value) {
		if(context == null)
			return;
		SharedPreferences.Editor editor = context.getSharedPreferences("PreferenceManager", Context.MODE_PRIVATE).edit();
		if(value == null) {
			editor.remove(key);
		}
		else {
			editor.putString(key, value);
		}
		editor.commit();
	}

	public static void saveToSharedPreferences(Context context, String key, long value) {
		if(context == null)
			return;
		SharedPreferences.Editor editor = context.getSharedPreferences("PreferenceManager", Context.MODE_PRIVATE).edit();
		editor.putLong(key, value);
		editor.commit();
	}

	public static String loadFromSharedPreferences(Context context, String key) {
		if(key == null || context == null) {
			return null;
		}
		return context.getSharedPreferences("PreferenceManager", Context.MODE_PRIVATE).getString(key, null);
	}

	public static String loadFromSharedPreferences(Context context, String key, String defaultValue) {
		if(key == null || context == null) {
			return null;
		}
		return context.getSharedPreferences("PreferenceManager", Context.MODE_PRIVATE).getString(key, defaultValue);
	}

	public static long loadFromSharedPreferences(Context context, String key, long defaultValue) {
		if(key == null || context == null) {
			return 0;
		}
		return context.getSharedPreferences("PreferenceManager", Context.MODE_PRIVATE).getLong(key, defaultValue);
	}

	public static String[] splitString(String src, String delims) {
		if(src == null || delims == null)
			return null;
		try {
			return src.split(delims);
		}
		catch(Exception e) {
			return null;
		}
	}

	public static String mergeString(String[] src, String delims) {
		if(src == null || delims == null)
			return null;
		try {
			StringBuilder merged = new StringBuilder();
			for (int i = 0; i < src.length; i++) {
				if (i == 0)
					merged = new StringBuilder(src[i]);
				else
					merged.append(delims).append(src[i]);
			}
			return merged.toString();
		}
		catch(Exception e) {
			return null;
		}
	}

	public static float convertDpToPixel(float dp, Context context){
		Resources resources = context.getResources();
		DisplayMetrics metrics = resources.getDisplayMetrics();
		float px = dp * (metrics.densityDpi / 160f);
		return px;
	}

	public static float convertPixelsToDp(float px, Context context){
		Resources resources = context.getResources();
		DisplayMetrics metrics = resources.getDisplayMetrics();
		float dp = px / (metrics.densityDpi / 160f);
		return dp;
	}


    public static void sendEmail(Context context, boolean isPaidApp, String emailReceiver, String subject, String message) {
        String sOSVersion = null;
        String sManufacturer = null;
        String sModel = null;
        String version = null;

        try {
            PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            sOSVersion = Build.VERSION.RELEASE;
            sManufacturer = Build.MANUFACTURER;
            version = pInfo.versionName;

            sModel = Build.MODEL + " (" + Build.DEVICE + ")";
        } catch (Exception e) {
        }
        String combinedMessage = "";
        if(version != null && !version.equals("")) {
            if(isPaidApp)
                combinedMessage = "App Version : " + version + "p\n";
            else
                combinedMessage = "App Version : " + version + "\n";
        }
        if(sOSVersion != null && !sOSVersion.equals("")) {
            combinedMessage += "OS Version : " + sOSVersion + "\n";
        }
        if((sManufacturer != null && !sManufacturer.equals("")) || (sModel != null && !sModel.equals(""))) {
            combinedMessage += "Device : " + sManufacturer + " " + sModel + "\n";
        }
        combinedMessage += "\n\n" + message;

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{emailReceiver});
        i.putExtra(Intent.EXTRA_SUBJECT, subject);
        i.putExtra(Intent.EXTRA_TEXT   , combinedMessage);
        try {
            context.startActivity(Intent.createChooser(i, "Send Email..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(context, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

	public static void applyFont(ViewGroup group, Typeface font) {
		if(font == null)
			return;
		if(group == null)
			return;

		int count = group.getChildCount();
		View v;
		for (int i = 0; i < count; i++) {
			v = group.getChildAt(i);
			if (v instanceof TextView)
				((TextView) v).setTypeface(font);
			else if(v instanceof Button)
				((Button) v).setTypeface(font);
			else if (v instanceof ViewGroup)
				applyFont((ViewGroup) v, font);
		}
	}

}