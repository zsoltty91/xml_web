/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 *
 * @author zsolti
 */
public class Connection {

    private static Logger logger = Logger.getLogger(Connection.class);

    private BaseXClient client;

    Connection(String host, int port, String user, String pass) {
        try {
            client = new BaseXClient(host, port, user, pass);
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    void closeConnection() {
        try {
            client.close();
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    public ArrayList<String> query(String queryString) throws IOException {
        BaseXClient.Query query = client.query(queryString);
        ArrayList<String> ret = new ArrayList<>();
        while (query.more()) {
            ret.add(query.next());
        }
        query.close();
        return ret;
    }

    public void executeQuery(String queryString) throws IOException {
        BaseXClient.Query query = client.query(queryString);
        query.execute();
    }

}
