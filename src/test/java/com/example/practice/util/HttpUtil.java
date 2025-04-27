package com.example.practice.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;

@Slf4j
public class HttpUtil {

    /**
     * 默认连接超时时间 10秒
     */
    private static final int DEFAULT_CONNECTION_TIME_OUT = 10_000;

    /**
     * 默认读取响应结果超时时间 10秒
     */
    private static final int DEFAULT_READ_TIME_OUT = 10_000;

    /**
     * http OAuth 2.0 固定字段
     */
    private static final String USER_NAME_FIELD = "username";
    private static final String PASSWORD_FIELD = "password";
    private static final String CLIENT_ID_FIELD = "client_id";
    private static final String CLIENT_SECRET_FIELD = "client_secret";
    private static final String GRANT_TYPE_FIELD = "grant_type";
    private static final String GRANT_TYPE_VALUE = PASSWORD_FIELD;
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String AUTHORIZATION_BASIC = "Basic";

    /**
     * oauth 2.0
     * authorization type : basic
     *
     * @param url      地址
     * @param userName 账号
     * @param password 密码
     * @param token    token 可选
     * @return 响应结果 json 形式
     * @throws HttpResponseException 非20X时，扔出http响应异常
     */
    public static JSONObject doOauth2(String url, String userName, String password, String token)
            throws HttpResponseException {

        Objects.requireNonNull(userName, "登录账号");
        Objects.requireNonNull(password, "登录密码");
        Map<String, String> bodyParam = new HashMap<>();
        bodyParam.put(USER_NAME_FIELD, userName);
        bodyParam.put(PASSWORD_FIELD, password);
        bodyParam.put(GRANT_TYPE_FIELD, GRANT_TYPE_VALUE);

        if (StringUtils.isBlank(token)) {
            return sentPostWithForm(url, bodyParam, null);
        }
        Map<String, String> headerParam = new HashMap<>();
        headerParam.put(AUTHORIZATION_HEADER, AUTHORIZATION_BASIC + " " + token);
        return sentPostWithForm(url, bodyParam, headerParam);
    }


    /**
     * oauth 2.0
     * authorization type : 密码模式
     *
     * @param url          地址
     * @param username     账号
     * @param password     密码
     * @param clientId     客户端
     * @param clientSecret 客户端凭证
     * @return 响应结果 json 形式
     * @throws HttpResponseException 非20X时，扔出http响应异常
     */
    public static JSONObject doOauth2(String url, String username, String password,
                                      String clientId, String clientSecret) throws HttpResponseException {

        Objects.requireNonNull(username, "登录账号");
        Objects.requireNonNull(password, "登录密码");
        Objects.requireNonNull(clientId, "客户端账号");
        Objects.requireNonNull(clientSecret, "客户端密码");

        Map<String, String> bodyParam = new HashMap<>(5);
        bodyParam.put(USER_NAME_FIELD, username);
        bodyParam.put(PASSWORD_FIELD, password);
        bodyParam.put(CLIENT_ID_FIELD, clientId);
        bodyParam.put(CLIENT_SECRET_FIELD, clientSecret);
        bodyParam.put(GRANT_TYPE_FIELD, GRANT_TYPE_VALUE);

        return sentPostWithForm(url, bodyParam, null);
    }


    /**
     * post
     * content-type： application/json
     * token 形式： [auth_type token_content]
     * eg: Basic xxxxxxxxxxx
     * Bearer xxxxxxxxxx
     *
     * @param url   请求地址
     * @param body  请求报文
     * @param token 权限校验口令
     * @return 响应报文
     * @throws HttpResponseException 非20x,异常
     */
    public static JSONObject sentPostWithJsonByAuthorization(String url, Map<String, ?> body, String token)
            throws HttpResponseException {
        Objects.requireNonNull(token, "Authorization token");
        HashMap<String, String> authHeader = new HashMap<>();
        authHeader.put(AUTHORIZATION_HEADER, token);
        return sentPostWithJson(url, body, authHeader);
    }

    /**
     * POST
     * content-type: application/json;charset=utf-8
     *
     * @param url         访问地址
     * @param bodyParam   请求报文，body
     * @param headerParam 请求头 header
     * @return 响应报文，body
     * @throws HttpResponseException 非20X，异常
     */
    public static JSONObject sentPostWithJson(String url,
                                              Map<String, ?> bodyParam,
                                              Map<String, String> headerParam) throws HttpResponseException {
        return sentPost(url, bodyParam, APPLICATION_JSON_UTF8, headerParam);
    }


