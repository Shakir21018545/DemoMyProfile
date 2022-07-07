package sg.edu.rp.c346.id21018545.demomyprofile;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    EditText etGPA;
    RadioGroup rgGender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
        rgGender = findViewById(R.id.radioGroupGender);
    }
    @Override
    protected void onStop() {
        super.onStop();
        String strName = etName.getText().toString();
        float gpa= Float.parseFloat(etGPA.getText().toString());SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String gender;
        if (rgGender.getCheckedRadioButtonId() == R.id.radioButtonGenderMale){
            gender = "Male";
        } else {
            gender = "Female";
        }
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("name", strName);
        prefEdit.putFloat("gpa", gpa);
        prefEdit.putString("gender", gender);
        prefEdit.commit();
    }
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String strName = prefs.getString("name", "John");
        float gpa = prefs.getFloat("gpa", 0 );
        String gender = prefs.getString("gender", "Male");
        etName.setText(strName);
        etGPA.setText(gpa + "");
        if (gender.equals("Male") ){
            rgGender.check(R.id.radioButtonGenderMale);
        } else if ( gender.equals("Female") ){
            rgGender.check(R.id.radioButtonGenderFemale);
        }
    }
}