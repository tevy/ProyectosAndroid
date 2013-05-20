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

public class Region extends ListActivity {
	
	public MiAdaptador adaptador =null;
	//se creara un arraylist DE TIPO NODO para definir todos los nodos de la Lista
	public static ArrayList<Node> miarray = new ArrayList<Node>();
	
//	@Override
			
	public static class MiAdaptador extends BaseAdapter	{
		public Context micontexto;
		public MiAdaptador(Context c){
			micontexto = c;
		}
		
		/*devuelve num max*/
		public int getCount() {
			return miarray.size();
		}

		public Object getItem(int posicion) {
			return miarray.get(posicion);
		}

		public long getItemId(int arg0) {
			return 0;
		}

		/*devuelve el contenido*/
		public View getView(int posicion, View converView, ViewGroup parent) {
			
			View view =null;
			if (converView == null){
				LayoutInflater inflater = (LayoutInflater) micontexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				view =inflater.inflate(R.layout.general_layout, null);				
			}
			else{
				view = converView;
			}
			
			Node nod1 = miarray.get(posicion);
			
			ImageView img = (ImageView) view.findViewById(R.id.imagen);
			Integer imageResource = micontexto.getResources().getIdentifier(nod1.getRutaImagen(), null, micontexto.getPackageName());
			img.setImageDrawable(micontexto.getResources().getDrawable(imageResource));
			
						
			TextView ttitulo =(TextView) view.findViewById(R.id.titulo);
			ttitulo.setText(nod1.d_nomdep + " - " + nod1.d_nomcap);
			
			TextView descr =(TextView) view.findViewById(R.id.des);
			descr.setText(nod1.d_desc);
			
			if (posicion % 2 == 0){
				view.setBackgroundColor(0x6600ff00);
			}
			else {
				view.setBackgroundColor(0x66ff0000);
			}								
			return view;
		}		
	}
	
	public void setDatos(String region)
	{
		miarray.clear();
		LugarOpenHelper poh=new LugarOpenHelper(getApplicationContext());
		SQLiteDatabase db= poh.getReadableDatabase();
		Cursor c =db.rawQuery("SELECT * FROM " + poh.TABLE_NAME1 + " WHERE "+poh.NOMREG + " = " + "'"+region+"'" ,null);
		//Cursor c =getDptos("Selva");
		
		if (c.moveToFirst()) {
		     //Recorremos el cursor hasta que no haya más registros
			     do {
			    	 	Node minodo = new Node();
			    	 	minodo.d_id = Integer.parseInt(c.getString(0));
			    	 	minodo.d_nomreg = c.getString(1);
						minodo.d_nomdep = c.getString(2);
						minodo.d_nomcap = c.getString(3);
						minodo.d_desc = c.getString(4);
						minodo.d_rutaima = c.getString(5);
						miarray.add(minodo);			    	 
			     } while(c.moveToNext());
			}
		c.close();
	}
		
		
	   
	

}