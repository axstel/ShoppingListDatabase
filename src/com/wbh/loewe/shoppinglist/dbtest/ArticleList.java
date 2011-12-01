package com.wbh.loewe.shoppinglist.dbtest;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.wbh.loewe.shoppinglist.database.ShoppingListDatabase;


public class ArticleList extends DatatableList {
	
	@Override
    protected void fillData() {
		tablename = ShoppingListDatabase.TABLE_NAME_ARTICLE;
		super.fillData();
  	}
	
	@Override
	protected void showAddItemDialog() {
		
		Context mContext = getApplicationContext();
		LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.addarticle_dlg,
		                               (ViewGroup) findViewById(R.id.layout_root));

		/* Clickhandler */
		Button btn;
		
		btn = (Button)layout.findViewById(R.id.btn_addarticle_dlg_ok);
		btn.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				finish();
			}
		});
		
		btn = (Button)layout.findViewById(R.id.btn_addarticle_dlg_cancel);
		btn.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				finish();
			}
		});
		
		//TextView text = (TextView) layout.findViewById(R.id.text);
		//text.setText("Hello, this is a custom dialog!");
		//ImageView image = (ImageView) layout.findViewById(R.id.image);
		//image.setImageResource(R.drawable.android);

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setView(layout);
		AlertDialog alertDialog = builder.create();
		alertDialog.show();
		
		/*AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Neuen Artikel hinzufügen")
		       .setCancelable(false)
		       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
		                dialog.cancel();
		           }
		       })
		       .setNegativeButton("Abbrechen", new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
		                dialog.cancel();
		           }
		       });
		AlertDialog alert = builder.create();
		*/
    }
}