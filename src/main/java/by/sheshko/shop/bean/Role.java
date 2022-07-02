package by.sheshko.shop.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Role implements Serializable {
    private static final long serialVersionUID = -4919966976903480589L;
    private final Map<Integer, RoleName> roles = new HashMap<>();

    public Role() {
        roles.put(1, RoleName.ADMIN);
        roles.put(2, RoleName.USER);
        roles.put(3, RoleName.ANONYMOUS);
    }

    public Map<Integer, RoleName> getRoles() {
        return roles;
    }

    public String getRoleName(final Integer roleID) {
        String roleName = null;
        for (Map.Entry<Integer, RoleName> role : roles.entrySet()) {
            if (roleID.equals(role.getKey())) {
                roleName = String.valueOf(role.getValue());
            }
        }
        return roleName;
    }

    public Integer setRoleIDByName(final RoleName roleName) {
        Integer roleID = null;
        for (Map.Entry<Integer, RoleName> role : roles.entrySet()) {
            if (roleName.equals(role.getValue())) {
                roleID = role.getKey();
            }
        }
        return roleID;
    }


}
