
package urlhttpconnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.DataOutputStream;

public class URLHttpConnection  
{ 
    private static final String USER_AGENT = "Mozilla/5.0";
    public static void main(String[] args) throws Exception
    {
    try
    {
      String getURL = "https://raw.githubusercontent.com/Biuni/PokemonGO-Pokedex/master/pokedex.json";
      String postURL = "https://postman-echo.com/post/";
     
      String resultsGET = connectionCreate(getURL,"GET");
      String resultsPOST = connectionCreate(postURL,"POST");
      System.out.println(resultsGET+System.lineSeparator()+
              "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+System.lineSeparator()+
              "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+System.lineSeparator()+
              "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
              System.lineSeparator()+resultsPOST);
    }
    catch (Exception e)
    {
    }
  }
    
    private static String connectionCreate(String desiredUrl, String option)
            throws Exception
    {
    String requestResultMessage;
    Integer requestResultCode;
    URL url = null;
    BufferedReader reader = null;
    StringBuilder stringBuilder;
    String inputProperties;

    try
    {
      // create the HttpURLConnection
      url = new URL(desiredUrl);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
       connection.setRequestProperty("User-Agent", USER_AGENT);
      
      switch(option) {
          case "GET":
              connection.setRequestMethod("GET");
              connection.setReadTimeout(15*1000);
              connection.connect();
              break;
          case "POST":
              connection.setRequestMethod("POST");
              connection.setDoOutput(true);
              connection.setReadTimeout(15*1000);
              connection.connect();
              inputProperties = "Post String 1=This is a string that shoud be retuned&Post String 2=This is the second string that should be printed";
              try(DataOutputStream write = new DataOutputStream(connection.getOutputStream())){
                  write.writeBytes(inputProperties);
                  write.flush();
              }catch(Exception e){
                  e.printStackTrace();
              }
              break;
          default:
              System.exit(0);
              break;
      }
      
      // give it 15 seconds to respond
      
      requestResultMessage = connection.getResponseMessage();
      requestResultCode = connection.getResponseCode();
      System.out.println("Response from: "+connection.getURL().toString()+System.lineSeparator()+requestResultCode + ": "+requestResultMessage);

      // read the output from the server
      reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      stringBuilder = new StringBuilder();

      String line = null;
      while ((line = reader.readLine()) != null)
      {
        stringBuilder.append(line + "\n");
      }
      return stringBuilder.toString();
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw e;
    }
    finally
    {// close the reader;
      if (reader != null)
      {
          try{reader.close();}
          catch (IOException ioe){ioe.printStackTrace();}
      }
    }
        
    }
//      connection.setRequestMethod("HEAD");
//      connection.setRequestMethod("OPTIONS");
//      connection.setRequestMethod("PUT");
//      connection.setRequestMethod("DELETE");
//      connection.setRequestMethod("TRACE");

}