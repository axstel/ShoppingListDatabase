package com.wbh.loewe.shoppinglist.dbtest;

import com.wbh.loewe.shoppinglist.database.ShoppingListDatabase;


public class ArticleList extends DatatableList {
	
	@Override
    protected void fillData() {
		tablename = ShoppingListDatabase.TABLE_NAME_ARTICLE;
		super.fillData();
  	}
	
	@Override
	protected void showAddItemDialog() {
		
		AddArticleDlg lDialog = new AddArticleDlg(this, 0, "Test", "Kategorie", "Einheit");
		lDialog.show();
    }
}