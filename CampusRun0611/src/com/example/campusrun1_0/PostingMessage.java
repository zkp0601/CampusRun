package com.example.campusrun1_0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import android.util.Log;
import postingMessage.JSONArray;
import postingMessage.JSONException;
import postingMessage.JSONObject;

public class PostingMessage {
	static String entityResult;
	static HttpResponse response = null;
	public static int stateCode = 0;
	
	// 利用HttpPost发送数据后传回JSON数据
	private static String httpPost(Map<String, Object> map, String url) throws Exception{
		final HttpClient httpClient = new DefaultHttpClient(); 
		final HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>();
		for(Map.Entry<String, Object> entry : map.entrySet()){
			nameValuePair.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
		}
		HttpEntity entity = new UrlEncodedFormEntity(nameValuePair, HTTP.UTF_8);//设置字符集
		httpPost.setHeader(entity.getContentType()); 
		httpPost.setEntity(entity);	// 设置参数实体
		httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 5000); //连接超时
		httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 5000); // 请求超时
		response = null;
		response = httpClient.execute(httpPost);
		
		stateCode = response.getStatusLine().getStatusCode(); //获取访问页面的状态码 
		if (stateCode == 200) {
			entityResult = null;
			entityResult = EntityUtils.toString(response.getEntity());
			Log.e("entityResult", entityResult);
			return entityResult;
		}else
			return null;
	}
		
	// 解析错误或提示性的JSON数据
	private static Map<String, Object> toMap(String jsonString) throws Exception{
		JSONObject jsonObject = new JSONObject("{mess:"+jsonString+"}");
		Map item = new HashMap();
		Iterator iter = jsonObject.keys();
		String key = null, value = null;
				
		while(iter.hasNext()){
			key = (String) iter.next();
			value = jsonObject.getString(key).toString();
			item.put(key, value);
		}
		return item;
	}
		
	// 解析正确返回的json数据
	private static ArrayList<HashMap<String, Object>> JSONAnalysis(String jsonString)throws JSONException{
		JSONArray jsonArray = new JSONArray(jsonString);
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		list.clear();
		for(int i = 0; i < jsonArray.length(); i++){
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			HashMap<String, Object> map = new HashMap<String, Object>();
			Iterator iter = jsonObject.keys();
			String key = null, value = null;
					
			while(iter.hasNext()){
				key = (String) iter.next();
				value = jsonObject.getString(key);
				map.put(key, value);
			}
			list.add(map);
		}
		return list;
	}
	
	public ArrayList<HashMap<String, Object>> sendingMessage(Map<String, Object> map, String url) throws Exception{
		String jsonString = httpPost(map, url);
		// 成功取到正确的 Msssage JSON 数据时
		if(!jsonString.isEmpty() && (jsonString.startsWith("[{") || jsonString.startsWith("{"))) {
			if(jsonString.startsWith("{"))
				jsonString = "[" + jsonString + "]";
			ArrayList<HashMap<String, Object>> message = JSONAnalysis(jsonString);
			return message;
		}
		else if(!jsonString.isEmpty()){ // 说明是某些提示消息
			Map<String, Object> message = new HashMap<String, Object>();
			message.clear();
			message = toMap(jsonString);
			HashMap<String, Object> temp = new HashMap<String, Object>();

			for(Map.Entry<String, Object> entry : message.entrySet())
				temp.put(entry.getKey(), entry.getValue());
				
			ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
			result.add(temp);
			return result;
		}
		else
			return null;
	}
}
