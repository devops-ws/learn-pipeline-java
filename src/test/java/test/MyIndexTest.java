package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import util.HttpClientUtil;
import util.PropertiesUtil;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertTrue;

public class MyIndexTest {
    private final Logger logger = Logger.getLogger("javasoft");
    /**
     * 测试代码
     */
    public static void main (String[] args){
        String url =PropertiesUtil.getProperty("redpoint.url");
        String responseStr = HttpClientUtil.doPost(url);
        JSONObject obj = JSON.parseObject(responseStr);
        String status = obj.getString("status");
        System.out.println(responseStr);
        System.out.println(status);
    }

    /**
     * 我的页面，newIndexProver（主接口）测试-未登录
     */
    @Test
    public void newIndexImprove(){
        String url = PropertiesUtil.getProperty("newIndexImprove.url");
        String responseStr = HttpClientUtil.doPost(url);
        JSONObject obj = JSON.parseObject(responseStr);
        String status = obj.getString("status");
        logger.setLevel(Level.INFO);
        logger.info("newIndexImprove：" + responseStr);
        logger.info("newIndexImprove.status：" + status);
        assertTrue("22032".equals(obj.getString("status")));
    }

    /**
     * 我的页面,recommend（运营位接口）测试-未登录
     */
    @Test
    public void recommend(){
        String url = PropertiesUtil.getProperty("recommend.url");
        String responseStr = HttpClientUtil.doPost(url);
        JSONObject obj = JSON.parseObject(responseStr);
        String status = obj.getString("status");
        logger.setLevel(Level.INFO);
        logger.info("recommend：" + responseStr);
        logger.info("recommend.status：" + status);
        assertTrue("0".equals(obj.getString("status")));
    }

    /**
     * 我的页面,showIcons（Icons接口）测试-未登录
     */
    @Test
    public void showIcons(){
        String url = PropertiesUtil.getProperty("showIcons.url");
        String responseStr = HttpClientUtil.doPost(url);
        JSONObject obj = JSON.parseObject(responseStr);
        String status = obj.getString("status");
        logger.setLevel(Level.INFO);
        logger.info("showIcons：" + responseStr);
        logger.info("showIcons.stauts：" + status);
        assertTrue("0".equals(obj.getString("status")));
    }



    /**
     * 我的页面,redpoint（红点接口）测试-未登录
     */
    @Test
    public void redpoint(){
        String url = PropertiesUtil.getProperty("redpoint.url");
        String responseStr = HttpClientUtil.doPost(url);
        JSONObject obj = JSON.parseObject(responseStr);
        String status = obj.getString("status");
        logger.setLevel(Level.INFO);
        logger.info("redpoint：" + responseStr);
        logger.info("redpoint.status："+ status);
        assertTrue("0".equals(obj.getString("status")));
    }
}
