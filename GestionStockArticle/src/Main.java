import  com.controller.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Store> Gestion = new ArrayList<>();
        Store testStore = new Store();
        ArticleFamily fruits =  new ArticleFamily("fruits","");
        ArticleSheet banane = new ArticleSheet("banane", 0,23.5,50, fruits,new MaximumStockDeliveryModel(20,80));
        ArticleSheet pomme = new ArticleSheet("pomme", 0,22.5,50, fruits,new MaximumStockDeliveryModel(20,80));
        testStore.addArticleSheet(banane);
        testStore.addArticleSheet(pomme);
        testStore.bookAnArticle(new ArticleReservation(0,40));

        //testStore.editArticleSheet("pomme",banane);
       //testStore.removeAllArticleSheet();
        //boolean isTrans = testStore.transferArticleQuantity("banane","pomme",40);
        System.out.println(testStore.getArticleSheet(0).getStockNbr());
        /*if(isTrans){*/
            //System.out.println(testStore.getArticleSheet(0).getStockNbr());
           // System.out.println(testStore.getArticleSheet(1).getStockNbr());
            System.out.println(testStore.getListOfSuppliesOrders().get(0).getNeededQuantity());
            System.out.println(testStore.getArticleSheet(0).isAvailable());
        System.out.println(testStore.getListOfBookArticle());


       // }*/

        //System.out.println(testStore.getIdOf("pomme"));
    }
}
