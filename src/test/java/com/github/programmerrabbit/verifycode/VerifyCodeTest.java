package com.github.programmerrabbit.verifycode;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Rabbit on 2016/12/15.
 */
public class VerifyCodeTest {
    public static void main(String[] args) throws IOException {
        VerifyCode verifyCode = new VerifyCode();
        BufferedImage image = verifyCode.getVerifyCodeImage();
        String text = verifyCode.getVerifyCodeText();
        System.out.println(text);
        OutputStream outputStream = new FileOutputStream("D:/verifycode.jpeg");
        verifyCode.writeOutputStream(image, outputStream);
    }
}
