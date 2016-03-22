package com.example.androidtest6cyc;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ListActivity;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

	private BaseAdapter Adapter;
	private ArrayList<Goods> data;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		data = new ArrayList<Goods>();
		data.add(new Goods(R.drawable.p1, 168, 388));
		data.add(new Goods(R.drawable.p2, 268, 488));
		data.add(new Goods(R.drawable.p3, 368, 588));
		data.add(new Goods(R.drawable.p4, 468, 688));
		data.add(new Goods(R.drawable.p5, 568, 788));
		data.add(new Goods(R.drawable.p6, 668, 888));
		
		Adapter=new BaseAdapter() {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				if (convertView==null) {
					convertView=LayoutInflater.from(MainActivity.this).inflate(R.layout.item, parent, false);
				}
				if (convertView!=null) {
					ImageView imageView1= (ImageView) convertView.findViewById(R.id.imageView1);
					ImageView imageView2= (ImageView) convertView.findViewById(R.id.imageView2);
					TextView textView1=(TextView) convertView.findViewById(R.id.textView1);
					TextView textView2=(TextView) convertView.findViewById(R.id.textView2);
					Goods goods= data.get(position);
					imageView1.setImageResource(goods.getImageId());
					textView1.setText("¥："+goods.getNewPrice());
					textView2.setText("原价为："+goods.getOldPrice());
					textView2.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
					imageView1.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this, "查看商品详情", Toast.LENGTH_SHORT).show();
						}
					});
					imageView2.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this, "购买成功", Toast.LENGTH_SHORT).show();
						}
					});
				}
				return convertView;
			}
			
			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return position;
			}
			
			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return data==null?0:data.get(position);
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return data==null?0:data.size();
			}
		};
		setListAdapter(Adapter);
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
