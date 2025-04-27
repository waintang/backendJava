package com.example.practice.util;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Slf4j
public class ZipUtil {

    public static void zipFiles(List<String> files, String zipName) throws Exception {
        if (CollectionUtil.isEmpty(files)) {
            return;
        }

        // 开始打zip
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ZipOutputStream zipOutputStream = new ZipOutputStream(baos)){
            long currentTimeMillis1 = System.currentTimeMillis();
            Set<String> nameSet = new HashSet<>();

            for(int i = 0; i < files.size(); i++) {

                // 下载文件
                String pathname = files.get(i);
                InputStream singleFileInputStream = Files.newInputStream(new File(pathname).toPath());
                // 压缩文件
                String fileName = pathname.substring(pathname.lastIndexOf("/") + 1);
                if (nameSet.contains(fileName)) {
                    zipOutputStream.putNextEntry(
                            new ZipEntry(fileName.lastIndexOf(".") == -1 ?
                                    fileName + i :
                                    new StringBuilder(fileName)
                                            .insert(fileName.lastIndexOf("."), i + 1)
                                            .toString()
                            )
                    );
                } else {
                    zipOutputStream.putNextEntry(new ZipEntry(fileName));
                }

                byte[] bytes = HttpUtil.readInputStream(singleFileInputStream);
                zipOutputStream.write(bytes);
                zipOutputStream.closeEntry();
                nameSet.add(fileName);
                if (singleFileInputStream != null) {
                    singleFileInputStream.close();
                }
            }
            zipOutputStream.flush();
            zipOutputStream.close();
            long currentTimeMillis2 = System.currentTimeMillis();
            log.info("zip time : "+ (currentTimeMillis2-currentTimeMillis1));
            byte[] fbaosByte = baos.toByteArray();
            zipName = StrUtil.addSuffixIfNot(zipName, ".zip");
            Files.write(Paths.get(zipName), fbaosByte);
        } catch (Exception e) {
            log.info("zip error");
            e.printStackTrace();
            throw e;
        }
    }

    public static void zipFilesAsync(List<String> files, String zipName) throws Exception {
        if (CollectionUtil.isEmpty(files)) {
            return;
        }
        List<Future<InputStream>> futureList = new ArrayList<>();
        StreamClass streamClass = new ZipUtil.StreamClass();

        // 开始打zip
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ZipOutputStream zipOutputStream = new ZipOutputStream(baos)){
            long currentTimeMillis1 = System.currentTimeMillis();
            Set<String> nameSet = new HashSet<>();
            for(int i = 0; i < files.size(); i++){
                String pathname = files.get(i);
                futureList.add(streamClass.getInputStream(pathname));
            }

            for(int i = 0; i < files.size(); i++) {
                String pathname = files.get(i);
                // 压缩文件
                InputStream singleFileInputStream = futureList.get(i).get(30, TimeUnit.SECONDS);
                String fileName = pathname.substring(pathname.lastIndexOf("/") + 1);
                if (nameSet.contains(fileName)) {
                    zipOutputStream.putNextEntry(
                            new ZipEntry(fileName.lastIndexOf(".") == -1 ?
                                    fileName + i :
                                    new StringBuilder(fileName)
                                            .insert(fileName.lastIndexOf("."), i + 1)
                                            .toString()
                            )
                    );
                } else {
                    zipOutputStream.putNextEntry(new ZipEntry(fileName));
                }

                byte[] bytes = HttpUtil.readInputStream(singleFileInputStream);
                zipOutputStream.write(bytes);
                zipOutputStream.closeEntry();
                nameSet.add(fileName);
                if (singleFileInputStream != null) {
                    singleFileInputStream.close();
                }
            }
            zipOutputStream.flush();
            zipOutputStream.close();
            long currentTimeMillis2 = System.currentTimeMillis();
            log.info("zip time : "+ (currentTimeMillis2-currentTimeMillis1));
            byte[] fbaosByte = baos.toByteArray();
            zipName = StrUtil.addSuffixIfNot(zipName, ".zip");
            Files.write(Paths.get(zipName), fbaosByte);
        } catch (Exception e) {
            log.info("zip error");
            e.printStackTrace();
            throw e;
        }
    }

    public static void main(String[] args) throws Exception {
        zipFilesAsync(Arrays.asList("C:\\Users\\TWP\\Downloads\\twp (5).yaml","C:\\Users\\TWP\\Downloads\\值集视图多语言模板.xlsx"),"twpppp.zip");
    }

    public static class StreamClass{

        @Async
        public Future<InputStream> getInputStream(String pathname) throws IOException {
            System.out.println("线程名："+Thread.currentThread().getName());
            return new AsyncResult(Files.newInputStream(new File(pathname).toPath()));
        }
    }
}
