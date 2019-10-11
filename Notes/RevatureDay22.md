# 10/10/2019

1) Client sends a request

2) web container consults the deployment descriptor, d.d. passes the request to the deployment dispatcher

3) d.s. consults HandlerMapping to determine what controller should handle request

4) d.s. calls appropriate controller method which processes request
RequestMappingHandlerMapping-> bean which holds information from controller method mappings

5) two options:

a) controller method is annotated with @ResponseBody and just returns data which will form the HttpResponse
same effect if @RestController instead of @Controller

b) controller returns a vie wname and potentially some model data -> server side reqndering of a view (.jsp, PhlymeLeaf, freemaker)
d.s. will then consult with ViewResolver to find the correct view to return

6) return response