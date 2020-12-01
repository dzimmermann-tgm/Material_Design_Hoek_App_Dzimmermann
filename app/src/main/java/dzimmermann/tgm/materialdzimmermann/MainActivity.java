package dzimmermann.tgm.materialdzimmermann;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {


    private TextInputLayout name;
    private TextInputLayout address;
    private TextInputLayout dob;
    private BottomNavigationView bnv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.name = (TextInputLayout)findViewById(R.id.mat_name_field);
        this.address = (TextInputLayout)findViewById(R.id.mat_address_field);
        this.dob = (TextInputLayout)findViewById(R.id.mat_dob_field);

        final Object that = this;

        this.bnv =  ((BottomNavigationView) findViewById(R.id.bottom_navigation));
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.page_1) {
                    Toast.makeText((MainActivity)that, "Hello there master kenobi", Toast.LENGTH_SHORT).show();
                    pfuschAmBau(item);
                } else if(item.getItemId() == R.id.page_2) {
                    Toast.makeText((MainActivity)that, "Something else", Toast.LENGTH_SHORT).show();
                } else if(item.getItemId() == R.id.page_3) {
                    Toast.makeText((MainActivity)that, "Something else again", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }

    public void pfuschAmBau(MenuItem item) {
        BadgeDrawable bd = bnv.getOrCreateBadge(item.getItemId());
        bd.setVisible(true);
        bd.setNumber(101);
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
