package PokeApp;


//import com.mysql.jdbc.Blob;
import java.sql.Blob;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
public class PokeHibernate {
	
	public void addPokemon(int poke_id, String name, int height, int weight, int base_experience,
				String type_1, String type_2, String species, Blob sprite, String sprite_api_location){
		SessionFactory sessionFactory;
		sessionFactory = new Configuration()
				.configure("./hibernate.cfg.xml")
				.addAnnotatedClass(PokemonModel.class)
				.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		PokemonModel newPokemon = new PokemonModel(poke_id,name,height,weight,base_experience,type_1,type_2,species,sprite,sprite_api_location);
		session.save(newPokemon);
		session.getTransaction().commit();
	}
	
}
