package onegreat.rain;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;


public class ScheduleSign extends ActionBarActivity {
    LinearLayout backbtn;
    EditText textedit;
    Button btnok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_sign);
        backbtn = (LinearLayout)findViewById(R.id.backbtn);
//        btnok= (Button)findViewById(R.id.okbtn);
//        textedit = (EditText)findViewById(R.id.textedit);
//        final String s = textedit.getText().toString();
//        btnok.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent2 = new Intent(ScheduleSign.this, DialogSchedule.class);
//                intent2.putExtra("asdf", s);
//            }
//        });
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
//        Intent intent = getIntent();
//        TextView tv = (TextView)findViewById(R.id.asdf);
//        String s = intent.getStringExtra("key");
//        tv.setText(s);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_schedule_sign, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
