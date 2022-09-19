import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before("@NegativeTestCase")
    public void beforeFirst(){
        System.out.println("Negative test case:");
    }


}