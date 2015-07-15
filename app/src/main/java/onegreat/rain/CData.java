package onegreat.rain;

import android.content.Context;

/**
 * Created by grooshbene on 15. 7. 14.
 */
public class CData {
    public int icon;
    public String content_label;
    public String description;
    public int id_position;
    public String time;

    public CData(Context context, int icon_, String content_label_, String description_, int id_position_,String time_) {
        icon = icon_;
        content_label = content_label_;
        description = description_;
        id_position = id_position_;
        time = time_;
    }

    public int getIcon() {
        return icon;
    }

    public String getContent_label() {
        return content_label;
    }

    public String getDescription() {
        return description;
    }

    public String getTime(){
        return time;
    }

    public int getId_position(){
        return id_position;
    }
}