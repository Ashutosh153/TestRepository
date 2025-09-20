package com.core.aemfoundations.core.service.impl;

import com.core.aemfoundations.core.service.PracticeService;
import org.osgi.service.component.annotations.Component;

@Component(service=PracticeService.class, immediate = true)
public class PracticeServiceImpl implements PracticeService {



    @Override
    public String getName() {
        return "its practice service ";
    }
}
