namespace ExternalSystemProxy.ReverseProxy.HeaderRouting;

public class TargetExternalSystemRouting : IHeaderRouting
{
    public string RoutingHeaderName => Constants.Constants.TargetExternalSystemHeaderName;

    public string TestHeaderValue => "test";

    public string ProdHeaderValue => "live";
}