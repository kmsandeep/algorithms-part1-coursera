package org.kmsandeep.algorithms.week1.assignment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class FileUtility {
    public static void createFile(int N, int queryCount, String columns, String fileName) throws IOException {
        List<String> lines = new ArrayList<>();
        Random random = new Random(10);
        for (int i = 1; i < queryCount; i++) {
            StringBuilder sb = new StringBuilder();
            String[] columns_arr = columns.split(" ");
            for (String col : columns_arr) {
                if ("int".equalsIgnoreCase(col)) {
                    sb.append(random.nextInt(N)).append(" ");
                } else if ("float".equalsIgnoreCase(col)) {
                    sb.append(random.nextFloat() * N).append(" ");
                } else if ("time".equalsIgnoreCase(col)) {
                    sb.append(between(Instant.now(),
                                    Instant.now().plus(Duration.ofDays(10))))
                            .append(" ");
                }
            }
            lines.add(sb.toString());
        }
        List<String> stringList = lines.stream()
                .sorted(Comparator.comparing(str -> Instant.parse(str.split(" ")[2])))
                .collect(Collectors.toList());
        stringList.add(0,String.valueOf(N));

        String path = FileUtility.class.getResource("/").getPath().concat("/week1");
        if(!Path.of(path).toFile().exists()){
            Files.createDirectory(Path.of(path));
        }
        Files.write(Path.of(path.concat(fileName)), stringList);
    }

    public static Instant between(Instant startInclusive, Instant endExclusive) {
        long startMillis = startInclusive.getEpochSecond();
        long endMillis = endExclusive.getEpochSecond();
        long randomMillisSinceEpoch = ThreadLocalRandom.current().nextLong(startMillis,endMillis);
        return Instant.ofEpochSecond(randomMillisSinceEpoch);
    }

    public static List<String> readFile(String fileName) throws IOException {
        String path = FileUtility.class.getResource("/week1"+fileName).getPath();

        List<String> lines = Files.readAllLines(Path.of(path));
        return lines;
    }
}
