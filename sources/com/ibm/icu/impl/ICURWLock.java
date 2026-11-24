package com.ibm.icu.impl;

import defpackage.cq;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class ICURWLock {
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private Stats stats = null;

    public void acquireRead() {
        if (this.stats != null) {
            synchronized (this) {
                try {
                    this.stats._rc++;
                    if (this.rwl.getReadLockCount() > 0) {
                        this.stats._mrc++;
                    }
                    if (this.rwl.isWriteLocked()) {
                        this.stats._wrc++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        this.rwl.readLock().lock();
    }

    public void acquireWrite() {
        if (this.stats != null) {
            synchronized (this) {
                try {
                    this.stats._wc++;
                    if (this.rwl.getReadLockCount() > 0 || this.rwl.isWriteLocked()) {
                        this.stats._wwc++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        this.rwl.writeLock().lock();
    }

    public synchronized Stats clearStats() {
        Stats stats;
        stats = this.stats;
        this.stats = null;
        return stats;
    }

    public synchronized Stats getStats() {
        Stats stats;
        stats = this.stats;
        return stats == null ? null : new Stats(stats, 0);
    }

    public void releaseRead() {
        this.rwl.readLock().unlock();
    }

    public void releaseWrite() {
        this.rwl.writeLock().unlock();
    }

    public synchronized Stats resetStats() {
        Stats stats;
        stats = this.stats;
        this.stats = new Stats(0);
        return stats;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Stats {
        public int _mrc;
        public int _rc;
        public int _wc;
        public int _wrc;
        public int _wwc;

        private Stats(Stats stats) {
            this(stats._rc, stats._mrc, stats._wrc, stats._wc, stats._wwc);
        }

        public String toString() {
            int i = this._rc;
            int i2 = this._mrc;
            int i3 = this._wrc;
            int i4 = this._wc;
            int i5 = this._wwc;
            StringBuilder sbP = cq.p(" rc: ", i, " mrc: ", i2, " wrc: ");
            sbP.append(i3);
            sbP.append(" wc: ");
            sbP.append(i4);
            sbP.append(" wwc: ");
            sbP.append(i5);
            return sbP.toString();
        }

        public /* synthetic */ Stats(Stats stats, int i) {
            this(stats);
        }

        private Stats() {
        }

        private Stats(int i, int i2, int i3, int i4, int i5) {
            this._rc = i;
            this._mrc = i2;
            this._wrc = i3;
            this._wc = i4;
            this._wwc = i5;
        }

        public /* synthetic */ Stats(int i) {
            this();
        }
    }
}
