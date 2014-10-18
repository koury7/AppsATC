package com.atc.ejercicio04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PantallaSecundaria extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity2);
		
		Bundle extras=getIntent().getExtras();
		//TextView texto=(TextView)findViewById(R.id.textView1);
		//texto.setText("La cadena recibida es: "+extras.getString("x".toString()));
		
		//Ejercicio listener
		// con las siguientes lineas se mandara un dato a la pantalla principal
		Button boton = (Button)findViewById(R.id.button2);
		final EditText texto2=(EditText)findViewById(R.id.editText1);
		
		boton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String txt = texto2.getText().toString();
				Intent i = getIntent();
				i.putExtra("Resultado", txt);
				setResult(RESULT_OK,i);
				finish();
			}
		});
	}
	 public void regresar(View v){
	    	Intent i=new Intent(this,MainActivity.class);
	    	startActivity(i);
	    	finish();
	    }
	
}
