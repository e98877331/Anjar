package wcm.ytwhyc.anjar.connection;

import org.apache.http.HttpResponse;
import org.apache.http.impl.client.BasicResponseHandler;
import org.json.JSONObject;

import android.util.Log;

abstract public class JSONRequest extends BaseRequest{
protected JSONObject json;
	
 public JSONObject execute() throws Exception
 {
	 
	 HttpResponse response = executeForHttpResponse();
	 BasicResponseHandler handler = new BasicResponseHandler();
	 String responseString = handler.handleResponse(response);

	 Log.e("JSONRequest",responseString);
	 json = new JSONObject(responseString);
	 return json;
 }
	
}
