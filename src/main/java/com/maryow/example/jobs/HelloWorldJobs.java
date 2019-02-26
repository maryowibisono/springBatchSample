package com.maryow.example.jobs;

import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class HelloWorldJobs implements Tasklet {
	
	private static Logger logger = Logger.getLogger(HelloWorldJobs.class);

	@Override
	public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
		logger.info("JOBS START");		
		for(int i=0; i<=10; i++) {
			System.out.print("Jobs Ke : " + i);
			logger.info("Jobs Ke : " + i);
		}
		return RepeatStatus.FINISHED;
	}

}
