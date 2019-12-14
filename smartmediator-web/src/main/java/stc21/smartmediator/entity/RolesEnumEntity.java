package stc21.smartmediator.entity;

import org.springframework.security.core.GrantedAuthority;

public enum RolesEnumEntity implements GrantedAuthority {
    USER, ADMIN, SELLER;

    @Override
    public String getAuthority() {
        return name();
    }
}
