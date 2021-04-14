package Fortigo;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class UniqueGen implements Callable {
    public String generateDigitCode() {
        String code = UUID.randomUUID().toString().replace("-","").substring(0,6).toUpperCase();
        return code;
    }

    @Override
    public Object call() throws Exception {
        Set<String> uidSet = new HashSet<>();
        for(int i = 0; i< 100; i++) {
            while(uidSet.add(generateDigitCode())!=true);
        }
        List<String> list = new ArrayList<>();
        list.addAll(uidSet);
        int item = ThreadLocalRandom.current().nextInt(0,100);
        return list.get(item).toString();
    }
}
