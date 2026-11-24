package com.ibm.icu.util;

import com.ibm.icu.lang.UCharacter;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class CaseInsensitiveString {
    private String string;
    private int hash = 0;
    private String folded = null;

    public CaseInsensitiveString(String str) {
        this.string = str;
    }

    private static String foldCase(String str) {
        return UCharacter.foldCase(str, true);
    }

    private void getFolded() {
        if (this.folded == null) {
            this.folded = foldCase(this.string);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CaseInsensitiveString)) {
            return false;
        }
        getFolded();
        CaseInsensitiveString caseInsensitiveString = (CaseInsensitiveString) obj;
        caseInsensitiveString.getFolded();
        return this.folded.equals(caseInsensitiveString.folded);
    }

    public String getString() {
        return this.string;
    }

    public int hashCode() {
        getFolded();
        if (this.hash == 0) {
            this.hash = this.folded.hashCode();
        }
        return this.hash;
    }

    public String toString() {
        return this.string;
    }
}
