package com.example.studentapp.view;
import com.example.studentapp.MainApp;
import com.example.studentapp.model.Person;
import com.example.studentapp.util.DateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class PersonOverviewController {

    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;
    @FXML
    private TableColumn<Person, Integer> groupCodeColumn;
    @FXML
    private TableColumn<Person, String> emailColumn;
    @FXML
    private TableColumn<Person, Integer> ageColumn;
    @FXML
    private TableColumn<Person, Double> gpaColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label groupCodeLabel;
    @FXML
    private Label birthdayLabel;

    private MainApp mainApp;

    public PersonOverviewController() {}

    /**
     * Инициализация контроллера.
     * Метод вызывается автоматически после загрузки FXML-файла.
     */
    @FXML
    private void initialize() {
        // Настройка столбцов таблицы
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        groupCodeColumn.setCellValueFactory(cellData -> cellData.getValue().groupCodeProperty().asObject());
        emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        ageColumn.setCellValueFactory(cellData -> cellData.getValue().ageProperty().asObject());
        gpaColumn.setCellValueFactory(cellData -> cellData.getValue().gpaProperty().asObject());
        // Очистка информации о деталях студента
        showPersonDetails(null);

        // Добавляем слушателя для изменений выбора в таблице
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));
    }

    /**
     * Устанавливает ссылку на главное приложение.
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        personTable.setItems(mainApp.getPersonData());
    }

    /**
     * Заполняет метки информацией из объекта Person.
     */
    private void showPersonDetails(Person person) {
        if (person != null) {
            // Заполняем метки информацией из объекта person
            firstNameLabel.setText(person.getFirstName());
            lastNameLabel.setText(person.getLastName());
            groupCodeLabel.setText(String.valueOf(person.getGroupCode()));

            // Форматируем дату рождения в строку
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            birthdayLabel.setText(DateUtil.format(person.getBirthday()));
        } else {
            // Если Person равен null, очищаем все метки
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            groupCodeLabel.setText("");
            birthdayLabel.setText("");
        }
    }

    @FXML
    private void handleDeletePerson() {
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();

        if (selectedIndex >= 0) {
            // Создаем диалоговое окно подтверждения
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Delete Confirmation");
            alert.setHeaderText("Are you sure you want to delete this person?");
            alert.setContentText("This action cannot be undone.");

            // Ожидаем подтверждения от пользователя
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                // Если пользователь нажал OK, удаляем элемент из списка
                personTable.getItems().remove(selectedIndex);
            }
        } else {
            // Показываем предупреждение, если не выбран студент
            Alert warningAlert = new Alert(Alert.AlertType.WARNING);
            warningAlert.initOwner(mainApp.getPrimaryStage());
            warningAlert.setTitle("No Selection");
            warningAlert.setHeaderText("No Person Selected");
            warningAlert.setContentText("Please select a person in the table.");
            warningAlert.showAndWait();
        }
    }

    @FXML
    private void handleNewPerson() {
        Person tempPerson=new Person();
        boolean okClicked=mainApp.showPersonEditDialog(tempPerson);
        if(okClicked) {
            mainApp.getPersonData().add(tempPerson);
        }
    }
    /**
     * Викликається, коли користувач клацне по кнопка Edit...
     * Відкриває діалогове вікно для зміни вибраного студента.
     */
    @FXML
    private void handleEditPerson() {
        Person
                selectedPerson=personTable.getSelectionModel().getSelectedItem();if(selectedPerson!=null) {
            boolean okClicked=mainApp.showPersonEditDialog(selectedPerson);
            if(okClicked) {
                showPersonDetails(selectedPerson);
            }
        }else{
// Нічого не вибрано.
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");
            alert.showAndWait();
        }
    }


}