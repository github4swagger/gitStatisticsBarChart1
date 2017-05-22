package com.git.services.restservice;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class RestApplicationConfig extends Application{

	@Override
	public Set<Class<?>> getClasses() {
		
		 Set<Class<?>>  classes = new HashSet <Class<?>>();
		 classes.add(GitRepositoryService.class);
		return classes;
	}

}
