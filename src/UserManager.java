import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private User currentUser;
    private UserController userController;
    private List<User> userList;
    private List<String> loginList;

    UserManager(UserController userController){
        this.userController = userController;
        this.userList = new ArrayList<>();
        this.loginList = new ArrayList<>();
    }

    public boolean isUserRecipe(Recipe recipe){
        return currentUser.isUserRecipe(recipe);
    }

    public void registerUser(String login, String password){
        if(loginList.contains(login)){
            userController.cancelRegistrationUser();
        }
        else{
            User user = new User(login, password);
            userList.add(user);
            loginList.add(user.getLogin());
            currentUser = user;
            userController.viewRecipes();
        }
    }

    public void authorizeUser(String login, String password){
        User user = findUserByLogin(login);
        if(checkPassword(user, password)){
            currentUser = user;
            userController.viewRecipes();
        }
        else{
            userController.cancelAuthenticationUser();
        }
    }

    public void deleteRecipe(Recipe recipe) {
        currentUser.deleteRecipe(recipe);
        refreshTable();
    }

    public void addRecipe(Recipe recipe){
        currentUser.addRecipe(recipe);
        refreshTable();
    }

    private void refreshTable(){
        List<Recipe> allRecipes = new ArrayList<>();
        for(User user : userList){
            allRecipes.addAll(user.getRecipeList());
        }
        userController.refreshTable(allRecipes);
    }

    public void deleteUser(){

    }

    private User findUserByLogin(String login){
        for (User user : userList) {
            if (user.getLogin().equals(login)){
                return user;
            }
        }
        return null;
    }

    private boolean checkPassword(User user, String password){
        return user.getPassword().equals(password);
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
