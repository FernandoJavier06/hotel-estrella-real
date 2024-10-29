/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cunori.controllers;

import com.cunori.controllers.exceptions.IllegalOrphanException;
import com.cunori.controllers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.cunori.models.Habitacion;
import com.cunori.models.TipoHabitacion;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ferna
 */
public class TipoHabitacionJpaController implements Serializable {

    public TipoHabitacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipoHabitacion tipoHabitacion) {
        if (tipoHabitacion.getHabitacionCollection() == null) {
            tipoHabitacion.setHabitacionCollection(new ArrayList<Habitacion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Habitacion> attachedHabitacionCollection = new ArrayList<Habitacion>();
            for (Habitacion habitacionCollectionHabitacionToAttach : tipoHabitacion.getHabitacionCollection()) {
                habitacionCollectionHabitacionToAttach = em.getReference(habitacionCollectionHabitacionToAttach.getClass(), habitacionCollectionHabitacionToAttach.getNumeroHabitacion());
                attachedHabitacionCollection.add(habitacionCollectionHabitacionToAttach);
            }
            tipoHabitacion.setHabitacionCollection(attachedHabitacionCollection);
            em.persist(tipoHabitacion);
            for (Habitacion habitacionCollectionHabitacion : tipoHabitacion.getHabitacionCollection()) {
                TipoHabitacion oldIdTipoHabitacionOfHabitacionCollectionHabitacion = habitacionCollectionHabitacion.getIdTipoHabitacion();
                habitacionCollectionHabitacion.setIdTipoHabitacion(tipoHabitacion);
                habitacionCollectionHabitacion = em.merge(habitacionCollectionHabitacion);
                if (oldIdTipoHabitacionOfHabitacionCollectionHabitacion != null) {
                    oldIdTipoHabitacionOfHabitacionCollectionHabitacion.getHabitacionCollection().remove(habitacionCollectionHabitacion);
                    oldIdTipoHabitacionOfHabitacionCollectionHabitacion = em.merge(oldIdTipoHabitacionOfHabitacionCollectionHabitacion);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipoHabitacion tipoHabitacion) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipoHabitacion persistentTipoHabitacion = em.find(TipoHabitacion.class, tipoHabitacion.getIdTipoHabitacion());
            Collection<Habitacion> habitacionCollectionOld = persistentTipoHabitacion.getHabitacionCollection();
            Collection<Habitacion> habitacionCollectionNew = tipoHabitacion.getHabitacionCollection();
            List<String> illegalOrphanMessages = null;
            for (Habitacion habitacionCollectionOldHabitacion : habitacionCollectionOld) {
                if (!habitacionCollectionNew.contains(habitacionCollectionOldHabitacion)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Habitacion " + habitacionCollectionOldHabitacion + " since its idTipoHabitacion field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Habitacion> attachedHabitacionCollectionNew = new ArrayList<Habitacion>();
            for (Habitacion habitacionCollectionNewHabitacionToAttach : habitacionCollectionNew) {
                habitacionCollectionNewHabitacionToAttach = em.getReference(habitacionCollectionNewHabitacionToAttach.getClass(), habitacionCollectionNewHabitacionToAttach.getNumeroHabitacion());
                attachedHabitacionCollectionNew.add(habitacionCollectionNewHabitacionToAttach);
            }
            habitacionCollectionNew = attachedHabitacionCollectionNew;
            tipoHabitacion.setHabitacionCollection(habitacionCollectionNew);
            tipoHabitacion = em.merge(tipoHabitacion);
            for (Habitacion habitacionCollectionNewHabitacion : habitacionCollectionNew) {
                if (!habitacionCollectionOld.contains(habitacionCollectionNewHabitacion)) {
                    TipoHabitacion oldIdTipoHabitacionOfHabitacionCollectionNewHabitacion = habitacionCollectionNewHabitacion.getIdTipoHabitacion();
                    habitacionCollectionNewHabitacion.setIdTipoHabitacion(tipoHabitacion);
                    habitacionCollectionNewHabitacion = em.merge(habitacionCollectionNewHabitacion);
                    if (oldIdTipoHabitacionOfHabitacionCollectionNewHabitacion != null && !oldIdTipoHabitacionOfHabitacionCollectionNewHabitacion.equals(tipoHabitacion)) {
                        oldIdTipoHabitacionOfHabitacionCollectionNewHabitacion.getHabitacionCollection().remove(habitacionCollectionNewHabitacion);
                        oldIdTipoHabitacionOfHabitacionCollectionNewHabitacion = em.merge(oldIdTipoHabitacionOfHabitacionCollectionNewHabitacion);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tipoHabitacion.getIdTipoHabitacion();
                if (findTipoHabitacion(id) == null) {
                    throw new NonexistentEntityException("The tipoHabitacion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipoHabitacion tipoHabitacion;
            try {
                tipoHabitacion = em.getReference(TipoHabitacion.class, id);
                tipoHabitacion.getIdTipoHabitacion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoHabitacion with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Habitacion> habitacionCollectionOrphanCheck = tipoHabitacion.getHabitacionCollection();
            for (Habitacion habitacionCollectionOrphanCheckHabitacion : habitacionCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This TipoHabitacion (" + tipoHabitacion + ") cannot be destroyed since the Habitacion " + habitacionCollectionOrphanCheckHabitacion + " in its habitacionCollection field has a non-nullable idTipoHabitacion field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(tipoHabitacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TipoHabitacion> findTipoHabitacionEntities() {
        return findTipoHabitacionEntities(true, -1, -1);
    }

    public List<TipoHabitacion> findTipoHabitacionEntities(int maxResults, int firstResult) {
        return findTipoHabitacionEntities(false, maxResults, firstResult);
    }

    private List<TipoHabitacion> findTipoHabitacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoHabitacion.class));
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

    public TipoHabitacion findTipoHabitacion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoHabitacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoHabitacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoHabitacion> rt = cq.from(TipoHabitacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
