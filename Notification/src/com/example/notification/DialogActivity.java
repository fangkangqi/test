package com.example.notification;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class DialogActivity extends Activity {
	private SharedPreferences sp ;
	private TextView tv;
	private Button bt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dialog);
		sp = getSharedPreferences("UserNote",MODE_PRIVATE);
		tv = (TextView)findViewById(R.id.dialog_tv);
		bt = (Button)findViewById(R.id.dialog_bt);
		 getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
			        | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
	}
	protected void onStart(){
		super.onStart();
		tv.setText(sp.getString("title","null")+"\n"+sp.getString("text", "null"));
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				finish();
				
			}
		});
	}

}
