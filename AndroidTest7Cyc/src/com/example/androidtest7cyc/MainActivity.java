package com.example.androidtest7cyc;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ListView listView;
	private ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		listView=(ListView) findViewById(R.id.listView1);
		ArrayList<String> data = new ArrayList<String>();
		for (int i = 0; i < 20; i++) {
			data.add(i+"");
		}
		adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_multiple_choice, data);
		listView.setAdapter(adapter);
		View v = View.inflate(MainActivity.this, R.layout.footer, null);
		listView.addFooterView(v);
		//==================================
		View v2=View.inflate(MainActivity.this, R.layout.header, null);
		listView.addHeaderView(v2);
		ProgressBar progressBar=(ProgressBar) v2.findViewById(R.id.progressBar);
		progressBar.setOnDragListener(new OnDragListener() {
			
			@Override
			public boolean onDrag(View v, DragEvent event) {
				// TODO Auto-generated method stub
				for (int i = 55; i < 66; i++) {
					adapter.add(i+"");
					adapter.notifyDataSetChanged();
				}
				return false;
			}
		});
		//=================================
		TextView textView=(TextView) v.findViewById(R.id.textView1);
		textView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				for (int i = 0; i < 20; i++) {
					adapter.add(i+"");
					adapter.notifyDataSetChanged();
				}
			}
		});
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Toast.makeText(MainActivity.this, adapter.getItem(arg2),Toast.LENGTH_SHORT).show();
			}
		});
		listView.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				adapter.remove(adapter.getItem(position));
				adapter.notifyDataSetChanged();
				return false;
			}
		});
		
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