    /**
     * POST
     * content-type: application/x-www-form-urlencoded
     *
     * @param url         请求地址
     * @param bodyParam   请求报文 body
     * @param headerParam 请求头 header
     * @return 响应报文 response body
     * @throws HttpResponseException 非20x响应，异常
     */
    public static JSONObject sentPostWithForm(String url,
                                              Map<String, ?> bodyParam,
                                              Map<String, String> headerParam) throws HttpResponseException {
        return sentPost(url, bodyParam, APPLICATION_FORM_URLENCODED, headerParam);
    }

    /**
     * @param url         请求地址
     * @param bodyParam   请求参数，form形式
     * @param headerParam 头部参数
     * @return 20X时，响应body 其他的以异常形式扔出
     */
    public static JSONObject sentPost(String url,
                                      Map<String, ?> bodyParam,
                                      MediaType contentType,
                                      Map<String, String> headerParam) throws HttpResponseException {

        String result = "";
        BufferedReader in = null;
        Integer status = null;
        try {
            URL realUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setConnectTimeout(DEFAULT_CONNECTION_TIME_OUT);
            connection.setReadTimeout(DEFAULT_READ_TIME_OUT);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            //添加头部参数
            if (Objects.nonNull(headerParam) && !headerParam.isEmpty()) {
                headerParam.forEach(connection::setRequestProperty);
            }
            connection.setDoOutput(true);
            connection.setDoInput(true);
            // 处理报文并发送请求
            processPostContentType(contentType, bodyParam, connection);
            status = connection.getResponseCode();
            String line;
            try {
                for (in = new BufferedReader(new InputStreamReader(connection.getInputStream(), UTF_8));
                     StringUtils.isNotEmpty((line = in.readLine()));
                     result = result + line) {
                }
            } catch (IOException e) {
                //判断，如果发生400的异常，则调用再次获取错误流里面的数据，再次包装响应对象
                for (in = new BufferedReader(new InputStreamReader(connection.getErrorStream(), UTF_8));
                     StringUtils.isNotEmpty((line = in.readLine()));
                     result = result + line) {
                }
            }
        } catch (Exception e) {
            throw new HttpResponseException(
                    Optional.ofNullable(status).orElse(HttpStatus.INTERNAL_SERVER_ERROR.value()),
                    result,
                    "请求失败");
        } finally {
            try {
                if (Objects.nonNull(in)) {
                    in.close();
                }
            } catch (IOException e) {
                log.error("http 请求失败，流关闭异常", e);
            }
        }
        if (Objects.isNull(status)) {
            status = HttpStatus.REQUEST_TIMEOUT.value();
        }

        if (status >= 200 && status < 300) {
            return (JSONObject) JSONObject.parse(result);
        }
        throw new HttpResponseException(status, result, "POST请求失败");
    }

