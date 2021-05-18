package lt.vu.ratingAssigner;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.Random;

@Named
@RequestScoped
public class RatingAssignerComponent implements IRatingAssigner {

    public Integer getRating() {
        Random random = new Random();
        int numb = random.nextInt(5 - 1);
        return numb;
    }
}
