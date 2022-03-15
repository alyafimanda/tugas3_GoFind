package com.example.gofind;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class hospital extends ListActivity {
  protected void onCreate (Bundle icicle) {
    super.onCreate(icicle);
    String[] listHospital = new String[] {"RS Awal Bros", "RSUD Arifin Achmad", "RS Eka Hospital", "RS Ibnu Sina"};
    this.setListAdapter(new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1,listHospital));
}

  protected void onListItemClick (ListView l, View v, int position, long id){
    super.onListItemClick(l, v, position, id);
    Object o = this.getListAdapter().getItem(position);
    String pilih = o.toString();
    tampilkan(pilih);
  }
  private void tampilkan(String pilih){
    try{
        Intent i = null;
        if (pilih.equals("RS Awal Bros")){
            i = new Intent(this, RSAwalBros.class);
        } else if (pilih.equals("RSUD Arifin Achmad")){

        }
        startActivity(i);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
