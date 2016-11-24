package com.example.notification;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	private Button button;
	private SharedPreferences sp;
	private TextView title, note,time;
	private String strTitle,strNote,strTime;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		sp = getSharedPreferences("UserNote",MODE_PRIVATE);
	}

	@Override
	protected void onStart() {
		super.onStart();
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, AddActivity.class);
				startActivity(intent);
			}
		});

	}
	protected void onResume(){
		super.onResume();
		strTime = sp.getString("time","null");
		strTitle = sp.getString("title","null");
		strNote = sp.getString("text","null");
		title.setText(strTitle);
		note.setText(strNote);
		time.setText(strTime);
		System.out.println("onResume");
		
	}

	public void init() {

		button = (Button) findViewById(R.id.bt);
		title = (TextView) findViewById(R.id.main_title);
		note = (TextView) findViewById(R.id.main_note);
		time = (TextView)findViewById(R.id.main_time);
	}
}
