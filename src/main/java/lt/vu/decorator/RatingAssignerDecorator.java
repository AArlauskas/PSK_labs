package lt.vu.decorator;


import lt.vu.ratingAssigner.IRatingAssigner;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public abstract class RatingAssignerDecorator implements IRatingAssigner {

    @Inject
    @Delegate
    @Any
    IRatingAssigner ratingAssigner;

    public Integer getRating() {
        int rating = ratingAssigner.getRating();
        if(rating < 4)
        {
            System.out.println("Rating is very low... Rating: " + rating);
        }
        return rating;
    }

}
