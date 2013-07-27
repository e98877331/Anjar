package wcm.ytwhyc.anjar.connection;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

abstract public class BaseRequest {

	
	
     HttpClient httpclient;
     HttpPost httppost;
     ArrayList<BasicNameValuePair> nameValuePairs;
     
     abstract public String getApiUrl();
     
	 public BaseRequest()
	 {
		HttpParams httpParameters = new BasicHttpParams();
		int timeoutConnection = 5000;
		HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
		int timeoutSocket = 8000;
		HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

		httpclient = new DefaultHttpClient(httpParameters);
		httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
		httppost = new HttpPost(getApiUrl());

		nameValuePairs = new ArrayList<BasicNameValuePair>();


		
	 }
	 
	 
	 
	 public void addParamPair(String key, String value)
	 {
		 nameValuePairs.add(new BasicNameValuePair(key, value));
	 }
     
	 protected HttpResponse executeForHttpResponse() throws Exception
	 {
		 httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8"));
		 return httpclient.execute(httppost);
	 }
}
