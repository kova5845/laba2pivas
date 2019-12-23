public class RecipeComponent {
    private String name;
    private String cookingMethod;
    private Ingredient ingredient;

    RecipeComponent(String name, String cookingMethod){
        this.name = name;
        this.cookingMethod = cookingMethod;
    }

    public String getCookingMethod() {
        return cookingMethod;
    }

    public void setCookingMethod(String cookingMethod) {
        this.cookingMethod = cookingMethod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
}
