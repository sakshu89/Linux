package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class o31 extends IOException {
    public boolean a;

    public static o31 a() {
        return new o31("Protocol message had invalid UTF-8.");
    }

    public static n31 b() {
        return new n31("Protocol message tag had invalid wire type.");
    }

    public static o31 c() {
        return new o31("CodedInputStream encountered a malformed varint.");
    }

    public static o31 d() {
        return new o31("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static o31 e() {
        return new o31("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
