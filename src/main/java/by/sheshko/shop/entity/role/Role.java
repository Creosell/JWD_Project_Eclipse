package by.sheshko.shop.entity.role;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Role implements Serializable {
    private final HashMap<Integer, RoleName> roles = new HashMap<>();

    public Role() {
        roles.put(1, RoleName.ADMIN);
        roles.put(2, RoleName.USER);
        roles.put(3, RoleName.ANONYMOUS);
    }

    public HashMap<Integer, RoleName> getRoles() {
        return roles;
    }

    public String getRoleName(Integer roleID) {
        String roleName = null;
        for (Map.Entry<Integer, RoleName> role : roles.entrySet()) {
            if (roleID.equals(role.getKey())) {
                roleName = String.valueOf(role.getValue());
            }
        }
        return roleName;
    }


}
