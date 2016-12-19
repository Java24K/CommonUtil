package com.baidu.util;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Description: 根据摆对地图获取经纬度、获取两地距离(米)等的工具类
 * All Rights Reserved.
 * @version 1.0  2016年12月15日 上午7:13:41  by feng.zhou@ucarinc.com 创建
 */
public class BaiDuMapUtil { 
	
		private static final String BAI_DU_MAP_API_AK = "7DEl2Sgy1QOloEghzLLRqBrk";
		
	   	private static final String BAI_DU_MAP_API_SK = "0MqYHMgtNRoZM84lRbFobmG2bidOhH0g";
	   	
		private static final double EARTH_RADIUS = 6378.137;  
	

		private static Logger logger = LoggerFactory.getLogger(BaiDuMapUtil.class);

		/**
		 * Description: 根据地址获得经纬度
		 * @Version1.0 2016年12月15日 上午7:16:53 by feng.zhou@ucarinc.com 创建
		 * @param address
		 * @return
		 * @throws IOException
		 */
		public static Map<String, Double> getLngAndLat(String address) throws IOException 
		{ 
			String sn = getSnCal(address, "json");
			Map<String, Double> resutlMap = new HashMap<String, Double>();
			if(null == sn){
				// 得到的sn为空标识，计算sn抛出异常
				resutlMap = null;
			}else{
				String addressEncode = URLEncoder.encode(address, "UTF-8");
				String url = "http://api.map.baidu.com/geocoder/v2/?address="
					+ addressEncode + "&output=json" 
					+"&ak=" + BAI_DU_MAP_API_AK + "&sn=" + sn;
			    String responseStr = doRequestUrl(url);
			    // 得到 经纬度
			    JSONObject jsonObject;
				try {
					jsonObject = new JSONObject(responseStr);
					JSONObject lngAndLatJson = jsonObject.getJSONObject("result").getJSONObject("location");
					resutlMap.put("lat", (Double)lngAndLatJson.get("lat"));
					resutlMap.put("lng", (Double)lngAndLatJson.get("lng"));
				} catch (JSONException e) {
					// 错误日志
					logger.error("BaiDuMapUtil类的getLngAndLat方法抛出JSONException",e);
					resutlMap = null;
				}  
			}
			
		    return resutlMap;
		} 

	     /**
	     * Description: 根据url得到响应Json
	     * @Version1.0 2016年12月15日 上午7:17:15 by feng.zhou@ucarinc.com 创建
	     * @param reqUrl
	     * @throws ClientProtocolException
	     * @throws IOException
	     */
	    public static String doRequestUrl(String reqUrl) throws ClientProtocolException, IOException 
	       {
	           String resultStr = "{}";
	           DefaultHttpClient httpclient = new DefaultHttpClient();
	           try {
	               HttpGet httpGet = new HttpGet(reqUrl);
	               HttpResponse response = httpclient.execute(httpGet);
	               HttpEntity entity = response.getEntity();
	               resultStr = EntityUtils.toString(entity);
	           } finally {
	               httpclient.getConnectionManager().shutdown();
	           }
	           return resultStr;
	       }
	       
