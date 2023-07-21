package io.github.zekerzhayard.npe_itemsatchel.core;

import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.MethodNode;

public class ClassTransformer implements IClassTransformer {
    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        /*if ("net.minecraft.util.WeightedRandom".equals(transformedName)) {
            ClassNode cn = new ClassNode();
            new ClassReader(basicClass).accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (RemapUtils.checkMethodName(cn.name, mn.name, mn.desc, "func_76273_a") && RemapUtils.checkMethodDesc(mn.desc, "(Ljava/util/Random;Ljava/util/List;I)Lnet/minecraft/util/WeightedRandom$Item;")) {
                    for (AbstractInsnNode ain : mn.instructions.toArray()) {
                        if (ain.getOpcode() == Opcodes.ATHROW) {
                            mn.instructions.insertBefore(ain, new InsnNode(Opcodes.POP));
                            mn.instructions.insertBefore(ain, new InsnNode(Opcodes.ACONST_NULL));
                            mn.instructions.set(ain, new InsnNode(Opcodes.ARETURN));
                        }
                    }
                }
            }
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
            cn.accept(cw);
            basicClass = cw.toByteArray();
        }*/
        return basicClass;
    }
}
