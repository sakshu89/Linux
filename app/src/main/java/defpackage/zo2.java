package defpackage;

import com.project.sonic.background.SonicVoiceService;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zo2 extends y50 {
    public /* synthetic */ Object e;
    public final /* synthetic */ SonicVoiceService f;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zo2(SonicVoiceService sonicVoiceService, y50 y50Var) {
        super(y50Var);
        this.f = sonicVoiceService;
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        this.e = obj;
        this.i |= Integer.MIN_VALUE;
        int i = SonicVoiceService.d0;
        return this.f.h(this);
    }
}
