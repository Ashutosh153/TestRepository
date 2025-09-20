package com.core.aemfoundations.core.models;

import com.core.aemfoundations.core.pojo.UserProfilePojo;
import com.core.aemfoundations.core.service.PracticeService;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;
import java.util.List;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MyTitleDescModel {
    @OSGiService
    PracticeService service;

    public PracticeService getService() {
        return service;
    }

    @ValueMapValue
    @Default(values = "testTitle")
    private  String title;

    @ValueMapValue
    @Default(values = "testDesc")
    private  String description;

    @ValueMapValue
    private String imagePath;

    @Inject

    private List<UserProfilePojo> userProfile;

    public List<UserProfilePojo> getUserProfile() {
        return userProfile;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getTitle()
    {
        return title;
    }
    public  String getDescription()
    {
        return description;
    }



}
