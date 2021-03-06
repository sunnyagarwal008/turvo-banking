package com.abc.banking.resource;

import com.abc.banking.dao.ServiceDao;
import com.abc.banking.model.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sunny
 */
@Controller
public class ServiceResource {

    @Autowired
    private ServiceDao serviceDao;

    @RequestMapping(value = "/services", method = RequestMethod.GET)
    @ResponseBody
    public List<Service> getAll() {
        List<Service> services = new ArrayList<>();
        serviceDao.findAll().forEach(services::add);
        return services;
    }

    public Service findByName(String name) {
        return serviceDao.findByName(name);
    }

    public Service findById(long id) {
        return serviceDao.findOne(id);
    }
}
