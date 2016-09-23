/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jdesktop.swingx.JXDatePicker;

public class DatePickerExample  {
 
    public JPanel da () {
//    public DatePickerExample(JPanel panal){
        
JFrame frame = new JFrame("JXPicker Example");
        JPanel panel = new JPanel();
       

        JXDatePicker picker = new JXDatePicker();
        picker.setDate(Calendar.getInstance().getTime());
        picker.setFormats(new SimpleDateFormat("dd/MM/yyyy"));
        panel.add(picker);
       

       
       
        return panel;
    }
}