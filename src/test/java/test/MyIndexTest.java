package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import util.HttpClientUtil;
import util.PropertiesUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertTrue;

public class MyIndexTest {
    private final Logger logger = Logger.getLogger("javasoft");
    /**
     * 测试代码
     */
    public static void main (String[] args){
        String url =PropertiesUtil.getProperty("showIconsrn.url");
        Map<String,String> param = new HashMap<String,String>();
        param.put("scheme","qunaraphone");
        param.put("isRN","true");
        param.put("qpVersion","32");
        Map<String,String> hearder = new HashMap<String,String>();
        //hearder.put("Cookie","QN1=000015000600105c80c0fe20; QN48=tc_3149f483c5f4e96c_168ac300f4d_4784; QN300=organic; QN235=2019-02-18; _i=ue-xY4nyAVjXXXhy46BjDAKxT4yX; _vi=hNwn1H4wgZCT2xfQFk7XaJPgFNj2hU8sofoCjpYMQVE6H8ny_fF3O6O365rmcrPLmMaDfFuQrTmnAEm8soAdM2TKrvRdsWWYqJoZZlqhGfhzzrdNAQZG2cwivz7ahoOvogPxVNdyN7jEDAPtcvBxZ2q75OEtsH64Smt462DO9vZZ; fid=20132569-ea87-46b8-a3f1-eca497d4010b; QN241=; QN270=1111%2C60001246%2CC5065%2CAA3A1BAC-8FE5-D291-7A30-EA36647C4D48%2C10010; csrfToken=ULW1fDPwz3pSJDK; _v=GfCYmRk0kYhpRxMB3ZoDVKxVj_dnUDyJmlWzLRhPk2soqmnRl1eQMpxqqHadx8avmeJscPx0QasxuMX2uESWc9kYHIlyf0npzRXIwIAQEaFlyRwhCvtzYPjXwNAfdCrycI-z1z0GxLiPR3k5cpv8b_6UYKR9J_DmIIpEyfIbmKLH; _t=26080242; _q=U.gscsldt7224; _s=s_HJHX5SDL6UJ6WUIEPDYAOSCV4Q");
        hearder.put("Cookie",PropertiesUtil.getProperty("cookie"));
        //mobile/h5/personalcenter/showIconsrn.htm?scheme=qunaraphone&isRN=true&qpVersion=32
        String responseStr = HttpClientUtil.doGet(url,param,hearder);
                //HttpClientUtil.doPost(url);
        JSONObject obj = JSON.parseObject(responseStr);
        String status = obj.getString("status");
        System.out.println("responseStr:" + responseStr);
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


    /**
     * 我的页面,showIconsrn（Iconsrn接口）测试-已登录
     */
    @Test
    public void showIconsrn(){
        String url = PropertiesUtil.getProperty("showIconsrn.url");
        Map<String,String> param = new HashMap<String,String>();
        param.put("scheme","qunaraphone");
        param.put("isRN","true");
        param.put("qpVersion","32");
        Map<String,String> hearder = new HashMap<String,String>();
        hearder.put("Cookie",PropertiesUtil.getProperty("cookie"));
        String responseStr = HttpClientUtil.doGet(url,param,hearder);
        JSONObject obj = JSON.parseObject(responseStr);
        String status = obj.getString("status");
        logger.setLevel(Level.INFO);
        logger.info("showIconsrn：" + responseStr);
        logger.info("showIconsrn.stauts：" + status);
        assertTrue("0".equals(obj.getString("status")));
    }

}
