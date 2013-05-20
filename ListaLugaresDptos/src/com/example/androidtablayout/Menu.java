package com.example.androidtablayout;

import java.util.ArrayList;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class Menu extends Activity {
	
	 SQLiteDatabase mydb;
	 Spinner My_spinner;
	 public String id_spinner;
	 public String name_spinner;
	 public String select;
	 int values;
	
	 private EditText txtlugar;
	 private EditText txtdesc;
	 private EditText txtID;
		
	 private Button btnInsertar;
	 private Button btnBuscar;
	 private Button btnEditar;
	 private Button btnEliminar;
	 private SQLiteDatabase db;
	 
	@Override
	public void onCreate (Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		
		//Obtenemos las referencias a los controles
		
		txtlugar = (EditText)findViewById(R.id.etlugar);
		txtdesc = (EditText)findViewById(R.id.etdesc);
		txtID = (EditText)findViewById(R.id.etBuscar);
		
		btnInsertar = (Button)findViewById(R.id.btnAgregar);
		btnBuscar  = (Button)findViewById(R.id.btBuscar);
		btnEditar = (Button)findViewById(R.id.btEditar);
		btnEliminar = (Button)findViewById(R.id.btEliminar);
		
		
		
				 
		        ArrayList<String> my_array = new ArrayList<String>();
		        my_array = getTableValues();
		 
		        My_spinner = (Spinner) findViewById(R.id.spinner1);
		        ArrayAdapter my_Adapter = new ArrayAdapter(this, R.layout.spinner_row,
		                my_array);
		        My_spinner.setAdapter(my_Adapter);
		        My_spinner.setOnItemSelectedListener(new SpinnerListener());
		       // My_spinner.s
		        
		     //  select = My_spinner.getSelectedItem().toString();
		       
		       // Log.d("ttt",select);
		        
		     
		        btnInsertar.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						LugarOpenHelper poh=new LugarOpenHelper(getApplicationContext());
						db= poh.getReadableDatabase();
						//Recuperamos los valores de los campos de texto
						
						String lug = txtlugar.getText().toString();
						String dss = txtdesc.getText().toString();
						
						ContentValues nuevoRegistro = new ContentValues();
						nuevoRegistro.put(poh.IDDPTO, String.valueOf(values));
						nuevoRegistro.put(poh.NOMLUG, lug);
						nuevoRegistro.put(poh.DESCLUG, dss);
						db.insert(poh.TABLE_NAME2, null, nuevoRegistro);
						db.close();
						//System.out.println("ddd" + String.valueOf(values)+ lug + dss);
						Toast.makeText(getApplicationContext(),"Se inserto "+lug + " "+dss, Toast.LENGTH_SHORT).show();
												
						
					}
				});
				
				btnBuscar.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						
						int id1 =Integer.parseInt(txtID.getText().toString());
						String rnam = getLugar(id1);
						String reda = getDesc(id1);
						if(getLugar(id1)!=null && getDesc(id1)!=null){
						txtlugar.setText(rnam);
						txtdesc.setText(reda);
						}
						else{
							txtlugar.setText("");
							txtdesc.setText("");
							txtID.setText("");
						}
							
					}
				});
				
				btnEditar.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						
						LugarOpenHelper poh=new LugarOpenHelper(getApplicationContext());
						db= poh.getReadableDatabase();
						
						String lug = txtlugar.getText().toString();
						String dess = txtdesc.getText().toString();
						int cod = Integer.parseInt(txtID.getText().toString());
						
						ContentValues nuevoRegistro = new ContentValues();
						nuevoRegistro.put(poh.NOMLUG, lug);
						nuevoRegistro.put(poh.DESCLUG, dess);
						db.update(poh.TABLE_NAME2, nuevoRegistro, poh.IDL+" =" + cod, null);
						db.close();
						txtlugar.setText("");
						txtdesc.setText("");
						txtID.setText("");
						Toast.makeText(getApplicationContext(),"Se edito el registro "+cod+" "+lug + " "+dess, Toast.LENGTH_SHORT).show();
						
					}
				});
				
				btnEliminar.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						
						LugarOpenHelper poh=new LugarOpenHelper(getApplicationContext());
						db= poh.getReadableDatabase();
						
						int cod = Integer.parseInt(txtID.getText().toString());
						db.delete(poh.TABLE_NAME2,poh.IDL+" =" + cod, null);
						db.close();
						txtlugar.setText("");
						txtdesc.setText("");
						txtID.setText("");
						Toast.makeText(getApplicationContext(),"Se elimino el registro "+cod, Toast.LENGTH_SHORT).show();
						
					}
				});
		    }
		 
	public class SpinnerListener implements OnItemSelectedListener {

	      public void onItemSelected(AdapterView<?> parent,
	          View view, int pos, long id) {
	          // Lamo a un método para cargar el Spinner de ciudades
	          // pasandole la posicion del elemento seleccionado en
	          // el Spinner de paises
	    	  values = parent.getSelectedItemPosition();
	          //System.out.println(" "+values);
	      }
	      public void onNothingSelected(AdapterView<?> parent) {
	        // Do nothing.
	      }
	  } 
	
	public String getLugar(int id){
		try{
		LugarOpenHelper poh=new LugarOpenHelper(getApplicationContext());
		Cursor c= poh.getReadableDatabase().
					rawQuery("SELECT "+poh.NOMLUG+" FROM "+poh.TABLE_NAME2+" WHERE "+poh.IDL+" = " +id, null);
						
					if(c != null){
						c.moveToFirst();
						String nb = c.getString(0);
						//c.close();
						return nb;
					}
				
			return null;
		}
		catch(Exception e){
			return null;
		}
	}
	

	public String getDesc(int id){
		try{
		LugarOpenHelper poh=new LugarOpenHelper(getApplicationContext());
		Cursor c= poh.getReadableDatabase().
				rawQuery("SELECT "+poh.DESCLUG+" FROM "+poh.TABLE_NAME2+" WHERE "+poh.IDL+" = " +id, null);
					
				if(c != null){
					c.moveToFirst();
					String nb = c.getString(0);
					//c.close();
					return nb;
				}
		//c.close();		
	    return null;
		}catch(Exception e){
			return null;
		}
	}    
		    
		 
		    // THIS FUNCTION SHOWS DATA FROM THE DATABASE
		    public ArrayList<String> getTableValues() {
		 
		        ArrayList<String> my_array = new ArrayList<String>();
		        try {
		        	LugarOpenHelper poh=new LugarOpenHelper(getApplicationContext());
		        	Cursor allrows = poh.getReadableDatabase().
		    				rawQuery("SELECT _id,nomdep FROM Dpto", null);
		        	
		        	my_array.add("----");
		            
		           // Cursor allrows = mydb.rawQuery("SELECT * FROM Dpto", null);
		            System.out.println("COUNT : " + allrows.getCount());
		 
		            if (allrows.moveToFirst()) {
		                do {
		 
		                     id_spinner = allrows.getString(0);
		                    name_spinner = allrows.getString(1);
		                     my_array.add(name_spinner);
		 
		                } while (allrows.moveToNext());
		            }
		            allrows.close();
		            //allrows.close();
		        } catch (Exception e) {
		            Toast.makeText(getApplicationContext(), "Error encountered.",
		                    Toast.LENGTH_LONG);
		        }
		        return my_array;
		        
		    }
	}


