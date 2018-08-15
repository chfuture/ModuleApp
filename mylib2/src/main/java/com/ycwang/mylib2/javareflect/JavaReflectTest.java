package com.ycwang.mylib2.javareflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ycwang.
 * @date 2018-8-14.
 */
public class JavaReflectTest {

    public static void main(String[] args) {

        try {
            Class clazz = Class.forName("com.ycwang.mylib2.javareflect.Student");

            System.out.println("***************** 所有公有构造方法 ****************");
            Constructor[] constructors = clazz.getConstructors();
            for (Constructor constructor : constructors) {
                System.out.println(constructor);
            }

            System.out.println("***************** 所有构造方法 ****************");
            constructors = clazz.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                System.out.println(constructor);
            }

            System.out.println("***************** 获取参数位char的构造方法 ****************");
            Constructor constructor = clazz.getConstructor(char.class);
            System.out.println(constructor);


            System.out.println("***************** 获取无参公有构造方法 ****************");
            constructor = clazz.getDeclaredConstructor(int.class);
            System.out.println(constructor);


            System.out.println("***************** 获取公有的字段 ****************");
            Field[] fields = clazz.getFields();
            for (Field field : fields) {
                System.out.println(field);
            }


            System.out.println("***************** 获取所有的字段 ****************");
            fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field);
            }
            System.out.println("***************** 获取特定公有的字段 ****************");
            Field field = clazz.getField("name");
            System.out.println(field);
            Constructor constructor1 = clazz.getConstructor();
            Object obj = constructor1.newInstance();
            field.set(obj, "刘德华");
            Student student = (Student) obj;
            System.out.println("student.name:===" + student.name);


            System.out.println("***************** 获取私有字段并赋值 ****************");
            field = clazz.getDeclaredField("phoneNum");
            obj = constructor1.newInstance(null);
            field.setAccessible(true);
            field.set(obj, "18883870255");
            student = (Student) obj;
            System.out.println("student.phoneNum:" + student);

            System.out.println("***************** 获取公有方法 ****************");
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                System.out.println(method);
            }

            System.out.println("***************** 获取所有方法 ****************");
            methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method);
            }


            Method method = clazz.getMethod("show1", String.class);
            System.out.println(method);
            Constructor constructor2=clazz.getConstructor();
            Object o = constructor2.newInstance();
            method.invoke(o,"刘德华");


            method=clazz.getDeclaredMethod("show4",int.class);
            method.setAccessible(true);
           String result= (String) method.invoke(o,12);
           System.out.println(result);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}
