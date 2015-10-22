package com.sabre.component;

import com.sabre.Message;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MessageServiceImpl implements MessageService
{
    @Override
    public Message getMessage(long id)
    {
        return DBStaticCache.getData().get(id);
    }

    @Override
    public int getMessageCount()
    {
        return DBStaticCache.getData().size();
    }

    @Override
    public List<Message> getMessages()
    {
        return new ArrayList<Message>(DBStaticCache.getData().values());
    }

    @Override public List<Message> deleteAll()
    {
        List<Message> messages = new ArrayList<Message>(DBStaticCache.getData().values());
        DBStaticCache.getData().clear();
        return messages;
    }

    @Override
    public long addMessage(Message message)
    {
        long id = new Date().getTime();
        message.setId(id);
        message.setDateTime(new Date());
        DBStaticCache.getData().put(id, message);
        return id;
    }

    @Override
    public void update(long id, Message data)
    {
        Message message = updateProperties(DBStaticCache.getData().get(id), data);
        message.setDateTime(new Date());
        DBStaticCache.getData().put(id, message);
    }

    @Override public Message delete(long id)
    {
        return DBStaticCache.getData().remove(id);
    }

    private Message updateProperties(Message message, Message from)
    {
        if (from.getText() != null)
        {
            message.setText(from.getText());
        }
        if (from.getSeat() != null)
        {
            message.setSeat(from.getSeat());
        }
        if (from.getStatus() != -1)
        {
            message.setStatus(from.getStatus());
        }
        return message;
    }
}
