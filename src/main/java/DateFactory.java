import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFactory {
    public String getDate() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(dateFormat);
    }
}
