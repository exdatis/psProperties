/*
 * Copyright (C) 2016 morar
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package bsproperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import org.jasypt.util.text.BasicTextEncryptor;

/**
 *
 * @author morar
 */
public class DbProperties {

    /*
     * static variable declaration
     */
    static final String KEY_USER = "DB_USER";
    static final String KEY_PWD = "DB_PWD";
    static final String KEY_HOST = "DB_HOST";
    /*
     * variable declaration
     */
    private String dbUser;
    private String dbPwd;
    private String dbHost;
    /*
     * final variable(set encryption password)
     */

    final private String sep = "JDK013";

    /**
     * Constructor (no data) empty fields
     */
    public DbProperties() {
        this.dbUser = "";
        this.dbPwd = "";
        this.dbHost = "";

    }

    /**
     * Constructor with default value for dbHost - localhost(127.0.0.1)
     *
     * @param dbUser
     * @param dbPwd
     */
    public DbProperties(String dbUser, String dbPwd) {
        this.dbUser = dbUser;
        this.dbPwd = dbPwd;
        //as default localhost
        this.dbHost = "localhost";

    }

    /**
     * Constructor with parameters for all fields
     *
     * @param dbUser
     * @param dbPwd
     * @param DbHost
     */
    public DbProperties(String dbUser, String dbPwd, String DbHost) {
        this.dbUser = dbUser;
        this.dbPwd = dbPwd;
        this.dbHost = dbHost;
    }

    /**
     *
     * @return dbUser
     */
    public String getDbUser() {
        return dbUser;
    }

    /**
     * set dbUser
     *
     * @param dbUser
     */
    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    /**
     * get current password
     *
     * @return dbPwd
     */
    public String getDbPwd() {
        return dbPwd;
    }

    /**
     * set current password
     *
     * @param dbPwd
     */
    public void setDbPwd(String dbPwd) {
        this.dbPwd = dbPwd;
    }

    /**
     *
     * @return dbHost
     */
    public String getDbHost() {
        return dbHost;
    }

    /**
     * set current dbHost - host(tcp/ip)
     *
     * @param dbHost
     */
    public void setDbHost(String dbHost) {
        this.dbHost = dbHost;
    }

    /**
     * return encrypted string(originalString)
     *
     * @param originalString
     * @return (encrypted String)
     */
    private String getEncryptedValue(String originalString) {

        // create encryptor
        BasicTextEncryptor enc = new BasicTextEncryptor();
        // set password
        enc.setPassword(this.sep);
        String encStr = enc.encrypt(originalString);
        return encStr;

    }

    /**
     * return decrypted string(originalString)
     *
     * @param originalString
     * @return (decrypted String)
     */
    private String getDecryptedValue(String originalString) {
        // create encryptor
        BasicTextEncryptor enc = new BasicTextEncryptor();
        // set password
        enc.setPassword(this.sep);
        String decStr = enc.decrypt(originalString);
        return decStr;

    }

    /**
     * read existent Java Properties file
     *
     * @param path
     * @return (Java Properties object)
     * @throws FileNotFoundException
     * @throws IOException
     */
    public Properties readPropertiesFile(String path) throws FileNotFoundException, IOException {
        //read file
        FileInputStream fs = new FileInputStream(path);
        // create Properties object
        Properties cnf = new Properties();
        cnf.load(fs);
        return cnf;
    }

    /**
     * save new properties file
     *
     * @param cnf (Java Properties)
     * @param path (path to file)
     * @return boolean(success or unsuccess)
     * @throws FileNotFoundException
     */
    public boolean savePropertiesFile(Properties cnf, String path) throws FileNotFoundException {
        // output stream
        FileOutputStream fs = new FileOutputStream(path);
        try {
            cnf.store(fs, "ExDatis");
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }

    }

    //TODO
    public Properties encryptProperties(Properties cnf) {
        return null;
    }

    //TODO
    public Properties decryptProperties(Properties cnf) {
        return null;
    }
}
