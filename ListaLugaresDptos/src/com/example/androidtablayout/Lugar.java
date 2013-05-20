package com.example.androidtablayout;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Lugar extends ListActivity {

	public String iden;
	public String nom_dpto;
	public String nom_reg;
	private MiAdaptador adaptador =null;
	
	 public static ArrayList<NodoLugar> miarraylugar = new ArrayList<NodoLugar>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.general_layout);
        
         Bundle bundle = getIntent().getExtras();
        
         iden =bundle.getString("ID");
         nom_reg = bundle.getString("REGION");
         nom_dpto = bundle.getString("DPTO");
         System.out.println(iden +" "+nom_dpto);
         setLugar(iden);
         adaptador =new MiAdaptador(this);
 		setListAdapter(adaptador);
                
    }
    
   	
	public static class MiAdaptador extends BaseAdapter	{
		public Context micontexto;
		public MiAdaptador(Context c){
			micontexto = c;
		}
		
		/*devuelve num max*/
		public int getCount() {
			return miarraylugar.size();
		}

		public Object getItem(int posicion) {
			return miarraylugar.get(posicion);
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
			
			NodoLugar nod1 = miarraylugar.get(posicion);
			
			ImageView img = (ImageView) view.findViewById(R.id.imagen);
			img.setImageDrawable(micontexto.getResources().getDrawable(R.drawable.costa_l));
									
			TextView ttitulo =(TextView) view.findViewById(R.id.titulo);
			//ttitulo.setText("id: "+nod1.l_id + " - "+ nod1.l_nombre);
			ttitulo.setText(nod1.l_nombre);
			
			TextView descr =(TextView) view.findViewById(R.id.des);
			descr.setText(nod1.l_desc);
			
					
			return view;
		}	
	}
    
    public void setLugar(String val)
	{
		miarraylugar.clear();
		LugarOpenHelper poh=new LugarOpenHelper(getApplicationContext());
		SQLiteDatabase db= poh.getReadableDatabase();
		Cursor c =db.rawQuery("SELECT * FROM " + poh.TABLE_NAME2 + " WHERE "+poh.IDDPTO + " = " +val ,null);
		//Cursor c =getDptos("Selva");
		
		if (c.moveToFirst()) {
		     //Recorremos el cursor hasta que no haya más registros
			     do {
			    	 	NodoLugar nodolug = new NodoLugar();
			    	 	nodolug.l_id = Integer.parseInt(c.getString(0));
			    	 	nodolug.l_iddpto = c.getString(1);
						nodolug.l_nombre = c.getString(2);
						nodolug.l_desc = c.getString(3);
						miarraylugar.add(nodolug);			    	 
			     } while(c.moveToNext());
			}
		//db.close();
	}
}