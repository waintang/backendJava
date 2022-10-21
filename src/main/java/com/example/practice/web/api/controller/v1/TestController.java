package com.example.practice.web.api.controller.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @description：测试部署成功
 * @author：tavion
 * @date：2021/2/25 16:41
 */
@RestController("testController.v1")
@RequestMapping("/v1/{organizationId}/test")
public class TestController {
//    RequestMappingHandlerMapping web-mvc包必不可少

    private String attachmentUrl = "http://192.168.191.1:9000/twplocal-invvatinvoiceattach/0/657cbfb2c2ce4e2f84f1de2c9169fd70%4011.jpg?response-cache-control=must-revalidate%2C%20post-check%3D0%2C%20pre-check%3D0&response-expires=1627525371703&response-content-disposition=attachment%3Bfilename%2A%3DUTF-8%27%2711.jpg&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20210729%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20210729T022250Z&X-Amz-Expires=300&X-Amz-SignedHeaders=host&X-Amz-Signature=5d6a7608eb1c6e1446e299dde8245c112c7e2a32a44bc0dbd70657ee2b65b1a2";

    @GetMapping("/success")
    public String success(){
        return "hello world";
    }

    @GetMapping("/downloadByRedirect")
    public void downloadByRedirect(HttpServletRequest request, HttpServletResponse response, String a, Long b, @PathVariable Long organizationId) {
        try {
            response.sendRedirect(attachmentUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/downloadByUrl")
    public void downloadByUrl(HttpServletRequest request, HttpServletResponse response, String a, Long b, @PathVariable Long organizationId) {
//        response.sendRedirect(attachmentUrl);
        InputStream inputStream = null;
        HttpURLConnection urlConnection = null;
        try (ServletOutputStream outputStream = response.getOutputStream()) {
            // 1.下载地址
            URL url = new URL(attachmentUrl);
            // 2.连接到这个资源 HTTP
            urlConnection = (HttpURLConnection) url.openConnection();
            inputStream = urlConnection.getInputStream();

            String fileName = new String("附件.jpg".getBytes("gb2312"), "iso-8859-1");
            response.reset();
            response.setContentType("application/octet-stream;charset=utf-8");
            response.setHeader("name", fileName);
            response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
            response.setHeader("Pragma", "public");
            response.setDateHeader("Expires", 0);
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.setCharacterEncoding("UTF-8");
            byte[] buf = new byte[1024];
            int readLength;
            while (((readLength = inputStream.read(buf)) != -1)) {
                outputStream.write(buf, 0, readLength);
            }
            outputStream.flush();
        } catch (Exception e) {
            System.out.println("异常:"+e);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            } catch (Exception e) {
                System.out.println("异常:"+e);
            }
        }

    }
}
