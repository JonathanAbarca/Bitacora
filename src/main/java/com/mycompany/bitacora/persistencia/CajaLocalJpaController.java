/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bitacora.persistencia;

import com.mycompany.bitacora.logica.CajaLocal;
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
public class CajaLocalJpaController implements Serializable {

    public CajaLocalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public CajaLocalJpaController() {
        
        emf = Persistence.createEntityManagerFactory("bitacoraPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CajaLocal cajaLocal) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cajaLocal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CajaLocal cajaLocal) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            cajaLocal = em.merge(cajaLocal);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = cajaLocal.getId_CajaLocal();
                if (findCajaLocal(id) == null) {
                    throw new NonexistentEntityException("The cajaLocal with id " + id + " no longer exists.");
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
            CajaLocal cajaLocal;
            try {
                cajaLocal = em.getReference(CajaLocal.class, id);
                cajaLocal.getId_CajaLocal();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cajaLocal with id " + id + " no longer exists.", enfe);
            }
            em.remove(cajaLocal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CajaLocal> findCajaLocalEntities() {
        return findCajaLocalEntities(true, -1, -1);
    }

    public List<CajaLocal> findCajaLocalEntities(int maxResults, int firstResult) {
        return findCajaLocalEntities(false, maxResults, firstResult);
    }

    private List<CajaLocal> findCajaLocalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CajaLocal.class));
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

    public CajaLocal findCajaLocal(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CajaLocal.class, id);
        } finally {
            em.close();
        }
    }

    public int getCajaLocalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CajaLocal> rt = cq.from(CajaLocal.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
