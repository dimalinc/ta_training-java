package model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.ResourceBundleReader;

public class CloudServerConfigInit {

            private static final String INSTANCES_QTY = "cloudServerConfig.INSTANCES_QTY";
            private static final String TYPE_OF_SERVER = "cloudServerConfig.TYPE_OF_SERVER";
            private static final String GPU_OPTION = "cloudServerConfig.GPU_OPTION";
            private static final String SSD_OPTION = "cloudServerConfig.SSD_OPTION";
            private static final String LOCATION_OF_DATA_CENTER = "cloudServerConfig.LOCATION_OF_DATA_CENTER";
            private static final String COST_ESTIMATED = "cloudServerConfig.COST_ESTIMATED";
            private static final Logger log = LogManager.getLogger(CloudServerConfigInit.class);

            public static CloudServerConfig initializeForm() {
            log.info("Initializing test data");
            return new CloudServerConfig(ResourceBundleReader.readFromRecourceBundle(INSTANCES_QTY),
                    ResourceBundleReader.readFromRecourceBundle(TYPE_OF_SERVER),
                    ResourceBundleReader.readFromRecourceBundle(GPU_OPTION),
                    ResourceBundleReader.readFromRecourceBundle(SSD_OPTION),
                    ResourceBundleReader.readFromRecourceBundle(LOCATION_OF_DATA_CENTER),
                    ResourceBundleReader.readFromRecourceBundle(COST_ESTIMATED));
        }
    }
