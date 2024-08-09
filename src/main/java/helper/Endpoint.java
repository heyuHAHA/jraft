package helper;

import java.io.Serializable;
import java.util.Objects;

public class Endpoint implements Serializable,Copiable<Endpoint> {
    private String ip;
    private int port;

    private transient String str;

    public Endpoint(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public String toString() {
        if (str == null) {
            str = ip + ":" + port;
        }
        return str;
    }

    @Override
    public Endpoint copy() {
        return new Endpoint(this.ip, this.port);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Endpoint endpoint = (Endpoint) o;
        return port == endpoint.port && Objects.equals(ip, endpoint.ip);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(ip);
        result = 31 * result + port;
        return result;
    }
}
