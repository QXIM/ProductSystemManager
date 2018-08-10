package com.neuedu.Aspect;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class LogBean implements Serializable {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    private int id;
    private int user_id;
    private String op;
    private  Long create_time;

    public LogBean(int id, int user_id, String op, Long create_time) {
        this.id = id;
        this.user_id = user_id;
        this.op = op;
        this.create_time = create_time;
    }

    public LogBean() {

    }

    public LogBean(int user_id, String op) {
        this.user_id = user_id;
        this.op = op;
    }
}
