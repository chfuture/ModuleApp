package com.ycwang.moduleapp.annotation;

import android.app.Activity;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ycwang.
 * @date 2018-8-20.
 */
public class Utils {
    public static void injectView(Activity activity) {
        if (null == activity) {
            return;
        }

        Class<? extends Activity> activityClass = activity.getClass();
        Field[] fields = activityClass.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectView.class)) {
                InjectView annotation = field.getAnnotation(InjectView.class);
                int value = annotation.value();
                try {
                    Method findViewByIdMethod = activityClass.getMethod("findViewById", int.class);
                    findViewByIdMethod.setAccessible(true);
                    findViewByIdMethod.invoke(activity, value);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }


            }
        }
    }

}
