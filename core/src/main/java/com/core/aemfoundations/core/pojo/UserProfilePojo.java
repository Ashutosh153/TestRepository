package com.core.aemfoundations.core.pojo;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;
import java.util.List;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class UserProfilePojo {
    @Inject
    @Default(values = "Test ttttt")
    private String title;

    @Inject
    private String description;

    @Inject
    private String imagePath;

    @Inject
    private List<UserAddressPojo> userAddress;



    public String getDescription() {
        return description;
    }


    public String getTitle() {
        return title;
    }

    public String getImagePath() {
        return imagePath;
    }

    public List<UserAddressPojo> getUserAddress() {
        return userAddress;
    }
}
