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
 * A container for entities based on hajo's shop Base class for OrderBook,
 * ProductCatalogue, CustomerRegistry
 *
 * K is type of id (primary key)
 *
 * @author Martin Augustsson, Markus Schützer, Gustaf Werlinder och Patrik
 * Thituson
 */
public abstract class AbstractDAO<T, K> implements IDAO<T, K> {

    protected EntityManagerFactory emf;
    private final Class<T> clazz;

    protected AbstractDAO(Class<T> clazz, String puName) {
        this.clazz = clazz;
        emf = Persistence.createEntityManagerFactory(puName);
    }

    protected EntityManager getEntityManager() {

        EntityManager em = emf.createEntityManager();
        return em;
    }

    /**
     * Adds a object T to the database
     * @param t
     */
    @Override
    public void add(T t) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
        } catch (Exception ex) {
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    /**
     * Removes object T with k id
     * @param id 
     */
    @Override
    public void remove(K id) {
        EntityManager em = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.find(clazz, id));
            em.getTransaction().commit();
        } catch (Exception ex) {
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Updates object T in database
     * @param t 
     */
    @Override
    public void update(T t) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
        } catch (Exception ex) {
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    /**
     * Find object T with K id from database
     * @param id
     * @return  object T wiht K id
     */
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
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return temp;
    }
    
    /**
     * 
     * @return return a List<T> with all object's T from database
     */
    @Override
    public List<T> getAll() {
        return get(true, -1, -1);
    }

    /**
     * @param maxResults
     * @param firstResult
     * @return return a list with objects T from index param firstResult 
     * to index param maxResults
     */
    @Override
    public List<T> getRange(int maxResults, int firstResult) {
        return get(false, maxResults, firstResult);
    }

    /**
     * Counts number of object's T in the database 
     * @return number of number of object's T in the database
     */
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
        } finally {
            em.close();
        }
        return count;
    }

    /**
     * 
     * @param all
     * @param maxResults
     * @param firstResult
     * @return 
     */
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
        } finally {
            em.close();
        }
        return found;
    }
}
