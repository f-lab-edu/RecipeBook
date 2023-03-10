package com.flab.recipebook.user.domain.dao;

import com.flab.recipebook.user.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {
    void save(User user);
}
