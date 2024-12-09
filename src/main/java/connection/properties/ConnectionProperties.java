package connection.properties;

/**
 * 连接信息
 */
public class ConnectionProperties {

    // host
    private String host;

    // hostName
    private String hostName;

    // port
    private Integer port;

    // password
    private String password;

    // userName
    private String username;

    private Long connectTimeout;

    private Long readTimeout;


    public String getHost() {
        return host;
    }

    public ConnectionProperties setHost(String host) {
        this.host = host;
        return this;
    }

    public String getHostName() {
        return hostName;
    }

    public ConnectionProperties setHostName(String hostName) {
        this.hostName = hostName;
        return this;
    }

    public Integer getPort() {
        return port;
    }

    public ConnectionProperties setPort(Integer port) {
        this.port = port;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public ConnectionProperties setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public ConnectionProperties setUsername(String username) {
        this.username = username;
        return this;
    }

    public Long getConnectTimeout() {
        return connectTimeout;
    }

    public ConnectionProperties setConnectTimeout(Long connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }

    public Long getReadTimeout() {
        return readTimeout;
    }

    public ConnectionProperties setReadTimeout(Long readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }
}
