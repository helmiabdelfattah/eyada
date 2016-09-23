/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author helmi
 */

public class db {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
	   static final String USER = "root";
	   static final String PASS = "root";
           static Connection conn = null ;
           public static Statement getconn(){
        
            try {
                if(conn!=null)
                conn.close();
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
                }
                String sTempDb = "user=root&password=root";
                String sJdbc = DB_URL;
                String sDbUrl = sJdbc + "?" + sTempDb;
//                      org.sqlite.JDBC .. com.mysql.jdbc.Driver
                //STEP 3: Open a connection
                System.out.println("Connecting to database...");
                
                conn = DriverManager.getConnection(sDbUrl);
                return conn.createStatement();
                
                
            } catch (SQLException ex) {
                Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
            }
        return null;
       
}
            public static void exedb(String s){
                 Connection conn = null ;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
                    
		      //STEP 2: Register JDBC driver
		     
                    
		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      stmt = getconn();
		     
//		      sql = "SELECT * FROM lib";
                     
                          stmt.execute(s);
                          
        		        
		     /* conn = DriverManager.getConnection
		    		  ("jdbc:mysql://localhost/?user=root&password=root"); 
		    		  stmt=conn.createStatement();
		    		  int res=stmt.executeUpdate("CREATE DATABASE emp");
		      *///STEP 5: Extract data from result set
                      
		     
                
    
		      //STEP 6: Clean-up environment
//		      stmt.closeOnCompletion();
//		     stmt.setEscapeProcessing(false);
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }//end try
             
		   System.out.println("Goodbye!");
		
}
            
            
            
            
   public static ResultSet getdb(String s){
    Connection conn = null ;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
                    
		      //STEP 2: Register JDBC driver
		      stmt = getconn();
		     
//		      sql = "SELECT * FROM lib";
		      rs =  stmt.executeQuery(s);
		     /* conn = DriverManager.getConnection
		    		  ("jdbc:mysql://localhost/?user=root&password=root"); 
		    		  stmt=conn.createStatement();
		    		  int res=stmt.executeUpdate("CREATE DATABASE emp");
		      *///STEP 5: Extract data from result set
                      
		     
                
    
		      //STEP 6: Clean-up environment
//		       stmt.setEscapeProcessing(false);
//                       stmt.closeOnCompletion();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }//end try
             
		   System.out.println("Goodbye!");
                   
		return rs;
}
   
   public static int getaccount(int id) throws SQLException{
    Connection conn = null ;
		Statement stmt = null;
		ResultSet rs = null;
                
		
		try{
                    
		      //STEP 2: Register JDBC driver
		       stmt = getconn();
		     
//		      sql = "SELECT * FROM lib";
                   
		       rs =  stmt.executeQuery("select account from patient;");
		     /* conn = DriverManager.getConnection
		    		  ("jdbc:mysql://localhost/?user=root&password=root"); 
		    		  stmt=conn.createStatement();
		    		  int res=stmt.executeUpdate("CREATE DATABASE emp");
		      *///STEP 5: Extract data from result set
                      
		     
                
    
		      //STEP 6: Clean-up environment
		      
		     
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }//end try
             rs.next();
		   
                   
		return rs.getInt("account");
}
   
   public static int getmaxid() throws SQLException{
    Connection conn = null ;
		Statement stmt = null;
		ResultSet rs = null;
                
		
		try{
                    
		      //STEP 2: Register JDBC driver
		       stmt = getconn();
		     
//		      sql = "SELECT * FROM lib";
                   
		       rs =  stmt.executeQuery("select max(patient_id) from patient;");
		     /* conn = DriverManager.getConnection
		    		  ("jdbc:mysql://localhost/?user=root&password=root"); 
		    		  stmt=conn.createStatement();
		    		  int res=stmt.executeUpdate("CREATE DATABASE emp");
		      *///STEP 5: Extract data from result set
                      
		     
                
    
		      //STEP 6: Clean-up environment
		      
		     
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }//end try
             rs.next();
		   System.out.println("Goodbye!");
                   System.out.println("hgsgsfajf");
                   
                   System.out.println(rs.getInt("max(patient_id)"));
                   
		int t = rs.getInt("max(patient_id)");
                System.out.println("dslmjkfgvasy  : "+t);
                   return t;
}
   public static int getmaxcureid() throws SQLException{
    Connection conn = null ;
		Statement stmt = null;
		ResultSet rs = null;
                
		
		try{
                    
		      //STEP 2: Register JDBC driver
		       stmt = getconn();
		     
//		      sql = "SELECT * FROM lib";
                   
		       rs =  stmt.executeQuery("select max(cure_id) from cure;");
		     /* conn = DriverManager.getConnection
		    		  ("jdbc:mysql://localhost/?user=root&password=root"); 
		    		  stmt=conn.createStatement();
		    		  int res=stmt.executeUpdate("CREATE DATABASE emp");
		      *///STEP 5: Extract data from result set
                      
		     
                
    
		      //STEP 6: Clean-up environment
		      
		     
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }//end try
             rs.next();
		   System.out.println("Goodbye!");
                  
                   
                   
		return rs.getInt("max(cure_id)");
}
   public static int getmaxchornicid() throws SQLException{
    Connection conn = null ;
		Statement stmt = null;
		ResultSet rs = null;
                
		
		try{
                    
		      //STEP 2: Register JDBC driver
		       stmt = getconn();
		     
//		      sql = "SELECT * FROM lib";
                   
		       rs =  stmt.executeQuery("select max(chronic_disease_id) from chronic_disease;");
		     /* conn = DriverManager.getConnection
		    		  ("jdbc:mysql://localhost/?user=root&password=root"); 
		    		  stmt=conn.createStatement();
		    		  int res=stmt.executeUpdate("CREATE DATABASE emp");
		      *///STEP 5: Extract data from result set
                      
		     
                
    
		      //STEP 6: Clean-up environment
		      
		     
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }//end try
             rs.next();
		   System.out.println("Goodbye!");
                   System.out.println("hgsgsfajf");
                   
                   System.out.println(rs.getInt("max(chronic_disease_id)"));
                   System.out.println("dslmjkfgvasy");
		return rs.getInt("max(chronic_disease_id)");
}
    public static int getmaxeye_disid() throws SQLException{
    Connection conn = null ;
		Statement stmt = null;
		ResultSet rs = null;
                
		
		try{
                    
		      //STEP 2: Register JDBC driver
		      stmt = getconn();
		     
//		      sql = "SELECT * FROM lib";
                   
		       rs =  stmt.executeQuery("select max(eye_diseases_id) from eye_diseases;");
		     /* conn = DriverManager.getConnection
		    		  ("jdbc:mysql://localhost/?user=root&password=root"); 
		    		  stmt=conn.createStatement();
		    		  int res=stmt.executeUpdate("CREATE DATABASE emp");
		      *///STEP 5: Extract data from result set
                      
		     
                
    
		      //STEP 6: Clean-up environment
		      
		     
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }//end try
             rs.next();
		   System.out.println("Goodbye!");
                   System.out.println("hgsgsfajf");
                   
                   System.out.println(rs.getInt("max(eye_diseases_id)"));
                   System.out.println("dslmjkfgvasy");
		return rs.getInt("max(eye_diseases_id)");
}
    
     public static int getmaxlineid() throws SQLException{
    Connection conn = null ;
		Statement stmt = null;
		ResultSet rs = null;
                
		
		try{
                    
		      //STEP 2: Register JDBC driver
		       stmt = getconn();
		     
//		      sql = "SELECT * FROM lib";
                   
		       rs =  stmt.executeQuery("select max(prescription_line_id) from prescription_line;");
		     /* conn = DriverManager.getConnection
		    		  ("jdbc:mysql://localhost/?user=root&password=root"); 
		    		  stmt=conn.createStatement();
		    		  int res=stmt.executeUpdate("CREATE DATABASE emp");
		      *///STEP 5: Extract data from result set
                      
		     
                
    
		      //STEP 6: Clean-up environment
		      
		     
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }//end try
             rs.next();
		   
                   
                   
		return rs.getInt("max(prescription_line_id)");
}
      public static int getmaxper() throws SQLException{
    Connection conn = null ;
		Statement stmt = null;
		ResultSet rs = null;
                
		
		try{
                    
		      //STEP 2: Register JDBC driver
		      stmt = getconn();
//		      sql = "SELECT * FROM lib";
                   
		       rs =  stmt.executeQuery("select max(prescription_id) from prescription;");
		     /* conn = DriverManager.getConnection
		    		  ("jdbc:mysql://localhost/?user=root&password=root"); 
		    		  stmt=conn.createStatement();
		    		  int res=stmt.executeUpdate("CREATE DATABASE emp");
		      *///STEP 5: Extract data from result set
                      
		     
                
    
		      //STEP 6: Clean-up environment
		      
		     
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }//end try
             rs.next();
		   
		return rs.getInt("max(prescription_id)");
}
       public static eyerecord [] getdb(int id) throws SQLException{
                ResultSet rs = db.getdb("select count(*) from sight_record where patient_patient_id = '"+id+"';");
                rs.next();
int length = rs.getInt(1);
         rs = db.getdb("select * from sight_record where patient_patient_id = '"+id+"';");
         eyerecord [] res ;
        res = new eyerecord[length];
        
         
         while(rs.next()){
             length --;
             System.out.println(length);
             System.out.println("recoed...");
         res[length] =new eyerecord();
         res[length].datee=rs.getDate(1);
         res[length].t1=rs.getInt(2);
         res[length].t2=rs.getInt(3);
         res[length].t3=rs.getInt(4);
         res[length].t4=rs.getInt(5);
         res[length].t5=rs.getInt(6);
         res[length].t6=rs.getInt(7);
         res[length].t7=rs.getInt(8);
         res[length].t8=rs.getInt(9);
         res[length].t9=rs.getInt(10);
         res[length].t10=rs.getInt(11);
                     System.out.println("done...");
         }
                return res; }
         
    /**
     *
     * @return
     * @throws SQLException
     */
    public static String[] getnoti() throws SQLException{
                Date date = new Date(System.currentTimeMillis());
                 ResultSet rs = db.getdb("select count(*) from noti where date >  '"+date+"' order by date;");
                rs.next();
                int length = rs.getInt(1);

         rs = db.getdb("select * from noti where date >  '"+date+"' order by date;");
         String [] res ;
        res = new String[length];
        
         
         while(rs.next()){
             length --;
            
         res[length] =rs.getString(3);
         
                    
         }
           
    return res; 
    }
    
    public static String[] getreports() throws SQLException{
                Date date = new Date(System.currentTimeMillis());
                 ResultSet rs = db.getdb("select count(distinct report.type) from report;");
                rs.next();
                int length = rs.getInt(1);

         rs = db.getdb("select distinct report.type from report;");
         String [] res ;
        res = new String[length];
        
         
         while(rs.next()){
             length --;
            
         res[length] =rs.getString("type");
         
         }
           
    return res; 
    }
    
    public static String[] getreport_t(String type) throws SQLException{
                Date date = new Date(System.currentTimeMillis());
                 ResultSet rs = db.getdb("select count(*) from report where type = '"+type+"';");
                rs.next();
                int length = rs.getInt(1);

         rs = db.getdb("select content  from report where report.type = '"+type+"';");
         String [] res ;
        res = new String[length];
        
         
         while(rs.next()){
             length --;
             System.out.println(length);
             System.out.println("recoed...");
         res[length] =rs.getString("content");
         
                     System.out.println("done...");
         }
           
    return res; 
    }
    
     public static String[] getIdes(int id) throws SQLException{
                Date date = new Date(System.currentTimeMillis());
                 ResultSet rs = db.getdb("select count(*) from visit where pat_id = '"+id+"';");
                rs.next();
                int length = rs.getInt(1);

         rs = db.getdb("select final_diagnosis  from visit where pat_id = '"+id+"';");
         String [] res ;
        res = new String[length];
        
         
         while(rs.next()){
             length --;
            
         res[length] =rs.getString("final_diagnosis");
         
         }
           
    return res; 
    }
    
       public static int getdesid(String a ) throws SQLException{
           int id =0;
              ResultSet rs = getdb("select eye_diseases_id from  eye_diseases where name ='"+a+"';");
           rs.next();
           return rs.getInt(1);
           }
       public int maxpreid() throws SQLException{
        ResultSet rs = getdb("SELECT max(prescription_id) FROM prescription;");
           rs.next();
           return rs.getInt(1);
       }
       
       public static void inc(int id , int count){
       db.exedb("UPDATE `patient` SET `count`='"+count+"' WHERE `patient_id`='"+id+"';");
       }
       
       public static void import_d (String fi) throws FileNotFoundException, IOException{
            FileReader file = new FileReader(fi);
            
            
            BufferedReader br = new BufferedReader(file);
            String sa ="";
            db.exedb("CREATE DATABASE  IF NOT EXISTS `mydb`;");
                    db.exedb("USE `mydb`;");
                    String ss = "";
            while ((sa=br.readLine()) != null){
         
            ss+=sa;}
            db.exedb(ss);
}
       public static int  getnotiid() throws SQLException{
       ResultSet rs = db.getdb("SELECT max(id) from noti;");
       rs.next();
       return rs.getInt(1);
       }
   }
    

