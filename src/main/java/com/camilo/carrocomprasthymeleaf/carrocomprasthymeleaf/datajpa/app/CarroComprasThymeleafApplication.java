package com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app;

import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.services.uploadservice.IUploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarroComprasThymeleafApplication implements CommandLineRunner {

    @Autowired
    IUploadFileService uploadFileService;

    public static void main(String[] args) {
        SpringApplication.run(CarroComprasThymeleafApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        uploadFileService.deleteAll();
        uploadFileService.init();
    }
}
