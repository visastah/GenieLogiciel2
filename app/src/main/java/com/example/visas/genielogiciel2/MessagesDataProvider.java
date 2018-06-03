package com.example.visas.genielogiciel2;

/**
 * Created by visas on 5/12/18.
 */


public class MessagesDataProvider {

    private String groupInitials;
    private String messageTitle;
    private String messageInfo;
    private String messageTime;
    private boolean messageIsSent;

    public MessagesDataProvider(String groupInitials, String messageTitle,
                                String messageInfo, String messageTime){
        this.groupInitials = groupInitials;
        this.messageTitle = messageTitle;
        this.messageInfo = messageInfo;
        this.messageTime = messageTime;
        messageIsSent = true;
    }

    public MessagesDataProvider(String groupInitials, String messageTitle,
                                String messageInfo, String messageTime, Boolean messageIsSent){
        this.groupInitials = groupInitials;
        this.messageTitle = messageTitle;
        this.messageInfo = messageInfo;
        this.messageTime = messageTime;
        this.messageIsSent = messageIsSent;
    }


    public String getGroupInitials() {
        return groupInitials;
    }

    public void setGroupInitials(String groupInitials) {
        this.groupInitials = groupInitials;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageInfo() {
        return messageInfo;
    }

    public void setMessageInfo(String messageInfo) {
        this.messageInfo = messageInfo;
    }

    public String getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }

    public boolean isMessageIsSent() {
        return messageIsSent;
    }

    public void setMessageIsSent(boolean messageIsSent) {
        this.messageIsSent = messageIsSent;
    }
}

