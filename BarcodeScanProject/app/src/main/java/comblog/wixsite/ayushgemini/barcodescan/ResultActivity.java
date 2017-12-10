package comblog.wixsite.ayushgemini.barcodescan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        txtResult=(TextView)findViewById(R.id.result);
        String result=getIntent().getStringExtra("result");
        txtResult.setText(result);
    }
}
