package com.github.programmerrabbit.verifycode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * Created by Rabbit on 2016/12/15.
 */
public class VerifyCode {
    private VerifyCodeConfig config;
    private String verifyCodeText;

    private Random random = new Random();

    public VerifyCode() {
        this(new VerifyCodeConfig());
    }

    public VerifyCode(VerifyCodeConfig config) {
        this.config = config;
    }

    private BufferedImage createImage() {
        BufferedImage image = new BufferedImage(config.getWidth(), config.getHeight(), BufferedImage.TYPE_INT_BGR);
        Graphics2D graphics2D = (Graphics2D) image.getGraphics();
        graphics2D.setColor(config.getBackgroundColor());
        graphics2D.fillRect(0, 0, config.getWidth(), config.getHeight());
        return image;
    }

    private char getRandomChar() {
        int index = random.nextInt(config.getCodes().length());
        return config.getCodes().charAt(index);
    }

    private Font getRandomFont() {
        int index = random.nextInt(config.getFonts().length);
        int style = random.nextInt(4);
        int size = random.nextInt(config.getFontSizeDelta()) + config.getFontSize();
        return new Font(config.getFonts()[index], style, size);
    }

    private Color getRandomColor() {
        int bound = config.getColorIntCeiling() - config.getColorIntFloor();
        int r = random.nextInt(bound) + config.getColorIntFloor();
        int g = random.nextInt(bound) + config.getColorIntFloor();
        int b = random.nextInt(bound) + config.getColorIntFloor();
        return new Color(r, g, b);
    }

    private void drawRandomLines(BufferedImage image) {
        int num = config.getRandomLineNum();
        Graphics2D graphics2D = (Graphics2D) image.getGraphics();
        for (int i = 0; i < num; i++) {
            int x1 = random.nextInt(config.getWidth());
            int x2 = random.nextInt(config.getWidth());
            int y1 = random.nextInt(config.getHeight());
            int y2 = random.nextInt(config.getHeight());
            graphics2D.setStroke(new BasicStroke(config.getRandomLineWidth()));
            graphics2D.setColor(getRandomColor());
            graphics2D.drawLine(x1, y1, x2, y2);
        }
    }

    public BufferedImage getVerifyCodeImage() {
        BufferedImage image = createImage();
        Graphics2D graphics2D = (Graphics2D) image.getGraphics();
        StringBuilder verifyCodeTextSB = new StringBuilder();
        for (int i = 0; i < config.getVerifyCodeCharNum(); i++) {
            String verifyCodeChar = getRandomChar() + "";
            verifyCodeTextSB.append(verifyCodeChar);
            float x = i*(config.getWidth() - 2*config.getMarginLeft())*1.0F/config.getVerifyCodeCharNum();
            graphics2D.setFont(getRandomFont());
            graphics2D.setColor(getRandomColor());
            graphics2D.drawString(verifyCodeChar, x + config.getMarginLeft(), config.getHeight() - config.getMarginBottom());
        }
        drawRandomLines(image);
        verifyCodeText = verifyCodeTextSB.toString();
        return image;
    }

    public String getVerifyCodeText() {
        return verifyCodeText;
    }

    public void writeOutputStream(BufferedImage image, OutputStream outputStream) throws IOException {
        ImageIO.write(image, "JPEG", outputStream);
    }
}
