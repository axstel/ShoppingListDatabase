package com.wbh.loewe.shoppinglist.dbtest;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.wbh.loewe.shoppinglist.database.ShoppingListDatabase;

public class AddArticleDlg extends Dialog {

	/* http://about-android.blogspot.com/2010/02/create-custom-dialog.html */
	/* http://androidcookbook.com/Recipe.seam;jsessionid=40151FCD26222877E151C3EEFB406EED?recipeId=1728&recipeFrom=ViewTOC */
	
	public interface ReadyListener {
        public void ready(int aState, ContentValues aValue);
    }
	
	private ReadyListener mReadyListener;
	private int mID;
	private String mName;
	private String mCategory;
	private String mQuantityUnit;
	private EditText edt_Name;
	private EditText edt_Category;
	private EditText edt_QuantityUnit;
	
    public AddArticleDlg(Context context, int aID, String aName, String aCategory, String aQuantityUnit, ReadyListener aReadyListener) {
        super(context);
        this.mReadyListener = aReadyListener;
        this.mID = aID;
        this.mName = aName; 
        this.mCategory = aCategory;
        this.mQuantityUnit = aQuantityUnit;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addarticle_dlg);
        setTitle("Artikel");
        
        Button btn;
        btn = (Button) findViewById(R.id.btn_addarticle_dlg_ok);
        btn.setOnClickListener(new btn_ok_click());
        btn = (Button) findViewById(R.id.btn_addarticle_dlg_cancel);
        btn.setOnClickListener(new btn_cancel_click());
        
        edt_Name = (EditText)findViewById(R.id.edt_addarticle_dlg_name);
        edt_Name.setText(this.mName);
        edt_Category = (EditText)findViewById(R.id.edt_addarticle_dlg_category);
        edt_Category.setText(this.mCategory);
        edt_QuantityUnit = (EditText)findViewById(R.id.edt_addarticle_dlg_quantityunit);
        edt_QuantityUnit.setText(this.mQuantityUnit);
    }

    private class btn_ok_click implements android.view.View.OnClickListener {
        public void onClick(View v) {
        	ContentValues values = new ContentValues();
    		values.put(ShoppingListDatabase.FIELD_NAME_NAME, String.valueOf(edt_Name.getText()));
    		values.put(ShoppingListDatabase.FIELD_NAME_IDCATEGORY, String.valueOf(edt_Category.getText()));
    		values.put(ShoppingListDatabase.FIELD_NAME_IDQUANTITYUNIT, String.valueOf(edt_QuantityUnit.getText()));   		
        	
        	mReadyListener.ready(0, values);
        	AddArticleDlg.this.dismiss();
        }
    }
    
    private class btn_cancel_click implements android.view.View.OnClickListener {
        public void onClick(View v) {
        	mReadyListener.ready(1, null);
        	AddArticleDlg.this.cancel();
        }
    }
}
