package com.hand13.bbs.dao.impl;

import com.hand13.bbs.dao.RoleDao;
import com.hand13.bbs.entity.Role;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by hd110 on 2017/10/26.
 * edited by hand13
 */
@Repository
public class RoleDaoImpl implements RoleDao {

    private static final String ROLEDAO_SQL= "com.hand13.bbs.dao.RoleDao.";

    private SqlSessionTemplate template;

    public SqlSessionTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(SqlSessionTemplate template) {
        this.template = template;
    }

    @Override
    public void addRole(Role role) {
        template.insert(ROLEDAO_SQL+"addRole",role);
    }

    @Override
    public Role getRoleByRoleName(String roleName) {
        return template.selectOne(ROLEDAO_SQL+"getRoleName",roleName);
    }

    @Override
    public List<Role> getAllRole() {
        return template.selectList(ROLEDAO_SQL+"getAllRole");
    }

    @Override
    public void updateRole(Role role) {
        template.update(ROLEDAO_SQL+"updateRole",role);
    }

    @Override
    public void deleteRoleById(Integer roleId) {
        template.delete(ROLEDAO_SQL+"deleteRole",roleId);
    }

    @Override
    public List<String> getRoles(List<Integer> ids) {
        List<String> roles = new LinkedList<>();
        for(Integer id:ids) {
            String role = template.selectOne(ROLEDAO_SQL+"getRole",id);
            Logger logger = LoggerFactory.getLogger(this.getClass());
            logger.debug(role);
            roles.add(role);
        }
        return roles;
    }
}
