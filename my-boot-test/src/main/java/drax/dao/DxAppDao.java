package drax.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import drax.entity.DxApp;

/**
 * 练习集DAO.
 * @author ChenST
 */
public interface DxAppDao extends PagingAndSortingRepository<DxApp, String>{

    public DxApp findByName(String name);
    
    @Query("select t.id, t.name, t.createBy FROM DxApp t WHERE t.createBy = :createBy")
    public List<Object[]> getByCreateBy(@Param("createBy") String createBy);

}