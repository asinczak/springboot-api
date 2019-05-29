package pl.bykowski.springbootapi;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("guiAdd")
public class AnimalGuiAdd extends HorizontalLayout {

    private AnimalRepo animalRepo;

    private TextField textFieldName = new TextField("Podaj imię zwierzaka");

    private TextField textFieldAge = new TextField("Podaj wiek");

    private Button button = new Button("Add animal");

    @Autowired
    public AnimalGuiAdd(AnimalRepo animalRepo) {
        add(textFieldName);
        add(textFieldAge);
        this.animalRepo = animalRepo;

        add(button);

        Animal animal = new Animal();
        button.addClickListener(clik -> {
            animal.setName(textFieldName.getValue());
            animal.setAge(Integer.parseInt(textFieldAge.getValue()));
            animalRepo.save(animal);
        });
    }


}
