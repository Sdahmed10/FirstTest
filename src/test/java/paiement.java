import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class paiement {
    public static void main(String[] args) {

        //on va voir comment utiliser ad blocker
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("/Users/takiacademy/IdeaProjects/FirstTest/adblocker/AdBlock — best ad blocker 5.21.0.0.crx"));


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://automationexercise.com/");

        //recuperer l'identifiant de la fenetre principale
        String mainWindowHandle = driver.getWindowHandle();
        //recuperer les identifiants de toutes les fenetres ouvertes
        Set<String> windowHandles = driver.getWindowHandles();
        //parcourez toutes les fenetres ouvertes
        for (String windowHandle : windowHandles) {
            //ici il y a une condition si ce n'est pas la fenetre principal alors c'est la fentre de ad blocker
            if (!windowHandle.equals(mainWindowHandle)) {
                //allons vers la fentre de ad blocker
                driver.switchTo().window(windowHandle);
                //fermer cette fenetre
                driver.close();
            }
        }
        //revenir maintenant a la fentre principale
        //on va voir comment aprés l'execution
        driver.switchTo().window(mainWindowHandle);

        // la premiere chose on va faire le login
        WebElement login;
        login = driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']"));
        login.click();

        // on va empire les champs necessaries
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
        //on va ajouter les produits au panier
        WebElement add;
        add = driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[1]"));
        add.click();

        //cliquer sur continuer
        WebElement continuer;
        continuer = driver.findElement(By.xpath("//button[normalize-space()='Continue Shopping']"));
        continuer.click();

        //ajouter le 2eme produit
        WebElement add1;
        add1 = driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[3]"));
        add1.click();

        //la meme chose on va cliquer sur continuer
        WebElement continuer1;
        continuer1 = driver.findElement(By.xpath("//button[normalize-space()='Continue Shopping']"));
        continuer1.click();

        //attention toujours il faut chnager les noms pour que tout va bien
        //maintenant on va affiché un message indiquant que les produits ont ete ajoutes au panier correctement

        System.out.println("les produits ont ete ajoutés correctement au panier");
        // cliquer sur le bouton panier (cart)
        WebElement cart;
        cart = driver.findElement(By.xpath("//body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]"));
        cart.click();

        //verifier que la page du panier est affiché
        //recuperer l'url actuelle de la page web

        String actuelURL1 = driver.getCurrentUrl();
        String expectedURL1 = "https://automationexercise.com/view_cart";

        //comparer les resultats
        if (actuelURL1.equals(expectedURL1)) {
            System.out.println("URLs match. la pagne panier est affiché correctement");
        } else {
            System.out.println("URLs do not match. test failed");
            System.out.println("Expected URL:" + expectedURL1);
            System.out.println("Actual URL:" + actuelURL1);
        }

        //cliquer sur proceed to checkout

        WebElement caisse;
        caisse = driver.findElement(By.xpath("//a[normalize-space()='Proceed To Checkout']"));
        caisse.click();

        //cliquez sur le bouton connexion et creation du compte ...... on a deja vu tous ces cas de tests dans les anciens videos en plus de ca on est deja connecter des le debut
        //mainetenant on va saisir une petite description et cliquer sur passer la commande
        // a la prochaine video

        WebElement des;
        des = driver.findElement(By.xpath("//textarea[@name='message']"));
        des.sendKeys("un message comme vous voulez");
        des.click();

        //cliquer sur place order(passer la commande)
        WebElement place;
        place = driver.findElement(By.xpath("//a[normalize-space()='Place Order']"));
        place.click();

        //on va remplir tous les champs necessaires
        WebElement name;
        name = driver.findElement(By.xpath("//input[@name='name_on_card']"));
        name.sendKeys("ahmed");
        name.click();

        WebElement num;
        num = driver.findElement(By.xpath("//input[@name='card_number']"));
        num.sendKeys("1111222233334444");
        num.click();

        WebElement cvc;
        cvc = driver.findElement(By.xpath("//input[@placeholder='ex. 311']"));
        cvc.sendKeys("300");
        cvc.click();

        WebElement ex;
        ex = driver.findElement(By.xpath("//input[@placeholder='MM']"));
        ex.sendKeys("06");
        ex.click();

        WebElement year;
        year = driver.findElement(By.xpath("//input[@placeholder='YYYY']"));
        year.sendKeys("2030");
        year.click();


        //cliquer sur pay

        WebElement pay;
        pay = driver.findElement(By.xpath("//button[@id='submit']"));
        pay.click();


        // la prochaine video on va verifier le message de reussite et verifier si le mot congratulations est visible sur la page et on va fermer le navigateur aprés l'execution
        //Merci

        //on va verifier le message de reussite
        //recuperer l'element HTML de la page web

        WebElement htmlElement = driver.findElement(By.tagName("html"));
        //recuperer le tagname de l'element
        String tagName = htmlElement.getTagName();
        //afficher le tagName
        System.out.println("le tagName de la page est:" + tagName);
        //recuperer le contenu de la page
        String pageText = driver.findElement(By.tagName("html")).getText();

        //verifier si le mot Congratulations!
        if (pageText.contains("Congratulations!")) {
            System.out.println("le mot Congratulations! a ete trouvé sur la page web");
        } else {
            System.out.println("le mot Congratulations! n'est pas présent sur la page web");


            //ctrl+s enregistrer
        }
        //fermer le navigateur
        driver.quit();


    }
}
