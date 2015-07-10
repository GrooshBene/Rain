package onegreat.rain;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
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
   private ArrayAdapter<String> s;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setWindowManager(); // Window 기본 구성 설정, 백그라운드 dimm정도 설정 등
        setContentView(R.layout.schedule_list); // 다이얼로그 레이아웃, 레이아웃 관련 설명도 주석달아놨으니 읽어보세요
        ListView scheduleList = (ListView)findViewById(R.id.schedule_list);
        scheduleList.setAdapter(s);
        s.add("a");
        s.add("b");
        s.add("c");

        dateText = (TextView) findViewById(R.id.list_day);
        LinearLayout backbtn = (LinearLayout)findViewById(R.id.backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }

    // 호출되었을때 받아오는것 > context, dialogTitle, dialogDescription, dialogOnClickListener.
    // 호출되서 받아왔을시 본 액티비티의 String dialogTitle, String dialogDescription, View.OnClickListener onClickListenerOnCustomDialog에 넘겨줌
    public DialogSchedule(Context context, ArrayAdapter<String> m_adapter) {
        /*
        넘겨받은 context와 다이얼로그의 기본 Theme 정의.
        몇가지 다른 Diealog 테마를 적용시켜봤는데 가장 적합한게 AppCompat에서 지원하는 Dialog이더라
        */
        super(context, R.style.Theme_AppCompat_Light_Dialog);
        this.s = m_adapter;
    }


    public void setWindowManager() {
        //윈도우 받아와서 dimAmount설정, 이건 그냥 안건드려도 될듯
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}

