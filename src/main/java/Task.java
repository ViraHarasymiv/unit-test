import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task {
    public boolean checkEmail(String email) {
        if(email == null){
            throw new NullPointerException();
        }
        String regex = "^[aZ-zA]+[\\.\\w]*[aZ0-zA9$]@(\\w+\\.)+\\w{2,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}