/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common.model;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author helmi
 */
public class patient {
     public  int id  ,age,count ,account;
   public  String first,second, email , facebook , last , title,add1,add2,meeting,company,note,gender,phone;
   public Date birthDate;
   public List<CDis> cdis ;  List<EDis> edis;
    public String titlee;
}
