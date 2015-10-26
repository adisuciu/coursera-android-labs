package course.labs.intentslab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ExplicitlyLoadedActivity extends Activity {

	static private final String TAG = "Lab-Intents";
	static private final String returnString = "returnString";

	private EditText mEditText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.explicitly_loaded_activity);

		// Get a reference to the EditText field
		mEditText = (EditText) findViewById(R.id.editText);

		// Declare and setup "Enter" button
		Button enterButton = (Button) findViewById(R.id.enter_button);
		enterButton.setOnClickListener(new OnClickListener() {

			// Call enterClicked() when pressed

			@Override
			public void onClick(View v) {

				enterClicked();
			
			}
		});

	}

	// Sets result to send back to calling Activity and finishes
	
	private void enterClicked() {
		String tempStr;
		Log.i(TAG, "Entered enterClicked()");
		
		// TODO - Save user provided input from the EditText field
		tempStr = mEditText.getText().toString();

		Log.i(TAG, tempStr);
		// TODO - Create a new intent and save the input from the EditText field as an extra
		Intent returnIntent = new Intent();
		returnIntent.putExtra(returnString, tempStr);
		// TODO - Set Activity's result with result code RESULT_OK
		setResult(RESULT_OK, returnIntent);
		// TODO - Finish the Activity
		finish();

	}
}
