package webtest.automations;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import webtest.Automation;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class ReporterScrapper extends Automation {
    private static ReporterScrapper ourInstance = new ReporterScrapper();

    public static ReporterScrapper getInstance() {
        return ourInstance;
    }

    private ReporterScrapper() {
        super();
    }

    @Override
    public void automate() {
        JsonArray postjson = new JsonArray();
        WDname.get("https://www.ethiopianreporter.com/");
        List<WebElement> posts = WDname.findElements(By.cssSelector("div.post-block"));
        for(WebElement post: posts){
            try {
                JsonObject newPost = new JsonObject();
                newPost.addProperty("description", post.findElement(By.className("post-title")).getText());
                newPost.addProperty("date", post.findElement(By.className("post-created")).getText());
                newPost.addProperty("category", post.findElement(By.className("post-category")).getText());
                postjson.add(newPost);
            }
            catch (NotFoundException exception){
                continue;
            }

        }


        try (PrintWriter out = new PrintWriter("e:\\news\\data.json")) {
            out.println(postjson.toString());
        }
         catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
