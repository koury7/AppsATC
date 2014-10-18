package com.atc.ejercicio03;

import com.atc.ejercicio03.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/*
		 * Crear arreglo de String
		 */
		final String[] arreglo =new String[]{
				"Opcion1",
				"Opcion2",
				"Opcion3",
				"Opcion4",
				"Opcion5"
				
		};
		
		/*
		 * Crear adaptador
		 */
		
		/*
		 * Crear adaptador para asignar el arreglo a una vista previa y posteriormente
		 * asignar al listView
		 */
		ArrayAdapter<String> adaptador=
				new ArrayAdapter<String>(this,
				R.layout.lista_os,//quien lo cre
				arreglo   //origen de los datos
				);	
		
		//listview = (ListView)findViewById(R.id.listViewOS);	
		ListView listview = (ListView) findViewById(R.id.listViewOS);
		
		
		listview.setAdapter(adaptador);
		
	}
}
