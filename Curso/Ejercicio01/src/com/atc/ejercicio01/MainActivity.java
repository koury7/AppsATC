package com.atc.ejercicio01;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		
		final String[] arreglo =new String[]{
				"Opcion1",
				"Opcion2",
				"Opcion3",
				"Opcion4",
				"Opcion5"
				
		};
		
		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,
				arreglo));		
	}
}
