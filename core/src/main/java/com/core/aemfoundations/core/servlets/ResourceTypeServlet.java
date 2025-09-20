package com.core.aemfoundations.core.servlets;


import org.apache.jackrabbit.vault.util.JcrConstants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceDescription;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;


@Component(service = Servlet.class)
@SlingServletResourceTypes(
        resourceTypes = "/apps/aemfoundations/components/content/simple-box",
        methods = HttpConstants.METHOD_GET,
       extensions = "txt"
)
@ServiceDescription("Hello")
public class ResourceTypeServlet extends SlingSafeMethodsServlet {
    @Override
    protected void doGet( SlingHttpServletRequest request,  SlingHttpServletResponse response)
            throws ServletException, IOException {
       // Resource resource=request.getResource();
        //response.setContentType("text/plain");
        //response.getWriter().write("page title "+resource.getValueMap().get(JcrConstants.JCR_TITLE));
        response.getWriter().write("Hello World");
    }
}
