package com.example.practice.web.util;

import org.apache.commons.lang3.StringUtils;

public class FileUtil {

    public static String getFileName(String fileUrl) {
        if (StringUtils.isBlank(fileUrl)) {
            return null;
        } else {
            int index = fileUrl.lastIndexOf("/");
            if (index < 0) {
                return fileUrl;
            } else {
                String uuidFilename = fileUrl.substring(index + 1);
                if (uuidFilename.contains("@") && uuidFilename.length() >= 33) {
                    return uuidFilename.charAt(32) == '@' ? uuidFilename.substring(33) : uuidFilename;
                } else {
                    return uuidFilename;
                }
            }
        }
    }
}
