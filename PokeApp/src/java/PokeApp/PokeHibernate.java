package PokeApp;

import java.util.Arrays;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
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
	
	public String getPokemon(int pokeid){
		String pokeString;
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		PokemonModel pokeRequest = (PokemonModel) session.get(PokemonModel.class, pokeid);
		pokeString = pokeRequest.toString();
		session.getTransaction().commit();
		return pokeString;
	}
	public String getPokemon(String pokeName){
		String pokeString;
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(PokemonModel.class);
		pokeString = criteria.add(Restrictions.eq("name", pokeName)).uniqueResult().toString();
		session.getTransaction().commit();
		return pokeString;
	}
	
	public String getCount(){
		String count;
		List results;
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		results = session.createSQLQuery("select count(*) from pokeapp.pokemon").list();
		count = results.get(0).toString();
		session.getTransaction().commit();
		return count;
	}
	
}
