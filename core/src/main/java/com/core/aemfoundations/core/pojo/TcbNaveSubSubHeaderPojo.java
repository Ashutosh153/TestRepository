package com.core.aemfoundations.core.pojo;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class TcbNaveSubSubHeaderPojo {

    @Inject
    private  String subSubItemsName;

    public String getSubSubItemsName() {
        return subSubItemsName;
    }
}
