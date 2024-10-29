/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cunori.controllers;

import com.cunori.controllers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.cunori.models.Factura;
import com.cunori.models.Habitacion;
import com.cunori.models.Reservacion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ferna
 */
public class ReservacionJpaController implements Serializable {

    public ReservacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Reservacion reservacion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Factura idFactura = reservacion.getIdFactura();
            if (idFactura != null) {
                idFactura = em.getReference(idFactura.getClass(), idFactura.getIdFactura());
                reservacion.setIdFactura(idFactura);
            }
            Habitacion numeroHabitacion = reservacion.getNumeroHabitacion();
            if (numeroHabitacion != null) {
                numeroHabitacion = em.getReference(numeroHabitacion.getClass(), numeroHabitacion.getNumeroHabitacion());
                reservacion.setNumeroHabitacion(numeroHabitacion);
            }
            em.persist(reservacion);
            if (idFactura != null) {
                idFactura.getReservacionCollection().add(reservacion);
                idFactura = em.merge(idFactura);
            }
            if (numeroHabitacion != null) {
                numeroHabitacion.getReservacionCollection().add(reservacion);
                numeroHabitacion = em.merge(numeroHabitacion);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Reservacion reservacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reservacion persistentReservacion = em.find(Reservacion.class, reservacion.getIdReservacion());
            Factura idFacturaOld = persistentReservacion.getIdFactura();
            Factura idFacturaNew = reservacion.getIdFactura();
            Habitacion numeroHabitacionOld = persistentReservacion.getNumeroHabitacion();
            Habitacion numeroHabitacionNew = reservacion.getNumeroHabitacion();
            if (idFacturaNew != null) {
                idFacturaNew = em.getReference(idFacturaNew.getClass(), idFacturaNew.getIdFactura());
                reservacion.setIdFactura(idFacturaNew);
            }
            if (numeroHabitacionNew != null) {
                numeroHabitacionNew = em.getReference(numeroHabitacionNew.getClass(), numeroHabitacionNew.getNumeroHabitacion());
                reservacion.setNumeroHabitacion(numeroHabitacionNew);
            }
            reservacion = em.merge(reservacion);
            if (idFacturaOld != null && !idFacturaOld.equals(idFacturaNew)) {
                idFacturaOld.getReservacionCollection().remove(reservacion);
                idFacturaOld = em.merge(idFacturaOld);
            }
            if (idFacturaNew != null && !idFacturaNew.equals(idFacturaOld)) {
                idFacturaNew.getReservacionCollection().add(reservacion);
                idFacturaNew = em.merge(idFacturaNew);
            }
            if (numeroHabitacionOld != null && !numeroHabitacionOld.equals(numeroHabitacionNew)) {
                numeroHabitacionOld.getReservacionCollection().remove(reservacion);
                numeroHabitacionOld = em.merge(numeroHabitacionOld);
            }
            if (numeroHabitacionNew != null && !numeroHabitacionNew.equals(numeroHabitacionOld)) {
                numeroHabitacionNew.getReservacionCollection().add(reservacion);
                numeroHabitacionNew = em.merge(numeroHabitacionNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = reservacion.getIdReservacion();
                if (findReservacion(id) == null) {
                    throw new NonexistentEntityException("The reservacion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reservacion reservacion;
            try {
                reservacion = em.getReference(Reservacion.class, id);
                reservacion.getIdReservacion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reservacion with id " + id + " no longer exists.", enfe);
            }
            Factura idFactura = reservacion.getIdFactura();
            if (idFactura != null) {
                idFactura.getReservacionCollection().remove(reservacion);
                idFactura = em.merge(idFactura);
            }
            Habitacion numeroHabitacion = reservacion.getNumeroHabitacion();
            if (numeroHabitacion != null) {
                numeroHabitacion.getReservacionCollection().remove(reservacion);
                numeroHabitacion = em.merge(numeroHabitacion);
            }
            em.remove(reservacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Reservacion> findReservacionEntities() {
        return findReservacionEntities(true, -1, -1);
    }

    public List<Reservacion> findReservacionEntities(int maxResults, int firstResult) {
        return findReservacionEntities(false, maxResults, firstResult);
    }

    private List<Reservacion> findReservacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Reservacion.class));
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

    public Reservacion findReservacion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Reservacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getReservacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Reservacion> rt = cq.from(Reservacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
