package controller;

import service.UserService;

public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void addUserToGroup(String userId, String groupId){
        userService.addUserToGroup(userId, groupId);
    }

    public void removeUserFromGroup(String userId, String groupId){
        userService.removeUserFromGroup(userId, groupId);
    }
}
