package com.connorcode.chat;

public class Response {
    public ResponseType type;
    public Object value;

    public Response(ResponseType type, Object value) {
        this.type = type;
        this.value = value;
    }

    public enum ResponseType {
        None,
        BasicText,
        Exit
    }
}