package com.github.tulliocba.money.api.listener;

import com.github.tulliocba.money.api.event.CreatedResourceEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Component
public class CreatedResourceListener implements ApplicationListener<CreatedResourceEvent> {

    @Override
    public void onApplicationEvent(CreatedResourceEvent createdResourceEvent) {
        HttpServletResponse response = createdResourceEvent.getResponse();
        Integer id = createdResourceEvent.getId();

        buildHttpHeaderLocation(response, id);
    }

    private void buildHttpHeaderLocation(HttpServletResponse response, Integer id) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(id)
                .toUri();

        response.setHeader("Location", uri.toASCIIString());
    }
}
