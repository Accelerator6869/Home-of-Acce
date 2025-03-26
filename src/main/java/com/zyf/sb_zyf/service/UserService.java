package com.zyf.sb_zyf.service;

import com.zyf.sb_zyf.exception.BusinessException;
import com.zyf.sb_zyf.pojo.DTO.UserDTO;
import com.zyf.sb_zyf.pojo.DTO.UserDTO.*;
import com.zyf.sb_zyf.pojo.DTO.request.RegistrationRequest;
import com.zyf.sb_zyf.pojo.User;
import com.zyf.sb_zyf.repository.UserRepository;
import jakarta.servlet.Registration;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service//配置成spring的bean，可以被注入到其他类中如controller
public class UserService implements IUserService{

    @Autowired
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // 构造器注入依赖
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void registerUser(RegistrationRequest request) {
        // 检查用户名唯一性
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new BusinessException("用户名已存在");
        }

        // 创建用户并保存
        User user = new User();
        user.setUserName(request.getUsername());
        user.setUserPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user); // 使用 CrudRepository 的 save()
    }


    @Override
    public User add(UserDTO user){

        User userPOJO = new User();
        BeanUtils.copyProperties(user, userPOJO);//把user的属性复制到userPOJO中
        return userRepository.save(userPOJO);//会自动判断是增加还是修改，没有ID则是增加，有ID则是修改
        //返回User类型的对象
    }

    @Override
    public User delete(UserDTO user){
        User userPOJO = new User();
        BeanUtils.copyProperties(user, userPOJO);
        userRepository.delete(userPOJO);
        return userPOJO;
    }

    @Override
    public User update(Integer id, UserDTO user){
        User userPOJO = userRepository.findById(id).get();//根据ID查询User对象
        userPOJO.setUserName(user.getUserName());
        userPOJO.setEmail(user.getEmail());
        return userRepository.save(userPOJO);//修改后保存
    }

    @Override
    public User queryByID(Integer id){
        return userRepository.findById(id).get();//返回User类型的对象
    }
}
