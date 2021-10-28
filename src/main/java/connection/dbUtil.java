package connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class dbUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("k19WebApp");

    public static EntityManagerFactory getEMF() {
        return emf;
    }
}
