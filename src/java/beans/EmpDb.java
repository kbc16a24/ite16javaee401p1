package beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EmpDb {

    @PersistenceContext
    private EntityManager em;

    public void create(Emp emp) {
        em.persist(emp);
    }

    public void update(Emp emp) {
        em.merge(emp);
    }

    public void delete(Emp emp) {
        em.remove(em.merge(emp));  
    }

    public Emp find(Integer key) {
        return em.find(Emp.class, key);
    }

    public List<Emp> getAll() {
        return em.createQuery("SELECT c FROM Emp c").getResultList();
    }
    
    public List<Emp> csv() {
        return em.createQuery("SELECT c FROM Emp c").getResultList();
    }
}
