package br.com.skilslmanager.asynceventsscheduling.core.config;

import jakarta.annotation.Nullable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {
    private static final int CORE_POOL_SIZE = 2;
    private static final int MAX_POOL_SIZE = 4;
    private static final int QUEUE_CAPACITY = 10;
    private static final String THREAD_NAME_PREFIX = "AsyncExecutor-";

    @Override
    @Nullable
    public Executor getAsyncExecutor() {
        var executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(CORE_POOL_SIZE);
        executor.setMaxPoolSize(MAX_POOL_SIZE);
        executor.setQueueCapacity(QUEUE_CAPACITY);
        executor.setThreadNamePrefix(THREAD_NAME_PREFIX);
        executor.initialize();
        return executor;
    }
    @Bean
    public ApplicationEventMulticaster applicationEventMulticaster() {
        var eventMulticaster = new SimpleApplicationEventMulticaster();
        eventMulticaster.setTaskExecutor(getAsyncExecutor());
        return eventMulticaster;
    }

}
