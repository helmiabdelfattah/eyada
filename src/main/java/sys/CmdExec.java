/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class CmdExec {
public static void main (String args[]) throws SQLException, IOException, InterruptedException{
String dbName = "mydb";
String dbUser = "root";
String dbPass = "1234";

/***********************************************************/
// Execute Shell Command
/***********************************************************/
String executeCmd  ;

executeCmd = "C:\\Program Files\\MySQL\\MySQL Server 5.6\\bin\\mysql -u helmi -p1234 mydp < file.sql";


Process runtimeProcess =Runtime.getRuntime().exec(executeCmd);
    OutputStream os =  runtimeProcess.getOutputStream();
    
    
   
    

 int processComplete = runtimeProcess.waitFor();
if(processComplete == 0){

System.out.println("success");

} else {

System.out.println("restore failure");

}
}
}
