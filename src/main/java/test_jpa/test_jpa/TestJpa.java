package test_jpa.test_jpa;

import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestJpa {

	private static final Logger LOG = LoggerFactory.getLogger(TestJpa.class);

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pizza-jpa");
		EntityManager em = entityManagerFactory.createEntityManager();

		Livre livre = em.find(Livre.class, 1);
		LOG.info("");
		LOG.info("ID: " + livre.getId() + " titre: " + livre.getTitre() + " auteur: " + livre.getAuteur());
		LOG.info("");
		
		Query query1 = em.createQuery("select l from Livre l where l.titre='Germinal'");
		Livre germinal = (Livre) query1.getResultList().get(0);
		LOG.info("Germinal");
		LOG.info("ID: " + germinal.getId() + " titre: " + germinal.getTitre() + " auteur: " + germinal.getAuteur());
		
		Query query2 = em.createQuery("select c from Client c where c.prenom='Pierre'");
		Client pierre = (Client) query2.getResultList().get(0);
		LOG.info("Pierre");
		LOG.info("ID: " + pierre.getId() + " Prenom: " + pierre.getPrenom() + " Nom: " + pierre.getNom());
		
		Query query3 = em.createQuery("select e from Emprunt e where e.id=1");
		Emprunt emprunt = (Emprunt) query3.getResultList().get(0);
		Iterator<Livre> iteratorLivre = emprunt.getLivres().iterator();
		while(iteratorLivre.hasNext()){
			LOG.info(iteratorLivre.next().getTitre());
		}
		
		Query query4 = em.createQuery("select c from Client c where c.prenom='Hicham'");
		Client client = (Client) query4.getResultList().get(0);
		Iterator<Emprunt> iteratorEmprunt = client.getEmprunts().iterator();
		while(iteratorEmprunt.hasNext()){
			LOG.info(iteratorEmprunt.next().getDateDebut().toString());
		}
		
	}

}
