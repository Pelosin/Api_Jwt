package com.jwt.test.demo;

import com.jwt.test.demo.domain.*;
import com.jwt.test.demo.repo.CategoryRepo;
import com.jwt.test.demo.repo.FoodRepo;
import com.jwt.test.demo.repo.TableRepo;
import com.jwt.test.demo.service.CategoryService;
import com.jwt.test.demo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService, FoodRepo foodRepo, CategoryRepo categoryRepo, TableRepo tableRepo, CategoryService categoryService) {
        return args -> {

//            tableRepo.save(new TbTable(null, false, "Mesa 1"));
//            tableRepo.save(new TbTable(null, false, "Mesa 2"));
//            tableRepo.save(new TbTable(null, false, "Mesa 3"));

//            foodRepo.save(new Food(null, "Hamburger",
//                    "A hamburger is a sandwich consisting of a cooked meat patty on " +
//                    "a bun or roll. You can order a hamburger, fries, and a shake at most fast food restaurants. ",
//                    new BigDecimal(4.50),
//                    "https://moinhoglobo.com.br/wp-content/uploads/2019/05/16-hamburguer.jpeg"));
//
//            foodRepo.save(new Food(null, "Coca-cola",
//                    "Coca-Cola is a carbonated, sweetened soft drink and is the " +
//                    "world's best-selling drink.",
//                    new BigDecimal(1.30),
//                    "https://ncultura.pt/wp-content/uploads/2021/06/Os-diferentes-usos-da-Coca-Cola.-E-surpreendente-04.jpg"));
//
//            foodRepo.save(new Food(null, "Francesinha simples",
//                    "Esse lanche é perfeito para dividir com alguém, já que ele fica bem grande. " +
//                            "Pra completar, o prato é acompanhado por uma dose de batatas petiscar junto.",
//                    new BigDecimal(7.50),
//                    "https://camada.pt/delivery/wp-content/uploads/2020/03/camada-francesinhas-francesinha-scaled.jpg"));

//            foodRepo.save(new Food(null, "Hamburger Vegetariano",
//                    "This hamburger is a sandwich consisting of a cooked chopped vegetables patty on " +
//                    "a bun or roll. You can order a hamburger, fries, and a shake at most fast food restaurants. ",
//                    new BigDecimal(6.50),
//                    "https://www.sabornamesa.com.br/media/k2/items/cache/acbf17dca076404b2078b0d4b135530d_XL.jpg"));
//
//            foodRepo.save(new Food(null, "Lipton Ice tea",
//                    "Ice tea é uma bebida, mais precisamente uma forma de chá, servido gelado ou bem gelado.",
//                    new BigDecimal(1.30),
//                    "https://altadonna.pt/wp-content/uploads/2021/04/IMG_9417-copy.jpg"));
//
//            foodRepo.save(new Food(null, "Francesinha especial",
//                    "Esse lanche é perfeito para dividir com alguém, já que ele fica bem grande. " +
//                            "Pra completar, o prato é acompanhado por uma dose de batatas petiscar junto.",
//                    new BigDecimal(7.50),
//                    "https://rotadodouro.pt/wp-content/uploads/2019/03/rota-site-capa-pagina-francesinha-a-bordo.jpg"));

//            List<Food> foodList = new ArrayList<Food>() {{
//                add(foodRepo.findByName("Francesinha simples"));
//            }};
//
//            List<Food> foodList2 = new ArrayList<Food>() {{
//                add(foodRepo.findByName("Hamburger"));
//            }};
//
//
//            List<Food> foodList3 = new ArrayList<Food>() {{
//                add(foodRepo.findByName("Coca-cola"));
//            }};

//            categoryService.addFoodToCategory(25L, foodRepo.findByName("Francesinha especial"));
//            categoryService.addFoodToCategory(26L, foodRepo.findByName("Hamburger Vegetariano"));
//            categoryService.addFoodToCategory(27L, foodRepo.findByName("Lipton Ice tea"));


//            categoryRepo.delete(categoryRepo.findById(22L).get());
//
            //           categoryRepo.save(new Category(null, "Francesinhas", foodList));
            //          categoryRepo.save(new Category(null, "Hamburguer", foodList2));
            //        categoryRepo.save(new Category(null, "Bebidas", foodList3));

//			foodRepo.save(new Food(null, "Cerveja", "Boa gelada", new BigDecimal(0.50),
//                    "https://www.cocacolabrasil.com.br/content/dam/journey/br/pt/brand-landing/coca-cola-may-2021/br-pt-coca-cola-original-glass-bottle-250ml-234x700px.png",
//                    foodCategoryRepo.findById(33L).get()));
//			foodRepo.save(new Food(null, "Francesinha", "A frança", new BigDecimal(17.66)));
//
//			userService.saveRole(new Role(null, "ROLE_USER"));
//			userService.saveRole(new Role(null, "ROLE_MANAGER"));
//			userService.saveRole(new Role(null, "ROLE_ADMIN"));
//			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
//
//			userService.saveUser(new User(null, "John" , "jhon", "1234", new ArrayList<>(), new ArrayList<>(), null, null));
//			userService.saveUser(new User(null, "Nhoj" , "nhoj", "1234", new ArrayList<>(), new ArrayList<>(), null, null));
//			userService.saveUser(new User(null, "Paulo" , "oluaP", "1234", new ArrayList<>(), new ArrayList<>(), null, null));
//			userService.saveUser(new User(null, "Miguel" , "miguel", "1234", new ArrayList<>(), new ArrayList<>(), null, null));
//			userService.saveUser(new User(null, "Pelosi" , "pelosi", "1234", new ArrayList<>(), new ArrayList<>(), null, null));

//			userService.addRole("pelosi", "ROLE_MANAGER");
//			userService.addRole("jhon", "ROLE_USER");
//			userService.addRole("jhon", "ROLE_MANAGER");
//			userService.addRole("Nhoj", "ROLE_MANAGER");
//			userService.addRole("oluaP", "ROLE_ADMIN");
//			userService.addRole("miguel", "ROLE_USER");
//			userService.addRole("miguel", "ROLE_ADMIN");
//			userService.addRole("miguel", "ROLE_SUPER_ADMIN");
//			userService.addRole("jhon", "ROLE_USER");


        };
    }

}
