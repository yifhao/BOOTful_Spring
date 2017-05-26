package com.julysky;

import de.codecentric.boot.admin.notify.LoggingNotifier;
import de.codecentric.boot.admin.notify.Notifier;
import de.codecentric.boot.admin.notify.RemindingNotifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.TimeUnit;

/**
 * Created by haoyifen on 2017/5/3 10:20.
 */
@Configuration
@EnableScheduling
public class NotifierConfiguration {
    private static Logger logger = LoggerFactory.getLogger(NotifierConfiguration.class);

    @Bean
    @Primary
    public RemindingNotifier remindingNotifier() {
        Notifier loggingNotifier = new LoggingNotifier();
        RemindingNotifier remindingNotifier = new RemindingNotifier(loggingNotifier);
        remindingNotifier.setReminderPeriod(TimeUnit.SECONDS.toMillis(1));
        return remindingNotifier;
    }

    //每次如果有应用状态改变, 都会有SpringEvent, 然后都会调用notifier
    //但是这个还可以在发送一次notifier之后, 继续周期性发送, 直到状态UP
    @Scheduled(fixedRate = 10_000L)
    public void remind() {
        remindingNotifier().sendReminders();
    }
}
