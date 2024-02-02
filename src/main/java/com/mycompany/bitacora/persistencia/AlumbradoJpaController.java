/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bitacora.persistencia;

import com.mycompany.bitacora.logica.Alumbrado;
import com.mycompany.bitacora.persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Jonathan Abarca
 */
public class AlumbradoJpaController implements Serializable {

    public AlumbradoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public AlumbradoJpaController() {        
        emf = Persistence.createEntityManagerFactory("bitacoraPU");
    }
    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Alumbrado alumbrado) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(alumbrado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Alumbrado alumbrado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            alumbrado = em.merge(alumbrado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = alumbrado.getId_alumbrado();
                if (findAlumbrado(id) == null) {
                    throw new NonexistentEntityException("The alumbrado with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Alumbrado alumbrado;
            try {
                alumbrado = em.getReference(Alumbrado.class, id);
                alumbrado.getId_alumbrado();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The alumbrado with id " + id + " no longer exists.", enfe);
            }
            em.remove(alumbrado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Alumbrado> findAlumbradoEntities() {
        return findAlumbradoEntities(true, -1, -1);
    }

    public List<Alumbrado> findAlumbradoEntities(int maxResults, int firstResult) {
        return findAlumbradoEntities(false, maxResults, firstResult);
    }

    private List<Alumbrado> findAlumbradoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Alumbrado.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Alumbrado findAlumbrado(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Alumbrado.class, id);
        } finally {
            em.close();
        }
    }

    public int getAlumbradoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Alumbrado> rt = cq.from(Alumbrado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
