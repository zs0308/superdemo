package com.zs.superdemo.leco.utils;

import android.util.Log;

public class MLog {

	private static boolean DEBUG = true;
	private static String TAG = "hua";

	public static void i(String s) {
		if (!DEBUG)
			return;
		Log.i(TAG, s);
	}

	public static void d(String s) {
		if (!DEBUG)
			return;
		Log.d(TAG, s);
	}

	public static void e(String s) {
		if (!DEBUG)
			return;
		Log.e(TAG, s);
	}
}
