package ucl.dev.travis.torrent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import ucl.dev.travis.torrent.bean.Project;
import ucl.dev.travis.torrent.bean.TravisBuild;

@Mapper
public interface TravisBuildMapper {
	@Select("SELECT * FROM travistorrent_27_10_2016 WHERE row = #{torrentId}")
	TravisBuild findByTorrentId(@Param("torrentId") Integer torrentId);
	
	@Select("SELECT * FROM travistorrent_27_10_2016 WHERE gh_project_name = #{projectName} ORDER BY tr_build_id")
	List<TravisBuild> getDataByProject(@Param("projectName") String projectName);
	
	@Select("SELECT DISTINCT gh_project_name, gh_lang FROM travistorrent_27_10_2016 ORDER BY gh_lang")
	List<Project> getProjectsName();

	@Select("SELECT DISTINCT gh_project_name, gh_lang FROM travistorrent_27_10_2016 WHERE gh_lang = #{language}")
	List<Project> getProjectsNamePerLanguage(@Param("language") String language);
}
