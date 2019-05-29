/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package url_http_connection;
import javax.swing.text.*;
import javax.swing.*;
import java.io.*;
import java.awt.*;

public class ShowJframe {

  public static void OReilly() {
        
     JEditorPane jep = new JEditorPane();
     jep.setEditable(false);   
     
     try {
       jep.setPage("https://www.google.com");
     }
     catch (IOException e) {
       jep.setContentType("text/html");
       jep.setText("<html>Could not load Page</html>");
     } 
           
     JScrollPane scrollPane = new JScrollPane(jep);     
     JFrame f = new JFrame("O'Reilly & Associates");
     // Next line requires Java 1.3
     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     f.getContentPane().add(scrollPane);
     f.setSize(512, 342);
     f.setVisible(true);
    
  }

}