package com.nodz.sqlliteprac;

public class NoteModel {

    String note_text,id;

    public NoteModel() {
    }

    public NoteModel(String note_text, String id) {
        this.note_text = note_text;
        this.id = id;
    }

    public String getNote_text() {
        return note_text;
    }

    public void setNote_text(String note_text) {
        this.note_text = note_text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
