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
		for(TravisBuild info : travisTorrentInfoProject){
			
			System.out.println(info);
		}

	}

	public static void main( String[] args ){
		SpringApplication.run(App.class, args);
	}
}
