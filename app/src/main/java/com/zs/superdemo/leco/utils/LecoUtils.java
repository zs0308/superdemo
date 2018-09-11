package com.zs.superdemo.leco.utils;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.location.LocationManager;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Base64;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

//import com.maning.mndialoglibrary.MToast;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.StreamCorruptedException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class LecoUtils {

    //是否打印log
    private static boolean isShowLog = true;
    public static String SessionFailNotice = "请重新登录";

    /**
     * log
     */
    public static void Log(String log) {
        if (isShowLog) {
            Log.e("zs", log);
        }
    }

    public static void logE(String tag, String log) {
        if (isShowLog) {
            Log.e(tag, log);
        }
    }

    public static void showToast(Context context, String msg) {
//        MToast.makeTextShort(context, msg);
    }


    /**
     * JSONObject JSONArray
     * @param resultjsonMsg
     * @param context
     */
    /*JSONObject mJsonObject = new JSONObject();
        try {
        mJsonObject.put("coupon", 12);
        mJsonObject.put("sex", "女");
        mJsonObject.put("age", 18);
        mJsonObject.put("isBoole", true);
    } catch (JSONException mE) {
        mE.printStackTrace();
    }

    JSONObject mJsonObject2 = new JSONObject();
        try {
        mJsonObject2.put("coupon", 111);
        mJsonObject2.put("sex", "女");
        mJsonObject2.put("age", 28);
        mJsonObject2.put("isBoole", false);
    } catch (JSONException mE) {
        mE.printStackTrace();
    }

        MLog.e("mj=" + mJsonObject.toString());

    JSONArray mJsonElements = new JSONArray();
        mJsonElements.put(mJsonObject);
        mJsonElements.put(mJsonObject2);

    JSONObject mJsonObject1 = new JSONObject();
        try {
        mJsonObject1.put("big", 12);
        mJsonObject1.put("list", mJsonElements);
    } catch (JSONException mE) {
        mE.printStackTrace();
    }
        MLog.e("have list mj=" + mJsonObject1.toString());*/

//    public static void showToast(Context context, String msg) {
//        try {
//            if (TextUtils.equals(msg, "session failed")) {
//                Toast.makeText(context, "请重新登录！", Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
//            }
//        } catch (Exception e) {
//
//        }
//    }

    //通知栏 沉浸
//    implementation 'com.jaeger.statusbaruitl:library:1.3.6'
    //设置颜色
//    StatusBarUtil.setColor(this, getResources().getColor(R.color.theme),0);
    //设限制透明
//     StatusBarUtil.setTranslucentForImageView(this, 0, null);
    //实现状态栏图标和文字颜色为浅色
//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
    //实现状态栏图标和文字颜色为暗色
//      getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);


    //session failed 后跳登录页面
    public static void dengluAgain(String resultjsonMsg, Context context) {
        if (TextUtils.equals(resultjsonMsg, "session failed")) {
            //session failed
//            Intent intent = new Intent(context, DengluActivity.class);
//            context.startActivity(intent);
        }
    }

    /**
     * 获取当前日期，比较日期大小
     * return 2018-01-11
     */
//    LecoUtils.Log("比较的int="+daoqiDateTv.getText().toString().compareTo(tixingDateTv.getText().toString()));
    public static String getToday() {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = dateFormat.format(now);
        LecoUtils.Log("当前日期=" + today);
        return today;
    }

    /**
     * 同格式比较日期大小
     *
     * @param a
     * @param b
     * @return a>b:return>0  a=b:return=0 a<b:return<0
     */
    public static Integer getDateStringCompare(String a, String b) {
        Integer result = null;
        if (a.length() == b.length()) {
            result = a.compareTo(b);
        } else {
            LecoUtils.Log("比较日期输入的参数错误");
            return null;
        }
        return result;
    }

    /**
     * 保留两位小数
     */
    public static double getTwoDecimal(double decimal) {
        DecimalFormat df = new DecimalFormat("#.00");
        return Double.valueOf(df.format(decimal));

        //四舍五入
//        double   f   =   111231.5585;
//        BigDecimal   b   =   new   BigDecimal(f);
//        double   f1   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();

    }

    /**
     * 四舍五入为整数
     */
    public static int getMathFloor(double decimal) {
        return (int) Math.floor(decimal + 0.5);
    }

    /**
     * 获取屏幕大小，动态设置控价大小
     */
