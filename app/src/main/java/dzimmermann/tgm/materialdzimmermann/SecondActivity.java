package dzimmermann.tgm.materialdzimmermann;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ((TextView)(this.findViewById(R.id.text))).setText(getIntent().getStringExtra("VALS"));
    }
}
