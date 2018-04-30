package test_jpa.test_jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestJpa {
	
//	private static final Logger LOG = LoggerFactory.getLogger(TestJpa.class);
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pizza-jpa");
		EntityManager em = entityManagerFactory.createEntityManager();		
	}

}
