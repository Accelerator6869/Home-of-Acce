package com.zyf.sb_zyf.service;

import com.zyf.sb_zyf.pojo.DTO.UserDTO;
import com.zyf.sb_zyf.pojo.User;
import org.springframework.stereotype.Service;

@Service //配置成spring的bean，可以被注入到其他类中如controller
public interface IUserService {
    /*
    * 增加用户
    * @param user//参数
    *
    *
    * */
    User add(UserDTO user);
    User delete(UserDTO user);
    User update(Integer id, UserDTO user);
    User queryByID(Integer id);
}
