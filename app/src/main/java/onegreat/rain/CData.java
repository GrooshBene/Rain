package onegreat.rain;

import android.content.Context;

/**
 * Created by grooshbene on 15. 7. 14.
 */
public class CData {
    public int icon;
    public String content_label;
    public String description;

    public CData(Context context, int icon_, String content_label_, String description_) {
        icon = icon_;
        content_label = content_label_;
        description = description_;
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
}