package wcm.ytwhyc.anjar.datatype;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class Reply {

	public String userName,userID,floorNumber,content,postTime;
	
	public Reply(String pUserName,String pUserID,String pFloorNumber,String pContent,String pPostTime)
	{
		userName = pUserName;
		userID = pUserID;
		floorNumber = pFloorNumber;
		content = pContent;
		postTime = pPostTime;
	}

	public Reply(JSONObject jobj) throws JSONException
	{
//		userName = jobj.getString("UserName");
//		userID = jobj.getString("UserID");
//	//	Log.e("Reply",userID);
//		floorNumber = jobj.getString("FloorNumber");
//		content = jobj.getString("Content");
//		postTime = jobj.getString("PostTime");
		
		userName = getValue(jobj, "UserName");
		userID = getValue(jobj,"UserID");
		floorNumber = getValue(jobj,"FloorNumber");
		content = getValue(jobj, "Content");
		postTime = getValue(jobj, "PostTime");
	}
	
	private String getValue(JSONObject jobj,String key) throws JSONException
	{
		if(jobj.has(key))
			return jobj.getString(key);
		else 
			return "ERROR:NO SUCH KEY";
	}
}
