package com.ibm.icu.impl;

import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class IterableComparator<T> implements Comparator<Iterable<T>> {
    private static final IterableComparator NOCOMPARATOR = new IterableComparator();
    private final Comparator<T> comparator;
    private final int shorterFirst;

    public IterableComparator(Comparator<T> comparator, boolean z) {
        this.comparator = comparator;
        this.shorterFirst = z ? 1 : -1;
    }

    public static <T> int compareIterables(Iterable<T> iterable, Iterable<T> iterable2) {
        return NOCOMPARATOR.compare((Iterable) iterable, (Iterable) iterable2);
    }

    @Override // java.util.Comparator
    public int compare(Iterable<T> iterable, Iterable<T> iterable2) {
        int i;
        if (iterable == null) {
            if (iterable2 == null) {
                return 0;
            }
            i = this.shorterFirst;
        } else {
            if (iterable2 == null) {
                return this.shorterFirst;
            }
            Iterator<T> it = iterable2.iterator();
            for (T t : iterable) {
                if (!it.hasNext()) {
                    return this.shorterFirst;
                }
                T next = it.next();
                Comparator<T> comparator = this.comparator;
                int iCompare = comparator != null ? comparator.compare(t, next) : ((Comparable) t).compareTo(next);
                if (iCompare != 0) {
                    return iCompare;
                }
            }
            if (!it.hasNext()) {
                return 0;
            }
            i = this.shorterFirst;
        }
        return -i;
    }

    public IterableComparator(Comparator<T> comparator) {
        this(comparator, true);
    }

    public IterableComparator() {
        this(null, true);
    }
}
