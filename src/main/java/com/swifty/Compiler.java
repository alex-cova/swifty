package com.swifty;

import com.swifty.bytecodegeneration.BytecodeGenerator;
import com.swifty.domain.CompilationUnit;
import com.swifty.parsing.Parser;
import com.swifty.util.FakeLogger;
import com.swifty.validation.ArgumentErrors;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.file.Paths;

public class Compiler {

    public static void main(String[] args) throws Exception {

        System.out.println("""
                \n
                ███████╗██╗    ██╗██╗███████╗████████╗██╗   ██╗
                ██╔════╝██║    ██║██║██╔════╝╚══██╔══╝╚██╗ ██╔╝
                ███████╗██║ █╗ ██║██║█████╗     ██║    ╚████╔╝\s
                ╚════██║██║███╗██║██║██╔══╝     ██║     ╚██╔╝ \s
                ███████║╚███╔███╔╝██║██║        ██║      ██║  \s
                ╚══════╝ ╚══╝╚══╝ ╚═╝╚═╝        ╚═╝      ╚═╝  \s
                \n                                            \s
                """);

        try {
            new Compiler().compile(args);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void compile(String[] args) throws Exception {
        ArgumentErrors argumentsErrors = getArgumentValidationErrors(args);
        if (argumentsErrors != ArgumentErrors.NONE) {
            String errorMessage = argumentsErrors.getMessage();
            FakeLogger.error(errorMessage);
            return;
        }
        File swiftFile = new File(args[0]);

        if (!swiftFile.exists()) {
            throw new FileNotFoundException("the file must exist");
        }

        String fileAbsolutePath = swiftFile.getAbsolutePath();
        FakeLogger.info("Trying to parse file:", swiftFile.getAbsolutePath());
        CompilationUnit compilationUnit = new Parser().getCompilationUnit(fileAbsolutePath);
        FakeLogger.info("Finished Parsing. Started compiling to byte code generation.");
        saveBytecodeToClassFile(compilationUnit);
    }

    private ArgumentErrors getArgumentValidationErrors(String[] args) {
        if (args.length != 1) {
            return ArgumentErrors.NO_FILE;
        }
        String filePath = args[0];
        if (!filePath.endsWith(".swift")) {
            return ArgumentErrors.BAD_FILE_EXTENSION;
        }
        return ArgumentErrors.NONE;
    }

    private void saveBytecodeToClassFile(CompilationUnit compilationUnit) throws IOException {
        BytecodeGenerator bytecodeGenerator = new BytecodeGenerator();
        byte[] bytecode = bytecodeGenerator.generate(compilationUnit);
        String className = compilationUnit.getClassName();
        String fileName = className + ".class";
        FakeLogger.info("Finished Compiling. Saving bytecodegeneration to ", Paths.get(fileName).toAbsolutePath());
        OutputStream os = new FileOutputStream(fileName);
        IOUtils.write(bytecode, os);
        FakeLogger.info("Done. To run compiled file execute: 'java " + className + "' in current dir");
    }
}
