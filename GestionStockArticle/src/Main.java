import  com.controller.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Store> Gestion = new ArrayList<>();
        Store testStore = new Store();
        ArticleSheet banane = new ArticleSheet("banane", 0,23.5,50, new ArticleFamily("fruits",""),new MaximumStockDeliveryModel(100,300));
        ArticleSheet pomme = new ArticleSheet("pomme", 0,22.5,50, new ArticleFamily("fruits",""),new MaximumStockDeliveryModel(100,200));
        testStore.addArticleSheet(banane);
        testStore.addArticleSheet(pomme);
        //testStore.editArticleSheet("pomme",banane);
        testStore.removeAllArticleSheet();
        System.out.println(testStore.isArticleSheetInStore("banane"));
    }
}
