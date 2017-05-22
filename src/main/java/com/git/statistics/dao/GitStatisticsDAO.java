package com.git.statistics.dao;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

public class GitStatisticsDAO {

	public Map<String, Integer> getGitStatistics() {
		Map<String, Integer> statsMap = new HashMap<>();
		try {
			FileRepositoryBuilder builder = new FileRepositoryBuilder();
			//path for git clone https://github.com/angular/angular.git
			Repository repository = builder.setGitDir(new File("C:/Shiva/JS2017/git/angular/.git"))
					.readEnvironment() // scan environment GIT_* variables
					.findGitDir() // scan up the file system tree
					.build();
			Git git = new Git(repository);
			Iterable<RevCommit> revCommits = git.log().all().call();
			int i = 0;
			Calendar calCurr = Calendar.getInstance();
			calCurr.setTime(new Date());
			int curYear = calCurr.get(Calendar.YEAR);
			for (RevCommit revCommit : revCommits) {
				java.util.Date date= new Date(
						revCommit.getCommitTime() * 1000L);
				Calendar cal = Calendar.getInstance();
			    cal.setTime(date);
			    int year = cal.get(Calendar.YEAR);
			    //Displaying only current year data in the graph
				if(year == curYear){
					SimpleDateFormat dateFormat = new SimpleDateFormat("MMM");
					String month = dateFormat.format(date);
					statsMap.put(month, statsMap.get(month) != null ? statsMap.get(month)+1 : 0);
				}
			}
		} catch (IOException | GitAPIException e) {
			e.printStackTrace();
		}finally{
			return statsMap;
		}

	}
	
}
