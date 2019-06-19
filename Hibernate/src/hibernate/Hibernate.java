/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.util.Arrays;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
/**
 *
 * @author sirri
 */
public class Hibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SessionFactory sessionFactory;
		sessionFactory = new Configuration()
				.configure("./hibernate.cfg.xml")
				.addAnnotatedClass(FilmModel.class)
				.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		Object id = session.get(FilmModel.class, 5);
		System.out.println(id.toString());
		List select = session.createSQLQuery("Select * from newfilm where film_id in (1,2,3,4)").list();
		for (int i=0;i<select.size();i++){
			System.out.println(Arrays.toString((Object[]) select.get(i)));
			}
		FilmModel addFilm = new FilmModel("Ace Ventura: Pet Detective","A slightly insane detecitve investigates a missing animal case.",1994,1.50,87,5.50);
		session.save(addFilm);
		session.getTransaction().commit();
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Object newFilm = session.get(FilmModel.class, 1001);
		System.out.println(newFilm.toString());
		session.close();
		sessionFactory.close();
    }
    
}
