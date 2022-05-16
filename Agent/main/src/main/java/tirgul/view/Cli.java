package tirgul.view;

import tirgul.model.Model;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cli implements Icli {
    Model m;

    private String menuBuilder() {

        StringBuilder menu = new StringBuilder();
        try {
            BufferedReader bf = new BufferedReader(new FileReader("cli_menu.txt"));
            String line = "";

            while ((line = bf.readLine()) != null) {
                menu.append(line + "\n");
            }

            bf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return menu.toString();
    }

    private String mainMenu;

    public Cli() {
        this.mainMenu = menuBuilder();
        this.m = new Model("properties.txt");
    }

    public void start() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Integer selection = 0;
        System.out.println("\n" + mainMenu);
        try {
            while (selection != 1) {
                selection = Integer.parseInt(input.readLine());
                switch (selection) {
                    case 1:
                        shoutdown();
                        break;
                    case 2:
                        reset();
                        break;
                    case 3:
                        print_stream();
                        break;
                    case 4:
                        System.out.println("Set Aliron value: ");
                        setAileron(Float.parseFloat(input.readLine()));
                        System.out.println("\n" + mainMenu);
                        break;
                    case 5:
                        System.out.println("Set Rudder value: ");
                        setRudder(Float.parseFloat(input.readLine()));
                        break;
                    case 6:
                        System.out.println("Set Elevator value: ");
                        setElevator(Float.parseFloat(input.readLine()));
                        break;
                    case 7:
                        System.out.println("Set Thruttle value: ");
                        setThruttle(input.readLine());
                        break;
                }
                System.out.println(mainMenu);
            }
            System.out.println("Good By ! ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void shoutdown() {
        System.out.println("Shout Down ... ");
        setAileron(0);
        setRudder(0);
        setElevator(0);
        setThruttle("0");
    }

    @Override
    public void reset() {
        System.out.println("Reseting ...  ");

    }

    @Override
    public void print_stream() {
        System.out.println("Printing Stream ..  ");

    }

    @Override
    public void setAileron(float n) {
        m.setAileron(n);
        System.out.println("Aliron changed to: " + n + " degres\n");
    }

    @Override
    public void setRudder(float n) {
        m.setRudder(n);
        System.out.println("Rudder changed to: " + n + " degres\n");
    }

    @Override
    public void setElevator(float n) {
        m.setElevators(n);
        System.out.println("Elevator changed to: " + n + " degres\n");
    }

    @Override
    public void setThruttle(String n) {
        m.setThruttle(n);
        System.out.println("Thurttle is at : " + n + " Percent \n");

    }

}
