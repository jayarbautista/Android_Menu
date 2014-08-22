package com.android.exercises.simplemenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

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
		// Inflate the menu; this adds items to the action bar if it is present.
		menu.add(0, 1, 0, "Add");
		menu.add(0, 2, 0, "Edit");
		menu.add(0, 3, 3, "Delete");
		menu.add(1, 4, 1, "Copy");
		menu.add(1, 5, 2, "Paste");
		menu.add(1, 6, 4, "Exit");
		
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// menu items with group ID = 1 are visible if checkbox is checked
		menu.setGroupVisible(1, mCheckBox.isChecked());
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
