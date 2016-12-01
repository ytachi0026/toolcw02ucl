package ucl.dev.travis.torrent.bean;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@SuppressWarnings("serial")
public class TravisBuild implements Serializable{

	private BigInteger row;//Unique identifier for a build job in TravisTorrent
	private String git_commit;//SHA1 Hash of the commit which triggered this build (should be unique world-wide)
	private String git_branch;//Branch git_commit was committed on
	private String git_commits;//All commits included in the push that triggered the build, minus the built commit
	private String gh_project_name;//Project name on GitHub (in format user/repository)
	private Boolean gh_is_pr;//Whether this build was triggered as part of a pull request on GitHub
	private Date gh_first_commit_created_at;//Timestamp of first commit in the push that triggered the build
	private Integer gh_team_size;//Size of the team contributing to this project within 3 months of last commit
	public void setGit_commits(String git_commits) {
		this.git_commits = git_commits;
	}
	public void setTr_failed_tests(String tr_failed_tests) {
		this.tr_failed_tests = tr_failed_tests;
	}
	private Integer gh_src_churn;//How much (lines) production code changed by the new commits in this build
	private Integer gh_test_churn;//How much (lines) test code changed by the new commits in this build
	private Integer gh_files_added;//Number of files added by the new commits in this build
	private Integer gh_files_deleted;//Number of files deleted by the new commits in this build
	private Integer gh_files_modified;//Number of files modified by the new commits in this build
	private Integer gh_tests_added;//Lines of testing code added by the new commits in this build
	private Integer gh_tests_deleted;//Lines of testing code deleted by the new commits in this build
	private Integer gh_src_files;//Lines of testing code deleted by the new commits in this build
	private Integer gh_sloc;//Number of executable production source lines of code, in the entire repository
	private Double gh_test_lines_per_kloc;//Test density. Number of lines in test cases per 1,000 gh_sloc
	private Double gh_test_cases_per_kloc;//Test density. Number of test cases per 1,000 gh_sloc
	private String tr_build_id;//Unique build ID on Travis
	private String tr_status;//Build status (pass, fail, errored, canceled)
	private Integer tr_duration;//Overall duration of the build, in seconds
	private Date tr_started_at;//Start of the build process
	private Integer tr_build_number;//Build number in the project
	private String tr_lan;//Language of the build, as recognized by BUILDLOGANALYZER
	private Integer	tr_tests_ok;// If available (depends on tr_frameworks and tr_analyzer): Number of tests passed
	private Integer tr_tests_fail;//If available (depends on tr_frameworks and tr_analyzer): Number of tests failed 
	private Integer tr_tests_run;//If available (depends on tr_frameworks and tr_analyzer): Number of tests were run as part of this build 
	private Integer tr_tests_skipped;//If available (depends on tr_frameworks and tr_analyzer): Number of tests were skipped or ignored in the build 
	private String tr_failed_tests;//All tests that failed in this build
	private Boolean tr_tests_ran;//Whether tests ran in this build
	private Boolean tr_tests_failed;//tr_tests_failed
	
	
	
