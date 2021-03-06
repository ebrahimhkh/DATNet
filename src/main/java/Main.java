import com.google.gson.Gson;
import profiler.CapacityProfiler;
import stateTransition.Environment;
import utils.Globals;

import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void init() {

    }


    public static void main(String[] args) throws IOException {
        System.out.print("\n");
        System.out.print("  _________________________");
        System.out.print("\n");
        System.out.print("    In the name of ALLAH");
        System.out.print("\n");
        System.out.print("IOT Trust Evaluation Simulator");
        System.out.print("\n");
        System.out.print("  _________________________");
        System.out.print("\n");
        System.out.print("\n");

        String capFileName = "D:\\01-Project\\34-selfDrivingCars\\02-V2VNetwork\\src\\main\\java\\SimData\\Sim0.json";
        String envFileName = "D:\\01-Project\\34-selfDrivingCars\\02-V2VNetwork\\src\\main\\java\\SimData\\environment.json";
        Gson gson = new Gson();

        FileReader prfReader = new FileReader(capFileName);
        Globals.profiler = gson.fromJson(prfReader, CapacityProfiler.class);
        Globals.profiler.init();

        System.out.println("popCount:"+Globals.profiler.populationCount);
        System.out.println("bunch:"+Globals.profiler.bunchCount());
        System.out.println("sim Round:"+Globals.profiler.simulationRound);

        FileReader envReader = new FileReader(envFileName);
        Globals.environment = gson.fromJson(envReader, Environment.class);

        System.out.println("stateCount:"+Globals.environment.getStateCount());
        System.out.println("actionCount:"+Globals.environment.getActionCount());
        System.out.println("transitionCount:"+Globals.environment.getTransitionCount());

        Simulator simulator = new Simulator();
        simulator.simulate();


    }

}
