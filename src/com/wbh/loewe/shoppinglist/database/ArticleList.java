package com.wbh.loewe.shoppinglist.database;


public class ArticleList extends DatatableList {
	
	@Override
    protected void fillData() {
		tablename = ShoppingListDatabase.TABLE_NAME_ARTICLE;
		super.fillData();
  	}
}