package ucl.dev.travis.torrent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ucl.dev.travis.torrent.bean.Project;
import ucl.dev.travis.torrent.bean.TravisBuild;
import ucl.dev.travis.torrent.mapper.TravisBuildMapper;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App implements CommandLineRunner{
	
	@Autowired
	TravisBuildMapper travisMapper;
	
	public void run(String... arg0) throws Exception {
		//Getting the name of the projects and its languages
//		List<Project> projects = travisMapper.getProjectsName();
//		for(Project project : projects){
//			System.out.println(project);
//		}
		
		//Algorithm to get the commit frequency
		//Project: mybatis/mybatis-3
		List<TravisBuild> travisTorrentInfoProject = travisMapper.getDataByProject("mybatis/mybatis-3");
		/*
		 * Get the first build fail!
		 * 
		 */
		boolean failBuild = false;
		
		System.out.println("ANALYSIS");
		for(TravisBuild info : travisTorrentInfoProject){
			if("master".equals(info.getGit_branch()) && !info.getGh_is_pr()){
				if("failed".equals(info.getTr_status())){
					if(!failBuild){
						failBuild = true;
						System.out.println("Begin FAILURE: "+info.infoCommit());
					} else {
						continue;
					}
				}
				if(failBuild && "passed".equals(info.getTr_status())){
					System.out.println("Fix FAILURE: "+info.infoCommit());
					failBuild = false;
				}
			}
		}
	}

	public static void main( String[] args ){
		SpringApplication.run(App.class, args);
	}
}
