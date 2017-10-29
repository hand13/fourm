package com.hand13.bbs.dao;

import com.hand13.bbs.entity.Role;

import java.util.List;

/**
 * Created by hd110 on 2017/10/25.
 * edited by hand13
 */
public interface RoleDao {

    void addRole(Role role);

    Role getRoleByRoleName(String roleName);

    List<Role> getAllRole();

    void updateRole(Role role);

    void deleteRoleById(Integer roleId);

    List<String> getRoles(List<Integer> ids);
}
