package ucl.dev.travis.torrent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ucl.dev.travis.torrent.bean.FixDuration;
import ucl.dev.travis.torrent.bean.Project;
import ucl.dev.travis.torrent.bean.TravisBuild;
import ucl.dev.travis.torrent.mapper.ProjectAnalysisMapper;
import ucl.dev.travis.torrent.mapper.TravisBuildMapper;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App implements CommandLineRunner {

	@Autowired
	TravisBuildMapper travisMapper;

	@Autowired
	ProjectAnalysisMapper projectAnalysisMapper;

	public void run(String... arg0) throws Exception {
		/*
		 * Analysis for one project
		 */
		Project project = new Project("mybatis/mybatis-3", "Java");
		projectAnalysisMapper.addProject(project);
		analysisPerProject(project);
		//analysisAllProjects();
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	/**
	 * Algorithm for all projects
	 */
	private void analysisAllProjects() {
		List<Project> projects = travisMapper.getProjectsName();
		for (Project project : projects) {
			projectAnalysisMapper.addProject(project);
			analysisPerProject(project);
		}
	}

	/**
	 * Algorithm to get the commit frequency. Example: mybatis/mybatis-3
	 * Project: mybatis/mybatis-3; junit-team/junit; gradle/gradle; ruby/ruby;
	 * heroku/heroku
	 */
	private void analysisPerProject(Project project) {
		List<TravisBuild> travisTorrentInfoProject = travisMapper.getDataByProject(project.getGh_project_name());
		boolean failBuild = false;
		FixDuration detectedFixDuration = null;
		for (TravisBuild info : travisTorrentInfoProject) {
			if (TravisBuild.FAILED_STATUS.equals(info.getTr_status())
					|| TravisBuild.ERRORED_STATUS.equals(info.getTr_status())) {
				if (!failBuild) {
					failBuild = true;
					detectedFixDuration = new FixDuration();
					detectedFixDuration.setGh_project_name(project.getGh_project_name());
					detectedFixDuration.setFailureStart(info.getTr_started_at());
					detectedFixDuration.setLoc(info.getGh_sloc());
				} else {
					continue;
				}
			}
			if (failBuild && TravisBuild.PASSED_STATUS.equals(info.getTr_status())) {
				failBuild = false;
				detectedFixDuration.setFailureFix(info.getTr_started_at());
				project.addFixDuration(detectedFixDuration);
				projectAnalysisMapper.addFixDurationPorject(detectedFixDuration);
			}
		}
	}
}
