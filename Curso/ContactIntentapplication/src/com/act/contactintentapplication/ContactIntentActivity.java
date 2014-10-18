package com.act.contactintentapplication;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ContactIntentActivity extends Activity {

	private final int Phone=0;
	private final int Email=1;
	private final int Website=2;
	
	private ListView intentListView;
	private ArrayAdapter<String> adapter;
	private  List<ContactObject> list;

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//inflate your view
		setContentView(R.layout.activity_contact_intent);
		
		intentListView = (ListView) findViewById(R.id.listView1);
		
		//initialize the list and add item
		
		list = new ArrayList<ContactObject>();
		list.add(new ContactObject("Android One", "111-1111-1111",
				"android1@gmail.com", "www.atc1.com"));
		list.add(new ContactObject("Android two", "222-2222-2222",
				"android2@gmail.com", "www.atc2.com"));
		list.add(new ContactObject("Android Three", "333-3333-3333",
				"android3@gmail.com", "www.atc3.com"));
		list.add(new ContactObject("Android Four", "444-4444-4444",
				"android4@gmail.com", "www.atc4.com"));
		
		List<String> listName=new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			listName.add(list.get(i).getName());
			//Ininitialize the arrayAdapter
			adapter = new ArrayAdapter<String>(ContactIntentActivity.this, 
					android.R.layout.simple_list_item_1,listName);
			//set the adapter of the list 
			intentListView.setAdapter(adapter);
			
		}
		
		intentListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				
				
				Intent i= new Intent(ContactIntentActivity.this,
						ContactPage.class);
				i.putExtra("Object", list.get(arg2));
				startActivityForResult(i, 0);
				
				
			}
			
			
		});
		
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, 
			Intent data)
	{
		Bundle resultdata = data.getExtras();
		String value = resultdata.getString("value");
		switch (resultCode) {
		case Phone:
			//Implicit intent to make a call
			startActivity(new 
			Intent(Intent.ACTION_CALL,Uri.parse("tel:" + value)));			
			break;		
		case Email:
			//Implicit intent to send a email
			startActivity(new 
			Intent(Intent.ACTION_VIEW,Uri.parse("http;//" + value)));			
			break;		
		case Website:
			//Implicit intent to visit website
			startActivity(new 
			Intent(Intent.ACTION_VIEW,Uri.parse("http://" + value)));			
			break;

		}
				
	}
}


