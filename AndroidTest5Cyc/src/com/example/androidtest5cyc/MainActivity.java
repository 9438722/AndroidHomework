package com.example.androidtest5cyc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.androidtest5cyc.R.id;

import android.app.Activity;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {

	private ListView listView;
	private SimpleAdapter Adapter;
	
	private int[] images={R.drawable.i1,R.drawable.i2,R.drawable.i3};
	private String[] names={"我是用户名一","我是用户名二","我是用户名三"};
	private String[] infos={"我是个性签名一","我是个性签名二","我是个性签名三"};
	private String[] states={"在线","隐身","离线"};
	
	private String[] from={"images","names","infos","states"};
	private int[] to={R.id.imageView1,R.id.textView1,R.id.textView2,R.id.textView3};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView=(ListView) findViewById(R.id.ListView1);
		
		ArrayList<HashMap<String, Object>> data = new ArrayList<HashMap<String,Object>>();
		
		for (int i = 0; i < images.length; i++) {
			HashMap<String, Object> item = new HashMap<String, Object>();
			item.put(from[0], images[i]);
			item.put(from[1], names[i]);
			item.put(from[2], infos[i]);
			item.put(from[3], states[i]);
			data.add(item);
		}
		
		Adapter=new SimpleAdapter(MainActivity.this, data, R.layout.item, from, to);
		listView.setAdapter(Adapter);
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
