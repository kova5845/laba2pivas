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

        }
    }

    public void authorizeUser(User user){

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
