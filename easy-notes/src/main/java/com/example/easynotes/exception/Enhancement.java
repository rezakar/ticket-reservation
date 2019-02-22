package com.example.easynotes.exception;

import javax.persistence.*;

import com.example.easynotes.model.Application;
import com.example.easynotes.model.Release;
import com.example.easynotes.model.Ticket;

@Entity
public class Enhancement extends Ticket{
	// private Boolean duplicate;
    private String priority;

    public Enhancement() {
    }

    public Enhancement(String priority) {
      //  this.duplicate = duplicate;
        this.priority = priority;
    }

    public Enhancement(Integer id, String title, String description, Application application, Release release, String status, String priority) {
        super(id, title, description, application, release, status);
       // this.duplicate = duplicate;
        this.priority = priority;
    }

//    public Boolean getDuplicate() {
//        return duplicate;
//    }

//    public void setDuplicate(Boolean duplicate) {
//        this.duplicate = duplicate;
//    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
