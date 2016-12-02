package ucl.dev.travis.torrent.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import ucl.dev.travis.torrent.bean.FixDuration;
import ucl.dev.travis.torrent.bean.Project;

@Mapper
public interface ProjectAnalysisMapper {
	
	@Insert("INSERT INTO project VALUES(#{gh_project_name}, #{gh_lang})")
	void addProject(Project project);

	@Insert("INSERT INTO fix_duration VALUES(#{gh_project_name}, #{loc}, #{durationInDays}, #{failureStart}, #{failureFix})")
	void addFixDurationPorject(FixDuration fixDuration);

}
