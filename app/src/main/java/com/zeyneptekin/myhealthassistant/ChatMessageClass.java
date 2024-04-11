package com.zeyneptekin.myhealthassistant;
import java.util.Date;

public class ChatMessageClass {
    private String content;
    private Date date;
    private Boolean isUserMessage;
    ChatMessageClass(){
        //for firebase
    }
    ChatMessageClass(String content, Boolean isUserMessage){
        this.content = content;
        this.date = new Date(); // Anlık tarih ve saat değerini al
        this.isUserMessage = isUserMessage;
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
