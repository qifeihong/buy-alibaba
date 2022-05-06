package com.sale.buyalibaba.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * HTTPS请求工具类
 *
 * @author ma.jh
 * @date 2021-12-17 09:33:30
 */
@Slf4j
public class HttpsPostUtil {

    private static final int SUCCESS_CODE = 200;

    public static String doPost(String urlStr, String body, Map<String, String> headers) {
        return HttpsPostUtil.doPost(urlStr, body, headers, "application/json", "UTF-8");
    }

    public static String doPost(String urlStr, String body, Map<String, String> headers, String contentType, String charsetName) {
        OutputStreamWriter out = null;
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        HttpURLConnection conn;
        try {
            URL url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            if (headers != null && headers.size() > 0) {
                headers.forEach(conn::addRequestProperty);
            }
            //发送POST请求必须设置为true
            conn.setDoOutput(true);
            conn.setDoInput(true);
            //设置连接超时时间和读取超时时间
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(10000);
            if (StringUtils.isEmpty(contentType)) {
                contentType = "application/json";
            }
            conn.setRequestProperty("Content-Type", contentType);
            //获取输出流
            out = new OutputStreamWriter(conn.getOutputStream());
            out.write(body);
            out.flush();
            out.close();
            //取得输入流，并使用Reader读取
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charsetName));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
            if (SUCCESS_CODE != conn.getResponseCode()) {
                log.warn("ResponseCode is an error code={}, result={}", conn.getResponseCode(), result);
            }
        } catch (Exception e) {
            log.warn("ResponseCode is an error urlStr={}, body={}, headers={}, result={}", urlStr, body, headers, result, e);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return result.toString();
    }

//    public static String doGet(String urlStr, String body, Map<String, String> headers, String contentType, String charsetName) {
//        HttpURLConnection conn = null;
//        InputStream is = null;
//        BufferedReader br = null;
//        StringBuilder result = new StringBuilder();
//        try {
//            //创建远程url连接对象
//            URL url = new URL(urlStr);
//            //通过远程url连接对象打开一个连接，强转成HTTPURLConnection类
//            conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            if (headers != null && headers.size() > 0) {
//                headers.forEach(conn::addRequestProperty);
//            }
//            //设置连接超时时间和读取超时时间
//            conn.setConnectTimeout(15000);
//            conn.setReadTimeout(60000);
//            conn.setRequestProperty("Accept", "application/json");
//            //发送请求
//            conn.connect();
//            //通过conn取得输入流，并使用Reader读取
//            if (SUCCESS_CODE == conn.getResponseCode()) {
//                is = conn.getInputStream();
//                br = new BufferedReader(new InputStreamReader(is, charsetName));
//                String line;
//                while ((line = br.readLine()) != null) {
//                    result.append(line);
//                }
//            } else {
//                System.out.println("ResponseCode is an error code:" + conn.getResponseCode());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (br != null) {
//                    br.close();
//                }
//                if (is != null) {
//                    is.close();
//                }
//            } catch (IOException ioe) {
//                ioe.printStackTrace();
//            }
//            conn.disconnect();
//        }
//        return result.toString();
//    }


    public static void main(String[] args) {
        String url = "https://enn-finance-center-bff.dev.ennew.com/bank/page";
        //String url = "https://enn-finance-center-bff.dev.ennew.com/bank/page";
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("X-GW-AccessKey", "pm8NQT0GPsYsONR7RytyKEwkMSBCyVxc");
        headerMap.put("accessKey", "bb4ec15a0492");
        headerMap.put("accessSecret", "606ae44568a3df5a369d1160b867dd16");
        headerMap.put("userid", "1");
        headerMap.put("username", "1");
        String body = "{\"companyCode\":\"0011\"}";
        String r = HttpsPostUtil.doPost(url, body, headerMap);
        System.out.println(r);
    }
}
