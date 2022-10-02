package edu.iit.sat.itmd4515.jreginaldo.config;

import javax.annotation.sql.DataSourceDefinition;

@DataSourceDefinition(
        name = "java:app/jdbc/itmd4515DS",
        className = "com.mysql.cj.jdbc.MysqlDataSource",
        portNumber = 3306,
        serverName = "localhost",
        databaseName = "itmd4515",
        user = "itmd4515",
        password = "itmd4515",
        properties = {
                "zeroDateTimeBehavior=CONVERT_TO_NULL",
                "serverTimezone=America/Chicago",
                "useSSL=false"
        }
)

public class DatabaseConfig {

}
