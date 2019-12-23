public class RecipeComponentController extends Controller {
    private Initializer initializer;

    RecipeComponentController(Initializer initializer){
        this.initializer = initializer;
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
