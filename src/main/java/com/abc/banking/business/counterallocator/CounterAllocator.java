package com.abc.banking.business.counterallocator;

import com.abc.banking.model.Counter;
import com.abc.banking.model.Customer;
import com.abc.banking.model.Service;

/**
 * Created by sunny on 03/09/17.
 */
public interface CounterAllocator {

    Counter allocate(Service service, Customer customer);

}
