import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before("@First")
    public void beforeFirst(){
        System.out.println("This will run only before the First Scenario");
    }

    @After("@First")
    public void afterFirst(){
        System.out.println("This will run only after the First Scenario");
    }

}