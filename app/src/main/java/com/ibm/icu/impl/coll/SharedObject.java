package com.ibm.icu.impl.coll;

import com.ibm.icu.util.ICUCloneNotSupportedException;
import java.lang.ref.Cleaner;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class SharedObject implements Cloneable {
    private AtomicInteger refCount = new AtomicInteger();

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class SharedObjectHolder<T extends SharedObject> implements Runnable {
        private T sharedObj;

        public SharedObjectHolder(T t) {
            this.sharedObj = t;
        }

        public T get() {
            return this.sharedObj;
        }

        @Override // java.lang.Runnable
        public void run() {
            T t = this.sharedObj;
            if (t != null) {
                t.removeRef();
                this.sharedObj = null;
            }
        }

        public void set(T t) {
            this.sharedObj = t;
        }
    }

    public final void addRef() {
        this.refCount.incrementAndGet();
    }

    @Override // 
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public SharedObject mo8clone() {
        try {
            SharedObject sharedObject = (SharedObject) super.clone();
            sharedObject.refCount = new AtomicInteger();
            return sharedObject;
        } catch (CloneNotSupportedException e) {
            throw new ICUCloneNotSupportedException(e);
        }
    }

    public final int getRefCount() {
        return this.refCount.get();
    }

    public final void removeRef() {
        this.refCount.decrementAndGet();
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Reference<T extends SharedObject> implements AutoCloseable {
        private static final Cleaner CLEANER = Cleaner.create();
        private final Cleaner.Cleanable cleanable;
        private final SharedObjectHolder<T> sharedObjectHolder;

        public Reference(T t) {
            SharedObjectHolder<T> sharedObjectHolder = new SharedObjectHolder<>(t);
            this.sharedObjectHolder = sharedObjectHolder;
            if (t != null) {
                t.addRef();
            }
            this.cleanable = CLEANER.register(this, sharedObjectHolder);
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            this.cleanable.clean();
        }

        public T copyOnWrite() {
            T t = (T) this.sharedObjectHolder.get();
            if (t.getRefCount() <= 1) {
                return t;
            }
            T t2 = (T) t.mo8clone();
            t.removeRef();
            t2.addRef();
            this.sharedObjectHolder.set(t2);
            return t2;
        }

        public T readOnly() {
            return (T) this.sharedObjectHolder.get();
        }

        public Reference(Reference<T> reference) {
            this(reference.readOnly());
        }
    }

    public final void deleteIfZeroRefCount() {
    }
}
