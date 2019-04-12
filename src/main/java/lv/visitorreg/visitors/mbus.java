package lv.visitorreg.visitors;

import de.re.easymodbus.modbusclient.ModbusClient;
import org.springframework.stereotype.Component;

@Component
public class mbus {


public void start (){


    ModbusClient modbusClient = new ModbusClient("192.168.40.50", 502);
		try
    {
        modbusClient.setUnitIdentifier((byte) 8);

        modbusClient.Connect();

        System.out.println(modbusClient.ReadHoldingRegisters(5001, 1)[0]);

    }
		catch (Exception e)
    {
    }
}
}





