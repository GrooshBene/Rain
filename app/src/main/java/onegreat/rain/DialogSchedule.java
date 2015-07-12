package onegreat.rain;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by GrooshBene on 2015-07-08.
 */
public class DialogSchedule extends Activity implements AdapterView.OnItemClickListener {

    TextView dateText;
    private ArrayAdapter<String> m_adapter;
    Context context;
    ImageView btn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setWindowManager(); // Window �⺻ ���� ����, ��׶��� dimm���� ���� ��
        setContentView(R.layout.schedule_list); // ���̾�α� ���̾ƿ�, ���̾ƿ� ��� ���? �ּ��޾Ƴ����� �о����
        btn_add = (ImageView)findViewById(R.id.btn_add);
        ListView scheduleList = (ListView) findViewById(R.id.schedule_list);
        Intent intent = getIntent();
        int year = intent.getIntExtra("year",0);
        int month = intent.getIntExtra("month",0);
        int dayOfMonth = intent.getIntExtra("date",0);
        m_adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1);
        scheduleList.setAdapter(m_adapter);
        m_adapter.add("a");
        m_adapter.add("k");
        m_adapter.add("q");
        m_adapter.add("g");
        m_adapter.add("d");
        m_adapter.add("x");
        m_adapter.add("e");
        m_adapter.add("s");

        dateText = (TextView) findViewById(R.id.list_day);
        dateText.setText(year+"년 "+month+"월 "+dayOfMonth+"일");
        LinearLayout backbtn = (LinearLayout) findViewById(R.id.backbtn);
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

    // ȣ��Ǿ����� �޾ƿ��°� > context, dialogTitle, dialogDescription, dialogOnClickListener.
    // ȣ��Ǽ� �޾ƿ����� �� ��Ƽ��Ƽ�� String dialogTitle, String dialogDescription, View.OnClickListener onClickListenerOnCustomDialog�� �Ѱ���
//    public DialogSchedule(Context context, ArrayAdapter<String> m_adapter) {
//        /*
//        �Ѱܹ��� context�� ���̾�α��� �⺻ Theme ����.
//        ��� �ٸ� Diealog �׸��� �����Ѻôµ� ���� �����Ѱ� AppCompat���� �����ϴ� Dialog�̴���
//        */
////        super(context, R.style.Theme_AppCompat_Light_Dialog);
//        this.s = m_adapter;
//    }


    public void setWindowManager() {
        //������ �޾ƿͼ� dimAmount����, �̰� �׳� �Ȱǵ���� �ɵ�
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//        ListView list = (ListView) findViewById(R.id.schedule_list);
//        Intent intent = new Intent(DialogSchedule.this, ScheduleSign.class);
//        intent.putExtra("key", (char[]) list.getItemAtPosition(position));
//        startActivity(intent);

    }


}

