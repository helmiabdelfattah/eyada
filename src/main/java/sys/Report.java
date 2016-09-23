/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author helmi
 */
public class Report {
    
    public static void makereport (String name ,String date , String [] pre , String folder , String fname) throws Exception {
    final BufferedImage image = ImageIO.read(new File("by.jpg"));
//String name = "حلمي عبدالفتاح عبدالحميد";
//String date ="2015 - 08 - 10";
//String pre[] = {"Revo      knnsd", "cabsol   jehfgbe " , "بسم"};
//String folder = "de";
for (int i = 0; name.length() < 52; i++) {
                name+=" ";
            }
        for (int j = 0; j < pre.length; j++) {
            for (int i = 0; pre[j].length() < 85; i++) {
                pre[j]+=" ";
            }
        }
        
    Graphics g = image.getGraphics();
    g.setFont(g.getFont().deriveFont(30f));
    
    g.setColor(Color.BLACK);
    
    g.drawString(name, 500, 410);
   g.drawString(date, 190, 410);
   g.setFont(g.getFont().deriveFont(40f));
        for (int i = 0; i < pre.length; i++) {
            g.drawString(pre[i], 110 , 620 + 60*i);
        }
    g.dispose();
        System.out.println(new File(folder).mkdir());
        String s ="";
        s+=folder;s+="/";s+=fname;s+=".jpg";
    ImageIO.write(image, "png", new File(s));
}
    public static void makepre (String name ,String date , String [] pre , String folder , String fname) throws Exception {
    final BufferedImage image = ImageIO.read(new File(
        "by.jpg"));
//String name = "حلمي عبدالفتاح عبدالحميد";
//String date ="2015 - 08 - 10";
//String pre[] = {"Revo      knnsd", "cabsol   jehfgbe " , "بسم"};
//String folder = "de";
for (int i = 0; name.length() < 52; i++) {
                name+=" ";
            }
        for (int j = 0; j < pre.length; j++) {
            System.out.println(pre[j]);
            if(pre[j] =="")break;
            if(pre[j] ==null)break;
            for (int i = 0; pre[j].length() < 75; i++) {
                pre[j]+=" ";
            }
        }
        
    Graphics g = image.getGraphics();
    g.setFont(g.getFont().deriveFont(30f));
    
    g.setColor(Color.BLACK);
    
    g.drawString(name, 500, 410);
   g.drawString(date, 190, 410);
   g.setFont(g.getFont().deriveFont(40f));
        for (int i = 0; i < pre.length; i++) {
            if(pre[i] =="")break;
            if(pre[i] ==null)break;
            g.drawString(pre[i], 110 , 620 + 60*i);
            g.drawString(pre[++i], 110 , 620 + 60*i);
        }
    g.dispose();
        System.out.println(new File(folder).mkdir());
        String s ="";
        s+=folder;s+="/";s+=fname;s+=".jpg";
    ImageIO.write(image, "png", new File(s));
}
}
