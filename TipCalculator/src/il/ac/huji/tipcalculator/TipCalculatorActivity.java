package il.ac.huji.tipcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);
		
		final Button calc = (Button) findViewById(R.id.btnCalculate);
		final EditText edtBillAmout = (EditText) findViewById(R.id.edtBillAmount);
		final CheckBox chkRound = (CheckBox) findViewById(R.id.chkRound);
		final TextView txtTipResult = (TextView) findViewById(R.id.txtTipResult);
		calc.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String bill = edtBillAmout.getText().toString();
				float billAmnt = Float.parseFloat(bill);
				float tipAmnt = 0.12f * billAmnt;
				if (chkRound.isChecked())
				{
					tipAmnt = Math.round(tipAmnt);
				}
				
				
				String tipStr = "Tip: $" + String.format("%.2f", tipAmnt);
				txtTipResult.setText(tipStr);
				
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calculator, menu);
		return true;
	}

}
