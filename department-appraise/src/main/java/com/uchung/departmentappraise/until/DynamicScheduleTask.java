package com.uchung.departmentappraise.until;

import com.uchung.departmentappraise.mapper.PersonnelMapper;
import com.uchung.departmentappraise.mapper.SalaryMapper;
import com.uchung.departmentappraise.model.Personnel;
import com.uchung.departmentappraise.model.Salary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Date;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class DynamicScheduleTask implements SchedulingConfigurer {
    @Autowired      //注入mapper
    @SuppressWarnings("all")
    SalaryMapper salaryMapper;
    @Autowired
    PersonnelMapper personnelMapper;
    /**
     * 执行定时任务
     * @param taskRegistrar
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(
                //1.添加任务内容(Runnable)
                () -> {
                    List<Personnel> list = personnelMapper.selectAllByStatus(true);
                    salaryMapper.insertMany(list,new BigDecimal(2000),new Date(),false);
                },
                //2.设置执行周期(Trigger)
                triggerContext -> {
                    //2.1 设定时长周期
                    String cron = "0 0 0 10 * ?";//秒分时日月
                    //2.2 合法性校验.
                    if (StringUtils.isEmpty(cron)) {
                        // Omitted Code ..
                    }
                    //2.3 返回执行周期(Date)
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );
    }
}
