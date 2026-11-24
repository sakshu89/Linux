package defpackage;

import com.project.sonic.background.SonicVoiceService;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wo2 extends y50 {
    public String e;
    public List f;
    public String i;
    public t42 j;
    public boolean k;
    public /* synthetic */ Object n;
    public final /* synthetic */ SonicVoiceService s;
    public int t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wo2(SonicVoiceService sonicVoiceService, y50 y50Var) {
        super(y50Var);
        this.s = sonicVoiceService;
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        this.n = obj;
        this.t |= Integer.MIN_VALUE;
        return SonicVoiceService.b(this.s, null, null, this);
    }
}
