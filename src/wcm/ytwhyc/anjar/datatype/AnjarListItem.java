package wcm.ytwhyc.anjar.datatype;

public class AnjarListItem {
	public String anjarID,hostName,topic,hostMessage,startTime,lastUpdateTime,imageUrl;
	
	public AnjarListItem(String anjarID,String hostName, String topic, 
			String hostMessage,String startTime, String lastUpdateTime,String imageUrl)
	{
		this.anjarID = anjarID;
		this.hostName = hostName;
		this.topic = topic;
		this.hostMessage = hostMessage;
		this.startTime = startTime;
		this.lastUpdateTime = lastUpdateTime;
		this.imageUrl = imageUrl;
	}
	
}
