package com.github.programmerrabbit.verifycode;

import java.awt.*;

/**
 * Created by Rabbit on 2016/12/15.
 */
public class VerifyCodeConfig {
    private int width = 145;
    private int height = 50;
    private Color backgroundColor = new Color(255, 255, 255);
    private int colorIntCeiling = 150;
    private int colorIntFloor = 0;
    private int fontSize = 42;
    private int fontSizeDelta = 5;
    private int marginLeft = 10;
    private int marginBottom = 10;
    private int randomLineNum = 10;
    private float randomLineWidth = 1.5F;
    private int verifyCodeCharNum = 4;

    private String codes = "23456789abcdefghjkmnpqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ";
    private String[] fonts = { "Arial", "Consolas", "Times New Roman", "Dotum", "Courier New" };

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getColorIntCeiling() {
        return colorIntCeiling;
    }

    public void setColorIntCeiling(int colorIntCeiling) {
        this.colorIntCeiling = colorIntCeiling;
    }

    public int getColorIntFloor() {
        return colorIntFloor;
    }

    public void setColorIntFloor(int colorIntFloor) {
        this.colorIntFloor = colorIntFloor;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public int getFontSizeDelta() {
        return fontSizeDelta;
    }

    public void setFontSizeDelta(int fontSizeDelta) {
        this.fontSizeDelta = fontSizeDelta;
    }

    public int getMarginLeft() {
        return marginLeft;
    }

    public void setMarginLeft(int marginLeft) {
        this.marginLeft = marginLeft;
    }

    public int getMarginBottom() {
        return marginBottom;
    }

    public void setMarginBottom(int marginBottom) {
        this.marginBottom = marginBottom;
    }

    public int getRandomLineNum() {
        return randomLineNum;
    }

    public void setRandomLineNum(int randomLineNum) {
        this.randomLineNum = randomLineNum;
    }

    public float getRandomLineWidth() {
        return randomLineWidth;
    }

    public void setRandomLineWidth(float randomLineWidth) {
        this.randomLineWidth = randomLineWidth;
    }

    public int getVerifyCodeCharNum() {
        return verifyCodeCharNum;
    }

    public void setVerifyCodeCharNum(int verifyCodeCharNum) {
        this.verifyCodeCharNum = verifyCodeCharNum;
    }

    public String getCodes() {
        return codes;
    }

    public void setCodes(String codes) {
        this.codes = codes;
    }

    public String[] getFonts() {
        return fonts;
    }

    public void setFonts(String[] fonts) {
        this.fonts = fonts;
    }
}