    /**
     * POST
     * 默认content-type: application/json;charset=utf-8
     *
     * @param url         访问地址
     * @param bodyJson    请求报文，json串
     * @param headerParam 请求头 header
     * @return 响应报文，body
     * @throws HttpResponseException 非20X，异常
     */
    public static JSONObject sentBodyPostWithJson(String url,
                                                  String bodyJson,
                                                  Map<String, String> headerParam) throws HttpResponseException {

        String result = "";
        BufferedReader in = null;
        Integer status = null;
        try {
            URL realUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setConnectTimeout(DEFAULT_CONNECTION_TIME_OUT);
            connection.setReadTimeout(DEFAULT_READ_TIME_OUT);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            //添加头部参数
            if (Objects.nonNull(headerParam) && !headerParam.isEmpty()) {
                headerParam.forEach(connection::setRequestProperty);
            }
            connection.setDoOutput(true);
            connection.setDoInput(true);
            // 处理报文并发送请求
            PrintWriter out = null;
            connection.setRequestProperty("Content-type", APPLICATION_JSON_UTF8.toString());
            try {
                out = new PrintWriter(new OutputStreamWriter(connection.getOutputStream(), UTF_8));
                out.print(bodyJson);
                out.flush();
            } finally {
                if (Objects.nonNull(out)) {
                    out.close();
                }
            }
            status = connection.getResponseCode();
            String line;
            try {
                for (in = new BufferedReader(new InputStreamReader(connection.getInputStream(), UTF_8));
                     StringUtils.isNotEmpty((line = in.readLine()));
                     result = result + line) {
                }
            } catch (IOException e) {
                //判断，如果发生400的异常，则调用再次获取错误流里面的数据，再次包装响应对象
                for (in = new BufferedReader(new InputStreamReader(connection.getErrorStream(), UTF_8));
                     StringUtils.isNotEmpty((line = in.readLine()));
                     result = result + line) {
                }
            }
        } catch (Exception e) {
            throw new HttpResponseException(
                    Optional.ofNullable(status).orElse(HttpStatus.INTERNAL_SERVER_ERROR.value()),
                    result,
                    "请求失败");
        } finally {
            try {
                if (Objects.nonNull(in)) {
                    in.close();
                }
            } catch (IOException e) {
                log.error("http 请求失败，流关闭异常", e);
            }
        }
        if (Objects.isNull(status)) {
            status = HttpStatus.REQUEST_TIMEOUT.value();
        }

        if (status >= 200 && status < 300) {
            return (JSONObject) JSONObject.parse(result);
        }
        throw new HttpResponseException(status, result, "POST请求失败");
    }

    /**
     * 处理报文
     *
     * @param contentType 报文类型
     * @param bodyParam   报文map
     * @param connection  连接
     * @throws IOException 请求异常
     */
    private static void processPostContentType(MediaType contentType,
                                               Map<String, ?> bodyParam,
                                               HttpURLConnection connection) throws IOException {
        Supplier<String> buildParam = null;
        contentType = Objects.isNull(contentType) ? APPLICATION_FORM_URLENCODED : contentType;
        if (APPLICATION_FORM_URLENCODED.getSubtype().equalsIgnoreCase(contentType.getSubtype())) {
            buildParam = () -> buildForm(bodyParam);
        } else if (APPLICATION_JSON_UTF8.getSubtype().equalsIgnoreCase(contentType.getSubtype())) {
            buildParam = () -> buildJSON(bodyParam);
        } else {
            // 默认 form形式
            contentType = APPLICATION_FORM_URLENCODED;
            buildParam = () -> buildForm(bodyParam);
        }
        PrintWriter out = null;
        connection.setRequestProperty("Content-type", contentType.toString());
        try {
            out = new PrintWriter(new OutputStreamWriter(connection.getOutputStream(), UTF_8));
            out.print(buildParam.get());
            out.flush();
        } finally {
            if (Objects.nonNull(out)) {
                out.close();
            }
        }
    }



