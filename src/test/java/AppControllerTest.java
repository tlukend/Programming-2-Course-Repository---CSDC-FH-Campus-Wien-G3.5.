import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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

    }
    public void getTopHeadlinesAustriaTest(){

    }
    public void setArticlesTest(){

    }
    public void getAllNewsBitcoinTest(){

    }
    public void getArticleCountTest(){
        // try {} catch {}
    }
}

//Unittests die geschrieben werden müssen
//    //+setArticles(List<Article>articles): void
//    //+getArticleCount(): int
//    //+getTopHeadlinesAustria(): List<Article>
//    //+getAllNewsBitcoin(): List<Article>
//    //+filterList(String query, List<Article> articles) : List <Article>