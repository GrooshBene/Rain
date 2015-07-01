package onegreat.rain;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;


public class calendar extends ActionBarActivity implements View.OnClickListener,AdapterView.OnItemClickListener {
    public static int SUNDAY = 1;
    TextView calendarViewTitle;
    GridView calendarGridView;
    private ArrayList<DayInfo> dayList;
    private CalendarAdapterClass calendarAdapterClass;
    Calendar lastMonthCalendar, thisMonthCalendar, nextMonthCalendar;
    Button lastMonth, nextMonth;
    private ListView mini_scheduler;
    private ArrayAdapter<String> m_adapter;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        m_adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1);
        mini_scheduler=(ListView)findViewById(R.id.schedule_list);
        mini_scheduler.setAdapter(m_adapter);
        m_adapter.add("돌겜 하기");
        m_adapter.add("달리기 운동하기");
        m_adapter.add("아침밥 챙겨먹기");
        m_adapter.add("구창림 때리기");
        m_adapter.add("정유빈 때리기");
        m_adapter.add("맹승연한테 빌기");
        ImageView lastMonth = (ImageView) findViewById(R.id.last_month);
        ImageView nextMonth = (ImageView) findViewById(R.id.next_month);
        calendarViewTitle = (TextView) findViewById(R.id.calendarTitle);
        calendarGridView = (GridView) findViewById(R.id.calendarGrid);
        lastMonth.setOnClickListener(this);
        nextMonth.setOnClickListener(this);
        LinearLayout backbtn = (LinearLayout)findViewById(R.id.back_ic);
        calendarGridView.setOnItemClickListener(this);
        dayList = new ArrayList<DayInfo>();
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        // 이번달 캘린더 인스턴스 받는거야 여기.
        thisMonthCalendar = Calendar.getInstance();
        thisMonthCalendar.set(Calendar.DAY_OF_MONTH, 1);
        getCalendar(thisMonthCalendar);
    }

    private void getCalendar(Calendar calendar) {
        int lastMonthStartDay;
        int dayOfMonth;
        int thisMonthLastDay;
        dayList.clear();

        // 이번달 시작요일을 구하는 부분임 시작일이 일요일이면 다음주 일요일로 바꾸는거고 7을더해.
        dayOfMonth = calendar.get(Calendar.DAY_OF_WEEK);
        thisMonthLastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.add(Calendar.MONTH, -1);
        lastMonthStartDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.add(Calendar.MONTH, 1);

        if (dayOfMonth == SUNDAY) {
            dayOfMonth += 7;
        }
        lastMonthStartDay -= (dayOfMonth - 1) - 1;
        // 년월 글자 setText해주는부분
        calendarViewTitle.setText(thisMonthCalendar.get(Calendar.YEAR) + "년 "
                + (thisMonthCalendar.get(Calendar.MONTH) + 1) + "월");
        DayInfo day;
        for (int i = 0; i < dayOfMonth - 1; i++) {
            int date = lastMonthStartDay + i;
            day = new DayInfo();
            day.setDay(Integer.toString(date));
            day.setInMonth(false);
            dayList.add(day);
        }
        for (int i = 1; i <= thisMonthLastDay; i++) {
            day = new DayInfo();
            day.setDay(Integer.toString(i));
            day.setInMonth(true);

            dayList.add(day);
        }
        for (int i = 1; i < 42 - (thisMonthLastDay + dayOfMonth - 1) + 1; i++) {
            day = new DayInfo();
            day.setDay(Integer.toString(i));
            day.setInMonth(false);
            dayList.add(day);
        }

        initCalendarAdapter();
    }

    private Calendar getLastMonth(Calendar calendar) {
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 1);
        calendar.add(Calendar.MONTH, -1);
        calendarViewTitle.setText(thisMonthCalendar.get(Calendar.YEAR) + "년 "
                + (thisMonthCalendar.get(Calendar.MONTH) + 1) + "월");
        return calendar;
    }

    private Calendar getNextMonth(Calendar calendar) {
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 1);
        calendar.add(Calendar.MONTH, +1);
        calendarViewTitle.setText(thisMonthCalendar.get(Calendar.YEAR) + "년 "
                + (thisMonthCalendar.get(Calendar.MONTH) + 1) + "월");
        return calendar;
    }

    public void onItemClick(AdapterView<?> parent, View v, int position, long arg3) {
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.last_month: {
                thisMonthCalendar = getLastMonth(thisMonthCalendar);
                getCalendar(thisMonthCalendar);
                break;
            }
            case R.id.next_month: {
                thisMonthCalendar = getNextMonth(thisMonthCalendar);
                getCalendar(thisMonthCalendar);
                break;
            }
        }
    }

    private void initCalendarAdapter() {
        calendarAdapterClass = new CalendarAdapterClass(this, R.layout.content_day, dayList);
        calendarGridView.setAdapter(calendarAdapterClass);
    }
}
