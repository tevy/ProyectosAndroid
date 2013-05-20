package com.example.androidtablayout;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LugarOpenHelper extends SQLiteOpenHelper {
	

	public static final int DB_VERSION = 1;
	public static final String DB_NAME = "Lugares";
	
	public static final String TABLE_NAME1 = "Dpto";
	public static final String TABLE_NAME2 = "Lugar";
	//public static final String ID = "id";
	
	// campos tabla Dpto
	public static final String ID= "_id";
	public static final String NOMREG = "nomreg";
	public static final String NOMDEP = "nomdep";
	public static final String NOMCAP = "nomcap";
	public static final String DESC = "descrip";
	public static final String RUTIMADPTO= "rutimadpto"; //imagen
	
	// campos tabla Lugar
	    public static final String IDL = "_id";
		public static final String IDDPTO = "iddpto";
		public static final String NOMLUG = "nomlug";
		public static final String DESCLUG = "desclug";
		
	
	public static final String CREATE_DPTO = "CREATE TABLE "+TABLE_NAME1+" ( "+
								ID +" INTEGER PRIMARY KEY AUTOINCREMENT , "+
								NOMREG +"  text not null, "+
								NOMDEP +" text, "+
								NOMCAP +" text, "+
								DESC +" text, "+
								RUTIMADPTO +" text)";
	
	public static final String CREATE_LUG = "CREATE TABLE "+TABLE_NAME2+" ( "+
			IDL +" INTEGER PRIMARY KEY AUTOINCREMENT , "+
			IDDPTO +"  text, "+
			NOMLUG +" text, "+
			DESCLUG +" text, "+
			"FOREIGN KEY( "+ IDDPTO+" ) REFERENCES "+ TABLE_NAME1 + "( "+ID+"))";
	
	//public static final String FOREINGK = "FOREIGN KEY( "+ IDDPTO+" ) REFERENCES "+ TABLE_NAME1 + "( "+ID+")";
	

	
	public static final String INSERT_DPTO1 = "INSERT INTO "+
			TABLE_NAME1 + "(" + NOMREG +"," + NOMDEP+"," + NOMCAP+","+ DESC+"," + RUTIMADPTO+ ") " +
					"VALUES('Costa','Ancash','Huaraz','El territorio cuenta con grandes extensiones de bosques de eucaliptos y pinos y en menor medida como el molle, la tara','drawable/ancash')";
	
	public static final String INSERT_DPTO2 = "INSERT INTO "+
			TABLE_NAME1 + "(" + NOMREG +"," + NOMDEP+"," + NOMCAP+","+ DESC+"," + RUTIMADPTO+ ") " +
					"VALUES('Costa','Arequipa','Arequipa','Su es predominantemente seco en invierno, otoño y primavera debido a la humedad atmosférica','drawable/arequipa')";
	public static final String INSERT_DPTO3 = "INSERT INTO "+
			TABLE_NAME1 + "(" + NOMREG +"," + NOMDEP+"," + NOMCAP+","+ DESC+"," + RUTIMADPTO+ ")" +
					"VALUES('Costa','Ica','Ica','Ica posee un clima cálido desértico de tipo subtropical seco, con una temperatura media de alrededor de 22 °C','drawable/ica')";
	public static final String INSERT_DPTO4 = "INSERT INTO "+
			TABLE_NAME1 + "(" + NOMREG +"," + NOMDEP+"," + NOMCAP+","+ DESC+"," + RUTIMADPTO+ ") " +
					"VALUES('Costa','La Libertad','Trujillo','Su temperatura promedio oscila entre los 20 °C y 21 °C y en verano (enero a marzo) supera los 30 °C.','drawable/lalibertad')";
	public static final String INSERT_DPTO5 = "INSERT INTO "+
			TABLE_NAME1 + "(" + NOMREG +"," + NOMDEP+"," + NOMCAP+","+ DESC+"," + RUTIMADPTO+ ") VALUES('Costa','Lambayeque','Chiclayo','','drawable/lambayeque')";
	public static final String INSERT_DPTO6 = "INSERT INTO "+
			TABLE_NAME1 + "(" + NOMREG +"," + NOMDEP+"," + NOMCAP+","+ DESC+"," + RUTIMADPTO+ ") VALUES('Costa','Lima','Lima','','drawable/lima')";
	public static final String INSERT_DPTO7 = "INSERT INTO "+
			TABLE_NAME1 + "(" + NOMREG +"," + NOMDEP+"," + NOMCAP+","+ DESC+"," + RUTIMADPTO+ ") VALUES('Costa','Moquegua','Moquegua','','drawable/moquegua')";
	public static final String INSERT_DPTO8 = "INSERT INTO "+
			TABLE_NAME1 + "(" + NOMREG +"," + NOMDEP+"," + NOMCAP+","+ DESC+"," + RUTIMADPTO+ ") VALUES('Costa','Piura','Piura','','drawable/piura')";
	public static final String INSERT_DPTO9 = "INSERT INTO "+
			TABLE_NAME1 + "(" + NOMREG +"," + NOMDEP+"," + NOMCAP+","+ DESC+"," + RUTIMADPTO+ ") VALUES('Costa','Tacna','Tacna','','drawable/tacna')";
	public static final String INSERT_DPTO10 = "INSERT INTO "+
			TABLE_NAME1 + "(" + NOMREG +"," + NOMDEP+"," + NOMCAP+","+ DESC+"," + RUTIMADPTO+ ") VALUES('Costa','Tumbes','Tumbes','','drawable/tumbes')";
	public static final String INSERT_DPTO11 = "INSERT INTO "+
			TABLE_NAME1 + "(" + NOMREG +"," + NOMDEP+"," + NOMCAP+","+ DESC+"," + RUTIMADPTO+ ") " +
					"VALUES('Sierra','Apurimac','Abancay','Mayormente templado, con una temperatura promedio de 15 °C en los valles. Muy pocas veces nieva.','drawable/apurimac')";
	public static final String INSERT_DPTO12 = "INSERT INTO "+
			TABLE_NAME1 + "(" + NOMREG +"," + NOMDEP+"," + NOMCAP+","+ DESC+"," + RUTIMADPTO+ ") " +
					"VALUES('Sierra','Ayacucho','Ayacucho','El clima es templado y seco, con una temperatura promedio de 17.5 °C','drawable/ayacucho')";
	public static final String INSERT_DPTO13 = "INSERT INTO "+
			TABLE_NAME1 + "(" + NOMREG +"," + NOMDEP+"," + NOMCAP+","+ DESC+"," + RUTIMADPTO+ ") " +
					"VALUES('Sierra','Cajamarca','Cajamarca','El clima es templado, seco y soleado en el día y frío en la noche.','drawable/cajamarca')";
	public static final String INSERT_DPTO14 = "INSERT INTO "+
			TABLE_NAME1 + "(" + NOMREG +"," + NOMDEP+"," + NOMCAP+","+ DESC+"," + RUTIMADPTO+ ") " +
					"VALUES('Sierra','Cusco','Cusco','Su clima es generalmente seco y templado.','drawable/cusco')";
	public static final String INSERT_DPTO15 = "INSERT INTO "+
			TABLE_NAME1 + "(" + NOMREG +"," + NOMDEP+"," + NOMCAP+","+ DESC+"," + RUTIMADPTO+ ") VALUES('Sierra','Huancavelica','Huancavelica','','drawable/huancavelica')";
	public static final String INSERT_DPTO16 = "INSERT INTO "+
			TABLE_NAME1 + "(" + NOMREG +"," + NOMDEP+"," + NOMCAP+","+ DESC+"," + RUTIMADPTO+ ") VALUES('Sierra','Huanuco','Huanuco','','drawable/huanuco')";
	public static final String INSERT_DPTO17 = "INSERT INTO "+
			TABLE_NAME1 + "(" + NOMREG +"," + NOMDEP+"," + NOMCAP+","+ DESC+"," + RUTIMADPTO+ ") VALUES('Sierra','Junin','Huancayo','','drawable/junin')";
	public static final String INSERT_DPTO18 = "INSERT INTO "+
			TABLE_NAME1 + "(" + NOMREG +"," + NOMDEP+"," + NOMCAP+","+ DESC+"," + RUTIMADPTO+ ") VALUES('Sierra','Pasco','Cerro de Pasco','','drawable/pasco')";
	public static final String INSERT_DPTO19 = "INSERT INTO "+
			TABLE_NAME1 + "(" + NOMREG +"," + NOMDEP+"," + NOMCAP+","+ DESC+"," + RUTIMADPTO+ ") VALUES('Sierra','Puno','Puno','','drawable/puno')";
	public static final String INSERT_DPTO20 = "INSERT INTO "+
			TABLE_NAME1 + "(" + NOMREG +"," + NOMDEP+"," + NOMCAP+","+ DESC+"," + RUTIMADPTO+ ") " +
					"VALUES('Selva','Amazonas','Chachapoyas','El promedio de temperatura es de 25 °C.','drawable/amazonas')";
	public static final String INSERT_DPTO21 = "INSERT INTO "+
			TABLE_NAME1 + "(" + NOMREG +"," + NOMDEP+"," + NOMCAP+","+ DESC+"," + RUTIMADPTO+ ") VALUES('Selva','Loreto','Iquitos','','drawable/loreto')";
	public static final String INSERT_DPTO22 = "INSERT INTO "+
			TABLE_NAME1 + "(" + NOMREG +"," + NOMDEP+"," + NOMCAP+","+ DESC+"," + RUTIMADPTO+ ") VALUES('Selva','Madre de Dios','Pto. Maldonado','','drawable/madre')";
	public static final String INSERT_DPTO23 = "INSERT INTO "+
			TABLE_NAME1 + "(" + NOMREG +"," + NOMDEP+"," + NOMCAP+","+ DESC+"," + RUTIMADPTO+ ") VALUES('Selva','San Martin','Moyobamba','','drawable/sanmartin')";
	public static final String INSERT_DPTO24 = "INSERT INTO "+
			TABLE_NAME1 + "(" + NOMREG +"," + NOMDEP+"," + NOMCAP+","+ DESC+"," + RUTIMADPTO+ ") VALUES('Selva','Ucayali','Pucallpa','','drawable/ucayali')";
	
	public static final String INSERT_LUG1 = "INSERT INTO "+
			TABLE_NAME2 + "(" + IDDPTO +"," + NOMLUG+"," + DESCLUG+ ") " +
					"VALUES('2','Canion del Colca',' Este cañón es originado por la falla de los andes y el río colca llegando a una profundidad de 3400 metros')";
	public static final String INSERT_LUG2 = "INSERT INTO "+
			TABLE_NAME2 + "(" + IDDPTO +"," + NOMLUG+"," + DESCLUG+ ") " +
					"VALUES('2','Iglesia de la Companía','fue construida en el año 1698, se puede encontrar estructuras hechas con sillar de los volcanes.')";
	
	public static final String DROP_DB = "DROP DATABASE "+DB_NAME;
	
	//constructor con parametro contexto
	public LugarOpenHelper(Context ctx)
	{
		//super(contexto, nombre de la BD, parametro nulo, version de la BD)
		super(ctx,DB_NAME,null,DB_VERSION);
	}
	
	//metodo donde se va acrear una BD
	@Override
	public void onCreate(SQLiteDatabase db) //param una BD
	{
	
		// exec hace que se ejecuta un query
		/*String query = "CREATE TABLE People ("+_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ "Name text, Age int);";
		  db.execSQL(query); */
		db.execSQL(CREATE_DPTO); // cuando se ejecuta se creara un tabla nueva de bd
		db.execSQL(CREATE_LUG); // cuando se ejecuta se creara un tabla nueva de bd

		//DPTOS
		db.execSQL(INSERT_DPTO1);
		db.execSQL(INSERT_DPTO2);
		db.execSQL(INSERT_DPTO3);
		db.execSQL(INSERT_DPTO4);
		db.execSQL(INSERT_DPTO5);
		db.execSQL(INSERT_DPTO6);
		db.execSQL(INSERT_DPTO7);
		db.execSQL(INSERT_DPTO8);
		db.execSQL(INSERT_DPTO9);
		db.execSQL(INSERT_DPTO10);
		db.execSQL(INSERT_DPTO11);
		db.execSQL(INSERT_DPTO12);
		db.execSQL(INSERT_DPTO13);
		db.execSQL(INSERT_DPTO14);
		db.execSQL(INSERT_DPTO15);
		db.execSQL(INSERT_DPTO16);
		db.execSQL(INSERT_DPTO17);
		db.execSQL(INSERT_DPTO18);
		db.execSQL(INSERT_DPTO19);
		db.execSQL(INSERT_DPTO20);
		db.execSQL(INSERT_DPTO21);
		db.execSQL(INSERT_DPTO22);
		db.execSQL(INSERT_DPTO23);
		db.execSQL(INSERT_DPTO24);
	
		//LUGARES
		db.execSQL(INSERT_LUG1);
		db.execSQL(INSERT_LUG2);
				
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db,int version_ant, int version_nue)
	{
		//al destruir el contenido tenemos que llamar al metodo onCretae para que se vuelva crear todo
		db.execSQL(DROP_DB);
		onCreate(db);
		
	}
	
	
}

