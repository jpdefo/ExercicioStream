package mappers;

import model.OscarData;

import java.util.function.Function;

public class DadosOscarMapper implements Function<String, OscarData> {


    public OscarData apply(String o){
        var dados = o.split("; ");
        var index = Integer.parseInt(dados[0]);
        var year = Integer.parseInt(dados[1]);
        var age = Integer.parseInt(dados[2]);
        var name = dados[3];
        var movie = dados[4];
        int award = 1;

        return new OscarData(index, year, age, name, movie, award);
    }
}
