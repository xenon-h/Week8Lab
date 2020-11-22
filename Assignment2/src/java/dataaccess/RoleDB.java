/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import models.Role;

/**
 *
 * @author 759005
 */
public class RoleDB {

    public List<Role> getAll() throws Exception {

        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            return em.createNamedQuery("Role.findAll", Role.class).getResultList();

        } finally {
            em.close();
        }

    }

    public Role get(int index) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            Role role = em.find(Role.class, index);

            return role;
        } finally {
            em.close();
        }

    }
}