//    WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
//    Display display = wm.getDefaultDisplay();
//        LecoUtils.Log("屏幕尺寸1: 宽度 = " + display.getWidth() + "高度 = :" + display.getHeight());
//
//    DisplayMetrics dm = getResources().getDisplayMetrics();
//    int w_screen = dm.widthPixels;
//    int h_screen = dm.heightPixels;
//        LecoUtils.Log("屏幕尺寸2：宽度 = " + w_screen + "高度 = " + h_screen + "密度 = " + dm.densityDpi);
//
//    ViewGroup.LayoutParams para1;
//    para1 = bannerMainDefault.getLayoutParams();
//    para1.height = (int) (w_screen / 1.32);
//        bannerMainDefault.setLayoutParams(para1);

    /**
     * desc:保存对象
     *
     * @param context
     * @param key
     * @param obj     要保存的对象，只能保存实现了serializable的对象
     *                modified:
     */
    public static void saveObject(Context context, String key, Object obj) {
        try {
            // 保存对象
            SharedPreferences.Editor sharedata = context.getSharedPreferences(key, Context.MODE_PRIVATE).edit();
            //先将序列化结果写到byte缓存中，其实就分配一个内存空间
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(bos);
            //将对象序列化写入byte缓存
            os.writeObject(obj);
            //将序列化的数据转为16进制保存
            String bytesToHexString = bytesToHexString(bos.toByteArray());
            //保存该16进制数组
            sharedata.putString(key, bytesToHexString);
            sharedata.commit();
        } catch (IOException e) {
            e.printStackTrace();
            LecoUtils.Log("保存obj失败");
        }
    }

    /**
     * desc:将数组转为16进制
     *
     * @param bArray
     * @return modified:
     */
    public static String bytesToHexString(byte[] bArray) {
        if (bArray == null) {
            return null;
        }
        if (bArray.length == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer(bArray.length);
        String sTemp;
        for (int i = 0; i < bArray.length; i++) {
            sTemp = Integer.toHexString(0xFF & bArray[i]);
            if (sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * desc:获取保存的Object对象
     *
     * @param context
     * @param key
     * @return modified:
     */
    public static Object readObject(Context context, String key) {
        try {
            SharedPreferences sharedata = context.getSharedPreferences(key, Context.MODE_PRIVATE);
            if (sharedata.contains(key)) {
                String string = sharedata.getString(key, "");
                if (TextUtils.isEmpty(string)) {
                    return null;
                } else {
                    //将16进制的数据转为数组，准备反序列化
                    byte[] stringToBytes = StringToBytes(string);
                    ByteArrayInputStream bis = new ByteArrayInputStream(stringToBytes);
                    ObjectInputStream is = new ObjectInputStream(bis);
                    //返回反序列化得到的对象
                    Object readObject = is.readObject();
                    return readObject;
                }
            }
        } catch (StreamCorruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //所有异常返回null
        return null;

    }

    /**
     * desc:将16进制的数据转为数组
     * <p>创建人：聂旭阳 , 2014-5-25 上午11:08:33</p>
     *
     * @param hex
     * @return modified:
     */
    public static byte[] StringToBytes(String hex) {
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] achar = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
        }
        return result;
    }

    private static byte toByte(char c) {
        byte b = (byte) "0123456789ABCDEF".indexOf(c);
        return b;
    }

    /**
     * 计算从startColor过度到endColor过程中百分比为franch时的颜色值
     *
     * @param startColor 起始颜色 int类型
     * @param endColor   结束颜色 int类型
     * @param franch     franch 百分比0.5
     * @return 返回int格式的color
     */
    public static int caculateColor(int startColor, int endColor, float franch) {
        String strStartColor = "#" + Integer.toHexString(startColor);
        String strEndColor = "#" + Integer.toHexString(endColor);
        return Color.parseColor(caculateColor(strStartColor, strEndColor, franch));
    }

    /**
     * 计算从startColor过度到endColor过程中百分比为franch时的颜色值
     *
     * @param startColor 起始颜色 （格式#FFFFFFFF）
     * @param endColor   结束颜色 （格式#FFFFFFFF）
     * @param franch     百分比0.5
     * @return 返回String格式的color（格式#FFFFFFFF）
     */
    public static String caculateColor(String startColor, String endColor, float franch) {

        int startAlpha = Integer.parseInt(startColor.substring(1, 3), 16);
        int startRed = Integer.parseInt(startColor.substring(3, 5), 16);
        int startGreen = Integer.parseInt(startColor.substring(5, 7), 16);
        int startBlue = Integer.parseInt(startColor.substring(7), 16);

        int endAlpha = Integer.parseInt(endColor.substring(1, 3), 16);
        int endRed = Integer.parseInt(endColor.substring(3, 5), 16);
        int endGreen = Integer.parseInt(endColor.substring(5, 7), 16);
        int endBlue = Integer.parseInt(endColor.substring(7), 16);

        int currentAlpha = (int) ((endAlpha - startAlpha) * franch + startAlpha);
        int currentRed = (int) ((endRed - startRed) * franch + startRed);
        int currentGreen = (int) ((endGreen - startGreen) * franch + startGreen);
        int currentBlue = (int) ((endBlue - startBlue) * franch + startBlue);

        return "#" + getHexString(currentAlpha) + getHexString(currentRed)
                + getHexString(currentGreen) + getHexString(currentBlue);

    }

    /**
     * 将10进制颜色值转换成16进制。
     */
    public static String getHexString(int value) {
        String hexString = Integer.toHexString(value);
        if (hexString.length() == 1) {
            hexString = "0" + hexString;
        }
        return hexString;
    }

    /**
     * 获取当前版本号
     *
     * @param context
     * @return
     */
    public static int getCurrentVersion(Context context) {
        try {
            PackageManager pm = context.getPackageManager();// context为当前Activity上下文
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            return pi.versionCode;
        } catch (Exception e) {
        }
        return 0;
    }

    /**
     * 获取当前版本号 名称
     *
     * @param context
     * @return
     */
    public static String getCurrentVersionName(Context context) {
        try {
            PackageManager pm = context.getPackageManager();// context为当前Activity上下文
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            return pi.versionName;
        } catch (Exception e) {
        }
        return "";
    }

    /**
     * 创建二维码
     */
   /* public static Bitmap encodeAsBitmap(String contents, BarcodeFormat format, int desiredWidth,
                                        int desiredHeight) {
        final int WHITE = 0xFFFFFFFF; // 可以指定其他颜色，让二维码变成彩色效果
        final int BLACK = 0xFF000000;

        HashMap<EncodeHintType, String> hints = null;
        String encoding = guessAppropriateEncoding(contents);
        if (encoding != null) {
            hints = new HashMap<EncodeHintType, String>(2);
            hints.put(EncodeHintType.CHARACTER_SET, encoding);
        }
        MultiFormatWriter writer = new MultiFormatWriter();
        BitMatrix result = null;
        try {
            result = writer.encode(contents, format, desiredWidth, desiredHeight, hints);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        int width = result.getWidth();
        int height = result.getHeight();
        int[] pixels = new int[width * height];
        // All are 0, or black, by default
        for (int y = 0; y < height; y++) {
            int offset = y * width;
            for (int x = 0; x < width; x++) {
                pixels[offset + x] = result.get(x, y) ? BLACK : WHITE;
            }
        }

        Bitmap bitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
        return bitmap;
    }*/
    private static String guessAppropriateEncoding(CharSequence contents) {
        // Very crude at the moment
        for (int i = 0; i < contents.length(); i++) {
            if (contents.charAt(i) > 0xFF) {
                return "UTF-8";
            }
        }
        return null;
    }

    /**
     * 在二维码中间添加Logo图案
     */
    public static Bitmap addLogo(Bitmap src, Bitmap logo) {
        if (src == null) {
            return null;
        }

        if (logo == null) {
            return src;
        }

        //获取图片的宽高
        int srcWidth = src.getWidth();
        int srcHeight = src.getHeight();
        int logoWidth = logo.getWidth();
        int logoHeight = logo.getHeight();

        if (srcWidth == 0 || srcHeight == 0) {
            return null;
        }

        if (logoWidth == 0 || logoHeight == 0) {
            return src;
        }

        //logo大小为二维码整体大小的1/5
        float scaleFactor = srcWidth * 1.0f / 5 / logoWidth;
        Bitmap bitmap = Bitmap.createBitmap(srcWidth, srcHeight, Config.ARGB_8888);
        try {
            Canvas canvas = new Canvas(bitmap);
            canvas.drawBitmap(src, 0, 0, null);
            canvas.scale(scaleFactor, scaleFactor, srcWidth / 2, srcHeight / 2);
            canvas.drawBitmap(logo, (srcWidth - logoWidth) / 2, (srcHeight - logoHeight) / 2, null);

            canvas.save(Canvas.ALL_SAVE_FLAG);
            canvas.restore();
        } catch (Exception e) {
            bitmap = null;
            e.getStackTrace();
        }

        return bitmap;
    }

    /**
     * 保存二维码
     *
     * @param qrCodeBitmap
     */
    public static void saveQrCodePicture(Bitmap qrCodeBitmap) {
        final File qrImage = new File("/sdcard/",
                "erweima_" + System.currentTimeMillis() + ".jpg");
        if (qrImage.exists()) {
            qrImage.delete();
        }
        try {
            qrImage.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileOutputStream fOut = null;
        try {
            fOut = new FileOutputStream(qrImage);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (qrCodeBitmap == null) {
            return;
        }
        qrCodeBitmap.compress(CompressFormat.JPEG, 100, fOut);
        try {
            fOut.flush();
            fOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得状态栏的高度
     *
     * @param context
     * @return
     */
    public static int getStatusHeight(Context context) {

        int statusHeight = -1;
        try {
            Class clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height")
                    .get(object).toString());
            statusHeight = context.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusHeight;
    }

    /**
     * 将图片截取为圆角图片
     *
     * @param bitmap 原图片
     * @return 圆角矩形图片
     */
    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap) {

        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final Paint paint = new Paint();
        // 保证是方形，并且从中心画
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int w;
        int deltaX = 0;
        int deltaY = 0;
        if (width <= height) {
            w = width;
            deltaY = height - w;
        } else {
            w = height;
            deltaX = width - w;
        }
        final Rect rect = new Rect(deltaX, deltaY, w, w);
        final RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        // 圆形，所有只用一个
        int radius = (int) (Math.sqrt(w * w * 2.0d) / 2);//圆角半径
        canvas.drawRoundRect(rectF, radius, radius, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }

    /**
     * 从view 得到图片
     *
     * @param view
     * @return
     */
    public static Bitmap getBitmapFromView(View view) {
        view.destroyDrawingCache();
        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.setDrawingCacheEnabled(true);
        Bitmap bitmap = view.getDrawingCache(true);
        return bitmap;
    }

    /**
     * 图片灰化处理
     *
     * @return
     */
    public static Bitmap getGrayBitmap(Context context, int resid) {
        Bitmap mBitmap = BitmapFactory.decodeResource(context.getResources(), resid);
        Bitmap mGrayBitmap = Bitmap.createBitmap(mBitmap.getWidth(),
                mBitmap.getHeight(), Config.ARGB_8888);
        Canvas mCanvas = new Canvas(mGrayBitmap);
        Paint mPaint = new Paint();
        // 创建颜色变换矩阵
        ColorMatrix mColorMatrix = new ColorMatrix();
        // 设置灰度影响范围
        mColorMatrix.setSaturation(0);
        // 创建颜色过滤矩阵
        ColorMatrixColorFilter mColorFilter = new ColorMatrixColorFilter(
                mColorMatrix);
        // 设置画笔的颜色过滤矩阵
        mPaint.setColorFilter(mColorFilter);
        // 使用处理后的画笔绘制图像
        mCanvas.drawBitmap(mBitmap, 0, 0, mPaint);
        return mGrayBitmap;
    }

    /**
     * 提取图像Alpha位图
     *
     * @return
     */
    public static Bitmap getAlphaBitmap(Context context, int resid) {
        BitmapDrawable mBitmapDrawable = (BitmapDrawable) context
                .getResources().getDrawable(resid);
        Bitmap mBitmap = mBitmapDrawable.getBitmap();
        // BitmapDrawable的getIntrinsicWidth（）方法，Bitmap的getWidth（）方法
        // 注意这两个方法的区别
        // Bitmap mAlphaBitmap =
        // Bitmap.createBitmap(mBitmapDrawable.getIntrinsicWidth(),
        // mBitmapDrawable.getIntrinsicHeight(), Config.ARGB_8888);
        Bitmap mAlphaBitmap = Bitmap.createBitmap(mBitmap.getWidth(),
                mBitmap.getHeight(), Config.ARGB_8888);
        Canvas mCanvas = new Canvas(mAlphaBitmap);
        Paint mPaint = new Paint();
        mPaint.setColor(Color.BLUE);//位图的颜色
        // 从原位图中提取只包含alpha的位图
        Bitmap alphaBitmap = mBitmap.extractAlpha();
        // 在画布上（mAlphaBitmap）绘制alpha位图
        mCanvas.drawBitmap(alphaBitmap, 0, 0, mPaint);
        return mAlphaBitmap;
    }

    /**
     * 图片缩放
     *
     * @param context
     * @param resid   图片id
     * @param sx      x缩放
     * @param sy      y缩放
     * @return
     */
    public static Bitmap getScaleBitmap(Context context, int resid, float sx, float sy) {
        BitmapDrawable mBitmapDrawable = (BitmapDrawable) context
                .getResources().getDrawable(resid);
        Bitmap mBitmap = mBitmapDrawable.getBitmap();
        int width = mBitmap.getWidth();
        int height = mBitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.preScale(sx, sy);
        Bitmap mScaleBitmap = Bitmap.createBitmap(mBitmap, 0, 0, width, height,
                matrix, true);
        return mScaleBitmap;
    }

    /**
     * 图片旋转
     *
     * @param context
     * @param resid
     * @param rotate  旋转角度
     * @return
     */
    public static Bitmap getRotatedBitmap(Context context, int resid, int rotate) {
        BitmapDrawable mBitmapDrawable = (BitmapDrawable) context.getResources()
                .getDrawable(resid);
        Bitmap mBitmap = mBitmapDrawable.getBitmap();
        int width = mBitmap.getWidth();
        int height = mBitmap.getHeight();

        Matrix matrix = new Matrix();
        matrix.preRotate(rotate);
        Bitmap mRotateBitmap = Bitmap.createBitmap(mBitmap, 0, 0, width,
                height, matrix, true);
        return mRotateBitmap;
    }

    /**
     * 图像倾斜
     *
     * @param context
     * @param resid
     * @param x       x坐标倾斜度
     * @param y       y坐标倾斜度
     * @return
     */
    public static Bitmap getScrewBitmap(Context context, int resid, float x, float y) {
        BitmapDrawable mBitmapDrawable = (BitmapDrawable) context
                .getResources().getDrawable(resid);
        Bitmap mBitmap = mBitmapDrawable.getBitmap();
        int width = mBitmap.getWidth();
        int height = mBitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.preSkew(1.0f, 0.15f);
        Bitmap mScrewBitmap = Bitmap.createBitmap(mBitmap, 0, 0, width, height,
                matrix, true);
        return mScrewBitmap;
    }

    /**
     * 图像倒影
     *
     * @param context
     * @param resid
     * @return
     */
    public static Bitmap getReflectedBitmap(Context context, int resid) {
        BitmapDrawable mBitmapDrawable = (BitmapDrawable) context
                .getResources().getDrawable(resid);
        Bitmap mBitmap = mBitmapDrawable.getBitmap();
        int width = mBitmap.getWidth();
        int height = mBitmap.getHeight();
        Matrix matrix = new Matrix();
        // 图片缩放，x轴变为原来的1倍，y轴为-1倍,实现图片的反转
        matrix.preScale(1, -1);
        // 创建反转后的图片Bitmap对象，图片高是原图的一半。
        // Bitmap mInverseBitmap = Bitmap.createBitmap(mBitmap, 0, height/2,
        // width, height/2, matrix, false);
        // 创建标准的Bitmap对象，宽和原图一致，高是原图的1.5倍。
        // 注意两种createBitmap的不同
        // Bitmap mReflectedBitmap = Bitmap.createBitmap(width, height*3/2,
        // Config.ARGB_8888);
        Bitmap mInverseBitmap = Bitmap.createBitmap(mBitmap, 0, 0, width,
                height, matrix, false);
        Bitmap mReflectedBitmap = Bitmap.createBitmap(width, height * 2,
                Config.ARGB_8888);
        // 把新建的位图作为画板
        Canvas mCanvas = new Canvas(mReflectedBitmap);
        // 绘制图片
        mCanvas.drawBitmap(mBitmap, 0, 0, null);
        mCanvas.drawBitmap(mInverseBitmap, 0, height, null);
        // 添加倒影的渐变效果
        Paint mPaint = new Paint();
        Shader mShader = new LinearGradient(0, height, 0,
                mReflectedBitmap.getHeight(), 0x70ffffff, 0x00ffffff,
                TileMode.MIRROR);
        mPaint.setShader(mShader);
        // 设置叠加模式
        mPaint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        // 绘制遮罩效果
        mCanvas.drawRect(0, height, width, mReflectedBitmap.getHeight(), mPaint);
        return mReflectedBitmap;
    }

    public static Bitmap getImgThumbnail(String imgPath) {
        InputStream is = null;
        try {
            is = new FileInputStream(imgPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        BitmapFactory.Options options = new BitmapFactory.Options();
        //为位图设置100K的缓存
        options.inTempStorage = new byte[100 * 1024];
        //设置位图颜色显示优化方式
        options.inPreferredConfig = Config.RGB_565;
        //设置图片可以被回收，创建Bitmap用于存储Pixel的内存空间在系统内存不足时可以被回收
        options.inPurgeable = true;
        //设置位图缩放比例
        options.inSampleSize = 4;
        //设置解码位图的尺寸信息
        options.inInputShareable = true;
        Bitmap bitmap = null;
        if (is == null) {

        } else {
            //解码位图
            bitmap = BitmapFactory.decodeStream(is, null, options);
        }
        return bitmap;
    }

    /**
     * 根据指定的图像路径和大小来获取缩略图
     * 此方法有两点好处：
     * 1. 使用较小的内存空间，第一次获取的bitmap实际上为null，只是为了读取宽度和高度，
     * 第二次读取的bitmap是根据比例压缩过的图像，第三次读取的bitmap是所要的缩略图。
     * 2. 缩略图对于原图像来讲没有拉伸，这里使用了2.2版本的新工具ThumbnailUtils，使
     * 用这个工具生成的图像不会被拉伸。
     *
     * @param imagePath 图像的路径
     * @param width     指定输出图像的宽度
     * @param height    指定输出图像的高度
     * @return 生成的缩略图
     */
    public static Bitmap getImageThumbnail(String imagePath, int width, int height) {
        Bitmap bitmap = null;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        // 获取这个图片的宽和高，注意此处的bitmap为null
        bitmap = BitmapFactory.decodeFile(imagePath, options);
        options.inJustDecodeBounds = false; // 设为 false
        // 计算缩放比
        int h = options.outHeight;
        int w = options.outWidth;
        int beWidth = w / width;
        int beHeight = h / height;
        int be = 1;
        if (beWidth < beHeight) {
            be = beWidth;
        } else {
            be = beHeight;
        }
        if (be <= 0) {
            be = 1;
        }
        options.inSampleSize = be;
        // 重新读入图片，读取缩放后的bitmap，注意这次要把options.inJustDecodeBounds 设为 false
        bitmap = BitmapFactory.decodeFile(imagePath, options);
        // 利用ThumbnailUtils来创建缩略图，这里要指定要缩放哪个Bitmap对象
//		bitmap = ThumbnailUtils.extractThumbnail(bitmap, width, height,
//				ThumbnailUtils.OPTIONS_RECYCLE_INPUT);
        return bitmap;
    }

    /**
     * 获取视频的缩略图
     * 先通过ThumbnailUtils来创建一个视频的缩略图，然后再利用ThumbnailUtils来生成指定大小的缩略图。
     * 如果想要的缩略图的宽和高都小于MICRO_KIND，则类型要使用MICRO_KIND作为kind的值，这样会节省内存。
     *
     * @param videoPath 视频的路径
     * @param width     指定输出视频缩略图的宽度
     * @param height    指定输出视频缩略图的高度度
     * @param kind      参照MediaStore.Images.Thumbnails类中的常量MINI_KIND和MICRO_KIND。
     *                  其中，MINI_KIND: 512 x 384，MICRO_KIND: 96 x 96
     * @return 指定大小的视频缩略图
     */
    public static Bitmap getVideoThumbnail(String videoPath, int width, int height,
                                           int kind) {
        Bitmap bitmap = null;
        // 获取视频的缩略图
        bitmap = ThumbnailUtils.createVideoThumbnail(videoPath, kind);
        //System.out.println("w" + bitmap.getWidth());
        //System.out.println("h" + bitmap.getHeight());
        bitmap = ThumbnailUtils.extractThumbnail(bitmap, width, height,
                ThumbnailUtils.OPTIONS_RECYCLE_INPUT);
        return bitmap;
    }

    public static Bitmap getVideoThumbnail(String filePath) {
        Bitmap bitmap = null;
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        try {
            retriever.setDataSource(filePath);
            bitmap = retriever.getFrameAtTime();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            try {
                retriever.release();
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
        return bitmap;
    }

    //@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public static Bitmap createVideoThumbnail(String url, int width, int height) {
        Bitmap bitmap = null;
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        int kind = MediaStore.Video.Thumbnails.MINI_KIND;
        try {
            if (Build.VERSION.SDK_INT >= 14) {
                retriever.setDataSource(url, new HashMap<String, String>());
            } else {
                retriever.setDataSource(url);
            }
            bitmap = retriever.getFrameAtTime();
        } catch (IllegalArgumentException ex) {
            // Assume this is a corrupt video file
        } catch (RuntimeException ex) {
            // Assume this is a corrupt video file.
        } finally {
            try {
                retriever.release();
            } catch (RuntimeException ex) {
                // Ignore failures while cleaning up.
            }
        }
        if (kind == MediaStore.Images.Thumbnails.MICRO_KIND && bitmap != null) {
            bitmap = ThumbnailUtils.extractThumbnail(bitmap, width, height,
                    ThumbnailUtils.OPTIONS_RECYCLE_INPUT);
        }
        return bitmap;
    }

    /**
     * 弹出系统文件选择器回调函数中获取文件路径
     *
     * @param @param  context
     * @param @param  uri
     * @param @return
     * @return String
     * @throws
     * @Title: getPath
     */
    public static String getPath(Context context, Uri uri) {
        if ("content".equalsIgnoreCase(uri.getScheme())) {
            String[] projection = {"_data"};
            Cursor cursor = null;
            try {
                cursor = context.getContentResolver().query(uri, projection, null, null, null);
                int column_index = cursor.getColumnIndexOrThrow("_data");
                if (cursor.moveToFirst()) {
                    return cursor.getString(column_index);
                }
            } catch (Exception e) {
                // Eat it
            }
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }

        return null;
    }

    /**
     * 删除文件夹
     *
     * @param sPath
     * @return
     */
    public static boolean deleteDirectory(String sPath) {
        File dirFile = new File(sPath);
        // 如果dir对应的文件不存在，或者不是一个目录，则退出
        if (!dirFile.exists() || !dirFile.isDirectory()) {
            return false;
        }
        boolean flag = true;
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            // 删除子文件
            if (files[i].isFile()) {
                flag = files[i].delete();
                MLog.i(files[i].getAbsolutePath());
                if (!flag)
                    break;
            }
        }
        if (!flag)
            return false;
        return true;
    }

    /**
     * 获取压缩图像
     *
     * @param imagePath 路径
     * @param width     宽
     * @param height    高
     * @return
     */
    public static Bitmap getImageThumbnail(String imagePath, float width, float height) {
        Bitmap bitmap = null;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        // 获取这个图片的宽和高，注意此处的bitmap为null
        bitmap = BitmapFactory.decodeFile(imagePath, options);
        options.inJustDecodeBounds = false; // 设为 false
        // 计算缩放比
        int h = options.outHeight;
        int w = options.outWidth;
        int beWidth = (int) (w / width);
        int beHeight = (int) (h / height);
        int be = 1;
        if (beWidth < beHeight) {
            be = beWidth;
        } else {
            be = beHeight;
        }
        if (be <= 0) {
            be = 1;
        }
        options.inSampleSize = be;
        // 重新读入图片，读取缩放后的bitmap，注意这次要把options.inJustDecodeBounds 设为 false
        bitmap = BitmapFactory.decodeFile(imagePath, options);
        options.inJustDecodeBounds = false; // 设为 false
        return bitmap;
    }

    /**
     * 压缩图片
     *
     * @param srcPath
     * @param ww
     * @param hh
     * @return
     */
    public static boolean scaleImage(String srcPath, String desPath, int ww, int hh) {
        BitmapFactory.Options newOpts = new BitmapFactory.Options();
        // 开始读入图片，此时把options.inJustDecodeBounds 设回true了
        newOpts.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeFile(srcPath, newOpts);// 此时返回bm为空

        newOpts.inJustDecodeBounds = false;
        int w = newOpts.outWidth;
        int h = newOpts.outHeight;
        // 现在主流手机比较多是800*480分辨率，所以高和宽我们设置为
        // 缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
        int be = 1;// be=1表示不缩放
        if (w > h && w > ww) {// 如果宽度大的话根据宽度固定大小缩放
            be = (int) (newOpts.outWidth / ww);
        } else if (w < h && h > hh) {// 如果高度高的话根据宽度固定大小缩放
            be = (int) (newOpts.outHeight / hh);
        }
        if (be <= 0) {
            be = 1;
        }
        newOpts.inSampleSize = be;// 设置缩放比例
        // 重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了
        bitmap = BitmapFactory.decodeFile(srcPath, newOpts);
        try {
            bitmap.compress(CompressFormat.PNG, 100, new FileOutputStream(desPath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;// 压缩好比例大小后再进行质量压缩
    }

    private final static double PI = 3.14159265358979323;// 圆周率
    private final static double R = 6371229; // 地球的半径6371229

    /**
     * 根据经度和维度算出距离 纬度lat 经度lon
     *
     * @return
     */
    public static String getDistance(double longt1, double lat1, double longt2, double lat2) {
        double x, y, distance;
        x = (longt2 - longt1) * PI * R * Math.cos(((lat1 + lat2) / 2) * PI / 180) / 180;
        y = (lat2 - lat1) * PI * R / 180;
        distance = Math.hypot(x, y) / 1000;

        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(distance);
    }

    /**
     * 补充：计算两点之间真实距离
     *
     * @return 米
     */
    public static double getDistance2(double longitude1, double latitude1, double longitude2, double latitude2) {
        // 维度
        double lat1 = (Math.PI / 180) * latitude1;
        double lat2 = (Math.PI / 180) * latitude2;

        // 经度
        double lon1 = (Math.PI / 180) * longitude1;
        double lon2 = (Math.PI / 180) * longitude2;

        // 地球半径
        double R = 6371;

        // 两点间距离 km，如果想要米的话，结果*1000就可以了
        double d = Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon2 - lon1)) * R;
        return d * 1000;

    }

    /**
     * google maps的脚本里代码
     */

    private static double EARTH_RADIUS = 6378.137;

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 根据两点间经纬度坐标（double值），计算两点间距离，单位为米
     */
    public static String getDistanceOfGoogle(double lng1, double lat1, double lng2, double lat2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        MLog.i("-------------------" + s);
        s = Math.round(s * 10000) / 10000;
        MLog.i("-------------------" + s);

        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(s);

    }

    /**
     * 获取文件大小
     *
     * @param f
     * @return
     * @throws Exception
     */
    public static long getFileSize(File f) throws Exception {
        long size = 0;
        if (f.isDirectory()) {
            File flist[] = f.listFiles();
            if (flist.length > 0) {
                for (int i = 0; i < flist.length; i++) {
                    if (flist[i].isDirectory()) {
                        size = size + getFileSize(flist[i]);
                    } else {
                        size = size + flist[i].length();
                    }
                }
            }
        } else {
            size = f.length();
        }

        return size;
    }

    /**
     * 转换文件大小
     *
     * @param fileSize
     * @return
     */
    public static String FormatFileSize(long fileSize) {
        DecimalFormat df = new DecimalFormat("0.00");
        String fileSizeString = "";
        if (fileSize < 1024) {
            fileSizeString = fileSize + "B";
        } else if (fileSize < 1048576) {
            fileSizeString = df.format((double) fileSize / 1024) + "K";
        } else if (fileSize < 1073741824) {
            fileSizeString = df.format((double) fileSize / 1048576) + "M";
        } else {
            fileSizeString = df.format((double) fileSize / 1073741824) + "G";
        }
        return fileSizeString;
    }

    /**
     * 获得可用的内存 ram
     *
     * @param mContext
     * @return b
     */
    public static long getAvailMem(Context mContext) {
        long MEM_UNUSED;
        // 得到ActivityManager
        ActivityManager am = (ActivityManager) mContext.getSystemService(Context.ACTIVITY_SERVICE);
        // 创建ActivityManager.MemoryInfo对象
        ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
        //获得系统可用内存，保存在MemoryInfo对象上
        am.getMemoryInfo(mi);
        // 取得剩余的内存空间
        MEM_UNUSED = mi.availMem;
        LecoUtils.logE("ram", "当前系统可用内存  = " + Formatter.formatFileSize(mContext, MEM_UNUSED));
        return MEM_UNUSED;
    }

    /**
     * 是不是有效的经纬度
     *
     * @param lat
     * @param longt
     * @return
     */
    public static boolean isValidLocation(Double lat, Double longt) {
        if (lat == null || longt == null) {
            return false;
        }
        return true;
    }

    /**
     * sd卡是否可用
     *
     * @return
     */
    public static boolean isSDcardAvailable() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }

    /**
     * sd卡是否满了
     *
     * @return
     */
    public static boolean isSDcardFull() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        /**
         * statFs.getAvaliableBlocks方法可以返回尚未使用的block的数量
         */
        long avaliableBlocks = statFs.getAvailableBlocks();
        /**
         * statFs.getBlockCount可以获取总的block数量
         */
        int blockSize = statFs.getBlockSize();
        int bytes = (int) (avaliableBlocks / blockSize);
        MLog.i("avaliableBlocks = " + avaliableBlocks + ", blockSize = " + blockSize + ", bytes = " + bytes);
        return bytes <= 0;
    }

    /**
     * 从短信中解析验证码
     *
     * @param sms
     * @return
     */
    public static String parseCodeFromSMS(String sms) {
        String res = "";
        Pattern p = Pattern.compile("[\\d]{6}"); // 小数保留两位小数
        Matcher m = p.matcher(sms);

        // 查找相应的字符串
        if (m.find()) {
            res = m.group();
        }
        return res;
    }

    public static boolean isDateFormat(String s) {
        if (s == null) {
            return false;
        }
        // 闰年的2月份有29天，因此匹配闰年日期格式为YYYY-MM-DD的正则表达式为：
        // (([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29最后，
        // 将平年和闰年的日期验证表达式合并，我们得到最终的验证日期格式为YYYY-MM-DD的正则表达式为：
        return s.matches("(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29) ");
    }

    /**
     * 通过扩展名判断是jpg还是png
     *
     * @param fileName
     * @return
     */
    public static boolean isJpegOrPng(String fileName) {
        String sufferFix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
        return "jpg".equalsIgnoreCase(sufferFix) || "png".equalsIgnoreCase(sufferFix);
    }

    /**
     * 得到文件的扩展名
     *
     * @param fileName
     * @return
     */
    public static String getExtention(String fileName) {
        if (fileName == null) {
            return null;
        }
        return fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
    }

    /**
     * 判断电话
     *
     * @param phonenumber
     * @return
     */
    public static boolean isTelephone(String phonenumber) {
        if (phonenumber == null) {
            return false;
        }
        return phonenumber.matches("(^[0-9]{3,4}-[0-9]{3,8}$)|(^[0-9]{3,8}$)|(^([0-9]{3,4})[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)");
    }

    /**
     * 密码长度是否是6-16位
     *
     * @param s
     * @return
     */
    public static boolean isPswLength(String s) {
        if (s.length() < 6 || s.length() > 16) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 用户名长度
     *
     * @param s
     * @return
     */
    public static boolean isUsernameLength(String s) {
        if (s.length() < 0 || s.length() > 10) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 判断url是否有效
     *
     * @param url
     * @return
     */
    public static boolean isValidUrl(String url) {
        if (url == null) {
            return false;
        }
        return url.matches("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");
    }

    /**
     * 验证是否是邮箱格式
     *
     * @param @param  strEmail
     * @param @return
     * @return boolean
     * @throws
     * @Title: isEmail
     */
    public static boolean isEmail(String strEmail) {
        Pattern p = Pattern.compile("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\\.([a-zA-Z0-9_-])+)+$");
        Matcher m = p.matcher(strEmail);
        return m.matches();
    }

    /**
     * 验证手机号码
     *
     * @param @param  mobiles
     * @param @return
     * @return boolean
     * @throws
     * @Title: isMobileNO
     */
    public static boolean isMobileNO(String mobiles) {
        if (TextUtils.isEmpty(mobiles)) {
            return false;
        }
        try {
            Pattern p = Pattern.compile("^((13[0-9])|(14[0-9])|(15[0-9])|(17[0-9])|(18[0-9]))\\d{8}");
            Matcher m = p.matcher(mobiles);
            return m.matches();
        } catch (Exception e) {
        }
        return false;
    }

    /**
     * 判断身份证是否合法
     *
     * @param IDNumber
     * @return
     */
    public static boolean isLegalId(String IDNumber) {
        boolean result = IDNumber.matches("[0-9]{15}|[0-9]{17}[0-9X]");
        if (result) {
            int year, month, date;
            if (IDNumber.length() == 15) {//一代身份证
                year = Integer.parseInt(IDNumber.substring(6, 8));
                month = Integer.parseInt(IDNumber.substring(8, 10));
                date = Integer.parseInt(IDNumber.substring(10, 12));
            } else {//二代身份证
                year = Integer.parseInt(IDNumber.substring(6, 10));
                month = Integer.parseInt(IDNumber.substring(10, 12));
                date = Integer.parseInt(IDNumber.substring(12, 14));
            }
            switch (month) {
                case 2:
                    result = (date >= 1) && (year % 4 == 0 ? date <= 29 : date <= 28);
                    break;
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    result = (date >= 1) && (date <= 31);
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    result = (date >= 1) && (date <= 30);
                    break;
                default:
                    result = false;
                    break;
            }
        }
        return result;
    }

    /**
     * 拨打电话
     *
     * @param context
     * @param phoneNum
     */
    @SuppressLint("MissingPermission")
    public static void phoneCall(Context context, String phoneNum) {
        if (TextUtils.isEmpty(phoneNum)) {
            Toast.makeText(context, "电话号码无效", Toast.LENGTH_LONG).show();
            return;
        }

        // 直接连接打电话
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNum.replace("-", "")));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                context.startActivity(intent);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void callPhone(Context context, String phoneNum) {
        if (TextUtils.isEmpty(phoneNum)) {
            Toast.makeText(context, "电话号码无效", Toast.LENGTH_LONG).show();
            return;
        }

        // 打电话
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNum.replace("-", "")));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取手机号
     *
     * @param context
     * @return
     */
    public static String getPhoneNum(Context context) {
        //获取手机号码
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            String deviceid = tm.getDeviceId();//获取智能设备唯一编号
            String te1 = tm.getLine1Number();//获取本机号码
            String imei = tm.getSimSerialNumber();//获得SIM卡的序号
            String imsi = tm.getSubscriberId();//得到用户Id
            return te1;
        } else {
            return "";
        }

    }

    public static void showToastCenter(Context context, String msg) {
        //中间弹出 toast
        Toast toast = Toast.makeText(context, "" + msg, Toast.LENGTH_SHORT);
        //设置gravity属性，以改变默认位置
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }

    //没网的时候显示的toast
    public static void noNetworkShowToast(Context context) {
        Toast.makeText(context, "无法连接到服务器，请检查网络设置", Toast.LENGTH_SHORT).show();
    }

    /**
     * 判断GPS是否开启，GPS或者AGPS开启一个就认为是开启的
     *
     * @param context
     * @return true 表示开启
     */
    public static final boolean isOPenGPS(final Context context) {
        LocationManager locationManager
                = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        // 通过GPS卫星定位，定位级别可以精确到街（通过24颗卫星定位，在室外和空旷的地方定位准确、速度快）
        boolean gps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        // 通过WLAN或移动网络(3G/2G)确定的位置（也称作AGPS，辅助GPS定位。主要用于在室内或遮盖物（建筑群或茂密的深林等）密集的地方定位）
        boolean network = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        if (gps || network) {
            return true;
        }
        return false;
    }

    /**
     * 强制打开GPS
     *
     * @param context
     */
    public static final void openGPS(Context context) {
        Intent GPSIntent = new Intent();
        GPSIntent.setClassName("com.android.settings",
                "com.android.settings.widget.SettingsAppWidgetProvider");
        GPSIntent.addCategory("android.intent.category.ALTERNATIVE");
        GPSIntent.setData(Uri.parse("custom:3"));
        try {
            PendingIntent.getBroadcast(context, 0, GPSIntent, 0).send();
        } catch (CanceledException e) {
            e.printStackTrace();
        }
    }

    /**
     * 网络是否可用
     *
     * @param context
     * @return
     */
    public static boolean isNetworkAvailable(Context context) {
        try {
            ConnectivityManager manger = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = manger.getActiveNetworkInfo();
            if (info != null) {
                return info.isConnected();
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 连接的是WiFi 还是 手机
     *
     * @param context
     * @return
     */
    public static int isWifiOrPhone(Context context) {
        try {
            ConnectivityManager manger = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = manger.getActiveNetworkInfo();
            if (info != null) {
                if (info.getType() == ConnectivityManager.TYPE_WIFI) {//wifi
                    return ConnectivityManager.TYPE_WIFI;//1
                }
                if (info.getType() == ConnectivityManager.TYPE_MOBILE) {//手机
                    return ConnectivityManager.TYPE_MOBILE;
                }
            } else {
                return -1;
            }
        } catch (Exception e) {
            return -1;
        }
        return -1;
    }

    /**
     * 获取WiFi  IP
     *
     * @param context
     * @return
     */
    @SuppressLint("MissingPermission")
    public static String getWifiIP(Context context) {
        //获取wifi服务
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        //判断wifi是否开启
        if (!wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(true);
        }
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        int ipAddress = wifiInfo.getIpAddress();
        String ip = intToIp(ipAddress);
        return ip;
    }

    public static String intToIp(int i) {
        return (i & 0xFF) + "." + ((i >> 8) & 0xFF) + "." + ((i >> 16) & 0xFF)
                + "." + (i >> 24 & 0xFF);
    }

    /**
     * 获取手机IP
     *
     * @return
     */
    public static String getLocalIp() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface
                    .getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf
                        .getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException ex) {
            LecoUtils.logE("Wifi IpAddress", ex.toString());
        }
        return null;
    }

    /**
     * 获取手机IMEI
     *
     * @param context
     * @return
     */
    public static String getIMEI(Context context) {
        TelephonyManager TelephonyMgr = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            String szImei = TelephonyMgr.getDeviceId();
            return szImei;
        }else {
            return "";
        }

    }

    /**
     * 获取手机唯一码SerialNumber
     *
     * @param context
     * @return
     */
    public static String getSerialNumber(Context context) {
        String SerialNumber = Build.SERIAL;
        return SerialNumber;
    }

    /**
     * 获取MAC地址 Linux命令方式
     *
     * @return
     * @Deprecated 经过wuheng的测试，wifi关了之后/sys/class/net/wlan0文件夹不存在
     */
    /*@Deprecated
    public static String getMac() {
		String macSerial = null;
		String str = "";
		try {
			Process pp = Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address");
			InputStreamReader ir = new1 InputStreamReader(pp.getInputStream());
			LineNumberReader input = new1 LineNumberReader(ir);
			for (; null != str; ) {
				str = input.readLine();
				if (str != null) {
					macSerial = str.trim();// 去空格
					break;
				}
			}
		} catch (IOException ex) {
			// 赋予默认值
			ex.printStackTrace();
		}
		System.out.println("-------------getMac----------------" + macSerial);
		return macSerial;
	}*/
    public static String getWifiMac(Context context) {
        //获取wifi服务
        LecoUtils.Log("getWifiMac 111");
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        LecoUtils.Log("getWifiMac wifiManager=" + wifiManager);
        LecoUtils.Log("getWifiMac 222");
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        //判断wifi是否开启
        /*if (!wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(true);
		}*/

        String macAddress = null;
        if (wifiInfo == null) {
            Toast.makeText(context, "请打开网路", Toast.LENGTH_SHORT).show();
        } else {
            macAddress = wifiInfo.getMacAddress();
        }

        return macAddress;
    }

    /**
     * 星号代替手机号中间的数字
     *
     * @param mobilePhone
     * @return
     */
    public static String replacePhoneWithStar(String mobilePhone) {
        int length = mobilePhone.length();
        char[] c = new char[length];
        if (length > 3) {
            mobilePhone.getChars(0, length, c, 0);
            for (int i = 3; i < 7 && i < length; i++) {
                c[i] = '*';
            }
        }
        return new String(c);
    }

    /**
     * @param uri
     * @return
     */
    public static Intent getCropImageIntent(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 300);//不能太大 不然不能裁剪
        intent.putExtra("outputY", 300);
        intent.putExtra("return-data", true);
        return intent;
    }

    /**
     * 压缩图片
     *
     * @param srcPath
     * @return
     */
    public static Bitmap getimage(String srcPath) {
        if (srcPath == null || srcPath.equals("")) {
            return null;
        }
        BitmapFactory.Options newOpts = new BitmapFactory.Options();
        // 开始读入图片，此时把options.inJustDecodeBounds 设回true了
        newOpts.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeFile(srcPath, newOpts);// 此时返回bm为空

        newOpts.inJustDecodeBounds = false;
        int w = newOpts.outWidth;
        int h = newOpts.outHeight;
        // 现在主流手机比较多是800*480分辨率，所以高和宽我们设置为
        float hh = 800f;// 这里设置高度为800f
        float ww = 480f;// 这里设置宽度为480f
        // 缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
        int be = 1;// be=1表示不缩放
        if (w > h && w > ww) {// 如果宽度大的话根据宽度固定大小缩放
            be = (int) (newOpts.outWidth / ww);
        } else if (w < h && h > hh) {// 如果高度高的话根据宽度固定大小缩放
            be = (int) (newOpts.outHeight / hh);
        }
        if (be <= 0)
            be = 1;
        newOpts.inSampleSize = be;// 设置缩放比例
        // 重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了
        bitmap = BitmapFactory.decodeFile(srcPath, newOpts);
        try {
            bitmap.compress(CompressFormat.PNG, 100, new FileOutputStream(srcPath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return bitmap;// 压缩好比例大小后再进行质量压缩
    }

    /**
     * 压缩bitmap
     *
     * @param image
     * @return
     */
    public static Bitmap comp(Bitmap image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(CompressFormat.PNG, 100, baos);
        System.err.println("baos.toByteArray().length==" + baos.toByteArray().length);
        if (baos.toByteArray().length > 1024) {//判断如果图片大于1M,进行压缩避免在生成图片（BitmapFactory.decodeStream）时溢出
            baos.reset();//重置baos即清空baos
            image.compress(CompressFormat.PNG, 80, baos);//这里压缩80%，把压缩后的数据存放到baos中
        }
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());
        BitmapFactory.Options newOpts = new BitmapFactory.Options();
        //开始读入图片，此时把options.inJustDecodeBounds 设回true了
        newOpts.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, newOpts);
        newOpts.inJustDecodeBounds = false;
        int w = newOpts.outWidth;
        int h = newOpts.outHeight;
        //现在主流手机比较多是800*480分辨率，所以高和宽我们设置为
        float hh = 800f;//这里设置高度为800f
        float ww = 480f;//这里设置宽度为480f
        //缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
        int be = 1;//be=1表示不缩放
        if (w > h && w > ww) {//如果宽度大的话根据宽度固定大小缩放
            be = (int) (newOpts.outWidth / ww);
        } else if (w < h && h > hh) {//如果高度高的话根据宽度固定大小缩放
            be = (int) (newOpts.outHeight / hh);
        }
        if (be <= 0)
            be = 1;
        newOpts.inSampleSize = be;//设置缩放比例
        //重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了
        isBm = new ByteArrayInputStream(baos.toByteArray());
        bitmap = BitmapFactory.decodeStream(isBm, null, newOpts);
        //return compressImage(bitmap);//压缩好比例大小后再进行质量压缩
        return bitmap;//
    }

    public static Bitmap compressImage(Bitmap image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(CompressFormat.PNG, 100, baos);//质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
        System.err.println("22baos.toByteArray().length/1024==" + baos.toByteArray().length / 1024);
        int options = 100;
        while (baos.toByteArray().length / 1024 > 1024) {  //循环判断如果压缩后图片是否大于100kb,大于继续压缩         1M
            baos.reset();//重置baos即清空baos
            image.compress(CompressFormat.PNG, options, baos);//这里压缩options%，把压缩后的数据存放到baos中
            options -= 10;//每次都减少10
        }
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());//把压缩后的数据baos存放到ByteArrayInputStream中
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);//把ByteArrayInputStream数据生成图片
        return bitmap;
    }

    /**
     * 根据路径获取图片资源（已缩放）
     *
     * @param url    图片存储路径
     * @param width  缩放的宽度
     * @param height 缩放的高度
     * @return
     */
    public static Bitmap getBitmapFromUrl(String url, double width, double height) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true; // 设置了此属性一定要记得将值设置为false
        Bitmap bitmap = BitmapFactory.decodeFile(url, options);
        // 防止OOM发生
        options.inJustDecodeBounds = false;
        int mWidth = bitmap.getWidth();
        int mHeight = bitmap.getHeight();
        Matrix matrix = new Matrix();
        float scaleWidth = 1;
        float scaleHeight = 1;
        // 按照固定宽高进行缩放
        // 这里希望知道照片是横屏拍摄还是竖屏拍摄
        // 因为两种方式宽高不同，缩放效果就会不同
        // 这里用了比较笨的方式
        if (mWidth <= mHeight) {
            scaleWidth = (float) (width / mWidth);
            scaleHeight = (float) (height / mHeight);
        } else {
            scaleWidth = (float) (height / mWidth);
            scaleHeight = (float) (width / mHeight);
        }
//        matrix.postRotate(90); /* 翻转90度 */
        // 按照固定大小对图片进行缩放
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap newBitmap = Bitmap.createBitmap(bitmap, 0, 0, mWidth, mHeight, matrix, true);
        // 用完了记得回收
        bitmap.recycle();
        return newBitmap;
    }

    /**
     * 枚举所有挂载点
     */
    public static String[] getVolumePaths(Context context) {
        String[] paths = null;
        StorageManager mStorageManager;
        Method mMethodGetPaths = null;
        try {
            mStorageManager = (StorageManager) context
                    .getSystemService(Activity.STORAGE_SERVICE);
            mMethodGetPaths = mStorageManager.getClass().getMethod(
                    "getVolumePaths");
            paths = (String[]) mMethodGetPaths.invoke(mStorageManager);
            for (int i = 0; i < paths.length; i++) {
                Log.e("miles", "paths = " + i + " = " + paths[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paths;
    }

    /**
     *  rawable 转 bitmap
     */

//    BitmapDrawable bd = (BitmapDrawable) rawable;
//    Bitmap bm = bd.getBitmap();

    /**
     * drawable 转  bitmap
     *
     * @param drawable
     * @return
     */
    public static Bitmap drawable2Bitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        } else if (drawable instanceof NinePatchDrawable) {
            Bitmap bitmap = Bitmap
                    .createBitmap(
                            drawable.getIntrinsicWidth(),
                            drawable.getIntrinsicHeight(),
                            drawable.getOpacity() != PixelFormat.OPAQUE ? Config.ARGB_8888
                                    : Config.RGB_565);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                    drawable.getIntrinsicHeight());
            drawable.draw(canvas);
            return bitmap;
        } else {
            return null;
        }
    }

    /**
     * drawable 资源id 转bitmap
     *
     * @param context
     * @param resid   资源id
     * @return
     */
    public static Bitmap res2Bitmap(Context context, int resid) {
        Resources res = context.getResources();
        Bitmap bmp = BitmapFactory.decodeResource(res, resid);
        return bmp;
    }

    /**
     * bitmap 转 byte[]
     *
     * @param bm
     * @return
     */
    public static byte[] Bitmap2Bytes(Bitmap bm) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    }

    /**
     * byte[] 转 bitmap
     *
     * @param b
     * @return
     */
    public static Bitmap Bytes2Bimap(byte[] b) {
        if (b.length != 0) {
            return BitmapFactory.decodeByteArray(b, 0, b.length);
        } else {
            return null;
        }
    }

    /**
     * file转byte[]
     *
     * @param filePath 文件路径
     * @return
     */
    public static byte[] File2byte(String filePath) {
        byte[] buffer = null;
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

    /**
     * byte[]转file
     *
     * @param buf
     * @param filePath 文件路径
     * @param fileName 文件名
     */
    public static void byte2File(byte[] buf, String filePath, String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            File dir = new File(filePath);
            if (!dir.exists() && dir.isDirectory()) {
                dir.mkdirs();
            }
            file = new File(filePath + File.separator + fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(buf);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 隐藏输入法
     *
     * @param context
     * @param v
     */
    public static void hideInput(Context context, View v) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    //显示虚拟键盘
    public static void ShowKeyboard(View v) {
        v.setFocusable(true);
        v.setFocusableInTouchMode(true);
        v.requestFocus();
        InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(v, 0);

    }

    public static void closeBoard(Context mcontext) {
        InputMethodManager imm = (InputMethodManager) mcontext
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive()) // 一直是true
            imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT,
                    InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)+0.5f
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dp2px(Context context, int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

    /**
     * 时间的差值  ms
     *
     * @param times
     * @return
     */
    public static long diffTime(long times) {
        long off = System.currentTimeMillis() - times;
        return off;
    }

    /**
     * 将时间戳转为代表"距现在多久之前"的字符串
     *
     * @param timeStr 时间戳
     * @return
     */
    public static String getStandardDate(String timeStr) {

        StringBuffer sb = new StringBuffer();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            long t = Long.parseLong(format.parse(timeStr).getTime() + "");
            long time = System.currentTimeMillis() - (t);
            long mill = (long) Math.ceil(time / 1000);//秒前

            long minute = (long) Math.ceil(time / 60 / 1000.0f);// 分钟前

            long hour = (long) Math.ceil(time / 60 / 60 / 1000.0f);// 小时

            long day = (long) Math.ceil(time / 24 / 60 / 60 / 1000.0f);// 天前

            if (day - 1 > 0) {
                sb.append(day + "天");
            } else if (hour - 1 > 0) {
                if (hour >= 24) {
                    sb.append("1天");
                } else {
                    sb.append(hour + "小时");
                }
            } else if (minute - 1 > 0) {
                if (minute == 60) {
                    sb.append("1小时");
                } else {
                    sb.append(minute + "分钟");
                }
            } else if (mill - 1 > 0) {
                if (mill == 60) {
                    sb.append("1分钟");
                } else {
                    sb.append(mill + "秒");
                }
            } else {
                sb.append("刚刚");
            }
            if (!sb.toString().equals("刚刚")) {
                sb.append("前");
            }
        } catch (ParseException e) {
            e.printStackTrace();
            sb.append("刚刚");
        }
        return sb.toString();
    }


    ////////////////////////
    // 添加大小月月份并将其转换为list,方便之后的判断
    static String[] months_big = new String[]{"1", "3", "5", "7", "8", "10", "12"};
    static String[] months_little = new String[]{"4", "6", "9", "11"};

    static List<String> list_big = Arrays.asList(months_big);
    static List<String> list_little = Arrays.asList(months_little);

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0 || (year % 4 == 0) && (year % 100 != 0)) {
            return true;
        }
        return false;
    }

    /**==============================================日期==============================*/
    /**
     * 将long时间转成yyyy-MM-dd HH:mm:ss字符串<br>
     * @param timeInMillis 时间long值
     * @return yyyy-MM-dd HH:mm:ss
     */
//    public static String getDateTimeFromMillis(long timeInMillis) {
//        return getDateTimeFormat(new Date(timeInMillis));
//    }
    /**
     * 将date转成yyyy-MM-dd HH:mm:ss字符串
     * <br>
     * @param date Date对象
     * @return yyyy-MM-dd HH:mm:ss
     */
//    public static String getDateTimeFormat(Date date) {
//        return dateSimpleFormat(date, defaultDateTimeFormat.get());
//    }

    /**
     * 将年月日的int转成yyyy-MM-dd的字符串
     *
     * @param year  年
     * @param month 月 1-12
     * @param day   日
     *              注：月表示Calendar的月，比实际小1
     *              对输入项未做判断
     */
    public static String getDateFormat(int year, int month, int day) {
        return getDateFormat(getDate(year, month, day));
    }

    public static String getDateFormat(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        return sdf.format(date);
    }
    /**
     * 获得HH:mm:ss的时间
     * @param date
     * @return
     */
//    public static String getTimeFormat(Date date) {
//        return dateSimpleFormat(date, defaultTimeFormat.get());
//    }

    /**
     * 格式化日期显示格式
     * @param sdate 原始日期格式 "yyyy-MM-dd"
     * @param format 格式化后日期格式
     * @return 格式化后的日期显示
     */
//    public static String dateFormat(String sdate, String format) {
//        SimpleDateFormat formatter = new SimpleDateFormat(format);
//        java.sql.Date date = java.sql.Date.valueOf(sdate);
//        return dateSimpleFormat(date, formatter);
//    }
    /**
     * 格式化日期显示格式
     * @param date Date对象
     * @param format 格式化后日期格式
     * @return 格式化后的日期显示
     */
//    public static String dateFormat(Date date, String format) {
//        SimpleDateFormat formatter = new SimpleDateFormat(format);
//        return dateSimpleFormat(date, formatter);
//    }

    /**
     * 将date转成字符串
     * @param date Date
     * @param format SimpleDateFormat
     * <br>
     * 注： SimpleDateFormat为空时，采用默认的yyyy-MM-dd HH:mm:ss格式
     * @return yyyy-MM-dd HH:mm:ss
     */
//    public static String dateSimpleFormat(Date date, SimpleDateFormat format) {
//        if (format == null)
//            format = defaultDateTimeFormat.get();
//        return (date == null ? "" : format.format(date));
//    }

    /**
     * 将"yyyy-MM-dd HH:mm:ss" 格式的字符串转成Date
     * @param strDate 时间字符串
     * @return Date
     */
//    public static Date getDateByDateTimeFormat(String strDate) {
//        return getDateByFormat(strDate, defaultDateTimeFormat.get());
//    }

    /**
     * 将"yyyy-MM-dd" 格式的字符串转成Date
     * @param strDate
     * @return Date
     */
//    public static Date getDateByDateFormat(String strDate) {
//        return getDateByFormat(strDate, defaultDateFormat.get());
//    }

    /**
     * 将指定格式的时间字符串转成Date对象
     * @param strDate 时间字符串
     * @param format 格式化字符串
     * @return Date
     */
//    public static Date getDateByFormat(String strDate, String format) {
//        return getDateByFormat(strDate, new SimpleDateFormat(format));
//    }

    /**
     * 将String字符串按照一定格式转成Date<br>
     * 注： SimpleDateFormat为空时，采用默认的yyyy-MM-dd HH:mm:ss格式
     * @param strDate 时间字符串
     * @param format SimpleDateFormat对象
     * @exception ParseException 日期格式转换出错
     */
//    private static Date getDateByFormat(String strDate, SimpleDateFormat format) {
//        if (format == null)
//            format = defaultDateTimeFormat.get();
//        try {
//            return format.parse(strDate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }        return null;
//    }

    /**
     * 将年月日的int转成date
     *
     * @param year  年
     * @param month 月 1-12
     * @param day   日
     *              注：月表示Calendar的月，比实际小1
     */
    public static Date getDate(int year, int month, int day) {
        Calendar mCalendar = Calendar.getInstance();
        mCalendar.set(year, month - 1, day);
        return mCalendar.getTime();
    }

    /**
     * 求两个日期相差天数
     *
     * @param strat 起始日期，格式yyyy-MM-dd
     * @param end   终止日期，格式yyyy-MM-dd
     * @return 两个日期相差天数
     */
    public static long getIntervalDays(String strat, String end) {
        return ((java.sql.Date.valueOf(end)).getTime() - (java.sql.Date
                .valueOf(strat)).getTime()) / (3600 * 24 * 1000);
    }

    /**
     * 获得当前年份
     *
     * @return year(int)
     */
    public static int getCurrentYear() {
        Calendar mCalendar = Calendar.getInstance();
        return mCalendar.get(Calendar.YEAR);
    }

    /**
     * 获得当前月份
     *
     * @return month(int) 1-12
     */
    public static int getCurrentMonth() {
        Calendar mCalendar = Calendar.getInstance();
        return mCalendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 获得当月几号
     *
     * @return day(int)
     */
    public static int getDayOfMonth() {
        Calendar mCalendar = Calendar.getInstance();
        return mCalendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获得今天的日期(格式：yyyy-MM-dd)
     *
     * @return yyyy-MM-dd
     */
    public static String getToday2() {
        Calendar mCalendar = Calendar.getInstance();
        return getDateFormat(mCalendar.getTime());
    }

    /**
     * 获得昨天的日期(格式：yyyy-MM-dd)
     *
     * @return yyyy-MM-dd
     */
    public static String getYesterday() {
        Calendar mCalendar = Calendar.getInstance();
        mCalendar.add(Calendar.DATE, -1);
        return getDateFormat(mCalendar.getTime());
    }

    /**
     * 获得前天的日期(格式：yyyy-MM-dd)
     *
     * @return yyyy-MM-dd
     */
    public static String getBeforeYesterday() {
        Calendar mCalendar = Calendar.getInstance();
        mCalendar.add(Calendar.DATE, -2);
        return getDateFormat(mCalendar.getTime());
    }

    /**
     * 获得几天之前或者几天之后的日期
     *
     * @param diff 差值：正的往后推，负的往前推
     * @return
     */
    public static String getOtherDay(int diff) {
        Calendar mCalendar = Calendar.getInstance();
        mCalendar.add(Calendar.DATE, diff);
        return getDateFormat(mCalendar.getTime());
    }

    /**
     * 取得给定日期加上一定天数后的日期对象.
     *
     * @param //date 给定的日期对象
     * @param amount 需要添加的天数，如果是向前的天数，使用负数就可以.
     * @return Date 加上一定天数以后的Date对象.
     */
//    public static String getCalcDateFormat(String sDate, int amount) {
//        Date date = getCalcDate(getDateByDateFormat(sDate), amount);
//        return getDateFormat(date);
//    }

    /**
     * 取得给定日期加上一定天数后的日期对象.
     *
     * @param date   给定的日期对象
     * @param amount 需要添加的天数，如果是向前的天数，使用负数就可以.
     * @return Date 加上一定天数以后的Date对象.
     */
    public static Date getCalcDate(Date date, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, amount);
        return cal.getTime();
    }

    /**
     * 获得明天日期
     *
     * @return
     */
    public static String getTomoData() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);
        if (month == 2) {
            if (day == 28) {
                if (isLeapYear(year)) {
                    day = 29;
                } else {
                    day = 1;
                    month++;
                }
            } else if (day == 29) {
                day = 1;
                month++;
            } else {
                day++;
            }
        } else {
            if (day == 30) {
                if (list_big.contains(String.valueOf(month))) {
                    day = 31;
                }
                if (list_little.contains(String.valueOf(month))) {
                    day = 1;
                    if (month == 12) {
                        year++;
                        month = 1;
                    } else {
                        month++;
                    }
                }
            } else if (day == 31) {
                day = 1;
                if (month == 12) {
                    year++;
                    month = 1;
                } else {
                    month++;
                }
            } else {
                day++;
            }
        }
        String data = year + "-" + month + "-" + day;
        return data;
    }

    /**
     * 获得后天日期
     *
     * @return
     */
    public static String getTheDayData() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);
        if (month == 2) {
            if (day == 28) {
                if (isLeapYear(year)) {
                    day = 1;
                    month++;
                } else {
                    day = 2;
                    month++;
                }
            } else if (day == 27) {
                if (isLeapYear(year)) {
                    day = 29;
                } else {
                    day = 1;
                    month++;
                }
            } else if (day == 29) {
                day = 2;
                month++;
            } else {
                day = day + 2;
            }
        } else {
            if (day == 30) {
                if (list_big.contains(String.valueOf(month))) {
                    day = 1;
                    if (month == 12) {
                        year++;
                        month = 1;
                    } else {
                        month++;
                    }
                }
                if (list_little.contains(String.valueOf(month))) {
                    day = 2;
                    if (month == 12) {
                        year++;
                        month = 1;
                    } else {
                        month++;
                    }
                }
            } else if (day == 31) {
                day = 2;
                if (month == 12) {
                    year++;
                    month = 1;
                } else {
                    month++;
                }
            } else if (day == 29) {
                if (list_big.contains(String.valueOf(month))) {
                    day = 31;
                }
                if (list_little.contains(String.valueOf(month))) {
                    day = 1;
                    if (month == 12) {
                        year++;
                        month = 1;
                    } else {
                        month++;
                    }
                }
            } else {
                day = day + 2;
            }
        }
        String data = year + "-" + month + "-" + day;
        return data;
    }

    ////////////////////////

    /**************************** DES 加密 ****************************** **/
    /**
     * DES：算法DES要求密钥长度为64位密钥, 有效密钥56位。64bits=8*8*1，即8个ascii字符。
     * DESede：算法DESede要求的密钥位数为192位，即192bits=64*3=8*8*3，即24个ascii字符。
     * Blowfish：算法Blowfish要求密钥长度为8--448字位，即8--448(bits)。即：1个到56个ascii字符
     */
    private static SecretKey createSecretKey(String algorithm, String keyStr) {
        // 声明KeyGenerator对象
        // KeyGenerator keygen;
        // 声明 密钥对象
        // SecretKey deskey = null;
        SecretKeySpec key = new SecretKeySpec(keyStr.getBytes(), algorithm);
        return key;
    }

    /**
     * password密码是8位的长度
     *
     * @param info
     *            要加密的字串
     * @param password
     *            由于算法DES要求密钥长度为64位密钥, 有效密钥56位。64bits=8*8*1，即8个ascii字符。
     * @return
     */
//	public static String encryptToDES(String info, String password) {
//		SecretKey key = createSecretKey("DES", password);
//		// 定义 加密算法,可用 DES,DESede,Blowfish
//		String Algorithm = "DES";
//		// 加密随机数生成器 (RNG),(可以不写)
//		// SecureRandom sr = new1 SecureRandom();
//		// 定义要生成的密文
//		byte[] cipherByte = null;
//		try {
//			// 得到加密/解密器
//			Cipher c1 = Cipher.getInstance(Algorithm);
//			// 用指定的密钥和模式初始化Cipher对象
//			// 参数:(ENCRYPT_MODE, DECRYPT_MODE, WRAP_MODE,UNWRAP_MODE)
//			c1.init(Cipher.ENCRYPT_MODE, key);
//			// 对要加密的内容进行编码处理,
//			cipherByte = c1.doFinal(info.getBytes());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		if (cipherByte == null) {
//			return "";
//		} else {
//			// 返回密文的十六进制形式
//			// return byteArrayToString(cipherByte);
//			return encodeBase64(cipherByte);
//		}
//	}
//
//	public static String decryptByDES(String s, String password) {
//		// byte[] sInfo = stringToByteArray(s);
//		byte[] sInfo = decodeBase64(s);
//		if (sInfo == null) {
//			return null;
//		}
//		SecretKey key = createSecretKey("DES", password);
//		// 定义 加密算法,
//		String Algorithm = "DES";
//		// 加密随机数生成器 (RNG)
//		// SecureRandom sr = new1 SecureRandom();
//		byte[] cipherByte = null;
//		try {
//			// 得到加密/解密器
//			Cipher c1 = Cipher.getInstance(Algorithm);
//			// 用指定的密钥和模式初始化Cipher对象
//			c1.init(Cipher.DECRYPT_MODE, key);
//			// 对要解密的内容进行编码处理
//			cipherByte = c1.doFinal(sInfo);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		// return byte2hex(cipherByte);
//		// System.out.println(cipherByte);
//		if (cipherByte == null) {
//			return "";
//		} else {
//			return new1 String(cipherByte);
//		}
//	}

    /** DES 加密 end **/

    /*************************
     * Base64编码与解码
     *******************************/
    private final static char[] ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

    private static int[] toInt = new int[128];

    static {
        for (int i = 0; i < ALPHABET.length; i++) {
            toInt[ALPHABET[i]] = i;
        }
    }

    /**
     * Translates the specified byte array into Base64 string.
     *
     * @param buf the byte array (not null)
     * @return the translated Base64 string (not null)
     */
    public static String encodeBase64(byte[] buf) {
        int size = buf.length;
        char[] ar = new char[((size + 2) / 3) * 4];
        int a = 0;
        int i = 0;
        while (i < size) {
            byte b0 = buf[i++];
            byte b1 = (i < size) ? buf[i++] : 0;
            byte b2 = (i < size) ? buf[i++] : 0;

            int mask = 0x3F;
            ar[a++] = ALPHABET[(b0 >> 2) & mask];
            ar[a++] = ALPHABET[((b0 << 4) | ((b1 & 0xFF) >> 4)) & mask];
            ar[a++] = ALPHABET[((b1 << 2) | ((b2 & 0xFF) >> 6)) & mask];
            ar[a++] = ALPHABET[b2 & mask];
        }
        switch (size % 3) {
            case 1:
                ar[--a] = '=';
            case 2:
                ar[--a] = '=';
        }
        return new String(ar);
    }

    /**
     * 字符串进行Base64编码
     *
     * @param str
     */
    public static String StringToBase64(String str) {
        String encodedString = Base64.encodeToString(str.getBytes(), Base64.DEFAULT);
        return encodedString;
    }

    /**
     * 字符串进行Base64解码
     *
     * @param encodedString
     * @return
     */
    public static String Base64ToString(String encodedString) {
        String decodedString = new String(Base64.decode(encodedString, Base64.DEFAULT));
        return decodedString;
    }

    /**
     * Translates the specified Base64 string into a byte array.
     *
     * @param s the Base64 string (not null)
     * @return the byte array (not null)
     */
    public static byte[] decodeBase64(String s) {
        int delta = s.endsWith("==") ? 2 : s.endsWith("=") ? 1 : 0;
        byte[] buffer = new byte[s.length() * 3 / 4 - delta];
        int mask = 0xFF;
        int index = 0;
        for (int i = 0; i < s.length(); i += 4) {
            int c0 = toInt[s.charAt(i)];
            int c1 = toInt[s.charAt(i + 1)];
            buffer[index++] = (byte) (((c0 << 2) | (c1 >> 4)) & mask);
            if (index >= buffer.length) {
                return buffer;
            }
            int c2 = toInt[s.charAt(i + 2)];
            buffer[index++] = (byte) (((c1 << 4) | (c2 >> 2)) & mask);
            if (index >= buffer.length) {
                return buffer;
            }
            int c3 = toInt[s.charAt(i + 3)];
            buffer[index++] = (byte) (((c2 << 6) | c3) & mask);
        }
        return buffer;
    }
/************************* Base64编码与解码 end *******************************/

    /*************************
     * MD5加密
     *******************************/

    private static final char HEX_DIGITS[] = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String toHexString(byte[] b) {
        // String to byte
        StringBuilder sb = new StringBuilder(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            sb.append(HEX_DIGITS[(b[i] & 0xf0) >>> 4]);
            sb.append(HEX_DIGITS[b[i] & 0x0f]);
        }
        return sb.toString();
    }

    public static String md5(String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = MessageDigest
                    .getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            return toHexString(messageDigest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
/************************* MD5加密 end  *******************************/


//	public static String decryptPrivateKeyByDES(String s, String password) {
//		String newPwd = (password + "00000000").substring(0,8);
//		return decryptByDES(s, newPwd);
//	}
//
//	public static String generateStringId() {
//		return toHexString(UUID.randomUUID().toString().getBytes());
//	}
//
//	public static void main(String[] args) {
//		String s = encryptToDES("123456 sad9asklf23#￥……&*", "12345678");
//		System.out.println(s);
//
//		String ss = decryptByDES(s, "12345678");
//		System.out.println(ss);
//	}
/////////////////////////////////////

    /**
     * 上传图片
     *
     * @param urlStr
     * @param textMap
     * @param fileMap
     * @return
     */
    public static String formUpload(String urlStr, Map<String, String> textMap, Map<String, String> fileMap) {
        String res = "";
        HttpURLConnection conn = null;
        String BOUNDARY = "---------------------------123821742118716"; //boundary就是request头和上传文件内容的分隔符
        try {
            URL url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(30000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("User-Agent", "Windows (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");
            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);

            OutputStream out = new DataOutputStream(conn.getOutputStream());
            // text
            if (textMap != null) {
                StringBuffer strBuf = new StringBuffer();
                Iterator<Map.Entry<String, String>> iter = textMap.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry<String, String> entry = iter.next();
                    String inputName = (String) entry.getKey();
                    String inputValue = (String) entry.getValue();
                    if (inputValue == null) {
                        continue;
                    }
                    strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
                    strBuf.append("Content-Disposition: form-data; name=\"" + inputName + "\"\r\n\r\n");
                    strBuf.append(inputValue);
                }
                out.write(strBuf.toString().getBytes());
            }

            // file
            if (fileMap != null) {
                Iterator<Map.Entry<String, String>> iter = fileMap.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry<String, String> entry = iter.next();
                    String inputName = (String) entry.getKey();
                    String inputValue = (String) entry.getValue();
                    if (inputValue == null) {
                        continue;
                    }
                    File file = new File(inputValue);
                    String filename = file.getName();
                    System.err.println("inputName=" + inputName + "  filename=" + filename);
                    //MagicMatch match = Magic.getMagicMatch(file, false, true);
                    //String contentType = match.getMimeType();
                    //System.err.println("contentType= "+contentType);

                    StringBuffer strBuf = new StringBuffer();
                    strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
                    strBuf.append("Content-Disposition: form-data; name=\"" + inputName + "\"; filename=\"" + filename + "\"\r\n");
                    //strBuf.append("Content-Type:" + contentType + "\r\n\r\n");
                    strBuf.append("Content-Type:" + "multipart/form-data" + "\r\n\r\n");

                    out.write(strBuf.toString().getBytes());
                    DataInputStream in = null;
                    if (file.exists()) {
                        in = new DataInputStream(new FileInputStream(file));
                    }
                    int bytes = 0;
                    byte[] bufferOut = new byte[1024];
                    while ((bytes = in.read(bufferOut)) != -1) {
                        out.write(bufferOut, 0, bytes);
                    }
                    in.close();
                }
            }

            byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();
            out.write(endData);
            out.flush();
            out.close();

            // 读取返回数据
            StringBuffer strBuf = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                strBuf.append(line).append("\n");
            }
            res = strBuf.toString();
            reader.close();
            reader = null;
        } catch (Exception e) {
            System.out.println("发送POST请求出错。" + urlStr);
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
                conn = null;
            }
        }
        return res;
    }

