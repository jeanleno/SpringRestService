/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlheidemann.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Jean
 */
@Controller
@SpringBootApplication
public class SpringRestApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringRestApplication.class, args);
    }
}
