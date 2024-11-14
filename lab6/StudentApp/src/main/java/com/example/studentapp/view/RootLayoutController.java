package com.example.studentapp.view;
import com.example.studentapp.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class RootLayoutController {

    // Ссылка на главное приложение
    private MainApp mainApp;

    /**
     * Инициализирует контроллер. Этот метод вызывается автоматически после загрузки FXML-файла.
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    /**
     * Создает новый список студентов, очищая текущий список.
     */
    @FXML
    private void handleNew() {
        mainApp.getPersonData().clear();
    }

    /**
     * Показывает сообщение "О программе".
     */
    @FXML
    private void handleAbout() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("About StudentGroupApp");
        alert.setContentText("This is a simple JavaFX application for managing student groups.\n" +
                "Developed as part of a lab assignment.");

        alert.showAndWait();
    }

    /**
     * Закрывает приложение.
     */
    @FXML
    private void handleExit() {
        Stage stage = mainApp.getPrimaryStage();
        stage.close();
    }

    /**
     * Обрабатывает сохранение данных (заглушка).
     * В этом методе вы можете реализовать сохранение данных в файл.
     */
    @FXML
    private void handleSave() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Save");
        alert.setHeaderText(null);
        alert.setContentText("Save functionality is not implemented yet.");
        alert.showAndWait();
    }

    /**
     * Обрабатывает редактирование выбранного студента.
     */
    @FXML
    private void handleEditPerson() {
        if (mainApp != null && mainApp.getPersonData().size() > 0) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Edit Person");
            alert.setHeaderText(null);
            alert.setContentText("Edit functionality is not implemented yet.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person to edit.");
            alert.showAndWait();
        }
    }

    /**
     * Обрабатывает удаление выбранного студента.
     */
    @FXML
    private void handleDeletePerson() {
        if (mainApp != null && mainApp.getPersonData().size() > 0) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Delete Confirmation");
            alert.setHeaderText("Are you sure you want to delete this person?");
            alert.setContentText("This action cannot be undone.");

            alert.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person to delete.");
            alert.showAndWait();
        }
    }
}