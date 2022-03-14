import at.ac.fhcampuswien.AppController;
import at.ac.fhcampuswien.Article;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class AppControllerTest {
    @BeforeAll
    public static void init() {
        System.out.println("Starting Testing");
    }

    @AfterAll
    public static void finish() {
        System.out.println("Finished Testing");
    }

    @Test
    public void filterListTest(){
        Article a01 = new Article("Margarete Stokowski","Finger weg von den Frauen!");
        Article a02 = new Article("Melisa Erkurt","Reiche Eltern für alle!");
        Article a03 = new Article("Melina Borcak","Keine Strafe hoch genug");
        Article a04 = new Article("Melina Borcak","Das weiße Band der Schande");
        //Article a05 = new Article();
        //Article a06 = new Article();
        //Article a07 = new Article();
        //Article a08 = new Article();
        //Article a09 = new Article();
        //Article a10 = new Article();

    }
    public void getTopHeadlinesAustriaTest(){

    }
    @Test
    public void setArticlesTest(){



    }
    public void getAllNewsBitcoinTest(){

    }
    @Test
    public void getArticleCountTest(){
        try {
            AppController controller = new AppController();

            Article a1 = new Article("title", "author");
            Article a2 = new Article("title", "author");
            assertEquals(2, controller.getArticleCount(), "Test failed");

    }catch (Exception e) {
        e.printStackTrace();
        fail();
    }}}




//Unittests die geschrieben werden müssen
//    //+setArticles(List<Article>articles): void
//    //+getArticleCount(): int
//    //+getTopHeadlinesAustria(): List<Article>
//    //+getAllNewsBitcoin(): List<Article>
//    //+filterList(String query, List<Article> articles) : List <Article>