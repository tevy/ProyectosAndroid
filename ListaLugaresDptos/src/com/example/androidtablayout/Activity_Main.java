package com.example.androidtablayout;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class Activity_Main extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TabHost tabHost = getTabHost();
        
     // Tab para Menu
        TabSpec menu = tabHost.newTabSpec("Menu");
        menu.setIndicator("Menu", getResources().getDrawable(R.drawable.icon_menu_tab));
        Intent menuIntent = new Intent(this, Menu.class);
        menu.setContent(menuIntent);
        
        // Tab para R Costa
        TabSpec costa = tabHost.newTabSpec("Costa");
        costa.setIndicator("Costa", getResources().getDrawable(R.drawable.icon_costa_tab));
        Intent costaIntent = new Intent(this, Costa.class);
        costa.setContent(costaIntent);
        
        // Tab para R Sierra
        TabSpec sierra = tabHost.newTabSpec("Sierra");
        sierra.setIndicator("Sierra", getResources().getDrawable(R.drawable.icon_sierra_tab));
        Intent sierraIntent = new Intent(this, Sierra.class);
        sierra.setContent(sierraIntent);
        
        // Tab para R Selva
        TabSpec selva = tabHost.newTabSpec("Selva");
        selva.setIndicator("Selva", getResources().getDrawable(R.drawable.icon_selva_tab));
        Intent selvaIntent = new Intent(this, Selva.class);
        selva.setContent(selvaIntent);
        
        // Adcionando todos los TabSpec a TabHost
        tabHost.addTab(menu); 
        tabHost.addTab(costa); 
        tabHost.addTab(sierra);
        tabHost.addTab(selva); 
    }
}