package com.example.notification;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class AddActivity extends Activity {
	private Button conButton;
	private TimePicker tp;
	private DatePicker dp;
	private EditText etTitle, etNote;
	private String title, text;
	private SharedPreferences sp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add);
		init();
	}

	protected void onStart() {
		super.onStart();
		conButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				saveTime();

			}
		});
	}

	@SuppressLint("NewApi")
	public void init() {
		conButton = (Button) findViewById(R.id.add_bt_confirm);
		tp = (TimePicker) findViewById(R.id.timePicker1);
		dp = (DatePicker) findViewById(R.id.datePicker1);
		etTitle = (EditText) findViewById(R.id.add_et_title);
		etNote = (EditText) findViewById(R.id.add_et_note);
		tp.setIs24HourView(true);
		dp.setCalendarViewShown(false);
		sp = getSharedPreferences("UserNote", MODE_PRIVATE);
	}

	public void saveTime() {
		text = etNote.getText().toString();
		title = etTitle.getText().toString();
		int day = dp.getDayOfMonth();
		int mon = dp.getMonth()+1;//getMonth 返回从0开始
		System.out.println("setMon is"+mon);
		int year = dp.getYear();
		int hour = tp.getCurrentHour();
		int min = tp.getCurrentMinute();
		
		SimpleDateFormat sdf = new SimpleDateFormat("HHmm");

		String time = MyTime.getTime(year,mon,day,hour, min);
		System.out.println(time);
		SharedPreferences.Editor editor = sp.edit();
		editor.putString("text", text);
		editor.putString("time", time);
		editor.putString("title",title);
		editor.commit();
		System.out.println(time);
		Intent intent = new Intent(AddActivity.this, NotifyService.class);
		startService(intent);
		Log.i("ADD","intent完毕");
		finish();
	}

}
