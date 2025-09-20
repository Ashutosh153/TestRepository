package com.core.aemfoundations.core.pojo;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;
import java.util.List;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class TcbNaveHeaderPojo {

@Inject
    private String  itemsName;

@Inject
    private List<TcbNaveSubHeaderPojo> subHeaderItemsName;

    public List<TcbNaveSubHeaderPojo> getSubHeaderItemsName() {
        return subHeaderItemsName;
    }

    public String getItemsName() {
        return itemsName;
    }
}
