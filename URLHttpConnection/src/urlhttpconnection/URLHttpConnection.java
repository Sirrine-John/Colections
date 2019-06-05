
package urlhttpconnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class URLHttpConnection  
{ 
    public static void main(String[] args) throws Exception
    {
    try
    {
      String myUrl = "https://raw.githubusercontent.com/Biuni/PokemonGO-Pokedex/master/pokedex.json";
//      String myUrl = "https://www.baeldung.com/java-http-request";
      // if your url can contain weird characters you will want to 
      // encode it here, something like this:
      // myUrl = URLEncoder.encode(myUrl, "UTF-8");
      
//      ReadJSON getJSON = new ReadJSON();
      String results = doHttpUrlConnectionAction(myUrl);
      //results.substring(1, results.length()-1);
      //getJSON.reader(results);
      System.out.println(results);
    }
    catch (Exception e)
    {
      // deal with the exception in your "controller"
    }
  }

  private static String doHttpUrlConnectionAction(String desiredUrl)
  throws Exception
  {
    String requestResultMessage;
    Integer requestResultCode;
    URL url = null;
    BufferedReader reader = null;
    StringBuilder stringBuilder;

    try
    {
      // create the HttpURLConnection
      url = new URL(desiredUrl);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      
      // just want to do an HTTP GET here
      connection.setRequestMethod("GET");
//      connection.setRequestMethod("POST");
//      connection.setRequestMethod("HEAD");
//      connection.setRequestMethod("OPTIONS");
//      connection.setRequestMethod("PUT");
//      connection.setRequestMethod("DELETE");
//      connection.setRequestMethod("TRACE");
      
      // uncomment this if you want to write output to this url
      //connection.setDoOutput(true);
      
      // give it 15 seconds to respond
      connection.setReadTimeout(15*1000);
      connection.connect();
      requestResultMessage = connection.getResponseMessage();
      requestResultCode = connection.getResponseCode();
      System.out.println(requestResultCode + ": "+requestResultMessage);

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
    {
      // close the reader; this can throw an exception too, so
      // wrap it in another try/catch block.
      if (reader != null)
      {
        try
        {
          reader.close();
        }
        catch (IOException ioe)
        {
          ioe.printStackTrace();
        }
      }
    }
  }
}