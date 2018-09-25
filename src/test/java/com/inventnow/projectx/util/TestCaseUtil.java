package com.inventnow.projectx.util;

import org.apache.commons.io.IOUtils;

import java.io.IOException;

public class TestCaseUtil {

    private TestCaseUtil() {

    }

    public static String getContentFromFilePath(String filePath) {
        try {
            return IOUtils.toString(TestCaseUtil.class.getResourceAsStream(filePath), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
