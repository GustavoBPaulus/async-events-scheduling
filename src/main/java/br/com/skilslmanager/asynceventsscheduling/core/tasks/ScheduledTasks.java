package br.com.skilslmanager.asynceventsscheduling.core.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    //FIXED DELAY CONTA O TEMPO DEPOIS DA ULTIMA EXECUÇÃO
    private static final int FIXED_DELAY = 1000;
    private static final int FIXED_RATE = 1000;
    //rodar a cada 5 segundos
    private static final String CRON = "*/5 * * * * *";

    //CRONTAB GURU É UM BOM SITE PARA USAR
    //SPRING-FRAMEWORK/DOCS/CURRENT/JAVADOC

    @Scheduled(cron = CRON)
    public void taskExample(){
        logger.info("Task executada");
    }
}
