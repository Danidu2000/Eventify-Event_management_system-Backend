package edu.icet.service;

import edu.icet.dto.LoginDetails;
import edu.icet.dto.LoginStatus;
import edu.icet.dto.User;

public interface UserService extends CrudService<User>{
    LoginStatus login(LoginDetails loginDetails);

    User searchByEmail(String email);
}
