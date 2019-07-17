package PokeApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.DataOutputStream;
import com.google.gson.*;

public class PokeAPI_Connection implements Runnable{
	private final String USER_AGENT = "Mozilla/5.0";
	private String urlString;
	private String option;
	private JsonObject results;
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
              inputProperties = "Post String 1= This is a string that shoud be retuned&Post String 2=This is the second string that should be printed";
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
	  
      // read the output from the server
      reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      stringBuilder = new StringBuilder();

      String line = null;
      while ((line = reader.readLine()) != null)
      {
        stringBuilder.append(line + "\n");
      }
	  
	  JsonParser parser = new JsonParser();
	  JsonObject results = new JsonObject();
	  results = (JsonObject) parser.parse(stringBuilder.toString());

	  if(desiredUrl == "https://pokeapi.co/api/v2/pokemon-species/"){
		  System.out.println(requestResultCode + ": "+requestResultMessage+" : END - Thread " + option + " " + urlString);
		  this.results = results;
	  }
	  else{
		String key = results.get("id").toString();
		PokeAPI_JSON.pokeCollection.add(key,results);
		System.out.println(requestResultCode + ": "+requestResultMessage+" : END - Thread " + option + " " + urlString);
	  }
    }
    catch (Exception e)
    {
	  System.out.println("ERROR: "+requestResultCode + ": "+requestResultMessage+": "+url);
      return;
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
		
	public JsonObject getResults(){
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
