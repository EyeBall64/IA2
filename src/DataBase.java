public class DataBase {

    private int totalColWidth;
    private String filename;
    private int rowWidth;
    private int recordCount;

    public DataBase(String filename, int rowWidth, int totalColWidth) {
        this.filename = filename;
        this.rowWidth = rowWidth;
        this.totalColWidth = totalColWidth;
        recordCount = getRecordCount();
    }

    public void appendRecord(String data) {
       /*String[] Separator = new String[2];
       Separator = data.split(",");
       if (Separator[0].length() != 10 )
        */

        if (data.length() != rowWidth){
            if (data.length() > rowWidth){
                System.out.println("Tried to write " + data + " to field width of " + rowWidth);

            }
            while (data.length() < rowWidth){
                data = data + " ";
            }

        }
        if (data.length() == 10){
            FileHandler.appendLine(filename, data);
        }

        // TODO: Pad the data to the correct record width
        // TODO: Report an error if the data is too long for the record

    }

    public void deleteRecord(int rowNumber) {
    }

    public String getRecord(int rowNumber,int colNumber) {
        if(rowNumber == 0){
            return FileHandler.readLineAt(filename, rowNumber * rowWidth) + (colNumber*totalColWidth);
        }
        return FileHandler.readLineAt(filename, (rowNumber * rowWidth * totalColWidth) + rowNumber);
    }

    public int getRecordCount() {
        int count = 0;
        String record = getRecord(count);
        while (record != null){
            count++;
            record = getRecord(count);
        }
        return count;
        // return FileHandler.countLines(filename);
    }

    public boolean findRecord(String SearchData) {
        String CurrentData = getRecord(0);
        int counter = 0;
        while(counter < recordCount){
            counter++;
            getRecord(counter);
        }

        // search for a record matching data
        // return true if found
        return false;
    }
}