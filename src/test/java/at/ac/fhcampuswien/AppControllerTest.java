package at.ac.fhcampuswien;

import at.ac.fhcampuswien.AppController;
import at.ac.fhcampuswien.Article;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;
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

    @Test
    @DisplayName("Tests if filterList filters lowercase querys.")
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
    @DisplayName("Tests if filterList filters uppercase querys.")
    public void filterListTestUppercase() {
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
        List<Article> randomFiltered = AppController.filterList("DAS", random);

        assertEquals(randomFiltered, actual, "Your method didn't filter the expected articles containing the query!");

    }

    @Test
    @DisplayName("Tests if getTopHeadlinesAustria returns ArrayList.")
    public void getTopHeadlinesAustriaTest() {
        AppController controller = new AppController();
        assertNotNull(controller.getTopHeadlinesAustria());
        assertTrue(controller.getTopHeadlinesAustria() instanceof List);

    }

    @Test
    @DisplayName("Tests setArticles. Crashes if setArticles does not work or exist, which is a failed Test.")
    public void setArticlesTest() {
        AppController controller = new AppController();

        ArrayList<Article> random = new ArrayList<>();
        ArrayList<Article> actual = new ArrayList<>();
        Article r1 = new Article("Tina", "Das Auto");
        Article r2 = new Article("Toni", "Der die das");
        Article r3 = new Article("Tini", "Auf den Bermudas");
        Article r4 = new Article("Lola", "Planet der Affen");
        random.add(r1);
        random.add(r2);
        random.add(r3);
        random.add(r4);
        controller.setArticles(random);

        actual.add(r1);
        actual.add(r2);
        actual.add(r3);
        actual.add(r4);

        controller.setArticles(random);

        assertEquals(controller.getArticles(), actual, "Setter doesn't work! :(");

    }

    @Test
    @DisplayName("Tests if getAllNewsBitcoin filters for bitcoin query by comparison.")
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
        controller.setArticles(random);

        List<Article> randomBitcoin = controller.getAllNewsBitcoin();

       actual.add(r1);
       actual.add(r2);

       assertEquals(randomBitcoin, actual, "Your method didn't filter the expected articles containing the word \"bitcoin\" !");

    }

    @Test
    @DisplayName("Tests getArticleCount by setting two articles and comparing to expected value.")
    public void getArticleCountTest() {
        try {
            AppController controller = new AppController();
            List <Article> list = new ArrayList<>();
            Article a1 = new Article("title", "author");
            Article a2 = new Article("title", "author");
            list.add(a1);
            list.add(a2);
            controller.setArticles(list);

            assertEquals(2, controller.getArticleCount(), "Test failed");

        } catch (Exception e) {
            e.printStackTrace();
           fail();
        }
    }

    @Test
    @DisplayName("Tests if getArticleCount returns default value of articles.")
    public void getArticleCountTestDefault() {
        try {
            AppController controller = new AppController();
            assertEquals(4, controller.getArticleCount(), "Test failed"); //4 ist der erwartete wert, weil beim erstellen in der Mocklist 4 Einträge sind

        } catch (Exception e) {
            e.printStackTrace();
           fail();
        }
    }

}
