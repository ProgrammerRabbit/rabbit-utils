package com.github.programmerrabbit.test;

import java.io.File;
import java.io.FileFilter;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;

/**
 * Created by yangwen on 2016/12/3.
 */
public class Tests {
    public static void run(Class clazz) {
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            Annotation annotation = method.getAnnotation(Test.class);
            if (annotation != null) {
                try {
                    System.out.println("=== TESTS " + method.getName() + "() STARTED ===");
                    Object object = clazz.newInstance();
                    method.invoke(object);
                    System.out.println("=== TESTS " + method.getName() + "() SUCCEED ===");
                } catch (Throwable throwable) {
                    pauseToMakeConsoleOutputInOrder(10);
                    throwable.getCause().printStackTrace();
                    pauseToMakeConsoleOutputInOrder(10);
                    System.out.println("=== TESTS " + method.getName() + "() FAILED ===");
                }
                System.out.println();
            }
        }
    }

    public static void runPackage(Class clazz) {
        try {
            URL url = clazz.getResource("");
            String path = URLDecoder.decode(url.getFile(), "UTF-8");
            File dir = new File(path);
            File[] files = dir.listFiles(new FileFilter() {
                public boolean accept(File file) {
                    return file.getName().endsWith(".class") && !file.getName().contains("$");
                }
            });
            if (files != null && files.length > 0) {
                String packageName = clazz.getPackage().getName();
                for (File file : files) {
                    String className = file.getName().substring(0, file.getName().length() - 6);
                    Class classToTest = Class.forName(packageName + "." + className);
                    run(classToTest);
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void pauseToMakeConsoleOutputInOrder(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
