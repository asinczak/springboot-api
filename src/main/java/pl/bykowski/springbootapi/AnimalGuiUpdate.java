package pl.bykowski.springbootapi;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("GuiUpdate")
public class AnimalGuiUpdate extends VerticalLayout {

    private AnimalRepo animalRepo;

    private TextField textFieldId = new TextField ("Podaj numer id");
    private TextField textFieldName = new TextField ("Podaj imię zwierzaka");
    private TextField textFieldAge = new TextField ("Podaj wiek zwierzaka");

    private Button button = new Button("Update");

    private Label labelError = new Label();

    private AnimalGuiUpdate (AnimalRepo animalRepo){
        this.animalRepo = animalRepo;
        add(textFieldId);
        add(textFieldName);
        add(textFieldAge);
        add(button);

        Long idFromUser = Long.valueOf(textFieldId.getValue());
        if (checkingIfSuchIdExists(idFromUser)){
            Animal animal = animalRepo.findById(idFromUser).get();


            button.addClickListener(clik -> {animal.setName(textFieldName.getValue());
                animal.setAge(Integer.parseInt(textFieldName.getValue()));
            animalRepo.save(animal);
                });
        } else {
            add(labelError);
            labelError.setText("Such id doesn't exist");
        }
    }

    public boolean checkingIfSuchIdExists (Long id){
     return animalRepo.findAll().spliterator().tryAdvance(animal -> animal.getId().equals(id));
    }
}
