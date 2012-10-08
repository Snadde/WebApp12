    package core;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * A container for entities
 * Base class for OrderBook, ProductCatalogue, CustomerRegistry
 * 
 * K is type of id (primary key)
 * 
 * @author hajo
 */
public abstract class AbstractDAO<T , K> implements IDAO<T, K> {

    protected EntityManagerFactory emf;
    private final Class<T> clazz;
    
    protected AbstractDAO(Class<T> clazz, String puName) {
        this.clazz = clazz;
        emf = Persistence.createEntityManagerFactory(puName);
    }
    
    protected EntityManager getEntityManager() {
       
        EntityManager em = emf.createEntityManager();
        // Logger.getAnonymousLogger().log(Level.INFO, "Createing EM {0}", em);
        return em;
    }

    @Override
    public void add(T t) {
         EntityManager em = null;
        try {
            em = getEntityManager();    
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
        } catch (Exception ex) {
            //DbExceptionHandler.handle(ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
    }

    @Override
    public void remove(K id) {
               EntityManager em = null;
              // T t = null;
        try {
            em = getEntityManager();    
            em.getTransaction().begin();
            em.remove(em.find(clazz, id));             
            em.getTransaction().commit();
        } catch (Exception ex) {
            //DbExceptionHandler.handle(ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
        
    }

    @Override
    public void update(T t) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
        } catch (Exception ex) {
           // DbExceptionHandler.handle(ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

    @Override
    public T find(K id) {    
        T temp = null;
        EntityManager em = null;
        try {
            em = getEntityManager();    
            em.getTransaction().begin();
          temp = em.find(clazz, id);
            em.getTransaction().commit();
        } catch (Exception ex) {
            //DbExceptionHandler.handle(ex);
        } finally {
            if (em != null) {
                em.close();
            }
           
        }
         return temp;
        
    }

    @Override
    public List<T> getAll() {
        return get(true, -1, -1);
    }

    @Override
    public List<T> getRange(int maxResults, int firstResult) {
        return get(false, maxResults, firstResult);
    }

    @Override
    public int getCount() {
        EntityManager em = getEntityManager();
        int count = -1;
        try {
            
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<T> rt = cq.from(clazz);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            count = ((Long) q.getSingleResult()).intValue();
        } catch (Exception ex) {
           // DbExceptionHandler.handle(ex);
        } finally {
            em.close();
        }
        return count;
    }
    
    private List<T> get(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        List<T> found = new ArrayList<>();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(clazz));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            found.addAll(q.getResultList());
        } catch (Exception ex) {
            //DbExceptionHandler.handle(ex);
        } finally {
            em.close();
        }
        return found;
    }
}
