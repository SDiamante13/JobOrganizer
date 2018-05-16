package com.diamante.web.daoInterface;

import java.util.Stack;

import com.diamante.web.model.Job;

public interface JobDao {
	public void addJob(Job newJob);
	public Stack<Job> loadJobStack();
	public void deleteJob(int jobNumber);
	public Job getJobByNumber(int jobNumber);
	public void updateJob(Job jobToEdit);

}
