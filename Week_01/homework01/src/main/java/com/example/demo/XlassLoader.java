package com.example.demo;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.util.Arrays;

public class XlassLoader extends ClassLoader {
    public static void main(String[] args) {
        XlassLoader xlassLoader = new XlassLoader();
        try {
            Class<?> hello = xlassLoader.findClass("Hello");
            Object o = hello.newInstance();
            Method helloMethod = hello.getMethod("hello");
            helloMethod.invoke(o);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            File sourceFile = ResourceUtils.getFile("classpath:Hello.xlass");
            byte[] bytes = Files.readAllBytes(sourceFile.toPath());
            System.out.println(Arrays.toString(bytes));
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (255 - bytes[i]);
            }
            System.out.println(Arrays.toString(bytes));
            return defineClass(name, bytes, 0, bytes.length);
        } catch (FileNotFoundException e) {
            throw new ClassNotFoundException("文件未找到", e);
        } catch (IOException e) {
            throw new ClassNotFoundException("文件读写失败", e);
        }
    }
}
