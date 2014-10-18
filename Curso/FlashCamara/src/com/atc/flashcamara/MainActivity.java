package com.atc.flashcamara;

import com.atc.flashcamara.R;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ToggleButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		
		/*
		 * Declarar variables
		 */
		private Camera camera;
		private boolean isFlashOn;
		private boolean hasFlash;
		Parameters param;		

		public PlaceholderFragment() {
		}

				@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			
			/*
			 * Primero checar el dispositivo que soporta el flash de Camara o No
			 */
			
			hasFlash = getActivity().getApplicationContext().getPackageManager()
					.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
			
			if(!hasFlash){
				
				//El dispositvo no soporta el flash
				//Mostrar mensaje de alerta y cerrar la aplicacion
				AlertDialog alert= new AlertDialog.Builder(getActivity().
						getApplicationContext()).create();
				
				alert.setTitle("Error");
				alert.setMessage("Tu dispositivo no soporta la luz del flash!");
				alert.setButton("OK",new  DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(final DialogInterface dialog, final int which) {
						// Cerrando aplicacion
						getActivity().finish();
						
					}
				});
				
				alert.show();			
				return rootView;
			}
			getCamera();
			
			ToggleButton  flash =(ToggleButton) rootView.findViewById(R.id.flash_switch1);
			
			flash.setOnCheckedChangeListener(new OnCheckedChangeListener() {			
				
				public void onCheckedChanged(CompoundButton buttonView, 
								boolean isChecked) {
						    
							if(isChecked){
								turnOnFlash();
								
							}else{
								turnOffFlash();
							}
						}
							
					});
			return rootView;
			
		}
		private void getCamera() {
				
				if(camera==null){
					try{
						camera=Camera.open();
						param= camera.getParameters();
					}catch(RuntimeException e){
						Log.e("Error de Camara.Falla al Abrir.Error:",e.getMessage());
					}
					
				}
				
			}
		
		
		private void turnOnFlash(){
			if(!isFlashOn){
				if(camera== null || param==null){
					return;
				}			
			
				param=camera.getParameters();
				param.setFlashMode(Parameters.FLASH_MODE_TORCH);
				camera.setParameters(param);
				camera.startPreview();
				isFlashOn=true;
				
				Log.v("AndoridATC", "El Flash a sido prendido...");
				
			}
				
		}
		
		private void turnOffFlash(){
			if(isFlashOn){
				if(camera== null || param==null){
					return;
				}			
			
				param=camera.getParameters();
				param.setFlashMode(Parameters.FLASH_MODE_OFF);
				camera.setParameters(param);
				camera.stopPreview();
				isFlashOn=false;
				
				Log.v("AndoridATC", "El Flash a sido apagado...");
				
			}
			
		}
		
		@Override
		public void onPause() {
			
			super.onPause();
			turnOffFlash();
			
		}
	
	
		@Override
		public void onStart() {
			
			super.onStart();
			getCamera();
		}
	
	
		@Override
		public void onStop() {
			
			super.onStop();
			if(camera != null){
				camera.release();
				camera=null;
				
			}
		}
	
	
	}
}
