package org.example.cuttingdown.common;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class AppResponse {
    private String message;
    private Integer status;
    private List<Object> errors = new LinkedList<>();
    private Object data;

    public static AppResponse success(){
        AppResponse r = new AppResponse();
        r.setStatus(200);
        r.setMessage("default success message");
        return r;
    }
    public static AppResponse success(String message){
        AppResponse r = new AppResponse();
        r.setStatus(200);
        r.setMessage(message);
        return r;
    }
    public static AppResponse failure(Integer statusCode, String message){
        AppResponse r = new AppResponse();
        r.setStatus(500);
        r.setMessage(message);
        return r;
    }
    public static AppResponse success(Object data){
        AppResponse r = new AppResponse();
        r.setStatus(200);
        r.setMessage("default success message");
        r.setData(data);
        return r;
    }
    public static AppResponse success(String message, Object data){
        AppResponse r = new AppResponse();
        r.setStatus(200);
        r.setMessage(message);
        r.setData(data);
        return r;
    }


}
