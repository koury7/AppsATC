package com.atc.ejercicio04;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	public static int SHOW_SUBACTIVITY = 1; //Ejercicio listener
	TextView Resultado; //Ejercicio listener

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
      //Ejercicio listener
        Resultado=(TextView)findViewById(R.id.textView2);
        
    }
    
    public void mostrar(View v){
    	Intent i=new Intent(this,PantallaSecundaria.class);
    	
    	i.putExtra("x","llegaste");
    	startActivity(i);
    	finish();
    }
    
    public void navegar(View v){
    	//intent implicita
    	//necesita permisos de internet, androidManifest, permissions user permission
    	Intent i=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.google.com.mx"));
    	startActivity(i);
    }
    public void llamar(View v){
    	//intent implicita
    	Intent i=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:4611444744")); //para este no se neceita permiso
    	startActivity(i);
    }
    
  //Ejercicio listener
    public void mostrar2(View v){
    	Intent i=new Intent(this,PantallaSecundaria.class);
    	startActivityForResult(i, SHOW_SUBACTIVITY);
    }
    
  //Ejercicio listener
    //@Override // aqui puede tener override o no, dependiendo la version manejada
   public void onActivityResult(int requestCode, int resultCode, Intent data){
    	super.onActivityResult(requestCode, resultCode, data);
    	
    	/*esto es para el caso de tener varias opciones
    	 * 
    	 * switch(requestCode){
    	case 1:
    		if(resultCode==Activity.RESULT_OK){
        		String res=data.getExtras().getString("Resultado");
        		Resultado.setText(res);
        	}
        	
    	}*/
    	//aqui solo es una opcion por eso es viable el if
    	if(resultCode==Activity.RESULT_OK){
    		String res=data.getExtras().getString("Resultado");
    		Resultado.setText(res);
    	}
    	
    }
}
