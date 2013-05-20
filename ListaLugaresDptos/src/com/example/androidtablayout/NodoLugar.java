package com.example.androidtablayout;

public class NodoLugar {
	
		public int l_id;
		public String l_iddpto;
		public String l_nombre;
		public String l_desc;
		
		public NodoLugar(){
			this.l_id = 0;
			this.l_iddpto = "ninguno";
			this.l_nombre = "ninguno";
			this.l_desc = "ninguno";
		}

		public NodoLugar(int l_id, String l_iddpto, String l_nombre, String l_desc){
			this.l_id = l_id;
			this.l_iddpto = l_iddpto;
			this.l_nombre = l_nombre;
			this.l_desc = l_desc;
		}
		
}
