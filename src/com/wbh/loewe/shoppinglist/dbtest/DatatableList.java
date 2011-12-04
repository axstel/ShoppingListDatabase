package com.wbh.loewe.shoppinglist.dbtest;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.wbh.loewe.shoppinglist.database.ShoppingListDatabase;

public class DatatableList extends ListActivity {

	private Cursor cursor;
	protected ShoppingListDatabaseApplication shoppinglistapp;
	protected String tablename;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datatable_list);
        
        shoppinglistapp = (ShoppingListDatabaseApplication)getApplication();
        
        fillData();
		
        /* Assign Clickmethods */
		Button btn;
		
		btn= (Button)findViewById(R.id.btn_finish);
		btn.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				finish();
			}
		});
		
		btn = (Button)findViewById(R.id.btn_additem);
		btn.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				showAddItemDialog();
			}
		});
    }
    
    @Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		// Get the item that was clicked
		SimpleCursorAdapter adapt;
		adapt = (SimpleCursorAdapter)getListAdapter();
		Toast.makeText(this, adapt.getCursor().toString(), Toast.LENGTH_LONG).show();		
	}
    
    protected void fillData() {
    	cursor = shoppinglistapp.getDBAdapter().fetchAllDataSets(tablename);
 		startManagingCursor(cursor);

 	    String[] from = new String[] { ShoppingListDatabase.FIELD_NAME_ID, ShoppingListDatabase.FIELD_NAME_NAME };
 		int[] to = new int[] { R.id.labelid, R.id.labelname };

 		// Now create an array adapter and set it to display using our row
 		ListCursorAdapter datasets = new ListCursorAdapter(this, R.layout.list_row, cursor, from, to);
 		setListAdapter(datasets);
 	}
    
    protected void showAddItemDialog() {
    }
}
