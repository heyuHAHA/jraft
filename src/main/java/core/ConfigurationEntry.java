package core;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Getter
@Setter
public class ConfigurationEntry {
    private Configuration currentConf = new Configuration();

    private Configuration oldConf = new Configuration();

    public ConfigurationEntry() {
    }

    //判断旧的配置是否为空，如果为空，说明当前集群的配置没有进行过变更，也就代表当前集群很稳定
    public boolean isStable(){
        return this.oldConf.isEmpty();
    }

    //把当前配置和旧配置中的所有PeerId以集合的形式返回
    public Set<PeerId> listPeers() {
        final Set<PeerId> ret = new HashSet<>(this.currentConf.listPeers());
        ret.addAll(this.oldConf.listPeers());
        return ret;
    }

    public boolean contains(final PeerId peerId) {
        return this.currentConf.contains(peerId) || this.oldConf.contains(peerId);
    }


}
