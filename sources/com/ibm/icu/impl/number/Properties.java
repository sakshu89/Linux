package com.ibm.icu.impl.number;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class Properties implements Serializable {
    private static final long serialVersionUID = 4095518955889349243L;
    private transient DecimalFormatProperties instance;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        if (this.instance == null) {
            this.instance = new DecimalFormatProperties();
        }
        this.instance.readObjectImpl(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        if (this.instance == null) {
            this.instance = new DecimalFormatProperties();
        }
        this.instance.writeObjectImpl(objectOutputStream);
    }

    public DecimalFormatProperties getInstance() {
        return this.instance;
    }
}
