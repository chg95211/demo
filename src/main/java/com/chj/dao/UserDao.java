package com.chj.dao;

import org.springframework.stereotype.Repository;

import com.chj.domain.UserDomain;
@Repository
public interface UserDao extends BaseRepository<UserDomain, Integer> {
}
