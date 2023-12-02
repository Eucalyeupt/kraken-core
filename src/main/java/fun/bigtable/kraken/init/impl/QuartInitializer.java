package fun.bigtable.kraken.init.impl;

import fun.bigtable.kraken.init.AbstractInitializer;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.impl.matchers.GroupMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class QuartInitializer extends AbstractInitializer {
    @Resource
    SchedulerFactoryBean schedulerFactoryBean;

    private static final String JOB_GROUP = "workOrder-jobGroup";

    private static final Logger log = LoggerFactory.getLogger(QuartInitializer.class);

    @Override
    public void init() {
        try {
            log.info("重置quartz任务");
            Scheduler scheduler = schedulerFactoryBean.getScheduler();

            log.info("查询任务组内的所有任务，并终止所有任务");
            List<JobKey> jobKeys = new ArrayList<>(scheduler.getJobKeys(GroupMatcher.groupEquals(JOB_GROUP)));

            log.info("停止触发器");
            scheduler.resumeTriggers(GroupMatcher.groupEquals(JOB_GROUP));

            log.info("移除触发器");
            scheduler.unscheduleJobs(new ArrayList<>(scheduler.getTriggerKeys(GroupMatcher.groupEquals(JOB_GROUP))));

            log.info("删除任务");
            scheduler.deleteJobs(jobKeys);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

    }

    public String module(){
        return "定时任务";
    }
}
