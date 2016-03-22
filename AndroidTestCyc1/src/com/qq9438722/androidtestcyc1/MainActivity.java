package com.qq9438722.androidtestcyc1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button aButton1;
	private Button aButton2;
	
	private EditText aEditText1;
	private EditText aEditText2;
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		aButton1=(Button) findViewById(R.id.button1);
		aButton2=(Button) findViewById(R.id.button2);
		aEditText1=(EditText) findViewById(R.id.editText1);
		aEditText2=(EditText) findViewById(R.id.editText2);
		
		onClickListener listener = new onClickListener();
		aButton1.setOnClickListener(listener);
		
		onClickListener2 listener2=new onClickListener2();
		aButton2.setOnClickListener(listener2);
		
	}

	class onClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if (aEditText1.getText().toString().isEmpty()) {
				aEditText1.setError("用户名不能为空");
			}else if (aEditText2.getText().toString().isEmpty()) {
				aEditText2.setError("密码不能为空");
			}else if (aEditText1.getText().toString().equals("cyc") && aEditText2.getText().toString().equals("123")) {
				Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
			}else if (!aEditText1.getText().toString().equals("cyc") || !aEditText2.getText().toString().equals("123")) {
				Toast.makeText(getApplicationContext(), "用户名或密码错误", Toast.LENGTH_SHORT).show();
			} 
		}
	}
	
	class onClickListener2 implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Toast.makeText(getApplicationContext(), "暂不开放注册", Toast.LENGTH_SHORT).show();
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
