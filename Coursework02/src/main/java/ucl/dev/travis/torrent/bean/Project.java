package ucl.dev.travis.torrent.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Project implements Serializable{

	private String gh_project_name;
	private String gh_lang;
	private List<FixDuration> durationOfFix;

	public Project (String name, String lang){
	    gh_project_name = name;
	    gh_lang = lang;
	    durationOfFix = new ArrayList<FixDuration>();
	}
	
	
	public String getGh_project_name() {
		return gh_project_name;
	}
	public void setGh_project_name(String gh_project_name) {
		this.gh_project_name = gh_project_name;
	}
	public String getGh_lang() {
		return gh_lang;
	}
	public void setGh_lang(String gh_lang) {
		this.gh_lang = gh_lang;
	}
	
	public void addFixDuration (FixDuration fixDuration){
		fixDuration.calculateDaysFixDuration();
		System.out.println(fixDuration);
		durationOfFix.add(fixDuration);
	}
	
	
	@Override
	public String toString() {
		return "Project [gh_project_name=" + gh_project_name + ", gh_lang=" + gh_lang + ", durationOfFix="
				+ durationOfFix + "]";
	}
	
}
