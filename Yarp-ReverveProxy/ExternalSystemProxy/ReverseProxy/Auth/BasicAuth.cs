using Yarp.ReverseProxy.Configuration;
using Yarp.ReverseProxy.Transforms;

namespace ExternalSystemProxy.ReverseProxy.Auth;

public class BasicAuth : IAuthRoute
{
    private static readonly string _authHeader = "Authorization";
    private readonly string _username;
    private readonly string _password;
    
    public BasicAuth(string username, string password)
    {
        _username = username;
        _password = password;
    }
    
    public RouteConfig Route(RouteConfig routeConfig)
    {
        return routeConfig.WithTransformRequestHeaderRemove(_authHeader).WithTransformRequestHeader(_authHeader, GetBasicAuthHeaderValue());
    }
    
    string GetBasicAuthHeaderValue()
    {
        var encodedCredentials = Base64Encode($"{_username}:{_password}");

        return $"Basic {encodedCredentials}";
    }

    static string Base64Encode(string plainText)
    {
        var plainTextBytes = System.Text.Encoding.UTF8.GetBytes(plainText);
        return Convert.ToBase64String(plainTextBytes);
    }
}