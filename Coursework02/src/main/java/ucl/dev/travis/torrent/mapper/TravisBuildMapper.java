package ucl.dev.travis.torrent.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import ucl.dev.travis.torrent.bean.TravisBuild;

@Mapper
public interface TravisBuildMapper {
	@Select("SELECT * FROM travistorrent_27_10_2016 WHERE row = #{torrentId}")
	TravisBuild findByTorrentId(@Param("torrentId") Integer torrentId);
}
