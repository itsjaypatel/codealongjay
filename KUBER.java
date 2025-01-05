package designpatterns.Main;

public class KUBER {

    public KUBER(String deviceType){
        this.pricingStrategy = deviceType.equals("Android") ? new AndroidPricingStrategy() : new IphonePricingStrategy();
    }

    private final PricingStrategy pricingStrategy;

    public int calculatePrice(int source,int destination){
        return (destination - source)*pricingStrategy.multiplier();
    }

    public static void main(String[] args) {

        int source = 20;
        int destination = 30;

        System.out.println("Android Price :: " + new KUBER("Android").calculatePrice(source,destination)); ;
        System.out.println("Apple Price :: " + new KUBER("Iphone").calculatePrice(source,destination)); ;
    }
}

interface PricingStrategy{
    int multiplier();
}
class AndroidPricingStrategy implements PricingStrategy{

    public int multiplier() {
        return 10;
    }
}
class IphonePricingStrategy implements PricingStrategy{

    public int multiplier() {
        return 20;
    }
}


