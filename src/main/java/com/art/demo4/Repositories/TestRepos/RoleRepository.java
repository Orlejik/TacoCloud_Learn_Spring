package com.art.demo4.Repositories.TestRepos;

import com.art.demo4.Data.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends CrudRepository<Role, Long> {
    @Query("SELECT r FROM Role r WHERE r.roleName=:roleName")
    Role findByRoleName(@Param("roleName") String roleName);
//    @Query("SELECT r FROM Role r WHERE r.roleName=:roleName")
//    Role findRoleByRoleName(@Param("roleName") String roleName);
}
