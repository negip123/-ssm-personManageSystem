package com.neuedu.print.model;

import java.util.Date;

public class Message {
    private Integer id;

    private Integer qq;

    private String text;

    private Date date;

    public Message( Integer qq, String text, Date date) {
      
        this.qq = qq;
        this.text = text;
        this.date = date;
    }
    public Message(Integer id, Integer qq, String text, Date date) {
        this(qq,text,date);
    	this.id = id;
       
    }

    public Message() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQq() {
        return qq;
    }

    public void setQq(Integer qq) {
        this.qq = qq;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}