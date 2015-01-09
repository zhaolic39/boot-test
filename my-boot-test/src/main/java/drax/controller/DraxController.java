package drax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import drax.dao.DxAppDao;
import drax.entity.DxApp;

@Controller
public class DraxController {
    
    @Autowired
    private DxAppDao dxAppDao;
    
    @RequestMapping("/apps")
    @ResponseBody
    public Iterable<DxApp> getApps(){
        return dxAppDao.findAll();
    }
    
    @RequestMapping("/apps/{id}")
    @ResponseBody
    public DxApp getAppsById(@PathVariable String id){
        return dxAppDao.findOne(id);
    }
}
