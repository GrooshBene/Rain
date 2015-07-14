package onegreat.rain;

import android.content.Context;

/**
 * Created by grooshbene on 15. 7. 14.
 */
public class CData {
    private int icon, value_id;
    private String confirm;
    private String content_label;
    private String description;

    public CData(Context context, int icon_, String content_label_, String description_) {
        icon = icon_;
//        confirm = confirm_;
        content_label = content_label_;
        description = description_;
//        value_id = value_id_;
    }

    public int getValue_id() {
        return value_id;
    }

    public int getIcon() {
        return icon;
    }

    public String getConfirm() {
        return confirm;
    }

    public String getContent_label() {
        return content_label;
    }

    public String getDescription() {
        return description;
    }
}