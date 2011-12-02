package com.wbh.loewe.shoppinglist.dbtest;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;

public class ArticleListItem extends TableRow implements OnClickListener {

	private Context mContext;
	private String mName;
	private boolean mSelected;
	private TextView mTextView;
		
	public ArticleListItem(Context context) {
		super(context);
		
		this.mContext = context;
			
	    setClickable(true);
	    setOnClickListener(this);
	}

	public void setName(String aName) {
		
		this.mName = aName;
	}
	
	public void setSelected(boolean aSelected) {
		
		this.mSelected = aSelected;
	}
	
	public void create() {
	
		removeAllViews();
		addViews();
	}
	
	private void addViews() {
		
		mTextView = new TextView(mContext);
	    
		textView.setText(name);
		textView.setId(1000000 + getId());
		textView.setTextColor(Color.BLACK);
		textView.setTextSize(26);
		
		if(textView.getText().length() >= 19) {
			textView.setTextSize(22);
		}
		
		if(textView.getText().length() >= 23) {
			textView.setTextSize(19);
		}
		
		addView(textView);
	    
	    if(active) {
	    
	    	textView.setPaintFlags(textView.getPaintFlags() | Paint.FAKE_BOLD_TEXT_FLAG);
	    } else {
	    	
	    	textView.setTextColor(Color.GRAY);
	    	textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
	    	
	    	Button removeButton = new Button(context);
	    	removeButton.setText(" ");
	    	removeButton.setTextSize(8);
	    	removeButton.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.ic_delete));
	    	removeButton.setPaintFlags(removeButton.getPaintFlags() | Paint.FAKE_BOLD_TEXT_FLAG);
	    	removeButton.setGravity(FOCUS_RIGHT);
	    	
	    	removeButton.setOnClickListener(this);
			
			addView(removeButton);
	    }
	}

	@Override
	public void onClick(View v) {
		
		if(v.getClass() == Button.class) {
			
			showRemoveDialog();
		} else {
		
			removeAllViews();
			
			if(active) {
				db.execSQL("UPDATE items SET active = 0 WHERE id = '" + getId() + "';");
				active = false;
				addViews();
			} else {
				db.execSQL("UPDATE items SET active = 1 WHERE id = '" + getId() + "';");
				active = true;
				addViews();
			}
		}
	}
	
	private void showRemoveDialog() {
		
		AlertDialog.Builder b = new AlertDialog.Builder(context);
		b.setPositiveButton(((SimpleShoppingListExtActivity) context).getText(R.string.button_ok), new AlertDialog.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				db.execSQL("DELETE FROM items WHERE id = '" + getId() + "';");
				((SimpleShoppingListExtActivity) context).updateList();
				dialog.cancel();
			}
		});
		b.setNegativeButton(((SimpleShoppingListExtActivity) context).getText(R.string.button_cancel), new AlertDialog.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				dialog.cancel();
			}
		});
		
		AlertDialog d = b.create();
		d.setTitle(((SimpleShoppingListExtActivity) context).getText(R.string.dialog_remove_title));
		d.setMessage(((SimpleShoppingListExtActivity) context).getText(R.string.dialog_remove_message));
		
		d.show();
	}

	@Override
	public boolean onLongClick(View v) {
		
		if(v.getClass() == getClass()) {
			
			showRemoveDialog();
			
			Vibrator vr = (Vibrator) ((SimpleShoppingListExtActivity) context).getSystemService(Context.VIBRATOR_SERVICE);
			vr.vibrate(30);
		}
		return true;
	}
}
