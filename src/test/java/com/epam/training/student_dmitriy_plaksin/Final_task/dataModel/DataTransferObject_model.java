package com.epam.training.student_dmitriy_plaksin.Final_task.dataModel;

public class DataTransferObject_model {
    private String page_title;
    private String login_username;
    private String login_password;
    private String message_text;

    public DataTransferObject_model() {
    }

    public DataTransferObject_model(String s, String s1, String s2, String s3) {
        this.page_title=s;
        this.login_username=s1;
        this.login_password=s2;
        this.message_text=s3;
    }

    public String getPage_title() {
        return page_title;
    }

    public String getLogin_username() {
        return login_username;
    }

    public String getLogin_password() {
        return login_password;
    }

    public String getMessage_text() {
        return message_text;
    }

    public void setPage_title(String page_title) {
        this.page_title = page_title;
    }

    public void setLogin_username(String login_username) {
        this.login_username = login_username;
    }

    public void setLogin_password(String login_password) {
        this.login_password = login_password;
    }

    public void setMessage_text(String message_text) {
        this.message_text = message_text;
    }
}


