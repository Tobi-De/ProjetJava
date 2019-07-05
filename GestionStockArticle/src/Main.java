import  com.controller.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Store> Gestion = new ArrayList<>();
        Store testStore = new Store("Test Store");
        Store testStore2 = new Store("Test Store 2");
        Gestion.add(testStore);
        testStore.setId(0);
        Gestion.add(testStore2);
        testStore2.setId(1);

        ArticleFamily fruits =  new ArticleFamily("fruits");
        ArticleFamily vegetaux = new ArticleFamily("vegetaux");

        ArticleSheet banane = new ArticleSheet("banane", 0,23.5,50, fruits,new MaximumStockDeliveryModel(20,80));
        ArticleSheet pomme = new ArticleSheet("pomme", 0,22.5,50, fruits,new MaximumStockDeliveryModel(20,80));
        testStore.addArticleSheet(banane);
        testStore.addArticleSheet(pomme);

        ArticleSheet carrote = new ArticleSheet("carrote", testStore2.getId(),11.5,50, vegetaux, new EconomicDeliveryModel(1000, 23.8,100));
        ArticleSheet epinar = new ArticleSheet("epinar", testStore2.getId(),10.5,50, vegetaux, new VariableDeliveryModel(100,50));
        testStore2.addArticleSheet(carrote);
        testStore2.addArticleSheet(epinar);

        testStore.articleTransfer(testStore2, "banane", 50);
        if(!testStore.transferArticleQuantity("pomme","banane", 20))
            System.out.println("popo");

        testStore.bookAnArticle(new ArticleReservation(banane.getId(), 20));
        testStore.articleTransfer(testStore2, "pomme", 40);

        /*System.out.println(testStore.getListOfArticleSheet());
        System.out.println("---------------------------------------------------------------------");
        System.out.println(testStore2.getListOfArticleSheet());
       // System.out.println(testStore2.getArticleSheet("banane").getMovementHistoric().getHistoric());*/
        System.out.println(testStore);
    }
}
