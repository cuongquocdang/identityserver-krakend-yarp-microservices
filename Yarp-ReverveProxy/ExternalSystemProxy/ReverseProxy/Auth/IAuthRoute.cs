using Yarp.ReverseProxy.Configuration;

namespace ExternalSystemProxy.ReverseProxy.Auth;

public interface IAuthRoute
{
    public RouteConfig Route(RouteConfig routeConfig);
}