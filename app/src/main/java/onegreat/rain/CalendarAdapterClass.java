package onegreat.rain;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by GrooshBene on 2015-06-23.
 */
public class CalendarAdapterClass extends BaseAdapter {
    private ArrayList<DayInfo> mDayList;
    private Context mContext;
    private int mResource;
    private LayoutInflater mLiInflater;

    public CalendarAdapterClass(Context context, int textResource, ArrayList<DayInfo> dayList) {
        this.mContext = context;
        this.mDayList = dayList;
        this.mResource = textResource;
        this.mLiInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    public int getCount() {
        // TODO Auto-generated method stub
        return mDayList.size();
    }


    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return mDayList.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        DayInfo day = mDayList.get(position);

        DayViewHolde dayViewHolder;

        if (convertView == null) {
            convertView = mLiInflater.inflate(mResource, null);

            if (position % 7 == 6) {
                convertView.setLayoutParams(new GridView.LayoutParams(getCellWidthDP() + getRestCellWidthDP(), getCellHeightDP()));
            } else {
                convertView.setLayoutParams(new GridView.LayoutParams(getCellWidthDP(), getCellHeightDP()));
            }
            dayViewHolder = new DayViewHolde();
            dayViewHolder.llBackground = (LinearLayout) convertView.findViewById(R.id.content_day);
            dayViewHolder.tvDay = (TextView) convertView.findViewById(R.id.content_day_text);

            convertView.setTag(dayViewHolder);
        } else {
            dayViewHolder = (DayViewHolde) convertView.getTag();
        }

        if (day != null) {
            dayViewHolder.tvDay.setText(day.getDay());

            if (day.isInMonth()) {
                if (position % 7 == 0) {
                    dayViewHolder.tvDay.setTextColor(Color.RED);
                } else if (position % 7 == 6) {
                    dayViewHolder.tvDay.setTextColor(Color.BLUE);
                } else {
                    dayViewHolder.tvDay.setTextColor(Color.WHITE);
                }
            } else {
                dayViewHolder.tvDay.setTextColor(Color.GRAY);
            }

        }

        return convertView;
    }

    public class DayViewHolde {
        public LinearLayout llBackground;
        public TextView tvDay;

    }

    private int getCellWidthDP() {
//      int width = mContext.getResources().getDisplayMetrics().widthPixels;
        int cellWidth = mContext.getResources().getDisplayMetrics().widthPixels/7;
        return cellWidth;
    }

    private int getRestCellWidthDP() {
//      int width = mContext.getResources().getDisplayMetrics().widthPixels;
        int cellWidth = mContext.getResources().getDisplayMetrics().widthPixels%7;

        return cellWidth;
    }


    private int getCellHeightDP() {
//      int height = mContext.getResources().getDisplayMetrics().widthPixels;
        int cellHeight = mContext.getResources().getDisplayMetrics().widthPixels/7;

        return cellHeight;
    }
}
