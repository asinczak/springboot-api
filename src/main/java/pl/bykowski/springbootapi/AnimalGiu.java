package pl.bykowski.springbootapi;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;


@Route ("gui")
public class AnimalGiu extends HorizontalLayout {

    private TextField textField = new TextField("Podaj imię");
    private Button button = new Button("Ok");
    private Label label = new Label();

    public AnimalGiu (){
        add (textField);
        add (button);
        add (label);

        button.addClickListener(click -> label.setText("Hello " + textField.getValue()));
    }
}
