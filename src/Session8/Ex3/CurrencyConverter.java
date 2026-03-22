package Session8.Ex3;

import java.util.Locale;

public class CurrencyConverter {
    private static double rate;
    private CurrencyConverter() {
    }
    public static void setRate(double rate) {
        if(rate <=0){
            throw new IllegalArgumentException("Rate must be a positive number");
        }
        CurrencyConverter.rate = rate;
    }
    public static double getRate() {
        return rate;
    }
    public static double toUSD(int vnd){
        if(vnd < 0){
            throw new IllegalArgumentException("Value must not be negative");
        }
        if(rate <=0){
            throw new IllegalArgumentException("Rate must be a positive number");
        }
        return vnd/rate;
    }
    public static String formatUSD (double usd){
        if(usd < 0){
            throw new IllegalArgumentException("Value must not be negative");
        }
        String formattedUSD = String.format(Locale.US,"%,.2f USD",usd);
        return formattedUSD;
    }
}
