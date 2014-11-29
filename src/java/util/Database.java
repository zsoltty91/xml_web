/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 *
 * @author zsolti
 */
public class Database {

    private static Logger logger = Logger.getLogger(Database.class);
    
    private static Database database = null;

    private String host;
    private int port;
    private String user;
    private String pass;

    private Database() {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(new File("src\\main\\resources\\database.properties"));
           
            prop.load(input);
            host = prop.getProperty("host");
            port = Integer.parseInt(prop.getProperty("port"));
            user = prop.getProperty("user");
            pass = prop.getProperty("pass");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {

                }
            }
        }
    }

    public static synchronized Database getInstance() {
        logger.debug("getInstance()");
        if (database == null) {
            logger.debug("Create instance.");
            database = new Database();
        }
        return database;
    }

    public Connection getConnection() {
        return new Connection(host, port, user, pass);
    }

    public void freeConnection(Connection conn) {
        conn.closeConnection();
    }

}
