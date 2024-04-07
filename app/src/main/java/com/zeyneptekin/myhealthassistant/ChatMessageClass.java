package com.zeyneptekin.myhealthassistant;
import java.util.Date;

public class ChatMessageClass {
    private String content;
    private Date date;
    private Boolean isUserMessage;
    ChatMessageClass(){

    }
    ChatMessageClass(String content){
        this.content = content;
        this.date = new Date(); // Anlık tarih ve saat değerini al
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getIsUserMessage() {
        return isUserMessage;
    }

    public void setIsUserMessage(Boolean userMessage) {
        isUserMessage = userMessage;
    }
}
