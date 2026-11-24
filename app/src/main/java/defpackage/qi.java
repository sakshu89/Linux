package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qi extends we1 {
    public final long a;
    public final Integer b;
    public final long c;
    public final byte[] d;
    public final String e;
    public final long f;
    public final mn1 g;

    public qi(long j, Integer num, long j2, byte[] bArr, String str, long j3, mn1 mn1Var) {
        this.a = j;
        this.b = num;
        this.c = j2;
        this.d = bArr;
        this.e = str;
        this.f = j3;
        this.g = mn1Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof we1) {
            we1 we1Var = (we1) obj;
            qi qiVar = (qi) we1Var;
            if (this.a == qiVar.a) {
                Integer num = qiVar.b;
                Integer num2 = this.b;
                if (num2 != null ? num2.equals(num) : num == null) {
                    if (this.c == qiVar.c) {
                        if (Arrays.equals(this.d, we1Var instanceof qi ? ((qi) we1Var).d : qiVar.d)) {
                            String str = qiVar.e;
                            String str2 = this.e;
                            if (str2 != null ? str2.equals(str) : str == null) {
                                if (this.f == qiVar.f) {
                                    mn1 mn1Var = qiVar.g;
                                    mn1 mn1Var2 = this.g;
                                    if (mn1Var2 != null ? mn1Var2.equals(mn1Var) : mn1Var == null) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.a;
        int i = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.b;
        int iHashCode = (i ^ (num == null ? 0 : num.hashCode())) * 1000003;
        long j2 = this.c;
        int iHashCode2 = (((iHashCode ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.d)) * 1000003;
        String str = this.e;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j3 = this.f;
        int i2 = (iHashCode3 ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003;
        mn1 mn1Var = this.g;
        return i2 ^ (mn1Var != null ? mn1Var.hashCode() : 0);
    }

    public final String toString() {
        return "LogEvent{eventTimeMs=" + this.a + ", eventCode=" + this.b + ", eventUptimeMs=" + this.c + ", sourceExtension=" + Arrays.toString(this.d) + ", sourceExtensionJsonProto3=" + this.e + ", timezoneOffsetSeconds=" + this.f + ", networkConnectionInfo=" + this.g + "}";
    }
}
