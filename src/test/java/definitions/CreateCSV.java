package definitions;

import createDataCSV.DataCSV;
import io.cucumber.java.en.Given;
import writeFile.MoveFileScenario;

import java.io.IOException;

public class CreateCSV {

    @Given("generate data {string}{string}{string}")
    public void generate_data(String case1, String case2, String case3) throws IOException {

        System.out
                .println("========================================================");
        System.out
                .println("====================GENERATE DATA=======================");
        System.out
                .println("========================================================");
        MoveFileScenario moveFileScenario = new MoveFileScenario();
        moveFileScenario.dltDummyExist();

        DataCSV dataCSV = new DataCSV();
        dataCSV.dataDummy(case1, case2, case3);
    }
}

