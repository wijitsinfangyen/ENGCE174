package lab3;

public class systemconfig {
    private static systemconfig instance;
    private String serverUrl;
    private int maxConnections;

    private systemconfig() {
        serverUrl = "default.server.com";
        maxConnections = 10;
    }

    public static systemconfig getInstance() {
        if (instance == null) {
            instance = new systemconfig();
        }
        return instance;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String url) {
        serverUrl = url;
    }

    public int getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(int count) {
        if (count > 0) {
            maxConnections = count;
            System.out.println("Max connections set.");
        } else {
            System.out.println("Invalid count.");
        }
    }
}
