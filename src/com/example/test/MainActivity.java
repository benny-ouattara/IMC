package com.example.test;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
	
	Button envoyer = null;
	Button raz = null;
	EditText taille = null;
	EditText poids = null;
	RadioGroup group = null;
	TextView result = null;
	CheckBox mega = null;
	
	String defaut = "You must click on the IMC button";
	String megastring = "You have a perfect weight";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		envoyer = (Button) findViewById(R.id.calcul);
		raz = (Button) findViewById(R.id.raz);
		taille = (EditText) findViewById(R.id.taille);
		poids = (EditText) findViewById(R.id.poids);
		group = (RadioGroup) findViewById(R.id.group1);
		result = (TextView) findViewById(R.id.result);
		
		// set listeners
		envoyer.setOnClickListener(envoyerListener);
		raz.setOnClickListener(razListener);
		taille.addTextChangedListener(textwatcher);
		poids.addTextChangedListener(textwatcher);
		//mega.setOnClickListener(checkedListener);

		
	}

	
	private TextWatcher textwatcher = new TextWatcher() {

		@Override
		public void afterTextChanged(Editable arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
				int arg3) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence arg0, int arg1, int arg2,
				int arg3) {
			// TODO Auto-generated method stub
			result.setText(defaut);
		}
		
		
	};

	private OnClickListener envoyerListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			String t = taille.getText().toString();
			String p = poids.getText().toString();
			
			float pval = 0;
			float tval = 0;
			try{
				pval = Float.parseFloat(p);
				tval = Float.parseFloat(t);
				
			}catch(NumberFormatException e){
				e.printStackTrace();
			}
			if(group.getCheckedRadioButtonId() == R.id.radio2){
				tval = tval/100;
			}
			tval = (float) Math.pow(tval, 2);
			float imc = pval/tval;
			result.setText(Float.toString(imc));
			
		}
	};
	
	private OnClickListener razListener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			poids.getText().clear();
			taille.getText().clear();
			result.setText(defaut);
		}
		
		
	};
	
	/*private OnClickListener checkedListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			CheckBox cbox = (CheckBox) v;
			
			if(!cbox.isChecked() && result.getText().equals(megastring))
				result.setText(defaut);
			
		}
		
		
	};*/

}
