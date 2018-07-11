package sg.edu.rp.c346.myprofile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etGPA;
    RadioGroup rgGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etGPA = findViewById(R.id.editTextGPA);
        etName = findViewById(R.id.editTextName);
        rgGender = findViewById(R.id.radioGroupGender);


    }// havent do SharedPreferences for RadioButton

    @Override
    protected void onPause() {
        super.onPause();

        //Get the user input from the EditText and store it in a variable
        String strName = etName.getText().toString();
        String strGpa = etGPA.getText().toString();
        float gpa = Float.parseFloat(strGpa);
        int selectGender = rgGender.getCheckedRadioButtonId();



        //Obtain an instance of the SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        //Obtain an instance of the SharedPreferences Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();

        //Add the key-value pair
        prefEdit.putString("name", strName);
        prefEdit.putFloat("gpa", gpa);
        prefEdit.putInt("gender", selectGender);
        //Call commit() method to save the changes into SharedPreferences
        prefEdit.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();

        //Obtain an instance of the SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        //Retrieve the saved data from the SharedPreferences Object
        String strName = prefs.getString("name", "Default Name");
        float gpa = prefs.getFloat("gpa",0);
        int gender = prefs.getInt("gender", 0);

        //Update the UI element with the value
       etName.setText(strName);
       etGPA.setText(Float.toString(gpa));
        // etGPA.setText(gpa+""); --> lazy way
       rgGender.check(gender);

















    }
}
