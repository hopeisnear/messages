package com.sabre;

import java.util.Date;

public class Message
{
    private long id;
    private String text;
    private String seat;
    private Date dateTime;
    private int status = -1;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public String getSeat()
    {
        return seat;
    }

    public void setSeat(String seat)
    {
        this.seat = seat;
    }

    public Date getDateTime()
    {
        return dateTime;
    }

    public void setDateTime(Date dateTime)
    {
        this.dateTime = dateTime;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

}
