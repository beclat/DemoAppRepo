package com.example.demochatapp;

import android.app.Activity;
import android.content.ContentUris;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.Contacts;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactDetailsActivity extends Activity{
	ImageView img;
	TextView tv;
	long id,photo_id;
	String name;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact_details);
		id= getIntent().getExtras().getLong("id");
		photo_id=getIntent().getExtras().getLong("photo_id");
		name=getIntent().getExtras().getString("name");
		
		img=(ImageView) findViewById(R.id.imageView1);
		tv=(TextView) findViewById(R.id.textView1);
		tv.setText(name);
		
		if(photo_id==0)
		{
			img.setImageResource(R.drawable.ic_launcher);
		}
		else
		{
			Uri contact_uri=ContentUris.withAppendedId (
		            ContactsContract.Contacts.CONTENT_URI,id);
			Uri photo_uri=Uri.withAppendedPath(contact_uri,Contacts.Photo.CONTENT_DIRECTORY);
			img.setImageURI(photo_uri);
		}
		
	}

}
