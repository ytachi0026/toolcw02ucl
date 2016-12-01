package ucl.dev.travis.torrent.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class Util implements Serializable{
	private static SimpleDateFormat dateParse = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public static String niceFormatDate(Date date){
		return dateParse.format(date);
	}
	
}
