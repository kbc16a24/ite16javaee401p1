package beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BloodDb {

    @PersistenceContext
    private EntityManager emb;

    public void create(Blood blood) {
        emb.persist(blood);
    }

    public void update(Blood blood) {
        emb.merge(blood);
    }

    public void delete(Blood blood) {
        emb.remove(emb.merge(blood));  
    }

    public Blood find(String key) {
        return emb.find(Blood.class, key);
    }

    public List<Blood> getAll() {
        return emb.createQuery("SELECT c FROM Blood c").getResultList();
    }
}
