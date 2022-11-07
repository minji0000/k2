package com.k2web.board.model;

import lombok.Data;

import java.util.Calendar;

@Data
public class BoardDTO {
    private int boardId;
    private int writerId;
    private String title;
    private String content;
    private Calendar updatedDate;
    private Calendar writtenDate;
}
