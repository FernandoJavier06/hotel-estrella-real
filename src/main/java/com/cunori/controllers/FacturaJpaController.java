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
import com.cunori.models.Cliente;
import com.cunori.models.Factura;
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
public class FacturaJpaController implements Serializable {

    public FacturaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Factura factura) {
        if (factura.getReservacionCollection() == null) {
            factura.setReservacionCollection(new ArrayList<Reservacion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente nitCliente = factura.getNitCliente();
            if (nitCliente != null) {
                nitCliente = em.getReference(nitCliente.getClass(), nitCliente.getNitCliente());
                factura.setNitCliente(nitCliente);
            }
            Collection<Reservacion> attachedReservacionCollection = new ArrayList<Reservacion>();
            for (Reservacion reservacionCollectionReservacionToAttach : factura.getReservacionCollection()) {
                reservacionCollectionReservacionToAttach = em.getReference(reservacionCollectionReservacionToAttach.getClass(), reservacionCollectionReservacionToAttach.getIdReservacion());
                attachedReservacionCollection.add(reservacionCollectionReservacionToAttach);
            }
            factura.setReservacionCollection(attachedReservacionCollection);
            em.persist(factura);
            if (nitCliente != null) {
                nitCliente.getFacturaCollection().add(factura);
                nitCliente = em.merge(nitCliente);
            }
            for (Reservacion reservacionCollectionReservacion : factura.getReservacionCollection()) {
                Factura oldIdFacturaOfReservacionCollectionReservacion = reservacionCollectionReservacion.getIdFactura();
                reservacionCollectionReservacion.setIdFactura(factura);
                reservacionCollectionReservacion = em.merge(reservacionCollectionReservacion);
                if (oldIdFacturaOfReservacionCollectionReservacion != null) {
                    oldIdFacturaOfReservacionCollectionReservacion.getReservacionCollection().remove(reservacionCollectionReservacion);
                    oldIdFacturaOfReservacionCollectionReservacion = em.merge(oldIdFacturaOfReservacionCollectionReservacion);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Factura factura) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Factura persistentFactura = em.find(Factura.class, factura.getIdFactura());
            Cliente nitClienteOld = persistentFactura.getNitCliente();
            Cliente nitClienteNew = factura.getNitCliente();
            Collection<Reservacion> reservacionCollectionOld = persistentFactura.getReservacionCollection();
            Collection<Reservacion> reservacionCollectionNew = factura.getReservacionCollection();
            List<String> illegalOrphanMessages = null;
            for (Reservacion reservacionCollectionOldReservacion : reservacionCollectionOld) {
                if (!reservacionCollectionNew.contains(reservacionCollectionOldReservacion)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Reservacion " + reservacionCollectionOldReservacion + " since its idFactura field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (nitClienteNew != null) {
                nitClienteNew = em.getReference(nitClienteNew.getClass(), nitClienteNew.getNitCliente());
                factura.setNitCliente(nitClienteNew);
            }
            Collection<Reservacion> attachedReservacionCollectionNew = new ArrayList<Reservacion>();
            for (Reservacion reservacionCollectionNewReservacionToAttach : reservacionCollectionNew) {
                reservacionCollectionNewReservacionToAttach = em.getReference(reservacionCollectionNewReservacionToAttach.getClass(), reservacionCollectionNewReservacionToAttach.getIdReservacion());
                attachedReservacionCollectionNew.add(reservacionCollectionNewReservacionToAttach);
            }
            reservacionCollectionNew = attachedReservacionCollectionNew;
            factura.setReservacionCollection(reservacionCollectionNew);
            factura = em.merge(factura);
            if (nitClienteOld != null && !nitClienteOld.equals(nitClienteNew)) {
                nitClienteOld.getFacturaCollection().remove(factura);
                nitClienteOld = em.merge(nitClienteOld);
            }
            if (nitClienteNew != null && !nitClienteNew.equals(nitClienteOld)) {
                nitClienteNew.getFacturaCollection().add(factura);
                nitClienteNew = em.merge(nitClienteNew);
            }
            for (Reservacion reservacionCollectionNewReservacion : reservacionCollectionNew) {
                if (!reservacionCollectionOld.contains(reservacionCollectionNewReservacion)) {
                    Factura oldIdFacturaOfReservacionCollectionNewReservacion = reservacionCollectionNewReservacion.getIdFactura();
                    reservacionCollectionNewReservacion.setIdFactura(factura);
                    reservacionCollectionNewReservacion = em.merge(reservacionCollectionNewReservacion);
                    if (oldIdFacturaOfReservacionCollectionNewReservacion != null && !oldIdFacturaOfReservacionCollectionNewReservacion.equals(factura)) {
                        oldIdFacturaOfReservacionCollectionNewReservacion.getReservacionCollection().remove(reservacionCollectionNewReservacion);
                        oldIdFacturaOfReservacionCollectionNewReservacion = em.merge(oldIdFacturaOfReservacionCollectionNewReservacion);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = factura.getIdFactura();
                if (findFactura(id) == null) {
                    throw new NonexistentEntityException("The factura with id " + id + " no longer exists.");
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
            Factura factura;
            try {
                factura = em.getReference(Factura.class, id);
                factura.getIdFactura();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The factura with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Reservacion> reservacionCollectionOrphanCheck = factura.getReservacionCollection();
            for (Reservacion reservacionCollectionOrphanCheckReservacion : reservacionCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Factura (" + factura + ") cannot be destroyed since the Reservacion " + reservacionCollectionOrphanCheckReservacion + " in its reservacionCollection field has a non-nullable idFactura field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Cliente nitCliente = factura.getNitCliente();
            if (nitCliente != null) {
                nitCliente.getFacturaCollection().remove(factura);
                nitCliente = em.merge(nitCliente);
            }
            em.remove(factura);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Factura> findFacturaEntities() {
        return findFacturaEntities(true, -1, -1);
    }

    public List<Factura> findFacturaEntities(int maxResults, int firstResult) {
        return findFacturaEntities(false, maxResults, firstResult);
    }

    private List<Factura> findFacturaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Factura.class));
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

    public Factura findFactura(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Factura.class, id);
        } finally {
            em.close();
        }
    }

    public int getFacturaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Factura> rt = cq.from(Factura.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
