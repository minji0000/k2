package com.k2web.board.model;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Calendar;

@Data
public class BoardDTO {
    private int boardId;
    private int writerId;
    private String title;
    private String content;
    private Calendar updatedDate;
    private Calendar writtenDate;

    public void setWrittenDate(Timestamp writtenDate) {
        this.writtenDate = Calendar.getInstance();
        this.writtenDate.setTime(writtenDate);
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = Calendar.getInstance();
        this.updatedDate.setTime(updatedDate);
    }
}
