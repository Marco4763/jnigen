package com.github.dart_lang.jnigen.apisummarizer;

import java.io.File;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

public class JSONComparisonTest {
  static final File exampleClassJsonOutput =
      new File("src/test/resources/exampleClassSummary.json");

  @SuppressWarnings("SameParameterValue")
  private int gitDiff(File a, File b) throws IOException, InterruptedException {
    return gitDiff(a.getPath(), b.getPath());
  }

  private int gitDiff(String a, String b) throws IOException, InterruptedException {
    String colorSupport = "--color=never";
    if (System.console() != null && System.getenv().get("TERM") != null) {
      colorSupport = "--color=always";
    }
    String[] compareCommand = {
      "git", "diff", colorSupport, "--no-index", a, b,
    };
    var compare = Runtime.getRuntime().exec(compareCommand);
    compare.getErrorStream().transferTo(System.err);
    compare.getInputStream().transferTo(System.out);
    return compare.waitFor();
  }

  @Test
  public void testExampleSummary() throws IOException, InterruptedException {
    var tempFile = File.createTempFile("summarizer_test", ".json");
    Main.main(
        new String[] {
          "-s", "src/test/resources", "com.example.Example", "-o", tempFile.getPath(),
        });
    int comparison = gitDiff(exampleClassJsonOutput, tempFile);
    Assert.assertEquals(0, comparison);
  }
}
