package onegreat.rain;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by grooshbene on 15. 7. 14.
 */
public class SlideAdapter extends ArrayAdapter<CData> {
    // 레이아웃 XML을 읽어들이기 위한 객체
    private LayoutInflater mInflater;
    ImageView Image;
    TextView mText;
    LinearLayout bg;


    public SlideAdapter(Context context, ArrayList<CData> object) {
        // 상위 클래스의 초기화 과정
        // context, 0, 자료구조
        super(context, 0, object);
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // 보여지는 스타일을 자신이 만든 xml로 보이기 위한 구문
    @Override
    public View getView(int position, View v, ViewGroup parent) {
        View view = null;
        // 현재 리스트의 하나의 항목에 보일 컨트롤 얻기
        if (v == null) {
            // XML 레이아웃을 직접 읽어서 리스트뷰에 넣음
            view = mInflater.inflate(R.layout.slide_list, null);
        } else {
            view = v;
        }
        // 자료를 받는다.
        final CData data = this.getItem(position);
        if (data != null) {
            //화면 출력

            Image = (ImageView)view.findViewById(R.id.slideic);
            mText = (TextView)view.findViewById(R.id.tv_slide);
            bg = (LinearLayout)view.findViewById(R.id.background_slide);

        }
        return view;
    }
}

