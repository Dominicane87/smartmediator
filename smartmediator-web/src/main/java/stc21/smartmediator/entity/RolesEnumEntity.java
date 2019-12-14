package stc21.smartmediator.entity;

import org.springframework.security.core.GrantedAuthority;

public enum RolesEnumEntity implements GrantedAuthority {
    USER, ADMIN, SELLER, BUYER;

    @Override
    public String getAuthority() {
        return name();
    }
}
