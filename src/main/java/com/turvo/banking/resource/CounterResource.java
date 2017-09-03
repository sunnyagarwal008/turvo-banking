package com.turvo.banking.resource;

import com.turvo.banking.dao.CounterDao;
import com.turvo.banking.model.Counter;
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
public class CounterResource {

    @Autowired
    private CounterDao counterDao;

    @RequestMapping(value = "/counters", method = RequestMethod.GET)
    @ResponseBody
    public List<Counter> getAll() {
        List<Counter> counters = new ArrayList<>();
        counterDao.findAll().forEach(counters::add);
        return counters;
    }

    public void incrementQueueSize(long counterId) {
        Counter counter = counterDao.findOne(counterId);
        counter.setQueueSize(counter.getQueueSize() + 1);
    }

    public void decrmentQueueSize(long counterId) {
        Counter counter = counterDao.findOne(counterId);
        counter.setQueueSize(counter.getQueueSize() - 1);
    }
}
