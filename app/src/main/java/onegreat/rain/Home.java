package onegreat.rain;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class Home extends Activity {
    CustomDialog  customDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        customDialog = new CustomDialog(Home.this);
        ImageView cal = (ImageView)findViewById(R.id.btn_cal);
        ImageView game = (ImageView)findViewById(R.id.btn_game);
        ImageView setting = (ImageView)findViewById(R.id.btn_option);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   Intent game= new Intent(Home.this,calendar.class);
                startActivity(game);
            }
        });
        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"섹스",Toast.LENGTH_SHORT).show();
            }
        });
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialog.show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
