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

		private float altura;
		private float peso;
		private float BMI;
		
		
		
	public PlaceholderFragment() {
		}

		@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			
			

			Button btnCalcular = (Button) rootView.findViewById(R.id.btnCalcular);
			final EditText Altura_value = (EditText) rootView.findViewById(R.id.txtAltura);
			final EditText Peso_value = (EditText) rootView.findViewById(R.id.txtPeso);
			final TextView result = (TextView) rootView.findViewById(R.id.txtResultado);
			
			btnCalcular.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if (Altura_value.getText().length() > 0
							&& Peso_value.getText().length() > 0) {
							altura = Float.parseFloat(Altura_value.getText()
							.toString());
							peso = Float.parseFloat(Peso_value.getText()
							.toString());
							
							BMI = CalcularBMI(peso, altura);
							
							if (BMI < 16) {
								result.setText("Your BMI: " + BMI + "( Severely underweight )");
								} else if (BMI < 18.5) {
								result.setText("Your BMI: " + BMI + "( Underweight )");
								} else if (BMI < 25) {
								result.setText("Your BMI: " + BMI + "( Normal )");
								} else if (BMI < 30) {
								result.setText("Your BMI: " + BMI + "( Overweight )");
								} else {
								result.setText("Your BMI: " + BMI + "( Obese )");
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
