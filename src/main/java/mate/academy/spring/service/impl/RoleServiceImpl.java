package mate.academy.spring.service.impl;

import java.util.NoSuchElementException;
import mate.academy.spring.dao.RoleDao;
import mate.academy.spring.model.Role;
import mate.academy.spring.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role add(Role role) {
        return roleDao.add(role);
    }

    @Override
    public Role getByRoleName(Role.RoleName roleName) {
        return roleDao.getByRoleName(roleName).orElseThrow(() ->
                new NoSuchElementException("Can't get role with name " + roleName));
    }
}
