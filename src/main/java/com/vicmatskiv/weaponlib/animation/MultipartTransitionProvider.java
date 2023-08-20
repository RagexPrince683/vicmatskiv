package com.vicmatskiv.weaponlib.animation;

import java.util.*;

public interface MultipartTransitionProvider<State, Part, Context>
{
    List<MultipartTransition<Part, Context>> getPositioning(final State p0);
}
