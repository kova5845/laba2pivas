
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

    public void authenticationUser(){

    }

    public void cancelAuthenticationUser(){
        userView.cancelAuthenticationUser();
    }

    public void cancelRegistrationUser(){
        userView.cancelRegistrationUser();
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