    /**
     * 构建 application/x-www-form-urlencoded 格式的请求报文
     * <p>
     * formData 只支持 [String, String]的格式，
     *
     * @param param form 参数
     * @return 编码后的form参数
     */
    private static String buildForm(Map<String, ?> param) {
        if (Objects.isNull(param) || param.isEmpty()) {
            return "";
        }
        return param.entrySet().stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue().toString())
                .collect(Collectors.joining("&"));
    }

    /**
     * 构建json String
     *
     * @param param 参数
     * @return json String
     */
    private static String buildJSON(Map<String, ?> param) {
        if (Objects.isNull(param) || param.isEmpty()) {
            return "";
        }
        return JSON.toJSONString(param);
    }

    /**
     * 发送get请求的工具方法
     *
     * @param url         请求地址
     * @param param       body 参数
     * @param headerParam header 参数
     * @return 响应body
     */
    public static JSONObject sendGet(String url, Map<String, Object> param, Map<String, String> headerParam)
            throws HttpResponseException {

        BufferedReader in = null;
        String result = "";
        Integer status = null;
        try {
            URL realUrl = new URL(getUrl(url, param));
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setConnectTimeout(DEFAULT_CONNECTION_TIME_OUT);
            connection.setReadTimeout(DEFAULT_READ_TIME_OUT);
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

            //添加头部参数
            if (Objects.nonNull(headerParam) && !headerParam.isEmpty()) {
                for (String key : headerParam.keySet()) {
                    connection.setRequestProperty(key, headerParam.get(key));
                }
            }
            connection.connect();
            status = connection.getResponseCode();
            Map<String, List<String>> map = connection.getHeaderFields();
            map.forEach((key, values) -> {
                log.info(key + ":" + values.toString());
            });

            String line;
            try {
                for (in = new BufferedReader(new InputStreamReader(connection.getInputStream(), UTF_8));
                     (line = in.readLine()) != null;
                     result = result + line) {
                }
            } catch (IOException e) {
                for (in = new BufferedReader(new InputStreamReader(connection.getErrorStream(), UTF_8));
                     (line = in.readLine()) != null;
                     result = result + line) {
                    ;
                }
            }
        } catch (Exception var18) {
            throw new HttpResponseException(
                    Optional.ofNullable(status).orElse(HttpStatus.INTERNAL_SERVER_ERROR.value()),
                    result,
                    "请求失败");
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
                log.error("http 请求失败，流关闭异常", e);
            }
        }
        if (Objects.nonNull(status) && status >= 200 && status < 300) {
            return (JSONObject) JSONObject.parse(result);
        }
        //
        throw new HttpResponseException(Optional.ofNullable(status).orElse(HttpStatus.REQUEST_TIMEOUT.value()),
                result,
                "请求失败");

    }


    /**
     * 拼接 get 请求的 url
     *
     * @param url   基础url
     * @param param 参数
     * @return 拼接完成的url
     */
    private static String getUrl(String url, Map<String, Object> param) {
        StringBuilder sb = new StringBuilder();
        String equals = "=";
        //拼接get请求的url参数
        sb.append(url);
        if (Objects.nonNull(param) && !param.isEmpty()) {
            sb.append("?");
            Object tempValue = null;
            int count = 0;
            for (String key : param.keySet()) {
                //字符串类型参数
                tempValue = param.get(key);
                if (tempValue instanceof String && StringUtils.isNotBlank(tempValue.toString())) {
                    sb.append(count == 0 ? "" : "&").append(key).append(equals)
                            .append(encodeUrl(tempValue.toString()));
                    count++;
                }
                //数组类型参数
                if (tempValue instanceof List) {
                    List conditions = (List) tempValue;
                    for (Object value : conditions) {
                        if (value instanceof String && StringUtils.isNotBlank(value.toString())) {
                            sb.append(count == 0 ? "" : "&").append(key).append(equals)
                                    .append(encodeUrl(value.toString()));
                            count++;
                        }
                    }
                }
            }
        }
        return sb.toString();
    }

    /**
     * 编码url
     *
     * @param url raw url
     * @return encoder url
     */
    private static String encodeUrl(String url) {
        if (StringUtils.isBlank(url)) {
            return "";
        }
        try {
            return URLEncoder.encode(url, UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            return url;
        }
    }


    /**
     * 下载
     *
     * @param url 下载地址
     * @return 下载输入流
     */
    public static InputStream download(String url) {
        Objects.requireNonNull(url, "url must be not null");
        URL downUrl = null;
        try {
            downUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) downUrl.openConnection();
            //设置超时间为3秒
            conn.setConnectTimeout(DEFAULT_CONNECTION_TIME_OUT);
            conn.setReadTimeout(DEFAULT_READ_TIME_OUT);
            return conn.getInputStream();
        } catch (MalformedURLException e) {
            log.info("url:{}", url);
            e.printStackTrace();
//            throw new CommonException("error.url.value", url);
            throw new RuntimeException("error.url.value"+ url);
        } catch (IOException e) {
            e.printStackTrace();
//            throw new CommonException("error.download.file", url);
            throw new RuntimeException("error.download.file"+ url);
        }
    }

    /**
     * 下载
     *
     * @param url 下载地址
     * @return 二进制数据
     */
    public static byte[] downloadData(String url) {
        Objects.requireNonNull(url, "url must be not null");
        try (InputStream inputStream = HttpUtil.download(url)) {
            return readInputStream(inputStream);
        } catch (IOException e) {
            log.error("文件下载异常", e);
        }
        return null;
    }


    /**
     * 读取输入流，转成字节数字
     *
     * @param inputStream 输入流
     * @return 二进制数据
     * @throws IOException
     */
    public static byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len;
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream(); InputStream in = inputStream) {
            while ((len = in.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
            return bos.toByteArray();
        }
    }
}