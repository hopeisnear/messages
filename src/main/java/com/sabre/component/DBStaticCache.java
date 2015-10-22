package com.sabre.component;

import com.sabre.Message;

import java.util.HashMap;
import java.util.Map;

public class DBStaticCache
{
    private static Map<Long, Message> data = new HashMap<Long, Message>();

    public static Map<Long, Message> getData()
    {
        return data;
    }

}
