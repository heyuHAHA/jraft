package node;

import core.ConfigurationEntry;
import core.Node;
import core.PeerId;
import core.State;
import helper.NodeOptions;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NodeImpl implements Node {

    //集群id
    private final String groupId;

    private volatile State state;

    private PeerId leaderId = new PeerId();

    private final PeerId mine;

    private ConfigurationEntry conf;

    public NodeImpl(final String groupId, final PeerId mine) {
        if (groupId == null || groupId.isEmpty()) {
            throw new IllegalArgumentException("groupId cannot be null or empty");
        }
        this.groupId = groupId;
        this.mine = mine !=  null ? mine.copy() : null;
        this.state = State.STATE_UNINITIALIZED;
        log.info("The number of active nodes increment to {}.", 1);

    }


    public boolean init(NodeOptions opts) {
        return false;
    }

    @Override
    public void shutdown() {

    }
}
