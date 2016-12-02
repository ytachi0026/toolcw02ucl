package ucl.dev.travis.torrent.mapper;

import org.apache.ibatis.annotations.Mapper;

import ucl.dev.travis.torrent.bean.Project;

@Mapper
public interface ProjectAnalysis {
	
	void addProject(Project project);

}
