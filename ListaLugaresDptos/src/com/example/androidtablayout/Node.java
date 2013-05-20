package com.example.androidtablayout;
//definimos una estructura para guardar los datos
public class Node {

		protected int d_id;
		protected String d_nomreg;
		protected String d_nomdep;
		protected String d_nomcap;
		protected String d_desc;
		protected String d_rutaima;
		
		public Node() {
		    this.d_id = 0;
		    this.d_nomreg = "";
		    this.d_nomdep = "";
		    this.d_nomcap = "";
		    this.d_desc = "";
		    this.d_rutaima = "";		   
		 }
		
				
		public long getId() {
			return d_id;
		}
		
		public void setId(int id) {
			this.d_id = id;
		}
		
		public String getRutaImagen() {
			return d_rutaima;
		}
				
		public void setRutaImagen(String rutaImagen) {
			this.d_rutaima = rutaImagen;
		}
		
		public String getNombreRegion() {
			return d_nomreg;
		}
		
		public void setNombreRegion(String nombre) {
			this.d_nomreg = nombre;
		}
		
		public String getNombreDpto() {
			return d_nomdep;
		}
		
		public void setNombreDpto(String nombre) {
			this.d_nomdep = nombre;
		}
		public String getDescripcion() {
			return d_desc;
		}
		
		public void setDescripcion(String des) {
			this.d_desc = des;
		}
		
		public String getNombreCapital() {
			return d_nomcap;
		}
		
		public void setNombreCapital(String nombre) {
			this.d_nomcap = nombre;
		}
		
		
}
