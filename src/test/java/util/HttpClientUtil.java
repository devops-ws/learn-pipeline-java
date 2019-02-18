package util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {
    /**
     * 带参数的get请求
     * @param url 请求地址
     * @param param 请求参数
     * @return 结果
     */
    public static String doGet(String url, Map<String, String> param,Map<String, String> headers) {

        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();

        String resultString = "";
        CloseableHttpResponse response = null;
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            if (param != null) {
                for (String key : param.keySet()) {
                    builder.addParameter(key, param.get(key));
                }
            }

            URI uri = builder.build();
            String urlStr = uri.toString();
            System.out.println("urlStr:" + urlStr);

            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);
            if(headers!=null){
                for(Map.Entry<String,String> en:headers.entrySet()){
                    httpGet.setHeader(en.getKey(), en.getValue());
                }
            }

            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultString;
    }









    /**
     * 无参数的get请求
     * @param url 请求地址
     * @return 返回结果
     */
    public static String doGet(String url) {
        return doGet(url, null,null);
    }

    /**
     * 待参数的post请求
     * @param url  请求地址
     * @param param 请求参数
     * @return 返回结果
     */
    public static String doPost(String url, Map<String, String> param) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建参数列表
            if (param != null) {
                List<NameValuePair> paramList = new ArrayList<NameValuePair>();
                for (String key : param.keySet()) {
                    paramList.add(new BasicNameValuePair(key, param.get(key)));
                }
                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
                httpPost.setEntity(entity);
            }
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return resultString;
    }


    public static String doPost(String url,Map<String,String> params,Map<String,String> headers) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        UrlEncodedFormEntity entity;
        List<NameValuePair> paramPairs = new ArrayList<NameValuePair>();
        if(params!=null){
            for(Map.Entry<String,String> en:params.entrySet()){
                paramPairs.add(new BasicNameValuePair(en.getKey(), en.getValue()));
            }
        }
        if(headers!=null){
            for(Map.Entry<String,String> en:headers.entrySet()){
                httpPost.setHeader(en.getKey(), en.getValue());
            }
        }
        try {
            entity = new UrlEncodedFormEntity(paramPairs, "UTF-8");
            httpPost.setEntity(entity);
            HttpResponse resp = client.execute(httpPost);
            HttpEntity respEntity = resp.getEntity();
            if (null != respEntity) {
                return EntityUtils.toString(respEntity, "UTF-8");
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }



    /**
     * 无参的post请求
     * @param url 请求url
     * @return 返回结果
     */
    public static String doPost(String url) {
        return doPost(url, null);
    }


}
