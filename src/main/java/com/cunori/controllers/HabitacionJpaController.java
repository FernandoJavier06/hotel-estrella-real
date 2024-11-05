/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cunori.controllers;

import com.cunori.controllers.exceptions.NonexistentEntityException;
import com.cunori.controllers.exceptions.PreexistingEntityException;
import com.cunori.models.Habitacion;
import com.cunori.models.HabitacionDisponibleDTO;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.cunori.models.TipoHabitacion;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

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
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipoHabitacion idTipoHabitacion = habitacion.getIdTipoHabitacion();
            if (idTipoHabitacion != null) {
                idTipoHabitacion = em.getReference(idTipoHabitacion.getClass(), idTipoHabitacion.getIdTipoHabitacion());
                habitacion.setIdTipoHabitacion(idTipoHabitacion);
            }
            em.persist(habitacion);
            if (idTipoHabitacion != null) {
                idTipoHabitacion.getHabitacionCollection().add(habitacion);
                idTipoHabitacion = em.merge(idTipoHabitacion);
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

    public void edit(Habitacion habitacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Habitacion persistentHabitacion = em.find(Habitacion.class, habitacion.getNumeroHabitacion());
            TipoHabitacion idTipoHabitacionOld = persistentHabitacion.getIdTipoHabitacion();
            TipoHabitacion idTipoHabitacionNew = habitacion.getIdTipoHabitacion();
            if (idTipoHabitacionNew != null) {
                idTipoHabitacionNew = em.getReference(idTipoHabitacionNew.getClass(), idTipoHabitacionNew.getIdTipoHabitacion());
                habitacion.setIdTipoHabitacion(idTipoHabitacionNew);
            }
            habitacion = em.merge(habitacion);
            if (idTipoHabitacionOld != null && !idTipoHabitacionOld.equals(idTipoHabitacionNew)) {
                idTipoHabitacionOld.getHabitacionCollection().remove(habitacion);
                idTipoHabitacionOld = em.merge(idTipoHabitacionOld);
            }
            if (idTipoHabitacionNew != null && !idTipoHabitacionNew.equals(idTipoHabitacionOld)) {
                idTipoHabitacionNew.getHabitacionCollection().add(habitacion);
                idTipoHabitacionNew = em.merge(idTipoHabitacionNew);
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

    public void destroy(Short id) throws NonexistentEntityException {
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

    public List<Habitacion> obtenerHabitacionesDisponibles(Date fechaInicio, Date fechaFinal) {
        EntityManager em = getEntityManager();
        try {
            //Se define la consulta JPQL
            /*String jpql = "SELECT new com.cunori.models.HabitacionDisponibleDTO(h.numeroHabitacion,t.nombre,t.precio) "
                    + "FROM Habitacion h INNER JOIN TipoHabitacion t ON h.idTipoHabitacion = t.idTipoHabitacion "
                    + "WHERE h.numeroHabitacion NOT IN (SELECT r.numeroHabitacion FROM Reservacion r "
                    + "WHERE (r.checkOut > :fechaInicio AND r.checkIn < :fechaFinal))";
            
            //Crear la consulta
            TypedQuery<HabitacionDisponibleDTO> query = em.createQuery(jpql, HabitacionDisponibleDTO.class);
            query.setParameter("fechaInicio", fechaInicio);
            query.setParameter("fechaFinal", fechaFinal);*/

            Query query = em.createQuery("SELECT h FROM Habitacion h WHERE NOT (h.numeroHabitacion.)");
            query.setParameter("fechaInicio", fechaInicio);
            query.setParameter("fechaFinal", fechaFinal);
            /*Query query = em.createQuery("SELECT h "
                    + "FROM Habitacion h "
                    + "LEFT JOIN Reservacion r ON h.numeroHabitacion = r.numeroHabitacion");*/

            //Ejecutar la consulta 
            //List<Object[]> resultado = query.getResultList();
            return query.getResultList();
        } finally {
            em.close();
        }
    }

}
