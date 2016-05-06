/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eklinik_bill;

/**
 * This class monitor host and port
 * @author Ho Zhen Hong
 */
public class ServerDetail {
    
    // declaration host and port
    //String host = "biocore-stag.utem.edu.my"; //server stagging
    //String host = "biocore-devp.utem.edu.my"; // server development
    private final String host;
    private final int port;
    
    public ServerDetail(){
        this.host = "10.73.32.200";
        this.port = 1099;
    }
    
    public String getHost(){
        return this.host;
    }
    
    public int getPort(){
        return this.port;
    }
}
