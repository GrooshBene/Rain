package onegreat.rain;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;


public class calendar extends Activity {
//    public static int SUNDAY = 1;
//    TextView calendarViewTitle;
//    DialogSchedule ScheduleDialog;
//    GridView calendarGridView;
//    private ArrayList<DayInfo> dayList;
//    private CalendarAdapterClass calendarAdapterClass;
//    Calendar lastMonthCalendar, thisMonthCalendar, nextMonthCalendar;
//    Button lastMonth, nextMonth;
//    int position_temp = 0;
//    ArrayAdapter<String> m_adapter;
    CalendarView cal;
    LinearLayout backbtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        cal = (CalendarView)findViewById(R.id.calendar);
        backbtn = (LinearLayout)findViewById(R.id.back_ic);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int year, int month, int dayOfMonth) {
                Intent intent = new Intent(calendar.this, DialogSchedule.class);
                intent.putExtra("year",year);
                intent.putExtra("month",month+1);
                intent.putExtra("date",dayOfMonth);
                startActivity(intent);

            }
        });

////        m_adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1);
//
//
//        ImageView lastMonth = (ImageView) findViewById(R.id.last_month);
//        ImageView nextMonth = (ImageView) findViewById(R.id.next_month);
//        calendarViewTitle = (TextView) findViewById(R.id.calendarTitle);
//        calendarGridView = (GridView) findViewById(R.id.calendarGrid);
//        lastMonth.setOnClickListener(this);
//        nextMonth.setOnClickListener(this);
//        LinearLayout backbtn = (LinearLayout) findViewById(R.id.back_ic);
//        calendarGridView.setOnItemClickListener(this);
//        dayList = new ArrayList<DayInfo>();
//        backbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        // 이번달 캘린더 인스턴스 받는거야 여기.
//        thisMonthCalendar = Calendar.getInstance();
//        thisMonthCalendar.set(Calendar.DAY_OF_MONTH, 1);
//        getCalendar(thisMonthCalendar);
//    }
//
//    private void getCalendar(Calendar calendar) {
//        int lastMonthStartDay;
//        int dayOfMonth;
//        int thisMonthLastDay;
//        dayList.clear();
//
//        // 이번달 시작요일을 구하는 부분임 시작일이 일요일이면 다음주 일요일로 바꾸는거고 7을더해.
//        dayOfMonth = calendar.get(Calendar.DAY_OF_WEEK);
//        thisMonthLastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
//        calendar.add(Calendar.MONTH, -1);
//        lastMonthStartDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
//        calendar.add(Calendar.MONTH, 1);
//
//        if (dayOfMonth == SUNDAY) {
//            dayOfMonth += 7;
//        }
//        lastMonthStartDay -= (dayOfMonth - 1) - 1;
//        // 년월 글자 setText해주는부분
//        calendarViewTitle.setText(thisMonthCalendar.get(Calendar.YEAR) + "년 "
//                + (thisMonthCalendar.get(Calendar.MONTH) + 1) + "월");
//        DayInfo day;
//        for (int i = 0; i < dayOfMonth - 1; i++) {
//            int date = lastMonthStartDay + i;
//            day = new DayInfo();
//            day.setDay(Integer.toString(date));
//            day.setInMonth(false);
//            dayList.add(day);
//        }
//        for (int i = 1; i <= thisMonthLastDay; i++) {
//            day = new DayInfo();
//            day.setDay(Integer.toString(i));
//            day.setInMonth(true);
//
//            dayList.add(day);
//        }
//        for (int i = 1; i < 42 - (thisMonthLastDay + dayOfMonth - 1) + 1; i++) {
//            day = new DayInfo();
//            day.setDay(Integer.toString(i));
//            day.setInMonth(false);
//            dayList.add(day);
//        }
//
//        initCalendarAdapter();
//    }
//    private int getPositionToDate(int position, Calendar calendar){//다이얼로그에 띄울 날짜 계산함
//        int dayOfMonth;
//        int date;
//        int thisMonthLastDay;
//        int lastMonthStartDay;
//        DayInfo day;
//
//        dayOfMonth = calendar.get(Calendar.DAY_OF_WEEK);
//        thisMonthLastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
//        calendar.add(Calendar.MONTH, -1);
//        lastMonthStartDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
//        calendar.add(Calendar.MONTH, 1);
//
//        if (dayOfMonth == SUNDAY) {
//            dayOfMonth += 7;
//        }
//        lastMonthStartDay -= (dayOfMonth - 1) - 1;
//        date = lastMonthStartDay+position-thisMonthLastDay;
//        return date;
//
//    }
//
//    private Calendar getLastMonth(Calendar calendar) {
//        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 1);
//        calendar.add(Calendar.MONTH, -1);
//        calendarViewTitle.setText(thisMonthCalendar.get(Calendar.YEAR) + "년 "
//                + (thisMonthCalendar.get(Calendar.MONTH) + 1) + "월");
//        return calendar;
//    }
//
//    private Calendar getNextMonth(Calendar calendar) {
//        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 1);
//        calendar.add(Calendar.MONTH, +1);
//        calendarViewTitle.setText(thisMonthCalendar.get(Calendar.YEAR) + "년 "
//                + (thisMonthCalendar.get(Calendar.MONTH) + 1) + "월");
//        return calendar;
//    }
//
//    public void onItemClick(AdapterView<?> parent, View v, int position, long arg3) {
//        Intent intent = new Intent(calendar.this, DialogSchedule.class);
//        startActivityForResult(intent, 1);
//        Toast.makeText(getApplicationContext(), getPositionToDate(position,thisMonthCalendar)+"", Toast.LENGTH_SHORT).show();
//    }
//
//
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.last_month: {
//                thisMonthCalendar = getLastMonth(thisMonthCalendar);
//                getCalendar(thisMonthCalendar);
//                break;
//            }
//            case R.id.next_month: {
//                thisMonthCalendar = getNextMonth(thisMonthCalendar);
//                getCalendar(thisMonthCalendar);
//                break;
//            }
//        }
//    }
//
//    private void initCalendarAdapter() {
//        calendarAdapterClass = new CalendarAdapterClass(this, R.layout.content_day, dayList);
//        calendarGridView.setAdapter(calendarAdapterClass);
//    }
    }
}
