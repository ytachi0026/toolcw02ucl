package ucl.dev.travis.torrent.bean;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class FixDuration implements Serializable {

	private String gh_project_name;
	private Integer loc;
	private Integer durationInDays;

	private String buildFailureId;
	private Date failureStart;
	private Integer teamSizeFailure;
	
	
	private String buildFixId;
	private Date failureFix;
	
	
	private Double participationRate;

	public void calculateDaysFixDuration(){
		durationInDays = (int)((failureFix.getTime() - failureStart.getTime()) / (1000 *60 * 60 *24));
	}
	
	public void calculateParticipationRate(){
		if(teamSizeFailure > 0){
			participationRate = (double) durationInDays / teamSizeFailure;
		} else {
			participationRate = 0.0;
		}
	}

	public String getGh_project_name() {
		return gh_project_name;
	}


	public void setGh_project_name(String gh_project_name) {
		this.gh_project_name = gh_project_name;
	}


	public Integer getLoc() {
		return loc;
	}

	public void setLoc(Integer loc) {
		this.loc = loc;
	}

	public String getBuildFailureId() {
		return buildFailureId;
	}


	public void setBuildFailureId(String buildFailureId) {
		this.buildFailureId = buildFailureId;
	}


	public String getBuildFixId() {
		return buildFixId;
	}


	public void setBuildFixId(String buildFixId) {
		this.buildFixId = buildFixId;
	}


	public Integer getDurationInDays() {
		return durationInDays;
	}

	public void setDurationInDays(Integer durationInDays) {
		this.durationInDays = durationInDays;
	}

	public Date getFailureStart() {
		return failureStart;
	}

	public void setFailureStart(Date failureStart) {
		this.failureStart = failureStart;
	}

	public Date getFailureFix() {
		return failureFix;
	}

	public void setFailureFix(Date failureFix) {
		this.failureFix = failureFix;
	}

	public Integer getTeamSizeFailure() {
		return teamSizeFailure;
	}


	public void setTeamSizeFailure(Integer teamSizeFailure) {
		this.teamSizeFailure = teamSizeFailure;
	}


	@Override
	public String toString() {
		return "FixDuration [gh_project_name=" + gh_project_name + ", loc=" + loc + ", durationInDays=" + durationInDays
				+ ", buildFailureId=" + buildFailureId + ", failureStart=" + failureStart + ", teamSizeFailure="
				+ teamSizeFailure + ", buildFixId=" + buildFixId + ", failureFix=" + failureFix + ", participationRate="
				+ participationRate + "]";
	}
	
	public String getCVSformatInformation(){
		StringBuilder result = new StringBuilder();
		
		result.append(gh_project_name);
		result.append(",");
		result.append(loc);
		result.append(",");
		result.append(durationInDays);
		result.append(",");
		result.append(buildFailureId);
		result.append(",");
		result.append(teamSizeFailure);
		result.append(",");
		result.append(Util.niceFormatDate(failureStart));
		result.append(",");
		result.append(buildFixId);
		result.append(",");
		result.append(Util.niceFormatDate(failureFix));
		result.append(",");
		result.append(Util.fiveDecimalFormat(participationRate));
		
		return result.toString();
	}
	

}
