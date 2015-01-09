package drax.dao;

import org.springframework.data.repository.CrudRepository;

import drax.entity.DxApp;

/**
 * 练习集DAO.
 * @author ChenST
 */
public interface DxAppDao extends CrudRepository<DxApp, String>{

    public DxApp findByName(String name);

}