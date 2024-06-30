package com.example.practice;

import org.apache.commons.io.DirectoryWalker;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * 找出maven库 有问题的jar包，整个文件夹删除
 */
public class FindInvalidJarAndDel extends DirectoryWalker<String> {
    public static void main(String[] args) throws IOException {
        // 查找本地maven仓库
        File startDir = new File("D:\\mvnrepository");
//        File startDir = new File("D:\\mvnrepository\\org");
//        File startDir = new File("D:\\mvnrepository\\redis");
        FindInvalidJarAndDel finder = new FindInvalidJarAndDel();
        List<String> finded = new ArrayList<>();
        finder.walk(startDir, finded);
        if (finded.size() > 0) {
            //删除对应的文件
            for (String f : finded) {
                try {
                    System.out.println(f);
                    FileUtils.forceDelete(new File(f));//删除整个文件夹
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    protected void handleFile(File file, int depth, Collection<String> results) throws IOException {
        if (results.contains(file.getParent())) {
            return;
        }
        if (file.getName().endsWith(".lastUpdated")||file.getName().toLowerCase().endsWith("resolver-status.properties")) {
            results.add(file.getParent());
            return;
        }
        if (file.getName().endsWith(".jar")) {
            //尝试解压一下，如果不能解压，则说明jar包有问题
            try {
                ZipFile zip = new ZipFile(file);
                Enumeration zipEntries = zip.entries();
                while (zipEntries.hasMoreElements()) {
                    ZipEntry entry = (ZipEntry) zipEntries.nextElement();
                    entry.getName();
                    entry.getSize();
                }
            } catch (Exception e) {
                results.add(file.getParent());
                return;
            }
        }
    }
}
