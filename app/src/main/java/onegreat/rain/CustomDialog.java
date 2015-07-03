package onegreat.rain;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by GrooshBene on 2015-07-03.
 */
public class CustomDialog extends Dialog {

    Button button;
    TextView Title, Description;
    String DialogTitle, DialogDescription; // �޾ƿ� String������ ������ String��ü ����
    View.OnClickListener onClickListenerOnCustomDialog; // �޾ƿ� ��Ŭ�������͸� ������ View.OnClickListener��ü ����
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setWindowManager(); // Window �⺻ ���� ����, ��׶��� dimm���� ���� ��
        setContentView(R.layout.setting_dial); // ���̾�α� ���̾ƿ�, ���̾ƿ� ���� ���� �ּ��޾Ƴ����� �о����
//        setDefaultLayout(); // �⺻ ���̾ƿ� ���� �Լ�
        ImageView okBtn = (ImageView)findViewById(R.id.btn_ok);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
    // ȣ��Ǿ����� �޾ƿ��°� > context, dialogTitle, dialogDescription, dialogOnClickListener.
    // ȣ��Ǽ� �޾ƿ����� �� ��Ƽ��Ƽ�� String dialogTitle, String dialogDescription, View.OnClickListener onClickListenerOnCustomDialog�� �Ѱ���
    public CustomDialog(Context context) {
        /*
        �Ѱܹ��� context�� ���̾�α��� �⺻ Theme ����.
        ��� �ٸ� Dialog �׸��� ������Ѻôµ� ���� �����Ѱ� AppCompat���� �����ϴ� Dialog�̴���
        */
        super(context, R.style.Theme_AppCompat_Light_Dialog);

    }
//    public void setDefaultLayout() {
//        //�⺻ ���̾ƿ����� ��ü �޾ƿͼ� findViewById�� ����
//        Title = (TextView)findViewById(R.id.title);
//        Description = (TextView)findViewById(R.id.description);
//        button = (Button)findViewById(R.id.button);
//        // ���� ��ü ����
//        Title.setText(DialogTitle);
//        Description.setText(DialogDescription);
//        button.setOnClickListener(onClickListenerOnCustomDialog);
//    }

    public void setWindowManager() {
        //������ �޾ƿͼ� dimAmount����, �̰� �׳� �Ȱǵ���� �ɵ�
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);
    }
}