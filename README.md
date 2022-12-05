# NYC Traffic Pattern Pre, Through, and Post Pandemic

## Genie Hou

### This is a project Nancy Ma and I created for the class Processing Big Data for Analytics Application at NYU CAS. We are studying the changes in traffic patterns for both subway traffic patterns as well as driving traffic as an impact of the pandemic.
### Here is the link to Medium Story page: 

For the overall group combined data set, I wrote the MapReduce Codes to perform Analytics on the data set.(In point 10 and 11)

Data Ingestion

1. Upload all data files from local to peel to a directory /user/ch3801/ProjectData in there you can find and have been given the access to all files. Files including 9 2019~2021 MTA Ridership files.

2. Load all data files into Hive by creating tables and load data inpath files 
	(commands also shown in GenieCommands.hql)
	- create external table 2019AnnualRidership (stations STRING, bool INT, `2014` BIGINT, `2015` BIGINT, `2016` BIGINT, `2017` BIGINT, `2018` BIGINT, `2019` BIGINT,change BIGINT,rate FLOAT,rank INT) 
	 STORED AS TEXTFILE LOCATION '/user/ch3801/2019AnnualRidership';

	- load data inpath 'hdfs://horton.hpc.nyu.edu:8020/user/ch3801/ProjectData/2019AnnualTotalRidership.csv' overwrite into table 2019AnnualRidership;

3. Select and combine desired columns and information and drop some columns by using hive to combine tables
	- create table AandB AS SELECT a.stations, a.boro,a.`2018`, a.`2019`,a.`18-19change`,a.`18-19rate`,a.`19rank`,b.`2020`,b.`19-20change`,b.`19-20rate`,b.`20rank` FROM 2019AnnualRidership a JOIN 2020AnnualRidership b ON (a.stations=b.stations);

4. exporting the hive tables into csv files to peel
	- create external table csv_allendtable (stations STRING, boro STRING, `2018` STRING,`2019` STRING, `18-19change` STRING, `18-19rate` STRING,`19rank` STRING, `2020` STRING, `19-20change` STRING, `19-20rate` STRING,`20rank` STRING,`2021` STRING, `20-21change` STRING, `20-21rate` STRING,`21rank` STRING )STORED AS TEXTFILE LOCATION '/user/ch3801/csv_CombinedendTable';

	- INSERT OVERWRITE TABLE csv_alldaytable Select * from csv_daytable;

	- INSERT OVERWRITE DIRECTORY '/user/ch3801/goodweekday' ROW FORMAT DELIMITED FIELDS TERMINATED BY ‘!’ SELECT * FROM csv_alldaytable;

5. Resulting in 3 csv files in /user/ch3801/goodcsvfils in there you can find and have been given the access to all files.
Input files:
	- /user/ch3801/goodcsvfils/weekday.csv
	- /user/ch3801/goodcsvfils/weekend.csv
	- /user/ch3801/goodcsvfils/yeaer.csv
	These are the files I will use for Profiling, Cleaning, and Analytics
	- /user/ch3801/goodcsvfils/Combined.txt
	This is the file used for group combined dataset analytics
	
Profiling

6. After Observing the files, I used the 2 profiling MapReduce process on peel on all three of the csv files
	- countbadrecs in google folder of java, jar, and class files
	- countrecs in google folder of java, jar, and class files

ETL/Clean/Prep for Analysis

7. Cleaning up the data sets by excluding the shorter records using the MapReduce Process
	- ProjClean (only Mapper and Driver for the data structure ) in google folder of java, jar, and class files

Analytics Codes

8. Created the MapReduce processes to find the Changes of the amount passengers on Subway in each boro each year for each file
 	- FChange (for changes 2018-2019) in google folder of java, jar, and class files
 	- Change (for changes 2019-2020) in google folder of java, jar, and class files
 	- ChangeRate (for changes 2020-2021) in google folder of java, jar, and class files
 	Input files:
	- /user/ch3801/goodcsvfils/weekday.csv
	- /user/ch3801/goodcsvfils/weekend.csv
	- /user/ch3801/goodcsvfils/yeaer.csv

9. Results can be found  
/user/ch3801/weekdaychange18-19/part-r-00000
/user/ch3801/weekdaychange19-20/part-r-00000
/user/ch3801/weekdaychange20-21/part-r-00000

/user/ch3801/weekendchange18-19/part-r-00000
/user/ch3801/weekendchange19-20/part-r-00000
/user/ch3801/weekendchange20-21/part-r-00000

/user/ch3801/yearchange18-19/part-r-00000
/user/ch3801/yearchange19-20/part-r-00000
/user/ch3801/yearchange20-21/part-r-00000

10. Created MapReduce Processes for the overall group combined dataset
	- Correlation in google folder of java, jar, and class files
		-finds the relationship between subway user and tunnel users through 2019-2021
	- BoroTunnel in google folder of java, jar, and class files
		-finds the Tunnel passengers number in each boro each year
	- SameBoro_weekdays
		-finds the weekday subway passengers number in each boro each year
	- SameBoro_weekends
		-finds the weekend subway passengers number in each boro each year
	Input file:
	- /user/ch3801/goodcsvfils/Combined.txt

11. Results can be found
/user/ch3801/correlation_output/part-r-00000
/user/ch3801/combined_output/part-r-00000
/user/ch3801/combined_daysoutput/part-r-00000
/user/ch3801/combined_tunnel_output/part-r-00000

