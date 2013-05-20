package com.example.androidtablayout;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Costa extends Region {
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		miarray.clear();
		setDatos("Costa");
		
		adaptador =new MiAdaptador(this);
		setListAdapter(adaptador);
		        
	}
	
	protected void onListItemClick(ListView l, View v, int posicion, long id)
	{
		
        		Intent intent = new Intent(Costa.this, Lugar.class);
        		 
                Bundle bundle = new Bundle();
                bundle.putString("ID"," "+miarray.get(posicion).d_id);
                bundle.putString("REGION"," "+miarray.get(posicion).d_nomreg);
                bundle.putString("DPTO"," "+miarray.get(posicion).d_nomdep);
                intent.putExtras(bundle);
         
                startActivity(intent);
        	}
      	
	
}
	