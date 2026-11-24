package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSessionManager;
import android.media.session.PlaybackState;
import com.project.sonic.SonicNotificationService;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ii1 {
    public final Context a;
    public final zv1 b;
    public final ue c;

    public ii1(Context context, zv1 zv1Var, ue ueVar) {
        zv1Var.getClass();
        ueVar.getClass();
        this.a = context;
        this.b = zv1Var;
        this.c = ueVar;
    }

    public static boolean d(MediaController mediaController) {
        PlaybackState playbackState = mediaController.getPlaybackState();
        return playbackState != null && playbackState.getState() == 3;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0053  */
    /* JADX WARN: Code duplicated, block: B:19:0x0065 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x0066  */
    /* JADX WARN: Code duplicated, block: B:23:0x007d  */
    /* JADX WARN: Code duplicated, block: B:25:0x0080 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:35:0x0097 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:37:0x009a  */
    /* JADX WARN: Code duplicated, block: B:39:0x009d  */
    /* JADX WARN: Code duplicated, block: B:41:0x00a5 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:49:0x00bf A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:50:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:51:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:55:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0066 -> B:21:0x006b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object a(defpackage.th1 r19, android.media.session.MediaController r20, defpackage.ro1 r21, defpackage.y50 r22) {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ii1.a(th1, android.media.session.MediaController, ro1, y50):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:16:0x002c  */
    public final List b() {
        ComponentName componentName;
        boolean zA = this.b.a();
        ii0 ii0Var = ii0.a;
        if (zA) {
            Context context = this.a;
            MediaSessionManager mediaSessionManager = (MediaSessionManager) context.getSystemService(MediaSessionManager.class);
            if (mediaSessionManager != null) {
                try {
                    try {
                        String packageName = context.getPackageName();
                        if (packageName == null) {
                            packageName = "com.project.sonic";
                        } else {
                            if (cs2.A(packageName)) {
                                packageName = null;
                            }
                            if (packageName == null) {
                                packageName = "com.project.sonic";
                            }
                        }
                        componentName = new ComponentName(packageName, SonicNotificationService.class.getName());
                    } catch (Exception unused) {
                        componentName = new ComponentName("com.project.sonic", SonicNotificationService.class.getName());
                    }
                    List<MediaController> activeSessions = mediaSessionManager.getActiveSessions(componentName);
                    activeSessions.getClass();
                    return mz.K(activeSessions, new lo0(this));
                } catch (Exception unused2) {
                    return ii0Var;
                }
            }
        }
        return ii0Var;
    }

    public final Object c(th1 th1Var, MediaController mediaController, ai1 ai1Var) {
        ro1 ro1VarF = f(mediaController);
        try {
            int iOrdinal = th1Var.ordinal();
            if (iOrdinal == 0) {
                mediaController.getTransportControls().play();
            } else if (iOrdinal == 1) {
                mediaController.getTransportControls().pause();
            } else if (iOrdinal == 2) {
                mediaController.getTransportControls().stop();
            } else if (iOrdinal == 3) {
                mediaController.getTransportControls().skipToNext();
            } else {
                if (iOrdinal != 4) {
                    throw new b10();
                }
                mediaController.getTransportControls().skipToPrevious();
            }
            return a(th1Var, mediaController, ro1VarF, ai1Var);
        } catch (IllegalStateException unused) {
            return yh1.a;
        } catch (SecurityException e) {
            String message = e.getMessage();
            if (message == null) {
                message = "the player refused the command";
            }
            return new xh1(message);
        }
    }

    public final ro1 e(String str) {
        Object next;
        Iterator it = b().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!g31.a(((MediaController) next).getPackageName(), str));
        MediaController mediaController = (MediaController) next;
        if (mediaController != null) {
            return f(mediaController);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00be  */
    /* JADX WARN: Code duplicated, block: B:7:0x001e  */
    public final ro1 f(MediaController mediaController) {
        Long l;
        Object next;
        String string;
        Long l2;
        String string2;
        String string3;
        MediaMetadata metadata = mediaController.getMetadata();
        PlaybackState playbackState = mediaController.getPlaybackState();
        if (metadata != null) {
            long j = metadata.getLong("android.media.metadata.DURATION");
            Long lValueOf = Long.valueOf(j);
            if (j > 0) {
                l = lValueOf;
            } else {
                l = null;
            }
        } else {
            l = null;
        }
        String packageName = mediaController.getPackageName();
        packageName.getClass();
        String packageName2 = mediaController.getPackageName();
        packageName2.getClass();
        ue ueVar = this.c;
        ueVar.getClass();
        Iterator it = ueVar.b().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((x11) next).a.equals(packageName2));
        x11 x11Var = (x11) next;
        String str = x11Var != null ? x11Var.b : null;
        String str2 = (metadata == null || (string3 = metadata.getString("android.media.metadata.TITLE")) == null || cs2.A(string3)) ? null : string3;
        if (metadata == null || (string = metadata.getString("android.media.metadata.ARTIST")) == null) {
            string = metadata != null ? metadata.getString("android.media.metadata.ALBUM_ARTIST") : null;
        }
        String str3 = (string == null || cs2.A(string)) ? null : string;
        String str4 = (metadata == null || (string2 = metadata.getString("android.media.metadata.ALBUM")) == null || cs2.A(string2)) ? null : string2;
        boolean z = false;
        if (playbackState != null && playbackState.getState() == 3) {
            z = true;
        }
        boolean z2 = z;
        if (playbackState != null) {
            long position = playbackState.getPosition();
            Long lValueOf2 = Long.valueOf(position);
            if (position >= 0) {
                l2 = lValueOf2;
            } else {
                l2 = null;
            }
        } else {
            l2 = null;
        }
        return new ro1(packageName, str, str2, str3, str4, z2, l2, l);
    }

    public final MediaController g(String str) {
        Object next;
        List listB = b();
        Object obj = null;
        if (listB.isEmpty()) {
            return null;
        }
        if (str != null) {
            Iterator it = listB.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!g31.a(((MediaController) next).getPackageName(), str));
            MediaController mediaController = (MediaController) next;
            if (mediaController != null) {
                return mediaController;
            }
        }
        for (Object obj2 : listB) {
            if (d((MediaController) obj2)) {
                obj = obj2;
                break;
            }
        }
        MediaController mediaController2 = (MediaController) obj;
        return mediaController2 == null ? (MediaController) mz.x(listB) : mediaController2;
    }
}
