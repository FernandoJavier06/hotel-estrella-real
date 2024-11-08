/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cunori.controllers;

import com.cunori.controllers.exceptions.IllegalOrphanException;
import com.cunori.controllers.exceptions.NonexistentEntityException;
import com.cunori.controllers.exceptions.PreexistingEntityException;
import com.cunori.models.Cliente;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.cunori.models.Factura;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author ferna
 */
public class ClienteJpaController implements Serializable {

    public ClienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cliente cliente) throws PreexistingEntityException, Exception {
        if (cliente.getFacturaCollection() == null) {
            cliente.setFacturaCollection(new ArrayList<Factura>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Factura> attachedFacturaCollection = new ArrayList<Factura>();
            for (Factura facturaCollectionFacturaToAttach : cliente.getFacturaCollection()) {
                facturaCollectionFacturaToAttach = em.getReference(facturaCollectionFacturaToAttach.getClass(), facturaCollectionFacturaToAttach.getIdFactura());
                attachedFacturaCollection.add(facturaCollectionFacturaToAttach);
            }
            cliente.setFacturaCollection(attachedFacturaCollection);
            em.persist(cliente);
            for (Factura facturaCollectionFactura : cliente.getFacturaCollection()) {
                Cliente oldNitClienteOfFacturaCollectionFactura = facturaCollectionFactura.getNitCliente();
                facturaCollectionFactura.setNitCliente(cliente);
                facturaCollectionFactura = em.merge(facturaCollectionFactura);
                if (oldNitClienteOfFacturaCollectionFactura != null) {
                    oldNitClienteOfFacturaCollectionFactura.getFacturaCollection().remove(facturaCollectionFactura);
                    oldNitClienteOfFacturaCollectionFactura = em.merge(oldNitClienteOfFacturaCollectionFactura);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCliente(cliente.getNitCliente()) != null) {
                throw new PreexistingEntityException("Cliente " + cliente + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cliente cliente) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente persistentCliente = em.find(Cliente.class, cliente.getNitCliente());
            Collection<Factura> facturaCollectionOld = persistentCliente.getFacturaCollection();
            Collection<Factura> facturaCollectionNew = cliente.getFacturaCollection();
            List<String> illegalOrphanMessages = null;
            for (Factura facturaCollectionOldFactura : facturaCollectionOld) {
                if (!facturaCollectionNew.contains(facturaCollectionOldFactura)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Factura " + facturaCollectionOldFactura + " since its nitCliente field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Factura> attachedFacturaCollectionNew = new ArrayList<Factura>();
            for (Factura facturaCollectionNewFacturaToAttach : facturaCollectionNew) {
                facturaCollectionNewFacturaToAttach = em.getReference(facturaCollectionNewFacturaToAttach.getClass(), facturaCollectionNewFacturaToAttach.getIdFactura());
                attachedFacturaCollectionNew.add(facturaCollectionNewFacturaToAttach);
            }
            facturaCollectionNew = attachedFacturaCollectionNew;
            cliente.setFacturaCollection(facturaCollectionNew);
            cliente = em.merge(cliente);
            for (Factura facturaCollectionNewFactura : facturaCollectionNew) {
                if (!facturaCollectionOld.contains(facturaCollectionNewFactura)) {
                    Cliente oldNitClienteOfFacturaCollectionNewFactura = facturaCollectionNewFactura.getNitCliente();
                    facturaCollectionNewFactura.setNitCliente(cliente);
                    facturaCollectionNewFactura = em.merge(facturaCollectionNewFactura);
                    if (oldNitClienteOfFacturaCollectionNewFactura != null && !oldNitClienteOfFacturaCollectionNewFactura.equals(cliente)) {
                        oldNitClienteOfFacturaCollectionNewFactura.getFacturaCollection().remove(facturaCollectionNewFactura);
                        oldNitClienteOfFacturaCollectionNewFactura = em.merge(oldNitClienteOfFacturaCollectionNewFactura);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = cliente.getNitCliente();
                if (findCliente(id) == null) {
                    throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente cliente;
            try {
                cliente = em.getReference(Cliente.class, id);
                cliente.getNitCliente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Factura> facturaCollectionOrphanCheck = cliente.getFacturaCollection();
            for (Factura facturaCollectionOrphanCheckFactura : facturaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cliente (" + cliente + ") cannot be destroyed since the Factura " + facturaCollectionOrphanCheckFactura + " in its facturaCollection field has a non-nullable nitCliente field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(cliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cliente> findClienteEntities() {
        return findClienteEntities(true, -1, -1);
    }

    public List<Cliente> findClienteEntities(int maxResults, int firstResult) {
        return findClienteEntities(false, maxResults, firstResult);
    }

    private List<Cliente> findClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cliente.class));
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

    public Cliente findCliente(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cliente> rt = cq.from(Cliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Cliente> findAllByNit(String nitCliente){
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Cliente> query = em.createNamedQuery("Cliente.findAllByNit",Cliente.class);
            query.setParameter("nitCliente", nitCliente + "%");
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
    public List<Cliente> findAllByNombre(String nombreCliente){
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Cliente> query = em.createNamedQuery("Cliente.findAllByNombre", Cliente.class);
            query.setParameter("nombreCliente", nombreCliente + "%");
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
    public List<Cliente> findAllByApellidos(String apellidosCliente){
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Cliente> query = em.createNamedQuery("Cliente.findAllByApellidos", Cliente.class);
            query.setParameter("apellidosCliente", apellidosCliente + "%");
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
    public short nitExistente(String nitCliente){
        EntityManager em = getEntityManager();
        try {
            Query query = em.createNamedQuery("Cliente.nitExistente");
            query.setParameter("nitCliente", nitCliente);
            Long result = (Long) query.getSingleResult();
            return  result.shortValue();
        } finally {
            em.close();
        }
    }
    
}
