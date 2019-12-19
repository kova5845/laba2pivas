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

    public void addController(UserController userController){
        this.userController = userController;
    }

    public void processRequest(){

    }

    public void viewRecipes(){
        recipeView.viewRecipes(initializer.getStage());
    }

    public void viewRecipe(){

    }

    public void editRecipe(){

    }

    public void createRecipe(){

    }

    public void deleteRecipe(){

    }

    private Recipe getRecipe(){
        return new Recipe();
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
}
