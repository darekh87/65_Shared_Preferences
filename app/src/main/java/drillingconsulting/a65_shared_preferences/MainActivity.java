package drillingconsulting.a65_shared_preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usernameInput;
    EditText passwordInput;
    TextView darekText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameInput = (EditText) findViewById(R.id.editText2);
        passwordInput= (EditText) findViewById(R.id.editText);
        darekText = (TextView) findViewById(R.id.textView3);

    }

    //Save the users login info
    public void saveInfo(View view){

        SharedPreferences sharedPref = getSharedPreferences("user info", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("username", usernameInput.getText().toString() );
        editor.putString("password", passwordInput.getText().toString() );
        editor.apply();

        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
        }

    //Print out the saved data
    public void DisplayData(View view){
        SharedPreferences sharedPref = getSharedPreferences("user info", Context.MODE_PRIVATE);

        String name = sharedPref.getString("username", "");
        String pw = sharedPref.getString("password", "");

        darekText.setText(name +" "+ pw);


    }


    }


