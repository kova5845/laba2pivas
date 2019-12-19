import javax.swing.*;
import java.util.List;

public class UserController extends Controller {
    private UserManager userManager;
    private UserView userView;
    private Initializer initializer;
    private RecipeController recipeController;

    UserController(Initializer initializer){
        this.initializer = initializer;
        this.userView = new UserView(this);
        this.userManager = new UserManager(this);
    }

    public boolean isUserRecipe(Recipe recipe){
        return userManager.isUserRecipe(recipe);
    }

    public void addController(RecipeController recipeController){
        this.recipeController = recipeController;
    }

    public void viewRecipes(){
        recipeController.viewRecipes();
    }

    public void processRequest(){

    }

    public void viewRegistrationForm(){
        userView.registration(initializer.getStage());
    }

    public void createUser(User user){
        this.userManager.registerUser(user);
    }

    public void viewInputForm(){
        userView.input(initializer.getStage());
    }

    public void authenticationUser(String login, String password){
        this.userManager.authorizeUser(login, password);
    }

    public void cancelAuthenticationUser(){
        userView.cancelAuthenticationUser();
    }

    public void cancelRegistrationUser(){
        userView.cancelRegistrationUser();
    }

    public void deleteRecipe(Recipe recipe){
        userManager.deleteRecipe(recipe);
    }

    public void addRecipe(Recipe recipe){
        userManager.addRecipe(recipe);
    }

    public void refreshTable(List<Recipe> data){
        recipeController.refreshTable(data);
    }

    private User getUser(){
        return new User("qwe", "qwe");
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public UserView getUserView() {
        return userView;
    }

    public void setUserView(UserView userView) {
        this.userView = userView;
    }
}
