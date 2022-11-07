package com.k2web.board.model;

import lombok.Data;

import java.util.Calendar;

@Data
public class UserDTO {
    private int userId;
    private String username;
    private String password;
    private String nickname;
    private Calendar updatedDate;
    private Calendar createdDate;
}
