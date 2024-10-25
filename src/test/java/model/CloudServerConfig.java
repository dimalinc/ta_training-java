package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Getter
    @AllArgsConstructor
    public class CloudServerConfig {
        private final String numberOfInstances;
        private final String machineType;
        private final String gpuModel;
        private final String localSSD;
        private final String dataCenterLocation;
        private final String estimatedCost;

    private static final String NUMBER_OF_INSTANCES = "data.form.NUMBER_OF_INSTANCES";
    private static final String MACHINE_TYPE = "data.form.MACHINE_TYPE";
    private static final String GPU_TYPE = "data.form.GPU_TYPE";
    private static final String LOCAL_SSD = "data.form.LOCAL_SSD";
    private static final String DATA_CENTER_LOCATION = "data.form.DATA_CENTER_LOCATION";
    private static final String ESTIMATED_COST = "data.form.ESTIMATED_COST";
    private static final Logger log = LogManager.getLogger(CloudServerConfigInit.class);



    }
