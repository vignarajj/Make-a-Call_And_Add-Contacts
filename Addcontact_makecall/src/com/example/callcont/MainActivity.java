package com.example.callcont;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	Button call,addcontact;
	EditText cal,name,number,email;
	int PICK_CONTACT;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        call=(Button)findViewById(R.id.callbutton);
        addcontact=(Button)findViewById(R.id.contact);
        cal=(EditText)findViewById(R.id.phone);
        name=(EditText)findViewById(R.id.name);
        number=(EditText)findViewById(R.id.number);
        email=(EditText)findViewById(R.id.email);
        call.setOnClickListener(new OnClickListener() 
        {			
			public void onClick(View arg0) 
			{
				// TODO Auto-generated method stub
				if(cal.getText().length()==0)
				{
					Toast.makeText(MainActivity.this, "Enter the Number", Toast.LENGTH_SHORT).show();
				}
				else
				{
					Intent callNumber = new Intent();
				      callNumber.setAction(Intent.ACTION_CALL);
				      callNumber.setData(Uri.parse("tel:"+cal.getText().toString()));
				startActivity(callNumber);
				}
			}
		});
        addcontact.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(name.getText().length()==0||number.getText().length()==0||email.getText().length()==0)
				{
					Toast.makeText(MainActivity.this, "Fill all fields", Toast.LENGTH_SHORT).show();
				}
				else
				{
				Intent contact1=new Intent(Intent.ACTION_INSERT);
				contact1.setType(ContactsContract.Contacts.CONTENT_TYPE);
				contact1.putExtra(ContactsContract.Intents.Insert.NAME,name.getText().toString());
				contact1.putExtra(ContactsContract.Intents.Insert.PHONE,number.getText().toString());
				contact1.putExtra(ContactsContract.Intents.Insert.EMAIL,email.getText().toString());
				startActivityForResult(contact1, PICK_CONTACT);
				name.setText("");
				email.setText("");
				number.setText("");
			}
			}
		});
    }
}