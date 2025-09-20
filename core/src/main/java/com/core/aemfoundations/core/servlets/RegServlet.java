package com.core.aemfoundations.core.servlets;

import org.apache.jackrabbit.vault.util.JcrConstants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Component(service = Servlet.class)
@SlingServletPaths("/bin/regSubmit")
public class RegServlet extends SlingAllMethodsServlet {
    private static final Logger log = LoggerFactory.getLogger(RegServlet.class);

    public boolean isExist=false;

    @Reference
    private  ResourceResolverFactory factory;
    @Override
    protected void doPost(final SlingHttpServletRequest request, final SlingHttpServletResponse response)
            throws ServletException, IOException {
        log.info(" RECEIVED_DATA " + request.getParameter("formData"));
        response.setContentType("text/plain");

        ResourceResolver resolver = null;
//        try {
//            resolver = customResourceResolver(factory);
//        } catch (LoginException e) {
//            throw new RuntimeException(e);
//        }
        resolver= request.getResourceResolver();
        Resource resource = resolver.getResource("/content/dam/aemfoundations/userprofiles");
        Node oldNode = resource.adaptTo(Node.class);
        Node newNode = null;
        if(oldNode !=null)
        {
            Iterator<Resource> children = resource.listChildren();
            while(children.hasNext())
            {
                if (request.getParameter("email").equals(children.next().getName()))
                {
                    response.getWriter().write("the user with username "+request.getParameter("email")+"already exist");
                    isExist=true;
                    break;
                }
                else {
                    isExist=false;
                }
            }
        }
        if(!isExist) {
            try {
                newNode = oldNode.addNode(request.getParameter("email"), JcrConstants.NT_UNSTRUCTURED);
                log.info("email: " + request.getParameter("email"));
                log.info(newNode.toString());
                newNode.setProperty("name", request.getParameter("fname") + " " + request.getParameter("lname"));
                newNode.setProperty("email", request.getParameter("email"));
                newNode.setProperty("gender", request.getParameter("gender"));
                newNode.setProperty("dob", request.getParameter("dob"));
                newNode.setProperty("bioData", request.getParameter("bioData"));
                newNode.setProperty("interestInSports", request.getParameter("interestInSports"));
                newNode.setProperty("sports", request.getParameterValues("sports"));
                resolver.commit();
                response.getWriter().write("node added successfully with name " + request.getParameter("email"));
            } catch (Exception e) {
                log.info("an error occured " + e);
                response.getWriter().write("an error occured " + e);
            }
            resolver.close();
        }
    }

//  public ResourceResolver  customResourceResolver(ResourceResolverFactory factory) throws LoginException {
//
//
//          final Map parameters = new HashMap();
//          parameters.put(factory.SUBSERVICE, "bot");
//          return factory.getServiceResourceResolver(parameters);
//
//      }

}