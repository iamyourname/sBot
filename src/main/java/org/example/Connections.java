package org.example;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {

    public static void initConnectionStore() throws SQLException, ClassNotFoundException {
        try {
            logger.info("TRY TO INIT AND CONNECT TO DATABASE");
            Class.forName(baseDriver);
            connLog = DriverManager.getConnection(urlLog,  username, password);
            connLog.setAutoCommit(true);
            logger.info("CONNECTION SUCCESSFULY");
        } catch (SQLException e) {
            logger.error("FAILED  CONNECT TO DATABASE: "+e.toString());
        }
    }

}
