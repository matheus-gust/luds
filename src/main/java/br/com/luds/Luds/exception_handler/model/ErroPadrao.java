package br.com.luds.Luds.exception_handler.model;

import java.io.Serializable;

public class ErroPadrao implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long timeStamp;
    private Integer status;
    private String msg;
    private String message;
    private String path;
    private boolean tratado;

    public ErroPadrao(Long timeStamp, Integer status, String msg, String message, String path, boolean tratado) {
        super();
        this.timeStamp = timeStamp;
        this.status = status;
        this.msg = msg;
        this.message = message;
        this.path = path;
        this.tratado = tratado;
    }
    public Long getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
}
