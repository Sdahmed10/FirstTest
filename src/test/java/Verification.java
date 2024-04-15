import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Verification {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://automationexercise.com/");

        //la premiere chose on va faire le LOGIN

        WebElement Login;
        Login = driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']"));
        Login.click();


        //on va remplir les champs necessaires
        WebElement email;
        email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        //puisque le champ de l'email est déja saisie on va utiliser la commande controle + q parceque j'utilise MAC pour effacer le contenu du champ email
        email.sendKeys(Keys.chord(Keys.META, "q"));
        email.sendKeys(Keys.BACK_SPACE);
        //aprés avoir supprimer le contenu on va remplir par le nouveau email
        email.sendKeys("Ahmaddd+1111@gmail.com");
        email.click();

        // la meme chose pour le champ de password

        WebElement mdp;
        mdp = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        mdp.sendKeys(Keys.chord(Keys.META, "q"));
        mdp.sendKeys(Keys.BACK_SPACE);
        mdp.sendKeys("123456Aa@");
        mdp.click();

        WebElement login;
        login = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        login.click();

        //recuperer l'URL actuelle de la page web
        String actualURL = driver.getCurrentUrl();
        //definir l'URL attendue
        String expectedURL = "https://automationexercise.com/";

        //comparer les resultats
        if (actualURL.equals(expectedURL)) {
            System.out.println("URLs match. la page home est affiché correctement");
        } else {
            System.out.println("URLs do not match. Test failed");
            System.out.println("Expected URL:" + expectedURL);
            System.out.println("Actual URL:" + actualURL);
        }

        WebElement products;
        products = driver.findElement(By.xpath("//a[@href='/products']"));
        products.click();

        // la meme chose pour gagner du temps

        //recuperer l'URL actuelle de la page web
        String actualURL1 = driver.getCurrentUrl();
        //definir l'URL attendue
        String expectedURL1 = "https://automationexercise.com/products";

        //comparer les resultats
        if (actualURL1.equals(expectedURL1)) {
            System.out.println("URLs match. la page home est affiché correctement");
        } else {
            System.out.println("URLs do not match. Test failed");
            System.out.println("Expected URL:" + expectedURL1);
            System.out.println("Actual URL:" + actualURL1);
        }


        WebElement View = driver.findElement(By.xpath("(//a[contains(text(),'View Product')])[1]"));
        int deltaY = View.getRect().y;
        new Actions(driver).scrollByAmount(50, deltaY).perform();
        View.click();


        //Récupèrer l'élément HTML racine de la page web
        WebElement htmlElement = driver.findElement(By.tagName("html"));
// Notez bien : ce code n’est pas nécessaires sauf si vous voulez vérifier si certains mots existent sur la page.

// Récupérer le tagname de l'élément
        String tagName = htmlElement.getTagName();

// Afficher le tagname de la page
        System.out.println("Le tagname de la page est : " + tagName);


        // Récupérer le contenu de la page
        String pageContent = driver.findElement(By.tagName("html")).getText();

        // Liste de mots à rechercher
        List<String> motsRecherche = new ArrayList<>();
        motsRecherche.add("Category");
        motsRecherche.add("Quantity");
        motsRecherche.add("Availability");
        motsRecherche.add("Condition");
        motsRecherche.add("Brand");

        //verifier l'existance des mots
        for (String mot : motsRecherche) {
            if (pageContent.contains(mot)) {
                System.out.println("le mot \"" + mot + "\"existe sur la page");
            } else {
                System.out.println("le mot\"" + mot + "\"n'existe pas sur la page");
            }

            //fermer le navigateur
            driver.quit();

        }

    }
}
