package com.atc.contactdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContactDialogActivity extends Activity {

	private String name;
	private String email;
	private String website;
	private Button start;
	
	    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_dialog);
        
        start=(Button) findViewById(R.id.start);
        start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				createWebDialog();
				createEmailDialog();
				createNameDialog();
				
			}
		});
    }
    
    private Dialog createNameDialog(){
    	
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	builder.setTitle("Hola Usuario ATC Android");
    	builder.setMessage("Cual es tu nombre:");
    	
    	//use an editText view to get user input
    	final EditText input = new EditText(this);
    	builder.setView(input);
    	
    	builder.setPositiveButton("OK", new 
    			DialogInterface.OnClickListener() {
			    		    		
			@Override
			public void onClick(DialogInterface dialog, int whichButton) {
				// TODO Auto-generated method stub
				name=input.getText().toString();
				dialog.dismiss();
							}
		});
    	builder.setNegativeButton("Cancel", new 
    			DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});
    	return builder.show();
    }
    
    private Dialog createEmailDialog(){
    	
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	builder.setTitle("Hola Usuario ATC Android");
    	builder.setMessage("Cual es tu correo;");
    	
    	//use an editText view to get user input
    	final EditText input = new EditText(this);
    	builder.setView(input);
    	
    	builder.setPositiveButton("OK", new 
    			DialogInterface.OnClickListener() {
			    		    		
			@Override
			public void onClick(DialogInterface dialog, int whichButton) {
				// TODO Auto-generated method stub
				email=input.getText().toString();
				dialog.dismiss();
							}
		});
    	builder.setNegativeButton("Cancel", new 
    			DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});
    	return builder.show();
    }
    
    private Dialog createWebDialog(){

    	
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	builder.setTitle("Hola Usuario ATC Android");
    	builder.setMessage("Cual es tu sitioweb;");
    	
    	//use an editText view to get user input
    	final EditText input = new EditText(this);
    	builder.setView(input);
    	
    	builder.setPositiveButton("OK", new 
    			DialogInterface.OnClickListener() {
			    		    		
			@Override
			public void onClick(DialogInterface dialog, int whichButton) {
				// TODO Auto-generated method stub
				website=input.getText().toString();
				Toast.makeText(ContactDialogActivity.this, 
				name + "\n" + email + "\n"
				+ website,Toast.LENGTH_LONG).show();
				dialog.dismiss();
							}
		});
    	builder.setNegativeButton("Cancel", new 
    			DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});
    	return builder.show();
    
    }
    
    
}
