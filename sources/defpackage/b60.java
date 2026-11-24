package defpackage;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 b60[], still in use, count: 1, list:
  (r0v1 b60[]) from 0x002c: CONSTRUCTOR (r0v1 b60[]) A[MD:(java.lang.Enum[]):void (m), WRAPPED] (LINE:45) call: gj0.<init>(java.lang.Enum[]):void type: CONSTRUCTOR
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class b60 {
    LIVE("Live"),
    OFFLINE("Offline"),
    ANDROID_CONTINUOUS("Android Continuous");

    public static final fl4 b = new fl4(11);
    public static final /* synthetic */ gj0 j;
    public final String a;

    static {
        j = new gj0(new b60[]{r0, r1, r2});
    }

    public b60(String str) {
        super(str, i);
        this.a = str;
    }

    public static b60 valueOf(String str) {
        return (b60) Enum.valueOf(b60.class, str);
    }

    public static b60[] values() {
        return (b60[]) i.clone();
    }
}
