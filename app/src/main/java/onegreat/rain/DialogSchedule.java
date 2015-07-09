package onegreat.rain;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by GrooshBene on 2015-07-08.
 */
public class DialogSchedule extends Dialog implements AdapterView.OnItemClickListener
{
    TextView dateText;
    public String[] arrList = {
            "������ ������",
            "��â�� ������",
            "���� ���� ����"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> Adapter;
        Adapter  = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrList);//�����߻�
        ListView scheduleList  = (ListView)findViewById(R.id.schedule_list);
        scheduleList.setAdapter(Adapter);
        setWindowManager(); // Window �⺻ ���� ����, ��׶��� dimm���� ���� ��
        setContentView(R.layout.schedule_list); // ���̾�α� ���̾ƿ�, ���̾ƿ� ���� ���� �ּ��޾Ƴ����� �о����

        dateText = (TextView) findViewById(R.id.list_day);
        LinearLayout backbtn = (LinearLayout)findViewById(R.id.backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }

    // ȣ��Ǿ����� �޾ƿ��°� > context, dialogTitle, dialogDescription, dialogOnClickListener.
    // ȣ��Ǽ� �޾ƿ����� �� ��Ƽ��Ƽ�� String dialogTitle, String dialogDescription, View.OnClickListener onClickListenerOnCustomDialog�� �Ѱ���
    public DialogSchedule(Context context, String s) {
        /*
        �Ѱܹ��� context�� ���̾�α��� �⺻ Theme ����.
        ��� �ٸ� Diealog �׸��� ������Ѻôµ� ���� �����Ѱ� AppCompat���� �����ϴ� Dialog�̴���
        */
        super(context, R.style.Theme_AppCompat_Light_Dialog);

    }


    public void setWindowManager() {
        //������ �޾ƿͼ� dimAmount����, �̰� �׳� �Ȱǵ���� �ɵ�
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}

