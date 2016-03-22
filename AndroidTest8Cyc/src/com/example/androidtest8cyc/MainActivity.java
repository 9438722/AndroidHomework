package com.example.androidtest8cyc;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ExpandableListView expandableListView;
	private ArrayList<group> aGroups;
	private ArrayList<Child> aChilds;
	private BaseExpandableListAdapter adapter;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		expandableListView=(ExpandableListView) findViewById(R.id.ExpandableListView1);
		aChilds = new ArrayList<Child>();
		aGroups = new ArrayList<group>();
		
		aChilds.add(new Child(R.drawable.a1, "����"));
		aChilds.add(new Child(R.drawable.a2, "����"));
		aChilds.add(new Child(R.drawable.a3, "��"));
		aGroups.add(new group(R.drawable.g1, "Сѧ��", aChilds));
		aChilds.clear();
		
		aChilds.add(new Child(R.drawable.a4, "˼˼"));
		aChilds.add(new Child(R.drawable.a5, "����"));
		aChilds.add(new Child(R.drawable.a6, "����"));
		aChilds.add(new Child(R.drawable.a7, "����"));
		aGroups.add(new group(R.drawable.g2, "��ѧ��", aChilds));
		aChilds.clear();
		
		aChilds.add(new Child(R.drawable.a8, "�Ű�"));
		aChilds.add(new Child(R.drawable.a9, "����"));
		aChilds.add(new Child(R.drawable.a10, "ʫʫ"));
		aGroups.add(new group(R.drawable.g3, "��ѧ��", aChilds));
		
		adapter = new BaseExpandableListAdapter() {
			
			@Override
			public boolean isChildSelectable(int arg0, int arg1) {
				// TODO �Զ����ɵķ������
				return true;
			}
			
			@Override
			public boolean hasStableIds() {
				// TODO �Զ����ɵķ������
				return true;
			}
			
			@Override
			public View getGroupView(int arg0, boolean arg1, View arg2, ViewGroup arg3) {
				// TODO �Զ����ɵķ������
				if (arg2 == null) {
					arg2=LayoutInflater.from(MainActivity.this).inflate(R.layout.group, arg3, false);
				}
				if (arg2 != null) {
					ImageView imageView=(ImageView) arg2.findViewById(R.id.imageView1);
					imageView.setImageResource(aGroups.get(arg0).getImggeId());
					TextView textView = (TextView) arg2.findViewById(R.id.textView1);
					textView.setText(aGroups.get(arg0).getName());
				}
				return arg2;
			}
			
			@Override
			public long getGroupId(int arg0) {
				// TODO �Զ����ɵķ������
				return arg0;
			}
			
			@Override
			public int getGroupCount() {
				// TODO �Զ����ɵķ������
				return aGroups==null?0:aGroups.size();
			}
			
			@Override
			public Object getGroup(int arg0) {
				// TODO �Զ����ɵķ������
				return aGroups==null?0:aGroups.get(arg0);
			}
			
			@Override
			public int getChildrenCount(int arg0) {
				// TODO �Զ����ɵķ������
				return aGroups==null?0:aGroups.get(arg0).getaChilds().size();
			}
			
			@Override
			public View getChildView(int arg0, int arg1, boolean arg2, View arg3,
					ViewGroup arg4) {
				if (arg3 == null) {
					arg3=LayoutInflater.from(MainActivity.this).inflate(R.layout.child, arg4, false);
				}
				if (arg3 != null) {
					ImageView imageView=(ImageView) arg3.findViewById(R.id.imageView1);
					imageView.setImageResource(aGroups.get(arg0).getaChilds().get(arg1).getImageId());
					TextView textView = (TextView) arg3.findViewById(R.id.textView1);
					textView.setText(aGroups.get(arg0).getaChilds().get(arg1).getName());
				}
				return arg3;
			}
			
			@Override
			public long getChildId(int arg0, int arg1) {
				// TODO �Զ����ɵķ������
				return arg1;
			}
			
			@Override
			public Object getChild(int arg0, int arg1) {
				// TODO �Զ����ɵķ������
				return aGroups==null?null:aGroups.get(arg0).getaChilds().get(arg1);
			}
		};
		expandableListView.setAdapter(adapter);
		expandableListView.setGroupIndicator(null);
		
		expandableListView.setOnGroupClickListener(new OnGroupClickListener() {
			
			@Override
			public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "�������"+aGroups.get(groupPosition).getName()+"����", Toast.LENGTH_SHORT).show();
				return false;
			}
		});
		
		expandableListView.setOnChildClickListener(new OnChildClickListener() {
			
			@Override
			public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "�����"+aGroups.get(groupPosition).getaChilds().get(childPosition).getName()+"���������", Toast.LENGTH_SHORT).show();
				return false;
			}
		});
		
		expandableListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {
			
			@Override
			public void onGroupCollapse(int groupPosition) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "���۵���"+aGroups.get(groupPosition).getName()+"����", Toast.LENGTH_SHORT).show();
				
			}
		});
		
		expandableListView.setOnGroupExpandListener(new OnGroupExpandListener() {
			
			@Override
			public void onGroupExpand(int groupPosition) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "��չ����"+aGroups.get(groupPosition).getName()+"����", Toast.LENGTH_SHORT).show();
				
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