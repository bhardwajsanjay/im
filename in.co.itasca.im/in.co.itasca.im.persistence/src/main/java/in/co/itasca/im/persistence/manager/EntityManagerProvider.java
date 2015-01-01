package in.co.itasca.im.persistence.manager;

import javax.persistence.EntityManager;


public interface EntityManagerProvider {

    EntityManager get();

}
