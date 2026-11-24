package defpackage;

import com.ibm.icu.util.IslamicCalendar;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class x31 implements IntConsumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ x31(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // java.util.function.IntConsumer
    public final void accept(int i) {
        int i2 = this.a;
        Object obj = this.b;
        switch (i2) {
            case 0:
                ((IslamicCalendar) obj).lambda$handleComputeFields$0(i);
                break;
            case 1:
                ((IslamicCalendar) obj).lambda$handleComputeFields$1(i);
                break;
            case 2:
                ((IslamicCalendar) obj).lambda$handleComputeFields$2(i);
                break;
            case 3:
                ((IslamicCalendar) obj).lambda$handleComputeFields$3(i);
                break;
            default:
                StringBuilder sb = (StringBuilder) obj;
                if (Character.isLetterOrDigit(i) || Character.isWhitespace(i) || ue.f.contains(Integer.valueOf(Character.getType(i)))) {
                    sb.appendCodePoint(i);
                }
                break;
        }
    }
}
