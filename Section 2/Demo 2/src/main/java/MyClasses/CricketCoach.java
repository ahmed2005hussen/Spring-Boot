package MyClasses;

import com.example.demo.Coach;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Hello i'm a Cricket Coach";
    }
}
