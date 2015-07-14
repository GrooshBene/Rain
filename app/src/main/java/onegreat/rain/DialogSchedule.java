package onegreat.rain;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by GrooshBene on 2015-07-08.
 */
public class DialogSchedule extends Activity implements AdapterView.OnItemClickListener {

    TextView dateText;

    ArrayList<CData> dataArr;
    Context context;
    ImageView btn_add;
    Button ok;
    SharedPreferences pref1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setWindowManager(); // Window �⺻ ���� ����, ��׶���? dimm���� ���� ��
        setContentView(R.layout.schedule_list); // ���̾�α�? ���̾ƿ�, ���̾ƿ� ���? ���?? �ּ��޾Ƴ����� �о����
        dataArr= new ArrayList<>();
        ArrayAdapter m_adapter;
        btn_add = (ImageView)findViewById(R.id.btn_add);
        ListView scheduleList = (ListView) findViewById(R.id.schedule_list);
        Intent intent = getIntent();
        int year = intent.getIntExtra("year",0);
        int month = intent.getIntExtra("month",0);
        int dayOfMonth = intent.getIntExtra("date",0);
        scheduleList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        scheduleList.setAdapter(new DataAdapter(DialogSchedule.this, dataArr));
        pref1 = getSharedPreferences("Schedule",0);
        int cnt = pref1.getInt("count",10);
        dataArr.add(new CData(getApplicationContext(),R.drawable.ic_type_edu,"공부하기",""));
        dataArr.add(new CData(getApplicationContext(),R.drawable.ic_type_etc,"야동보기",""));
        dataArr.add(new CData(getApplicationContext(),R.drawable.ic_type_etc,"운동하기",""));
//        for(int i=0;i<=cnt;i++) {
//            String s = pref1.getString("schedule"+i, "ㅁㄴㅇㄹ");
//            dataArr.add(new CData(getApplicationContext(),R.drawable.ic_music,s,s));
//            //프리퍼런스 불러오
//        }



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
        LinearLayout backbtn = (LinearLayout) findViewById(R.id.backbtn);
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
                startActivity(intent);
            }
        });

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
        TextView s = (TextView)findViewById(R.id.mText);
        Toast.makeText(getApplicationContext(),s.getText().toString(),Toast.LENGTH_SHORT).show();

    }

}

