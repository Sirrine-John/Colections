package PokeApp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;
 
import com.google.gson.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PokeAPI_JSON {
	
	public static JsonObject pokeCollection = new JsonObject();
	@SuppressWarnings("unchecked")
	
	public JsonObject getPokeJSON() throws IOException{
		int totalPokeCount;
		
		try{
			PokeAPI_Connection connection = new PokeAPI_Connection("https://pokeapi.co/api/v2/pokemon-species/","GET");
			JsonObject initialFetch = new JsonObject();
			connection.run();
			initialFetch = connection.getResults();
			totalPokeCount = Integer.parseInt(initialFetch.get("count").toString());
//			nextPage = initialFetch.get("next").toString();
//			totalPages = Math.ceil(totalPokeCount/20.0);
//			System.out.println("Starting loop for "+totalPages+" pages.");
//			for(int i=0;i<totalPokeCount;i++){
			ExecutorService exeServ = Executors.newFixedThreadPool(totalPokeCount);
			for(int i=0;i<totalPokeCount;i++){
				int currentPokeNum = i+1;
				PokeAPI_Connection individualConnection = new PokeAPI_Connection("https://pokeapi.co/api/v2/pokemon/"+currentPokeNum+"/", "GET");
//				JSONObject pokeFetch = new JSONObject();
				Thread retrevalThread = new Thread(individualConnection);
				exeServ.execute(retrevalThread);
//				retrevalThread.start();
				//pokeFetch = individualConnection.getResults();
				//pokeCollection.put(currentPokeNum,pokeFetch);
				if((currentPokeNum % 100) == 0){
					System.out.println("Waiting for 1 minute to continue fetching data.");
					TimeUnit.MINUTES.sleep(1);
					
					System.out.println();
				}
				
			};
			exeServ.shutdown();
			exeServ.awaitTermination(30, TimeUnit.SECONDS);
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally{
			return trimPokeCollection();
		}
	}
	
	private JsonObject trimPokeCollection() throws IOException{
		JsonObject newPokeCollection = new JsonObject();
		pokeCollection.entrySet().stream().map((poke) -> {
			JsonObject single = new JsonObject();
			single = (JsonObject) poke.getValue();
			return single;
		}).map((single) -> {
			JsonArray pokeInfo = new JsonArray();
			pokeInfo.add(single.get("id"));
			pokeInfo.add(single.get("name"));
			pokeInfo.add(single.get("height"));
			pokeInfo.add(single.get("weight"));
			pokeInfo.add(single.get("base_experience"));
			pokeInfo.add(single.getAsJsonArray("types").get(0).getAsJsonObject().getAsJsonObject("type").get("name"));
			try{pokeInfo.add(single.getAsJsonArray("types").get(1).getAsJsonObject().getAsJsonObject("type").get("name"));}
			catch(Exception e){pokeInfo.add("");}
			;
			try{
				saveSprites(single.getAsJsonObject("sprites").get("front_default").getAsString(),pokeInfo.get(0).getAsString());
				pokeInfo.add("p"+pokeInfo.get(0).getAsString()+".png");
			}catch(Exception e){pokeInfo.add("");}
			return pokeInfo;
		}).forEachOrdered((pokeInfo) -> {
			newPokeCollection.add(pokeInfo.get(0).getAsString(), pokeInfo);
		});
		return newPokeCollection;
		
	}
	
	public void saveSprites(String imageUrl, String pokeId) throws IOException{
		File imgPath = new File("./src/Java/pokeApp/Sprites/p"+pokeId+".png");
		if (!imgPath.exists()){
			URL url = new URL(imageUrl);
			InputStream is = url.openStream();
			OutputStream os = new FileOutputStream("./src/Java/pokeApp/Sprites/p"+pokeId+".png");

			byte[] b = new byte[2048];
			int length;

			while ((length = is.read(b)) != -1) {
				os.write(b, 0, length);
			}
			is.close();
			os.close();
		}
	}
	
}
