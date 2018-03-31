package com.dragonzmart.democontactlist;

import android.Manifest;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.security.Permission;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String phoneNumber;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<ModelClass> array_list=new ArrayList<>();
        ContentResolver contentresolver=getContentResolver(); 
        Cursor cursor=contentresolver.query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);
        while (cursor.moveToNext())
        {
            String id=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
            name=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            Cursor phoneCursor=contentresolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,ContactsContract.CommonDataKinds.Phone.
                    CONTACT_ID+"=?",new String[] {id},null);

            while (phoneCursor.moveToNext())
            {
                 phoneNumber= phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            }
            array_list.add(new ModelClass(name,phoneNumber));
          }

        for(int i=0;i<=array_list.size()-1;i++)
        {
            System.out.println(array_list.get(i).getName().toString()+" = "+array_list.get(i).getNumber().toString());
            //System.out.println("Size"+array_list.size());
        }
        cursor.close();

    }
}
