import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class ProtoTest {
    public static void main(String[] args) throws Throwable {
        if (args.length != 2) {
            System.out.println("Usage: prototest proto test_file");
            System.exit(-1);
        }
        TestCase tc = new TestCase(args[1]);
        String result = runProcess(args[0], tc.input);
        int status = compare(tc, result);
        System.exit(status);
    }

    static class TestCase {
        int number;
        String name;
        String input;
        String output;

        TestCase(String testFile) throws IOException {
            boolean firstLine = true;
            boolean readingOutput = false;
            final Pattern firstLinePattern = Pattern.compile("# (\\d\\d)\\. (.*)");
            StringJoiner inputJoiner = new StringJoiner("\r\n");
            StringJoiner outputJoiner = new StringJoiner("\r\n");
            try (Stream<String> lines = Files.lines(Paths.get(testFile))) {
                for (String line : (Iterable<String>) lines::iterator) {
                    if (firstLine) {
                        Matcher m = firstLinePattern.matcher(line);
                        if (m.find()) {
                            number = Integer.parseInt(m.group(1));
                            name = m.group(2);
                        }
                    } else {
                        StringJoiner target = readingOutput ? outputJoiner : inputJoiner;
                        if (line.equals("# Output:")) readingOutput = true;
                        else if (!line.equals("# Input:")) {
                            target.add(line);
                        }
                    }
                    firstLine = false;
                }
            }
            input = inputJoiner.toString();
            output = outputJoiner.toString();
        }
    }

    private static String runProcess(String path, String input) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder(path);
        Process p = null;
        String result = null;
        try {
            p = pb.start();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            bw.write(input);
            bw.close();
            StringJoiner sj = new StringJoiner("\r\n");
            br.lines().iterator().forEachRemaining(sj::add);
            result = sj.toString();
            br.close();
            p.waitFor();
        } finally {
            if (p != null && p.isAlive()) p.destroy();
        }
        return result;
    }

    private static int compare(TestCase tc, String result) {
        if (tc.output.equals(result)) return 0;
        String[] a = tc.output.split("\r\n");
        String[] b = result.split("\r\n");
        int i = 0;
        for (; i < Math.min(a.length, b.length); i++)
            if (!a[i].equals(b[i])) break;
        if (tc.name != null) System.out.printf("%02d. %s%n", tc.number, tc.name);
        System.out.printf("Output mismatch in line %d%n\texpected:\t%s%n\tgot:\t\t%s%n",
                i, i < a.length ? a[i] : "#EOF", i < b.length ? b[i] : "#EOF");
        return 1;
    }
}
