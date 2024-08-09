package core;

import helper.Copiable;
import helper.Endpoint;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.io.Serializable;


@Slf4j
@Getter
public class PeerId implements Serializable, Copiable<PeerId> {

    private int priority = ElectionPriority.Disabled;

    public static final String IP_ANY = "0.0.0.0";

    private Endpoint endpoint = new Endpoint(IP_ANY,0);

    private String str;

    public PeerId() {
    }

    public PeerId(Endpoint endpoint, int priority) {
        this.endpoint = endpoint;
        this.priority = priority;
    }

    public PeerId emptyPeer(){
        return new PeerId();
    }

    public void setPriority(int priority) {
        this.priority = priority;
        this.str = null;
    }


    @Override
    public PeerId copy() {
        //深拷贝
        return new PeerId(this.endpoint.copy(),this.priority);
    }
}
