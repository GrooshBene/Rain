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
//    String DialogTitle, DialogDescription; // tomi占쌨아울옙 String占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 String占쏙옙체 占쏙옙
//    View.OnClickListener onClickListenerOnCustomDialog; // 占쌨아울옙 占쏙옙클占쏙옙占쏙옙占쏙옙占싶몌옙 占쏙옙占쏙옙占쏙옙 View.OnClickListener占쏙옙체 占쏙옙
    int soundCnt = 1;
    int fxCnt = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setWindowManager(); // Window 占썩본 占쏙옙占쏙옙 占쏙옙占쏙옙, 占쏙옙溜占쏙옙占� dimm占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙
        setContentView(R.layout.setting_dial); // 占쏙옙占싱억옙慣占� 占쏙옙占싱아울옙, 占쏙옙占싱아울옙 占쏙옙占� 占쏙옙占�? 占쌍쇽옙占쌨아놂옙占쏙옙占쏙옙 占싻어보占쏙옙占쏙옙
//        setDefaultLayout(); // 占썩본 占쏙옙占싱아울옙 占쏙옙占쏙옙 占쌉쇽옙
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

    // 호占쏙옙퓸占쏙옙占쏙옙占� 占쌨아울옙占승곤옙 > context, dialogTitle, dialogDescription, dialogOnClickListener.
    // 호占쏙옙퓬占� 占쌨아울옙占쏙옙占쏙옙 占쏙옙 占쏙옙티占쏙옙티占쏙옙 String dialogTitle, String dialogDescription, View.OnClickListener onClickListenerOnCustomDialog占쏙옙 占싼곤옙占쏙옙
    public CustomDialog(Context context) {
        /*
        占싼겨뱄옙占쏙옙 context占쏙옙 占쏙옙占싱억옙慣占쏙옙占� 占썩본 Theme 占쏙옙占쏙옙.
        占쏘가占쏙옙 占쌕몌옙 Dialog 占쌓몌옙占쏙옙 占쏙옙占쏙옙占싼봤는듸옙 占쏙옙占쏙옙 占쏙옙占쏙옙占싼곤옙 AppCompat占쏙옙占쏙옙 占쏙옙占쏙옙占싹댐옙 Dialog占싱댐옙占쏙옙
        */
        super(context, R.style.Theme_AppCompat_Light_Dialog);

    }
//    public void setDefaultLayout() {
//        //占썩본 占쏙옙占싱아울옙占쏙옙占쏙옙 占쏙옙체 占쌨아와쇽옙 findViewById占쏙옙 占쏙옙占쏙옙
//        Title = (TextView)findViewById(R.id.title);
//        Description = (TextView)findViewById(R.id.description);
//        button = (Button)findViewById(R.id.button);
//        // 占쏙옙占쏙옙 占쏙옙체 占쏙옙占쏙옙
//        Title.setText(DialogTitle);
//        Description.setText(DialogDescription);
//        button.setOnClickListener(onClickListenerOnCustomDialog);
//    }

    public void setWindowManager() {
        //占쏙옙占쏙옙占쏙옙 占쌨아와쇽옙 dimAmount占쏙옙占쏙옙, 占싱곤옙 占쌓놂옙 占싫건듸옙占쏙옙占� 占심듸옙
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);
    }
}