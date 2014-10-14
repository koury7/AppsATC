package com.atc.primeraappandroid;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
		 * Declarar Variables
		 */
		private float altura;
		private float peso;
		private float IMC;
				
		
	public PlaceholderFragment() {
		}

		@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			
			
			
			Button btnCalcular = (Button) rootView.findViewById(R.id.btnCalcular);
			final EditText altura_valor = (EditText) rootView.findViewById(R.id.txtAltura);
			final EditText peso_valor = (EditText) rootView.findViewById(R.id.txtPeso);
			final TextView resultado = (TextView) rootView.findViewById(R.id.txtResultado);
			
			btnCalcular.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if (altura_valor.getText().length() > 0
							&& peso_valor.getText().length() > 0) {
							altura = Float.parseFloat(altura_valor.getText()
							.toString());
							peso = Float.parseFloat(peso_valor.getText()
							.toString());
							
							IMC = CalcularBMI(peso, altura);
							
							if (IMC < 16) {
								resultado.setText("Tu IMC: " + IMC + "( BajoPeso Severo )");
								} else if (IMC < 18.5) {
								resultado.setText("Tu IMC: " + IMC + "( Bajopeso )");
								} else if (IMC < 25) {
								resultado.setText("Tu IMC: " + IMC + "( Normal )");
								} else if (IMC < 30) {
								resultado.setText("Tu IMC: " + IMC + "( Sobrepeso )");
								} else {
								resultado.setText("Tu IMC: " + IMC + "( Obesidad )");
								}
							
							
							
					}
				}
			});
			
			
			return rootView;
			
			
		}
		
		private float CalcularBMI(float peso, float altura) {
			altura = (altura / 100);
			return (float) (peso / (altura * altura));
			}
	}
	
	
	
	
	
}
