package PokeApp;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
public class PokeHibernate {
	public PokeHibernate(){
		this.sessionFactory = new Configuration()
				.configure("./hibernate.cfg.xml")
				.addAnnotatedClass(PokemonModel.class)
				.buildSessionFactory();
	}
	private SessionFactory sessionFactory;
	
	
	public void addPokemon(int poke_id, String name, int height, int weight, int base_experience,
				String type_1, String type_2, String species, String sprite_location){
//		SessionFactory sessionFactory;
        Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		PokemonModel newPokemon = new PokemonModel(poke_id,name,height,weight,base_experience,type_1,type_2,sprite_location);
		session.save(newPokemon);
		session.getTransaction().commit();
	}
	
	public void addPokemon(String cls){
		Session session = this.sessionFactory.getCurrentSession();
		if (cls == "Close"){
			session.close();
			this.sessionFactory.close();
		}
	}
	
}
