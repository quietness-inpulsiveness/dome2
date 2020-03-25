package com.service;

import com.dao.T_userDao;
import com.entity.T_user;
import com.test.Test;

import java.util.List;

public class T_userServe {
    T_userDao t_userDao =new T_userDao();
    //获取所有
    public List<T_user> getAllT_user(){
        return  t_userDao.getAllT_user();
    }
    //添加用户
    public int addT_user(T_user user){
        return t_userDao.addT_user(user);
    }
    //获取用户信息
    public T_user getT_user(int id){
        return t_userDao.getT_user(id);
    }
    //删除一个或多个用户
    public int DelT_user(String idList){
        return t_userDao.DelT_user(idList);
    }
}
