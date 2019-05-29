/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package url_http_connection;


import java.io.PrintWriter;
import javax.swing.text.html.HTMLEditorKit.InsertHTMLTextAction;
import javax.swing.text.Document;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import jdk.internal.org.xml.sax.InputSource;
/**
 *
 * @author sirri
 */
public class URL_Http_Connection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HttpURLConnectionExample http = new HttpURLConnectionExample();
            try{
		//http.sendGet()
             
                ShowJframe.OReilly();
		
		//System.out.println("\nTesting 2 - Send Http POST request");
		//http.sendPost();
            }
            catch (Exception e){
                e.printStackTrace();
            }
    }
    
}
