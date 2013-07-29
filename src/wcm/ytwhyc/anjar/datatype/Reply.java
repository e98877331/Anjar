package wcm.ytwhyc.anjar.datatype;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
		userName = jobj.getString("UserName");
		userID = jobj.getString("UserID");
		floorNumber = jobj.getString("FloorNumber");
		content = jobj.getString("Content");
		postTime = jobj.getString("PostTime");
	}
}
