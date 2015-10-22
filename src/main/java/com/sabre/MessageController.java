package com.sabre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sabre.component.MessageService;

import java.util.List;

@RestController
@RequestMapping("/app")
public class MessageController
{
    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public long message(@RequestParam(value = "text") String text, @RequestParam(value = "seat") String seat, @RequestParam(value = "status") int status)
    {
        Message message = new Message();
        message.setSeat(seat);
        message.setStatus(status);
        message.setText(text);
        return messageService.addMessage(message);
    }

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    @ResponseBody
    public List<Message> messages()
    {
        return messageService.getMessages();
    }

    @RequestMapping(value = "/messages", method = RequestMethod.DELETE)
    @ResponseBody
    public List<Message> deleteMessages()
    {
        return messageService.deleteAll();
    }

    @RequestMapping(value = "/message/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") long id, @RequestBody(required = true) Message data)
    {
        messageService.update(id, data);
    }

    @RequestMapping(value = "/message/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Message delete(@PathVariable("id") long id)
    {
        return messageService.delete(id);
    }

}
