import java.util.ArrayList;
import java.util.List;

public class RecipeController extends Controller {
    private RecipeView recipeView;
    private Initializer initializer;
    private UserController userController;

    RecipeController(Initializer initializer){
        this.initializer = initializer;
        this.recipeView = new RecipeView(this);
    }

    public boolean isUserRecipe(Recipe recipe){
        return userController.isUserRecipe(recipe);
    }

    public void addController(UserController userController){
        this.userController = userController;
    }

    public void viewInputForm(){
       userController.viewInputForm();
    }

    public void processRequest(){

    }

    public void refreshTable(List<Recipe> data){
        recipeView.refreshTable(data);
    }

    public void viewRecipes(){
        recipeView.viewRecipes(initializer.getStage());
    }

    public void viewRecipe(Recipe recipe){
        recipeView.viewRecipe(initializer.getStage(), recipe);
    }

    public void editRecipe(Recipe recipe){
        if(userController.isUserRecipe(recipe)) {
            recipeView.editRecipe(initializer.getStage(), recipe);
        }
    }

    public void createRecipe(){
        recipeView.createRecipe(initializer.getStage());
    }

    public void deleteRecipe(Recipe recipe){
        userController.deleteRecipe(recipe);
    }

    public void addRecipe(Recipe recipe){
        userController.addRecipe(recipe);
    }

    private Recipe getRecipe(){
        return new Recipe("qwe");
    }

    private List<Recipe> getRecipes(){
        return new ArrayList<>();
    }

    public RecipeView getRecipeView() {
        return recipeView;
    }

    public void setRecipeView(RecipeView recipeView) {
        this.recipeView = recipeView;
    }

    public void change(){
    	
    }
}