	public BigInteger getRow() {
		return row;
	}
	public void setRow(BigInteger row) {
		this.row = row;
	}
	public String getGh_project_name() {
		return gh_project_name;
	}
	public void setGh_project_name(String gh_project_name) {
		this.gh_project_name = gh_project_name;
	}
	public String getGit_commit() {
		return git_commit;
	}
	public void setGit_commit(String git_commit) {
		this.git_commit = git_commit;
	}
	public String getGit_branch() {
		return git_branch;
	}
	public void setGit_branch(String git_branch) {
		this.git_branch = git_branch;
	}
	public Boolean getGh_is_pr() {
		return gh_is_pr;
	}
	public void setGh_is_pr(Boolean gh_is_pr) {
		this.gh_is_pr = gh_is_pr;
	}
	public Date getGh_first_commit_created_at() {
		return gh_first_commit_created_at;
	}
	public void setGh_first_commit_created_at(Date gh_first_commit_created_at) {
		this.gh_first_commit_created_at = gh_first_commit_created_at;
	}
	public Integer getGh_team_size() {
		return gh_team_size;
	}
	public void setGh_team_size(Integer gh_team_size) {
		this.gh_team_size = gh_team_size;
	}
	public Integer getGh_src_churn() {
		return gh_src_churn;
	}
	public void setGh_src_churn(Integer gh_src_churn) {
		this.gh_src_churn = gh_src_churn;
	}
	public Integer getGh_test_churn() {
		return gh_test_churn;
	}
	public void setGh_test_churn(Integer gh_test_churn) {
		this.gh_test_churn = gh_test_churn;
	}
	public Integer getGh_files_added() {
		return gh_files_added;
	}
	public void setGh_files_added(Integer gh_files_added) {
		this.gh_files_added = gh_files_added;
	}
	public Integer getGh_files_deleted() {
		return gh_files_deleted;
	}
	public void setGh_files_deleted(Integer gh_files_deleted) {
		this.gh_files_deleted = gh_files_deleted;
	}
	public Integer getGh_files_modified() {
		return gh_files_modified;
	}
	public void setGh_files_modified(Integer gh_files_modified) {
		this.gh_files_modified = gh_files_modified;
	}
	public Integer getGh_tests_added() {
		return gh_tests_added;
	}
	public void setGh_tests_added(Integer gh_tests_added) {
		this.gh_tests_added = gh_tests_added;
	}
	public Integer getGh_tests_deleted() {
		return gh_tests_deleted;
	}
	public void setGh_tests_deleted(Integer gh_tests_deleted) {
		this.gh_tests_deleted = gh_tests_deleted;
	}
	public Integer getGh_src_files() {
		return gh_src_files;
	}
	public void setGh_src_files(Integer gh_src_files) {
		this.gh_src_files = gh_src_files;
	}
	public Integer getGh_sloc() {
		return gh_sloc;
	}
	public void setGh_sloc(Integer gh_sloc) {
		this.gh_sloc = gh_sloc;
	}
	public Double getGh_test_lines_per_kloc() {
		return gh_test_lines_per_kloc;
	}
	public void setGh_test_lines_per_kloc(Double gh_test_lines_per_kloc) {
		this.gh_test_lines_per_kloc = gh_test_lines_per_kloc;
	}
	public Double getGh_test_cases_per_kloc() {
		return gh_test_cases_per_kloc;
	}
	public void setGh_test_cases_per_kloc(Double gh_test_cases_per_kloc) {
		this.gh_test_cases_per_kloc = gh_test_cases_per_kloc;
	}
	public String getTr_build_id() {
		return tr_build_id;
	}
	public void setTr_build_id(String tr_build_id) {
		this.tr_build_id = tr_build_id;
	}
	public String getTr_status() {
		return tr_status;
	}
	public void setTr_status(String tr_status) {
		this.tr_status = tr_status;
	}
	public Integer getTr_duration() {
		return tr_duration;
	}
	public void setTr_duration(Integer tr_duration) {
		this.tr_duration = tr_duration;
	}
	public Date getTr_started_at() {
		return tr_started_at;
	}
	public void setTr_started_at(Date tr_started_at) {
		this.tr_started_at = tr_started_at;
	}
	public Integer getTr_build_number() {
		return tr_build_number;
	}
	public void setTr_build_number(Integer tr_build_number) {
		this.tr_build_number = tr_build_number;
	}
	public String getTr_lan() {
		return tr_lan;
	}
	public void setTr_lan(String tr_lan) {
		this.tr_lan = tr_lan;
	}
	public Integer getTr_tests_ok() {
		return tr_tests_ok;
	}
	public void setTr_tests_ok(Integer tr_tests_ok) {
		this.tr_tests_ok = tr_tests_ok;
	}
	public Integer getTr_tests_fail() {
		return tr_tests_fail;
	}
	public void setTr_tests_fail(Integer tr_tests_fail) {
		this.tr_tests_fail = tr_tests_fail;
	}
	public Integer getTr_tests_run() {
		return tr_tests_run;
	}
	public void setTr_tests_run(Integer tr_tests_run) {
		this.tr_tests_run = tr_tests_run;
	}
	public Integer getTr_tests_skipped() {
		return tr_tests_skipped;
	}
	public void setTr_tests_skipped(Integer tr_tests_skipped) {
		this.tr_tests_skipped = tr_tests_skipped;
	}
	public Boolean getTr_tests_ran() {
		return tr_tests_ran;
	}
	public void setTr_tests_ran(Boolean tr_tests_ran) {
		this.tr_tests_ran = tr_tests_ran;
	}
	public Boolean getTr_tests_failed() {
		return tr_tests_failed;
	}
	public void setTr_tests_failed(Boolean tr_tests_failed) {
		this.tr_tests_failed = tr_tests_failed;
	}
	@Override
	public String toString() {
		return "TravisBuild [row=" + row + ", git_commit=" + git_commit + ", git_branch=" + git_branch
				+ ", git_commits=" + git_commits + ", gh_project_name=" + gh_project_name + ", gh_is_pr=" + gh_is_pr
				+ ", gh_first_commit_created_at=" + gh_first_commit_created_at + ", gh_team_size=" + gh_team_size
				+ ", gh_src_churn=" + gh_src_churn + ", gh_test_churn=" + gh_test_churn + ", gh_files_added="
				+ gh_files_added + ", gh_files_deleted=" + gh_files_deleted + ", gh_files_modified=" + gh_files_modified
				+ ", gh_tests_added=" + gh_tests_added + ", gh_tests_deleted=" + gh_tests_deleted + ", gh_src_files="
				+ gh_src_files + ", gh_sloc=" + gh_sloc + ", gh_test_lines_per_kloc=" + gh_test_lines_per_kloc
				+ ", gh_test_cases_per_kloc=" + gh_test_cases_per_kloc + ", tr_build_id=" + tr_build_id + ", tr_status="
				+ tr_status + ", tr_duration=" + tr_duration + ", tr_started_at=" + tr_started_at + ", tr_build_number="
				+ tr_build_number + ", tr_lan=" + tr_lan + ", tr_tests_ok=" + tr_tests_ok + ", tr_tests_fail="
				+ tr_tests_fail + ", tr_tests_run=" + tr_tests_run + ", tr_tests_skipped=" + tr_tests_skipped
				+ ", tr_failed_tests=" + tr_failed_tests + ", tr_tests_ran=" + tr_tests_ran + ", tr_tests_failed="
				+ tr_tests_failed + "]";
	}
	
}
