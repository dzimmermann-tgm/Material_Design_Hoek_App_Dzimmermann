package dzimmermann.tgm.materialdzimmermann;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {


    private TextInputLayout name;
    private TextInputLayout address;
    private TextInputLayout dob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.name = (TextInputLayout)findViewById(R.id.mat_name_field);
        this.address = (TextInputLayout)findViewById(R.id.mat_address_field);
        this.dob = (TextInputLayout)findViewById(R.id.mat_dob_field);
    }

    public void abbrechenClicked(View v) {
        this.name.getEditText().setText("");
        this.address.getEditText().setText("");
        this.dob.getEditText().setText("");
    }

    public void weiterClicked(View v) {
        String name = this.name.getEditText().getText().toString();
        if(name.equals("") || name.length() > 100) {
            Toast.makeText(this, "wrong Name input", Toast.LENGTH_SHORT).show();
            return;
        }

        String address = this.address.getEditText().getText().toString();
        if(address.equals("") || address.length() > 100) {
            Toast.makeText(this, "Wrong adress input", Toast.LENGTH_SHORT).show();
            return;
        }

        String dob = this.dob.getEditText().getText().toString();
        if(dob.equals("") || dob.length() != 11) {
            this.dob.setError("Wrong Date format.");
            return;
        } else {
            this.dob.setError(null);
        }

        Intent i = new Intent(this, SecondActivity.class);
        i.putExtra("VALS", name+" " + address + " " + dob);
        startActivity(i);

    }
}
