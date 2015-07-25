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
	
	// ����HttpPost�������ݺ󴫻�JSON����
	private static String httpPost(Map<String, Object> map, String url) throws Exception{
		final HttpClient httpClient = new DefaultHttpClient(); 
		final HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>();
		for(Map.Entry<String, Object> entry : map.entrySet()){
			nameValuePair.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
		}
		HttpEntity entity = new UrlEncodedFormEntity(nameValuePair, HTTP.UTF_8);//�����ַ���
		httpPost.setHeader(entity.getContentType()); 
		httpPost.setEntity(entity);	// ���ò���ʵ��
		httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 5000); //���ӳ�ʱ
		httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 5000); // ����ʱ
		response = null;
		response = httpClient.execute(httpPost);
		
		stateCode = response.getStatusLine().getStatusCode(); //��ȡ����ҳ���״̬�� 
		if (stateCode == 200) {
			entityResult = null;
			entityResult = EntityUtils.toString(response.getEntity());
			Log.e("entityResult", entityResult);
			return entityResult;
		}else
			return null;
	}
		
	// �����������ʾ�Ե�JSON����
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
		
	// ������ȷ���ص�json����
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
		// �ɹ�ȡ����ȷ�� Msssage JSON ����ʱ
		if(!jsonString.isEmpty() && (jsonString.startsWith("[{") || jsonString.startsWith("{"))) {
			if(jsonString.startsWith("{"))
				jsonString = "[" + jsonString + "]";
			ArrayList<HashMap<String, Object>> message = JSONAnalysis(jsonString);
			return message;
		}
		else if(!jsonString.isEmpty()){ // ˵����ĳЩ��ʾ��Ϣ
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
