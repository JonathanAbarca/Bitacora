/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bitacora.persistencia;

import com.mycompany.bitacora.logica.SeguridadGabinete;
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
public class SeguridadGabineteJpaController implements Serializable {

    public SeguridadGabineteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public SeguridadGabineteJpaController() {
        emf = Persistence.createEntityManagerFactory("bitacoraPU");
    }
    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SeguridadGabinete seguridadGabinete) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(seguridadGabinete);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SeguridadGabinete seguridadGabinete) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            seguridadGabinete = em.merge(seguridadGabinete);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = seguridadGabinete.getId_SeguridadGabinete();
                if (findSeguridadGabinete(id) == null) {
                    throw new NonexistentEntityException("The seguridadGabinete with id " + id + " no longer exists.");
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
            SeguridadGabinete seguridadGabinete;
            try {
                seguridadGabinete = em.getReference(SeguridadGabinete.class, id);
                seguridadGabinete.getId_SeguridadGabinete();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The seguridadGabinete with id " + id + " no longer exists.", enfe);
            }
            em.remove(seguridadGabinete);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SeguridadGabinete> findSeguridadGabineteEntities() {
        return findSeguridadGabineteEntities(true, -1, -1);
    }

    public List<SeguridadGabinete> findSeguridadGabineteEntities(int maxResults, int firstResult) {
        return findSeguridadGabineteEntities(false, maxResults, firstResult);
    }

    private List<SeguridadGabinete> findSeguridadGabineteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SeguridadGabinete.class));
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

    public SeguridadGabinete findSeguridadGabinete(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SeguridadGabinete.class, id);
        } finally {
            em.close();
        }
    }

    public int getSeguridadGabineteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SeguridadGabinete> rt = cq.from(SeguridadGabinete.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
