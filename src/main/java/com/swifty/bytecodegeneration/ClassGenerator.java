package com.swifty.bytecodegeneration;

import com.swifty.domain.ClassDeclaration;
import com.swifty.domain.Function;
import com.swifty.domain.scope.Field;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.util.Collection;
import java.util.List;

/**
 * Created by Alex
 */
public class ClassGenerator {

    //Java 11 = 55
    private static final int CLASS_VERSION = 55;
    private final ClassWriter classWriter;

    public ClassGenerator() {
        classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
    }

    public ClassWriter generate(ClassDeclaration classDeclaration) {

        classWriter.visit(CLASS_VERSION, Opcodes.ACC_PUBLIC + Opcodes.ACC_SUPER,
                classDeclaration.name(), null, "java/lang/Object", null);

        List<Function> methods = classDeclaration.methods();
        Collection<Field> fields = classDeclaration.fields();

        FieldGenerator fieldGenerator = new FieldGenerator(classWriter);
        fields.forEach(f -> f.accept(fieldGenerator));

        MethodGenerator methodGenerator = new MethodGenerator(classWriter);
        methods.forEach(f -> f.accept(methodGenerator));
        classWriter.visitEnd();

        return classWriter;
    }


}
