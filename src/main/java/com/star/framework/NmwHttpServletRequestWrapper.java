package com.star.framework;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;


/**
 * @author yuwei
 */
public class NmwHttpServletRequestWrapper extends HttpServletRequestWrapper {
    private String uuid;
    private String utype;
    private String accessLogId;

    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request
     * @throws IllegalArgumentException if the request is null
     */
    public NmwHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }



    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public String getUtype() {
        return utype;
    }
    public void setUtype(String utype) {
        this.utype = utype;
    }
    public String getAccessLogId() {
        return accessLogId;
    }
    public void setAccessLogId(String accessLogId) {
        this.accessLogId = accessLogId;
    }
}
