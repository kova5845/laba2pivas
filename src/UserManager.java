import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private UserController userController;
    private List<User> userList;
    private List<String> loginList;

    UserManager(UserController userController){
        this.userController = userController;
        this.userList = new ArrayList<>();
        this.loginList = new ArrayList<>();
    }

    public void registerUser(User user){
        if(loginList.contains(user.getLogin())){
            userController.cancelRegistrationUser();
        }
        else{
            userList.add(user);
            loginList.add(user.getLogin());
            userController.viewRecipes();
        }
    }

    public void authorizeUser(User user){
        if(findUser(user.getLogin(), user.getPassword()) != null){
            userController.viewRecipes();
        }
        else{
            userController.cancelAuthenticationUser();
        }
    }

    public User findUser(String login, String password) {
        for (User user : userList) {
            if (user.getLogin().equals(login) &&
                user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void deleteRecipe(String name, String description) {
        for (User user : userList) {
            for (Recipe recipe : user.getRecipeList()){
                if (recipe.getName().equals(name) &&
                        recipe.getDescription().equals(description)) {
                    user.getRecipeList().remove(recipe);
                }
            }
        }
    }

    public void deleteUser(){

    }

    private User findUserByLogin(){
        return new User("qwe", "qwe");
    }

    private boolean checkPassword(){
        return true;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
