package com.neuedu.print.model;

import java.util.Date;

public class Notice {
    private Integer id;

    private String noticetext;

    private Date noticedate;

    private String remark;

    public Notice(String noticetext, Date noticedate, String remark) {
        this.noticetext = noticetext;
        this.noticedate = noticedate;
        this.remark = remark;
    }
    public Notice(Integer id, String noticetext, Date noticedate, String remark) {
        this(noticetext,noticedate,remark);
    	this.id = id;
       
    }

    public Notice() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoticetext() {
        return noticetext;
    }

    public void setNoticetext(String noticetext) {
        this.noticetext = noticetext == null ? null : noticetext.trim();
    }

    public Date getNoticedate() {
        return noticedate;
    }

    public void setNoticedate(Date noticedate) {
        this.noticedate = noticedate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}