/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cunori.controllers;

import com.cunori.controllers.exceptions.IllegalOrphanException;
import com.cunori.controllers.exceptions.NonexistentEntityException;
import com.cunori.controllers.exceptions.PreexistingEntityException;
import com.cunori.models.Habitacion;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.cunori.models.TipoHabitacion;
import com.cunori.models.Reservacion;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ferna
 */
public class HabitacionJpaController implements Serializable {

    public HabitacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Habitacion habitacion) throws PreexistingEntityException, Exception {
        if (habitacion.getReservacionCollection() == null) {
            habitacion.setReservacionCollection(new ArrayList<Reservacion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipoHabitacion idTipoHabitacion = habitacion.getIdTipoHabitacion();
            if (idTipoHabitacion != null) {
                idTipoHabitacion = em.getReference(idTipoHabitacion.getClass(), idTipoHabitacion.getIdTipoHabitacion());
                habitacion.setIdTipoHabitacion(idTipoHabitacion);
            }
            Collection<Reservacion> attachedReservacionCollection = new ArrayList<Reservacion>();
            for (Reservacion reservacionCollectionReservacionToAttach : habitacion.getReservacionCollection()) {
                reservacionCollectionReservacionToAttach = em.getReference(reservacionCollectionReservacionToAttach.getClass(), reservacionCollectionReservacionToAttach.getIdReservacion());
                attachedReservacionCollection.add(reservacionCollectionReservacionToAttach);
            }
            habitacion.setReservacionCollection(attachedReservacionCollection);
            em.persist(habitacion);
            if (idTipoHabitacion != null) {
                idTipoHabitacion.getHabitacionCollection().add(habitacion);
                idTipoHabitacion = em.merge(idTipoHabitacion);
            }
            for (Reservacion reservacionCollectionReservacion : habitacion.getReservacionCollection()) {
                Habitacion oldNumeroHabitacionOfReservacionCollectionReservacion = reservacionCollectionReservacion.getNumeroHabitacion();
                reservacionCollectionReservacion.setNumeroHabitacion(habitacion);
                reservacionCollectionReservacion = em.merge(reservacionCollectionReservacion);
                if (oldNumeroHabitacionOfReservacionCollectionReservacion != null) {
                    oldNumeroHabitacionOfReservacionCollectionReservacion.getReservacionCollection().remove(reservacionCollectionReservacion);
                    oldNumeroHabitacionOfReservacionCollectionReservacion = em.merge(oldNumeroHabitacionOfReservacionCollectionReservacion);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findHabitacion(habitacion.getNumeroHabitacion()) != null) {
                throw new PreexistingEntityException("Habitacion " + habitacion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Habitacion habitacion) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Habitacion persistentHabitacion = em.find(Habitacion.class, habitacion.getNumeroHabitacion());
            TipoHabitacion idTipoHabitacionOld = persistentHabitacion.getIdTipoHabitacion();
            TipoHabitacion idTipoHabitacionNew = habitacion.getIdTipoHabitacion();
            Collection<Reservacion> reservacionCollectionOld = persistentHabitacion.getReservacionCollection();
            Collection<Reservacion> reservacionCollectionNew = habitacion.getReservacionCollection();
            List<String> illegalOrphanMessages = null;
            for (Reservacion reservacionCollectionOldReservacion : reservacionCollectionOld) {
                if (!reservacionCollectionNew.contains(reservacionCollectionOldReservacion)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Reservacion " + reservacionCollectionOldReservacion + " since its numeroHabitacion field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idTipoHabitacionNew != null) {
                idTipoHabitacionNew = em.getReference(idTipoHabitacionNew.getClass(), idTipoHabitacionNew.getIdTipoHabitacion());
                habitacion.setIdTipoHabitacion(idTipoHabitacionNew);
            }
            Collection<Reservacion> attachedReservacionCollectionNew = new ArrayList<Reservacion>();
            for (Reservacion reservacionCollectionNewReservacionToAttach : reservacionCollectionNew) {
                reservacionCollectionNewReservacionToAttach = em.getReference(reservacionCollectionNewReservacionToAttach.getClass(), reservacionCollectionNewReservacionToAttach.getIdReservacion());
                attachedReservacionCollectionNew.add(reservacionCollectionNewReservacionToAttach);
            }
            reservacionCollectionNew = attachedReservacionCollectionNew;
            habitacion.setReservacionCollection(reservacionCollectionNew);
            habitacion = em.merge(habitacion);
            if (idTipoHabitacionOld != null && !idTipoHabitacionOld.equals(idTipoHabitacionNew)) {
                idTipoHabitacionOld.getHabitacionCollection().remove(habitacion);
                idTipoHabitacionOld = em.merge(idTipoHabitacionOld);
            }
            if (idTipoHabitacionNew != null && !idTipoHabitacionNew.equals(idTipoHabitacionOld)) {
                idTipoHabitacionNew.getHabitacionCollection().add(habitacion);
                idTipoHabitacionNew = em.merge(idTipoHabitacionNew);
            }
            for (Reservacion reservacionCollectionNewReservacion : reservacionCollectionNew) {
                if (!reservacionCollectionOld.contains(reservacionCollectionNewReservacion)) {
                    Habitacion oldNumeroHabitacionOfReservacionCollectionNewReservacion = reservacionCollectionNewReservacion.getNumeroHabitacion();
                    reservacionCollectionNewReservacion.setNumeroHabitacion(habitacion);
                    reservacionCollectionNewReservacion = em.merge(reservacionCollectionNewReservacion);
                    if (oldNumeroHabitacionOfReservacionCollectionNewReservacion != null && !oldNumeroHabitacionOfReservacionCollectionNewReservacion.equals(habitacion)) {
                        oldNumeroHabitacionOfReservacionCollectionNewReservacion.getReservacionCollection().remove(reservacionCollectionNewReservacion);
                        oldNumeroHabitacionOfReservacionCollectionNewReservacion = em.merge(oldNumeroHabitacionOfReservacionCollectionNewReservacion);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Short id = habitacion.getNumeroHabitacion();
                if (findHabitacion(id) == null) {
                    throw new NonexistentEntityException("The habitacion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Short id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Habitacion habitacion;
            try {
                habitacion = em.getReference(Habitacion.class, id);
                habitacion.getNumeroHabitacion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The habitacion with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Reservacion> reservacionCollectionOrphanCheck = habitacion.getReservacionCollection();
            for (Reservacion reservacionCollectionOrphanCheckReservacion : reservacionCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Habitacion (" + habitacion + ") cannot be destroyed since the Reservacion " + reservacionCollectionOrphanCheckReservacion + " in its reservacionCollection field has a non-nullable numeroHabitacion field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            TipoHabitacion idTipoHabitacion = habitacion.getIdTipoHabitacion();
            if (idTipoHabitacion != null) {
                idTipoHabitacion.getHabitacionCollection().remove(habitacion);
                idTipoHabitacion = em.merge(idTipoHabitacion);
            }
            em.remove(habitacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Habitacion> findHabitacionEntities() {
        return findHabitacionEntities(true, -1, -1);
    }

    public List<Habitacion> findHabitacionEntities(int maxResults, int firstResult) {
        return findHabitacionEntities(false, maxResults, firstResult);
    }

    private List<Habitacion> findHabitacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Habitacion.class));
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

    public Habitacion findHabitacion(Short id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Habitacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getHabitacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Habitacion> rt = cq.from(Habitacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
