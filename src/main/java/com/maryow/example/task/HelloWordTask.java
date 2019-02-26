package com.maryow.example.task;



import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class HelloWordTask {
	private static Logger logger = Logger.getLogger(HelloWordTask.class);
	
	@Autowired
	private JobLauncher  launcher;

	@Autowired
	@Qualifier("helloWorldJob")
	private Job helloWorldJob;

	private JobExecution execution;

	public void run() {
		try {
			execution = launcher.run(helloWorldJob, new JobParameters());
			logger.info("Execution status: " + execution.getStatus());
			System.out.println("Execution status: " + execution.getStatus());
		} catch (JobExecutionAlreadyRunningException e) {
			e.printStackTrace();
		} catch (JobRestartException e) {
			e.printStackTrace();
		} catch (JobInstanceAlreadyCompleteException e) {
			e.printStackTrace();
		} catch (JobParametersInvalidException e) {
			e.printStackTrace();
		}
	}
}
