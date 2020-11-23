/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Item;

/**
 *
 * @author 759005
 */
public class ItemDB {

    public List<Item> getAll() throws Exception {//returns all categoriers
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            return em.createNamedQuery("Item.findAll", Item.class).getResultList();
        } finally {
            em.close();
        }

    }

    public Item get(String item_id) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            return em.find(Item.class, item_id);

        } finally {
            em.close();
        }

    }

    public void insert(Item item) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            em.persist(item);
            trans.commit();

        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }

    }

    public void update(Item item) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(item);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }

    }

    public void delete(Item item) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            em.remove(em.merge(item));
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }

    }
}
