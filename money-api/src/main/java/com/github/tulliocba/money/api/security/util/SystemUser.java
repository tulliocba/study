package com.github.tulliocba.money.api.security.util;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class SystemUser extends User {

    private com.github.tulliocba.money.api.model.User user;

    public SystemUser(com.github.tulliocba.money.api.model.User user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getEmail(), user.getPassword(), authorities);
        this.user = user;
    }

    public com.github.tulliocba.money.api.model.User getUser() {
        return user;
    }
}
