package core;

public enum State {
    STATE_LEADER,
    STATE_FOLLOWER,
    STATE_CANDIDATE,
    STATE_ERROR,
    STATE_UNINITIALIZED,
    STATE_SHUTTING,
    STATE_SHUTDOWN;

    public boolean isActive(){
        return this.ordinal() < STATE_ERROR.ordinal();
    }
}
