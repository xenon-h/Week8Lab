/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import models.Category;

/**
 *
 * @author 759005
 */
public class CategoryDB {

    public List<Category> getAll() throws Exception {//returns all categoriers
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            return em.createNamedQuery("Category.findAll", Category.class).getResultList();
        } finally {
            em.close();
        }

    }

    public Category get(int categoryId) throws Exception {//returns a categoriers
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            return em.find(Category.class, categoryId);
        } finally {
            em.close();
        }

    }
}
