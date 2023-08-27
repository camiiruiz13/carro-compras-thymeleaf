package com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app;


import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.services.uploads.IUploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class CarroComprasThymeleafApplication implements CommandLineRunner {

    @Autowired
    PasswordEncoder passwordEncoder;



    @Autowired
    IUploadFileService uploadFileService;
    public static void main(String[] args) {
        SpringApplication.run(CarroComprasThymeleafApplication.class, args);
    }



    @Override
    public void run(String... args) throws Exception {
        uploadFileService.deleteAll();
        uploadFileService.init();

        String password = "12345";

        for(int i=0; i<2; i++) {
            String bcryptPassword = passwordEncoder.encode(password);
            System.out.println(bcryptPassword);
        }


    }
}
