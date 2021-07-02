package selenium.test.framework.utils.data;

import selenium.test.framework.utils.configuration.DefaultConfiguration;
import selenium.test.framework.utils.date.DateTimeHelper;
import selenium.test.framework.utils.files.PathHelper;
import selenium.test.framework.utils.generators.BaseGenerator;
import selenium.test.framework.utils.models.ReleaseDataModel;

import java.util.List;

public class ReleaseDataProvider {

    public static ReleaseDataModel generateDataModel() {
        ReleaseDataModel releaseDataModel = new ReleaseDataModel();

        releaseDataModel.setName("rls_" + BaseGenerator.getTimestamp());
        releaseDataModel.setStarDate(DateTimeHelper.getDateInFormat(BaseGenerator.getRandomDate(), DefaultConfiguration.DATE_FORMAT));
        releaseDataModel.setEndDate(DateTimeHelper.getDateInFormat(BaseGenerator.getRandomDate(), DefaultConfiguration.DATE_FORMAT));
        releaseDataModel.setDescription(BaseGenerator.getRandomString(BaseGenerator.getRandomNumber(0, 160)));
        releaseDataModel.setActive(BaseGenerator.getRandomBoolean());

        return releaseDataModel;
    }

    public static Object[][] generateDataList(int dataListSize) {
        Object[][] data = new Object[dataListSize][];

        for (int i = 0; i < dataListSize; i++) {
            String[] dataRecord = new String[5];
            dataRecord[0] = "rls_" + BaseGenerator.getTimestamp();
            dataRecord[1] = DateTimeHelper.getDateInFormat(BaseGenerator.getRandomDate(), DefaultConfiguration.DATE_FORMAT);
            dataRecord[2] = DateTimeHelper.getDateInFormat(BaseGenerator.getRandomDate(), DefaultConfiguration.DATE_FORMAT);
            dataRecord[3] = BaseGenerator.getRandomString(BaseGenerator.getRandomNumber(0, 160));
            dataRecord[4] = String.valueOf(BaseGenerator.getRandomBoolean());

            data[i] = dataRecord;
        }
        return data;
    }

    public static Object[][] readDataList(String fileName) {

        List<String[]> readData = new CSVDataReader().readCSVData(DefaultConfiguration.DATA_PATH + fileName);

        Object[][] data = new Object[readData.size()][];

        int i = 0;
        for (String[] dataSet : readData) {
            data[i] = dataSet;
            i++;
        }
        return data;
    }


}
