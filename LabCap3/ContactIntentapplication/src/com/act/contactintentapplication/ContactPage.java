package com.act.contactintentapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;




public class ContactPage extends Activity implements OnClickListener {

	private final int Phone=0;
	private final int Email=1;
	private final int Website=2;
	
	private TextView contactName;
	private TextView contactEmail;
	private TextView contactPhone;
	private TextView contactWebsite;
	
	private ContactObject contactObject;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contactpage);
		
		contactName= (TextView) findViewById(R.id.contactName);
		contactEmail= (TextView) findViewById(R.id.contactEmail);
		contactPhone= (TextView) findViewById(R.id.contactPhone);
		contactWebsite= (TextView) findViewById(R.id.contactWebsite);
		
		Bundle extras = getIntent().getExtras();
		if(extras ==null)
			return;		
		contactObject=(ContactObject)
				getIntent().getSerializableExtra("Object");
		
		contactName.setText(contactObject.getName());
		contactEmail.setText("Email:" + contactObject.getEmail());
		contactPhone.setText("Phone:" + contactObject.getPhone());
		contactWebsite.setText("Website:" + contactObject.getWebsite());
		
		contactEmail.setOnClickListener( this);
		contactPhone.setOnClickListener( this);
		contactWebsite.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v){
		switch (v.getId()) {
		case R.id.contactPhone:
			Intent i = new Intent();
			i.putExtra("value", contactObject.getPhone());
			setResult(Phone , i);
			finish();
			break;
		case R.id.contactEmail:
			i = new Intent();
			i.putExtra("value", contactObject.getEmail());
			setResult(Email , i);
			finish();
			break;
		case R.id.contactWebsite:
			i = new Intent();
			i.putExtra("value", contactObject.getWebsite());
			setResult(Website , i);
			finish();
			break;

	
		}
	}


	

}
