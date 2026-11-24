package com.ibm.icu.impl.coll;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class CollationCompare {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* JADX WARN: Code duplicated, block: B:107:0x0185  */
    /* JADX WARN: Code duplicated, block: B:109:0x018e A[LOOP:9: B:109:0x018e->B:118:0x01b2, LOOP_START, PHI: r8
      0x018e: PHI (r8v22 int) = (r8v15 int), (r8v24 int) binds: [B:108:0x018c, B:118:0x01b2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:119:0x01b4 A[LOOP:11: B:119:0x01b4->B:139:0x01e5, LOOP_START, PHI: r8
      0x01b4: PHI (r8v16 int) = (r8v15 int), (r8v18 int) binds: [B:108:0x018c, B:139:0x01e5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:128:0x01d3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:129:0x01d5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:130:0x01d6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:131:0x01d7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:132:0x01d9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:133:0x01da A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:134:0x01db  */
    /* JADX WARN: Code duplicated, block: B:137:0x01e0 A[LOOP:8: B:108:0x018c->B:137:0x01e0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:138:0x01e3 A[LOOP:12: B:122:0x01c1->B:138:0x01e3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:139:0x01e5 A[LOOP:11: B:119:0x01b4->B:139:0x01e5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:142:0x01ef A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:143:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:151:0x021b  */
    /* JADX WARN: Code duplicated, block: B:152:0x021d  */
    /* JADX WARN: Code duplicated, block: B:154:0x0221  */
    /* JADX WARN: Code duplicated, block: B:155:0x0223  */
    /* JADX WARN: Code duplicated, block: B:157:0x0227  */
    /* JADX WARN: Code duplicated, block: B:159:0x022b  */
    /* JADX WARN: Code duplicated, block: B:160:0x022d  */
    /* JADX WARN: Code duplicated, block: B:162:0x0231 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:163:0x0232 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:165:0x0235 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:168:0x023e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:169:0x023f  */
    /* JADX WARN: Code duplicated, block: B:176:0x025f  */
    /* JADX WARN: Code duplicated, block: B:177:0x0262  */
    /* JADX WARN: Code duplicated, block: B:180:0x0268 A[LOOP:16: B:180:0x0268->B:201:0x02a1, LOOP_START, PHI: r4
      0x0268: PHI (r4v9 int) = (r4v7 int), (r4v15 int) binds: [B:179:0x0266, B:201:0x02a1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:182:0x0274  */
    /* JADX WARN: Code duplicated, block: B:183:0x0277  */
    /* JADX WARN: Code duplicated, block: B:190:0x0287  */
    /* JADX WARN: Code duplicated, block: B:193:0x0293 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:194:0x0294 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:196:0x0297  */
    /* JADX WARN: Code duplicated, block: B:199:0x029e  */
    /* JADX WARN: Code duplicated, block: B:201:0x02a1 A[LOOP:16: B:180:0x0268->B:201:0x02a1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:202:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:203:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:204:0x02af A[LOOP:14: B:146:0x0204->B:204:0x02af, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:231:0x01e7 A[EDGE_INSN: B:231:0x01e7->B:140:0x01e7 BREAK  A[LOOP:8: B:108:0x018c->B:137:0x01e0], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:232:0x01cf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:239:0x01bf A[EDGE_INSN: B:239:0x01bf->B:121:0x01bf BREAK  A[LOOP:11: B:119:0x01b4->B:139:0x01e5], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:240:0x01ae A[EDGE_INSN: B:240:0x01ae->B:116:0x01ae BREAK  A[LOOP:12: B:122:0x01c1->B:138:0x01e3], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:241:0x02b7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:242:0x0215 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:243:0x0237 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:244:0x0204 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:248:0x0213 A[EDGE_INSN: B:248:0x0213->B:148:0x0213 BREAK  A[LOOP:14: B:146:0x0204->B:204:0x02af], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:249:0x029d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:250:0x0281 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:253:0x027d A[EDGE_INSN: B:253:0x027d->B:186:0x027d BREAK  A[LOOP:16: B:180:0x0268->B:201:0x02a1], SYNTHETIC] */
    public static int compareUpToQuaternary(CollationIterator collationIterator, CollationIterator collationIterator2, CollationSettings collationSettings) {
        long jReorder;
        long j;
        char c;
        int i;
        int i2;
        int tertiaryMask;
        int i3;
        int i4;
        int i5;
        int ce;
        int i6;
        int i7;
        int i8;
        int i9;
        int ce2;
        int i10;
        int i11;
        int i12;
        long ce3;
        long j2;
        long jReorder2;
        int i13;
        long ce4;
        long j3;
        long jReorder3;
        int strength;
        int i14;
        int i15;
        int i16;
        int ce5;
        int i17;
        int i18;
        int ce6;
        int i19;
        long ce7;
        long ce8;
        long ce9;
        int i20;
        int ce10;
        int i21 = collationSettings.options;
        long j4 = 1;
        long j5 = 0;
        long j6 = (i21 & 12) == 0 ? 0L : collationSettings.variableTop + 1;
        boolean z = false;
        while (true) {
            long jNextCE = collationIterator.nextCE();
            char c2 = ' ';
            long j7 = jNextCE >>> 32;
            int i22 = 1;
            if (j7 < j6 && j7 > Collation.MERGE_SEPARATOR_PRIMARY) {
                do {
                    collationIterator.setCurrentCE(jNextCE & (-4294967296L));
                    while (true) {
                        jNextCE = collationIterator.nextCE();
                        j7 = jNextCE >>> 32;
                        if (j7 != 0) {
                            break;
                        }
                        collationIterator.setCurrentCE(0L);
                    }
                    if (j7 >= j6) {
                        break;
                    }
                } while (j7 > Collation.MERGE_SEPARATOR_PRIMARY);
                z = true;
            }
            long jReorder4 = j7;
            if (jReorder4 != 0) {
                while (true) {
                    long jNextCE2 = collationIterator2.nextCE();
                    long j8 = jNextCE2 >>> 32;
                    if (j8 < j6 && j8 > Collation.MERGE_SEPARATOR_PRIMARY) {
                        do {
                            collationIterator2.setCurrentCE(jNextCE2 & (-4294967296L));
                            while (true) {
                                jNextCE2 = collationIterator2.nextCE();
                                j8 = jNextCE2 >>> 32;
                                if (j8 != 0) {
                                    break;
                                }
                                collationIterator2.setCurrentCE(0L);
                            }
                            if (j8 >= j6) {
                                break;
                            }
                        } while (j8 > Collation.MERGE_SEPARATOR_PRIMARY);
                        z = true;
                    }
                    jReorder = j8;
                    if (jReorder != 0) {
                        break;
                    }
                    j4 = j4;
                }
                if (jReorder4 != jReorder) {
                    if (collationSettings.hasReordering()) {
                        jReorder4 = collationSettings.reorder(jReorder4);
                        jReorder = collationSettings.reorder(jReorder);
                    }
                    return jReorder4 < jReorder ? -1 : 1;
                }
                if (jReorder4 == j4) {
                    if (CollationSettings.getStrength(i21) >= 1) {
                        if ((i21 & 2048) == 0) {
                            int i23 = 0;
                            int i24 = 0;
                            while (true) {
                                i23++;
                                int ce11 = ((int) collationIterator.getCE(i23)) >>> 16;
                                if (ce11 != 0) {
                                    while (true) {
                                        i20 = i24 + 1;
                                        j = j5;
                                        ce10 = ((int) collationIterator2.getCE(i24)) >>> 16;
                                        if (ce10 != 0) {
                                            break;
                                        }
                                        i24 = i20;
                                        j5 = j;
                                    }
                                    if (ce11 != ce10) {
                                        return ce11 < ce10 ? -1 : 1;
                                    }
                                    if (ce11 == 256) {
                                        break;
                                    }
                                    i24 = i20;
                                    j5 = j;
                                }
                            }
                        } else {
                            j = 0;
                            int i25 = 0;
                            int i26 = 0;
                            while (true) {
                                int i27 = i25;
                                while (true) {
                                    long ce12 = collationIterator.getCE(i27) >>> c2;
                                    if (ce12 <= Collation.MERGE_SEPARATOR_PRIMARY && ce12 != 0) {
                                        break;
                                    }
                                    i27++;
                                    c2 = c2;
                                    i25 = i25;
                                    i22 = i22;
                                }
                                int i28 = i26;
                                while (true) {
                                    ce9 = collationIterator2.getCE(i28) >>> c2;
                                    if (ce9 <= Collation.MERGE_SEPARATOR_PRIMARY && ce9 != 0) {
                                        break;
                                    }
                                    i28++;
                                    c2 = c2;
                                    i25 = i25;
                                    i22 = i22;
                                }
                                int i29 = i27;
                                int i30 = i28;
                                while (true) {
                                    c = c2;
                                    int ce13 = 0;
                                    while (ce13 == 0 && i29 > i25) {
                                        i29--;
                                        ce13 = ((int) collationIterator.getCE(i29)) >>> 16;
                                        i25 = i25;
                                        i22 = i22;
                                    }
                                    i22 = i22;
                                    int i31 = i25;
                                    int ce14 = 0;
                                    while (ce14 == 0 && i30 > i26) {
                                        i30--;
                                        ce14 = ((int) collationIterator2.getCE(i30)) >>> 16;
                                    }
                                    if (ce13 != ce14) {
                                        if (ce13 < ce14) {
                                            return -1;
                                        }
                                        return i22;
                                    }
                                    if (ce13 == 0) {
                                        break;
                                    }
                                    c2 = c;
                                    i25 = i31;
                                    i22 = i22;
                                }
                                if (ce9 == j4) {
                                    break;
                                }
                                i25 = i27 + 1;
                                i26 = i28 + 1;
                                c2 = c;
                                i22 = i22;
                            }
                        }
                        i = i21 & 1024;
                        i2 = Collation.CASE_MASK;
                        if (i != 0) {
                            strength = CollationSettings.getStrength(i21);
                            i14 = 0;
                            i15 = 0;
                            while (true) {
                                if (strength == 0) {
                                    while (true) {
                                        i16 = i14 + 1;
                                        ce7 = collationIterator.getCE(i14);
                                        ce5 = (int) ce7;
                                        if ((ce7 >>> c) == j && ce5 != 0) {
                                            break;
                                        }
                                        i14 = i16;
                                    }
                                    i17 = ce5 & Collation.CASE_MASK;
                                    while (true) {
                                        i18 = i15 + 1;
                                        ce8 = collationIterator2.getCE(i15);
                                        ce6 = (int) ce8;
                                        if ((ce8 >>> c) == j && ce6 != 0) {
                                            break;
                                        }
                                        i15 = i18;
                                    }
                                } else {
                                    while (true) {
                                        i16 = i14 + 1;
                                        ce5 = (int) collationIterator.getCE(i14);
                                        if ((ce5 & (-65536)) != 0) {
                                            break;
                                        }
                                        i14 = i16;
                                    }
                                    i17 = ce5 & Collation.CASE_MASK;
                                    while (true) {
                                        i18 = i15 + 1;
                                        ce6 = (int) collationIterator2.getCE(i15);
                                        if ((ce6 & (-65536)) != 0) {
                                            break;
                                        }
                                        i15 = i18;
                                    }
                                }
                                i19 = ce6 & Collation.CASE_MASK;
                                if (i17 != i19) {
                                    if ((i21 & 256) == 0) {
                                        if (i17 < i19) {
                                            return -1;
                                        }
                                        return i22;
                                    }
                                    if (i17 < i19) {
                                        return i22;
                                    }
                                    return -1;
                                }
                                if ((ce5 >>> 16) == 256) {
                                    break;
                                }
                                i14 = i16;
                                i15 = i18;
                            }
                        }
                        if (CollationSettings.getStrength(i21) <= i22) {
                            return 0;
                        }
                        tertiaryMask = CollationSettings.getTertiaryMask(i21);
                        i3 = 0;
                        i4 = 0;
                        i5 = 0;
                        while (true) {
                            i3++;
                            ce = (int) collationIterator.getCE(i3);
                            i4 |= ce;
                            i6 = ce & tertiaryMask;
                            if (i6 != 0) {
                                while (true) {
                                    i7 = i5 + 1;
                                    i8 = i2;
                                    i9 = ce;
                                    ce2 = (int) collationIterator2.getCE(i5);
                                    i4 |= ce2;
                                    i10 = ce2 & tertiaryMask;
                                    if (i10 != 0) {
                                        break;
                                    }
                                    i5 = i7;
                                    i2 = i8;
                                    ce = i9;
                                }
                                if (i6 != i10) {
                                    if (CollationSettings.sortsTertiaryUpperCaseFirst(i21)) {
                                        if (i6 > 256) {
                                            if ((i9 & (-65536)) != 0) {
                                                i6 ^= i8;
                                            } else {
                                                i6 += 16384;
                                            }
                                        }
                                        if (i10 > 256) {
                                            if ((ce2 & (-65536)) != 0) {
                                                i10 ^= i8;
                                            } else {
                                                i10 += 16384;
                                            }
                                        }
                                    }
                                    if (i6 < i10) {
                                        return -1;
                                    }
                                    return 1;
                                }
                                if (i6 == 256) {
                                    i5 = i7;
                                    i2 = i8;
                                } else {
                                    if (CollationSettings.getStrength(i21) <= 2) {
                                        return 0;
                                    }
                                    if (z && (i4 & 192) == 0) {
                                        return 0;
                                    }
                                    i11 = 0;
                                    i12 = 0;
                                    while (true) {
                                        int i32 = i11 + 1;
                                        ce3 = collationIterator.getCE(i11);
                                        j2 = ce3 & 65535;
                                        if (j2 <= 256) {
                                            jReorder2 = ce3 >>> c;
                                        } else {
                                            jReorder2 = j2 | 4294967103L;
                                        }
                                        if (jReorder2 != j) {
                                            while (true) {
                                                i13 = i12 + 1;
                                                ce4 = collationIterator2.getCE(i12);
                                                j3 = ce4 & 65535;
                                                if (j3 <= 256) {
                                                    jReorder3 = ce4 >>> c;
                                                } else {
                                                    jReorder3 = j3 | 4294967103L;
                                                }
                                                if (jReorder3 != j) {
                                                    break;
                                                }
                                                i12 = i13;
                                            }
                                            if (jReorder2 != jReorder3) {
                                                if (collationSettings.hasReordering()) {
                                                    jReorder2 = collationSettings.reorder(jReorder2);
                                                    jReorder3 = collationSettings.reorder(jReorder3);
                                                }
                                                if (jReorder2 < jReorder3) {
                                                    return -1;
                                                }
                                                return 1;
                                            }
                                            if (jReorder2 == j4) {
                                                return 0;
                                            }
                                            i12 = i13;
                                        }
                                        i11 = i32;
                                    }
                                }
                            }
                        }
                    } else {
                        j = 0;
                    }
                    c = ' ';
                    i = i21 & 1024;
                    i2 = Collation.CASE_MASK;
                    if (i != 0) {
                        strength = CollationSettings.getStrength(i21);
                        i14 = 0;
                        i15 = 0;
                        while (true) {
                            if (strength == 0) {
                                while (true) {
                                    i16 = i14 + 1;
                                    ce7 = collationIterator.getCE(i14);
                                    ce5 = (int) ce7;
                                    if ((ce7 >>> c) == j) {
                                    }
                                    i14 = i16;
                                }
                                i17 = ce5 & Collation.CASE_MASK;
                                while (true) {
                                    i18 = i15 + 1;
                                    ce8 = collationIterator2.getCE(i15);
                                    ce6 = (int) ce8;
                                    if ((ce8 >>> c) == j) {
                                    }
                                    i15 = i18;
                                }
                            } else {
                                while (true) {
                                    i16 = i14 + 1;
                                    ce5 = (int) collationIterator.getCE(i14);
                                    if ((ce5 & (-65536)) != 0) {
                                        break;
                                        break;
                                    }
                                    i14 = i16;
                                }
                                i17 = ce5 & Collation.CASE_MASK;
                                while (true) {
                                    i18 = i15 + 1;
                                    ce6 = (int) collationIterator2.getCE(i15);
                                    if ((ce6 & (-65536)) != 0) {
                                        break;
                                        break;
                                    }
                                    i15 = i18;
                                }
                            }
                            i19 = ce6 & Collation.CASE_MASK;
                            if (i17 != i19) {
                                if ((i21 & 256) == 0) {
                                    if (i17 < i19) {
                                        return -1;
                                    }
                                    return i22;
                                }
                                if (i17 < i19) {
                                    return i22;
                                }
                                return -1;
                            }
                            if ((ce5 >>> 16) == 256) {
                                break;
                                break;
                            }
                            i14 = i16;
                            i15 = i18;
                        }
                    }
                    if (CollationSettings.getStrength(i21) <= i22) {
                        return 0;
                    }
                    tertiaryMask = CollationSettings.getTertiaryMask(i21);
                    i3 = 0;
                    i4 = 0;
                    i5 = 0;
                    while (true) {
                        i3++;
                        ce = (int) collationIterator.getCE(i3);
                        i4 |= ce;
                        i6 = ce & tertiaryMask;
                        if (i6 != 0) {
                            while (true) {
                                i7 = i5 + 1;
                                i8 = i2;
                                i9 = ce;
                                ce2 = (int) collationIterator2.getCE(i5);
                                i4 |= ce2;
                                i10 = ce2 & tertiaryMask;
                                if (i10 != 0) {
                                    break;
                                    break;
                                }
                                i5 = i7;
                                i2 = i8;
                                ce = i9;
                            }
                            if (i6 != i10) {
                                if (CollationSettings.sortsTertiaryUpperCaseFirst(i21)) {
                                    if (i6 > 256) {
                                        if ((i9 & (-65536)) != 0) {
                                            i6 ^= i8;
                                        } else {
                                            i6 += 16384;
                                        }
                                    }
                                    if (i10 > 256) {
                                        if ((ce2 & (-65536)) != 0) {
                                            i10 ^= i8;
                                        } else {
                                            i10 += 16384;
                                        }
                                    }
                                }
                                if (i6 < i10) {
                                    return -1;
                                }
                                return 1;
                            }
                            if (i6 == 256) {
                                i5 = i7;
                                i2 = i8;
                            } else {
                                if (CollationSettings.getStrength(i21) <= 2) {
                                    return 0;
                                }
                                if (z) {
                                }
                                i11 = 0;
                                i12 = 0;
                                while (true) {
                                    int i33 = i11 + 1;
                                    ce3 = collationIterator.getCE(i11);
                                    j2 = ce3 & 65535;
                                    if (j2 <= 256) {
                                        jReorder2 = ce3 >>> c;
                                    } else {
                                        jReorder2 = j2 | 4294967103L;
                                    }
                                    if (jReorder2 != j) {
                                        while (true) {
                                            i13 = i12 + 1;
                                            ce4 = collationIterator2.getCE(i12);
                                            j3 = ce4 & 65535;
                                            if (j3 <= 256) {
                                                jReorder3 = ce4 >>> c;
                                            } else {
                                                jReorder3 = j3 | 4294967103L;
                                            }
                                            if (jReorder3 != j) {
                                                break;
                                                break;
                                            }
                                            i12 = i13;
                                        }
                                        if (jReorder2 != jReorder3) {
                                            if (collationSettings.hasReordering()) {
                                                jReorder2 = collationSettings.reorder(jReorder2);
                                                jReorder3 = collationSettings.reorder(jReorder3);
                                            }
                                            if (jReorder2 < jReorder3) {
                                                return -1;
                                            }
                                            return 1;
                                        }
                                        if (jReorder2 == j4) {
                                            return 0;
                                        }
                                        i12 = i13;
                                    }
                                    i11 = i33;
                                }
                            }
                        }
                    }
                } else {
                    j4 = j4;
                }
            }
        }
    }
}
