package com.sabre.component;

import com.sabre.Message;

import java.util.List;

public interface MessageService
{
    Message getMessage(long id);

    int getMessageCount();

    List<Message> getMessages();

    List<Message> deleteAll();

    long addMessage(Message message);

    void update(long id, Message data);

    Message delete(long id);
}
