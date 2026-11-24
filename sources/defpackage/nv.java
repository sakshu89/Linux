package defpackage;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.os.Trace;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class nv implements Runnable {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ ov b;
    public final /* synthetic */ Executor c;
    public final /* synthetic */ long e;
    public final /* synthetic */ int f;
    public final /* synthetic */ Context i;
    public final /* synthetic */ tp j;

    public /* synthetic */ nv(ov ovVar, Context context, Executor executor, int i, tp tpVar, long j) {
        this.b = ovVar;
        this.i = context;
        this.c = executor;
        this.f = i;
        this.j = tpVar;
        this.e = j;
    }

    /* JADX WARN: Code duplicated, block: B:52:0x0110 A[Catch: all -> 0x01b7, TryCatch #6 {all -> 0x01b7, blocks: (B:7:0x003e, B:9:0x0046, B:11:0x0066, B:13:0x0070, B:15:0x0089, B:17:0x0094, B:24:0x00a3, B:26:0x00b1, B:28:0x00b7, B:29:0x00bd, B:30:0x00bf, B:33:0x00c3, B:37:0x00cd, B:38:0x00ce, B:39:0x00da, B:40:0x00db, B:41:0x00e7, B:50:0x00ff, B:52:0x0110, B:53:0x0117, B:57:0x0120, B:59:0x014e, B:60:0x0153, B:61:0x015e, B:62:0x0160, B:66:0x0165, B:68:0x0169, B:69:0x016b, B:72:0x016f, B:76:0x0176, B:77:0x0177, B:79:0x017b, B:80:0x01a0, B:82:0x01a4, B:83:0x01a9, B:88:0x01b6, B:48:0x00f0, B:49:0x00fe, B:70:0x016c, B:71:0x016e, B:64:0x0162, B:65:0x0164), top: B:96:0x003e, inners: #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x011b  */
    /* JADX WARN: Code duplicated, block: B:61:0x015e A[Catch: all -> 0x01b7, TryCatch #6 {all -> 0x01b7, blocks: (B:7:0x003e, B:9:0x0046, B:11:0x0066, B:13:0x0070, B:15:0x0089, B:17:0x0094, B:24:0x00a3, B:26:0x00b1, B:28:0x00b7, B:29:0x00bd, B:30:0x00bf, B:33:0x00c3, B:37:0x00cd, B:38:0x00ce, B:39:0x00da, B:40:0x00db, B:41:0x00e7, B:50:0x00ff, B:52:0x0110, B:53:0x0117, B:57:0x0120, B:59:0x014e, B:60:0x0153, B:61:0x015e, B:62:0x0160, B:66:0x0165, B:68:0x0169, B:69:0x016b, B:72:0x016f, B:76:0x0176, B:77:0x0177, B:79:0x017b, B:80:0x01a0, B:82:0x01a4, B:83:0x01a9, B:88:0x01b6, B:48:0x00f0, B:49:0x00fe, B:70:0x016c, B:71:0x016e, B:64:0x0162, B:65:0x0164), top: B:96:0x003e, inners: #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0161  */
    /* JADX WARN: Code duplicated, block: B:68:0x0169 A[Catch: all -> 0x01b7, TryCatch #6 {all -> 0x01b7, blocks: (B:7:0x003e, B:9:0x0046, B:11:0x0066, B:13:0x0070, B:15:0x0089, B:17:0x0094, B:24:0x00a3, B:26:0x00b1, B:28:0x00b7, B:29:0x00bd, B:30:0x00bf, B:33:0x00c3, B:37:0x00cd, B:38:0x00ce, B:39:0x00da, B:40:0x00db, B:41:0x00e7, B:50:0x00ff, B:52:0x0110, B:53:0x0117, B:57:0x0120, B:59:0x014e, B:60:0x0153, B:61:0x015e, B:62:0x0160, B:66:0x0165, B:68:0x0169, B:69:0x016b, B:72:0x016f, B:76:0x0176, B:77:0x0177, B:79:0x017b, B:80:0x01a0, B:82:0x01a4, B:83:0x01a9, B:88:0x01b6, B:48:0x00f0, B:49:0x00fe, B:70:0x016c, B:71:0x016e, B:64:0x0162, B:65:0x0164), top: B:96:0x003e, inners: #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x0177 A[Catch: all -> 0x01b7, TryCatch #6 {all -> 0x01b7, blocks: (B:7:0x003e, B:9:0x0046, B:11:0x0066, B:13:0x0070, B:15:0x0089, B:17:0x0094, B:24:0x00a3, B:26:0x00b1, B:28:0x00b7, B:29:0x00bd, B:30:0x00bf, B:33:0x00c3, B:37:0x00cd, B:38:0x00ce, B:39:0x00da, B:40:0x00db, B:41:0x00e7, B:50:0x00ff, B:52:0x0110, B:53:0x0117, B:57:0x0120, B:59:0x014e, B:60:0x0153, B:61:0x015e, B:62:0x0160, B:66:0x0165, B:68:0x0169, B:69:0x016b, B:72:0x016f, B:76:0x0176, B:77:0x0177, B:79:0x017b, B:80:0x01a0, B:82:0x01a4, B:83:0x01a9, B:88:0x01b6, B:48:0x00f0, B:49:0x00fe, B:70:0x016c, B:71:0x016e, B:64:0x0162, B:65:0x0164), top: B:96:0x003e, inners: #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x017b A[Catch: all -> 0x01b7, TryCatch #6 {all -> 0x01b7, blocks: (B:7:0x003e, B:9:0x0046, B:11:0x0066, B:13:0x0070, B:15:0x0089, B:17:0x0094, B:24:0x00a3, B:26:0x00b1, B:28:0x00b7, B:29:0x00bd, B:30:0x00bf, B:33:0x00c3, B:37:0x00cd, B:38:0x00ce, B:39:0x00da, B:40:0x00db, B:41:0x00e7, B:50:0x00ff, B:52:0x0110, B:53:0x0117, B:57:0x0120, B:59:0x014e, B:60:0x0153, B:61:0x015e, B:62:0x0160, B:66:0x0165, B:68:0x0169, B:69:0x016b, B:72:0x016f, B:76:0x0176, B:77:0x0177, B:79:0x017b, B:80:0x01a0, B:82:0x01a4, B:83:0x01a9, B:88:0x01b6, B:48:0x00f0, B:49:0x00fe, B:70:0x016c, B:71:0x016e, B:64:0x0162, B:65:0x0164), top: B:96:0x003e, inners: #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x01a0 A[Catch: all -> 0x01b7, TryCatch #6 {all -> 0x01b7, blocks: (B:7:0x003e, B:9:0x0046, B:11:0x0066, B:13:0x0070, B:15:0x0089, B:17:0x0094, B:24:0x00a3, B:26:0x00b1, B:28:0x00b7, B:29:0x00bd, B:30:0x00bf, B:33:0x00c3, B:37:0x00cd, B:38:0x00ce, B:39:0x00da, B:40:0x00db, B:41:0x00e7, B:50:0x00ff, B:52:0x0110, B:53:0x0117, B:57:0x0120, B:59:0x014e, B:60:0x0153, B:61:0x015e, B:62:0x0160, B:66:0x0165, B:68:0x0169, B:69:0x016b, B:72:0x016f, B:76:0x0176, B:77:0x0177, B:79:0x017b, B:80:0x01a0, B:82:0x01a4, B:83:0x01a9, B:88:0x01b6, B:48:0x00f0, B:49:0x00fe, B:70:0x016c, B:71:0x016e, B:64:0x0162, B:65:0x0164), top: B:96:0x003e, inners: #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x01a4 A[Catch: all -> 0x01b7, TryCatch #6 {all -> 0x01b7, blocks: (B:7:0x003e, B:9:0x0046, B:11:0x0066, B:13:0x0070, B:15:0x0089, B:17:0x0094, B:24:0x00a3, B:26:0x00b1, B:28:0x00b7, B:29:0x00bd, B:30:0x00bf, B:33:0x00c3, B:37:0x00cd, B:38:0x00ce, B:39:0x00da, B:40:0x00db, B:41:0x00e7, B:50:0x00ff, B:52:0x0110, B:53:0x0117, B:57:0x0120, B:59:0x014e, B:60:0x0153, B:61:0x015e, B:62:0x0160, B:66:0x0165, B:68:0x0169, B:69:0x016b, B:72:0x016f, B:76:0x0176, B:77:0x0177, B:79:0x017b, B:80:0x01a0, B:82:0x01a4, B:83:0x01a9, B:88:0x01b6, B:48:0x00f0, B:49:0x00fe, B:70:0x016c, B:71:0x016e, B:64:0x0162, B:65:0x0164), top: B:96:0x003e, inners: #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x01a9 A[Catch: all -> 0x01b7, TRY_LEAVE, TryCatch #6 {all -> 0x01b7, blocks: (B:7:0x003e, B:9:0x0046, B:11:0x0066, B:13:0x0070, B:15:0x0089, B:17:0x0094, B:24:0x00a3, B:26:0x00b1, B:28:0x00b7, B:29:0x00bd, B:30:0x00bf, B:33:0x00c3, B:37:0x00cd, B:38:0x00ce, B:39:0x00da, B:40:0x00db, B:41:0x00e7, B:50:0x00ff, B:52:0x0110, B:53:0x0117, B:57:0x0120, B:59:0x014e, B:60:0x0153, B:61:0x015e, B:62:0x0160, B:66:0x0165, B:68:0x0169, B:69:0x016b, B:72:0x016f, B:76:0x0176, B:77:0x0177, B:79:0x017b, B:80:0x01a0, B:82:0x01a4, B:83:0x01a9, B:88:0x01b6, B:48:0x00f0, B:49:0x00fe, B:70:0x016c, B:71:0x016e, B:64:0x0162, B:65:0x0164), top: B:96:0x003e, inners: #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x016c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:79:0x017b, please report this as an issue */
    @Override // java.lang.Runnable
    public final void run() {
        gu guVar;
        p72 p72VarA;
        switch (this.a) {
            case 0:
                ov ovVar = this.b;
                Context context = this.i;
                Executor executor = this.c;
                int i = this.f;
                tp tpVar = this.j;
                long j = this.e;
                Trace.beginSection(hd4.e("CX:initAndRetryRecursively"));
                Context contextA = el4.a(context);
                try {
                    try {
                        try {
                            if (ovVar.c.m() == null) {
                                throw new v01(new IllegalArgumentException("Invalid app configuration provided. Missing CameraFactory."));
                            }
                            xh xhVar = new xh(ovVar.d, ovVar.e);
                            ju juVarL = ovVar.c.l();
                            ovVar.f = new mq(contextA, xhVar, juVarL, ovVar.c.o());
                            if (ovVar.c.u() == null) {
                                throw new v01(new IllegalArgumentException("Invalid app configuration provided. Missing CameraDeviceSurfaceManager."));
                            }
                            mq mqVar = ovVar.f;
                            ovVar.g = wr.a(contextA, mqVar.e, new LinkedHashSet(mqVar.f));
                            if (ovVar.c.v() == null) {
                                throw new v01(new IllegalArgumentException("Invalid app configuration provided. Missing UseCaseConfigFactory."));
                            }
                            ovVar.h = new bs(contextA);
                            if (executor instanceof qt) {
                                ((qt) executor).a(ovVar.f);
                            }
                            ovVar.a.A(ovVar.f);
                            yu.a(contextA, ovVar.a, juVarL);
                            if (i > 1 && hd4.a()) {
                                hd4.b(-1, "CX:CameraProvider-RetryStatus");
                            }
                            synchronized (ovVar.b) {
                                ovVar.k = 4;
                                break;
                            }
                            tpVar.a(null);
                            Trace.endSection();
                            return;
                        } catch (RuntimeException e) {
                            e = e;
                            guVar = new gu(j, e);
                            p72VarA = ovVar.i.a(guVar);
                            if (hd4.a()) {
                                hd4.b(guVar.a, "CX:CameraProvider-RetryStatus");
                            }
                            if (p72VarA.b) {
                                synchronized (ovVar.b) {
                                    ovVar.k = 3;
                                    if (p72VarA.c) {
                                        synchronized (ovVar.b) {
                                            ovVar.k = 4;
                                            tpVar.a(null);
                                        }
                                    } else if (e instanceof xu) {
                                        String str = "Device reporting less cameras than anticipated. On real devices: Retrying initialization might resolve temporary camera errors. On emulators: Ensure virtual camera configuration matches supported camera features as reported by PackageManager#hasSystemFeature. Available cameras: " + ((xu) e).a;
                                        xq4.b("CameraX", str, e);
                                        tpVar.b(new v01(new su(str)));
                                    } else if (e instanceof v01) {
                                        tpVar.b(e);
                                    } else {
                                        tpVar.b(new v01(e));
                                    }
                                }
                            } else {
                                synchronized (ovVar.b) {
                                    ovVar.k = 3;
                                    if (p72VarA.c) {
                                        synchronized (ovVar.b) {
                                            ovVar.k = 4;
                                            tpVar.a(null);
                                        }
                                    } else if (e instanceof xu) {
                                        String str2 = "Device reporting less cameras than anticipated. On real devices: Retrying initialization might resolve temporary camera errors. On emulators: Ensure virtual camera configuration matches supported camera features as reported by PackageManager#hasSystemFeature. Available cameras: " + ((xu) e).a;
                                        xq4.b("CameraX", str2, e);
                                        tpVar.b(new v01(new su(str2)));
                                    } else if (e instanceof v01) {
                                        tpVar.b(e);
                                    } else {
                                        tpVar.b(new v01(e));
                                    }
                                }
                            }
                        } catch (v01 e2) {
                            e = e2;
                            guVar = new gu(j, e);
                            p72VarA = ovVar.i.a(guVar);
                            if (hd4.a()) {
                                hd4.b(guVar.a, "CX:CameraProvider-RetryStatus");
                            }
                            if (p72VarA.b) {
                                synchronized (ovVar.b) {
                                    ovVar.k = 3;
                                    if (p72VarA.c) {
                                        synchronized (ovVar.b) {
                                            ovVar.k = 4;
                                            tpVar.a(null);
                                        }
                                    } else if (e instanceof xu) {
                                        String str3 = "Device reporting less cameras than anticipated. On real devices: Retrying initialization might resolve temporary camera errors. On emulators: Ensure virtual camera configuration matches supported camera features as reported by PackageManager#hasSystemFeature. Available cameras: " + ((xu) e).a;
                                        xq4.b("CameraX", str3, e);
                                        tpVar.b(new v01(new su(str3)));
                                    } else if (e instanceof v01) {
                                        tpVar.b(e);
                                    } else {
                                        tpVar.b(new v01(e));
                                    }
                                }
                            } else {
                                synchronized (ovVar.b) {
                                    ovVar.k = 3;
                                    if (p72VarA.c) {
                                        synchronized (ovVar.b) {
                                            ovVar.k = 4;
                                            tpVar.a(null);
                                        }
                                    } else if (e instanceof xu) {
                                        String str4 = "Device reporting less cameras than anticipated. On real devices: Retrying initialization might resolve temporary camera errors. On emulators: Ensure virtual camera configuration matches supported camera features as reported by PackageManager#hasSystemFeature. Available cameras: " + ((xu) e).a;
                                        xq4.b("CameraX", str4, e);
                                        tpVar.b(new v01(new su(str4)));
                                    } else if (e instanceof v01) {
                                        tpVar.b(e);
                                    } else {
                                        tpVar.b(new v01(e));
                                    }
                                }
                            }
                        } catch (xu e3) {
                            e = e3;
                            guVar = new gu(j, e);
                            p72VarA = ovVar.i.a(guVar);
                            if (hd4.a()) {
                                hd4.b(guVar.a, "CX:CameraProvider-RetryStatus");
                            }
                            if (p72VarA.b) {
                                synchronized (ovVar.b) {
                                    ovVar.k = 3;
                                    if (p72VarA.c) {
                                        synchronized (ovVar.b) {
                                            ovVar.k = 4;
                                            tpVar.a(null);
                                        }
                                    } else if (e instanceof xu) {
                                        String str5 = "Device reporting less cameras than anticipated. On real devices: Retrying initialization might resolve temporary camera errors. On emulators: Ensure virtual camera configuration matches supported camera features as reported by PackageManager#hasSystemFeature. Available cameras: " + ((xu) e).a;
                                        xq4.b("CameraX", str5, e);
                                        tpVar.b(new v01(new su(str5)));
                                    } else if (e instanceof v01) {
                                        tpVar.b(e);
                                    } else {
                                        tpVar.b(new v01(e));
                                    }
                                }
                            } else {
                                synchronized (ovVar.b) {
                                    ovVar.k = 3;
                                    if (p72VarA.c) {
                                        synchronized (ovVar.b) {
                                            ovVar.k = 4;
                                            tpVar.a(null);
                                        }
                                    } else if (e instanceof xu) {
                                        String str6 = "Device reporting less cameras than anticipated. On real devices: Retrying initialization might resolve temporary camera errors. On emulators: Ensure virtual camera configuration matches supported camera features as reported by PackageManager#hasSystemFeature. Available cameras: " + ((xu) e).a;
                                        xq4.b("CameraX", str6, e);
                                        tpVar.b(new v01(new su(str6)));
                                    } else if (e instanceof v01) {
                                        tpVar.b(e);
                                    } else {
                                        tpVar.b(new v01(e));
                                    }
                                }
                            }
                        }
                    } catch (Throwable th) {
                        Trace.endSection();
                        throw th;
                    }
                } catch (RuntimeException e4) {
                    e = e4;
                } catch (v01 e5) {
                    e = e5;
                } catch (xu e6) {
                    e = e6;
                }
                guVar = new gu(j, e);
                p72VarA = ovVar.i.a(guVar);
                if (hd4.a()) {
                    hd4.b(guVar.a, "CX:CameraProvider-RetryStatus");
                }
                if (p72VarA.b || i >= Integer.MAX_VALUE) {
                    synchronized (ovVar.b) {
                        ovVar.k = 3;
                        break;
                    }
                    if (p72VarA.c) {
                        synchronized (ovVar.b) {
                            ovVar.k = 4;
                            break;
                        }
                        tpVar.a(null);
                    } else if (e instanceof xu) {
                        String str7 = "Device reporting less cameras than anticipated. On real devices: Retrying initialization might resolve temporary camera errors. On emulators: Ensure virtual camera configuration matches supported camera features as reported by PackageManager#hasSystemFeature. Available cameras: " + ((xu) e).a;
                        xq4.b("CameraX", str7, e);
                        tpVar.b(new v01(new su(str7)));
                    } else if (e instanceof v01) {
                        tpVar.b(e);
                    } else {
                        tpVar.b(new v01(e));
                    }
                } else {
                    xq4.e("CameraX", "Retry init. Start time " + j + " current time " + SystemClock.elapsedRealtime(), e);
                    Handler handler = ovVar.e;
                    nv nvVar = new nv(ovVar, executor, j, i, contextA, tpVar);
                    long j2 = p72VarA.a;
                    if (Build.VERSION.SDK_INT >= 28) {
                        p50.m(handler, nvVar, j2);
                    } else {
                        Message messageObtain = Message.obtain(handler, nvVar);
                        messageObtain.obj = "retry_token";
                        handler.sendMessageDelayed(messageObtain, j2);
                    }
                }
                Trace.endSection();
                return;
            default:
                ov ovVar2 = this.b;
                Executor executor2 = this.c;
                executor2.execute(new nv(ovVar2, this.i, executor2, this.f + 1, this.j, this.e));
                return;
        }
    }

    public /* synthetic */ nv(ov ovVar, Executor executor, long j, int i, Context context, tp tpVar) {
        this.b = ovVar;
        this.c = executor;
        this.e = j;
        this.f = i;
        this.i = context;
        this.j = tpVar;
    }
}
