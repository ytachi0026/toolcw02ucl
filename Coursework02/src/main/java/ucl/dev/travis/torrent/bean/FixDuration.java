package ucl.dev.travis.torrent.bean;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class FixDuration implements Serializable {

	private Integer loc;
	private Integer durationInDays;

	private Date failureStart;
	private Date failureFix;

	public void calculateDaysFixDuration(){
		durationInDays = (int)((failureFix.getTime() - failureStart.getTime()) / (1000 *60 * 60 *24));
	}
	
	
	public Integer getLoc() {
		return loc;
	}

	public void setLoc(Integer loc) {
		this.loc = loc;
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

	@Override
	public String toString() {
		return "FixDuration [loc=" + loc + ", durationInDays=" + durationInDays + ", failureStart=" + failureStart
				+ ", failureFix=" + failureFix + "]";
	}

}
