package ucl.dev.travis.torrent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ucl.dev.travis.torrent.bean.FixDuration;
import ucl.dev.travis.torrent.bean.Project;
import ucl.dev.travis.torrent.bean.TravisBuild;
import ucl.dev.travis.torrent.mapper.TravisBuildMapper;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App implements CommandLineRunner {

	@Autowired
	TravisBuildMapper travisMapper;

	public void run(String... arg0) throws Exception {
		// Getting the name of the projects and its languages
		// List<Project> projects = travisMapper.getProjectsName();
		// for(Project project : projects){
		// System.out.println(project);
		// }

		// Algorithm to get the commit frequency
		// Project: mybatis/mybatis-3; junit-team/junit; gradle/gradle;
		// ruby/ruby; heroku/heroku
		List<TravisBuild> travisTorrentInfoProject = travisMapper.getDataByProject("heroku/heroku");
		/*
		 * Get the first build fail!
		 * 
		 */

		Project project = new Project("mybatis/mybatis-3", "Java");
		boolean failBuild = false;
		FixDuration detectedFixDuration = null;

		System.out.println("ANALYSIS");
		for (TravisBuild info : travisTorrentInfoProject) {
			if (TravisBuild.FAILED_STATUS.equals(info.getTr_status())
					|| TravisBuild.ERRORED_STATUS.equals(info.getTr_status())) {
				if (!failBuild) {
					System.out.println("Begin FAILURE: " + info.infoCommit());
					failBuild = true;
					detectedFixDuration = new FixDuration();
					detectedFixDuration.setFailureStart(info.getTr_started_at());
					detectedFixDuration.setLoc(info.getGh_sloc());
				} else {
					continue;
				}
			}
			if (failBuild && TravisBuild.PASSED_STATUS.equals(info.getTr_status())) {
				System.out.println("Fix FAILURE: " + info.infoCommit());
				failBuild = false;
				detectedFixDuration.setFailureFix(info.getTr_started_at());
				project.addFixDuration(detectedFixDuration);
				System.out.println("\n");
			}
		}
		System.out.println(project);
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
