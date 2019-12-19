import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class RecipeView extends BasicView {
    private List<Recipe> recipes;
    private RecipeController recipeController;

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
        Table table = new Table();
        Button recipeButton = new Button("Рецепты");
        Button logOutButton = new Button("Выход");
        BorderPane topPane = new BorderPane();
        topPane.setRight(logOutButton);
        topPane.setLeft(recipeButton);
        Button newRecipeButton = new Button("Новый рецепт");
        Button editRecipeButton = new Button("Редактировать рецепт");
        FlowPane bottomPane = new FlowPane(newRecipeButton, editRecipeButton);
        FlowPane flowPane = new FlowPane();
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topPane);
        borderPane.setCenter(table.pagination);
        borderPane.setBottom(bottomPane);
        recipeButton.setOnAction(actionEvent -> {

        });
        recipeButton.setOnAction(actionEvent -> {

        });
        logOutButton.setOnAction(actionEvent -> {

        });
        editRecipeButton.setOnAction(actionEvent -> {

        });
        Scene scene = new Scene(borderPane, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void viewRecipe(){

    }

    public void editRecipe(){

    }

    public void createRecipe(){

    }

    public void deleteRecipe(){

    }
}
