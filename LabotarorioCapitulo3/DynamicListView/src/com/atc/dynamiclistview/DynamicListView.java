package com.atc.dynamiclistview;

import java.util.ArrayList;

import com.atc.dynamiclistview.R.string;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class DynamicListView extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//inflate your view
		setContentView(R.layout.dynamic_list_view_activity);
		
		//get references to UI widgets
		final EditText item  = (EditText) findViewById(R.id.myEditText);
		Button add = (Button) findViewById(R.id.myAddButton);
		ListView dynamicListView = (ListView) findViewById(R.id.myListView);
		
		//Initialize the list and add item
		 final ArrayList<String> list = new ArrayList<String>();
		
		//initialize the arrayAdapter
		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(DynamicListView.this,
				android.R.layout.simple_list_item_1,list);
		
		//setting the adapter t the list view
		dynamicListView.setAdapter(adapter);
		
		//add item to the listView on click button (add)
		add.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// add editText Value to the list
				list.add(item.getText().toString());
				
				//apply changes on the adapter to refresh the lisView
				adapter.notifyDataSetChanged();
				
				//clear the editText for the new item
				item.setText(" ");
				
			}		
			
		});
		
		//delete item on the long click on the item
		dynamicListView.setOnItemLongClickListener(new
		OnItemLongClickListener() {
						
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
			

				//remove the item from list
				list.remove(position);
				
				//apply changes on the adapter to refresh the listView
				adapter.notifyDataSetChanged();
				return false;
			}
			
		})	;	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dynamic_list_view, menu);
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
