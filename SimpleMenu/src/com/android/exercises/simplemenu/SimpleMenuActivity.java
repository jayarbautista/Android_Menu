package com.android.exercises.simplemenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextView;

public class SimpleMenuActivity extends Activity {

	TextView mText;
	CheckBox mCheckBox;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_menu);
		
		mText = (TextView)findViewById(R.id.textView);
		mCheckBox = (CheckBox)findViewById(R.id.chbExtMenu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.simple_menu, menu);
		
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// menu items with group ID = 1 are visible if checkbox is checked
		menu.setGroupVisible(R.id.group1, mCheckBox.isChecked());
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		StringBuilder sb = new StringBuilder();
		
		//print the information about pressed menu item
		sb.append("Item Menu");
		sb.append("\r\n Group ID: " + String.valueOf(item.getGroupId()));
		sb.append("\r\n Item ID: " + String.valueOf(item.getItemId()));
		sb.append("\r\n Order: " + String.valueOf(item.getOrder()));
		sb.append("\r\n Title: " + item.getTitle());
		mText.setText(sb.toString());
		
		return super.onOptionsItemSelected(item);
	}
}
