package abpl.android.com.abpl.utils.device;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class FontTypeFace {
	
	public  void setTypeFace(Context context, View... view) {
		Typeface tf = Typeface.createFromAsset(context.getAssets(), "Roboto-Light.ttf");
		for (View v : view) {
			if(v instanceof TextView) {
				((TextView)v).setTypeface(tf);
			} else if(v instanceof EditText) {
				((EditText)v).setTypeface(tf);
			} else if(v instanceof Button) {
				((Button)v).setTypeface(tf);
			} else if(v instanceof CheckBox) {
				((CheckBox)v).setTypeface(tf);
			} else if(v instanceof RadioButton) {
				((RadioButton)v).setTypeface(tf);
			}
		}
	}
	public  void setTypeFaceMedium(Context context, View... view) {
		Typeface tf = Typeface.createFromAsset(context.getAssets(), "Roboto-Medium.ttf");
		for (View v : view) {
			if(v instanceof TextView) {
				((TextView)v).setTypeface(tf, Typeface.BOLD);
			} else if(v instanceof EditText) {
				((EditText)v).setTypeface(tf, Typeface.BOLD);
			} else if(v instanceof Button) {
				((Button)v).setTypeface(tf, Typeface.BOLD);
			} else if(v instanceof CheckBox) {
				((CheckBox)v).setTypeface(tf, Typeface.BOLD);
			} else if(v instanceof RadioButton) {
				((RadioButton)v).setTypeface(tf, Typeface.BOLD);
			}
		}
	}
	public  void setTypeFaceCocacola(Context context, View... view) {
		Typeface tf = Typeface.createFromAsset(context.getAssets(), "cocacola.ttf");
		for (View v : view) {
			if(v instanceof TextView) {
				((TextView)v).setTypeface(tf, Typeface.BOLD);
			} else if(v instanceof EditText) {
				((EditText)v).setTypeface(tf, Typeface.BOLD);
			} else if(v instanceof Button) {
				((Button)v).setTypeface(tf, Typeface.BOLD);
			} else if(v instanceof CheckBox) {
				((CheckBox)v).setTypeface(tf, Typeface.BOLD);
			} else if(v instanceof RadioButton) {
				((RadioButton)v).setTypeface(tf, Typeface.BOLD);
			}
		}
	}
	public  void setTypeFacethinline(Context context, View... view) {
		Typeface tf = Typeface.createFromAsset(context.getAssets(), "Thin_Line_Font.otf");
		for (View v : view) {
			if(v instanceof TextView) {
				((TextView)v).setTypeface(tf);
			} else if(v instanceof EditText) {
				((EditText)v).setTypeface(tf);
			} else if(v instanceof Button) {
				((Button)v).setTypeface(tf);
			} else if(v instanceof CheckBox) {
				((CheckBox)v).setTypeface(tf);
			} else if(v instanceof RadioButton) {
				((RadioButton)v).setTypeface(tf);
			}
		}
	}
}
