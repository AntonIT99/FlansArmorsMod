package com.wolffsarmormod.util;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Handle;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import javax.annotation.Nullable;
import java.util.Map;

public class ReferenceModifierClassVisitor extends ClassVisitor
{
    private final Map<String, String> methodNameMapping;
    private final Map<String, String> fieldNameMapping;
    private final String classToReplace;
    private final String classToUseInstead;
    private final String newClassName;
    private String originalClassName;

    public ReferenceModifierClassVisitor(ClassVisitor cv, @Nullable String newClassName, String classToReplace, String classToUseInstead, Map<String, String> methodNameMapping, Map<String, String> fieldNameMapping)
    {
        super(Opcodes.ASM9, cv);
        this.newClassName = newClassName;
        this.classToReplace = classToReplace;
        this.classToUseInstead = classToUseInstead;
        this.methodNameMapping = methodNameMapping;
        this.fieldNameMapping = fieldNameMapping;
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces)
    {
        originalClassName = name;

        //Rename class
        if (newClassName != null)
        {
            name = newClassName;
        }

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
        return mv == null ? null : new ReferenceModifierMethodVisitor(mv, originalClassName, newClassName, classToReplace, classToUseInstead, methodNameMapping, fieldNameMapping);
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
        private final String newClassName;
        private final String originalClassName;

        public ReferenceModifierMethodVisitor(MethodVisitor mv, String originalClassName, @Nullable String newClassName, String classToReplace, String classToUseInstead, Map<String, String> methodNameMapping, Map<String, String> fieldNameMapping)
        {
            super(Opcodes.ASM9, mv);
            this.originalClassName = originalClassName;
            this.newClassName = newClassName;
            this.classToReplace = classToReplace;
            this.classToUseInstead = classToUseInstead;
            this.methodNameMapping = methodNameMapping;
            this.fieldNameMapping = fieldNameMapping;
        }

        @Override
        public void visitTypeInsn(int opcode, String type)
        {
            if (type.equals(originalClassName) && newClassName != null)
            {
                super.visitTypeInsn(opcode, newClassName);
            }
            else if (type.equals(classToReplace) && opcode == Opcodes.CHECKCAST)
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
            if (owner.equals(originalClassName) && newClassName != null)
            {
                owner = newClassName;
            }
            if (owner.equals(classToReplace))
            {
                owner = classToUseInstead;
            }
            String modifiedDescriptor = modifyDescriptor(descriptor);
            super.visitMethodInsn(opcode, owner, methodNameMapping.getOrDefault(name, name), modifiedDescriptor, isInterface);
        }

        @Override
        public void visitFieldInsn(int opcode, String owner, String name, String descriptor)
        {
            if (owner.equals(originalClassName) && newClassName != null)
            {
                owner = newClassName;
            }
            if (owner.equals(classToReplace))
            {
                owner = classToUseInstead;
            }
            String modifiedDescriptor = modifyDescriptor(descriptor);
            super.visitFieldInsn(opcode, owner, fieldNameMapping.getOrDefault(name, name), modifiedDescriptor);
        }

        @Override
        public void visitLdcInsn(Object value) {
            if (value instanceof Type && ((Type) value).getInternalName().equals(originalClassName) && newClassName != null)
            {
                super.visitLdcInsn(Type.getObjectType(newClassName));
            }
            else
            {
                super.visitLdcInsn(value);
            }
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
