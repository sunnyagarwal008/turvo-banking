package com.turvo.banking.business.counterallocator;

import com.turvo.banking.model.Counter;
import com.turvo.banking.model.Customer;
import com.turvo.banking.model.Service;
import com.turvo.banking.model.Token;

/**
 * Created by sunny on 03/09/17.
 */
public interface CounterAllocator {

    Counter allocate(Service service, Customer customer);

}
