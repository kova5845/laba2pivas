import java.util.ArrayList;
import java.util.List;

public class Recipe {

    private String name;
    private String description;
    private List<RecipeComponent> recipeComponentList;

    Recipe(String name){
        this.name = name;
        this.description = "";
        this.recipeComponentList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addRecipeComponent(RecipeComponent recipeComponent){
        recipeComponentList.add(recipeComponent);
    }

    public List<RecipeComponent> getRecipeComponentList() {
        return recipeComponentList;
    }

    public void setRecipeComponentList(List<RecipeComponent> recipeComponentList) {
        this.recipeComponentList = recipeComponentList;
    }
}
