package com.connorcode;

public class Response {
    ResponseType type;
    Object value;

    public enum ResponseType {
        BasicText
    }
}