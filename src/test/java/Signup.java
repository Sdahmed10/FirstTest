import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Signup {
    public static void main(String[] args) {


        //Vous pouvez utiliser GoogleChrome, firefox ou safari : a vous le choix
        //dans notre lecon d'aujourd'hui on va utiliser googlechrome

        WebDriver driver;
        driver = new ChromeDriver(); // pour google chrome
        //driver = new SafariDriver(); // pour safari
        //driver = new FirefoxDriver(); // pour firefox


        // on va ajouter un delai d'attente a notre script de test
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

        //Maximizer notre page web
        driver.manage().window().maximize();
        //delete all cookies
        driver.manage().deleteAllCookies();
        //Taper URL de la page ou on va faire Signup
        driver.get("https://automationexercise.com/");


        //declaration de signup element
        WebElement Signup;
        //identification de l'element
        Signup = (WebElement) driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']"));
        //un simple click
        Signup.click();

        //Maintenant on va remplir les champs obligatoires
        // le champ du nom
        //declaration de l'element
        WebElement Nom;
        //identification de l'element
        Nom = driver.findElement(By.xpath("//input[@placeholder='Name']"));
        //Remplir le champ par votre nom
        Nom.sendKeys("Ahmedd");
        //un simple click
        Nom.click();
        //on va completer par remplir le champ de l'adresse email
        //declaration de l'element
        WebElement Email;
        //identification de l'element
        Email = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        //Remplir le champ
        Email.sendKeys("Ahmaddd+1111@gmail.com");
        //un simple click
        Email.click();

        //Maintenant on va cliquer sur le bouton signup
        //declaration de l'element
        WebElement Sign;
        //identification de l'element
        Sign = driver.findElement(By.xpath("//button[normalize-space()='Signup']"));
        //un simple click
        Sign.click();

        //recuperer l'URL actuelle de la page web
        String actualURL = driver.getCurrentUrl();
        //Definir l'URL attendue
        String expectedURL = "https://automationexercise.com/signup";

        //comparer les résultats
        if (actualURL.equals(expectedURL)) {
            System.out.println("URLs match. Test passed");
        } else {
            System.out.println("URLs do not match. Test failed");
            System.out.println("Expected URL:" + expectedURL);
            System.out.println("Actual URL:" + actualURL);
        }

        //Declaration des elements
        WebElement Mr;
        //identification des elements
        Mr = driver.findElement(By.xpath("(//input[@id='id_gender1'])[1]"));
        //Un simple click
        Mr.click();

        WebElement password;
        password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("123456Aa@");
        password.click();

        WebElement day;
        day = driver.findElement(By.xpath("//select[@id='days']"));
        //on utilise methode select pour interagir avec les elements de type liste déroulante(dropdown list) sur une page web
        Select select = new Select(day);
        select.selectByValue("9");
        day.click();

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();

        WebElement Month;
        Month = driver.findElement(By.xpath("//select[@id='months']"));
        Select select1 = new Select(Month);
        select1.selectByValue("5");
        Month.click();
        Actions actions1 = new Actions(driver);
        actions1.sendKeys(Keys.ENTER).perform();


        WebElement Year;
        Year = driver.findElement(By.xpath("//select[@id='years']"));
        Select select2 = new Select(Year);
        select2.selectByValue("1991");
        Year.click();
        Actions actions2 = new Actions(driver);
        actions2.sendKeys(Keys.ENTER).perform();

        WebElement newsletter;
        newsletter = driver.findElement(By.xpath("//input[@id='newsletter']"));
        newsletter.click();

        WebElement Firstname;
        Firstname = driver.findElement(By.xpath("//input[@id='first_name']"));
        Firstname.sendKeys("Mohamed");//exemple
        Firstname.click();


        WebElement lastname;
        lastname = driver.findElement(By.xpath("//input[@id='last_name']"));
        int deltaY = lastname.getRect().y;
        new Actions(driver).scrollByAmount(40, deltaY).perform();
        lastname.sendKeys("mohamed");
        lastname.click();


        WebElement adress;
        adress = driver.findElement(By.xpath("(//input[@id='address1'])[1]"));
        adress.sendKeys("rue de la justice Sousse");
        adress.click();


        WebElement Country;
        Country = driver.findElement(By.xpath("//select[@id='country']"));
        Select select3 = new Select(Country);
        select3.selectByValue("Australia");
        Country.click();
        Actions actions3 = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();


        WebElement state;
        state = driver.findElement(By.xpath("//input[@id='state']"));
        state.sendKeys("Sousse");
        state.click();

        WebElement city;
        city = driver.findElement(By.xpath("//input[@id='city']"));
        city.sendKeys("Sousse1");
        city.click();

        WebElement zip;
        zip = driver.findElement(By.xpath("//input[@id='zipcode']"));
        zip.sendKeys("96");
        zip.click();


        WebElement phone;
        phone = driver.findElement(By.xpath("//input[@id='mobile_number']"));
        phone.sendKeys("96000000");
        phone.click();

        WebElement create;
        create = driver.findElement(By.xpath("//button[normalize-space()='Create Account']"));
        create.click();

        //recuperer l'URL actuelle de la page web
        String actualURL1 = driver.getCurrentUrl();
        //Definir l'URL attendue
        String expectedURL1 = "https://automationexercise.com/account_created";

        //comparer les résultats
        if (actualURL1.equals(expectedURL1)) {
            System.out.println("URLs match. Test passed");
        } else {
            System.out.println("URLs do not match. Test failed");
            System.out.println("Expected URL:" + expectedURL1);
            System.out.println("Actual URL:" + actualURL1);
        }

        driver.quit();

        //Ctrl + s enregistrer


    }
}
