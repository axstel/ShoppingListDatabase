package com.wbh.loewe.shoppinglist.database;


public class QuantityunitList extends DatatableList {
	
	@Override
    protected void fillData() {
		tablename = ShoppingListDatabase.TABLE_NAME_QUANTITYUNIT;
		super.fillData();
  	}
}
