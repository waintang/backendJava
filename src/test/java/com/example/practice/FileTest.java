package com.example.practice;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Slf4j
public class FileTest {
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

                byte[] bytes = null ; // HttpUtil.readInputStream(singleFileInputStream);
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
        zipFiles(Arrays.asList("/Users/zqian/Downloads/华为云租户.xlsx","/Users/zqian/Downloads/微软云租户.xlsx"),"/Users/zqian/Downloads/test.zip");
    }
}
