import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PController {
    private final ObjectProperty<Person> person ;
    @FXML
    private TextField firstName ;
    @FXML
    private TextField lastName ;
    @FXML
    private TextField bookName ;
    @FXML
    private TextField ISBN ;

    public PController() {
        this.person = new SimpleObjectProperty<>(this, "person", null);
    }

    public void initialize() {
        this.person.addListener((observable, oldPerson, newPerson) -> {
            if (oldPerson != null) {
                firstName.textProperty().unbindBidirectional(oldPerson.firstNameProperty());
                lastName.textProperty().unbindBidirectional(oldPerson.lastNameProperty());
                bookName.textProperty().unbindBidirectional(oldPerson.bookNameProperty());
                ISBN.textProperty().unbindBidirectional(oldPerson.ISBNProperty());
            }
            if (newPerson != null) {
                firstName.textProperty().bindBidirectional(newPerson.firstNameProperty());
                lastName.textProperty().bindBidirectional(newPerson.lastNameProperty());
                bookName.textProperty().unbindBidirectional(newPerson.bookNameProperty());
                ISBN.textProperty().unbindBidirectional(newPerson.ISBNProperty());
            }
        });
    }

    public final ObjectProperty<Person> personProperty() {
        return person ;
    }

}