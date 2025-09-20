package com.core.aemfoundations.core.pojo;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;
import java.util.List;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TcbNaveSubHeaderPojo {

   @Inject
    private String subItemsName;

   @Inject
   private List<TcbNaveSubSubHeaderPojo>subSubHeaderItemsName;

    public List<TcbNaveSubSubHeaderPojo> getSubSubHeaderItemsName() {
        return subSubHeaderItemsName;
    }

    public String getSubItemsName() {
        return subItemsName;
    }
}
