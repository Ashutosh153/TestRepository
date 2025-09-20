package com.core.aemfoundations.core.models;

import com.core.aemfoundations.core.service.PracticeService;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import javax.annotation.PostConstruct;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ServiceUseModel {
    @OSGiService
    PracticeService practiceService;


    String abc;

    public PracticeService getPracticeService() {
        return practiceService;
    }

    public String getAbc() {
        return abc = "Hello World" + " " +practiceService.getName();
    }




}
