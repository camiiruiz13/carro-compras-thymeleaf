package com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.services.usuarios;

import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.models.entities.Rol;
import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.models.entities.Usuario;
import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.repositories.usuario.IUsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("jpaUserDetailService")
@Slf4j
public class JpaUserDetailService implements UserDetailsService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByUsername(username);

        if(usuario == null) {
            log.error("Error en el Login: no existe el usuario '" + username + "' en el sistema!");
            throw new UsernameNotFoundException("Username: " + username + " no existe en el sistema!");
        }

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for(Rol role: usuario.getRoles()) {
            log.info("Role: ".concat(role.getAutorizado()));
            authorities.add(new SimpleGrantedAuthority(role.getAutorizado()));
        }

        if(authorities.isEmpty()) {
            log.error("Error en el Login: Usuario '" + username + "' no tiene roles asignados!");
            throw new UsernameNotFoundException("Error en el Login: usuario '" + username + "' no tiene roles asignados!");
        }

        return new User(usuario.getUsuario(), usuario.getClave(), usuario.getActivo(),
                true, true, true, authorities);
    }

    


}
