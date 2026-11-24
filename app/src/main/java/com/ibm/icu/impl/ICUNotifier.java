package com.ibm.icu.impl;

import defpackage.og;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ICUNotifier {
    private List<EventListener> listeners;
    private final Object notifyLock = new Object();
    private NotifyThread notifyThread;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class NotifyThread extends Thread {
        private final ICUNotifier notifier;
        private final List<EventListener[]> queue = new ArrayList();

        public NotifyThread(ICUNotifier iCUNotifier) {
            this.notifier = iCUNotifier;
        }

        public void queue(EventListener[] eventListenerArr) {
            synchronized (this) {
                this.queue.add(eventListenerArr);
                notify();
            }
        }

        /* JADX WARN: Bottom block not found for handler: all -> 0x000d */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r4 = this;
            L0:
                monitor-enter(r4)     // Catch: java.lang.InterruptedException -> L0
            L1:
                java.util.List<java.util.EventListener[]> r0 = r4.queue     // Catch: java.lang.Throwable -> Ld
                boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> Ld
                if (r0 == 0) goto Lf
                r4.wait()     // Catch: java.lang.Throwable -> Ld
                goto L1
            Ld:
                r0 = move-exception
                goto L26
            Lf:
                java.util.List<java.util.EventListener[]> r0 = r4.queue     // Catch: java.lang.Throwable -> Ld
                r1 = 0
                java.lang.Object r0 = r0.remove(r1)     // Catch: java.lang.Throwable -> Ld
                java.util.EventListener[] r0 = (java.util.EventListener[]) r0     // Catch: java.lang.Throwable -> Ld
                monitor-exit(r4)     // Catch: java.lang.Throwable -> Ld
            L19:
                int r2 = r0.length     // Catch: java.lang.InterruptedException -> L0
                if (r1 >= r2) goto L0
                com.ibm.icu.impl.ICUNotifier r2 = r4.notifier     // Catch: java.lang.InterruptedException -> L0
                r3 = r0[r1]     // Catch: java.lang.InterruptedException -> L0
                r2.notifyListener(r3)     // Catch: java.lang.InterruptedException -> L0
                int r1 = r1 + 1
                goto L19
            L26:
                monitor-exit(r4)     // Catch: java.lang.Throwable -> Ld
                throw r0     // Catch: java.lang.InterruptedException -> L0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.impl.ICUNotifier.NotifyThread.run():void");
        }
    }

    public abstract boolean acceptsListener(EventListener eventListener);

    public void addListener(EventListener eventListener) {
        eventListener.getClass();
        if (!acceptsListener(eventListener)) {
            og.n("Listener invalid for this notifier.");
            return;
        }
        synchronized (this.notifyLock) {
            try {
                List<EventListener> list = this.listeners;
                if (list == null) {
                    this.listeners = new ArrayList();
                } else {
                    Iterator<EventListener> it = list.iterator();
                    while (it.hasNext()) {
                        if (it.next() == eventListener) {
                            return;
                        }
                    }
                }
                this.listeners.add(eventListener);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void notifyChanged() {
        synchronized (this.notifyLock) {
            try {
                if (this.listeners != null) {
                    if (this.notifyThread == null) {
                        NotifyThread notifyThread = new NotifyThread(this);
                        this.notifyThread = notifyThread;
                        notifyThread.setDaemon(true);
                        this.notifyThread.start();
                    }
                    NotifyThread notifyThread2 = this.notifyThread;
                    List<EventListener> list = this.listeners;
                    notifyThread2.queue((EventListener[]) list.toArray(new EventListener[list.size()]));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void notifyListener(EventListener eventListener);

    public void removeListener(EventListener eventListener) {
        eventListener.getClass();
        synchronized (this.notifyLock) {
            try {
                List<EventListener> list = this.listeners;
                if (list != null) {
                    Iterator<EventListener> it = list.iterator();
                    while (it.hasNext()) {
                        if (it.next() == eventListener) {
                            it.remove();
                            if (this.listeners.size() == 0) {
                                this.listeners = null;
                            }
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
