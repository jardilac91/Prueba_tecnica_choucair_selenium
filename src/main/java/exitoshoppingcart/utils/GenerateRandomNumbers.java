package exitoshoppingcart.utils;

import java.util.*;

public class GenerateRandomNumbers {
    static Random random = new Random();

    private GenerateRandomNumbers() {
        throw new IllegalStateException("Utility class");
    }
    public static List<Integer> selectFiveRandomProducts(int products){
        List<Integer> random_numbers = new ArrayList<>();
        Set<Integer> unique_product = new HashSet<>();

        while (unique_product.size()<5){
            int random_index = random.nextInt(products-1)+1;
            unique_product.add(random_index);
        }
        random_numbers.addAll(unique_product);
        return random_numbers;
    }

    public static Integer selectRandomQuantityOfProducts(){
        return random.nextInt(10) + 1;


    }
}
