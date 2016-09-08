dynamic add Servlet and Filter using ServletContainerInitializer

ServletContainerInitializer interface introduced with Servlet 3.0 specification

implements of this interface are notified during the context startup phase

Per the Servlet specs, this implementation must be declared in a META-INF/services/javax.servlet.ServletContainerInitializer file

@HandleTypes annotation with a value of an interface(eg. WebApplicationInitializer.class) 
it means that the Servlet container will scan for classes implementing the WebApplicationInitializer implementation 
and call the ServletContainerInitializer.onStartUp method with these classes 