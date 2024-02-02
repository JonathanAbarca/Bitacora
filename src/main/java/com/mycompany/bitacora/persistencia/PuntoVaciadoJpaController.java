/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bitacora.persistencia;

import com.mycompany.bitacora.logica.PuntoVaciado;
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
public class PuntoVaciadoJpaController implements Serializable {

    public PuntoVaciadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public PuntoVaciadoJpaController() {
        emf = Persistence.createEntityManagerFactory("bitacoraPU");
    }
    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PuntoVaciado puntoVaciado) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(puntoVaciado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PuntoVaciado puntoVaciado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            puntoVaciado = em.merge(puntoVaciado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = puntoVaciado.getId_PuntoVaciado();
                if (findPuntoVaciado(id) == null) {
                    throw new NonexistentEntityException("The puntoVaciado with id " + id + " no longer exists.");
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
            PuntoVaciado puntoVaciado;
            try {
                puntoVaciado = em.getReference(PuntoVaciado.class, id);
                puntoVaciado.getId_PuntoVaciado();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The puntoVaciado with id " + id + " no longer exists.", enfe);
            }
            em.remove(puntoVaciado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PuntoVaciado> findPuntoVaciadoEntities() {
        return findPuntoVaciadoEntities(true, -1, -1);
    }

    public List<PuntoVaciado> findPuntoVaciadoEntities(int maxResults, int firstResult) {
        return findPuntoVaciadoEntities(false, maxResults, firstResult);
    }

    private List<PuntoVaciado> findPuntoVaciadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PuntoVaciado.class));
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

    public PuntoVaciado findPuntoVaciado(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PuntoVaciado.class, id);
        } finally {
            em.close();
        }
    }

    public int getPuntoVaciadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PuntoVaciado> rt = cq.from(PuntoVaciado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
