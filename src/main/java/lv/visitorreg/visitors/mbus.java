package lv.visitorreg.visitors;

import de.re.easymodbus.modbusclient.ModbusClient;
import org.springframework.stereotype.Component;

import java.util.Timer;
import java.util.TimerTask;

@Component
public class mbus {


public void start (){


    ModbusClient modbusClient = new ModbusClient("192.168.40.30", 502);
		try
    {
        modbusClient.setUnitIdentifier((byte) 1);

        modbusClient.Connect();

        System.out.println(modbusClient.ReadHoldingRegisters(5001, 1)[0]);

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                start();
            }
        };

        timer.schedule(timerTask, 100);
    }
		catch (Exception e)
    {
    }
}
}





