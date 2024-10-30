package br.com.skilslmanager.asynceventsscheduling.core.listeners;

import br.com.skilslmanager.asynceventsscheduling.core.events.NewUserEvent;
import br.com.skilslmanager.asynceventsscheduling.core.services.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GlobalListener {
    private final MailService mailService;

    @EventListener
    private void handleNewUserEvent(NewUserEvent event) {
        var email = event.getEmail();
        mailService.send(email, "E-mail pelo evento","Corpo do e-mail" );
    }
}
