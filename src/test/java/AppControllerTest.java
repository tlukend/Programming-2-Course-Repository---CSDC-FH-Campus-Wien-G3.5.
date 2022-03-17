import at.ac.fhcampuswien.AppController;
import at.ac.fhcampuswien.Article;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
    public void filterListTest() {

        //Article a05 = new Article();
        //Article a06 = new Article();
        //Article a07 = new Article();
        //Article a08 = new Article();
        //Article a09 = new Article();
        //Article a10 = new Article();

    }

    @Test
    public void getTopHeadlinesAustriaTest() {
        AppController controller = new AppController();
        assertNotNull(controller.getTopHeadlinesAustria());
        assertTrue(controller.getTopHeadlinesAustria() instanceof List);
    }

    @Test
    public void setArticlesTest() {

        AppController controller = new AppController();
        List<Article> Articles = new ArrayList<>();
        Article Article1 = new Article("Jack", "Article");
        Article Article2 = new Article("Khaled Hosseini", "Article");
        Articles.add(Article1);
        Articles.add(Article2);
        try {
            controller.setArticles(Articles);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
    @Test
    public void getAllNewsBitcoinTest(){
        try {
            AppController c1 = new AppController();
            c1.Articles.add(0, "Bitcoin");
            assertEquals(true, c1.getAllNewsBitcoin(), "Should be true");
        }catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void getArticleCountTest() {
        try {
            //Article.count = 0;
            AppController controller = new AppController();

            Article a1 = new Article("title", "author");
            Article a2 = new Article("title", "author");
            assertEquals(2, controller.getArticleCount(), "Test failed");

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}


//Unittests die geschrieben werden müssen
//    //+setArticles(List<Article>articles): void
//    //+getArticleCount(): int
//    //+getTopHeadlinesAustria(): List<Article>
//    //+getAllNewsBitcoin(): List<Article>
//    //+filterList(String query, List<Article> articles) : List <Article>