package exitoshoppingcart.utils;

public class ConvertNumberToInt {
    public static int convertAmountToInt(String amount){
        String amount_without_symbols = amount.replace(" ","").
                replace("$","").
                replace(".","");
        return Integer.parseInt(amount_without_symbols);
    }

    public static int convertUnitsToInt(String units){
        String[] product_quantity = units.split("\\.");
        return Integer.parseInt(product_quantity[0]);
    }
}
