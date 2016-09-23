/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author helmi
 */
public class dbmake {
    public static void main(String[] args) throws FileNotFoundException, IOException {
       
//        db.exedb("CREATE TABLE `account`(`patient_id` int(10)  NOT NULL,`amount` varchar(45) NOT NULL,PRIMARY KEY (`patient_id`),UNIQUE (`patient_id`),CONSTRAINT `patient_id` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`) ON DELETE NO ACTION ON UPDATE NO ACTION);");
//          db.exedb("CREATE TABLE `cat_cure` (`cat` varchar(50) NOT NULL,PRIMARY KEY (`cat`),UNIQUE (`cat`));");
//        db.exedb("CREATE TABLE `cat_dis` (`dis_name` varchar(50) NOT NULL,PRIMARY KEY (`dis_name`),UNIQUE (`dis_name`));");
//          db.exedb("CREATE TABLE `chronic_disease` (`chronic_disease_id` int(10)  NOT NULL,`description` varchar(45) NOT NULL,PRIMARY KEY (`chronic_disease_id`),UNIQUE (`chronic_disease_id`));");
//        db.exedb("CREATE TABLE `chronically` ( `patient_patient_id` int(10)  NOT NULL,  `chronic_disease_chronic_disease_id` int(10)  NOT NULL,  `month` int(10)  NOT NULL,  `year` int(11) NOT NULL,  PRIMARY KEY (`patient_patient_id`,`chronic_disease_chronic_disease_id`));");
//            db.exedb("CREATE TABLE `cure` (  `cure_id` int(10)  NOT NULL,  `describtion` varchar(45) NOT NULL,  `catregory` varchar(120) DEFAULT NULL,`formate` varchar(150) DEFAULT NULL,  PRIMARY KEY (`cure_id`),  UNIQUE  (`cure_id`));");
//        db.exedb("CREATE TABLE `cure_formate` (  `formate` varchar(150) NOT NULL,  PRIMARY KEY (`formate`));");
//        db.exedb("CREATE TABLE `cure_places` (  `place` varchar(120) NOT NULL,  PRIMARY KEY (`place`));");
//          db.exedb("CREATE TABLE `eye_diseases` (  `eye_diseases_id` int(10)  NOT NULL,  `name` varchar(45) NOT NULL,  `cat` varchar(45) DEFAULT NULL,  `note` mediumtext,  PRIMARY KEY (`eye_diseases_id`),  UNIQUE  (`eye_diseases_id`));");
//            db.exedb("CREATE TABLE `noti` (  `id` int(10)  NOT NULL,  `date` date DEFAULT NULL,  `text` longtext,  PRIMARY KEY (`id`),  UNIQUE  (`id`));");   
//              db.exedb("CREATE TABLE `patient` (  `patient_id` int(10)  NOT NULL,  `first_name` varchar(20) NOT NULL,  `second_name` varchar(20) NOT NULL,  `last_name` varchar(20) NOT NULL,  `title` varchar(20) NOT NULL,  `gender` varchar(20) NOT NULL,  `month_of_birth` int(11) NOT NULL,  `year_of_birth` year(4) NOT NULL,  `age` int(11) NOT NULL,  `phone` varchar(15) NOT NULL,  `address_1` varchar(45) NOT NULL,  `address_2` varchar(45) NOT NULL,  `note` longtext,  `company` varchar(45) DEFAULT NULL,  `meeting` longtext,  `day_of_birth` int(10)  DEFAULT NULL,  `email` varchar(100) DEFAULT NULL,  `facebook` varchar(100) DEFAULT NULL,  `titlee` varchar(45) DEFAULT NULL,  `count` int(11) DEFAULT '0',  `account` int(10)   DEFAULT '0000000000',  PRIMARY KEY (`patient_id`),  UNIQUE  (`patient_id`));");
//            db.exedb("CREATE TABLE `prescription` (  `prescription_id` int(10)  NOT NULL,  `eye_dis` varchar(150) DEFAULT NULL,  PRIMARY KEY (`prescription_id`),  UNIQUE  (`prescription_id`));");
//            db.exedb("CREATE TABLE `prescription_line` (  `prescription_line_id` int(10)  NOT NULL,  `count` int(10)  DEFAULT NULL,  `cure` varchar(150) DEFAULT NULL,  `note` varchar(200) DEFAULT NULL,  `prescription_prescription_id` int(10)  NOT NULL,  `amount` int(11) DEFAULT NULL,  `place` varchar(100) DEFAULT NULL,  `duration` int(11) DEFAULT NULL,  PRIMARY KEY (`prescription_line_id`),  UNIQUE  (`prescription_line_id`));");
//              db.exedb("CREATE TABLE `report` (  `type` varchar(100) NOT NULL,  `content` longtext);");
//            db.exedb("CREATE TABLE `sight_record` (  `date` date NOT NULL,  `r1` double DEFAULT NULL,  `r2` double DEFAULT NULL,  `r3` double DEFAULT NULL,  `r4` double DEFAULT NULL,  `r5` double DEFAULT NULL,  `r6` double DEFAULT NULL,  `r7` double DEFAULT NULL,  `r8` double DEFAULT NULL,  `r9` double DEFAULT NULL,  `r0` double DEFAULT NULL,  `patient_patient_id` int(10)  NOT NULL DEFAULT '0',  PRIMARY KEY (`patient_patient_id`,`date`));");
//        db.exedb("CREATE TABLE `visit` (  `visit_id` varchar(100) NOT NULL,  `type` varchar(45) NOT NULL,  `date` date NOT NULL,  `Initial_diagnosis` longtext,  `final_diagnosis` varchar(120) NOT NULL,  `prescription` int(10)  DEFAULT NULL,  `right` tinyint(1) NOT NULL,  `left` tinyint(1) NOT NULL,  `charge` int(11) NOT NULL DEFAULT '50',  `note` longtext,  `pat_id` int(11) DEFAULT NULL,  PRIMARY KEY (`visit_id`),  UNIQUE (`visit_id`));");
       
    } 
    
}
