package com.example.chainboutique.adib;

import java.time.LocalDateTime;

public class Announcement {
    private String announcementID;  // Primary Key (Unique)
    private String title , message;

    @Override
    public String toString() {
        return "Announcement{" +
                "announcementID='" + announcementID + '\'' +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdOn=" + createdOn +
                '}';
    }

    public String getAnnouncementID() {
        return announcementID;
    }

    public void setAnnouncementID(String announcementID) {
        this.announcementID = announcementID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public Announcement(String announcementID, String title, String message, String createdBy, LocalDateTime createdOn) {
        this.announcementID = announcementID;
        this.title = title;
        this.message = message;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
    }

    private String createdBy;       // Foreign Key
    private LocalDateTime createdOn;





}

