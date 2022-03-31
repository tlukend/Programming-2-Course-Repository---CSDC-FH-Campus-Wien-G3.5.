package at.ac.fhcampuswien;

import at.ac.fhcampuswien.AppController;
import at.ac.fhcampuswien.Article;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
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

    @Test //funktioniert falsch
    public void filterListTest() {
        List<Article> random = new ArrayList<>();
        List<Article> actual = new ArrayList<>();
        Article r1 = new Article("Tina", "Das Auto");
        Article r2 = new Article("Toni", "Der die das");
        Article r3 = new Article("Tini", "Auf den Bermudas");
        Article r4 = new Article("Lola", "Planet der Affen");
        random.add(r1);
        random.add(r2);
        random.add(r3);
        random.add(r4);

        actual.add(r1);
        actual.add(r2);
        actual.add(r3);
        List<Article> randomFiltered = AppController.filterList("das", random);

        assertEquals(randomFiltered, actual, "Your method didn't filter the expected articles containing the query!");

    }

    @Test
    public void getTopHeadlinesAustriaTest() {
        AppController controller = new AppController();
        assertNotNull(controller.getTopHeadlinesAustria());
        assertTrue(controller.getTopHeadlinesAustria() instanceof List);
    }

    @Test // dieser Test überprüft garnichts, er fügt nur artikel hinzu
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
    public void getAllNewsBitcoinTest() {
        AppController controller = new AppController();
        List<Article> random = new ArrayList<>();
        List<Article> actual = new ArrayList<>();
        Article r1 = new Article("Tina", "Das Bitcoin-Auto");
        Article r2 = new Article("Toni", "Der die das bitcoin");
        Article r3 = new Article("Tini", "Auf den Bermudas");
        Article r4 = new Article("Lola", "Planet der Affen");
        random.add(r1);
        random.add(r2);
        random.add(r3);
        random.add(r4);

        List<Article> randomBitcoin = controller.getAllNewsBitcoin(random);

        actual.add(r1);
        actual.add(r2);

        assertEquals(randomBitcoin, actual, "Your method didn't filter the expected articles containing the word \"bitcoin\" !");

    }

    @Test
    public void getArticleCountTest() {
        try {
            Article.count = 0;
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
//   //  eine List Article wird an das probarty Atrribute übergeben und zwar an Articles
//    //+getArticleCount(): int
//    //+getTopHeadlinesAustria(): List<Article>
//    //+getAllNewsBitcoin(): List<Article>
//    //+filterList(String query, List<Article> articles) : List <Article>
