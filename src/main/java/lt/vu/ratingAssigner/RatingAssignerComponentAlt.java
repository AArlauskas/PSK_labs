package lt.vu.ratingAssigner;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Named;
import java.util.Random;

@Alternative
@Named
@RequestScoped
public class RatingAssignerComponentAlt implements IRatingAssigner {

    public Integer getRating() {
        Random random = new Random();
        int numb = random.nextInt(10 - 1);
        return numb;
    }
}
