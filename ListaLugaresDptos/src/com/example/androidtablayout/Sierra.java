package com.example.androidtablayout;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class Sierra extends Region {
       	
    	@Override
    	protected void onCreate(Bundle savedInstanceState) {
    		super.onCreate(savedInstanceState);
    		miarray.clear();
    		setDatos("Sierra");
    		
    		adaptador =new MiAdaptador(this);
    		setListAdapter(adaptador);    
    
    }
    	
    	protected void onListItemClick(ListView l, View v, int posicion, long id)
    	{
    		
            		Intent intent = new Intent(Sierra.this, Lugar.class);
            		 
                    Bundle bundle = new Bundle();
                    bundle.putString("ID"," "+miarray.get(posicion).d_id);
                    bundle.putString("REGION"," "+miarray.get(posicion).d_nomreg);
                    bundle.putString("DPTO"," "+miarray.get(posicion).d_nomdep);
                    intent.putExtras(bundle);
             
                    startActivity(intent);
            	}
          
}