package hello;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * Generate test cases by freemarker.
 */
public class GenerateTestCases {
    private Configuration config = new Configuration();

    public static void main(String[] args) throws Exception {
        GenerateTestCases generator = new GenerateTestCases();

        generator.generate("UserSystemTest.java");
        generator.generate("AccountSystemTest.java");
        generator.generate("WithExceptionTest.java");
    }

    private void generate(final String fileName) throws Exception {
        config.setClassForTemplateLoading(GenerateTestCases.class,"/");

        try (OutputStreamWriter writer =
                     new OutputStreamWriter(new FileOutputStream(new File("target", fileName)))){
            Template template = config.getTemplate(fileName, "UTF-8");
            template.setEncoding("UTF-8");
            template.process(null, writer);
        }
    }
}


