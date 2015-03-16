package com.example.demochatapp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.zip.Inflater;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.ContactsContract.Contacts;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactsAdapter extends BaseAdapter{
	Context context;
	public static int count=0;
	ArrayList<Contact> contact_list;
	HashMap<String,Integer> occurance=new HashMap<String, Integer>();
	
	public ContactsAdapter(Context context, ArrayList<Contact> contact_list) {
		super();
		this.context = context;
		this.contact_list = contact_list;
		Collections.sort(contact_list);
		for(int i=0;i<contact_list.size();i++)
		{
			if(!occurance.containsKey(contact_list.get(i).getName().substring(0,1)))
			occurance.put(contact_list.get(i).getName().substring(0,1),i);
		}
	}

	
	

	

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return contact_list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return contact_list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return contact_list.get(position).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		String ch="0";
		System.out.println("count is"+count);
		
		
		LayoutInflater mInflater = (LayoutInflater) 
	            context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		convertView=mInflater.inflate(R.layout.contact_list_item, null);
		TextView section=(TextView) convertView.findViewById(R.id.sectionName);
		section.setVisibility(View.VISIBLE);
		ImageView img=(ImageView) convertView.findViewById(R.id.ContactImage);
		TextView name=(TextView) convertView.findViewById(R.id.ContactName);
		name.setText(contact_list.get(position).getName());
		
		ch=contact_list.get(position).getName().substring(0,1);
		System.out.println("hash map value"+occurance.get(ch));
		if(position==occurance.get(ch))
		{
		section.setVisibility(View.VISIBLE);
		section.setText(ch.toUpperCase());
		}
		else
		{
			section.setVisibility(View.GONE);
		}
		
		if(contact_list.get(position).getImage_id() == 0)
		{
		img.setImageResource(R.drawable.ic_launcher);	
		}
		else
		{
			Uri contact_uri=ContentUris.withAppendedId (
		            ContactsContract.Contacts.CONTENT_URI,contact_list.get(position).getId());
			Uri photo_uri=Uri.withAppendedPath(contact_uri,Contacts.Photo.CONTENT_DIRECTORY);
			img.setImageURI(photo_uri);
		}
		count++;
		
		return convertView;
	}

}
