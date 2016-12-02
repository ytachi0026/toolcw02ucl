CREATE TABLE project(gh_project_name VARCHAR(50) NOT NULL PRIMARY KEY, gh_lang VARCHAR(50));


CREATE TABLE fix_duration(gh_project_name VARCHAR(50) NOT NULL, loc INTEGER, durationInDays INTEGER, failureStart DATETIME, failureFix DATETIME);


CREATE INDEX project_name_fix_duration ON fix_duration(gh_project_name);


