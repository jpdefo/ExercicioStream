package service;

import model.OscarData;

import java.util.*;
import java.util.stream.Collectors;

public class OscarService {

    private List<OscarData> totalData;

    public OscarService(List<OscarData> totalData) {
        this.totalData = totalData;
    }

    public void printOscarOldest(){
        var oldestWinner = totalData.stream()
                .max(Comparator.comparingInt(OscarData::getAge));
        oldestWinner.ifPresent(p -> System.out.printf("O ator/atriz mais velho é %s com %d anos\n", p.getName(), p.getAge()));
    }

    public void printOscarNewest(){
        var newestWinner = totalData.stream()
                .min(Comparator.comparingInt(OscarData::getAge));
        newestWinner.ifPresent(p -> System.out.printf("O ator/atriz mais novo é %s com %d anos\n", p.getName(), p.getAge()));
    }

    public void mostWins(){
        var actorMostWins = totalData.stream()
                .collect(Collectors.filtering(i->i.getAge() >= 18 && i.getAge() <=24,
                        Collectors.groupingBy(n->n.getName(),
                                Collectors.summingInt(OscarData::getAward))))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());
        actorMostWins.ifPresent(c-> System.out.printf("O ator/atriz jovem(18-24 anos) com mais estatuetas é %s com %d vitórias\n",c.getKey(),c.getValue()));
    }

    public void mostWinsTotal(){
        //perguntar como printar multiplos resultados
        var personMostWins = totalData.stream()
                .collect(Collectors.groupingBy(n->n.getName(),
                                Collectors.summingInt(OscarData::getAward)))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());
        personMostWins.ifPresent(c-> System.out.printf("O ator/atriz com mais estatuetas é %s com %d vitórias\n",c.getKey(),c.getValue()));
    }
}
