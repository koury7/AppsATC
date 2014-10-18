package com.atc.ejercicio04;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	public static int SHOW_SUBACTIVITY=1;
	
	TextView resultado;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		resultado = (TextView)findViewById(R.id.txtRespuesta);
		
        		}
	
	
	
	public void mostrar(View view){
		
		Intent i = new Intent(this,Activity2.class);
		i.putExtra("Parametro1", "Este es el parametro 1");
		startActivity(i);
		
		
	}
	
	public void navegar(View view){
		 
		 Intent i= new Intent(Intent.ACTION_DIAL,
				 Uri.parse("tel:4614216943"));
		 startActivity(i);
	 }
	 
	public void mostrar2(View view)
		{
			
			Intent i = new Intent(this,Activity2.class);		
			startActivityForResult(i, SHOW_SUBACTIVITY);
					
		}
	
	public void onActivityResult(int requestCode,
			int resultCode,Intent data )
	{
		
		super.onActivityResult(requestCode, resultCode, data);
			switch(requestCode)
			{
				case 1:
					if(resultCode==Activity.RESULT_OK){
						String res = data.getExtras().getString("Resultado");
						resultado.setText(res);
					}	
			}
		
		
	}
	
}
