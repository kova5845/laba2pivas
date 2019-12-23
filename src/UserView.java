import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserView extends BasicView {

    private UserController userController;
    private User user;

    UserView(UserController userController){
        this.userController = userController;
    }

    public void createPage(String path){

    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void registration(Stage primaryStage){
        Label nameLabel = new Label("Регистрация");
        TilePane tilePane = new TilePane(Orientation.VERTICAL);
        Label emailLabel = new Label("Email");
        TextField emailTextField = new TextField();
        Label passwordLabel = new Label("Пароль");
        PasswordField passwordPasswordField = new PasswordField();
        Label passwordRepeatLabel = new Label("Повторите пароль");
        PasswordField passwordRepeatPasswordField = new PasswordField();
        HBox h1 = new HBox();
        HBox h2 = new HBox();
        HBox h3 = new HBox();
        HBox h4 = new HBox();
        Button inputButton = new Button("Вход");
        Button registrationButton = new Button("Регистрация");
        inputButton.setOnAction(actionEvent -> {
            userController.viewInputForm();
        });
        registrationButton.setOnAction(actionEvent -> {
            if(passwordPasswordField.getText().equals(passwordRepeatPasswordField.getText())){
               userController.createUser(emailTextField.getText(), passwordPasswordField.getText());
            }
            else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Пароли не совпадают");
                alert.showAndWait();
            }
        });
        h1.getChildren().addAll(emailLabel, emailTextField);
        h2.getChildren().addAll(passwordLabel, passwordPasswordField);
        h3.getChildren().addAll(passwordRepeatLabel, passwordRepeatPasswordField);
        h4.getChildren().addAll(inputButton, registrationButton);
        tilePane.getChildren().addAll(h1, h2, h3, h4);
        tilePane.setStyle("-fx-border-color: black;");
        tilePane.setMaxSize(300, 300);
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(nameLabel, tilePane);
        Scene scene = new Scene(root, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void cancelRegistrationUser(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText("Пользователь с таким логином уже существует");
        alert.showAndWait();
    }

    public void input(Stage primaryStage){
        Label nameLabel = new Label("Вход");
        TilePane tilePane = new TilePane(Orientation.VERTICAL);
        Label emailLabel = new Label("Email");
        TextField emailTextField = new TextField();
        Label passwordLabel = new Label("Пароль");
        PasswordField passwordPasswordField = new PasswordField();
        HBox h1 = new HBox();
        HBox h2 = new HBox();
        HBox h3 = new HBox();
        HBox h4 = new HBox();
        Button inputButton = new Button("Вход");
        Button registrationButton = new Button("Регистрация");
        inputButton.setOnAction(actionEvent -> {
            userController.authenticationUser(emailTextField.getText(), passwordPasswordField.getText());
        });
        registrationButton.setOnAction(actionEvent -> {
            userController.viewRegistrationForm();
        });
        h1.getChildren().addAll(emailLabel, emailTextField);
        h2.getChildren().addAll(passwordLabel, passwordPasswordField);
        h4.getChildren().addAll(inputButton, registrationButton);
        tilePane.getChildren().addAll(h1, h2, h3, h4);
        tilePane.setStyle("-fx-border-color: black;");
        tilePane.setMaxSize(300, 300);
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(nameLabel, tilePane);
        Scene scene = new Scene(root, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void cancelAuthenticationUser(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText("Неверный логин или пароль");
        alert.showAndWait();
    }
}