/************************ 高斯模糊 **********************/
    /**
     * 水平方向模糊度
     */
    private static float hRadius = 10;
    /**
     * 竖直方向模糊度
     */
    private static float vRadius = 10;
    /**
     * 模糊迭代度
     */
    private static int iterations = 7;

    /**
     * 高斯模糊
     *
     * @param bmp
     * @return
     */
    public static Drawable BoxBlurFilter(Bitmap bmp) {
        int width = bmp.getWidth();
        int height = bmp.getHeight();
        int[] inPixels = new int[width * height];
        int[] outPixels = new int[width * height];
        Bitmap bitmap = Bitmap.createBitmap(width, height,
                Config.ARGB_8888);
        bmp.getPixels(inPixels, 0, width, 0, 0, width, height);
        for (int i = 0; i < iterations; i++) {
            blur(inPixels, outPixels, width, height, hRadius);
            blur(outPixels, inPixels, height, width, vRadius);
        }
        blurFractional(inPixels, outPixels, width, height, hRadius);
        blurFractional(outPixels, inPixels, height, width, vRadius);
        bitmap.setPixels(inPixels, 0, width, 0, 0, width, height);
        Drawable drawable = new BitmapDrawable(bitmap);
        return drawable;
    }

    public static void blur(int[] in, int[] out, int width, int height,
                            float radius) {
        int widthMinus1 = width - 1;
        int r = (int) radius;
        int tableSize = 2 * r + 1;
        int divide[] = new int[256 * tableSize];

        for (int i = 0; i < 256 * tableSize; i++)
            divide[i] = i / tableSize;

        int inIndex = 0;

        for (int y = 0; y < height; y++) {
            int outIndex = y;
            int ta = 0, tr = 0, tg = 0, tb = 0;

            for (int i = -r; i <= r; i++) {
                int rgb = in[inIndex + clamp(i, 0, width - 1)];
                ta += (rgb >> 24) & 0xff;
                tr += (rgb >> 16) & 0xff;
                tg += (rgb >> 8) & 0xff;
                tb += rgb & 0xff;
            }

            for (int x = 0; x < width; x++) {
                out[outIndex] = (divide[ta] << 24) | (divide[tr] << 16)
                        | (divide[tg] << 8) | divide[tb];

                int i1 = x + r + 1;
                if (i1 > widthMinus1)
                    i1 = widthMinus1;
                int i2 = x - r;
                if (i2 < 0)
                    i2 = 0;
                int rgb1 = in[inIndex + i1];
                int rgb2 = in[inIndex + i2];

                ta += ((rgb1 >> 24) & 0xff) - ((rgb2 >> 24) & 0xff);
                tr += ((rgb1 & 0xff0000) - (rgb2 & 0xff0000)) >> 16;
                tg += ((rgb1 & 0xff00) - (rgb2 & 0xff00)) >> 8;
                tb += (rgb1 & 0xff) - (rgb2 & 0xff);
                outIndex += height;
            }
            inIndex += width;
        }
    }

    public static void blurFractional(int[] in, int[] out, int width,
                                      int height, float radius) {
        radius -= (int) radius;
        float f = 1.0f / (1 + 2 * radius);
        int inIndex = 0;

        for (int y = 0; y < height; y++) {
            int outIndex = y;

            out[outIndex] = in[0];
            outIndex += height;
            for (int x = 1; x < width - 1; x++) {
                int i = inIndex + x;
                int rgb1 = in[i - 1];
                int rgb2 = in[i];
                int rgb3 = in[i + 1];

                int a1 = (rgb1 >> 24) & 0xff;
                int r1 = (rgb1 >> 16) & 0xff;
                int g1 = (rgb1 >> 8) & 0xff;
                int b1 = rgb1 & 0xff;
                int a2 = (rgb2 >> 24) & 0xff;
                int r2 = (rgb2 >> 16) & 0xff;
                int g2 = (rgb2 >> 8) & 0xff;
                int b2 = rgb2 & 0xff;
                int a3 = (rgb3 >> 24) & 0xff;
                int r3 = (rgb3 >> 16) & 0xff;
                int g3 = (rgb3 >> 8) & 0xff;
                int b3 = rgb3 & 0xff;
                a1 = a2 + (int) ((a1 + a3) * radius);
                r1 = r2 + (int) ((r1 + r3) * radius);
                g1 = g2 + (int) ((g1 + g3) * radius);
                b1 = b2 + (int) ((b1 + b3) * radius);
                a1 *= f;
                r1 *= f;
                g1 *= f;
                b1 *= f;
                out[outIndex] = (a1 << 24) | (r1 << 16) | (g1 << 8) | b1;
                outIndex += height;
            }
            out[outIndex] = in[width - 1];
            inIndex += width;
        }
    }

    public static int clamp(int x, int a, int b) {
        return (x < a) ? a : (x > b) ? b : x;
    }

    /************************ 高斯模糊 end **********************/
}
