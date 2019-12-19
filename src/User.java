import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {

    private String name;
    private String surname;
    private Date dateOfBirth;
    private String country;
    private String login;
    private String password;
    private List<Recipe> recipeList;

    User(String login, String password){
        this.name = "";
        this.surname = "";
        this.dateOfBirth = new Date();
        this.country = "";
        this.login = login;
        this.password = password;
        this.recipeList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }
}
