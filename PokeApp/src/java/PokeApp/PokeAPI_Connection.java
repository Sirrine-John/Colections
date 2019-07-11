package PokeApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.DataOutputStream;
import java.util.concurrent.TimeUnit;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class PokeAPI_Connection implements Runnable{
	private final String USER_AGENT = "Mozilla/5.0";
	private String urlString;
	private String option;
	private JSONObject results;
	public PokeAPI_Connection(String in_url,String in_option){
		this.urlString = in_url;
		this.option = in_option;
	};
	
	
    public void connectionCreate(String desiredUrl, String option)
            throws Exception
    {
    String requestResultMessage = "PreConnection Message";
    Integer requestResultCode = 0;
    URL url = null;
    BufferedReader reader = null;
    StringBuilder stringBuilder;
    String inputProperties;

    try
    {
      // create the HttpURLConnection
      url = new URL(desiredUrl);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestProperty("User-Agent", this.USER_AGENT);
      
      switch(option) {
          case "GET":
              requestResultMessage = "GET - ";
              connection.setRequestMethod("GET");
              connection.setReadTimeout(15*1000);
              connection.connect();
              break;
          case "POST":
              requestResultMessage = "POST - ";
              connection.setRequestMethod("POST");
              connection.setDoOutput(true);
              connection.setReadTimeout(15*1000);
              connection.connect();
              inputProperties = "Post String 1=This is a string that shoud be retuned&Post String 2=This is the second string that should be printed";
              try(DataOutputStream write = new DataOutputStream(connection.getOutputStream())){
                  write.writeBytes(inputProperties);
                  write.flush();
              }catch(Exception e){
                  //e.printStackTrace();
              }
              break;
          default:
              System.exit(0);
              break;
      }
      
      // give it 15 seconds to respond
      
      requestResultMessage += connection.getResponseMessage();
      requestResultCode += connection.getResponseCode();
      //System.out.println("Response from: "+connection.getURL().toString()+System.lineSeparator()+requestResultCode + ": "+requestResultMessage);

	  
	  
      // read the output from the server
      reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      stringBuilder = new StringBuilder();

      String line = null;
      while ((line = reader.readLine()) != null)
      {
        stringBuilder.append(line + "\n");
      }
	  //System.out.println(stringBuilder.toString());
	  
	  JSONParser parser = new JSONParser();
	  JSONObject results = new JSONObject();
	  results = (JSONObject) parser.parse(stringBuilder.toString());
//	  try {
//              TimeUnit.MILLISECONDS.sleep((int)(Math.random() * 1000));
//            } catch (InterruptedException e) {}
//	  System.out.println("Thread finished: "+url);
	  
//	  this.results = results;
	  if(desiredUrl == "https://pokeapi.co/api/v2/pokemon-species/"){
		  System.out.println("END - Thread " + option + " " + urlString);
		  this.results = results;
	  }
	  else{
		int key = Integer.parseInt(results.get("id").toString());
		PokeAPI_JSON.pokeCollection.put(key,results);
		System.out.println("END - Thread " + option + " " + urlString);
	  }
    }
    catch (Exception e)
    {
      //e.printStackTrace();
      //throw e;
	  System.out.println("ERROR: "+requestResultCode + ": "+requestResultMessage+": "+url);
      return;
		// "ERROR: "+requestResultCode + ": "+requestResultMessage+": "+url;
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
	public JSONObject getResults(){
		return this.results;
	}
	
	public void run() {
		System.out.println("START " + option + " " + urlString);
		try{
			this.connectionCreate(urlString, option);
		}
		catch(Exception e){}
	}
}
