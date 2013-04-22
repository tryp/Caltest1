package com.cjd.caltest1;

import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

public class AddEventActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Intent intent = getIntent();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_event);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_event, menu);
		return true;
	}

	
    public void addEvent(View view) {
    	Intent intent = new Intent(Intent.ACTION_EDIT);
    	Calendar cal = getDate();
    	intent.setType("vnd.android.cursor.item/event");
    	intent.putExtra("beginTime", cal.getTimeInMillis());
    	intent.putExtra("allDay", false);
    	intent.putExtra("endTime", cal.getTimeInMillis() + 60*60*1000);
    	intent.putExtra("cjd_testevent", "Test Event!");
    	startActivity(intent);
    }
    
    private Calendar getDate() {
    	DatePicker d = (DatePicker) findViewById(R.id.datePicker);
    	TimePicker t = (TimePicker) findViewById(R.id.timePicker);
    	Calendar cal = Calendar.getInstance();
    	cal.set(d.getYear(), d.getMonth(), d.getDayOfMonth(), t.getCurrentHour(), t.getCurrentMinute());
    	return cal;
    }
	
}
