package lnitcode.ex20230316;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public interface MenuConstants {

    Menu MENU_INDEX = new Menu("Index", "/index", Arrays.asList("Admin", "Staff"));

    Menu MENU_HOME = new Menu("Home", "/home", Arrays.asList("Admin", "Staff"));

    Menu MENU_FILE = new Menu("File", "/file", Arrays.asList("Admin", "Staff"));

    Menu MENU_ROLE = new Menu("Role", "/manage/role", Arrays.asList("Admin"));

    List<Menu> MENU_LIST = Arrays.asList(MENU_INDEX, MENU_HOME, MENU_FILE, MENU_ROLE);

}

class Menu {

    // Please add Properties, Constructors, Getter and Setter according to the requirements.
    // --- write your code here ---
    private String name;

    private String path;

    private List<String> roles;

    public Menu(String name, String path, List<String> roles) {
        this.name = name;
        this.path = path;
        this.roles = roles;
    }

    public List<String> getRoles() {
        return roles;
    }

    // Do not modify `toString` below.
    @Override
    public String toString() {
        return "\t{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}