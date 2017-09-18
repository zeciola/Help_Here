/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quartz;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Web application lifecycle listener.
 *
 * @author Diego
 */
public class ListenerQuartz implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        SchedulerFactory shedFact = new StdSchedulerFactory();
        try {
            Scheduler scheduler = shedFact.getScheduler();
            scheduler.start();
            
            JobDetail job = JobBuilder.newJob(AvaliarEvento.class)
                    .withIdentity("validadorJOB", "grupo02")
                    .build();
            
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("validadorTRIGGER", "grupo02")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0/50 * * * * ?"))
                    .build();
            
            scheduler.scheduleJob(job, trigger);
            
        } catch (SchedulerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
