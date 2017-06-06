package quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class Quartz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SchedulerFactory shedFact = new StdSchedulerFactory();
        try {
            Scheduler scheduler = shedFact.getScheduler();
            scheduler.start();
            JobDetail job = JobBuilder.newJob(ValidadorJob.class)
                    .withIdentity("validadorJOB", "grupo01")
                    .build();
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("validadorTRIGGER", "grupo01")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?"))
                    .build();
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
