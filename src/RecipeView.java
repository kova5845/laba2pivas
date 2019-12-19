import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class RecipeView extends BasicView {
    private List<Recipe> recipes;
    private RecipeController recipeController;
    private  Table table = new Table();

    RecipeView(RecipeController recipeController){
        this.recipeController = recipeController;
    }

    public void createPage(String path){

    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public void viewRecipes(Stage primaryStage){
        Button recipeButton = new Button("Рецепты");
        Button logOutButton = new Button("Выход");
        BorderPane topPane = new BorderPane();
        topPane.setRight(logOutButton);
        topPane.setLeft(recipeButton);
        Button createRecipeButton = new Button("Создать новый рецепт");
        Button editRecipeButton = new Button("Редактировать рецепт");
        Button viewRecipeButton = new Button("Посмотреть рецепт");
        FlowPane bottomPane = new FlowPane(createRecipeButton, editRecipeButton, viewRecipeButton);
        FlowPane flowPane = new FlowPane();
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topPane);
        borderPane.setCenter(table.pagination);
        borderPane.setBottom(bottomPane);
        recipeButton.setOnAction(actionEvent -> {

        });
        logOutButton.setOnAction(actionEvent -> {
            recipeController.viewInputForm();
        });
        editRecipeButton.setOnAction(actionEvent -> {

        });
        viewRecipeButton.setOnAction(actionEvent -> {
            recipeController.viewRecipe(table.getSelectedItem());
        });
        createRecipeButton.setOnAction(actionEvent -> {
            recipeController.createRecipe();
        });
        Scene scene = new Scene(borderPane, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void viewRecipe(Stage primaryStage, Recipe recipe){
        Button recipeButton = new Button("Рецепты");
        Button logOutButton = new Button("Выход");
        BorderPane topPane = new BorderPane();
        topPane.setRight(logOutButton);
        topPane.setLeft(recipeButton);
        Button editRecipeButton = new Button("Редактировать рецепт");
        Button deleteRecipeButton = new Button("Посмотреть рецепт");
        FlowPane bottomPane = new FlowPane(editRecipeButton, deleteRecipeButton);
        BorderPane centerPane = new BorderPane();
        String components = "Компоненты\n";
        for(RecipeComponent recipeComponent : recipe.getRecipeComponentList()){
            components += recipeComponent.getName() + ":\n";
            components += recipeComponent.getCookingMethod()+ "\n\n";
        }
        String description = recipe.getName();
        description += "\nОписание:\n";
        description += recipe.getDescription();
        Label componentLabel = new Label();
        Label descriptionLabel = new Label();
        descriptionLabel.setText(description);
        componentLabel.setText(components);
        centerPane.setLeft(descriptionLabel);
        centerPane.setRight(componentLabel);
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topPane);
        borderPane.setCenter(centerPane);
        borderPane.setBottom(bottomPane);
        recipeButton.setOnAction(actionEvent -> {
            recipeController.viewRecipes();
        });
        logOutButton.setOnAction(actionEvent -> {
            recipeController.viewInputForm();
        });
        editRecipeButton.setOnAction(actionEvent -> {
            recipeController.editRecipe(recipe);
        });
        deleteRecipeButton.setOnAction(actionEvent -> {
            recipeController.deleteRecipe(recipe);
        });
        Scene scene = new Scene(borderPane, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void editRecipe(Stage primaryStage, Recipe recipe){

    }

    public void createRecipe(Stage primaryStage){
        Recipe recipe = new Recipe("");
        Button recipeButton = new Button("Рецепты");
        Button logOutButton = new Button("Выход");
        BorderPane topPane = new BorderPane();
        topPane.setRight(logOutButton);
        topPane.setLeft(recipeButton);
        Button addComponentButton = new Button("Добавить компонент");
        Button createButton = new Button("Создать");
        FlowPane bottomPane = new FlowPane(createButton);
        BorderPane centerPane = new BorderPane();
        Label nameRecipeLabel = new Label("Название: ");
        Label descriptionLabel = new Label("Описание: ");
        TextField nameTextField = new TextField();
        TextField descriptionTextField = new TextField();
        HBox nameHBox = new HBox(nameRecipeLabel, nameTextField);
        VBox descriptionVBox = new VBox(nameHBox, descriptionLabel, descriptionTextField);
        Label componentNameLabel = new Label("Компонент");
        TextField nameComponentTextField = new TextField();
        TextField cookingMethodComponentTextField = new TextField();
        VBox componentVBox = new VBox(componentNameLabel, nameComponentTextField,
                cookingMethodComponentTextField, addComponentButton);
        centerPane.setRight(descriptionVBox);
        centerPane.setLeft(componentVBox);
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topPane);
        borderPane.setCenter(centerPane);
        borderPane.setBottom(bottomPane);
        recipeButton.setOnAction(actionEvent -> {
            recipeController.viewRecipes();
        });
        logOutButton.setOnAction(actionEvent -> {
            recipeController.viewInputForm();
        });
        addComponentButton.setOnAction(actionEvent -> {
            recipe.addRecipeComponent(new RecipeComponent(nameComponentTextField.getText(),
                    cookingMethodComponentTextField.getText()));
        });
        createButton.setOnAction(actionEvent -> {
            recipe.setName(nameTextField.getText());
            recipe.setDescription(descriptionTextField.getText());
        });
        Scene scene = new Scene(borderPane, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
