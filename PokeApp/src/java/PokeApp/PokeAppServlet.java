package PokeApp;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "PokeAppServlet", urlPatterns = {"/PokeAppServlet"})
public class PokeAppServlet extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PokeHibernate hiberPoke = new PokeHibernate();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if (request.getParameterMap().containsKey("id")){
			int paramID = Integer.parseInt(request.getParameter("id"));
			if (paramID != 0){out.append(hiberPoke.getPokemon(paramID));}
			else{out.append("TRY AGAIN");}
		}
		else if (request.getParameterMap().containsKey("name")){
			String paramName = request.getParameter("name");
			if (paramName != null){
				String output = hiberPoke.getPokemon(paramName);
				if (output != null){
					out.append(output);
				}
			}
			else{out.append("TRY AGAIN");}
		}
		else if (request.getParameterMap().containsKey("count")){
			String paramCount;
			paramCount = hiberPoke.getCount();
			out.append(paramCount);
		}
		else if (request.getParameterMap().containsKey("refresh")){
			PokeAPI_JSON returnPokemon = new PokeAPI_JSON();
			JsonObject pokeShortList = new JsonObject();
			pokeShortList = returnPokemon.getPokeJSON();
//			PokeHibernate hiberPoke = new PokeHibernate();
			for(Map.Entry<String,JsonElement> poke : pokeShortList.entrySet()){
				JsonArray singlePoke = (JsonArray)poke.getValue();
				int id = singlePoke.get(0).getAsInt();
				String name = singlePoke.get(1).getAsString();
				int height = singlePoke.get(2).getAsInt();
				int weight = singlePoke.get(3).getAsInt();
				int base_experience = singlePoke.get(4).getAsInt();
				String type_1 = singlePoke.get(5).getAsString();
				String type_2 = singlePoke.get(6).getAsString();
				String sprite_location = singlePoke.get(7).getAsString();
				hiberPoke.addPokemon(id, name, height, weight, base_experience, type_1, type_2, type_2, sprite_location);
		}
		hiberPoke.addPokemon("Close");
		}
		else{out.append("TRY AGAIN");}
		out.close();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	public String getServletInfo() {
		return "Do Actions with HTTP/Hibernate/And return results";
	}
}