	     /**
	     * Description: 通过经纬度获取距离(单位：米)  
	     * @Version1.0 2016年12月15日 上午7:18:03 by feng.zhou@ucarinc.com 创建
	     * @param latA 纬度A
	     * @param lngA 经度A
	     * @param latB 纬度B
	     * @param lngB 经度B
	     * @return
	     */
	    public static double getDistance(double latA, double lngA, double latB,  
	                                        double lngB) {  
           double radLatA = rad(latA);  
           double radLatB = rad(latB);  
           double radLatGap = radLatA - radLatB;  
           double radLngGap = rad(lngA) - rad(lngB);  
           double distance = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(radLatGap / 2), 2)  
                   + Math.cos(radLatA) * Math.cos(radLatB)  
                   * Math.pow(Math.sin(radLngGap / 2), 2)));  
           distance = distance * EARTH_RADIUS;  
           distance = Math.round(distance * 10000d) / 10000d;  
           distance = distance*1000; 
           return distance;  
       }  
     
	    private static double rad(double d) {  
	        return d * Math.PI / 180.0;  
	    } 

	   	/**
	   	 * Description: 得到服务端请求所需sn
	   	 * @Version1.0 2016年12月15日 上午7:20:57 by feng.zhou@ucarinc.com 创建
	   	 * @param address
	   	 * @param output
	   	 * @return
	   	 */
	   	public static String getSnCal(String address, String output) {
	
	   		Map<String,String> paramsMap = new LinkedHashMap<String, String>();
	   		paramsMap.put("address", address);
	   		paramsMap.put("output", "json");
	   		paramsMap.put("ak", BAI_DU_MAP_API_AK);
	
	   		String paramsStr = null;
	   		String tempStr = null;
	   		String resultStr = null;
	   		try {
	   			paramsStr = toQueryString(paramsMap);
	   			// 对paramsStr前面拼接上/geocoder/v2/?，后面直接拼接SK
	   			String wholeStr = new String("/geocoder/v2/?" + paramsStr + BAI_DU_MAP_API_SK);
	   			// 对上面wholeStr再作utf8编码
	   			tempStr = URLEncoder.encode(wholeStr, "UTF-8");
	   			// 调用下面的MD5方法得到最后的sn签名
	   			resultStr =  MD5(tempStr);
	   		} catch (UnsupportedEncodingException e) {
	   			logger.error("BaiDuMapUtil类的getSnCal方法抛出UnsupportedEncodingException",e);
	   			resultStr = null;
	   		}
	   		return resultStr;
	   	}
	
	   	/**
	   	 * Description: 对Map内所有value作utf8编码，拼接返回结果
	   	 * @Version1.0 2016年12月15日 上午7:21:46 by feng.zhou@ucarinc.com 创建
	   	 * @param data
	   	 * @return
	   	 * @throws UnsupportedEncodingException
	   	 */
	   	public static String toQueryString(Map<?, ?> data)
	   			throws UnsupportedEncodingException 
	   	{
	   		StringBuffer queryString = new StringBuffer();
	   		for (Entry<?, ?> pair : data.entrySet()) 
	   		{
	   			queryString.append(pair.getKey() + "=");
	   			queryString.append(URLEncoder.encode((String) pair.getValue(),
	   					"UTF-8") + "&");
	   		}
	   		if (queryString.length() > 0)
	   		{
	   			queryString.deleteCharAt(queryString.length() - 1);
	   		}
	   		return queryString.toString();
	   	}
	
	   	/**
	   	 * Description: 来自stackoverflow的MD5计算方法，调用了MessageDigest库函数，并把byte数组结果转换成16进制
	   	 * @Version1.0 2016年12月15日 上午7:22:05 by feng.zhou@ucarinc.com 创建
	   	 * @param md5
	   	 * @return
	   	 */
	   	public static String MD5(String md5) 
	   	{
	   		String md5Str = null;
	   		try 
	   		{
	   			MessageDigest md = MessageDigest.getInstance("MD5");
	   			byte[] array = md.digest(md5.getBytes());
	   			StringBuffer sb = new StringBuffer();
	   			for (int i = 0; i < array.length; ++i) 
	   			{
	   				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
	   			}
	   			md5Str = sb.toString();
	   		} catch (NoSuchAlgorithmException e) 
	   		{
	   			logger.error("BaiDuMapUtil类的MD5方法获取MessageDigest实例异常",e);
	   			md5Str = null;
	   		} catch (Exception e)
	   		{
	   			logger.error("BaiDuMapUtil类的MD5方法抛出异常",e);
	   			md5Str = null;
	   		}
	   		return md5Str;
	   	}
	   	
}