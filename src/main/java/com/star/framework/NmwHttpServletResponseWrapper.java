package com.star.framework;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;


/**
 * @author yuwei
 */
public class NmwHttpServletResponseWrapper extends HttpServletResponseWrapper {
    private String charResult;

    /**
     * Constructs a response adaptor wrapping the given response.
     *
     * @param response
     * @throws IllegalArgumentException if the response is null
     */
    public NmwHttpServletResponseWrapper(HttpServletResponse response) {
        super(response);
    }


    public String getCharResult() {
        return charResult;
    }

    public void setCharResult(String charResult) {
        this.charResult = charResult;
    }
}
