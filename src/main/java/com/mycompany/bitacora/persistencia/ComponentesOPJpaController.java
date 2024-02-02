/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bitacora.persistencia;

import com.mycompany.bitacora.logica.ComponentesOP;
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
public class ComponentesOPJpaController implements Serializable {

    public ComponentesOPJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public ComponentesOPJpaController() {
        emf = Persistence.createEntityManagerFactory("bitacoraPU");
    }
    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ComponentesOP componentesOP) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(componentesOP);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ComponentesOP componentesOP) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            componentesOP = em.merge(componentesOP);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = componentesOP.getId_Componentes();
                if (findComponentesOP(id) == null) {
                    throw new NonexistentEntityException("The componentesOP with id " + id + " no longer exists.");
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
            ComponentesOP componentesOP;
            try {
                componentesOP = em.getReference(ComponentesOP.class, id);
                componentesOP.getId_Componentes();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The componentesOP with id " + id + " no longer exists.", enfe);
            }
            em.remove(componentesOP);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ComponentesOP> findComponentesOPEntities() {
        return findComponentesOPEntities(true, -1, -1);
    }

    public List<ComponentesOP> findComponentesOPEntities(int maxResults, int firstResult) {
        return findComponentesOPEntities(false, maxResults, firstResult);
    }

    private List<ComponentesOP> findComponentesOPEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ComponentesOP.class));
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

    public ComponentesOP findComponentesOP(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ComponentesOP.class, id);
        } finally {
            em.close();
        }
    }

    public int getComponentesOPCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ComponentesOP> rt = cq.from(ComponentesOP.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
