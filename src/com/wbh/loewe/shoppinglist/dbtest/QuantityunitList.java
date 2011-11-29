package com.wbh.loewe.shoppinglist.dbtest;

import com.wbh.loewe.shoppinglist.database.ShoppingListDatabase;


public class QuantityunitList extends DatatableList {
	
	@Override
    protected void fillData() {
		tablename = ShoppingListDatabase.TABLE_NAME_QUANTITYUNIT;
		super.fillData();
  	}
}
