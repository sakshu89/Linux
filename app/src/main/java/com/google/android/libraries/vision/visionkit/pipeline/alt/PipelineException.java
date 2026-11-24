package com.google.android.libraries.vision.visionkit.pipeline.alt;

import defpackage.aq3;
import defpackage.bv3;
import defpackage.cm3;
import defpackage.cq;
import defpackage.dk0;
import defpackage.hn3;
import defpackage.kg3;
import defpackage.np3;
import defpackage.pp3;
import defpackage.rp3;
import defpackage.up3;
import defpackage.ut3;
import defpackage.wp3;
import defpackage.y74;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class PipelineException extends Exception {
    private static final String ROOT_CAUSE_DELIMITER = "#vk ";
    private final cm3 statusCode;
    private final String statusMessage;
    private final hn3 visionkitStatus;

    private PipelineException(hn3 hn3Var) {
        super(cq.k(cm3.values()[hn3Var.o()].a, ": ", hn3Var.q()));
        this.statusCode = cm3.values()[hn3Var.o()];
        this.statusMessage = hn3Var.q();
        this.visionkitStatus = hn3Var;
    }

    public List<kg3> getComponentStatuses() {
        hn3 hn3Var = this.visionkitStatus;
        if (hn3Var != null) {
            return hn3Var.r();
        }
        up3 up3Var = wp3.f;
        return aq3.k;
    }

    public pp3 getRootCauseMessage() {
        Object next;
        Object obj;
        if (!this.statusMessage.contains(ROOT_CAUSE_DELIMITER)) {
            return np3.a;
        }
        String str = this.statusMessage;
        y74 y74Var = new y74(21);
        str.getClass();
        rp3 rp3Var = new rp3(y74Var, str);
        ArrayList arrayList = new ArrayList();
        while (rp3Var.hasNext()) {
            arrayList.add((String) rp3Var.next());
        }
        List listUnmodifiableList = Collections.unmodifiableList(arrayList);
        if (listUnmodifiableList == null) {
            Iterator it = listUnmodifiableList.iterator();
            do {
                next = it.next();
            } while (it.hasNext());
            obj = next;
        } else {
            if (listUnmodifiableList.isEmpty()) {
                dk0.d();
                return null;
            }
            obj = listUnmodifiableList.get(listUnmodifiableList.size() - 1);
        }
        return pp3.d((String) obj);
    }

    public cm3 getStatusCode() {
        return this.statusCode;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public PipelineException(int i, String str) {
        super(cq.k(cm3.values()[i].a, ": ", str));
        this.statusCode = cm3.values()[i];
        this.statusMessage = str;
        this.visionkitStatus = null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PipelineException(byte[] bArr) {
        this(hn3.p(bArr, ut3.c));
        ut3 ut3Var = ut3.b;
        bv3 bv3Var = bv3.c;
    }
}
