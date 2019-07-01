package com.vnext.interjava.userproduct.idea.controller;

import com.vnext.interjava.userproduct.idea.entity.User;
import com.vnext.interjava.userproduct.idea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.vnext.interjava.userproduct.idea.utils.UrlConstant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String init() {
        return "login";
    }

    @RequestMapping(value = UrlConstant.URL_LOGIN, method = RequestMethod.POST)
    public String login(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password,

                        ModelMap modelMap, Model model) {
        List<User> users = jdbcTemplate.query("select * from user" +
                " where username = ? AND password = ?", new Object[] {username, password}, new UserRowMaapper());
        for (User user : users) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {

                if (user.getRole() == 1) {
                    return "redirect:/admin";
                }
                return "redirect:/index";
            }
        }
        model.addAttribute("logError", "logError");
        return "login";
    }

    public class UserRowMaapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {

            User user = new User();
            user.id = resultSet.getLong("id");
            user.username = resultSet.getString("username");
            user.password = resultSet.getString("password");
            user.role = resultSet.getInt("role");
            return user;
        }
    }
        // tim kiem


    // save user
    @RequestMapping(value = "saveUser", method = RequestMethod.POST)
    public String saveUser(User user) {


        userService.saveUser(user);
        return "redirect:/showAllUser";
    }

    // edit user
    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public String editUser(@RequestParam("id") Long userId, Model model) {
        Optional<User> userEdit = userService.findUserById(userId);
        userEdit.ifPresent(user -> model.addAttribute("user", user));
        return "editUser";
    }

    /**
     *
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public String deleteUser(@RequestParam("id") Long userId, Model model) {
        userService.deleteUser(userId);
        return "redirect:/showAllUser";
    }

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "addUser", method = RequestMethod.GET)
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    //////////// show all user
    @RequestMapping(value = {"/admin/showAllUser"})

    public String show(Model model) {
        List<User> users = userService.getAllUser();
        model.addAttribute("users", users);
        return "showAllUser";
    }
}
