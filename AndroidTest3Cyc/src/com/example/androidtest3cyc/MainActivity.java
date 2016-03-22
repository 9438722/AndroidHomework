package com.example.androidtest3cyc;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends Activity {
	private int[] a={R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5,R.drawable.p6,R.drawable.p7,R.drawable.p8};
	private int i=7;
	private ImageSwitcher imageSwitcher;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		imageSwitcher=(ImageSwitcher) findViewById(R.id.imageSwitcher1);
		imageSwitcher.setFactory(new ViewFactory() {
			@Override
			public View makeView() {
				ImageView imageView=new ImageView(MainActivity.this);
				return imageView;
			}
		});
		
		imageSwitcher.setImageResource(a[i]);
		OnClickListener listener=new onClickListener1();
		imageSwitcher.setOnClickListener(listener);
		
	
		LinearLayout linearLayout2=(LinearLayout) findViewById(R.id.LinearLayout2);
		for (int i = 0; i <a.length; i++) {
			ImageView imageView=new ImageView(MainActivity.this);
			imageView.setImageResource(a[i]);
			imageView.setAlpha(0.3f);
			imageView.setPadding(10, 0, 0, 0);
			linearLayout2.addView(imageView,130,180);
			onClickListener2 listener2=new onClickListener2();
			imageView.setOnClickListener(listener2);
		}
		
	}
	
	
	class onClickListener1 implements OnClickListener{
		@Override
		public void onClick(View view) {
			imageSwitcher.setImageResource(a[i++]);
				if (i==8) {
					i=0;
				}
		}
	}
	
	class onClickListener2 implements OnClickListener{
		@Override
		public void onClick(View view) {
			ImageView imageView2=(ImageView) view;
			imageSwitcher.setImageDrawable(imageView2.getDrawable());
			imageView2.setAlpha(1.0f);
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
