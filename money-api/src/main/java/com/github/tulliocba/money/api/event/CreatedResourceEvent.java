package com.github.tulliocba.money.api.event;

import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

public class CreatedResourceEvent extends ApplicationEvent {

    private final HttpServletResponse response;
    private final Integer id;

    public CreatedResourceEvent(Object source, HttpServletResponse response, Integer id) {
        super(source);
        this.response = response;
        this.id = id;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public Integer getId() {
        return id;
    }
}
