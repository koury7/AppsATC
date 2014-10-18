package com.atc.ejercicio02;
/*
 * Otro forma de crear un listView , por ejemplo agregar items a una lista 
 */

import com.atc.ejercicio02.R;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		/*
		 * Linea del setContentView no se elimina por que  anteriormente todo el activity es un 
		 *ListView 
		 * */
		setContentView(R.layout.activity_main);
		
		final String[] arreglo =new String[]{
				"Opcion1",
				"Opcion2",
				"Opcion3",
				"Opcion4",
				"Opcion5"
				
		};
		// Crear variable LISTVIEW
		final ListView lista = (ListView) findViewById(R.id.listView1);
		
		//Crear Adaptador Arreglo String
		ArrayAdapter<String> adaptador =
		new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,
				arreglo);	
		//Asign  el adaptador a la lista	
		lista.setAdapter(adaptador);
		
		
	}
}
