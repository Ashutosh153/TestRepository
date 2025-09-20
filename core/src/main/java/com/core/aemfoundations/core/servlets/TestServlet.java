package com.core.aemfoundations.core.servlets;


import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceDescription;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = {Servlet.class},
        property = {
                "sling.servlet.methods=" + HttpConstants.METHOD_GET,
                "sling.servlet.paths=/bin/testservlet"
        }
)
@ServiceDescription("it will appear in description property in AEM")
public class TestServlet extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain");
        response.getWriter().write("name: " + request.getParameter("name"));
    }

}
//
//@Component(service = {Servlet.class})
//@SlingServletResourceTypes(
//        resourceTypes ="aemfoundations/components/page",
//        methods = HttpConstants.METHOD_GET,
//        extensions ="txt"
//)
//@ServiceDescription("it will appear in description property in aem")
//
//
//
//public class TestServlet extends SlingSafeMethodsServlet {
//
//    @Override
//    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
//            throws ServletException, IOException {
//       response.setContentType("text/plain");
//       response.getWriter().write("name:"+request.getParameter("name"));
//    }
//}