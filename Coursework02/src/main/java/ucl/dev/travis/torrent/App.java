package ucl.dev.travis.torrent;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
		System.out.println("BEGIN- Analysis per language");
		analysisProjectsLanguaje(TravisBuild.language_JAVA);
		System.out.println("END");
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	/**
	 * Algorithm for all projects per language
	 */
	private void analysisProjectsLanguaje(String language) {
		List<Project> projects = travisMapper.getProjectsNamePerLanguage(language);

		Path path = Paths.get("analysis_" + language + ".csv");

		StringBuilder infocsv = new StringBuilder();
		infocsv.append("projectName,loc,fixDurationDays,buildIdFail,teamSize,dateFail,buildIdFix,dateFix\n");

		for (Project project : projects) {
			List<FixDuration> failureFixResult = analysisFailureFixPerProject(project);
			for (FixDuration failureFixInfo : failureFixResult) {
				infocsv.append(failureFixInfo.getCVSformatInformation());
				infocsv.append("\n");
			}

			try {
				Files.write(path, infocsv.toString().getBytes(), CREATE, APPEND);
			} catch (IOException e) {
				e.printStackTrace();
			}
			infocsv = new StringBuilder();
		}

	}

	/**
	 * Algorithm to get the commit frequency. Example: mybatis/mybatis-3
	 * Project: mybatis/mybatis-3; junit-team/junit; gradle/gradle; ruby/ruby;
	 * heroku/heroku
	 */
	private List<FixDuration> analysisFailureFixPerProject(Project project) {
		List<TravisBuild> travisTorrentInfoProject = travisMapper.getDataByProject(project.getGh_project_name());
		boolean failBuild = false;

		List<FixDuration> result = new ArrayList<FixDuration>();

		FixDuration detectedFixDuration = null;
		for (TravisBuild info : travisTorrentInfoProject) {
			if (TravisBuild.FAILED_STATUS.equals(info.getTr_status())
					|| TravisBuild.ERRORED_STATUS.equals(info.getTr_status())) {
				if (!failBuild) {
					failBuild = true;
					detectedFixDuration = new FixDuration();
					detectedFixDuration.setGh_project_name(project.getGh_project_name());
					detectedFixDuration.setBuildFailureId(info.getTr_build_id());
					detectedFixDuration.setTeamSizeFailure(info.getGh_team_size());
					detectedFixDuration.setFailureStart(info.getTr_started_at());
					detectedFixDuration.setLoc(info.getGh_sloc());
				} else {
					continue;
				}
			}
			if (failBuild && TravisBuild.PASSED_STATUS.equals(info.getTr_status())) {
				failBuild = false;
				detectedFixDuration.setBuildFixId(info.getTr_build_id());
				detectedFixDuration.setFailureFix(info.getTr_started_at());
				project.addFixDuration(detectedFixDuration);

				result.add(detectedFixDuration);
			}
		}
		return result;
	}

	/**
	 * Algorithm for analising only one project (Probably outdated version)
	 */
	public void oneProjectAnalysis() {
		Project project = new Project("mybatis/mybatis-3", "Java");
		// projectAnalysisMapper.addProject(project);
		List<FixDuration> result = analysisFailureFixPerProject(project);
		try {
			Path path = Paths.get("analysis.csv");
			StringBuilder infocsv = new StringBuilder();
			infocsv.append("projectName,loc,fixDuration,buildIdFail,teamsize,dateFail,buildIdFix,dateFix\n");
			for (FixDuration fixDuration : result) {
				System.out.println(fixDuration.getCVSformatInformation());
				infocsv.append(fixDuration.getCVSformatInformation());
				infocsv.append("\n");
			}
			Files.write(path, infocsv.toString().getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
