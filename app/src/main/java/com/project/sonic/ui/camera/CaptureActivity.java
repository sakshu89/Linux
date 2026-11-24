package com.project.sonic.ui.camera;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import defpackage.g31;
import defpackage.hw;
import defpackage.jb;
import defpackage.jq4;
import defpackage.kw0;
import defpackage.n10;
import defpackage.r02;
import defpackage.tt;
import defpackage.uf4;
import defpackage.z3;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class CaptureActivity extends n10 implements GeneratedComponentManagerHolder {
    public volatile z3 c0;
    public final Object d0 = new Object();
    public boolean e0 = false;
    public tt f0;
    public r02 g0;
    public TextView h0;

    public CaptureActivity() {
        e(new kw0(this, 0));
    }

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public final Object generatedComponent() {
        return componentManager().generatedComponent();
    }

    @Override // dagger.hilt.internal.GeneratedComponentManagerHolder
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public final z3 componentManager() {
        if (this.c0 == null) {
            synchronized (this.d0) {
                try {
                    if (this.c0 == null) {
                        this.c0 = new z3(this);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.c0;
    }

    public final void m(Bundle bundle) {
        super.onCreate(bundle);
        componentManager().b();
    }

    @Override // defpackage.n10, android.app.Activity
    public final void onCreate(Bundle bundle) {
        m(bundle);
        this.g0 = new r02(this);
        TextView textView = new TextView(this);
        textView.setTextSize(72.0f);
        textView.setTextColor(-1);
        textView.setGravity(17);
        this.h0 = textView;
        FrameLayout frameLayout = new FrameLayout(this);
        r02 r02Var = this.g0;
        if (r02Var == null) {
            g31.f("preview");
            throw null;
        }
        frameLayout.addView(r02Var, new FrameLayout.LayoutParams(-1, -1));
        TextView textView2 = this.h0;
        if (textView2 == null) {
            g31.f("countdown");
            throw null;
        }
        frameLayout.addView(textView2, new FrameLayout.LayoutParams(-1, -1));
        setContentView(frameLayout);
        uf4.b(jq4.a(this), null, new hw(this, g31.a(getIntent().getStringExtra("camera_facing"), "front"), null), 3);
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        jb jbVar = componentManager().f;
        if (jbVar != null) {
            jbVar.b = null;
        }
    }
}
