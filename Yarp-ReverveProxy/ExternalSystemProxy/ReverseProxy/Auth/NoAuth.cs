using Yarp.ReverseProxy.Configuration;

namespace ExternalSystemProxy.ReverseProxy.Auth;

public class NoAuth : IAuthRoute
{
    public RouteConfig Route(RouteConfig routeConfig)
    {
        return routeConfig;
    }
}