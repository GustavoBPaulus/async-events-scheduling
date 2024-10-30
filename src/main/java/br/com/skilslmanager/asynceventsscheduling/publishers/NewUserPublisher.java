package br.com.skilslmanager.asynceventsscheduling.publishers;

import br.com.skilslmanager.asynceventsscheduling.core.events.NewUserEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NewUserPublisher {
    private final ApplicationEventPublisher applicationEventPublisher;

    public void publish(String email) {
        var event = new NewUserEvent(this,email);
        applicationEventPublisher.publishEvent(event);

    }
}
