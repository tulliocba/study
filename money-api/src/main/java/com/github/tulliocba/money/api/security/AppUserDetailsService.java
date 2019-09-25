package com.github.tulliocba.money.api.security;

import com.github.tulliocba.money.api.model.User;
import com.github.tulliocba.money.api.repository.UserRepository;
import com.github.tulliocba.money.api.security.util.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário e/ou senha inválidos"));
        return new SystemUser(user, getRoles(user));
    }

    private Collection<? extends GrantedAuthority> getRoles(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles()
                .forEach(role -> authorities
                        .add(new SimpleGrantedAuthority(role.getDescription().toUpperCase())));
        return authorities;
    }
}
