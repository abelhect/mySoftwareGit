/*
 * Copyright (C) 2013 Code Here Now - A subsidiary of Mobs & Geeks
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file 
 * except in compliance with the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the 
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language governing permissions and 
 * limitations under the License.
 */
package com.codeherenow.sicalculator;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SICalculatorActivity extends Activity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener{

	private EditText principalAmountView = null;
	String principalValueString = null;
	int principalValueInteger = 0;
	private EditText interestView = null;
	String interestValueString = null;
	double interestValueDouble = 0;
	private TextView yearsView = null;
	String yearsString = null;
	int yearsInteger = 0;
	private double calculation = 0;
	String calculationString = null;
	private TextView summaryView = null;
	String summaryViewString = null;
	private Button calculateButton = null;
	private SeekBar seekBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sicalculator);

		principalAmountView = (EditText) findViewById(R.id.principal_amount_id);
		interestView = (EditText) findViewById(R.id.interest_rate_id);
		yearsView = (TextView) findViewById(R.id.number_years_id);
		seekBar = (SeekBar) findViewById(R.id.seekBar_id);

		summaryView = (TextView) findViewById(R.id.summary_id);
		calculateButton = (Button) findViewById(R.id.calculate_button_id);
		calculateButton.setOnClickListener(this);

		yearsView.setText(seekBar.getProgress()+"");
		seekBar.setOnSeekBarChangeListener(this);
	}

	@Override
	public void onClick(View v) {
		//getting the string from the view for use in the summary
		principalValueString = principalAmountView.getText().toString();
		interestValueString = interestView.getText().toString();
		yearsString = yearsView.getText().toString();

		try {
			principalValueInteger = Integer.parseInt(principalValueString);
			interestValueDouble = Double.parseDouble(interestValueString);
		} catch (NumberFormatException e){
			System.out.println(e.getMessage());
			Toast.makeText(this, "Please insert values other than empty space or zero and try again",Toast.LENGTH_LONG).show();
		}

		calculationString= String.format("%.2f", interestCalculation(principalValueInteger, interestValueDouble, yearsInteger));

		if (principalValueString.equals("") || interestValueString.equals("")){
			summaryView.setText("");
		} else {
			summaryView.setText("The interest for $"+ principalValueString +" at a rate of "
					+interestValueString+"% for "+yearsString+" year(s) is $"+calculationString+".");
		}
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		yearsInteger = progress;
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {

	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		yearsView.setText(yearsInteger+"");
	}

	public double interestCalculation (int principalAmount, double interest, int years) {
		calculation = (principalAmount * (interest/100) * years);
		return calculation;
	}

}
