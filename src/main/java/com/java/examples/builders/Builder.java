package com.java.examples.builders;

import com.java.examples.domain.Associate;

public interface Builder {
    Associate build(Associate associate);
    boolean appliesTo(Associate associate);
}
