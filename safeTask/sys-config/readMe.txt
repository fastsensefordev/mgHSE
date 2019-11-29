java.sql.SQLException: The server time zone value 'ÖÐ¹ú±ê×¼Ê±¼ä' is unrecognized or represents more than one time......
解决方案1
在mysql中执行命令： 
set global time_zone='+8:00' 