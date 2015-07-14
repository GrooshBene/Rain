package onegreat.rain;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.preference.Preference;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class ScheduleSign extends ActionBarActivity {
    LinearLayout backbtn;
    LinearLayout datepicker;
    LinearLayout musicpicker;
    LinearLayout gamepicker;
    ImageView btnok;
    TextView tv_time;
    Typeface typeface1;

    public SharedPreferences pref1;
    SharedPreferences.Editor edit1;
    public int cnt = 0;
    EditText textedit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_sign);
        datepicker = (LinearLayout)findViewById(R.id.datepicker);
        gamepicker = (LinearLayout)findViewById(R.id.gamepicker);
        musicpicker = (LinearLayout)findViewById(R.id.musicpicker);
        tv_time = (TextView)findViewById(R.id.tv_time);
        textedit = (EditText)findViewById(R.id.edittext);
        tv_time.setTypeface(Typeface.createFromAsset(getAssets(),"RobotoCondensed-Light.ttf"));
        datepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"없어",Toast.LENGTH_SHORT).show();
            }
        });
//        gamepicker.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(),"구현중",Toast.LENGTH_SHORT).show();
//            }
//        });
        musicpicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"ㅇㅇ",Toast.LENGTH_SHORT).show();
            }
        });
        backbtn = (LinearLayout)findViewById(R.id.backbtn);
        btnok= (ImageView)findViewById(R.id.btn_ok);
//        textedit = (EditText)findViewById(R.id.textedit);
        pref1 = getSharedPreferences("Schedule",0);
        edit1 = pref1.edit();
//        final String s = textedit.getText().toString();
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit1.putString("schedule" + cnt, textedit.getText().toString());
                edit1.putInt("count", cnt);
                edit1.commit();
                cnt++;
                finish();
            }
        });
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

//        pref1 = getSharedPreferences("DialogSchedule",0);
//        edit1 = pref1.edit();
//
//        edit1.putString("asdf","nullpointerexception");
//        edit1.commit();
//
//        String s = pref1.getString("asdf","no string");

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
