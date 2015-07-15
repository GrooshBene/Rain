package onegreat.rain;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by GrooshBene on 2015-07-08.
 */
public class DialogSchedule extends Activity implements AdapterView.OnItemClickListener {

    TextView dateText;
    float historicX = Float.NaN, historicY = Float.NaN;
    static final int DELTA = 50;
    enum Direction {LEFT, RIGHT;}
    ArrayList<CData> dataArr;
    Context context;
    int cat_pos;
    FloatingActionButton btn_add;
    String selected_object;
    SharedPreferences pref2;
    SharedPreferences pref1;
    SharedPreferences.Editor edit2;
    SharedPreferences.Editor edit1;
    int cnt=0;
    AlarmManager mManager;
    int res;
    ListView scheduleList;
    LinearLayout backbtn;
    ArrayAdapter m_adapter;
    DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setWindowManager(); // Window �⺻ ���� ����, ��׶���? dimm���� ���� ��
        setContentView(R.layout.schedule_list); // ���̾�α�? ���̾ƿ�, ���̾ƿ� ���? ���?? �ּ��޾Ƴ����� �о����
        mManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        btn_add = (FloatingActionButton) findViewById(R.id.btn_add);
        btn_add.setColorPressedResId(R.color.white_pressed);
        btn_add.setIcon(R.drawable.plus);
        btn_add.setColorNormalResId(R.color.white);
        scheduleList = (ListView) findViewById(R.id.schedule_list);
        Intent intent = getIntent();
        int year = intent.getIntExtra("year", 0);
        int month = intent.getIntExtra("month", 0);
        int dayOfMonth = intent.getIntExtra("date", 0);
        scheduleList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        dataArr = new ArrayList<CData>();
        pref1 = getSharedPreferences("Schedule", 0);
        pref2 = getSharedPreferences("countPref", 0);
        edit2 = pref2.edit();
        edit1 = pref1.edit();
        adapter = new DataAdapter(DialogSchedule.this, dataArr);
        scheduleList.setAdapter(adapter);
        cnt = pref2.getInt("count", 0);


//

//        pref1 = getSharedPreferences("DialogSchedule",0);
//        edit1 = pref1.edit();
//
//        edit1.putString("asdf","nullpointerexception");
//        edit1.commit();
//
//        String s = pref1.getString("asdf","no string");
//
//        dateText = (TextView) findViewById(R.id.list_day);
//        dateText.setText(year+"년 "+month+"월 "+dayOfMonth+"일");
        backbtn = (LinearLayout) findViewById(R.id.backbtn);
//        Intent intent2 = getIntent();
//        String list = intent2.getStringExtra("asdf");
//        m_adapter.add(list);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DialogSchedule.this, ScheduleSign.class);
                cnt = pref2.getInt("count", 0);
                cnt++;
                edit2.putInt("count", cnt);

                edit2.commit();
                startActivity(intent);


                finish();
            }
        });
        //여기있던 Preference 지움 (2개)
        for (int i = 0;/*!(pref1.getString("Schedule"+i,"default").equals("default"))*/ i <= cnt; i++) {
            String s = pref1.getString("schedule" + i, String.format("\0"));
            String date = pref1.getString("date" + i, String.format("\0"));
            String time = pref1.getString("time"+i, String.format("\0"));
            String selected_object = pref1.getString("category_str"+i, "asdf");
            switch(selected_object) {
                case "외출":
                    res = R.drawable.ic_type_exr;
                    break;
                case "식사":
                    res = R.drawable.ic_type_food;
                    break;
                case "자기개발/업무":
                    res = R.drawable.ic_type_edu;
                    break;
                case "기타":
                    res = R.drawable.ic_type_etc;
                    break;
            }
            if (s.equals("\0") || date.equals("\0")) continue;
            dataArr.add(new CData(getApplicationContext(),res, s, date,i,time));
            //프리퍼런스 불러오기
        }
        SwipeDismissListViewTouchListener touchListener =
                new SwipeDismissListViewTouchListener(scheduleList,
                        new SwipeDismissListViewTouchListener.DismissCallbacks() {
                            @Override
                            public boolean canDismiss(int position) {
                                return true;
                            }

                            @Override
                            public void onDismiss(ListView listView, int[] reverseSortedPositions) {
                                for (int position : reverseSortedPositions) {
                                    CData v = adapter.getItem(position);
                                    int getcnt = adapter.getCount();
                                    int id = v.id_position;
                                    String temp;
                                    String temp_date;
                                    temp = "\0";
                                    temp_date = "\0";
                                    edit1.putString("schedule"+id,temp);
                                    edit1.putString("date"+id,temp_date);
                                    edit1.commit();

                                    adapter.remove(adapter.getItem(position));
                                    if(getcnt==0)
                                        finish();
                                    //여기서 오류

//                                    CData v = adapter.getItem(position);
//
//                                    int id = v.id_position;
//                                    String temp;
//                                    String temp_date;
//                                    temp = "\0";
//                                    temp_date = "\0";
//                                    edit1.putString("schedule"+id,temp);
//                                    edit1.putString("date"+id,temp_date);
//                                    edit1.commit();

                                }
                                adapter.notifyDataSetChanged();

                            }
                        });

        scheduleList.setOnTouchListener(touchListener);
        scheduleList.setOnScrollListener(touchListener.makeScrollListener());
        scheduleList.setOnItemClickListener(this);
    }


    // ȣ��Ǿ�����? �޾ƿ��°� > context, dialogTitle, dialogDescription, dialogOnClickListener.
    // ȣ��Ǽ�? �޾ƿ����� �� ��Ƽ��Ƽ�� String dialogTitle, String dialogDescription, View.OnClickListener onClickListenerOnCustomDialog�� �Ѱ���
//    public DialogSchedule(Context context, ArrayAdapter<String> m_adapter) {
//        /*
//        �Ѱܹ��� context�� ���̾�α���? �⺻ Theme ����.
//        ��� �ٸ� Diealog �׸��� �����Ѻôµ� ���� �����Ѱ� AppCompat���� �����ϴ� Dialog�̴���
//        */
////        super(context, R.style.Theme_AppCompat_Light_Dialog);
//        this.s = m_adapter;
//    }


    public void setWindowManager() {
        //������ �޾ƿͼ� dimAmount����, �̰� �׳� �Ȱǵ����? �ɵ�
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent mIntent =null;
        CData s = adapter.getItem(position);
        int id_edit = s.id_position;
        edit2.putInt("id_edit",id_edit);
        edit2.commit();
        mIntent = new Intent(DialogSchedule.this, ScheduleEdit.class);
        startActivity(mIntent);
        finish();



    }
    private void releaseAlarm(){
        Intent intent = new Intent(this,AlarmActivity.class);
        PendingIntent pIndent = PendingIntent.getActivity(context, 0, intent, 0);
        mManager.cancel(pIndent);
    }
//    @Override
//    public void onResume() {
//        super.onResume();
//        pref1 = getSharedPreferences("Schedule",0);
//        pref2 = getSharedPreferences("countPref",0);
//        cnt= pref2.getInt("count",0);
//        for(int i=0;!(pref1.getString("Schedule"+i,"default").equals("default"));i++) {
//            String s = pref1.getString("schedule"+i, "");
//            String date = pref1.getString("date"+i, "");
//            dataArr.add(new CData(getApplicationContext(),R.drawable.ic_music,s,date));
//            //프리퍼런스 불러오기
//        }
//        //TODO 넣을 코드
//    }

}

