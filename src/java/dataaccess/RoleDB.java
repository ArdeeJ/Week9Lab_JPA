package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import models.Role;

/**
 *
 * @author ardee
 */
public class RoleDB {

    public List<Role> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            List<Role> roles = em.createNamedQuery("Role.findAll", Role.class).getResultList();
            return roles;
        } finally {
            em.close();
        }
    }

    public Role get(int roleId) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            Role role = em.find(Role.class, roleId);
            return role;
        } finally {
            em.close();
        }
    }

    public Role getRole(int roleId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
