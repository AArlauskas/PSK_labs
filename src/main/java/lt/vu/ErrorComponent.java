package lt.vu;

import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.Serializable;

@ApplicationScoped
@Named
public class ErrorComponent implements Serializable {

    @Getter @Setter
    private boolean showErrorMessage = false;

    public String getErrorStatus() {
        if (showErrorMessage) {
            return "Something wrong happened. Try again later...";
        } else {
            return "";
        }
    }
}
