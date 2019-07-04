import  com.controller.*;

public class Main {
    public static void main(String[] args) {
        Store testStore = new Store();
        ArticleSheet banane = new ArticleSheet("banane", 0,23.5,50, new ArticleFamily("fruits",""),new MaximumStockDeliveryModel(100,300));
        ArticleSheet pomme = new ArticleSheet("pomme", 0,22.5,50, new ArticleFamily("fruits",""),new MaximumStockDeliveryModel(100,200));
        testStore.addArticleSheet(banane);
        testStore.addArticleSheet(pomme);
        //testStore.editArticleSheet("pomme",banane);
        System.out.println(testStore.getArticleSheet("banane"));
    }
}
