package io.github.zekerzhayard.npe_itemsatchel.core;

import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;

public class ClassTransformer implements IClassTransformer {
    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        if ("cofh.thermalexpansion.item.ItemSatchel".equals(transformedName)) {
            ClassNode cn = new ClassNode();
            new ClassReader(basicClass).accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (RemapUtils.checkMethodName(cn.name, mn.name, mn.desc, "lambda$registerModels$0") && RemapUtils.checkMethodDesc(mn.desc, "(Lnet/minecraft/item/ItemStack;)Lnet/minecraft/client/renderer/block/model/ModelResourceLocation;")) {
                    for (AbstractInsnNode ain : mn.instructions.toArray()) {
                        if (ain.getOpcode() == Opcodes.GETFIELD) {
                            FieldInsnNode fin = (FieldInsnNode) ain;
                            if (RemapUtils.checkClassName(fin.owner, "cofh/thermalexpansion/item/ItemSatchel$TypeEntry") && RemapUtils.checkFieldName(fin.owner, fin.name, fin.desc, "name") && RemapUtils.checkFieldDesc(fin.desc, "Ljava/lang/String;")) {
                                int index = mn.localVariables.size();
                                LabelNode ln0 = new LabelNode(), ln1 = new LabelNode();
                                mn.instructions.insertBefore(ain, new VarInsnNode(Opcodes.ASTORE, index));
                                mn.instructions.insertBefore(ain, new VarInsnNode(Opcodes.ALOAD, index));
                                mn.instructions.insertBefore(ain, new JumpInsnNode(Opcodes.IFNONNULL, ln0));
                                mn.instructions.insertBefore(ain, new LdcInsnNode("null"));
                                mn.instructions.insertBefore(ain, new JumpInsnNode(Opcodes.GOTO, ln1));
                                mn.instructions.insertBefore(ain, ln0);
                                mn.instructions.insertBefore(ain, new VarInsnNode(Opcodes.ALOAD, index));
                                mn.instructions.insert(ain, ln1);
                            }
                        }
                    }
                }
            }
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
            cn.accept(cw);
            basicClass = cw.toByteArray();
        }
        return basicClass;
    }
}
