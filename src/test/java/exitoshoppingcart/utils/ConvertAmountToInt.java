package exitoshoppingcart.utils;

public class ConvertAmountToInt {
    public static int convertAmountToInt(String amount){
        System.out.println(String.format("Monto a convertir: %s", amount));
        String amount_without_symbols = amount.replace(" ","").
                replace("$","").
                replace(".","");
        return Integer.parseInt(amount_without_symbols);
    }
}
