package lnitcode.ex20230316;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/17 9:26
 */
public class StaffStrategyImpl {

    private List<Menu> menus;

    public StaffStrategyImpl() {
        menus = MenuConstants.MENU_LIST.stream().filter(
            menu -> menu.getRoles().contains("staff")).collect(Collectors.toList());
    }

    public List<Menu> getMenuListByRole() {

        // --- write your code here ---
        return menus;
    }
}
