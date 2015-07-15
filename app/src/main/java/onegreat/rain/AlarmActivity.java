package onegreat.rain;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by grooshbene on 15. 7. 15.
 */
public class AlarmActivity extends Activity {
    ListView slidelv;
    ArrayList<CData> listArr;
    DataAdapter adapter;
    TextView tv_time;
    TextView tv_date;
    String date;
    String time;
    SharedPreferences pref1;
    int cnt;
    SharedPreferences pref2;
    SharedPreferences.Editor edit1;
    SharedPreferences.Editor edit2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarmactivity);
        pref1 = getSharedPreferences("Schedule",0);
        pref2 = getSharedPreferences("countPref",0);
        edit1 = pref1.edit();
        edit2 = pref2.edit();
        cnt = pref2.getInt("count", 0);
        date = pref1.getString("date" + cnt, "");
        time = pref1.getString("time" + cnt, "");
        slidelv = (ListView)findViewById(R.id.slide);
        listArr = new ArrayList<CData>();
        adapter = new DataAdapter(AlarmActivity.this,listArr);
        tv_date = (TextView)findViewById(R.id.timeview);
        tv_time =  (TextView)findViewById(R.id.tv_date);
        tv_date.setText(date);
        tv_time.setText(time);
        SwipeDismissListViewTouchListener touchListener =
                new SwipeDismissListViewTouchListener(slidelv,
                        new SwipeDismissListViewTouchListener.DismissCallbacks() {
                            @Override
                            public boolean canDismiss(int position) {
                                return true;
                            }

                            @Override
                            public void onDismiss(ListView listView, int[] reverseSortedPositions) {
                                for (int position : reverseSortedPositions) {

                                    adapter.remove(adapter.getItem(position));
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

        slidelv.setOnTouchListener(touchListener);
        slidelv.setOnScrollListener(touchListener.makeScrollListener());
        slidelv.setOnItemClickListener((AdapterView.OnItemClickListener) this);
    }
}
