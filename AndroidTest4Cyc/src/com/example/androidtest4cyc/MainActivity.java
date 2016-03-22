package com.example.androidtest4cyc;

import java.lang.reflect.Array;
import java.util.ArrayList;

import android.R.anim;
import android.R.string;
import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.annotation.RawRes;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private AutoCompleteTextView aAutoCompleteTextView;
	private ArrayAdapter<String> Adapter;
	
	private Spinner spinner;
	
	private Button button1;
	private Button button2;
	
	private TextView textView1;
	private TextView textView2;
	
	private RadioGroup radioGroup;
	private RadioButton radioButton1;
	private RadioButton radioButton2;
	
	private CheckBox checkBox1;
	private CheckBox checkBox2;
	private CheckBox checkBox3;
	
	private Switch switch1;
	
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		aAutoCompleteTextView=(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
		ArrayList<String> data = new ArrayList<String>();
		for (int i = 0; i < 20; i++) {
			data.add("cyc"+i);
		}
		Adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, data);
		aAutoCompleteTextView.setAdapter(Adapter);
		
		spinner=(Spinner) findViewById(R.id.spinner1);
		
		radioGroup=(RadioGroup) findViewById(R.id.radioGroup1);
		radioButton1=(RadioButton) findViewById(R.id.radio0);
		radioButton2=(RadioButton) findViewById(R.id.radio1);
		
		checkBox1=(CheckBox) findViewById(R.id.checkBox1);
		checkBox2=(CheckBox) findViewById(R.id.checkBox2);
		checkBox3=(CheckBox) findViewById(R.id.checkBox3);
		
		switch1=(Switch) findViewById(R.id.switch1);
		
		button1=(Button) findViewById(R.id.button1);
		button2=(Button) findViewById(R.id.button2);
		
		button1.setOnClickListener(new onClickListener1());
		button2.setOnClickListener(new onClickListener2());
		
		
	}
	
	class onClickListener1 implements android.view.View.OnClickListener{

		@Override
		public void onClick(View view) {
			// 提交
			StringBuffer stringBuffer=new StringBuffer();
			String name=aAutoCompleteTextView.getText().toString();
			
			//输出姓名
			if(name==null || name.equals("")){                        
				aAutoCompleteTextView.setError("姓名不能为空！");
			}else {
				stringBuffer.append("姓名："+name);
			}
			
			//输出年龄
			String age=spinner.getSelectedItem().toString();
			stringBuffer.append("，年龄："+age);
			
			//输出性别
			if (radioButton1.isChecked()) {                             
				stringBuffer.append(",性别："+radioButton1.getText()+",");
			}else {
				stringBuffer.append(",性别："+radioButton2.getText()+",");
			}
			
			//输出爱好
			if (checkBox1.isChecked() || checkBox2.isChecked() || checkBox3.isChecked()) {  
				stringBuffer.append("爱好：");
				if (checkBox1.isChecked()) {
					stringBuffer.append(checkBox1.getText()+",");
				}
				if (checkBox2.isChecked()) {
					stringBuffer.append(checkBox2.getText()+",");
				}
				if (checkBox3.isChecked()) {
					stringBuffer.append(checkBox3.getText()+",");
				}
			}else {
				stringBuffer.append("爱好：无,");
			}
			
			//输出政治面貌
			if (switch1.isChecked()) {
				stringBuffer.append("政治面貌："+switch1.getTextOn());
			}else {
				stringBuffer.append("政治面貌："+switch1.getTextOff());
			}
			
			Toast.makeText(MainActivity.this, stringBuffer, Toast.LENGTH_LONG).show();
			
		}
	}
	
	class onClickListener2 implements android.view.View.OnClickListener{

		@Override
		public void onClick(View view) {
			// 重置
			aAutoCompleteTextView.setText(null);
			radioButton1.setChecked(true);
			radioButton2.setChecked(false);
			spinner.setSelection(0);
			checkBox1.setChecked(false);
			checkBox2.setChecked(false);
			checkBox3.setChecked(false);
			switch1.setChecked(false);
		}
	}
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
