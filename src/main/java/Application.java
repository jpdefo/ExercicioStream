import mappers.DadosOscarMapper;
import model.OscarData;
import service.OscarService;
import util.FileUtil;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) throws IOException {

        var fileUtilFemale = new FileUtil<OscarData>("oscar_age_female.csv");
        var fileUtilMale = new FileUtil<OscarData>("oscar_age_male.csv");

        var maleData = fileUtilMale.readFile(new DadosOscarMapper());
        var femaleData = fileUtilFemale.readFile(new DadosOscarMapper());

        var totalData = Stream.concat(maleData.stream(), femaleData.stream()).collect(Collectors.toList());

        var oscarService = new OscarService(totalData);

        oscarService.printOscarOldest();
        oscarService.printOscarNewest();
        oscarService.mostWins();
        oscarService.mostWinsTotal();
    }
}
