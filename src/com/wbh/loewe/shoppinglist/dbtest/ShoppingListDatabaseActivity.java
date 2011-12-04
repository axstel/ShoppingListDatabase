package com.wbh.loewe.shoppinglist.dbtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShoppingListDatabaseActivity extends Activity {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    
        Button btn_tableList;
        
        btn_tableList = (Button) findViewById(R.id.btn_quantityunits);
        btn_tableList.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		Intent intent = new Intent(ShoppingListDatabaseActivity.this, QuantityunitList.class);
        		startActivity(intent);
		}
        });
        
        btn_tableList = (Button) findViewById(R.id.btn_categories);
        btn_tableList.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		Intent intent = new Intent(ShoppingListDatabaseActivity.this, CategoryList.class);
        		startActivity(intent);
		}
        });
        
        btn_tableList = (Button) findViewById(R.id.btn_articles);
        btn_tableList.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
				Intent intent = new Intent(ShoppingListDatabaseActivity.this, ArticleList.class);
				startActivity(intent);
		}
        });
    }
}