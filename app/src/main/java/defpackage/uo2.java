package defpackage;

import com.project.sonic.background.SonicVoiceService;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class uo2 extends y50 {
    public t42 e;
    public o42 f;
    public z83 i;
    public /* synthetic */ Object j;
    public final /* synthetic */ SonicVoiceService k;
    public int n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uo2(SonicVoiceService sonicVoiceService, y50 y50Var) {
        super(y50Var);
        this.k = sonicVoiceService;
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        this.j = obj;
        this.n |= Integer.MIN_VALUE;
        return SonicVoiceService.a(this.k, this);
    }
}
