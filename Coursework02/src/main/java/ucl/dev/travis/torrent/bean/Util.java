package ucl.dev.travis.torrent.bean;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class Util implements Serializable{
	private static SimpleDateFormat dateParse = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private static DecimalFormat fiveDecimalFormat = new DecimalFormat("#.#####");
	
	
	public static String niceFormatDate(Date date){
		return dateParse.format(date);
	}

	public static String fiveDecimalFormat(Double value){
		return fiveDecimalFormat.format(value);
	}
	
}
