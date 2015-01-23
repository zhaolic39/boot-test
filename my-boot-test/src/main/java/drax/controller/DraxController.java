package drax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import drax.dao.DxAppDao;
import drax.entity.DxApp;

@RestController
public class DraxController {
    
    @Autowired
    private DxAppDao dxAppDao;
    
    @RequestMapping(value = "/apps", method = RequestMethod.GET)
    public Iterable<DxApp> getApps(){
        return dxAppDao.findAll();
    }
    
    @RequestMapping(value = "/apps/{id}", method = RequestMethod.GET)
    public DxApp getAppsById(@PathVariable String id){
        return dxAppDao.findOne(id);
    }
    
    @ResponseStatus(HttpStatus.CREATED)  
    @RequestMapping(value = "/apps", method = RequestMethod.POST)
    public DxApp createApp(@RequestBody DxApp app){
        return dxAppDao.save(app);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)  
    @RequestMapping(value = "/apps/{id}", method = RequestMethod.DELETE)
    public void deleteApp(@PathVariable String id){
        dxAppDao.delete(id);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)  
    @RequestMapping(value = "/apps/nocontent", method = RequestMethod.DELETE)
    public DxApp testNoContent(){
        DxApp app = new DxApp();
        app.setName("test");
        app.setId("test_id");
        return app;
    }
}
