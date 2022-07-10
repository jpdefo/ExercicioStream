package service;

import model.OscarData;

import java.util.*;
import java.util.stream.Collectors;

public class OscarService {

    private final List<OscarData> TOTALDATA;

    public OscarService(List<OscarData> TOTALDATA) {
        this.TOTALDATA = TOTALDATA;
    }

    public void printOscarOldest(){
        var oldestWinner = TOTALDATA.stream()
                .max(Comparator.comparingInt(OscarData::getAge));
        oldestWinner.ifPresent(p -> System.out.printf("O ator/atriz mais velho é %s com %d anos\n", p.getName(), p.getAge()));
    }

    public void printOscarNewest(){
        var newestWinner = TOTALDATA.stream()
                .min(Comparator.comparingInt(OscarData::getAge));
        newestWinner.ifPresent(p -> System.out.printf("O ator/atriz mais novo é %s com %d anos\n", p.getName(), p.getAge()));
    }

    public void mostWins(){
        var actorMostWins = TOTALDATA.stream()
                .collect(Collectors.filtering(i->i.getAge() >= 18 && i.getAge() <=24,
                        Collectors.groupingBy(OscarData::getName,
                                Collectors.summingInt(OscarData::getAward))))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());
        actorMostWins.ifPresent(c-> System.out.printf("O ator/atriz jovem(18-24 anos) com mais estatuetas é %s com %d vitórias\n",c.getKey(),c.getValue()));
    }

    public void mostWinsTotal(){
        //perguntar como printar multiplos resultados
        var personMostWins = TOTALDATA.stream()
                .collect(Collectors.groupingBy(OscarData::getName,
                                Collectors.summingInt(OscarData::getAward)))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());
        personMostWins.ifPresent(c-> System.out.printf("O ator/atriz com mais estatuetas é %s com %d vitórias\n",c.getKey(),c.getValue()));
    }
}
