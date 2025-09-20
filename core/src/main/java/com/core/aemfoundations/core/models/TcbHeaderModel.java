package com.core.aemfoundations.core.models;

import com.core.aemfoundations.core.pojo.TcbNaveHeaderPojo;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;
import java.util.List;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class TcbHeaderModel {

    @ValueMapValue
    private  String buttonName;

    @ValueMapValue
    private String logoPath;

    @Inject
    private List<TcbNaveHeaderPojo> headerItemsName;


    public String getLogoPath() {
        return logoPath;
    }

    public List<TcbNaveHeaderPojo> getHeaderItemsName() {
        return headerItemsName;
    }

    public String getButtonName() {
        return buttonName;
    }
}
