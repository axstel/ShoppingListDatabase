package com.wbh.loewe.shoppinglist.dbtest;

import android.content.ContentValues;
import android.widget.Toast;

import com.wbh.loewe.shoppinglist.database.ShoppingListDatabase;


public class ArticleList extends DatatableList {
	
	@Override
    protected void fillData() {
		tablename = ShoppingListDatabase.TABLE_NAME_ARTICLE;
		super.fillData();
  	}
	
	@Override
	protected void showAddItemDialog() {
		
		AddArticleDlg lDialog = new AddArticleDlg(this, 0, "Test", "1", "1", new OnReadyListener());
		lDialog.show();
    }
	
	private class OnReadyListener implements AddArticleDlg.ReadyListener {
        public void ready(int aState, ContentValues aValues) {
        	/* Only if clicked OK */
        	if (aState == 0) {
        		Toast.makeText(ArticleList.this, String.valueOf(aValues.get(ShoppingListDatabase.FIELD_NAME_NAME)), Toast.LENGTH_LONG).show();
        		shoppinglistapp.getDBAdapter().createArticle(aValues);
        		fillData();
        	}
        }
    }
}