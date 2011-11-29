package com.wbh.loewe.shoppinglist.dbtest;

import com.wbh.loewe.shoppinglist.database.ShoppingListDatabase;


public class CategoryList extends DatatableList {
	
	@Override
    protected void fillData() {
		tablename = ShoppingListDatabase.TABLE_NAME_CATEGORY;
		super.fillData();
  	}
}