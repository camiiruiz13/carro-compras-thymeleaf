package com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.repositories.usuario;

import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.models.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    /*
    final String autQuery = "SELECT u.usuario as username,\n" +
                "a.autorizado as authority \n" +
                "FROM carrito.dbo.autorizaciones a \n" +
                "INNER JOIN carrito.dbo.usuario u \n" +
                "ON u.id = a.idusuario \n" +
                "WHERE u.usuario =?";
     */

    @Query("select u from Usuario u " +
            "where u.usuario=:username ")
    Usuario findByUsername(@Param("username") String username);
}