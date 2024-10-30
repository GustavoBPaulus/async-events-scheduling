package br.com.skilslmanager.asynceventsscheduling.core.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class MailService {
    private final Logger log = LoggerFactory.getLogger(MailService.class);
    private static final Duration DELAY = Duration.ofSeconds(2);

    @Async
    public void send(String to, String subject, String body) {
        try {
            Thread.sleep(2);
        }catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        log.info("Email enviado para {}", to);
    }

    @Async
    public void sendAsync(String to, String subject, String body) {
      try {
          Thread.sleep(2);
      }catch (InterruptedException e) {
          log.error(e.getMessage());
      }
        log.info("Email enviado para {}", to);
    }

}
