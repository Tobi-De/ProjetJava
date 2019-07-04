import  com.controller.*;

public class Main {
    public static void main(String[] args) {
        Store testSTore = new Store();
        ArticleSheet banane = new ArticleSheet("bananane", 0,23.5,50,new ArticleFamily("fruits",""),new MaximumStockDeliveryModel(100,300));
        System.out.println(banane.toString());
    }
}
