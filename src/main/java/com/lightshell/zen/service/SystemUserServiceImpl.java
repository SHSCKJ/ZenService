package com.lightshell.zen.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import com.lightshell.zen.common.SuperService;
import com.lightshell.zen.entity.SystemUser;
import com.lightshell.zen.repository.SystemUserRepository;

/**
 * @author kevindong
 */
@Service
public class SystemUserServiceImpl implements SuperService<SystemUser> {

    @Autowired
    SystemUserRepository systemUserRepository;

    @Override
    public void delete(Integer id) {
        systemUserRepository.deleteById(id);
    }

    @Override
    public void deleteByUID(String uid) {
        SystemUser entity = findByUserid(uid);
        if (entity != null) {
            systemUserRepository.delete(entity);
        } else {
            throw new NullPointerException(uid);
        }
    }

    @Override
    public boolean existsById(Integer id) {
        return systemUserRepository.existsById(id);
    }

    @Override
    public boolean existsByUID(String uid) {
        SystemUser systemUser = findByUserid(uid);
        return systemUser != null;
    }

    @Override
    public List<SystemUser> findAll(@Nullable Map<String, String> sorts) {
        if (sorts != null && !sorts.isEmpty()) {
            Sort sort = null;
            for (Map.Entry<String, String> entry : sorts.entrySet()) {
                if (sort == null) {
                    sort = Sort.by(Sort.Direction.fromString(entry.getValue()), entry.getKey());
                } else {
                    sort = sort.and(Sort.by(Sort.Direction.fromString(entry.getValue()), entry.getKey()));
                }
            }
            return systemUserRepository.findAll(sort);
        }
        return systemUserRepository.findAll();
    }

    @Override
    public SystemUser findById(Integer id) {
        try {
            return systemUserRepository.findById(id).get();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public SystemUser findByUID(String uid) {
        return systemUserRepository.findByUseridEquals(uid);
    }

    @Override
    public long getCount() {
        return systemUserRepository.count();
    }

    @Override
    public long getCount(Map<String, Object> filters) {
        return systemUserRepository.count(getSpecification(filters));
    }

    @Override
    public SystemUser save(SystemUser user) {
        return systemUserRepository.save(user);
    }

    @Override
    public List<SystemUser> saveAll(List<SystemUser> data) {
        return systemUserRepository.saveAll(data);
    }

    public SystemUser findByUserid(String userid) {
        return systemUserRepository.findByUseridEquals(userid);
    }
}