package onegreat.rain;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.preference.Preference;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class ScheduleSign extends ActionBarActivity {
    LinearLayout backbtn;
    LinearLayout datepicker;
    LinearLayout musicpicker;
    LinearLayout gamepicker;
    Spinner spinner_object;
    FloatingActionButton btnok;
    String result_object;
    int cnt;
    SharedPreferences pref2;
    TextView tv_time;
    TextView tv_date;
    int year, month, day,hour, minute;

    int color_te;
    public SharedPreferences pref1;
    SharedPreferences.Editor edit1;
    SharedPreferences.Editor edit2;
    EditText textedit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_sign);
        color_te = Color.parseColor("#84c6ed");
        GregorianCalendar calendar = new GregorianCalendar();
        pref2 = getSharedPreferences("countPref", 0);
        edit2 = pref2.edit();
        cnt = pref2.getInt("count",0);
        tv_date = (TextView)findViewById(R.id.tv_date);
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
        datepicker = (LinearLayout)findViewById(R.id.datepicker);
        gamepicker = (LinearLayout)findViewById(R.id.gamepicker);
        musicpicker = (LinearLayout)findViewById(R.id.musicpicker);
        tv_time = (TextView)findViewById(R.id.tv_time);
        textedit = (EditText)findViewById(R.id.edittext);
        tv_time.setTypeface(Typeface.createFromAsset(getAssets(), "RobotoCondensed-Light.ttf"));
        textedit.setTypeface(Typeface.createFromAsset(getAssets(),"NanumPen.ttf"));
        tv_date.setTypeface(Typeface.createFromAsset(getAssets(),"NanumPen.ttf"));
        String time_now = String.format("%d : %d",hour,minute);
        tv_time.setText(time_now);

//        gamepicker.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(),"구현중",Toast.LENGTH_SHORT).show();
//            }
//        });
        spinner_object = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter_object = ArrayAdapter
                .createFromResource(this, R.array.spinner_object,
                        android.R.layout.simple_spinner_item);
        adapter_object.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_object.setAdapter(adapter_object);
        result_object=(String)spinner_object.getSelectedItem();
        backbtn = (LinearLayout)findViewById(R.id.backbtn);
        btnok= (FloatingActionButton)findViewById(R.id.btn_ok);
//        textedit = (EditText)findViewById(R.id.textedit);
        pref1 = getSharedPreferences("Schedule", 0);
        edit1 = pref1.edit();
//        final String s = textedit.getText().toString();

//        btnok.setSize(FloatingActionButton.SIZE_MINI);
        btnok.setColorNormalResId(R.color.white);
        btnok.setColorPressedResId(R.color.white_pressed);
        btnok.setStrokeVisible(false);
        datepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(ScheduleSign.this, dateSetListener, year, month, day).show();
            }
        });
        tv_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TimePickerDialog(ScheduleSign.this, timeSetListener, hour, minute, false).show();
            }
        });
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text_e = textedit.getText().toString();
                if(text_e.equals(""))
                    text_e="\0";
                edit1.putString("schedule" + cnt, text_e);
                edit1.putString("category"+cnt, result_object);
                edit1.commit();

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
    private TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {


        @Override

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

            // TODO Auto-generated method stub

            String msg = String.format(" %d : %d",hourOfDay, minute);
            tv_time.setText(msg);

        }

    };

    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {



        @Override

        public void onDateSet(DatePicker view, int year, int monthOfYear,

                              int dayOfMonth) {

            // TODO Auto-generated method stub

            String msg = String.format("%d년 %d월 %d일", year,monthOfYear+1, dayOfMonth);
            tv_date.setText(msg);
            if(msg.equals(""))
                msg = "\0";
            edit1.putString("date"+cnt,msg);


        }

    };

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
