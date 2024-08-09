package core;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Configuration {

    private List<PeerId> peers = new ArrayList<>();

    public Configuration() {
    }

    public Configuration(final Iterable<PeerId> peers) {
        for(final PeerId p : peers) {
            this.peers.add(p.copy());
        }
    }

    public void reset( ) {
        this.peers.clear();
    }

    public List<PeerId> listPeers() {
        return new ArrayList<>(this.peers);
    }

    public List<PeerId> getPeers(){
        return this.peers;
    }

    public void setPeers(final List<PeerId> peers) {
        this.peers.clear();
        for(final PeerId p : peers) {
            this.peers.add(p.copy());
        }
    }

    public boolean addPeer(final PeerId p) {
        return this.peers.add(p);
    }

    public boolean isEmpty(){
        return this.peers.isEmpty();
    }

    public boolean contains(final PeerId p) {
        return this.peers.contains(p);
    }
}
