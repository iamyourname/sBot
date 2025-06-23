package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connections {
    final static Logger logger = LoggerFactory.getLogger(Connections.class);
    final public static String baseDriver = "org.postgresql.Driver";
    public static java.sql.Connection conn;
    public static String connUrl = "jdbc:postgresql://45.139.77.167:5432/domofon";

    public static void initConnectionStore() throws SQLException, ClassNotFoundException {
        try {
            logger.info("TRY TO INIT AND CONNECT TO DATABASE");
            Class.forName(baseDriver);
            conn = DriverManager.getConnection(connUrl,  "domofon", "xid123mt");
            conn.setAutoCommit(true);
            logger.info("CONNECTION SUCCESSFULY");
        } catch (SQLException e) {
            logger.error("FAILED  CONNECT TO DATABASE: "+e.toString());
        }
    }


    public static boolean getAddress(){

        String query="SELECT * from codes \n" +
                "where upper(address) like upper('%лермо%')";

        try{
            if(conn==null)
                initConnectionStore();
            Statement stmt = conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = stmt.executeQuery(query);
            resultSet.last();
            int rowCount = resultSet.getRow();
            resultSet.beforeFirst();
            int i=0;
            while (resultSet.next()){
                System.out.println(resultSet.getString(1));


            }
            if(rowCount > 0){
                return true;
            }else{
                return false;
            }
            // logger.info("writeNewDailyUsersCount DONE");
        }catch (SQLException | ClassNotFoundException e){

            logger.error(e.toString());
            return false;
        }
    }

}
