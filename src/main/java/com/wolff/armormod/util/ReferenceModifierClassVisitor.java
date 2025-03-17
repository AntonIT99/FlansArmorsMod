package com.wolff.armormod.util;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Handle;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Map;

public class ReferenceModifierClassVisitor extends ClassVisitor
{
    private final Map<String, String> methodNameMapping;
    private final Map<String, String> fieldNameMapping;
    private final String classToReplace;
    private final String classToUseInstead;

    public ReferenceModifierClassVisitor(ClassVisitor cv, String classToReplace, String classToUseInstead, Map<String, String> methodNameMapping, Map<String, String> fieldNameMapping)
    {
        super(Opcodes.ASM9, cv);
        this.classToReplace = classToReplace;
        this.classToUseInstead = classToUseInstead;
        this.methodNameMapping = methodNameMapping;
        this.fieldNameMapping = fieldNameMapping;
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces)
    {
        // Replace superclass references
        if (classToReplace.equals(superName))
        {
            superName = classToUseInstead;
        }

        // Replace interface references
        for (int i = 0; i < interfaces.length; i++)
        {
            if (classToReplace.equals(interfaces[i]))
            {
                interfaces[i] = classToUseInstead;
            }
        }

        super.visit(version, access, name, signature, superName, interfaces);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions)
    {
        MethodVisitor mv = cv.visitMethod(access, methodNameMapping.getOrDefault(name, name), descriptor, signature, exceptions);
        return mv == null ? null : new ReferenceModifierMethodVisitor(mv, classToReplace, classToUseInstead, methodNameMapping, fieldNameMapping);
    }

    @Override
    public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value)
    {
        return super.visitField(access, fieldNameMapping.getOrDefault(name, name), descriptor, signature, value);
    }

    public static class ReferenceModifierMethodVisitor extends MethodVisitor
    {
        private final Map<String, String> methodNameMapping;
        private final Map<String, String> fieldNameMapping;
        private final String classToReplace;
        private final String classToUseInstead;

        public ReferenceModifierMethodVisitor(MethodVisitor mv, String classToReplace, String classToUseInstead, Map<String, String> methodNameMapping, Map<String, String> fieldNameMapping)
        {
            super(Opcodes.ASM9, mv);
            this.classToReplace = classToReplace;
            this.classToUseInstead = classToUseInstead;
            this.methodNameMapping = methodNameMapping;
            this.fieldNameMapping = fieldNameMapping;
        }

        @Override
        public void visitTypeInsn(int opcode, String type)
        {
            if (opcode == Opcodes.CHECKCAST && classToReplace.equals(type))
            {
                super.visitTypeInsn(opcode, classToUseInstead);
            }
            else
            {
                super.visitTypeInsn(opcode, type);
            }
        }

        @Override
        public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface)
        {
            if (classToReplace.equals(owner))
            {
                owner = classToUseInstead;
            }
            String modifiedDescriptor = modifyDescriptor(descriptor);
            super.visitMethodInsn(opcode, owner, methodNameMapping.getOrDefault(name, name), modifiedDescriptor, isInterface);
        }

        @Override
        public void visitFieldInsn(int opcode, String owner, String name, String descriptor)
        {
            if (classToReplace.equals(owner))
            {
                owner = classToUseInstead;
            }
            String modifiedDescriptor = modifyDescriptor(descriptor);
            super.visitFieldInsn(opcode, owner, fieldNameMapping.getOrDefault(name, name), modifiedDescriptor);
        }

        @Override
        public void visitInvokeDynamicInsn(String name, String descriptor, Handle bootstrapMethodHandle, Object... bootstrapMethodArguments)
        {
            String modifiedDescriptor = modifyDescriptor(descriptor);
            super.visitInvokeDynamicInsn(name, modifiedDescriptor, bootstrapMethodHandle, bootstrapMethodArguments);
        }

        private String modifyDescriptor(String descriptor)
        {
            return descriptor.replace(classToReplace, classToUseInstead);
        }
    }
}
