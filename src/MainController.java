import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class MainController {
    @FXML
    private PController personEditorController;
    @FXML
    private ListView<Person> personList;

    public void initialize() {
        personList.getItems().addAll(
                new Person("James", "Smith", "The Java Programming Language ", "978-0321349804"),
                new Person("Walker", "Johnson", "Java in a Nutshell: A Desktop Quick Reference", " 978-1492037255"),
                new Person("Robert", "Brown", "Effective Java", "978-0134685991"),
                new Person("Davis", "Jones", "Head First Java, 2nd Edition", "978-0596009205"),
                new Person("Richard", "Moore", "Java: A Beginner's Guide", "978-1260440218"),
                new Person("William", "Taylor", "Core Java Volume I--Fundamentals ", "978-0135166307"),
                new Person("Elliot", "Anderson", "Thinking in Java", "978-0131872486"),
                new Person("Charles", "Moore", "Java Concurrency in Practice", "978-0321349606"),
                new Person("Matthew", "Robinson", "Clean Code: A Handbook of Agile Software Craftsmanship", "978-0132350884"),
                new Person("Mark", "Lee", "Code Complete: A Practical Handbook of Software Construction", "978-0735619678"),
                new Person("Steven", "Loopez", "Extreme Programming Explained: Embrace Change", "978-0321278654")
        );
        personList.setCellFactory(new Callback<>() {
            @Override
            public ListCell<Person> call(ListView<Person> listView) {
                return new ListCell<>() {
                    @Override
                    public void updateItem(Person person, boolean empty) {
                        super.updateItem(person, empty);
                        textProperty().unbind();
                        if (person != null) {
                            textProperty().bind(Bindings.format("%s %s, %s, %s",
                                    person.firstNameProperty(),
                                    person.lastNameProperty(),
                                    person.bookNameProperty(),
                                    person.ISBNProperty()
                            ));
                        }
                    }
                };
            }

        });

        personEditorController.personProperty().bind(personList.getSelectionModel().selectedItemProperty());
    }
}