/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bitacora.persistencia;

import com.mycompany.bitacora.logica.ComponentesInternos;
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
public class ComponentesInternosJpaController implements Serializable {

    public ComponentesInternosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public ComponentesInternosJpaController() {
        emf = Persistence.createEntityManagerFactory("bitacoraPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ComponentesInternos componentesInternos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(componentesInternos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ComponentesInternos componentesInternos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            componentesInternos = em.merge(componentesInternos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = componentesInternos.getId_ComponentesInternos();
                if (findComponentesInternos(id) == null) {
                    throw new NonexistentEntityException("The componentesInternos with id " + id + " no longer exists.");
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
            ComponentesInternos componentesInternos;
            try {
                componentesInternos = em.getReference(ComponentesInternos.class, id);
                componentesInternos.getId_ComponentesInternos();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The componentesInternos with id " + id + " no longer exists.", enfe);
            }
            em.remove(componentesInternos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ComponentesInternos> findComponentesInternosEntities() {
        return findComponentesInternosEntities(true, -1, -1);
    }

    public List<ComponentesInternos> findComponentesInternosEntities(int maxResults, int firstResult) {
        return findComponentesInternosEntities(false, maxResults, firstResult);
    }

    private List<ComponentesInternos> findComponentesInternosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ComponentesInternos.class));
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

    public ComponentesInternos findComponentesInternos(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ComponentesInternos.class, id);
        } finally {
            em.close();
        }
    }

    public int getComponentesInternosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ComponentesInternos> rt = cq.from(ComponentesInternos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
