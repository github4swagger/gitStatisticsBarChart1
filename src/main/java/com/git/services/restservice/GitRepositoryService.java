package com.git.services.restservice;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.git.statistics.dao.GitStatisticsDAO;

@Path("/gitRepoStatistics")
public class GitRepositoryService {
	GitStatisticsDAO dao = new GitStatisticsDAO();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response gitStats() {
		Map<String,Integer> statsMap = dao.getGitStatistics();
		return Response.status(Response.Status.OK).entity(statsMap).build();	
	}
}
