package onegreat.rain;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;

/**
 * Created by GrooshBene on 2015-07-03.
 */
public class CustomDialog extends Dialog {



//    Button button;
//    TextView Title, Description;
//    String DialogTitle, DialogDescription; // 받아온 String값들을 저장할 String객체 생성
//    View.OnClickListener onClickListenerOnCustomDialog; // 받아온 온클릭리스터를 저장할 View.OnClickListener객체 생성
    int soundCnt = 1;
    int fxCnt = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setWindowManager(); // Window 기본 구성 설정, 백그라운드 dimm정도 설정 등
        setContentView(R.layout.setting_dial); // 다이얼로그 레이아웃, 레이아웃 관련 설명도 주석달아놨으니 읽어보세요
//        setDefaultLayout(); // 기본 레이아웃 설정 함수
        ImageView okBtn = (ImageView)findViewById(R.id.btn_ok);
        FrameLayout soundBtn = (FrameLayout)findViewById(R.id.sound_btn);
        FrameLayout fxBtn = (FrameLayout)findViewById(R.id.fx_btn);
        final ImageView fx_On = (ImageView)findViewById(R.id.fx_on);
        final ImageView fx_Off = (ImageView)findViewById(R.id.fx_off);
        final ImageView sound_On = (ImageView)findViewById(R.id.sound_on);
        final ImageView sound_Off = (ImageView)findViewById(R.id.sound_off);
        soundBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundCnt++;
                switch (soundCnt){
                    case 1:
                       sound_On.setVisibility(ImageView.INVISIBLE);
                        sound_Off.setVisibility(ImageView.VISIBLE);
                        break;
                    case 2:
                        sound_On.setVisibility(ImageView.VISIBLE);
                        sound_Off.setVisibility(ImageView.INVISIBLE);
                        soundCnt = 0;
                        break;
                }
            }
        });
        fxBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fxCnt++;
                switch (fxCnt){
                    case 1:
                        fx_On.setVisibility(ImageView.INVISIBLE);
                        fx_Off.setVisibility(ImageView.VISIBLE);
                        break;
                    case 2:
                        fx_On.setVisibility(ImageView.VISIBLE);
                        fx_Off.setVisibility(ImageView.INVISIBLE);
                        fxCnt=0;
                        break;
                }
            }
        });
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }

    // 호출되었을때 받아오는것 > context, dialogTitle, dialogDescription, dialogOnClickListener.
    // 호출되서 받아왔을시 본 액티비티의 String dialogTitle, String dialogDescription, View.OnClickListener onClickListenerOnCustomDialog에 넘겨줌
    public CustomDialog(Context context) {
        /*
        넘겨받은 context와 다이얼로그의 기본 Theme 정의.
        몇가지 다른 Dialog 테마를 적용시켜봤는데 가장 적합한게 AppCompat에서 지원하는 Dialog이더라
        */
        super(context, R.style.Theme_AppCompat_Light_Dialog);

    }
//    public void setDefaultLayout() {
//        //기본 레이아웃에서 객체 받아와서 findViewById로 연결
//        Title = (TextView)findViewById(R.id.title);
//        Description = (TextView)findViewById(R.id.description);
//        button = (Button)findViewById(R.id.button);
//        // 각각 객체 설정
//        Title.setText(DialogTitle);
//        Description.setText(DialogDescription);
//        button.setOnClickListener(onClickListenerOnCustomDialog);
//    }

    public void setWindowManager() {
        //윈도우 받아와서 dimAmount설정, 이건 그냥 안건드려도 될듯
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);
    }
}