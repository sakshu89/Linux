package defpackage;

import android.app.AlarmManager;
import android.content.Context;
import java.util.Arrays;
import java.util.Calendar;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class s5 {
    public final n21 a;
    public final AlarmManager b;
    public volatile q5 c;

    public s5(Context context, n21 n21Var) {
        n21Var.getClass();
        this.a = n21Var;
        this.b = (AlarmManager) context.getSystemService(AlarmManager.class);
    }

    public static String a(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(calendar.get(11)), Integer.valueOf(calendar.get(12))}, 2));
    }

    public static long c(int i, int i2) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i);
        calendar.set(12, i2);
        calendar.set(13, 0);
        calendar.set(14, 0);
        if (calendar.getTimeInMillis() <= System.currentTimeMillis()) {
            calendar.add(6, 1);
        }
        return calendar.getTimeInMillis();
    }

    public final Long b() {
        AlarmManager.AlarmClockInfo nextAlarmClock;
        try {
            AlarmManager alarmManager = this.b;
            if (alarmManager != null && (nextAlarmClock = alarmManager.getNextAlarmClock()) != null) {
                return Long.valueOf(nextAlarmClock.getTriggerTime());
            }
        } catch (IllegalStateException | SecurityException unused) {
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0045  */
    /* JADX WARN: Code duplicated, block: B:19:0x0055 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x005d  */
    /* JADX WARN: Code duplicated, block: B:24:0x006c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0053 -> B:20:0x0056). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object d(java.lang.Long r12, long r13, defpackage.y50 r15) {
        /*
            r11 = this;
            boolean r0 = r15 instanceof defpackage.r5
            if (r0 == 0) goto L13
            r0 = r15
            r5 r0 = (defpackage.r5) r0
            int r1 = r0.n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.n = r1
            goto L18
        L13:
            r5 r0 = new r5
            r0.<init>(r11, r15)
        L18:
            java.lang.Object r15 = r0.j
            int r1 = r0.n
            r2 = 150(0x96, double:7.4E-322)
            r4 = 1
            if (r1 == 0) goto L36
            if (r1 != r4) goto L2f
            long r12 = r0.i
            long r5 = r0.f
            java.lang.Long r14 = r0.e
            defpackage.bz3.g(r15)
            r15 = r0
            r0 = r5
            goto L56
        L2f:
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.og.n(r11)
            r11 = 0
            return r11
        L36:
            defpackage.bz3.g(r15)
            r5 = 0
            r15 = r0
            r0 = r13
            r14 = r12
            r12 = r5
        L3f:
            r5 = 1500(0x5dc, double:7.41E-321)
            int r5 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r5 >= 0) goto L7e
            r15.e = r14
            r15.f = r0
            r15.i = r12
            r15.n = r4
            java.lang.Object r5 = defpackage.bm4.b(r2, r15)
            t70 r6 = defpackage.t70.a
            if (r5 != r6) goto L56
            return r6
        L56:
            long r12 = r12 + r2
            java.lang.Long r5 = r11.b()
            if (r5 == 0) goto L3f
            long r5 = r5.longValue()
            r7 = 60000(0xea60, double:2.9644E-319)
            long r9 = r5 / r7
            long r7 = r0 / r7
            int r7 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r7 != 0) goto L3f
            v5 r11 = new v5
            java.lang.String r12 = a(r5)
            java.lang.String r13 = "AlarmManager.nextAlarmClock is now "
            java.lang.String r14 = ", matching the requested time"
            java.lang.String r12 = defpackage.cq.v(r13, r12, r14)
            r11.<init>(r5, r12)
            return r11
        L7e:
            java.lang.Long r11 = r11.b()
            y5 r12 = new y5
            if (r11 != 0) goto L89
            java.lang.String r11 = "the clock app has not published a matching next-alarm record"
            goto Lb5
        L89:
            boolean r13 = r11.equals(r14)
            if (r13 == 0) goto La8
            long r13 = r11.longValue()
            int r13 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r13 >= 0) goto La8
            long r13 = r11.longValue()
            java.lang.String r11 = a(r13)
            java.lang.String r13 = "you already have an earlier alarm at "
            java.lang.String r14 = ", so the system's next-alarm record didn't change and I can't confirm this one"
        La3:
            java.lang.String r11 = defpackage.cq.v(r13, r11, r14)
            goto Lb5
        La8:
            long r13 = r11.longValue()
            java.lang.String r11 = a(r13)
            java.lang.String r13 = "the system's next alarm is "
            java.lang.String r14 = ", which isn't the time I asked for"
            goto La3
        Lb5:
            r12.<init>(r11)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.s5.d(java.lang.Long, long, y50):java.lang.Object");
    }
}
