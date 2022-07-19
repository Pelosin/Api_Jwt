package com.jwt.test.demo;

import com.jwt.test.demo.domain.*;
import com.jwt.test.demo.repo.CategoryRepo;
import com.jwt.test.demo.repo.FoodRepo;
import com.jwt.test.demo.repo.TableRepo;
import com.jwt.test.demo.service.CategoryService;
import com.jwt.test.demo.service.FoodService;
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
    CommandLineRunner run(UserService userService, FoodRepo foodRepo, CategoryRepo categoryRepo,
                          TableRepo tableRepo, CategoryService categoryService, FoodService foodService) {
        return args -> {
//            foodService.changeImage(19L, "https://momentosdocesesalgados.com/wp-content/uploads/2021/03/736DAA39-7DA0-4303-B3A8-F5C93ED36737-scaled.jpeg");
//            foodService.changeImage(20L, "https://www.selecoes.com.br/wp-content/uploads/2022/04/muffin-chocolate-id456066771-500x375.jpg");
//            foodService.changeImage(21L, "https://www.celiacos.org.pt/wp-content/uploads/2020/03/9285523034_a6d243804b_b-1.jpg");
//            foodService.changeImage(22L, "https://www.foodfromportugal.com/content/uploads/2014/09/croissant-chocolate.jpg");
//            foodService.changeImage(23L, "https://amopaocaseiro.com.br/wp-content/uploads/2020/01/pao-caseiro-para-iniciantes_02.jpg");
//            foodService.changeImage(24L, "https://frize.pt//abuploads/2021/01/03_Frize_Limao.png");
//            foodService.changeImage(25L, "https://res.cloudinary.com/fonte-online/image/upload/c_fill,h_600,q_auto,w_600/v1/PDO_PROD/534333_1");
//            foodService.changeImage(26L, "https://sgfm.elcorteingles.es/SGFM/dctm/MEDIA03/202102/18/05218625807617____2__600x600.jpg");
//            foodService.changeImage(27L, "https://media.recheio.pt/catalogo/media/catalog/product/cache/1/image/415x415/9df78eab33525d08d6e5fb8d27136e95/6/1/61003_3.png");
//            foodService.changeImage(28L, "https://www.oswaldocruz.com/site/images/artigos/pesquisa_cafe_coracao.jpg");


//            userService.saveRole(new Role(null, "ROLE_USER"));
//            userService.saveRole(new Role(null, "ROLE_MANAGER"));
//            userService.saveRole(new Role(null, "ROLE_ADMIN"));
//            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
//
//            userService.createAdminUser();
//
//            tableRepo.save(new TbTable(null, false, "Mesa 1"));
//            tableRepo.save(new TbTable(null, false, "Mesa 2"));
//            tableRepo.save(new TbTable(null, false, "Mesa 3"));
//            tableRepo.save(new TbTable(null, false, "Mesa 4"));
//            tableRepo.save(new TbTable(null, false, "Mesa 5"));
//            tableRepo.save(new TbTable(null, false, "Mesa 6"));
//            tableRepo.save(new TbTable(null, false, "Mesa 7"));

//            foodRepo.save(new Food(null, "Hamburger",
//                    "Carne em formato circular, servida normalmente " +
//                            "como sanduíche e com diversos acompanhamentos ",
//                    new BigDecimal(4.50),
//                    "https://moinhoglobo.com.br/wp-content/uploads/2019/05/16-hamburguer.jpeg"));
//
//            foodRepo.save(new Food(null, "Coca-cola",
//                    "Coca-Cola é um drink gaseficado e doce, mas não se preocupe também temos Pepsi",
//                    new BigDecimal(1.30),
//                    "https://ncultura.pt/wp-content/uploads/2021/06/Os-diferentes-usos-da-Coca-Cola.-E-surpreendente-04.jpg"));
//
//            foodRepo.save(new Food(null, "Francesinha simples",
//                    "Esse lanche é perfeito para dividir com alguém, já que ele fica bem grande. " +
//                            "Pra completar, o prato é acompanhado por um molho que da um sabor unico ao prato.",
//                    new BigDecimal(7.50),
//                    "https://camada.pt/delivery/wp-content/uploads/2020/03/camada-francesinhas-francesinha-scaled.jpg"));
//
//            foodRepo.save(new Food(null, "Hamburger Vegetariano",
//                    "Esse prato é exatamente igual a um hamburguer " +
//                            "padrão, porém a ao invés de carne o prato é composto por vegetais ",
//                    new BigDecimal(6.50),
//                    "https://www.sabornamesa.com.br/media/k2/items/cache/acbf17dca076404b2078b0d4b135530d_XL.jpg"));
//
//            foodRepo.save(new Food(null, "Lipton Ice tea",
//                    "Ice tea é uma bebida, mais precisamente uma forma de chá," +
//                            " servido gelado com diferentes sabores.",
//                    new BigDecimal(1.30),
//                    "https://altadonna.pt/wp-content/uploads/2021/04/IMG_9417-copy.jpg"));
//
//            foodRepo.save(new Food(null, "Francesinha especial",
//                    "Esse lanche é perfeito para dividir com alguém, já que ele fica bem grande. " +
//                            "Pra completar, o prato é acompanhado por um molho que da um sabor unico ao prato," +
//                            "Está versão acompanha mais alguns ingredientes e uma dose de batatas.",
//                    new BigDecimal(7.50),
//                    "https://rotadodouro.pt/wp-content/uploads/2019/03/rota-site-capa-pagina-francesinha-a-bordo.jpg"));
//
//            foodRepo.save(new Food(null, "Lanche", "Um lanche misto saboroso, " +
//                    "mas fica ainda melhor com uma bebida pra acompanhar",
//                    new BigDecimal(0.00),
//                    "https://moinhoglobo.com.br/wp-content/uploads/2019/05/16-hamburguer.jpeg"));
//
//            foodRepo.save(new Food(null, "Queque", "Um muffin de chocolate, perfito quando você não sabe o que comer",
//                    new BigDecimal(0.00),
//                    "https://moinhoglobo.com.br/wp-content/uploads/2019/05/16-hamburguer.jpeg"));
//
//            foodRepo.save(new Food(null, "Bolo de arroz", "Para quem não gosta do" +
//                    " Queque de chocolate, mas ainda quer algo doce",
//                    new BigDecimal(0.00),
//                    "https://moinhoglobo.com.br/wp-content/uploads/2019/05/16-hamburguer.jpeg"));
//
//            foodRepo.save(new Food(null, "Croissant de chocolate", "Um croissant recheado com chocolate." +
//                    "Para quem tem bastante fome, esses lanches são grandes",
//                    new BigDecimal(0.00),
//                    "https://moinhoglobo.com.br/wp-content/uploads/2019/05/16-hamburguer.jpeg"));
//
//            foodRepo.save(new Food(null, "Pão simples", "Se você não gosta de mais nada" +
//                    " nessa lista, um pão com um café sempre cai bem",
//                    new BigDecimal(0.00),
//                    "https://moinhoglobo.com.br/wp-content/uploads/2019/05/16-hamburguer.jpeg"));
//
//            foodRepo.save(new Food(null, "Frize", "Agua com gás sabor limão",
//                    new BigDecimal(0.00),
//                    "https://moinhoglobo.com.br/wp-content/uploads/2019/05/16-hamburguer.jpeg"));
//
//            foodRepo.save(new Food(null, "Compal de maracujá", "Compal 33cl de sabor maracujá",
//                    new BigDecimal(0.00),
//                    "https://moinhoglobo.com.br/wp-content/uploads/2019/05/16-hamburguer.jpeg"));
//
//            foodRepo.save(new Food(null, "Compal de laranja", "Compal 33cl de sabor maracujá",
//                    new BigDecimal(0.00),
//                    "https://moinhoglobo.com.br/wp-content/uploads/2019/05/16-hamburguer.jpeg"));
//
//            foodRepo.save(new Food(null, "Pepsi", "",
//                    new BigDecimal(0.00),
//                    "https://moinhoglobo.com.br/wp-content/uploads/2019/05/16-hamburguer.jpeg"));
//
//            foodRepo.save(new Food(null, "Café", "",
//                    new BigDecimal(0.00),
//                    "https://moinhoglobo.com.br/wp-content/uploads/2019/05/16-hamburguer.jpeg"));
////
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
//
//            List<Food> papFoodList = new ArrayList<Food>() {{
//                add(foodRepo.findByName("Lanche"));
//                add(foodRepo.findByName("Queque"));
//                add(foodRepo.findByName("Croissant de chocolate"));
//                add(foodRepo.findByName("Pão simples"));
//                add(foodRepo.findByName("Frize"));
//                add(foodRepo.findByName("Compal de maracujá"));
//                add(foodRepo.findByName("Compal de laranja"));
//                add(foodRepo.findByName("Pepsi"));
//                add(foodRepo.findByName("Coca-cola"));
//            }};

//            List<Food> papFoodList2 = new ArrayList<>();

//            categoryRepo.save(new Category(null, "Francesinhas", foodList));
//            categoryRepo.save(new Category(null, "Hamburguer", foodList2));
//            categoryRepo.save(new Category(null, "Bebidas", foodList3));
//            categoryRepo.save(new Category(null, "Pap", papFoodList2));

//            categoryService.addFoodToCategory(29L, foodRepo.findByName("Francesinha especial"));
//            categoryService.addFoodToCategory(30L, foodRepo.findByName("Hamburger Vegetariano"));
//            categoryService.addFoodToCategory(31L, foodRepo.findByName("Lipton Ice tea"));
//            categoryService.addFoodToCategory(38L, foodRepo.findByName("Lanche"));
//            categoryService.addFoodToCategory(38L, foodRepo.findByName("Queque"));
//            categoryService.addFoodToCategory(38L, foodRepo.findByName("Bolo de arroz"));
//            categoryService.addFoodToCategory(38L, foodRepo.findByName("Croissant de chocolate"));
//            categoryService.addFoodToCategory(38L, foodRepo.findByName("Pão simples"));
//            categoryService.addFoodToCategory(38L, foodRepo.findByName("Frize"));
//            categoryService.addFoodToCategory(38L, foodRepo.findByName("Compal de maracujá"));
//            categoryService.addFoodToCategory(38L, foodRepo.findByName("Compal de laranja"));
//            categoryService.addFoodToCategory(38L, foodRepo.findByName("Pepsi"));
//            categoryService.addFoodToCategory(38L, foodRepo.findByName("Café"));

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
