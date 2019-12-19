public class RecipeComponentController extends Controller {
    private RecipeView recipeView;

    RecipeComponentController(RecipeView recipeView){
        this.recipeView = recipeView;
    }

    public void processRequest(){

    }

    public void addRecipeComponent(String name, String cookingMethod){

    }

    public void change(){

    }

    public void delete(){

    }

    private RecipeComponent getRecipeComponent(){
        return new RecipeComponent("", "");
    }
}
