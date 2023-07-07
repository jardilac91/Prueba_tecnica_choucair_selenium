package exitoshoppingcart.utils;

import java.util.*;

public class GenerateRandomNumbers {
    static Random random = new Random();
    public static List<Integer> select_five_random_products(int products){
        List<Integer> random_numbers = new ArrayList<>();
        Set<Integer> unique_product = new HashSet<>();

        while (unique_product.size()<5){
            int random_index = random.nextInt(products-1)+1;
            unique_product.add(random_index);
        }
        random_numbers.addAll(unique_product);
        return random_numbers;
    }

    public static Integer select_random_quantity_of_products(){
        int quantity_of_products = random.nextInt(10) + 1;
        return quantity_of_products;

    }
}
