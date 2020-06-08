package design.twitter;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Commands {

    public List<String> loadCommands() {

        try (Stream<String> lines = Files.lines(Paths.get(getClass().getClassLoader().getResource("commands.txt").toURI()))) {
            return Arrays.asList(lines.collect(Collectors.joining(",")).split(","));
        } catch (Exception e) {
            System.out.println(e);
        }
        return Collections.emptyList();
    }

    public List<String> loadData() {
        List<String> res = new ArrayList<>();

        try (Stream<String> lines = Files.lines(Paths.get(getClass().getClassLoader().getResource("data.txt").toURI()))) {

            String collect = lines.collect(Collectors.joining(","));

            Pattern pattern = Pattern.compile("\\[(.*?)\\]");
            Matcher matcher = pattern.matcher(collect);

            while (matcher.find()) {
                res.add(matcher.group());
            }
            return res;
        } catch (Exception e) {
            System.out.println(e);
        }
        return Collections.emptyList();
    }

    public List<List<Integer>> loadResult() {
        List<List<Integer>> res = new ArrayList<>();

        try (Stream<String> lines = Files.lines(Paths.get(getClass().getClassLoader().getResource("result.txt").toURI()))) {

            String collect = lines.collect(Collectors.joining(","));

            Pattern pattern = Pattern.compile("\\[(.*?)\\]");
            Matcher matcher = pattern.matcher(collect);

            while (matcher.find()) {
                res.add(getAsList(matcher.group()));
            }
            return res;
        } catch (Exception e) {
            System.out.println(e);
        }
        return Collections.emptyList();
    }

    private List<Integer> getAsList(String group) {
        List<Integer> res = new ArrayList<>();
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(group);
        while (matcher.find()) {
            res.add(Integer.parseInt(matcher.group()));
        }
        return res;
    }
}
