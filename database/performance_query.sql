--SQL database improvement
--Please run this after creating the travis torrent database

--alter table travistorrent_27_10_2016 add primary key (row);
--create index index_project_name on travistorrent_27_10_2016(gh_project_name(15));

create index index_project_name on travistorrent_6_12_2016(gh_project_name(15));


--create unique index index_row_id on travistorrent_27_10_2016(row);

--create index index_language on travistorrent_27_10_2016(gh_lang(10));
create index index_language on travistorrent_6_12_2016(gh_lang(10));


--show index from travistorrent_27_10_2016;
