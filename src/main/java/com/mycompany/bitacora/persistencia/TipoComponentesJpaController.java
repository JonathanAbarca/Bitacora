/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bitacora.persistencia;

import com.mycompany.bitacora.logica.TipoComponentes;
import com.mycompany.bitacora.persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.JComboBox;

/**
 *
 * @author Jonathan Abarca
 */
public class TipoComponentesJpaController implements Serializable {
    
    public TipoComponentesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public TipoComponentesJpaController() {
        emf = Persistence.createEntityManagerFactory("bitacoraPU");
    }
    
    
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipoComponentes tipoComponentes) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipoComponentes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipoComponentes tipoComponentes) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipoComponentes = em.merge(tipoComponentes);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = tipoComponentes.getId();
                if (findTipoComponentes(id) == null) {
                    throw new NonexistentEntityException("The tipoComponentes with id " + id + " no longer exists.");
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
            TipoComponentes tipoComponentes;
            try {
                tipoComponentes = em.getReference(TipoComponentes.class, id);
                tipoComponentes.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoComponentes with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipoComponentes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TipoComponentes> findTipoComponentesEntities() {
        return findTipoComponentesEntities(true, -1, -1);
    }

    public List<TipoComponentes> findTipoComponentesEntities(int maxResults, int firstResult) {
        return findTipoComponentesEntities(false, maxResults, firstResult);
    }

    private List<TipoComponentes> findTipoComponentesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoComponentes.class));
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

    public TipoComponentes findTipoComponentes(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoComponentes.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoComponentesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoComponentes> rt = cq.from(TipoComponentes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
