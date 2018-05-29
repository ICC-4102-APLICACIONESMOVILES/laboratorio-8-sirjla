package cl.magnet.mobileappsexample.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Question {

    @PrimaryKey
    private int uid;

    @ColumnInfo(name = "text")
    private String text;

    @ColumnInfo(name = "type")
    private String type;

    @ForeignKey(entity = Form.class, parentColumns = "uid", childColumns = "form")
    private int form;

    public Question(int uid, String text, String type, int form) {
        this.uid = uid;
        this.text = text;
        this.type = type;
        this.form = form;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getForm() { return form; }

    public void setForm(int form) { this.form = form; }
}
