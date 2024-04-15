import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class searchproduct {
    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://automationexercise.com/");


        // la premiere chose on va faire le login
        WebElement login;
        login = driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']"));
        login.click();

        //on va remplir les champs necessaires ;)




        WebElement email;
        email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        // comme j'ai dit lorsque le champ est deja saisi on va utiliser la commande pour supprimé le contenu et saisir un nouveau email
        email.sendKeys(Keys.chord(Keys.META, "q"));
        email.sendKeys(Keys.BACK_SPACE);
        //aprés avoir supprimé le contenu on va saisir le nouveau email
        email.sendKeys("Ahmaddd+1111@gmail.com");
        email.click();

        // la meme chose pour le password


        // on va remplir les champs necessaires
        WebElement mdp;
        mdp = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        // comme j'ai dit lorsque le champ est deja saisi on va utiliser la commande pour supprimé le contenu et saisir un nouveau email
        mdp.sendKeys(Keys.chord(Keys.META, "q"));
        mdp.sendKeys(Keys.BACK_SPACE);
        //aprés avoir supprimé le contenu on va saisir le nouveau email
        mdp.sendKeys("123456Aa@");
        mdp.click();


        // on va cliquer sur le boutton login
        WebElement login1;
        login1 = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        login1.click();

        //recuperer l'url actuelle de la page web
        String actualURL = driver.getCurrentUrl();
        //URL attendue
        String expectedURL = "https://automationexercise.com/";

        //comparer les resultats
        if (actualURL.equals(expectedURL)) {
            System.out.println("URLs match. la page home est affiché correctement");

        } else {
            System.out.println("URLs do not match. test failed");
            System.out.println("Expected URL:" + expectedURL);
            System.out.println("Actual URL:" + actualURL);
        }

        //cliquer sur le bouton products
        WebElement products;
        products = driver.findElement(By.xpath("//a[@href='/products']"));
        products.click();

        //verifier si on a acceder a la page products correctement
        // pour gagner du temps on va copier le meme code de verification précedentes
        //recuperer l'url actuelle de la page web
        String actualURL1 = driver.getCurrentUrl();
        //URL attendue
        String expectedURL1 = "https://automationexercise.com/products";

        //comparer les resultats
        if (actualURL1.equals(expectedURL1)) {
            System.out.println("URLs match. la page products est affiché correctement");

        } else {
            System.out.println("URLs do not match. test failed");
            System.out.println("Expected URL:" + expectedURL1);
            System.out.println("Actual URL:" + actualURL1);
        }

        //on va cliquer sur le champ recherche
        WebElement search;
        search = driver.findElement(By.xpath("//input[@id='search_product']"));
        search.sendKeys("Men Tshirt");
        search.click();

        //on va cliquer sur le bouton search logo
        WebElement search1;
        search1 = driver.findElement(By.xpath("//button[@id='submit_search']"));
        search1.click();

        //recuperer l'element HTML de notre page web
        WebElement htmlElement = driver.findElement(By.tagName("html"));

        //recuperer le tagname de l'element
        String tagName = htmlElement.getTagName();
        //afficher le tagName
        System.out.println("Le tagName de la page est:" + tagName);
        //recuperer le contenu de la page
        String pageText = driver.findElement(By.tagName("html")).getText();

        //verifier si le mot SEARCHED PRODUCTS est visible sur la page web
        if (pageText.contains("SEARCHED PRODUCTS")) {
            System.out.println("le mot 'SEARCHED PRODUCTS' a été trouvé sur la page");
        } else {
            System.out.println("le mot 'SEARCHED PRODUCTS' n'est pas présent sur la page");
        }

        //recuperer l'URL de la page web
        String actualURL2 = driver.getCurrentUrl();
        //definir l'URL attendu
        String expectedURL2 = "https://automationexercise.com/products?search=Men%20Tshirt";

        //comparer les resultats
        if (actualURL2.equals(expectedURL2)) {
            System.out.println("URLs match. produit recherché est affiché correctement");
        } else {
            System.out.println("URLs do not match.test failed");
            System.out.println("Expected URL:" + expectedURL2);
            System.out.println("Actual URL:" + actualURL2);
        }

        //fermer le navigateur
        driver.quit();


        // ctrl+ s enregistrer


    }
}
