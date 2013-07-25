package wcm.ytwhyc.anjar.loginAcitvity;

import wcm.ytwhyc.ratiofixer.RatioRelativeLayout;
import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivityView extends RatioRelativeLayout {

	public Button browseButton;
	public TextView text1;
	public EditText userName;
	
	public LoginActivityView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		browseButton = new Button(context);
		browseButton.setText("瀏覽");
		
		text1 = new TextView(context);
		text1.setText("輸入名稱");
		userName = new EditText(context);
		
		this.addView(text1, 500, 150, 20, 20);
		this.addView(userName, 500, 150, 20, 180);
		this.addView(browseButton, 200, 150, 20, 350);
		
	}


}
