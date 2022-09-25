namespace ExternalSystemProxy.ReverseProxy.HeaderRouting;

public interface IHeaderRouting
{
    public string RoutingHeaderName { get; }
    public string TestHeaderValue { get; }
    public string ProdHeaderValue { get; }
}