package defpackage;

import android.app.Notification;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.LocaleList;
import android.os.Looper;
import android.os.PersistableBundle;
import android.os.Trace;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.Selection;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.graphics.drawable.IconCompat;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.project.sonic.R;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.Adler32;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kf implements pi0, wu2, up, ir0, j92 {
    public static volatile kf f;
    public static final Object i = new Object();
    public static final r41 j = new r41(4);
    public final /* synthetic */ int a;
    public Object b;
    public Object c;
    public Object e;

    /* JADX WARN: Code duplicated, block: B:82:0x01df  */
    /* JADX WARN: Code duplicated, block: B:85:0x01e8  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v2, types: [java.lang.Class[], java.lang.Object[], java.lang.Throwable] */
    public kf(po1 po1Var) {
        int i2;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        int i3;
        char c;
        Icon iconCreateWithBitmap;
        String strF;
        ColorStateList colorStateList;
        PorterDuff.Mode mode;
        int i4;
        this.a = 20;
        new ArrayList();
        this.e = new Bundle();
        this.c = po1Var;
        Context context = po1Var.a;
        ArrayList arrayList4 = po1Var.p;
        ArrayList arrayList5 = po1Var.c;
        ArrayList arrayList6 = po1Var.d;
        Notification.Builder builder = new Notification.Builder(context, po1Var.m);
        this.b = builder;
        Notification notification = po1Var.o;
        Object obj = null;
        int i5 = 0;
        builder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(po1Var.e).setContentText(po1Var.f).setContentInfo(null).setContentIntent(po1Var.g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(null, (notification.flags & 128) != 0).setNumber(0).setProgress(0, 0, false);
        builder.setLargeIcon((Icon) null);
        builder.setSubText(null).setUsesChronometer(false).setPriority(po1Var.h);
        ArrayList arrayList7 = po1Var.b;
        int size = arrayList7.size();
        int i6 = 0;
        while (i6 < size) {
            int i7 = i6 + 1;
            oo1 oo1Var = (oo1) arrayList7.get(i6);
            if (oo1Var.b == null && (i4 = oo1Var.e) != 0) {
                oo1Var.b = IconCompat.a(i4);
            }
            IconCompat iconCompat = oo1Var.b;
            int i8 = i5;
            boolean z = oo1Var.c;
            Bundle bundle = oo1Var.a;
            if (iconCompat != null) {
                var r18 = obj;
                int i9 = iconCompat.a;
                switch (i9) {
                    case -1:
                        arrayList2 = arrayList5;
                        arrayList3 = arrayList7;
                        i3 = size;
                        c = 2;
                        iconCreateWithBitmap = (Icon) iconCompat.b;
                        break;
                    case 0:
                    default:
                        og.i("Unknown type");
                        throw r18;
                    case 1:
                        arrayList2 = arrayList5;
                        arrayList3 = arrayList7;
                        i3 = size;
                        c = 2;
                        iconCreateWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.b);
                        colorStateList = iconCompat.g;
                        if (colorStateList != null) {
                            iconCreateWithBitmap.setTintList(colorStateList);
                        }
                        mode = iconCompat.h;
                        if (mode != IconCompat.k) {
                            iconCreateWithBitmap.setTintMode(mode);
                        }
                        break;
                    case 2:
                        if (i9 == -1) {
                            Object obj2 = iconCompat.b;
                            arrayList2 = arrayList5;
                            arrayList3 = arrayList7;
                            if (Build.VERSION.SDK_INT >= 28) {
                                strF = p50.f(obj2);
                                i3 = size;
                            } else {
                                try {
                                    i3 = size;
                                    try {
                                        strF = (String) obj2.getClass().getMethod("getResPackage", r18).invoke(obj2, r18);
                                    } catch (IllegalAccessException e) {
                                        e = e;
                                        Log.e("IconCompat", "Unable to get icon package", e);
                                        strF = null;
                                    } catch (NoSuchMethodException e2) {
                                        e = e2;
                                        Log.e("IconCompat", "Unable to get icon package", e);
                                        strF = null;
                                    } catch (InvocationTargetException e3) {
                                        e = e3;
                                        Log.e("IconCompat", "Unable to get icon package", e);
                                        strF = null;
                                    }
                                } catch (IllegalAccessException e4) {
                                    e = e4;
                                    i3 = size;
                                } catch (NoSuchMethodException e5) {
                                    e = e5;
                                    i3 = size;
                                } catch (InvocationTargetException e6) {
                                    e = e6;
                                    i3 = size;
                                }
                            }
                            c = 2;
                        } else {
                            arrayList2 = arrayList5;
                            arrayList3 = arrayList7;
                            i3 = size;
                            c = 2;
                            if (i9 != 2) {
                                dk0.q(iconCompat, "called getResPackage() on ");
                                throw null;
                            }
                            String str = iconCompat.j;
                            strF = (str == null || TextUtils.isEmpty(str)) ? ((String) iconCompat.b).split(":", -1)[i8] : iconCompat.j;
                        }
                        iconCreateWithBitmap = Icon.createWithResource(strF, iconCompat.e);
                        colorStateList = iconCompat.g;
                        if (colorStateList != null) {
                            iconCreateWithBitmap.setTintList(colorStateList);
                        }
                        mode = iconCompat.h;
                        if (mode != IconCompat.k) {
                            iconCreateWithBitmap.setTintMode(mode);
                        }
                        break;
                    case 3:
                        iconCreateWithBitmap = Icon.createWithData((byte[]) iconCompat.b, iconCompat.e, iconCompat.f);
                        arrayList2 = arrayList5;
                        arrayList3 = arrayList7;
                        i3 = size;
                        c = 2;
                        colorStateList = iconCompat.g;
                        if (colorStateList != null) {
                            iconCreateWithBitmap.setTintList(colorStateList);
                        }
                        mode = iconCompat.h;
                        if (mode != IconCompat.k) {
                            iconCreateWithBitmap.setTintMode(mode);
                        }
                        break;
                    case 4:
                        iconCreateWithBitmap = Icon.createWithContentUri((String) iconCompat.b);
                        arrayList2 = arrayList5;
                        arrayList3 = arrayList7;
                        i3 = size;
                        c = 2;
                        colorStateList = iconCompat.g;
                        if (colorStateList != null) {
                            iconCreateWithBitmap.setTintList(colorStateList);
                        }
                        mode = iconCompat.h;
                        if (mode != IconCompat.k) {
                            iconCreateWithBitmap.setTintMode(mode);
                        }
                        break;
                    case 5:
                        iconCreateWithBitmap = Icon.createWithAdaptiveBitmap((Bitmap) iconCompat.b);
                        arrayList2 = arrayList5;
                        arrayList3 = arrayList7;
                        i3 = size;
                        c = 2;
                        colorStateList = iconCompat.g;
                        if (colorStateList != null) {
                            iconCreateWithBitmap.setTintList(colorStateList);
                        }
                        mode = iconCompat.h;
                        if (mode != IconCompat.k) {
                            iconCreateWithBitmap.setTintMode(mode);
                        }
                        break;
                    case 6:
                        if (Build.VERSION.SDK_INT < 30) {
                            throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + iconCompat.c());
                        }
                        iconCreateWithBitmap = e3.b(iconCompat.c());
                        arrayList2 = arrayList5;
                        arrayList3 = arrayList7;
                        i3 = size;
                        c = 2;
                        colorStateList = iconCompat.g;
                        if (colorStateList != null) {
                            iconCreateWithBitmap.setTintList(colorStateList);
                        }
                        mode = iconCompat.h;
                        if (mode != IconCompat.k) {
                            iconCreateWithBitmap.setTintMode(mode);
                        }
                        break;
                        break;
                }
            } else {
                arrayList2 = arrayList5;
                arrayList3 = arrayList7;
                i3 = size;
                c = 2;
                iconCreateWithBitmap = null;
            }
            Notification.Action.Builder builder2 = new Notification.Action.Builder(iconCreateWithBitmap, oo1Var.f, oo1Var.g);
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            bundle2.putBoolean("android.support.allowGeneratedReplies", z);
            builder2.setAllowGeneratedReplies(z);
            bundle2.putInt("android.support.action.semanticAction", i8);
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 28) {
                p50.o(builder2);
            }
            if (i10 >= 29) {
                f50.l(builder2);
            }
            if (i10 >= 31) {
                le.e(builder2);
            }
            bundle2.putBoolean("android.support.action.showsUserInterface", oo1Var.d);
            builder2.addExtras(bundle2);
            ((Notification.Builder) this.b).addAction(builder2.build());
            i6 = i7;
            arrayList5 = arrayList2;
            arrayList7 = arrayList3;
            size = i3;
            obj = null;
            i5 = 0;
        }
        ArrayList arrayList8 = arrayList5;
        Bundle bundle3 = po1Var.l;
        if (bundle3 != null) {
            ((Bundle) this.e).putAll(bundle3);
        }
        ((Notification.Builder) this.b).setShowWhen(po1Var.i);
        ((Notification.Builder) this.b).setLocalOnly(po1Var.k);
        ((Notification.Builder) this.b).setGroup(null);
        ((Notification.Builder) this.b).setSortKey(null);
        ((Notification.Builder) this.b).setGroupSummary(false);
        ((Notification.Builder) this.b).setCategory(null);
        ((Notification.Builder) this.b).setColor(0);
        ((Notification.Builder) this.b).setVisibility(0);
        ((Notification.Builder) this.b).setPublicVersion(null);
        ((Notification.Builder) this.b).setSound(notification.sound, notification.audioAttributes);
        if (Build.VERSION.SDK_INT < 28) {
            if (arrayList8 == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(arrayList8.size());
                Iterator it = arrayList8.iterator();
                if (it.hasNext()) {
                    it.next().getClass();
                    dk0.t();
                    throw null;
                }
            }
            if (arrayList != null) {
                if (arrayList4 == null) {
                    arrayList4 = arrayList;
                } else {
                    pg pgVar = new pg(arrayList4.size() + arrayList.size());
                    pgVar.addAll(arrayList);
                    pgVar.addAll(arrayList4);
                    arrayList4 = new ArrayList(pgVar);
                }
            }
        }
        if (arrayList4 != null && !arrayList4.isEmpty()) {
            int size2 = arrayList4.size();
            int i11 = 0;
            while (i11 < size2) {
                Object obj3 = arrayList4.get(i11);
                i11++;
                ((Notification.Builder) this.b).addPerson((String) obj3);
            }
        }
        if (arrayList6.size() > 0) {
            if (po1Var.l == null) {
                po1Var.l = new Bundle();
            }
            Bundle bundle4 = po1Var.l.getBundle("android.car.EXTENSIONS");
            bundle4 = bundle4 == null ? new Bundle() : bundle4;
            Bundle bundle5 = new Bundle(bundle4);
            Bundle bundle6 = new Bundle();
            for (int i12 = 0; i12 < arrayList6.size(); i12++) {
                String string = Integer.toString(i12);
                oo1 oo1Var2 = (oo1) arrayList6.get(i12);
                Bundle bundle7 = new Bundle();
                if (oo1Var2.b == null && (i2 = oo1Var2.e) != 0) {
                    oo1Var2.b = IconCompat.a(i2);
                }
                IconCompat iconCompat2 = oo1Var2.b;
                Bundle bundle8 = oo1Var2.a;
                bundle7.putInt("icon", iconCompat2 != null ? iconCompat2.b() : 0);
                bundle7.putCharSequence("title", oo1Var2.f);
                bundle7.putParcelable("actionIntent", oo1Var2.g);
                Bundle bundle9 = bundle8 != null ? new Bundle(bundle8) : new Bundle();
                bundle9.putBoolean("android.support.allowGeneratedReplies", oo1Var2.c);
                bundle7.putBundle("extras", bundle9);
                bundle7.putParcelableArray("remoteInputs", null);
                bundle7.putBoolean("showsUserInterface", oo1Var2.d);
                bundle7.putInt("semanticAction", 0);
                bundle6.putBundle(string, bundle7);
            }
            bundle4.putBundle("invisible_actions", bundle6);
            bundle5.putBundle("invisible_actions", bundle6);
            if (po1Var.l == null) {
                po1Var.l = new Bundle();
            }
            po1Var.l.putBundle("android.car.EXTENSIONS", bundle4);
            ((Bundle) this.e).putBundle("android.car.EXTENSIONS", bundle5);
        }
        ((Notification.Builder) this.b).setExtras(po1Var.l);
        ((Notification.Builder) this.b).setRemoteInputHistory(null);
        ((Notification.Builder) this.b).setBadgeIconType(0);
        ((Notification.Builder) this.b).setSettingsText(null);
        ((Notification.Builder) this.b).setShortcutId(null);
        ((Notification.Builder) this.b).setTimeoutAfter(0L);
        ((Notification.Builder) this.b).setGroupAlertBehavior(0);
        if (!TextUtils.isEmpty(po1Var.m)) {
            ((Notification.Builder) this.b).setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
        }
        int i13 = Build.VERSION.SDK_INT;
        if (i13 >= 28) {
            Iterator it2 = arrayList8.iterator();
            if (it2.hasNext()) {
                it2.next().getClass();
                dk0.t();
                throw null;
            }
        }
        if (i13 >= 29) {
            f50.j((Notification.Builder) this.b, po1Var.n);
            f50.k((Notification.Builder) this.b);
        }
        if (i13 >= 36) {
            g3.f((Notification.Builder) this.b);
        }
    }

    public static void H(List list, Size size) {
        ArrayList arrayList = new ArrayList();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            Size size3 = (Size) list.get(size2);
            if (size3.getWidth() >= size.getWidth() && size3.getHeight() >= size.getHeight()) {
                break;
            }
            arrayList.add(0, size3);
        }
        list.removeAll(arrayList);
        Collections.reverse(list);
        list.addAll(arrayList);
    }

    public static boolean h(Editable editable, KeyEvent keyEvent, boolean z) {
        r33[] r33VarArr;
        if (KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd && (r33VarArr = (r33[]) editable.getSpans(selectionStart, selectionEnd, r33.class)) != null && r33VarArr.length > 0) {
                for (r33 r33Var : r33VarArr) {
                    int spanStart = editable.getSpanStart(r33Var);
                    int spanEnd = editable.getSpanEnd(r33Var);
                    if ((z && spanStart == selectionStart) || ((!z && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                        editable.delete(spanStart, spanEnd);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static kf o(Context context) {
        if (f == null) {
            synchronized (i) {
                try {
                    if (f == null) {
                        f = new kf(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f;
    }

    public static ArrayList q(ArrayList arrayList) {
        Object obj;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(ug.a);
        arrayList2.add(ug.c);
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj2 = arrayList.get(i2);
            i2++;
            Size size2 = (Size) obj2;
            Rational rational = new Rational(size2.getWidth(), size2.getHeight());
            if (!arrayList2.contains(rational)) {
                int size3 = arrayList2.size();
                int i3 = 0;
                do {
                    if (i3 >= size3) {
                        arrayList2.add(rational);
                        break;
                    }
                    obj = arrayList2.get(i3);
                    i3++;
                } while (!ug.a((Rational) obj, size2));
            }
        }
        return arrayList2;
    }

    public static Rational t(int i2, boolean z) {
        if (i2 == -1) {
            return null;
        }
        if (i2 == 0) {
            return z ? ug.a : ug.b;
        }
        if (i2 == 1) {
            return z ? ug.c : ug.d;
        }
        xq4.a("SupportedOutputSizesCollector", "Undefined target aspect ratio: " + i2);
        return null;
    }

    public static HashMap u(ArrayList arrayList) {
        HashMap map = new HashMap();
        ArrayList arrayListQ = q(arrayList);
        int size = arrayListQ.size();
        int i2 = 0;
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayListQ.get(i3);
            i3++;
            map.put((Rational) obj, new ArrayList());
        }
        int size2 = arrayList.size();
        while (i2 < size2) {
            Object obj2 = arrayList.get(i2);
            i2++;
            Size size3 = (Size) obj2;
            for (Rational rational : map.keySet()) {
                if (ug.a(rational, size3)) {
                    ((List) map.get(rational)).add(size3);
                }
            }
        }
        return map;
    }

    public boolean A(int i2) {
        zm2 zm2Var;
        if (i2 == 7 || i2 == 2 || i2 == 6 || i2 == 5 || i2 == 3 || i2 == 4) {
            p();
        } else if (i2 != 1 && i2 != 0) {
            og.n("invalid ImeAction");
            return false;
        }
        if (i2 == 6) {
            ao0 ao0Var = (ao0) this.e;
            if (ao0Var != null) {
                ((do0) ao0Var).g(1, true);
                return true;
            }
            g31.f("focusManager");
            throw null;
        }
        if (i2 != 5) {
            if (i2 != 7 || (zm2Var = (zm2) this.b) == null) {
                return false;
            }
            ((ac0) zm2Var).a();
            return true;
        }
        ao0 ao0Var2 = (ao0) this.e;
        if (ao0Var2 != null) {
            ((do0) ao0Var2).g(2, true);
            return true;
        }
        g31.f("focusManager");
        throw null;
    }

    public void B(pj pjVar, int i2, boolean z) {
        aj ajVar = (aj) this.c;
        Context context = (Context) this.e;
        ComponentName componentName = new ComponentName(context, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        Adler32 adler32 = new Adler32();
        adler32.update(context.getPackageName().getBytes(Charset.forName("UTF-8")));
        String str = pjVar.a;
        adler32.update(str.getBytes(Charset.forName("UTF-8")));
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        v02 v02Var = pjVar.c;
        adler32.update(byteBufferAllocate.putInt(w02.a(v02Var)).array());
        byte[] bArr = pjVar.b;
        if (bArr != null) {
            adler32.update(bArr);
        }
        int value = (int) adler32.getValue();
        if (!z) {
            for (JobInfo jobInfo : jobScheduler.getAllPendingJobs()) {
                int i3 = jobInfo.getExtras().getInt("attemptNumber");
                if (jobInfo.getId() == value) {
                    if (i3 < i2) {
                        break;
                    }
                    yq4.a("JobInfoScheduler");
                    new StringBuilder("Upload for context ").append(pjVar);
                    return;
                }
            }
        }
        Cursor cursorRawQuery = ((l92) this.b).c().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{str, String.valueOf(w02.a(v02Var))});
        try {
            Long lValueOf = cursorRawQuery.moveToNext() ? Long.valueOf(cursorRawQuery.getLong(0)) : 0L;
            cursorRawQuery.close();
            long jLongValue = lValueOf.longValue();
            JobInfo.Builder builder = new JobInfo.Builder(value, componentName);
            builder.setMinimumLatency(ajVar.a(v02Var, jLongValue, i2));
            Set set = ((bj) ajVar.b.get(v02Var)).c;
            if (set.contains(bb2.a)) {
                builder.setRequiredNetworkType(2);
            } else {
                builder.setRequiredNetworkType(1);
            }
            if (set.contains(bb2.c)) {
                builder.setRequiresCharging(true);
            }
            if (set.contains(bb2.b)) {
                builder.setRequiresDeviceIdle(true);
            }
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putInt("attemptNumber", i2);
            persistableBundle.putString("backendName", str);
            persistableBundle.putInt("priority", w02.a(v02Var));
            if (bArr != null) {
                persistableBundle.putString("extras", Base64.encodeToString(bArr, 0));
            }
            builder.setExtras(persistableBundle);
            Object[] objArr = {pjVar, Integer.valueOf(value), Long.valueOf(ajVar.a(v02Var, jLongValue, i2)), lValueOf, Integer.valueOf(i2)};
            yq4.a("JobInfoScheduler");
            String.format("Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", objArr);
            jobScheduler.schedule(builder.build());
        } catch (Throwable th) {
            cursorRawQuery.close();
            throw th;
        }
    }

    public void C(Object obj) {
        long jA = tc4.a();
        if (jA == m03.a) {
            this.e = obj;
            return;
        }
        synchronized (this.c) {
            j03 j03Var = (j03) ((AtomicReference) this.b).get();
            int iA = j03Var.a(jA);
            if (iA < 0) {
                ((AtomicReference) this.b).set(j03Var.b(jA, obj));
            } else {
                j03Var.c[iA] = obj;
            }
        }
    }

    public void D(cw cwVar) {
        ((ew) this.e).a.c = cwVar;
    }

    public void E(jc0 jc0Var) {
        ((ew) this.e).a.a = jc0Var;
    }

    public void F(z61 z61Var) {
        ((ew) this.e).a.b = z61Var;
    }

    public void G(long j2) {
        ((ew) this.e).a.d = j2;
    }

    public void I() {
        gm1 gm1Var = (gm1) this.b;
        String str = (String) this.c;
        List list = (List) gm1Var.k(str);
        if (list != null) {
            list.remove((fq0) this.e);
        }
        if (list == null || list.isEmpty()) {
            return;
        }
        gm1Var.m(str, list);
    }

    public int J(int i2, byte[] bArr, int i3) {
        Object h72Var;
        AudioFocusRequest audioFocusRequest;
        final bd1 bd1Var = ((mt0) this.c).j;
        final zc1 zc1Var = (zc1) this.e;
        bd1Var.getClass();
        synchronized (bd1Var) {
            if (!bd1Var.a(zc1Var)) {
                return 0;
            }
            if (bd1Var.c == null) {
                final t42 t42Var = new t42();
                AudioFocusRequest.Builder builder = new AudioFocusRequest.Builder(2);
                AudioAttributes audioAttributesBuild = new AudioAttributes.Builder().setUsage(16).setContentType(1).build();
                audioAttributesBuild.getClass();
                AudioFocusRequest audioFocusRequestBuild = builder.setAudioAttributes(audioAttributesBuild).setWillPauseWhenDucked(true).setOnAudioFocusChangeListener(new AudioManager.OnAudioFocusChangeListener() { // from class: yc1
                    @Override // android.media.AudioManager.OnAudioFocusChangeListener
                    public final void onAudioFocusChange(int i4) {
                        bd1 bd1Var2 = bd1Var;
                        zc1 zc1Var2 = zc1Var;
                        t42 t42Var2 = t42Var;
                        if (i4 == 1 || i4 == 2 || i4 == 3) {
                            Object obj = t42Var2.a;
                            if (obj == null) {
                                g31.f("request");
                                throw null;
                            }
                            AudioFocusRequest audioFocusRequest2 = (AudioFocusRequest) obj;
                            synchronized (bd1Var2) {
                                if (bd1Var2.b == zc1Var2 && bd1Var2.c == audioFocusRequest2) {
                                    zc1Var2.c.a();
                                    return;
                                }
                                return;
                            }
                        }
                        if (i4 != -2 && i4 != -3) {
                            if (i4 <= -1) {
                                Object obj2 = t42Var2.a;
                                if (obj2 != null) {
                                    bd1Var2.d(zc1Var2, (AudioFocusRequest) obj2);
                                    return;
                                } else {
                                    g31.f("request");
                                    throw null;
                                }
                            }
                            return;
                        }
                        Object obj3 = t42Var2.a;
                        if (obj3 == null) {
                            g31.f("request");
                            throw null;
                        }
                        AudioFocusRequest audioFocusRequest3 = (AudioFocusRequest) obj3;
                        synchronized (bd1Var2) {
                            if (bd1Var2.b == zc1Var2 && bd1Var2.c == audioFocusRequest3) {
                                zc1Var2.b.a();
                            }
                        }
                    }
                }, new Handler(Looper.getMainLooper())).build();
                audioFocusRequestBuild.getClass();
                t42Var.a = audioFocusRequestBuild;
                bd1Var.c = audioFocusRequestBuild;
                Object obj = null;
                try {
                    AudioManager audioManager = bd1Var.a;
                    h72Var = audioManager != null ? Integer.valueOf(audioManager.requestAudioFocus(audioFocusRequestBuild)) : null;
                } catch (Throwable th) {
                    h72Var = new h72(th);
                }
                if (!(h72Var instanceof h72)) {
                    obj = h72Var;
                }
                Integer num = (Integer) obj;
                boolean z = num != null && num.intValue() == 1;
                if (!z) {
                    synchronized (bd1Var) {
                        audioFocusRequest = bd1Var.c;
                    }
                    if (audioFocusRequest == null) {
                        return 0;
                    }
                    bd1Var.d(zc1Var, audioFocusRequest);
                    return 0;
                }
            }
            return ((AudioTrack) this.b).write(bArr, i2, i3, 1);
        }
    }

    @Override // defpackage.pi0
    public /* bridge */ /* synthetic */ pi0 a(Class cls, vo1 vo1Var) {
        ((HashMap) this.b).put(cls, vo1Var);
        ((HashMap) this.c).remove(cls);
        return this;
    }

    @Override // defpackage.j92
    public Object apply(Object obj) {
        l92 l92Var;
        String str;
        int i2;
        long jInsert;
        String str2 = "bytes";
        int i3 = 0;
        int i4 = 1;
        Object obj2 = null;
        switch (this.a) {
            case 23:
                l92 l92Var2 = (l92) this.b;
                ArrayList arrayList = (ArrayList) this.c;
                pj pjVar = (pj) this.e;
                Cursor cursor = (Cursor) obj;
                qi0 qi0Var = l92.f;
                while (cursor.moveToNext()) {
                    long j2 = cursor.getLong(i3);
                    int i5 = cursor.getInt(7) != 0 ? i4 : i3;
                    lj1 lj1Var = new lj1(2);
                    lj1Var.g = new HashMap();
                    String string = cursor.getString(i4);
                    if (string == null) {
                        Object obj3 = obj2;
                        dk0.n("Null transportName");
                        return obj3;
                    }
                    lj1Var.b = string;
                    lj1Var.e = Long.valueOf(cursor.getLong(2));
                    lj1Var.f = Long.valueOf(cursor.getLong(3));
                    if (i5 != 0) {
                        String string2 = cursor.getString(4);
                        lj1Var.d = new ni0(string2 == null ? l92.f : new qi0(string2), cursor.getBlob(5));
                        l92Var = l92Var2;
                        str = str2;
                        i2 = i3;
                    } else {
                        String string3 = cursor.getString(4);
                        qi0 qi0Var2 = string3 == null ? l92.f : new qi0(string3);
                        Cursor cursorQuery = l92Var2.c().query("event_payloads", new String[]{str2}, "event_id = ?", new String[]{String.valueOf(j2)}, null, null, "sequence_num");
                        try {
                            qi0 qi0Var3 = l92.f;
                            ArrayList arrayList2 = new ArrayList();
                            int length = i3;
                            while (cursorQuery.moveToNext()) {
                                byte[] blob = cursorQuery.getBlob(i3);
                                arrayList2.add(blob);
                                length += blob.length;
                            }
                            byte[] bArr = new byte[length];
                            int i6 = i3;
                            int length2 = i6;
                            while (i6 < arrayList2.size()) {
                                byte[] bArr2 = (byte[]) arrayList2.get(i6);
                                l92 l92Var3 = l92Var2;
                                String str3 = str2;
                                System.arraycopy(bArr2, 0, bArr, length2, bArr2.length);
                                length2 += bArr2.length;
                                i6++;
                                l92Var2 = l92Var3;
                                str2 = str3;
                            }
                            l92Var = l92Var2;
                            str = str2;
                            i2 = 0;
                            cursorQuery.close();
                            lj1Var.d = new ni0(qi0Var2, bArr);
                        } catch (Throwable th) {
                            cursorQuery.close();
                            throw th;
                        }
                    }
                    if (!cursor.isNull(6)) {
                        lj1Var.c = Integer.valueOf(cursor.getInt(6));
                    }
                    arrayList.add(new xi(j2, pjVar, lj1Var.c()));
                    i3 = i2;
                    obj2 = obj2;
                    l92Var2 = l92Var;
                    str2 = str;
                    i4 = 1;
                }
                return obj2;
            default:
                l92 l92Var4 = (l92) this.b;
                pj pjVar2 = (pj) this.c;
                hi hiVar = (hi) this.e;
                ni0 ni0Var = hiVar.c;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                qi0 qi0Var4 = l92.f;
                long jSimpleQueryForLong = l92Var4.c().compileStatement("PRAGMA page_size").simpleQueryForLong() * l92Var4.c().compileStatement("PRAGMA page_count").simpleQueryForLong();
                ii iiVar = l92Var4.e;
                if (jSimpleQueryForLong >= iiVar.a) {
                    return -1L;
                }
                Long lE = l92.e(sQLiteDatabase, pjVar2);
                if (lE != null) {
                    jInsert = lE.longValue();
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("backend_name", pjVar2.a);
                    contentValues.put("priority", Integer.valueOf(w02.a(pjVar2.c)));
                    contentValues.put("next_request_ms", (Integer) 0);
                    byte[] bArr3 = pjVar2.b;
                    if (bArr3 != null) {
                        contentValues.put("extras", Base64.encodeToString(bArr3, 0));
                    }
                    jInsert = sQLiteDatabase.insert("transport_contexts", null, contentValues);
                }
                int i7 = iiVar.e;
                byte[] bArr4 = ni0Var.b;
                boolean z = bArr4.length <= i7;
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("context_id", Long.valueOf(jInsert));
                contentValues2.put("transport_name", hiVar.a);
                contentValues2.put("timestamp_ms", Long.valueOf(hiVar.d));
                contentValues2.put("uptime_ms", Long.valueOf(hiVar.e));
                contentValues2.put("payload_encoding", ni0Var.a.a);
                contentValues2.put("code", hiVar.b);
                contentValues2.put("num_attempts", (Integer) 0);
                contentValues2.put("inline", Boolean.valueOf(z));
                contentValues2.put("payload", z ? bArr4 : new byte[0]);
                long jInsert2 = sQLiteDatabase.insert("events", null, contentValues2);
                if (!z) {
                    int iCeil = (int) Math.ceil(((double) bArr4.length) / ((double) i7));
                    while (i4 <= iCeil) {
                        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr4, (i4 - 1) * i7, Math.min(i4 * i7, bArr4.length));
                        ContentValues contentValues3 = new ContentValues();
                        contentValues3.put("event_id", Long.valueOf(jInsert2));
                        contentValues3.put("sequence_num", Integer.valueOf(i4));
                        contentValues3.put("bytes", bArrCopyOfRange);
                        sQLiteDatabase.insert("event_payloads", null, contentValues3);
                        i4++;
                    }
                }
                for (Map.Entry entry : Collections.unmodifiableMap(hiVar.f).entrySet()) {
                    ContentValues contentValues4 = new ContentValues();
                    contentValues4.put("event_id", Long.valueOf(jInsert2));
                    contentValues4.put("name", (String) entry.getKey());
                    contentValues4.put("value", (String) entry.getValue());
                    sQLiteDatabase.insert("event_metadata", null, contentValues4);
                }
                return Long.valueOf(jInsert2);
        }
    }

    @Override // defpackage.wu2
    public Object b() {
        ya0 ya0Var = (ya0) this.b;
        pj pjVar = (pj) this.c;
        hi hiVar = (hi) this.e;
        l92 l92Var = ya0Var.d;
        l92Var.getClass();
        v02 v02Var = pjVar.c;
        yq4.a("SQLiteEventStore");
        new StringBuilder("Storing event with priority=").append(v02Var);
        ((Long) l92Var.j(new kf(l92Var, pjVar, hiVar, 24))).getClass();
        ya0Var.a.B(pjVar, 1, false);
        return null;
    }

    @Override // defpackage.ir0
    public void c(Object obj) {
        switch (this.a) {
            case 22:
                ((k02) this.e).i = null;
                break;
            default:
                oz3.f(true, (wc1) this.b, (tp) this.c, xg4.a());
                break;
        }
    }

    @Override // defpackage.up
    public Object d(tp tpVar) {
        o7 o7Var = new o7(4, this);
        dd0 dd0VarA = xg4.a();
        o62 o62Var = tpVar.c;
        if (o62Var != null) {
            o62Var.a(o7Var, dd0VarA);
        }
        ((wv0) this.e).a.set(tpVar);
        return "HandlerScheduledFuture-" + ((Callable) this.c).toString();
    }

    public void e(n71 n71Var, q31 q31Var) {
        uf1 uf1Var = (uf1) this.b;
        uf1 uf1Var2 = (uf1) this.c;
        uf1 uf1Var3 = (uf1) this.e;
        int iOrdinal = q31Var.ordinal();
        if (iOrdinal == 0) {
            uf1Var.h(n71Var);
            uf1Var3.h(n71Var);
            return;
        }
        if (iOrdinal == 1) {
            uf1Var2.h(n71Var);
            uf1Var3.h(n71Var);
            return;
        }
        if (iOrdinal == 2) {
            if (n71Var.n != null) {
                uf1Var3.h(n71Var);
                return;
            } else {
                uf1Var.h(n71Var);
                return;
            }
        }
        if (iOrdinal != 3) {
            dk0.l();
        } else if (n71Var.n != null) {
            uf1Var3.h(n71Var);
        } else {
            uf1Var2.h(n71Var);
        }
    }

    public boolean f(n71 n71Var) {
        return !(n71Var.n == null) && (((ep2) ((uf1) this.b).b).contains(n71Var) || ((ep2) ((uf1) this.c).b).contains(n71Var));
    }

    public void g(st2 st2Var, Map.Entry entry) {
        st2 st2Var2 = (st2) entry.getValue();
        ij ijVar = null;
        ij ijVar2 = new ij(st2Var.g.a, ((ui) entry.getKey()).d, st2Var.c ? (wt) this.c : null, ((ui) entry.getKey()).f, ((ui) entry.getKey()).g);
        int i2 = ((ui) entry.getKey()).c;
        st2Var2.getClass();
        vc4.b();
        st2Var2.a();
        hh1.e("Consumer can only be linked once.", !st2Var2.j);
        st2Var2.j = true;
        rt2 rt2Var = st2Var2.l;
        xw xwVarG = oz3.g(rt2Var.c(), new qt2(st2Var2, rt2Var, i2, ijVar2, ijVar), xg4.c());
        xwVarG.a(new or0(0, xwVarG, new q91(this, st2Var2)), xg4.c());
    }

    @Override // defpackage.ir0
    public void i(Throwable th) {
        switch (this.a) {
            case 22:
                ((k02) this.e).i = null;
                ArrayList arrayList = (ArrayList) this.b;
                if (!arrayList.isEmpty()) {
                    int size = arrayList.size();
                    int i2 = 0;
                    while (i2 < size) {
                        Object obj = arrayList.get(i2);
                        i2++;
                        ((ut) this.c).k((es) obj);
                    }
                    arrayList.clear();
                }
                break;
            default:
                boolean z = th instanceof CancellationException;
                tp tpVar = (tp) this.c;
                if (!z) {
                    tpVar.a(null);
                } else {
                    hh1.e(null, tpVar.b(new du2(((String) this.e).concat(" cancelled."), th)));
                }
                break;
        }
    }

    public void j(Bundle bundle) {
        HashSet hashSet = (HashSet) this.c;
        String string = ((Context) this.e).getString(R.string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet2 = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (w01.class.isAssignableFrom(cls)) {
                            hashSet.add(cls);
                        }
                    }
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    k((Class) it.next(), hashSet2);
                }
            } catch (ClassNotFoundException e) {
                throw new b10(e);
            }
        }
    }

    public Object k(Class cls, HashSet hashSet) {
        Object objB;
        HashMap map = (HashMap) this.b;
        if (hd4.a()) {
            try {
                Trace.beginSection(hd4.e(cls.getSimpleName()));
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
        if (hashSet.contains(cls)) {
            throw new IllegalStateException("Cannot initialize " + cls.getName() + ". Cycle detected.");
        }
        if (map.containsKey(cls)) {
            objB = map.get(cls);
        } else {
            hashSet.add(cls);
            try {
                w01 w01Var = (w01) cls.getDeclaredConstructor(null).newInstance(null);
                List<Class> listA = w01Var.a();
                if (!listA.isEmpty()) {
                    for (Class cls2 : listA) {
                        if (!map.containsKey(cls2)) {
                            k(cls2, hashSet);
                        }
                    }
                }
                objB = w01Var.b((Context) this.e);
                hashSet.remove(cls);
                map.put(cls, objB);
            } catch (Throwable th2) {
                throw new b10(th2);
            }
        }
        Trace.endSection();
        return objB;
    }

    public Object l() {
        long jA = tc4.a();
        if (jA == m03.a) {
            return this.e;
        }
        j03 j03Var = (j03) ((AtomicReference) this.b).get();
        int iA = j03Var.a(jA);
        if (iA >= 0) {
            return j03Var.c[iA];
        }
        return null;
    }

    public cw m() {
        return ((ew) this.e).a.c;
    }

    public ne1 n() {
        LocaleList localeList = LocaleList.getDefault();
        synchronized (((el1) this.e)) {
            try {
                ne1 ne1Var = (ne1) this.c;
                if (ne1Var != null && localeList == ((LocaleList) this.b)) {
                    return ne1Var;
                }
                int size = localeList.size();
                ArrayList arrayList = new ArrayList(size);
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.add(new me1(localeList.get(i2)));
                }
                ne1 ne1Var2 = new ne1(arrayList);
                this.b = localeList;
                this.c = ne1Var2;
                return ne1Var2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public t51 p() {
        t51 t51Var = (t51) this.c;
        if (t51Var != null) {
            return t51Var;
        }
        g31.f("keyboardActions");
        throw null;
    }

    public long r() {
        return ((ew) this.e).a.d;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00d0  */
    public ArrayList s(r53 r53Var) {
        Size[] sizeArr;
        Rational rational;
        ut utVar = (ut) this.b;
        xy0 xy0Var = (xy0) r53Var;
        List list = (List) xy0Var.d(xy0.J, null);
        ArrayList arrayList = list != null ? new ArrayList(list) : null;
        if (arrayList != null) {
            return arrayList;
        }
        l62 l62Var = (l62) xy0Var.d(xy0.I, null);
        List list2 = (List) xy0Var.d(xy0.G, null);
        int iP = r53Var.p();
        if (list2 == null) {
            sizeArr = null;
            break;
        }
        Iterator it = list2.iterator();
        while (true) {
            if (!it.hasNext()) {
                sizeArr = null;
                break;
            }
            Pair pair = (Pair) it.next();
            if (((Integer) pair.first).intValue() == iP) {
                sizeArr = (Size[]) pair.second;
                break;
            }
        }
        List listAsList = sizeArr == null ? null : Arrays.asList(sizeArr);
        if (listAsList == null) {
            listAsList = utVar.j(iP);
        }
        ArrayList arrayList2 = new ArrayList(listAsList);
        boolean z = true;
        Collections.sort(arrayList2, new v00(true));
        if (arrayList2.isEmpty()) {
            xq4.d("SupportedOutputSizesCollector", "The retrieved supported resolutions from camera info internal is empty. Format is " + iP + ".");
        }
        int i2 = 0;
        if (l62Var != null) {
            Size size = (Size) ((xy0) r53Var).d(xy0.F, null);
            xy0Var.i();
            if (!((Boolean) r53Var.d(r53.V, Boolean.FALSE)).booleanValue()) {
                int iP2 = r53Var.p();
                if (l62Var.c == 1) {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.addAll(arrayList2);
                    arrayList3.addAll(utVar.e(iP2));
                    Collections.sort(arrayList3, new v00(true));
                    arrayList2 = arrayList3;
                }
            }
            l62 l62Var2 = (l62) xy0Var.f(xy0.I);
            Rational rational2 = (Rational) this.c;
            su0 su0Var = l62Var2.a;
            HashMap mapU = u(arrayList2);
            if (rational2 != null && rational2.getNumerator() < rational2.getDenominator()) {
                z = false;
            }
            su0Var.getClass();
            Rational rationalT = t(0, z);
            ArrayList arrayList4 = new ArrayList(mapU.keySet());
            Collections.sort(arrayList4, new tg(rationalT, rational2));
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int size2 = arrayList4.size();
            while (i2 < size2) {
                Object obj = arrayList4.get(i2);
                i2++;
                Rational rational3 = (Rational) obj;
                linkedHashMap.put(rational3, (List) mapU.get(rational3));
            }
            if (size != null) {
                Size size3 = al2.a;
                int height = size.getHeight() * size.getWidth();
                Iterator it2 = linkedHashMap.keySet().iterator();
                while (it2.hasNext()) {
                    List<Size> list3 = (List) linkedHashMap.get((Rational) it2.next());
                    ArrayList arrayList5 = new ArrayList();
                    for (Size size4 : list3) {
                        if (al2.a(size4) <= height) {
                            arrayList5.add(size4);
                        }
                    }
                    list3.clear();
                    list3.addAll(arrayList5);
                }
            }
            el1 el1Var = l62Var2.b;
            if (el1Var != null) {
                Iterator it3 = linkedHashMap.keySet().iterator();
                while (it3.hasNext()) {
                    List list4 = (List) linkedHashMap.get((Rational) it3.next());
                    if (!list4.isEmpty() && el1Var != el1.i) {
                        boolean zContains = list4.contains(null);
                        list4.clear();
                        if (zContains) {
                            list4.add(null);
                        }
                    }
                }
            }
            ArrayList arrayList6 = new ArrayList();
            Iterator it4 = linkedHashMap.values().iterator();
            while (it4.hasNext()) {
                for (Size size5 : (List) it4.next()) {
                    if (!arrayList6.contains(size5)) {
                        arrayList6.add(size5);
                    }
                }
            }
            return arrayList6;
        }
        ht2 ht2Var = (ht2) this.e;
        ht2Var.getClass();
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        ArrayList arrayList7 = new ArrayList(arrayList2);
        Collections.sort(arrayList7, new v00(true));
        ArrayList arrayList8 = new ArrayList();
        xy0 xy0Var2 = (xy0) r53Var;
        Size size6 = (Size) xy0Var2.d(xy0.F, null);
        Size size7 = (Size) arrayList7.get(0);
        if (size6 == null) {
            size6 = size7;
        } else if (al2.a(size7) < size6.getHeight() * size6.getWidth()) {
            size6 = size7;
        }
        Size sizeA = ht2Var.a(xy0Var2);
        Size size8 = al2.b;
        int iA = al2.a(size8);
        if (al2.a(size6) < iA) {
            size8 = al2.a;
        } else if (sizeA != null) {
            if (sizeA.getHeight() * sizeA.getWidth() < iA) {
                size8 = sizeA;
            }
        }
        int size9 = arrayList7.size();
        int i3 = 0;
        while (i3 < size9) {
            Object obj2 = arrayList7.get(i3);
            i3++;
            Size size10 = (Size) obj2;
            if (al2.a(size10) <= size6.getHeight() * size6.getWidth()) {
                if (size10.getHeight() * size10.getWidth() >= al2.a(size8) && !arrayList8.contains(size10)) {
                    arrayList8.add(size10);
                }
            }
        }
        if (arrayList8.isEmpty()) {
            throw new IllegalArgumentException("All supported output sizes are filtered out according to current resolution selection settings. \nminSize = " + size8 + "\nmaxSize = " + size6 + "\ninitial size list: " + arrayList7);
        }
        bi biVar = xy0.z;
        if (xy0Var2.a(biVar)) {
            rational = t(((Integer) xy0Var2.f(biVar)).intValue(), ht2Var.d);
        } else {
            Size sizeA2 = ht2Var.a(xy0Var2);
            if (sizeA2 != null) {
                ArrayList arrayListQ = q(arrayList8);
                int size11 = arrayListQ.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size11) {
                        rational = new Rational(sizeA2.getWidth(), sizeA2.getHeight());
                        break;
                    }
                    Object obj3 = arrayListQ.get(i4);
                    i4++;
                    Rational rational4 = (Rational) obj3;
                    if (ug.a(rational4, sizeA2)) {
                        rational = rational4;
                        break;
                    }
                }
            } else {
                rational = null;
            }
        }
        if (sizeA == null) {
            sizeA = (Size) xy0Var2.d(xy0.E, null);
        }
        ArrayList arrayList9 = new ArrayList();
        new HashMap();
        if (rational == null) {
            arrayList9.addAll(arrayList8);
            if (sizeA != null) {
                H(arrayList9, sizeA);
                return arrayList9;
            }
        } else {
            HashMap mapU2 = u(arrayList8);
            if (sizeA != null) {
                Iterator it5 = mapU2.keySet().iterator();
                while (it5.hasNext()) {
                    H((List) mapU2.get((Rational) it5.next()), sizeA);
                }
            }
            ArrayList arrayList10 = new ArrayList(mapU2.keySet());
            Collections.sort(arrayList10, new tg(rational, ht2Var.c));
            int size12 = arrayList10.size();
            while (i2 < size12) {
                Object obj4 = arrayList10.get(i2);
                i2++;
                for (Size size13 : (List) mapU2.get((Rational) obj4)) {
                    if (!arrayList9.contains(size13)) {
                        arrayList9.add(size13);
                    }
                }
            }
        }
        return arrayList9;
    }

    public String toString() {
        switch (this.a) {
            case 14:
                return "OutputFileOptions{mFile=null, mContentResolver=" + ((ContentResolver) this.b) + ", mSaveCollection=" + MediaStore.Images.Media.EXTERNAL_CONTENT_URI + ", mContentValues=" + ((ContentValues) this.c) + ", mOutputStream=null, mMetadata=" + ((qs4) this.e) + "}";
            default:
                return super.toString();
        }
    }

    public boolean v(CharSequence charSequence, int i2, int i3, q33 q33Var) {
        if ((q33Var.c & 3) == 0) {
            ma0 ma0Var = (ma0) this.e;
            gj1 gj1VarB = q33Var.b();
            int iA = gj1VarB.a(8);
            if (iA != 0) {
                ((ByteBuffer) gj1VarB.e).getShort(iA + gj1VarB.a);
            }
            ma0Var.getClass();
            ThreadLocal threadLocal = ma0.b;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            StringBuilder sb = (StringBuilder) threadLocal.get();
            sb.setLength(0);
            while (i2 < i3) {
                sb.append(charSequence.charAt(i2));
                i2++;
            }
            TextPaint textPaint = ma0Var.a;
            String string = sb.toString();
            int i4 = st1.a;
            boolean zHasGlyph = textPaint.hasGlyph(string);
            int i5 = q33Var.c & 4;
            q33Var.c = zHasGlyph ? i5 | 2 : i5 | 1;
        }
        return (q33Var.c & 3) == 2;
    }

    public boolean w() {
        return !(((ep2) ((uf1) this.b).b).isEmpty() && ((ep2) ((uf1) this.e).b).isEmpty() && ((ep2) ((uf1) this.c).b).isEmpty());
    }

    public void x(Object obj) throws Exception {
        m10 m10Var = (m10) this.b;
        LinkedHashMap linkedHashMap = m10Var.b;
        ArrayList arrayList = m10Var.d;
        String str = (String) this.c;
        Object obj2 = linkedHashMap.get(str);
        su0 su0Var = (su0) this.e;
        if (obj2 == null) {
            throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + su0Var + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
        }
        int iIntValue = ((Number) obj2).intValue();
        arrayList.add(str);
        try {
            m10Var.b(iIntValue, su0Var, obj);
        } catch (Exception e) {
            arrayList.remove(str);
            throw e;
        }
    }

    public Object y(CharSequence charSequence, int i2, int i3, int i4, boolean z, wh0 wh0Var) {
        int i5;
        char c;
        zh0 zh0Var = new zh0((ij1) ((p6) this.c).c);
        int iCodePointAt = Character.codePointAt(charSequence, i2);
        int i6 = 0;
        boolean zF = true;
        int iCharCount = i2;
        loop0: while (true) {
            i5 = iCharCount;
            while (true) {
                if (iCharCount < i3 && i6 < i4 && zF) {
                    SparseArray sparseArray = zh0Var.c.a;
                    ij1 ij1Var = sparseArray == null ? null : (ij1) sparseArray.get(iCodePointAt);
                    if (zh0Var.a == 2) {
                        if (ij1Var != null) {
                            zh0Var.c = ij1Var;
                            zh0Var.f++;
                        } else {
                            if (iCodePointAt == 65038) {
                                zh0Var.a();
                            } else if (iCodePointAt != 65039) {
                                ij1 ij1Var2 = zh0Var.c;
                                if (ij1Var2.b != null) {
                                    if (zh0Var.f != 1) {
                                        zh0Var.d = ij1Var2;
                                        zh0Var.a();
                                    } else if (zh0Var.b()) {
                                        zh0Var.d = zh0Var.c;
                                        zh0Var.a();
                                    } else {
                                        zh0Var.a();
                                    }
                                    c = 3;
                                } else {
                                    zh0Var.a();
                                }
                            }
                            c = 1;
                        }
                        c = 2;
                    } else if (ij1Var == null) {
                        zh0Var.a();
                        c = 1;
                    } else {
                        zh0Var.a = 2;
                        zh0Var.c = ij1Var;
                        zh0Var.f = 1;
                        c = 2;
                    }
                    zh0Var.e = iCodePointAt;
                    if (c == 1) {
                        iCharCount = Character.charCount(Character.codePointAt(charSequence, i5)) + i5;
                        if (iCharCount >= i3) {
                            break;
                        }
                        iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                        break;
                    }
                    if (c == 2) {
                        int iCharCount2 = Character.charCount(iCodePointAt) + iCharCount;
                        if (iCharCount2 < i3) {
                            iCodePointAt = Character.codePointAt(charSequence, iCharCount2);
                        }
                        iCharCount = iCharCount2;
                    } else if (c == 3) {
                        if (!z && v(charSequence, i5, iCharCount, zh0Var.d.b)) {
                            break;
                        }
                        zF = wh0Var.f(charSequence, i5, iCharCount, zh0Var.d.b);
                        i6++;
                        break;
                    }
                } else {
                    break loop0;
                }
            }
        }
        if (zh0Var.a == 2 && zh0Var.c.b != null && ((zh0Var.f > 1 || zh0Var.b()) && i6 < i4 && zF && (z || !v(charSequence, i5, iCharCount, zh0Var.c.b)))) {
            wh0Var.f(charSequence, i5, iCharCount, zh0Var.c.b);
        }
        return wh0Var.e();
    }

    public void z() {
        ((AudioTrack) this.b).release();
        if (((mt0) this.c).s == ((AudioTrack) this.b)) {
            ((mt0) this.c).s = null;
        }
        mt0.f((mt0) this.c, "nativeAudioTracksReleased");
    }

    public /* synthetic */ kf(Object obj, Object obj2, Object obj3, int i2, boolean z) {
        this.a = i2;
        this.e = obj;
        this.b = obj2;
        this.c = obj3;
    }

    public kf(int i2) {
        this.a = i2;
        switch (i2) {
            case 3:
                this.e = new el1(19);
                break;
            case 7:
                break;
            case 10:
                this.b = new uf1(16);
                this.c = new uf1(16);
                this.e = new uf1(16);
                break;
            case 21:
                long[] jArr = ya2.a;
                this.b = new gm1();
                break;
            case 26:
                this.b = new AtomicReference(a54.a);
                this.c = new Object();
                break;
            default:
                this.b = new HashMap();
                this.c = new HashMap();
                this.e = j;
                break;
        }
    }

    public kf(b42 b42Var) {
        this.a = 19;
        this.b = new hh(0);
        this.c = new cj(2);
        this.e = new zb(10, this, b42Var);
    }

    public kf(zm2 zm2Var) {
        this.a = 17;
        this.b = zm2Var;
    }

    public kf(View view) {
        this.a = 15;
        this.b = view;
        this.c = yp4.a(new ta(7, this));
        this.e = new wj1(view);
    }

    public kf(ew ewVar) {
        this.a = 5;
        this.e = ewVar;
        this.b = new q82(this);
    }

    public /* synthetic */ kf(Object obj, Object obj2, Object obj3, int i2) {
        this.a = i2;
        this.b = obj;
        this.c = obj2;
        this.e = obj3;
    }

    public kf(Context context) {
        this.a = 0;
        this.e = context.getApplicationContext();
        this.c = new HashSet();
        this.b = new HashMap();
    }

    public kf(ut utVar, Size size) {
        Rational rational;
        this.a = 27;
        this.b = utVar;
        utVar.a();
        utVar.b();
        if (size != null) {
            rational = new Rational(size.getWidth(), size.getHeight());
        } else {
            List listJ = utVar.j(256);
            if (listJ.isEmpty()) {
                rational = null;
            } else {
                Size size2 = (Size) Collections.max(listJ, new v00(false));
                rational = new Rational(size2.getWidth(), size2.getHeight());
            }
        }
        this.c = rational;
        this.e = new ht2(utVar, rational);
    }

    public kf(wt wtVar, fb0 fb0Var) {
        this.a = 28;
        this.c = wtVar;
        this.b = fb0Var;
    }

    public kf(p6 p6Var, su0 su0Var, ma0 ma0Var, Set set) {
        this.a = 11;
        this.b = su0Var;
        this.c = p6Var;
        this.e = ma0Var;
        if (set.isEmpty()) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            int[] iArr = (int[]) it.next();
            String str = new String(iArr, 0, iArr.length);
            y(str, 0, str.length(), 1, true, new yh0(str));
        }
    }

    public kf(l11 l11Var) {
        this.a = 4;
        this.e = l11Var;
        this.c = new AtomicBoolean(false);
        this.b = ((yq) l11Var.c).e.schedule(new uq(this, 0), 2000L, TimeUnit.MILLISECONDS);
    }

    public kf(ContentResolver contentResolver, ContentValues contentValues) {
        this.a = 14;
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        this.b = contentResolver;
        this.c = contentValues;
        this.e = new qs4(13);
    }
}
