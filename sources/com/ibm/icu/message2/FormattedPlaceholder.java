package com.ibm.icu.message2;

import com.ibm.icu.text.FormattedValue;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class FormattedPlaceholder {
    private final Directionality directionality;
    private final FormattedValue formattedValue;
    private final Object inputValue;
    private final boolean isolate;

    @Deprecated
    public FormattedPlaceholder(Object obj, FormattedValue formattedValue, Directionality directionality, boolean z) {
        if (formattedValue == null) {
            throw new IllegalAccessError("Should not try to wrap a null formatted value");
        }
        this.inputValue = obj;
        this.formattedValue = formattedValue;
        this.directionality = directionality;
        this.isolate = z;
    }

    @Deprecated
    public Directionality getDirectionality() {
        return this.directionality;
    }

    @Deprecated
    public FormattedValue getFormattedValue() {
        return this.formattedValue;
    }

    @Deprecated
    public Object getInput() {
        return this.inputValue;
    }

    @Deprecated
    public boolean getIsolate() {
        return this.isolate;
    }

    @Deprecated
    public String toString() {
        return this.formattedValue.toString();
    }

    @Deprecated
    public FormattedPlaceholder(Object obj, FormattedValue formattedValue) {
        this(obj, formattedValue, Directionality.LTR, false);
    }
}
