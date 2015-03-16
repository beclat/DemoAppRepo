package com.example.demochatapp;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	SimpleCursorAdapter adapter;
	ListView lvContacts;
	ArrayList<Contact> _contactList;
	ContactsAdapter cnt_adpt;
	TextView a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v,
			w, x, y, z;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initialize();
		addListener();
		System.out.println("In on create");
		lvContacts = (ListView) findViewById(R.id.ContactsListView);
		ContentResolver cr = getContentResolver();
		Cursor c = cr.query(ContactsContract.Contacts.CONTENT_URI,
				new String[] { ContactsContract.Contacts._ID,
						ContactsContract.Contacts.DISPLAY_NAME,
						ContactsContract.Contacts.PHOTO_ID }, null, null, null);
		_contactList = new ArrayList<Contact>();
		if (c.moveToFirst()) {
			do {
				long id = c.getLong(c
						.getColumnIndex(ContactsContract.Contacts._ID));
				String name = c
						.getString(c
								.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
				long img_id = c.getLong(c
						.getColumnIndex(ContactsContract.Contacts.PHOTO_ID));
				_contactList.add(new Contact(id, name, img_id));

			} while (c.moveToNext());
		}
		cnt_adpt = new ContactsAdapter(this, _contactList);
		// adapter = new SimpleCursorAdapter(this, R.layout.contact_list_item,
		// c,
		// new String[] { ContactsContract.Contacts.DISPLAY_NAME },
		// new int[] { R.id.ContactName });

		// lvContacts.setAdapter(adapter);
		lvContacts.setAdapter(cnt_adpt);
		lvContacts.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub

				Toast.makeText(getBaseContext(), "item select",
						Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(getBaseContext(),
						ContactDetailsActivity.class);
				intent.putExtra("id", _contactList.get(position).getId());
				intent.putExtra("name", _contactList.get(position).getName());
				intent.putExtra("photo_id", _contactList.get(position)
						.getImage_id());
				startActivity(intent);

			}
		});

		lvContacts.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(getBaseContext(), "item select",
						Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(getBaseContext(),
						ContactDetailsActivity.class);
				intent.putExtra("id", _contactList.get(position).getId());
				intent.putExtra("name", _contactList.get(position).getName());
				intent.putExtra("photo_id", _contactList.get(position)
						.getImage_id());
				startActivity(intent);

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}
		});
	}

	public void initialize()
{
	a=(TextView) findViewById(R.id.A);
	b=(TextView) findViewById(R.id.B);
	c=(TextView) findViewById(R.id.C);
	d=(TextView) findViewById(R.id.D);
	e=(TextView) findViewById(R.id.E);
	f=(TextView) findViewById(R.id.F);
	g=(TextView) findViewById(R.id.G);
	h=(TextView) findViewById(R.id.H);
	i=(TextView) findViewById(R.id.I);
	j=(TextView) findViewById(R.id.J);
	k=(TextView) findViewById(R.id.K);
	l=(TextView) findViewById(R.id.L);
	m=(TextView) findViewById(R.id.M);
	n=(TextView) findViewById(R.id.N);
	o=(TextView) findViewById(R.id.O);
	p=(TextView) findViewById(R.id.P);
	q=(TextView) findViewById(R.id.Q);
	r=(TextView) findViewById(R.id.R);
	s=(TextView) findViewById(R.id.S);
	t=(TextView) findViewById(R.id.T);
	u=(TextView) findViewById(R.id.U);
	v=(TextView) findViewById(R.id.V);
	w=(TextView) findViewById(R.id.W);
	x=(TextView) findViewById(R.id.X);
	y=(TextView) findViewById(R.id.Y);
	z=(TextView) findViewById(R.id.Z);
	
}

	public void addListener() {
		a.setOnClickListener(this);
		b.setOnClickListener(this);
		c.setOnClickListener(this);
		d.setOnClickListener(this);
		e.setOnClickListener(this);
		f.setOnClickListener(this);
		g.setOnClickListener(this);
		h.setOnClickListener(this);
		i.setOnClickListener(this);
		j.setOnClickListener(this);
		k.setOnClickListener(this);
		l.setOnClickListener(this);
		m.setOnClickListener(this);
		n.setOnClickListener(this);
		o.setOnClickListener(this);
		p.setOnClickListener(this);
		q.setOnClickListener(this);
		r.setOnClickListener(this);
		s.setOnClickListener(this);
		t.setOnClickListener(this);
		u.setOnClickListener(this);
		v.setOnClickListener(this);
		w.setOnClickListener(this);
		x.setOnClickListener(this);
		y.setOnClickListener(this);
		z.setOnClickListener(this);
	}

	public void quickScroll(View v) {
		System.out.println("in quick scroll");
		int index = 0;
		String alphabet = (String) v.getTag();
		System.out.println("size is" + _contactList.size());
		if (_contactList != null) {
			System.out.println("in contactlist not null");
			for (Contact c : _contactList) {
				if (c.getName().startsWith(alphabet))
					index = _contactList.indexOf(c);
				System.out.println("index is:" + index);
			}
		}
		index = _contactList.indexOf(alphabet);
		// find the index of the separator row view
		lvContacts.setSelectionFromTop(index, 0);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		System.out.println("in quick scroll");
		int index = 0;
		String alphabet = (String) v.getTag();
		System.out.println("alphabet is" + alphabet);
		if (_contactList != null) {
			System.out.println("in contactlist not null");
			for (Contact c : _contactList) {
				if (c.getName().startsWith(alphabet)
						|| c.getName().startsWith(alphabet.toLowerCase())) {
					index = _contactList.indexOf(c);
					System.out.println("index is:" + index);
					break;
				}

			}
		}

		// find the index of the separator row view
		lvContacts.setSelectionFromTop(index, 0);
	}

}
