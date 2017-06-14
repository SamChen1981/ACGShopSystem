package com.acg_shop.entity;

/**
 * Message
 * Created by mac_zly on 2017/6/7.
 */

public class Message {

    String from;
    String message;
    Integer time;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Message{" +
                "from='" + from + '\'' +
                ", message='" + message + '\'' +
                ", time=" + time +
                '}';
    }
}
