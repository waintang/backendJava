package com.example.practice.util;

import com.example.practice.web.util.FileUtil;

public class FileUtilTest {
    public static void main(String[] args) {
        String fileUrl = "TWP2024031801外协-附件压缩埋点&附件回调保存&任意人直接完成外协&查询对方新增的协同人-外协附件-20240318 015452.zip";
        String fileName = FileUtil.getFileName(fileUrl);
        System.out.println(fileName);
    }
}
