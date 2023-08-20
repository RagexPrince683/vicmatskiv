package com.vicmatskiv.weaponlib.state;

public class Result
{
    private boolean stateChanged;
    private S state;
    protected Object actionResult;
    final /* synthetic */ StateManager this$0;
    
    private Result(final StateManager this$0, final boolean stateChanged, final S targetState) {
        this.this$0 = this$0;
        super();
        this.stateChanged = stateChanged;
        this.state = targetState;
    }
    
    public boolean isStateChanged() {
        return this.stateChanged;
    }
    
    public S getState() {
        return this.state;
    }
    
    public Object getActionResult() {
        return this.actionResult;
    }
    
    Result(final StateManager x0, final boolean x1, final ManagedState x2, final StateManager$1 x3) {
        this(x1, (S)x2);
    }
}
