import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test email's regex")
public class TaskTest {
    Task task = new Task();

    @ParameterizedTest
    @ValueSource(strings = {"mlablabla@xxfxf.hiy.com", "fsds9@example.com", "fsd9s.d@example.com"})
    @DisplayName("Check valid email")
    public void checkValidEmail(String validEmail){
    assertTrue(task.checkEmail(validEmail));
    }

    @Test
    @DisplayName("Check null email")
    public void checkNullEmail(){
        assertThrows(NullPointerException.class, () -> task.checkEmail(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2dfdfdf@jkjk.com", "%dfdfdf@jkjk.com", "dfdfd.@jkjk.com"})
    @DisplayName("Check invalid username")
    public void checkInvalidUserName(String invalidEmail){
        assertFalse(task.checkEmail(invalidEmail), "The username in an email must start with a letter" +
                "and end with a letter or number");
    }

    @Test
    @DisplayName("Check invalid top-level domain")
    public void checkInvalidEmailWithOneDomainLevel(){
        assertFalse(task.checkEmail("dfdf@jkjk.c"),"The top-level domain must be at least two letters long");
    }
}
