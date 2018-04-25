package com.pzh.scheduling;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.pzh.scheduling")
@EnableScheduling
public class SchedulingTaskConfig {

}
