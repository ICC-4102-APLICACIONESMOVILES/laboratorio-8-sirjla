package cl.magnet.mobileappsexample.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Answer {

    @PrimaryKey
    private int uid;

    @ColumnInfo(name = "text")
    private String text;

    @ForeignKey(entity = Question.class, parentColumns = "uid", childColumns = "question")
    private int question;

    public Answer(int uid, String text, int question) {
        this.uid = uid;
        this.text = text;
        this.question = question;
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

    public int getQuestion() { return question; }

    public void setQuestion(int question) { this.question = question; }
}
