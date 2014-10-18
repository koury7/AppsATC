package com.atc.prueba01;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Principal extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.principal);
		
		TextView mensaje= (TextView)findViewById(R.id.Mensaje);
	    mensaje.setText("Hola ATC");
	    
	}
	
}
