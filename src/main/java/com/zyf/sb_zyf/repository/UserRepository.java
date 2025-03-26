package com.zyf.sb_zyf.repository;

import com.zyf.sb_zyf.pojo.DTO.UserDTO;
import com.zyf.sb_zyf.pojo.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//只需继承CrudRepository接口即可实现增删查改，不需要自己实现任何方法
//第一个类型是操作哪个POJO类，第二个类型是主键的类型
@Repository//注册为spring的bean,可以被注入到其他类中,如service
public interface UserRepository extends CrudRepository<User, Integer> {
    // 确保存在以下方法之一
    boolean existsByUsername(String username);// 自动生成查询
}
