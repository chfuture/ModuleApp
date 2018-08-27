//package com.ycwang.moduleapp.service;
//
//import android.app.Notification;
//import android.app.NotificationManager;
//import android.app.PendingIntent;
//import android.app.Service;
//import android.content.Intent;
//import android.os.Binder;
//import android.os.IBinder;
//import android.support.annotation.Nullable;
//import android.util.Log;
//
//import com.ycwang.moduleapp.R;
//
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import static java.net.Proxy.Type.HTTP;
//
///**
// * @author ycwang.
// * @date 2018-8-24.
// */
//public class ForegroundService extends Service {
//
////    private static final Class[] mStartForegroundSignature = new Class[]{int.class, Notification.class};
////
////    private static final Class[] mStopForegroundSignature = new Class[]{boolean.class};
////
////    private NotificationManager notificationManager;
////
////    private Method mStopForeground;
////
////    private Method mStartForeground;
////
////    private Object[] mStartForegroundArgs = new Object[2];
////
////    private Object[] mStopForegroundArgs = new Object[1];
////
////    @Nullable
////    @Override
////    public IBinder onBind(Intent intent) {
////        return null;
////    }
////
////    @Override
////    public void onCreate() {
////        super.onCreate();
////        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
////        try {
////            mStartForeground = ForegroundService.class.getDeclaredMethod("startForeground", mStartForegroundSignature);
////            mStopForeground = ForegroundService.class.getDeclaredMethod("stopForeground", mStopForegroundSignature);
////        } catch (NoSuchMethodException e) {
////            mStartForeground = mStopForeground = null;
////        }
////
////        Notification notification = new Notification(R.mipmap.ic_launcher,
////                "Foreground Service Started.",
////                System.currentTimeMillis());
////        PendingIntent pendingIntent = PendingIntent.getActivity(
////                this,
////                0,
////                new Intent(this, ServiceActivity.class),
////                0);
////
////        // 注意使用  startForeground ，id 为 0 将不会显示 notification
////        startForegroundCompat(1, notification);
////    }
////
////
////    @Override
////    public void onDestroy() {
////        super.onDestroy();
////        stopForegroundCompat(1);
////    }
////
////    // 以兼容性方式开始前台服务
////    private void startForegroundCompat(int id, Notification n){
////        if(mStartForeground != null){
////            mStartForegroundArgs[0] = id;
////            mStartForegroundArgs[1] = n;
////
////            try {
////                mStartForeground.invoke(this, mStartForegroundArgs);
////            } catch (IllegalArgumentException e) {
////                e.printStackTrace();
////            } catch (IllegalAccessException e) {
////                e.printStackTrace();
////            } catch (InvocationTargetException e) {
////                e.printStackTrace();
////            }
////
////            return;
////        }
////        notificationManager.notify(id, n);
////    }
////
////    private void stopForegroundCompat(int id){
////        if(mStopForeground != null){
////            mStopForegroundArgs[0] = Boolean.TRUE;
////
////            try {
////                mStopForeground.invoke(this, mStopForegroundArgs);
////            } catch (IllegalArgumentException e) {
////                e.printStackTrace();
////            } catch (IllegalAccessException e) {
////                e.printStackTrace();
////            } catch (InvocationTargetException e) {
////                e.printStackTrace();
////            }
////            return;
////        }
////
////        notificationManager.cancel(id);
////    }
//
//
//    private final static String TAG = "MyService";
//    private NotificationManager notificationMgr;
//    private boolean canRun = true;
//    private String retString = null;
//    //用于和外界交互
//    private final IBinder binder = new MyBinder();
//
//    public class MyBinder extends Binder {
//        ForegroundService getService() {
//            return ForegroundService.this;
//        }
//    }
//
//    @Override
//    public void onCreate() {
//        Thread thr = new Thread(null, new ServiceWorker(), "BackgroundSercie");
//        thr.start();
//        super.onCreate();
//    }
//
//    @Override
//    public IBinder onBind(Intent intent) {
//        Log.d(TAG, String.format("on bind,intent = %s", intent.toString()));
//        notificationMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//        displayNotificationMessage("服务已启动");
//
//        return binder;
//    }
//
//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//        Log.d(TAG, "start action=" + intent.getAction());
//        notificationMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//        displayNotificationMessage("服务已启动", true);
//        return super.onStartCommand(intent, flags, startId);
//    }
//
//    @Override
//    public void onDestroy() {
//        stopForeground(true);
//        canRun = false;
//        super.onDestroy();
//    }
//
//    public String getImage(String url) {
//        return "19";
//    }
//
//    public String getRetString() {
//        return retString;
//    }
//
//    //loginValidate 为service提供给外部调用的函数
//    public boolean loginValidate(String userName, String password) throws Exception {
//        String uriString = "http://www.renyugang.cn/blog/admin/admin_check.jsp";
//        boolean ret = false;
//        Log.d("scott", "enter myservice start loginvalidate");
//        try {
//            DefaultHttpClient httpClient = new DefaultHttpClient();
//            HttpResponse response;
//            HttpPost httpPost = new HttpPost(uriString);
//            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
//            nvps.add(new BasicNameValuePair("name", userName));
//            nvps.add(new BasicNameValuePair("password", password));
//
//            httpPost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
//            response = httpClient.execute(httpPost);
//            HttpEntity entity = response.getEntity();
//            retString = EntityUtils.toString(entity);
//            retString = str_Filter(retString);
//
//            if (response.getStatusLine().getStatusCode() == 200) {
//                if (retString.equals("") == false) {
//                    if (retString.startsWith("用户名") == true) {
//                        ret = false;
//                    } else {
//                        ret = true;
//                    }
//                    Log.d("retcontent", retString);
//                    Log.d("info", userName + password);
//                    Log.d("ret", "" + ret);
//                }
//
//            }
//        } catch (Exception e) {
//            throw e;
//        }
//        return ret;
//    }
//
//    public String str_Filter(String strSource) {
//        String strPattern = "(?i)(\r\n|\r|\n|\n\r)";
//        strSource.trim();
//        Pattern p = Pattern.compile(strPattern);
//        Matcher m = p.matcher(strSource);
//        if (m.find()) {
//            strSource = strSource.replaceAll("(\r\n|\r|\n|\n\r)", "");
//        }
//        return strSource;
//    }
//
//    //为服务设置图标和文字描述
//    private void displayNotificationMessage(String message, boolean isForeground) {
//        Notification notification = new Notification(R.mipmap.ic_launcher, message,
//                System.currentTimeMillis());
//        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
//                new Intent(this, ServiceActivity.class), 0);
//        notification.setLatestEventInfo(this, "My Service", message,
//                contentIntent);
//        MyService.this.startForeground(R.id.app_notification_id, notification);
//    }
//
//    private void displayNotificationMessage(String message) {
//        Notification notification = new Notification(R.mipmap.ic_launcher, message,
//                System.currentTimeMillis());
//        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
//                new Intent(this, ServiceActivity.class), 0);
//        notification.setLatestEventInfo(this, "我的通知", message,
//                contentIntent);
//        notificationMgr.notify(R.id.app_notification_id + 1, notification);
//    }
//
//    //ServiceWorker service自身的线程，用于做自己的事情，这里为了表示服务的确在运行，每2秒打印一次log信息。
//    class ServiceWorker implements Runnable {
//        int counter = 0;
//
//        @Override
//        public void run() {
//            // do background processing here.....
//            while (canRun) {
//                Log.d("scott", "" + counter);
//                counter++;
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//
//}
