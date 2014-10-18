package com.atc.ejercicio06;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //Mensaje en pantalla por tiempo que desaparece auto
        Toast.makeText(this, 
        		"Ya nos vamos",Toast.LENGTH_LONG).show();
        
                
    }
    
    public void dialogoPersona (View view)
    {
    	final Dialog dialogo= new Dialog(this);
    	dialogo.setTitle("Dialogo Personalizado ");
    	dialogo.setContentView(R.layout.dialogo_view);
    	
    	TextView titulo1 =
    			(TextView) dialogo.findViewById(R.id.textView1);
    	TextView titulo2 =
    			(TextView) dialogo.findViewById(R.id.textView2);
    	
    	titulo1.setText("Este es el titulo 1");
    	titulo2.setText("Este es el titulo 2");
    	dialogo.show();
    	
    	    	
    }
}
