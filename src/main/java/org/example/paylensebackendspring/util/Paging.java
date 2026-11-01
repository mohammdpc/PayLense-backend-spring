package org.example.paylensebackendspring.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public final class Paging {

    private static final int MAX_SIZE = 100;

    private Paging() {
    }

    public static Pageable of(int page, int size) {
        int safePage = Math.max(page, 0);
        int safeSize = Math.min(Math.max(size, 1), MAX_SIZE);
        return PageRequest.of(safePage, safeSize);
    }
}
