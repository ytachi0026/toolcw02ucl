package ucl.dev.travis.torrent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		System.out.println(travisMapper.findByTorrentId(1304109));
	}

	public static void main( String[] args ){
		SpringApplication.run(App.class, args);
	}
}
