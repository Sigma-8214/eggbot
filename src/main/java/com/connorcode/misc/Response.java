package com.connorcode.misc;

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